package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import com.google.gson.annotations.SerializedName

data class PictureContent(
        @SerializedName("src")
        private val src: String,
        @SerializedName("height")
        private val height: Int,
        @SerializedName("width")
        private val width: Int) {
}