package com.example.mycapstone.presentation.mybag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycapstone.BR
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentMybagBinding
import com.example.mycapstone.presentation.categories.OnClickHandlerInterface


class MybagFragment : Fragment(), OnClickHandlerInterface {

    private lateinit var fragmentMybagBinding: FragmentMybagBinding
    private lateinit var onClickHandlerInterface: OnClickHandlerInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMybagBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_mybag,container,false)

        val list=ArrayList<MyBagModel>()
        list.add(MyBagModel("Pullover","51$","Color: Black Size: L","1",R.drawable.img1,R.drawable.ic_plusbtn,R.drawable.ic_minusbtn))
        list.add(MyBagModel("T-Shirt","30$","Color: Gray Size: L","1",R.drawable.img2,R.drawable.ic_plusbtn,R.drawable.ic_minusbtn))
        list.add(MyBagModel("Sport Dress","43$","Color: Gray Size: L","1",R.drawable.img3,R.drawable.ic_plusbtn,R.drawable.ic_minusbtn))

        onClickHandlerInterface=this
        val adapter=MyBagAdapter(list,onClickHandlerInterface)
        val linearLayoutManager= LinearLayoutManager(context)
        fragmentMybagBinding.recyclerview.layoutManager=linearLayoutManager
        fragmentMybagBinding.setVariable(BR.adapter,adapter)

        return fragmentMybagBinding.root
    }

    override fun onClick(view: View, position: Int) {
        TODO("Not yet implemented")
    }

}