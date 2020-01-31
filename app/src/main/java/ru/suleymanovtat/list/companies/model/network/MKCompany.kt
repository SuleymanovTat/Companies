package ru.suleymanovtat.list.companies.model.network

import ru.suleymanovtat.list.companies.BuildConfig
import ru.suleymanovtat.list.companies.model.database.CompanyDB

data class MKCompany(
    val id: String? = null,
    val name: String? = null,
    var img: String? = null,
    val description: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val www: String? = null,
    val phone: String? = null
)

fun MKCompany.mapToDb(): CompanyDB {
    return CompanyDB(
        id!!,
        name,
        BuildConfig.BASE_URL + img,
        description ?: "",
        lat ?: 0.0,
        lon ?: 0.0,
        if (www == null || www.isEmpty()) "" else "http://$www",
        phone ?: ""
    )
}
