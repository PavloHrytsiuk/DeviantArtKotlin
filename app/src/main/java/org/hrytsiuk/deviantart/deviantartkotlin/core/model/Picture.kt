package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import com.google.gson.annotations.SerializedName

data class Picture(
        @SerializedName("title")
        private val title: String,
        @SerializedName("content")
        private val content: PictureContent,
        @SerializedName("author")
        private val author: PictureAuthor,
        @SerializedName("stats")
        private val stats: PictureStats)