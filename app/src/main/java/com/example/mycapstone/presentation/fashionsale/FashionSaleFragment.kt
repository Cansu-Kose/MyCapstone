package com.example.mycapstone.presentation.fashionsale

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentFashionSaleBinding
import com.squareup.picasso.Picasso


class FashionSaleFragment : Fragment() {
    private lateinit var fragmentFashionSaleBinding: FragmentFashionSaleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFashionSaleBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_fashion_sale,container,false)

        return fragmentFashionSaleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentFashionSaleBinding.imageclick1.setOnClickListener {
            findNavController().navigate(R.id.action_fashionSaleFragment_to_productCardFragment)
        }
        fragmentFashionSaleBinding.button5.setOnClickListener {
            val url="https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fde%2F09%2Fde09a0d76bf8b0ea64464c514285dad13bed9fee.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/fullscreen]"
            Picasso.get()
                .load(url)
                .resize(412,583)
                .into(fragmentFashionSaleBinding.imageView12)
        }
    }

}