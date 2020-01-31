package ru.suleymanovtat.list.companies.presentation.companies.adapter

import ru.suleymanovtat.list.companies.model.local.CompanyLocal

interface OnCompanyClickListener {
    fun onCompanyLocal(companyLocal: CompanyLocal)
}