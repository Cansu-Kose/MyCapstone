package com.example.mycapstone.presentation.categories


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycapstone.BR
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentCategoriesBinding


class CategoriesFragment( ) : Fragment(), OnClickHandlerInterface {

    private lateinit var fragmentCategoriesBinding: FragmentCategoriesBinding
    private lateinit var onClickHandlerInterface: OnClickHandlerInterface

    private var itemList= ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCategoriesBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_categories,container,false)

        itemList.add("\t\t\t\t\t    Tops")
        itemList.add("\t\t\t\t\t    Shirts And Blouses")
        itemList.add("\t\t\t\t\t    Cardigans And Sweaters")
        itemList.add("\t\t\t\t\t    Knitwear")
        itemList.add("\t\t\t\t\t    Blazers")
        itemList.add("\t\t\t\t\t    Jeans")
        itemList.add("\t\t\t\t\t    Pants")
        itemList.add("\t\t\t\t\t    Shorts")
        itemList.add("\t\t\t\t\t    Skirts")
        itemList.add("\t\t\t\t\t    Dresses")


        onClickHandlerInterface=this
        val adapter=CategoriesAdapter(itemList,onClickHandlerInterface)
        val linearLayoutManager= LinearLayoutManager(context)
        fragmentCategoriesBinding.recyclerview.layoutManager=linearLayoutManager
        fragmentCategoriesBinding.setVariable(BR.adapter,adapter)


        return fragmentCategoriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentCategoriesBinding.back4.setOnClickListener {
            findNavController().navigate(R.id.action_categoriesFragment_to_fashionSaleFragment)
        }
    }

    override fun onClick(view: View, position: Int) {
        TODO("Not yet implemented")
    }


}