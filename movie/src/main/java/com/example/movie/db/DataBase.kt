package com.example.movie.db

import com.example.movie.model.Movie

object DataBase {
val movieList:MutableList<Movie> = mutableListOf()
init {
    generateModel()
}
    private fun generateModel() {
        movieList.add(
            Movie(
                1, 90,
                "Thor",
                "1h 59m",
                "Action,Adventure,Fantasy",
                "English,Tamil,Telugu,Hindi",
                "Thor is an English movie starring Chris Hemsworth, Christian Bale and Taika Waititi in prominent roles. It is an action adventure directed by Taika Waititi with Mark Mothersbaugh as musician, forming part of the crew.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/thor-love-and-thunder-et00302403-24-05-2022-12-00-43.jpg"
            )

        )
        movieList.add(
            Movie(
                2, 80,
                "D Block",
                "2h 16m",
                "Action,Thriller",
                "Tamil",
                "D Block is a drama film directed by Vijay Kumar Rajendran, featuring Arulnithi Tamilarasu in a prominent role.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/d-block-et00319623-17-01-2022-03-10-54.jpg"
            )
        )
        movieList.add(
            Movie(
                3, 96,
                "Rocketry",
                "2h 38m",
                "Biography,Drama",
                "Tamil,English,Kannada,Telugu,Malayalam,Hindi",
                "A biographical drama based on the life of former ISRO scientist Nambi Narayanan, who fought years on end for justice after being falsely accused of espionage.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/rocketry-et00094131-1655809015.jpg"
            )
        )
        movieList.add(
            Movie(
                4,
                96,
                "Vikram",
                "2h 53m",
                "Action,Thriller",
                "Tamil",
                "A high-octane action film where a special investigator is assigned a case of serial Killings. As the investigation proceeds, he finds the case is not what it seems to be and leading down this path is only going to end in a war between everyone involved.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/vikram-et00138591-22-07-2021-11-45-18.jpg"
            )


        )
        movieList.add(
            Movie(
                5, 90,
                "Thor",
                "1h 59m",
                "Action,Adventure,Fantasy",
                "English,Tamil,Telugu,Hindi",
                "Thor is an English movie starring Chris Hemsworth, Christian Bale and Taika Waititi in prominent roles. It is an action adventure directed by Taika Waititi with Mark Mothersbaugh as musician, forming part of the crew.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/thor-love-and-thunder-et00302403-24-05-2022-12-00-43.jpg"
            )

        )
        movieList.add(
            Movie(
                6, 80,
                "D Block",
                "2h 16m",
                "Action,Thriller",
                "Tamil",
                "D Block is a drama film directed by Vijay Kumar Rajendran, featuring Arulnithi Tamilarasu in a prominent role.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/d-block-et00319623-17-01-2022-03-10-54.jpg"
            )
        )
        movieList.add(
            Movie(
                7, 96,
                "Rocketry",
                "2h 38m",
                "Biography,Drama",
                "Tamil,English,Kannada,Telugu,Malayalam,Hindi",
                "A biographical drama based on the life of former ISRO scientist Nambi Narayanan, who fought years on end for justice after being falsely accused of espionage.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/rocketry-et00094131-1655809015.jpg"
            )
        )
        movieList.add(
            Movie(
                8,
                96,
                "Vikram",
                "2h 53m",
                "Action,Thriller",
                "Tamil",
                "A high-octane action film where a special investigator is assigned a case of serial Killings. As the investigation proceeds, he finds the case is not what it seems to be and leading down this path is only going to end in a war between everyone involved.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/vikram-et00138591-22-07-2021-11-45-18.jpg"
            )


        )
        movieList.add(
            Movie(
                9, 90,
                "Thor",
                "1h 59m",
                "Action,Adventure,Fantasy",
                "English,Tamil,Telugu,Hindi",
                "Thor is an English movie starring Chris Hemsworth, Christian Bale and Taika Waititi in prominent roles. It is an action adventure directed by Taika Waititi with Mark Mothersbaugh as musician, forming part of the crew.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/thor-love-and-thunder-et00302403-24-05-2022-12-00-43.jpg"
            )

        )
        movieList.add(
            Movie(
                10, 80,
                "D Block",
                "2h 16m",
                "Action,Thriller",
                "Tamil",
                "D Block is a drama film directed by Vijay Kumar Rajendran, featuring Arulnithi Tamilarasu in a prominent role.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/d-block-et00319623-17-01-2022-03-10-54.jpg"
            )
        )
        movieList.add(
            Movie(
                11, 96,
                "Rocketry",
                "2h 38m",
                "Biography,Drama",
                "Tamil,English,Kannada,Telugu,Malayalam,Hindi",
                "A biographical drama based on the life of former ISRO scientist Nambi Narayanan, who fought years on end for justice after being falsely accused of espionage.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/rocketry-et00094131-1655809015.jpg"
            )
        )
        movieList.add(
            Movie(
                12,
                96,
                "Vikram",
                "2h 53m",
                "Action,Thriller",
                "Tamil",
                "A high-octane action film where a special investigator is assigned a case of serial Killings. As the investigation proceeds, he finds the case is not what it seems to be and leading down this path is only going to end in a war between everyone involved.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/vikram-et00138591-22-07-2021-11-45-18.jpg"
            )


        )
        movieList.add(
            Movie(
                13, 90,
                "Thor",
                "1h 59m",
                "Action,Adventure,Fantasy",
                "English,Tamil,Telugu,Hindi",
                "Thor is an English movie starring Chris Hemsworth, Christian Bale and Taika Waititi in prominent roles. It is an action adventure directed by Taika Waititi with Mark Mothersbaugh as musician, forming part of the crew.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/thor-love-and-thunder-et00302403-24-05-2022-12-00-43.jpg"
            )

        )
        movieList.add(
            Movie(
                14, 80,
                "D Block",
                "2h 16m",
                "Action,Thriller",
                "Tamil",
                "D Block is a drama film directed by Vijay Kumar Rajendran, featuring Arulnithi Tamilarasu in a prominent role.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/d-block-et00319623-17-01-2022-03-10-54.jpg"
            )
        )
        movieList.add(
            Movie(
                15, 96,
                "Rocketry",
                "2h 38m",
                "Biography,Drama",
                "Tamil,English,Kannada,Telugu,Malayalam,Hindi",
                "A biographical drama based on the life of former ISRO scientist Nambi Narayanan, who fought years on end for justice after being falsely accused of espionage.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/rocketry-et00094131-1655809015.jpg"
            )
        )
        movieList.add(
            Movie(
                16,
                96,
                "Vikram",
                "2h 53m",
                "Action,Thriller",
                "Tamil",
                "A high-octane action film where a special investigator is assigned a case of serial Killings. As the investigation proceeds, he finds the case is not what it seems to be and leading down this path is only going to end in a war between everyone involved.",
                "https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/vikram-et00138591-22-07-2021-11-45-18.jpg"
            )


        )
    }
}