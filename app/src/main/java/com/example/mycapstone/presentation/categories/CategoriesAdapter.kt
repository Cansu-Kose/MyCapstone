package com.example.mycapstone.presentation.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mycapstone.BR
import com.example.mycapstone.R
import com.example.mycapstone.databinding.ItemCategoriesBinding


class CategoriesAdapter(val list: List<String>,val onClickHandlerInterface: OnClickHandlerInterface):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding= DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),R.layout.item_categories,parent,false
        )
        return CategoriesViewHolder(itemBinding , onClickHandlerInterface)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoriesViewHolder).onBind(list.get(position),position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CategoriesViewHolder(val itemBinding: ViewDataBinding, val onClickHandlerInterface: OnClickHandlerInterface)
        : RecyclerView.ViewHolder(itemBinding.root){
        fun onBind(categoriesTittle: String,position: Int){
            val binding= itemBinding as ItemCategoriesBinding
            binding.setVariable(BR.categoriestitle, categoriesTittle)
            binding.setVariable(BR.clickHandler,onClickHandlerInterface)
            binding.setVariable(BR.position,position)

        }
    }

}