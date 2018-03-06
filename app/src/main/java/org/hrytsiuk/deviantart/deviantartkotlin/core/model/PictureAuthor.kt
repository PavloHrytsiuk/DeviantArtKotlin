package org.hrytsiuk.deviantart.deviantartkotlin.core.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PictureAuthor(@SerializedName("username")
                         val name: String,
                         @SerializedName("usericon")
                         val usericon: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(usericon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PictureAuthor> {
        override fun createFromParcel(parcel: Parcel): PictureAuthor {
            return PictureAuthor(parcel)
        }

        override fun newArray(size: Int): Array<PictureAuthor?> {
            return arrayOfNulls(size)
        }
    }
}