package ru.suleymanovtat.list.companies.di.component

import dagger.Component
import ru.suleymanovtat.list.companies.di.module.ApiModule
import ru.suleymanovtat.list.companies.di.scope.ApiScope
import ru.suleymanovtat.list.companies.repository.network.ServerCommunicator

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}
