package ru.suleymanovtat.list.companies.di.component

import dagger.Component
import ru.suleymanovtat.list.companies.di.module.IteractorModule
import ru.suleymanovtat.list.companies.di.scope.InteractorScope
import ru.suleymanovtat.list.companies.domain.CompaniesInteractor

@InteractorScope
@Component(
    modules = [IteractorModule::class],
    dependencies = [RepositoryComponent::class]
)
interface IteractorComponent {
    val companiesInteractor: CompaniesInteractor
}