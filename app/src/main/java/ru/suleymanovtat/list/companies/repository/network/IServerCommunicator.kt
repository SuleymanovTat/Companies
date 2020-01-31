package ru.suleymanovtat.list.companies.repository.network

import io.reactivex.Single
import ru.suleymanovtat.list.companies.model.network.MKCompany

interface IServerCommunicator {

    fun getCompanies(): Single<List<MKCompany>>
    fun getCompanyFindById(id: String): Single<List<MKCompany>>
}