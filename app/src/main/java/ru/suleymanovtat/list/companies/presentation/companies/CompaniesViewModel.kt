package ru.suleymanovtat.list.companies.presentation.companies

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.suleymanovtat.list.companies.di.module.BaseViewModel
import ru.suleymanovtat.list.companies.domain.ICompaniesInteractor
import ru.suleymanovtat.list.companies.model.local.WrapperLocal

class CompaniesViewModel(
    application: Application,
    private val companiesInteractor: ICompaniesInteractor
) : BaseViewModel(application) {

    val companies = MutableLiveData<WrapperLocal>()

    init {
        loading()
        disposable.add(
            companiesInteractor.getCompanies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ companiesLocal ->
                    companies.postValue(WrapperLocal(1, response = companiesLocal))
                }, {
                    companies.postValue(WrapperLocal(0, message = onError(it)))
                })
        )
    }

    fun loading() {
        disposable.add(
            companiesInteractor.loading()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }, {
                    companies.postValue(WrapperLocal(0, message = onError(it)))
                })
        )
    }
}
