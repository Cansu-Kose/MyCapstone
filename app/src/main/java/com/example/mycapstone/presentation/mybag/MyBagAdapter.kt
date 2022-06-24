package com.example.mycapstone.presentation.mybag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mycapstone.BR
import com.example.mycapstone.R
import com.example.mycapstone.databinding.ItemMybagBinding
import com.example.mycapstone.presentation.categories.OnClickHandlerInterface


class MyBagAdapter(val list: List<MyBagModel>,val onClickHandlerInterface: OnClickHandlerInterface):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mybagBinding= DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),R.layout.item_mybag,parent,false
        )
        return MyBagViewHolder(mybagBinding , onClickHandlerInterface)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyBagViewHolder).onBind(list.get(position),position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyBagViewHolder(val mybagBinding: ViewDataBinding, val onClickHandlerInterface: OnClickHandlerInterface)
        : RecyclerView.ViewHolder(mybagBinding.root){
        fun onBind(mybagModel: MyBagModel,position: Int){
            val binding= mybagBinding as ItemMybagBinding
            binding.setVariable(BR.itemmybag, mybagModel)
            binding.setVariable(BR.clickHandler,onClickHandlerInterface)
            binding.setVariable(BR.position,position)

        }
    }

}