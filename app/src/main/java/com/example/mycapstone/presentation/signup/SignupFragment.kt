package com.example.mycapstone.presentation.signup

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentSignupBinding
import com.example.mycapstone.presentation.forgotpassword.ForgotPasswordFragment
import com.example.mycapstone.presentation.login.LoginFragment
import com.google.firebase.auth.FirebaseAuth


class SignupFragment : Fragment() {

    private lateinit var fragmentSignupBinding: FragmentSignupBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var name=""
    private var email=""
    private var password=""

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
        progressDialog= ProgressDialog(getActivity())
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Creating account In...")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth= FirebaseAuth.getInstance()

        fragmentSignupBinding.signUpBtn.setOnClickListener {
            validateData()
        }

        fragmentSignupBinding.back1.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        fragmentSignupBinding.redarrow.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }

    private fun validateData() {
        name=fragmentSignupBinding.nameEt.text.toString().trim()
        email=fragmentSignupBinding.emailEt.text.toString().trim()
        password=fragmentSignupBinding.passwordEt.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            fragmentSignupBinding.emailEt.error = "Invalid email format"

        }
        else if (TextUtils.isEmpty(password)){
            fragmentSignupBinding.passwordEt.error="Please enter password"
        }
        else if (password.length<6){
            fragmentSignupBinding.passwordEt.error="Password must at least 6 character long"
        }
        else{
            firebaseLogin()
        }

    }

    private fun firebaseLogin() {
        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                val firebaseUser=firebaseAuth.currentUser
                val email=firebaseUser!!.email
                Toast.makeText(getActivity(), "Account created with email $email", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
              //  startActivity(Intent(getActivity(),LoginFragment::class.java))
                getActivity()?.finish()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(getActivity(), "SignUp failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }


    //  override fun onSupportNavigateUp(): Boolean {
       // onBackPressed()
       // return super.onSupportNavigateUp()
   // }


}