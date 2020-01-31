package ru.suleymanovtat.list.companies.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.suleymanovtat.list.companies.model.local.CompanyLocal

@Entity(tableName = "Company")
data class CompanyDB(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "img") val img: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "lat") val lat: Double? = null,
    @ColumnInfo(name = "lng") val lon: Double? = null,
    @ColumnInfo(name = "www") val www: String? = null,
    @ColumnInfo(name = "phone") val phone: String? = null
)

fun CompanyDB.mapToLocal(): CompanyLocal {
    return CompanyLocal(id, name, img, description, lat, lon, www, phone)
}