package com.ahfasxp.moviecatalogue.core.data

//class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
//    CatalogueDataSource {
//    override fun getAllMovies(): LiveData<List<MainEntity>> {
//        val movieResults = MutableLiveData<List<MainEntity>>()
//        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
//            override fun onAllMoviesReceived(movieResponses: List<MainResponse>) {
//                val movieList = ArrayList<MainEntity>()
//                for (response in movieResponses) {
//                    val movie = MainEntity(
//                        response.id,
//                        response.title,
//                        response.tagline,
//                        response.overview,
//                        response.poster_path
//                    )
//                    movieList.add(movie)
//                }
//                movieResults.postValue(movieList)
//            }
//        })
//        return movieResults
//    }
//
//    override fun getAllShows(): LiveData<List<MainEntity>> {
//        val showResults = MutableLiveData<List<MainEntity>>()
//        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
//            override fun onAllShowsReceived(showResponses: List<MainResponse>) {
//                val showList = ArrayList<MainEntity>()
//                for (response in showResponses) {
//                    val show = MainEntity(
//                        response.id,
//                        response.title,
//                        response.tagline,
//                        response.overview,
//                        response.poster_path
//                    )
//                    showList.add(show)
//                }
//                showResults.postValue(showList)
//            }
//        })
//        return showResults
//    }
//
//    override fun getDetailMovie(id: String): LiveData<MainEntity> {
//        val movieResult = MutableLiveData<MainEntity>()
//        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
//            override fun onAllMoviesReceived(movieResponses: List<MainResponse>) {
//                lateinit var movie: MainEntity
//                for (response in movieResponses) {
//                    if (response.id == id) {
//                        movie = MainEntity(
//                            response.id,
//                            response.title,
//                            response.tagline,
//                            response.overview,
//                            response.poster_path
//                        )
//                    }
//                }
//                movieResult.postValue(movie)
//            }
//        })
//        return movieResult
//    }
//
//    override fun getDetailShow(id: String): LiveData<MainEntity> {
//        val showResult = MutableLiveData<MainEntity>()
//        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
//            override fun onAllShowsReceived(showResponses: List<MainResponse>) {
//                lateinit var show: MainEntity
//                for (response in showResponses) {
//                    if (response.id == id) {
//                        show = MainEntity(
//                            response.id,
//                            response.title,
//                            response.tagline,
//                            response.overview,
//                            response.poster_path
//                        )
//                    }
//                }
//                showResult.postValue(show)
//            }
//        })
//        return showResult
//    }
//}