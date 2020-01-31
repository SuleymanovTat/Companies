package ru.suleymanovtat.list.companies.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.suleymanovtat.list.companies.App
import ru.suleymanovtat.list.companies.di.component.ViewModelComponent

abstract class BaseFragment(layout: Int) : Fragment(layout) {

    protected abstract fun injectDependency(component: ViewModelComponent)

    private fun createDaggerDependencies() {
        injectDependency((requireActivity().application as App).getViewModelComponent())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }
}