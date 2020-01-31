package ru.suleymanovtat.list.companies.di.component

import dagger.Component
import ru.suleymanovtat.list.companies.di.module.ViewModelModule
import ru.suleymanovtat.list.companies.di.scope.ViewModelScope
import ru.suleymanovtat.list.companies.presentation.companies.CompaniesFragment
import ru.suleymanovtat.list.companies.presentation.details.DetailsCompanyFragment

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [ IteractorComponent::class])
interface ViewModelComponent {

    fun inject(fragment: CompaniesFragment)
    fun inject(fragment: DetailsCompanyFragment)
}