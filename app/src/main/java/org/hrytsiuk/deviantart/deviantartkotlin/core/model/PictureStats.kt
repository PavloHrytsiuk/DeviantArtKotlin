package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import com.google.gson.annotations.SerializedName

data class PictureStats(@SerializedName("comments")
                        private val comments: Int,
                        @SerializedName("favourites")
                        private val favourites: Int) {
}