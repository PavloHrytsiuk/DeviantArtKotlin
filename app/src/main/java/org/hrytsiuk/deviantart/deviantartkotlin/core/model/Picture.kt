package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Picture(
        @SerializedName("title")
        val title: String,
        @SerializedName("content")
        val content: PictureContent,
        @SerializedName("author")
        val author: PictureAuthor,
        @SerializedName("stats")
        val stats: PictureStats) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(PictureContent::class.java.classLoader),
            parcel.readParcelable(PictureAuthor::class.java.classLoader),
            parcel.readParcelable(PictureStats::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeParcelable(content, flags)
        parcel.writeParcelable(author, flags)
        parcel.writeParcelable(stats, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Picture> {
        override fun createFromParcel(parcel: Parcel): Picture {
            return Picture(parcel)
        }

        override fun newArray(size: Int): Array<Picture?> {
            return arrayOfNulls(size)
        }
    }
}



