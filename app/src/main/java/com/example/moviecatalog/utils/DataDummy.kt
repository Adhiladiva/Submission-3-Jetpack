package com.example.moviecatalog.utils

import com.example.moviecatalog.data.MovieEntity
import com.example.moviecatalog.data.source.remote.response.CourseResponse

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
                "m1",
                "A Start Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2018",
                "2h 16m",
                "Drama, Romance, Music",
                "R.drawable.poster_a_start_is_born"
            )
        )

        movie.add(
            MovieEntity(
                "m2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019",
                "2h 2m",
                "Action, Science Fiction, Adventure",
                "R.drawable.poster_alita"
            )
        )

        movie.add(
            MovieEntity(
                "m3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018",
                "2h 23m",
                "Action, Adventure, Fantasy",
                "R.drawable.poster_aquaman"
            )
        )

        movie.add(
            MovieEntity(
                "m4",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018",
                "2h 29m",
                "Adventure, Action, Science Fiction",
                "R.drawable.poster_infinity_war"
            )
        )

        movie.add(
            MovieEntity(
                "m5",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                "2h 15m",
                "Music, Drama, History",
                "R.drawable.poster_bohemian"
            )
        )

        movie.add(
            MovieEntity(
                "m6",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019",
                "2h 9m",
                "Thriller, Drama, Science Fiction",
                "R.drawable.poster_glass"
            )
        )

        movie.add(
            MovieEntity(
                "m7",
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "2010",
                "1h 38m",
                "Fantasy, Adventure, Animation, Family",
                "R.drawable.poster_how_to_train"
            )
        )

        movie.add(
            MovieEntity(
                "m8",
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "2018",
                "2h 4m",
                "Drama, History",
                "R.drawable.poster_marry_queen"
            )
        )

        movie.add(
            MovieEntity(
                "m9",
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "2018",
                "1h 52m",
                "Family, Animation, Comedy, Adventure",
                "R.drawable.poster_ralph"
            )
        )

        movie.add(
            MovieEntity(
                "m10",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "2019",
                "1h 42m",
                "Thriller, Mystery, Drama",
                "R.drawable.poster_serenity"
            )
        )

        return movie
    }

    fun generateDummyTvShow(): List<MovieEntity> {

        val tvShow = ArrayList<MovieEntity>()

        tvShow.add(
            MovieEntity(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                "42m",
                "Crime, Drama, Mystery, Action & Adventure",
                "R.drawable.poster_arrow"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                "49m",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "R.drawable.poster_doom_patrol"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                "25m",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "R.drawable.poster_dragon_ball"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv4",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                "22m",
                "Animation, Comedy",
                "R.drawable.poster_family_guy"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv5",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "44m",
                "Drama, Sci-Fi & Fantasy",
                "R.drawable.poster_flash"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv6",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "2014",
                "43m",
                "Drama, Crime, Sci-Fi & Fantasy",
                "R.drawable.poster_gotham"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv7",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019",
                "50m",
                "Action & Adventure, Drama",
                "R.drawable.poster_hanna"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv8",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "2003",
                "45m",
                "Crime, Action & Adventure, Drama",
                "R.drawable.poster_ncis"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv9",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017",
                "45m",
                "Mystery, Drama, Crime",
                "R.drawable.poster_riverdale"
            )
        )

        tvShow.add(
            MovieEntity(
                "tv10",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                "22m",
                "Family, Animation, Comedy",
                "R.drawable.poster_the_simpson"
            )
        )

        return tvShow
    }

    fun generateRemoteDummyMovie(): List<CourseResponse> {

        val movie = ArrayList<CourseResponse>()

        movie.add(
            CourseResponse(
                "m1",
                "A Start Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2018",
                "2h 16m",
                "Drama, Romance, Music",
                "R.drawable.poster_a_start_is_born"
            )
        )

        movie.add(
            CourseResponse(
                "m2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019",
                "2h 2m",
                "Action, Science Fiction, Adventure",
                "R.drawable.poster_alita"
            )
        )

        movie.add(
            CourseResponse(
                "m3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018",
                "2h 23m",
                "Action, Adventure, Fantasy",
                "R.drawable.poster_aquaman"
            )
        )

        movie.add(
            CourseResponse(
                "m4",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018",
                "2h 29m",
                "Adventure, Action, Science Fiction",
                "R.drawable.poster_infinity_war"
            )
        )

        movie.add(
            CourseResponse(
                "m5",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                "2h 15m",
                "Music, Drama, History",
                "R.drawable.poster_bohemian"
            )
        )

        movie.add(
            CourseResponse(
                "m6",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019",
                "2h 9m",
                "Thriller, Drama, Science Fiction",
                "R.drawable.poster_glass"
            )
        )

        movie.add(
            CourseResponse(
                "m7",
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "2010",
                "1h 38m",
                "Fantasy, Adventure, Animation, Family",
                "R.drawable.poster_how_to_train"
            )
        )

        movie.add(
            CourseResponse(
                "m8",
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "2018",
                "2h 4m",
                "Drama, History",
                "R.drawable.poster_marry_queen"
            )
        )

        movie.add(
            CourseResponse(
                "m9",
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "2018",
                "1h 52m",
                "Family, Animation, Comedy, Adventure",
                "R.drawable.poster_ralph"
            )
        )

        movie.add(
            CourseResponse(
                "m10",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "2019",
                "1h 42m",
                "Thriller, Mystery, Drama",
                "R.drawable.poster_serenity"
            )
        )
        return movie
    }

    fun generateRemoteDummyTvShow(): List<CourseResponse> {

        val tvShow = ArrayList<CourseResponse>()

        tvShow.add(
            CourseResponse(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                "42m",
                "Crime, Drama, Mystery, Action & Adventure",
                "R.drawable.poster_arrow"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                "49m",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "R.drawable.poster_doom_patrol"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                "25m",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "R.drawable.poster_dragon_ball"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv4",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                "22m",
                "Animation, Comedy",
                "R.drawable.poster_family_guy"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv5",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "44m",
                "Drama, Sci-Fi & Fantasy",
                "R.drawable.poster_flash"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv6",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "2014",
                "43m",
                "Drama, Crime, Sci-Fi & Fantasy",
                "R.drawable.poster_gotham"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv7",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019",
                "50m",
                "Action & Adventure, Drama",
                "R.drawable.poster_hanna"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv8",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "2003",
                "45m",
                "Crime, Action & Adventure, Drama",
                "R.drawable.poster_ncis"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv9",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017",
                "45m",
                "Mystery, Drama, Crime",
                "R.drawable.poster_riverdale"
            )
        )

        tvShow.add(
            CourseResponse(
                "tv10",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                "22m",
                "Family, Animation, Comedy",
                "R.drawable.poster_the_simpson"
            )
        )

        return tvShow
    }
}