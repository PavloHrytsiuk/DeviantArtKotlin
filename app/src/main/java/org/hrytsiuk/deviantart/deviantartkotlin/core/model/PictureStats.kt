package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PictureStats(@SerializedName("comments")
                        val comments: Int,
                        @SerializedName("favourites")
                        val favourites: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(comments)
        parcel.writeInt(favourites)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PictureStats> {
        override fun createFromParcel(parcel: Parcel): PictureStats {
            return PictureStats(parcel)
        }

        override fun newArray(size: Int): Array<PictureStats?> {
            return arrayOfNulls(size)
        }
    }
}