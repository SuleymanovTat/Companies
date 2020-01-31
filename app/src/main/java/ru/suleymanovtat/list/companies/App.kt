package ru.suleymanovtat.list.companies

import android.app.Application
import androidx.room.Room
import ru.suleymanovtat.list.companies.di.component.*
import ru.suleymanovtat.list.companies.di.module.*
import ru.suleymanovtat.list.companies.repository.database.AppDatabase

class App : Application() {

    private var viewModelComponent: ViewModelComponent? = null
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database.db")
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()
        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this.database!!))
            .build()
        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()
        val iteractorComponent = DaggerIteractorComponent.builder()
            .repositoryComponent(repositoryComponent)
            .iteractorModule(IteractorModule())
            .build()
        viewModelComponent = DaggerViewModelComponent.builder()
            .viewModelModule(ViewModelModule(this))
            .iteractorComponent(iteractorComponent)
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent!!
    }
}