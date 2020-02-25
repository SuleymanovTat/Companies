package ru.suleymanovtat.list.companies.presentation.details

import android.app.Application
import androidx.lifecycle.MutableLiveData
import ru.suleymanovtat.list.companies.di.module.BaseViewModel
import ru.suleymanovtat.list.companies.model.local.CompanyLocal

class DetailsCompanyViewModel(
    application: Application
) : BaseViewModel(application) {

    val company: MutableLiveData<CompanyLocal> = MutableLiveData()

    fun setData(companyLocal: CompanyLocal) {
        company.postValue(companyLocal)
    }
}
