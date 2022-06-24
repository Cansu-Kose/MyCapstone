package com.example.mycapstone.presentation.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {
    private lateinit var fragmentSignupBinding: FragmentSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignupBinding=
                DataBindingUtil.inflate(inflater,R.layout.fragment_signup,container,false)
        // Inflate the layout for this fragment
        return fragmentSignupBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentSignupBinding.signupbutton.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_forgotPasswordFragment)
        }

        fragmentSignupBinding.back1.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        fragmentSignupBinding.redarrow.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }


}