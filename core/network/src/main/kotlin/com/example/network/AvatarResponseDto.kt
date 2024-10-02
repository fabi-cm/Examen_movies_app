package com.example.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class AvatarResponseDto(
    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val url: String,

    @Json(name = "name")
    val name: String?,

    @Json(name = "company")
    val company: String?,

    @Json(name = "bio")
    val bio: String?
)

@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name = "results") val results: List<Movie>
)

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "title") val title: String,
    @Json(name = "poster_path") val posterPath: String
)