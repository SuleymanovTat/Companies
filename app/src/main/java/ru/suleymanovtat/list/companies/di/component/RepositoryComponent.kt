package ru.suleymanovtat.list.companies.di.component

import dagger.Component
import ru.suleymanovtat.list.companies.di.module.RepositoryModule
import ru.suleymanovtat.list.companies.di.scope.RepositoryScope
import ru.suleymanovtat.list.companies.repository.CompaniesRepository

@RepositoryScope
@Component(
    modules = [RepositoryModule::class],
    dependencies = [ApiComponent::class, DatabaseComponent::class]
)
interface RepositoryComponent {
    val repository: CompaniesRepository
}