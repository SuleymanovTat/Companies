package ru.suleymanovtat.list.companies.di.module

import dagger.Module
import dagger.Provides
import ru.suleymanovtat.list.companies.di.scope.InteractorScope
import ru.suleymanovtat.list.companies.domain.CompaniesInteractor
import ru.suleymanovtat.list.companies.repository.CompaniesRepository

@Module
class IteractorModule {

    @InteractorScope
    @Provides
    internal fun providesSettingsFragment(repository: CompaniesRepository) =
        CompaniesInteractor(repository)
}