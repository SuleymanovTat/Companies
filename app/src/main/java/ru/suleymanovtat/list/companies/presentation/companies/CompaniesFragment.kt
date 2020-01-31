package ru.suleymanovtat.list.companies.presentation.companies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.companies_fragment.*
import ru.suleymanovtat.list.companies.R
import ru.suleymanovtat.list.companies.di.component.ViewModelComponent
import ru.suleymanovtat.list.companies.model.local.CompanyLocal
import ru.suleymanovtat.list.companies.presentation.base.BaseFragment
import ru.suleymanovtat.list.companies.presentation.companies.adapter.CompaniesAdapter
import ru.suleymanovtat.list.companies.presentation.companies.adapter.OnCompanyClickListener
import ru.suleymanovtat.list.companies.presentation.details.DetailsCompanyFragment
import javax.inject.Inject

class CompaniesFragment : BaseFragment(R.layout.companies_fragment), OnCompanyClickListener,
    View.OnClickListener {

    companion object {
        fun newInstance() = CompaniesFragment()
    }

    var viewModel: CompaniesViewModel? = null
        @Inject set


    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewPlaceHolder.setOnClickListener(this)
        textViewError.setOnClickListener(this)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.companies?.observe(this, Observer { wrapper ->
            when (wrapper.status) {
                0 -> {
                    //error
                    groupError.visibility = View.VISIBLE
                    recyclerViewCompanies.visibility = View.GONE
                    textViewError.text = wrapper.message
                }
                1 -> {
                    //success
                    val adapter = CompaniesAdapter(wrapper.response!!, this)
                    recyclerViewCompanies.adapter = adapter
                    groupError.visibility = View.GONE
                    recyclerViewCompanies.visibility = View.VISIBLE
                }
            }
            progress.visibility = View.GONE
        })
    }

    override fun onCompanyLocal(companyLocal: CompanyLocal) {
        activity?.supportFragmentManager!!.beginTransaction().replace(
            R.id.container, DetailsCompanyFragment.newInstance(companyLocal)
        ).addToBackStack(null)
            .commit()
    }

    override fun onClick(v: View?) {
        progress.visibility = View.VISIBLE
        viewModel?.loading()
    }
}
