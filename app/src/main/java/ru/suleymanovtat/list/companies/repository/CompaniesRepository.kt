package ru.suleymanovtat.list.companies.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.suleymanovtat.list.companies.model.database.mapToLocal
import ru.suleymanovtat.list.companies.model.local.CompanyLocal
import ru.suleymanovtat.list.companies.model.network.MKCompany
import ru.suleymanovtat.list.companies.model.network.mapToDb
import ru.suleymanovtat.list.companies.repository.database.AppDatabase
import ru.suleymanovtat.list.companies.repository.network.IServerCommunicator

class CompaniesRepository(
    private val serverCommunicator: IServerCommunicator,
    private val database: AppDatabase
) : ICompaniesRepository {

    override fun getCompanies(): Observable<List<CompanyLocal>> {
        return database.companyDao().getCompanies().map { it -> it.map { it.mapToLocal() } }
    }

    override fun loading(): Single<List<MKCompany>> {
        return serverCommunicator.getCompanies().toObservable()
            .flatMap { Observable.fromIterable(it) }
            .flatMap { company ->
                serverCommunicator.getCompanyFindById(company.id!!).map { it.first() }
                    .onErrorResumeNext { Single.just(company) }.toObservable()
            }.toList().doOnSuccess {
                saveCompanies(it)
            }
    }

    private fun saveCompanies(it: MutableList<MKCompany>) {
        database.companyDao().saveCompanies(it.map { it.mapToDb() })
    }
}