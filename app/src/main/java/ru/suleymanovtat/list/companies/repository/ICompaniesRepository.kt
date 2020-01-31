package ru.suleymanovtat.list.companies.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.suleymanovtat.list.companies.model.local.CompanyLocal
import ru.suleymanovtat.list.companies.model.network.MKCompany

interface ICompaniesRepository {

    fun getCompanies(): Observable<List<CompanyLocal>>
    fun loading(): Single<List<MKCompany>>
}