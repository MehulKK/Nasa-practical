package com.practical.ui.adapter

import android.view.View
import com.practical.R
import com.practical.base.BaseRecyclerAdapter
import com.practical.model.response.NasaResponse

class NasaAdapter : BaseRecyclerAdapter<NasaResponse>() {
    /*override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_user*/

    override fun onItemClick(view: View?, adapterPosition: Int) {
        /* no-op */
    }

    override fun areItemsSame(oldItem: NasaResponse, newItem: NasaResponse): Boolean {
        return oldItem == newItem
    }

    override fun getLayoutIdForLoading(viewType: Int): Int = R.layout.layout_loader

    override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_nasa

    override fun getLoaderItem(): NasaResponse = NasaResponse()
}
