package com.example.streamingapp.data.models

import com.google.gson.annotations.SerializedName

data class Genres(
    val data : List<GenresInfo>
)

data class GenresInfo(
    @SerializedName("mail_id") val mailid : String,
    val name : String,
)
