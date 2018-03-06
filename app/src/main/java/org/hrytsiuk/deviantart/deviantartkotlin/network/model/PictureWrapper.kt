package org.hrytsiuk.deviantart.deviantartkotlin.network.model

import com.google.gson.annotations.SerializedName
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture

data class PictureWrapper(
        @SerializedName("results") val results: List<Picture>) {
}