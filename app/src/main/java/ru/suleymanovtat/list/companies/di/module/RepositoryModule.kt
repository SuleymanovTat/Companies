package ru.suleymanovtat.list.companies.di.module

import dagger.Module
import dagger.Provides
import ru.suleymanovtat.list.companies.di.scope.RepositoryScope
import ru.suleymanovtat.list.companies.repository.CompaniesRepository
import ru.suleymanovtat.list.companies.repository.database.AppDatabase
import ru.suleymanovtat.list.companies.repository.network.ServerCommunicator

@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesRepository(
        communicator: ServerCommunicator,
        database: AppDatabase
    ) = CompaniesRepository(communicator, database)
}