package ru.suleymanovtat.list.companies.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import ru.suleymanovtat.list.companies.model.database.CompanyDB

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCompanies(companies: List<CompanyDB>)

    @Query("SELECT * from Company")
    fun getCompanies(): Observable<List<CompanyDB>>
}