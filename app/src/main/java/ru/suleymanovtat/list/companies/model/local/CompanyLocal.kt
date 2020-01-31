package ru.suleymanovtat.list.companies.model.local

import android.os.Parcel
import android.os.Parcelable

class CompanyLocal(
    val id: String? = null,
    val name: String? = null,
    var img: String? = null,
    var description: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    var www: String? = null,
    var phone: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(img)
        parcel.writeString(description)
        parcel.writeValue(lat)
        parcel.writeValue(lon)
        parcel.writeString(www)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CompanyLocal> {
        override fun createFromParcel(parcel: Parcel): CompanyLocal {
            return CompanyLocal(parcel)
        }

        override fun newArray(size: Int): Array<CompanyLocal?> {
            return arrayOfNulls(size)
        }
    }
}