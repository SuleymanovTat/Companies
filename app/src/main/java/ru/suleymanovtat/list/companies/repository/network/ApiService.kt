package ru.suleymanovtat.list.companies.repository.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.suleymanovtat.list.companies.model.network.MKCompany

interface ApiService {

    @GET("test.php")
    fun getCompanies(): Single<List<MKCompany>>

    @GET("test.php")
    fun getCompany(@Query("id") id: String): Single<List<MKCompany>>
}
