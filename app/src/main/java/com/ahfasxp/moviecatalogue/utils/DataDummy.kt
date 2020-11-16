package com.ahfasxp.moviecatalogue.utils

import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import java.util.ArrayList

object DataDummy {
    fun generateDummyMovie(): ArrayList<MainEntity> {
        val movie = ArrayList<MainEntity>()

        movie.add(
            MainEntity(
                "1",
                "The SpongeBob Movie: Sponge on the Run",
                "They're Not in Bikini Bottom Anymore.",
                "When his best friend Gary is suddenly snatched away, SpongeBob takes Patrick on a madcap mission far beyond Bikini Bottom to save their pink-shelled pal.",
                "https://image.tmdb.org/t/p/w500/jlJ8nDhMhCYJuzOw3f52CP1W8MW.jpg"
            )
        )
        movie.add(
            MainEntity(
                "2",
                "Hard Kill",
                "Take on a madman. Save the world.",
                "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.",
                "https://image.tmdb.org/t/p/w500/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg"
            )
        )
        movie.add(
            MainEntity(
                "3",
                "Rogue City",
                "They're Not in Bikini Bottom Anymore.",
                "Caught in the crosshairs of police corruption and Marseille’s warring gangs, a loyal cop must protect his squad by taking matters into his own hands.",
                "https://image.tmdb.org/t/p/w500/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg"
            )
        )
        movie.add(
            MainEntity(
                "4",
                "Roald Dahl's The Witches",
                "They're real!.",
                "In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered.",
                "https://image.tmdb.org/t/p/w500/betExZlgK0l7CZ9CsCBVcwO1OjL.jpg"
            )
        )
        movie.add(
            MainEntity(
                "5",
                "2067",
                "The fight for the future has begun.",
                "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.",
                "https://image.tmdb.org/t/p/w500/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg"
            )
        )
        movie.add(
            MainEntity(
                "6",
                "Once Upon a Snowman",
                "Every snowman starts somewhere.",
                "The previously untold origins of Olaf, the innocent and insightful, summer-loving snowman are revealed as we follow Olaf’s first steps as he comes to life and searches for his identity in the snowy mountains outside Arendelle.",
                "https://image.tmdb.org/t/p/w500/hddzYJtfYYeMDOQVcH58n8m1W3A.jpg"
            )
        )
        movie.add(
            MainEntity(
                "7",
                "The New Mutants",
                "It's time to face your demons.",
                "Five young mutants, just discovering their abilities while held in a secret facility against their will, fight to escape their past sins and save themselves.",
                "https://image.tmdb.org/t/p/w500/xrI4EnZWftpo1B7tTvlMUXVOikd.jpg"
            )
        )
        movie.add(
            MainEntity(
                "8",
                "Welcome to Sudden Death",
                "They're Not in Bikini Bottom Anymore.",
                "Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller.",
                "https://image.tmdb.org/t/p/w500/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg"
            )
        )
        movie.add(
            MainEntity(
                "9",
                "After We Collided",
                "Can love overcome the past?.",
                "Tessa finds herself struggling with her complicated relationship with Hardin; she faces a dilemma that could change their lives forever.",
                "https://image.tmdb.org/t/p/w500/kiX7UYfOpYrMFSAGbI6j1pFkLzQ.jpg"
            )
        )
        movie.add(
            MainEntity(
                "10",
                "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train",
                "With your blade, bring an end to the nightmare.",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!.",
                "https://image.tmdb.org/t/p/w500/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"
            )
        )

        return movie
    }

    fun generateDummyTvshow(): ArrayList<MainEntity> {
        val tvShow = ArrayList<MainEntity>()

        tvShow.add(
            MainEntity(
                "1",
                "The Good Doctor",
                "His mind is a mystery, his methods are a miracle.",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "https://image.tmdb.org/t/p/w500/bi4tb3GMYFVNUom65SJm7A66rgM.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "2",
                "The Mandalorian",
                "Bounty hunting is a complicated profession.",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "https://image.tmdb.org/t/p/w500/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "3",
                "Fear the Walking Dead",
                "Every decision is life or death.",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in The Walking Dead ? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "https://image.tmdb.org/t/p/w500/wGFUewXPeMErCe2xnCmmLEiHOGh.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "4",
                "Lucifer",
                "It's good to be bad.",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "5",
                "His Dark Materials",
                "One girl will change worlds.",
                "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                "https://image.tmdb.org/t/p/w500/g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "6",
                "Grey's Anatomy",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "7",
                "The Boys",
                "Never meet your heroes.",
                "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
                "https://image.tmdb.org/t/p/w500/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "8",
                "The Queen's Gambit",
                "They're Not in Bikini Bottom Anymore.",
                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                "https://image.tmdb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "9",
                "The Walking Dead: World Beyond",
                "The end of the world was our beginning.",
                "The end of the world was our beginning.",
                "https://image.tmdb.org/t/p/w500/z31GxpVgDsFAF4paZR8PRsiP16D.jpg"
            )
        )
        tvShow.add(
            MainEntity(
                "10",
                "The Umbrella Academy",
                "Super. Dysfunctional. Family.",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "https://image.tmdb.org/t/p/w500/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )

        return tvShow
    }

    fun generateRemoteDummyMovie(): List<MainResponse> {
        val movie = ArrayList<MainResponse>()

        movie.add(
            MainResponse(
                "1",
                "The SpongeBob Movie: Sponge on the Run",
                "They're Not in Bikini Bottom Anymore.",
                "When his best friend Gary is suddenly snatched away, SpongeBob takes Patrick on a madcap mission far beyond Bikini Bottom to save their pink-shelled pal.",
                "https://image.tmdb.org/t/p/w500/jlJ8nDhMhCYJuzOw3f52CP1W8MW.jpg"
            )
        )
        movie.add(
            MainResponse(
                "2",
                "Hard Kill",
                "Take on a madman. Save the world.",
                "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.",
                "https://image.tmdb.org/t/p/w500/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg"
            )
        )
        movie.add(
            MainResponse(
                "3",
                "Rogue City",
                "They're Not in Bikini Bottom Anymore.",
                "Caught in the crosshairs of police corruption and Marseille’s warring gangs, a loyal cop must protect his squad by taking matters into his own hands.",
                "https://image.tmdb.org/t/p/w500/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg"
            )
        )
        movie.add(
            MainResponse(
                "4",
                "Roald Dahl's The Witches",
                "They're real!.",
                "In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered.",
                "https://image.tmdb.org/t/p/w500/betExZlgK0l7CZ9CsCBVcwO1OjL.jpg"
            )
        )
        movie.add(
            MainResponse(
                "5",
                "2067",
                "The fight for the future has begun.",
                "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.",
                "https://image.tmdb.org/t/p/w500/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg"
            )
        )
        movie.add(
            MainResponse(
                "6",
                "Once Upon a Snowman",
                "Every snowman starts somewhere.",
                "The previously untold origins of Olaf, the innocent and insightful, summer-loving snowman are revealed as we follow Olaf’s first steps as he comes to life and searches for his identity in the snowy mountains outside Arendelle.",
                "https://image.tmdb.org/t/p/w500/hddzYJtfYYeMDOQVcH58n8m1W3A.jpg"
            )
        )
        movie.add(
            MainResponse(
                "7",
                "The New Mutants",
                "It's time to face your demons.",
                "Five young mutants, just discovering their abilities while held in a secret facility against their will, fight to escape their past sins and save themselves.",
                "https://image.tmdb.org/t/p/w500/xrI4EnZWftpo1B7tTvlMUXVOikd.jpg"
            )
        )
        movie.add(
            MainResponse(
                "8",
                "Welcome to Sudden Death",
                "They're Not in Bikini Bottom Anymore.",
                "Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller.",
                "https://image.tmdb.org/t/p/w500/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg"
            )
        )
        movie.add(
            MainResponse(
                "9",
                "After We Collided",
                "Can love overcome the past?.",
                "Tessa finds herself struggling with her complicated relationship with Hardin; she faces a dilemma that could change their lives forever.",
                "https://image.tmdb.org/t/p/w500/kiX7UYfOpYrMFSAGbI6j1pFkLzQ.jpg"
            )
        )
        movie.add(
            MainResponse(
                "10",
                "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train",
                "With your blade, bring an end to the nightmare.",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!.",
                "https://image.tmdb.org/t/p/w500/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"
            )
        )

        return movie
    }

    fun generateRemoteDummyTvshow(): List<MainResponse> {
        val tvShow = ArrayList<MainResponse>()

        tvShow.add(
            MainResponse(
                "1",
                "The Good Doctor",
                "His mind is a mystery, his methods are a miracle.",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "https://image.tmdb.org/t/p/w500/bi4tb3GMYFVNUom65SJm7A66rgM.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "2",
                "The Mandalorian",
                "Bounty hunting is a complicated profession.",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "https://image.tmdb.org/t/p/w500/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "3",
                "Fear the Walking Dead",
                "Every decision is life or death.",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in The Walking Dead ? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "https://image.tmdb.org/t/p/w500/wGFUewXPeMErCe2xnCmmLEiHOGh.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "4",
                "Lucifer",
                "It's good to be bad.",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "5",
                "His Dark Materials",
                "One girl will change worlds.",
                "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                "https://image.tmdb.org/t/p/w500/g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "6",
                "Grey's Anatomy",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "7",
                "The Boys",
                "Never meet your heroes.",
                "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
                "https://image.tmdb.org/t/p/w500/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "8",
                "The Queen's Gambit",
                "They're Not in Bikini Bottom Anymore.",
                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                "https://image.tmdb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "9",
                "The Walking Dead: World Beyond",
                "The end of the world was our beginning.",
                "The end of the world was our beginning.",
                "https://image.tmdb.org/t/p/w500/z31GxpVgDsFAF4paZR8PRsiP16D.jpg"
            )
        )
        tvShow.add(
            MainResponse(
                "10",
                "The Umbrella Academy",
                "Super. Dysfunctional. Family.",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "https://image.tmdb.org/t/p/w500/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )

        return tvShow
    }
}