package com.ahfasxp.moviecatalogue.core.di

import androidx.room.Room
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.core.data.source.local.room.CatalogueDatabase
import com.ahfasxp.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiService
import com.ahfasxp.moviecatalogue.core.domain.repository.ICatalogueRepository
import com.ahfasxp.moviecatalogue.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val databaseModule = module {
    factory { get<CatalogueDatabase>().catalogueDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("ahfasxp".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            CatalogueDatabase::class.java, "Catalogue.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ICatalogueRepository> {
        CatalogueRepository(
            get(),
            get(),
            get()
        )
    }
}