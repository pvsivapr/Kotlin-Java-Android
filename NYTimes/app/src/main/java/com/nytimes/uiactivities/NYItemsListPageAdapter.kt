package com.nytimes.uiactivities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.networking.NYItemsListModel
import com.nytimes.networking.NYItemsModel
import com.example.nytimes.BR
import com.example.nytimes.R
import com.example.nytimes.databinding.ListNyitemsCellBinding
var nyItemsListPageViewModel: NYItemsListPageViewModel? = null;
class NYItemsListPageAdapter(nyItems_List: NYItemsListModel, nyItemsListPage_ViewModel: NYItemsListPageViewModel) : RecyclerView.Adapter<NYItemsListPageAdapter.NYItemsViewHolder>()
{
    var nyItemsList: NYItemsListModel? = null;
    init {
        nyItemsList = nyItems_List
        nyItemsListPageViewModel = nyItemsListPage_ViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NYItemsViewHolder {
        var listNyitemsCellBinding: ListNyitemsCellBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_nyitems_cell,parent, false)
        return NYItemsViewHolder(listNyitemsCellBinding, nyItemsListPageViewModel!!)
    }

    override fun getItemCount(): Int {
        var count = 0;
        if(nyItemsList != null && nyItemsList?.results != null)
        {
            count = nyItemsList!!.results.count()
        }
        return count;
    }

    override fun onBindViewHolder(holder: NYItemsViewHolder, position: Int) {
        holder.bind(nyItemsList!!.results[position]);
    }

    class NYItemsViewHolder(val binding: ListNyitemsCellBinding, nyItemsListPageViewModel: NYItemsListPageViewModel) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(nyItemsModel : NYItemsModel)
        {
            binding.setVariable(BR.NYTimesItem, nyItemsModel)
            binding.setVariable(BR.nyItemsListPageVM, nyItemsListPageViewModel)
            binding.executePendingBindings()
        }
    }
}