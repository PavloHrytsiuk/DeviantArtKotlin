package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import com.google.gson.annotations.SerializedName

data class PictureAuthor(@SerializedName("username")
                         private val name: String,
                         @SerializedName("usericon")
                         private val usericon: String)