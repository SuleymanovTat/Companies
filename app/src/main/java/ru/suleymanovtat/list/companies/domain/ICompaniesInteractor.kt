package ru.suleymanovtat.list.companies.domain

import io.reactivex.Observable
import io.reactivex.Single
import ru.suleymanovtat.list.companies.model.local.CompanyLocal
import ru.suleymanovtat.list.companies.model.network.MKCompany

interface ICompaniesInteractor {

    fun getCompanies(): Observable<List<CompanyLocal>>
    fun loading(): Single<List<MKCompany>>
}