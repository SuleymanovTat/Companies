package ru.suleymanovtat.list.companies.repository.network

class ServerCommunicator(private val apiService: ApiService) : IServerCommunicator {

    override fun getCompanies() = apiService.getCompanies()
    override fun getCompanyFindById(id: String) = apiService.getCompany(id)
}
