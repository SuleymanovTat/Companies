package ru.suleymanovtat.list.companies.di.component

import dagger.Component
import ru.suleymanovtat.list.companies.di.module.DatabaseModule
import ru.suleymanovtat.list.companies.repository.database.AppDatabase

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}
