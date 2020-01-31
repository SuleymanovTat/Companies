package ru.suleymanovtat.list.companies.di.module

import dagger.Module
import dagger.Provides
import ru.suleymanovtat.list.companies.repository.database.AppDatabase

@Module
class DatabaseModule(private val appDatabase: AppDatabase) {
    @Provides
    internal fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }
}