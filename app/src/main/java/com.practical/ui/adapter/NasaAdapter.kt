package com.practical.ui.adapter

import android.view.View
import com.practical.R
import com.practical.base.BaseRecyclerAdapter
import com.practical.model.response.NasaResponse
import com.practical.viewmodel.HomeViewModel

class NasaAdapter(private val viewModel: HomeViewModel) : BaseRecyclerAdapter<NasaResponse>() {

    override fun onItemClick(view: View?, adapterPosition: Int) {
        viewModel.clickHandler.value = getListItems()[adapterPosition]
    }

    override fun areItemsSame(oldItem: NasaResponse, newItem: NasaResponse): Boolean {
        return oldItem == newItem
    }

    override fun getLayoutIdForLoading(viewType: Int): Int = R.layout.layout_loader

    override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_nasa

    override fun getLoaderItem(): NasaResponse = NasaResponse()
}
