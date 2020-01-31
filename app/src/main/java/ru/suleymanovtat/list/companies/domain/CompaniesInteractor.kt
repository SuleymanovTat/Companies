package ru.suleymanovtat.list.companies.domain

import ru.suleymanovtat.list.companies.repository.ICompaniesRepository

class CompaniesInteractor(private val repository: ICompaniesRepository): ICompaniesInteractor {

    override fun getCompanies() = repository.getCompanies()
    override fun loading() = repository.loading()
}