package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PictureContent(
        @SerializedName("src")
        val src: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("width")
        val width: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(src)
        parcel.writeInt(height)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PictureContent> {
        override fun createFromParcel(parcel: Parcel): PictureContent {
            return PictureContent(parcel)
        }

        override fun newArray(size: Int): Array<PictureContent?> {
            return arrayOfNulls(size)
        }
    }
}