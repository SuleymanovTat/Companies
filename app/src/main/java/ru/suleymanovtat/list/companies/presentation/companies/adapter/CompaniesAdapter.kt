package ru.suleymanovtat.list.companies.presentation.companies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_company.view.*
import ru.suleymanovtat.list.companies.R
import ru.suleymanovtat.list.companies.model.local.CompanyLocal


class CompaniesAdapter(
    private var companies: List<CompanyLocal>,
    private val listener: OnCompanyClickListener
) : RecyclerView.Adapter<CompaniesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_company,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return companies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = companies[position]
        with(holder.mView) {
            textViewCompanyName.text = item.name
            Glide
                .with(imageViewPhoto.context)
                .load(item.img)
                .error(R.drawable.ic_placeholder)
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(imageViewPhoto)
            setOnClickListener {
                listener.onCompanyLocal(item)
            }
        }
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
}