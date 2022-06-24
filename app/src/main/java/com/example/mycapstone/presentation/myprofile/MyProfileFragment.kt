package com.example.mycapstone.presentation.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentMyProfileBinding
import com.example.mycapstone.databinding.FragmentMybagBinding


class MyProfileFragment : Fragment() {

    private lateinit var fragmentMyProfileBinding: FragmentMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMyProfileBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_my_profile,container,false)

        return fragmentMyProfileBinding.root
    }

}