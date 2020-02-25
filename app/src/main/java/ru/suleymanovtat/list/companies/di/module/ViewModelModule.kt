package ru.suleymanovtat.list.companies.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.suleymanovtat.list.companies.App
import ru.suleymanovtat.list.companies.di.scope.ViewModelScope
import ru.suleymanovtat.list.companies.domain.CompaniesInteractor
import ru.suleymanovtat.list.companies.presentation.companies.CompaniesViewModel
import ru.suleymanovtat.list.companies.presentation.details.DetailsCompanyViewModel

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesCompaniesViewModel(companiesInteractor: CompaniesInteractor) =
        CompaniesViewModel(app, companiesInteractor)

    @ViewModelScope
    @Provides
    internal fun providesDetailsCompanyViewModel() = DetailsCompanyViewModel(app)
}