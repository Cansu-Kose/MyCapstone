package com.example.mycapstone.presentation.productcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentProductCardBinding


class ProductCardFragment : Fragment() {

    private lateinit var fragmentProductCardBinding: FragmentProductCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductCardBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_product_card,container,false)

        return fragmentProductCardBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentProductCardBinding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_productCardFragment_to_fashionSaleFragment)
        }
    }
}