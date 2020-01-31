package ru.suleymanovtat.list.companies.model.local

//status 0 error , 1 success
class WrapperLocal(
    var status: Int = 0,
    var response: List<CompanyLocal>? = null,
    var message: String? = null
)