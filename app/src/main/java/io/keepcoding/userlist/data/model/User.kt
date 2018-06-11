package io.keepcoding.userlist.data.model

/**
 * Created by costular on 11/06/2018.
 */
data class User(
        val name: Name,
        val picture: Picture
)

data class Name(
        val last: String
)

data class Picture(
        val large: String,
        val medium: String,
        val thumbnail: String
)