package ru.suleymanovtat.list.companies.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.suleymanovtat.list.companies.model.database.CompanyDB
import ru.suleymanovtat.list.companies.repository.database.dao.CompanyDao

@Database(
    entities = [CompanyDB::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
}