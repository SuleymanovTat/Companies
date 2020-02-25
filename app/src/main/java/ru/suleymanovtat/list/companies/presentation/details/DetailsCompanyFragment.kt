package ru.suleymanovtat.list.companies.presentation.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.details_company_fragment.*
import ru.suleymanovtat.list.companies.R
import ru.suleymanovtat.list.companies.di.component.ViewModelComponent
import ru.suleymanovtat.list.companies.model.local.CompanyLocal
import ru.suleymanovtat.list.companies.presentation.base.BaseFragment
import javax.inject.Inject


class DetailsCompanyFragment : BaseFragment(R.layout.details_company_fragment) {

    companion object {
        const val KEY_COMPANY = "company"
        fun newInstance(companyLocal: CompanyLocal): DetailsCompanyFragment {
            val arguments = Bundle()
            arguments.putParcelable(KEY_COMPANY, companyLocal)
            val fragment = DetailsCompanyFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    var viewModel: DetailsCompanyViewModel? = null
        @Inject set

    private var companyLocal: CompanyLocal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        companyLocal = arguments?.getParcelable(KEY_COMPANY)
        companyLocal?.let { viewModel?.setData(it) }
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewWww.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(companyLocal?.www)))
        }
        textViewPhone.setOnClickListener { makePhoneCall() }
        textViewLatLon.setOnClickListener { openMap() }
        viewModel?.company!!.observe(viewLifecycleOwner, Observer { item ->
            Glide
                .with(requireActivity())
                .load(item.img)
                .centerCrop()
                .error(R.drawable.ic_placeholder)
                .into(media_image)
            toolbar.title = item.name
            textViewDescription.text = getString(R.string.description, item?.description)
            textViewWww.text = getString(R.string.www, item?.www!!)
            textViewPhone.text = getString(R.string.phone, item.phone!!)
            textViewDescription.visibility = showView(item.description!!)
            textViewWww.visibility = showView(item.www!!)
            textViewPhone.visibility = showView(item.phone!!)
            textViewLatLon.visibility = if (item.lat == 0.0) View.GONE else View.VISIBLE
        })
    }

    private fun showView(text: String) =
        if (text.isEmpty()) View.GONE else View.VISIBLE

    private fun makePhoneCall() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + companyLocal?.phone)
        startActivity(intent)
    }

    private fun openMap() {
        val gmmIntentUri =
            Uri.parse("google.streetview:cbll=" + companyLocal?.lat + "," + companyLocal?.lon)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
