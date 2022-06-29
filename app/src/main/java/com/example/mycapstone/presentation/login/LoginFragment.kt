package com.example.mycapstone.presentation.login

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
import com.example.mycapstone.databinding.FragmentLoginBinding
import com.example.mycapstone.presentation.forgotpassword.ForgotPasswordFragment
import com.example.mycapstone.presentation.signup.SignupFragment
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {

    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var email=""
    private var password=""
    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        progressDialog= ProgressDialog(getActivity())
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Logging In...")

        firebaseAuth= FirebaseAuth.getInstance()
        checkUser();

        fragmentLoginBinding.redarrow2.setOnClickListener {
           // startActivity(Intent(getActivity(),ForgotPasswordFragment::class.java))
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        fragmentLoginBinding.loginBtn.setOnClickListener {
            validateData()

        }

        fragmentLoginBinding.back.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

    }

    private fun validateData() {
        email=fragmentLoginBinding.emailEt.text.toString().trim()
        password=fragmentLoginBinding.passwordEt.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            fragmentLoginBinding.emailEt.error = "Invalid email format"

        }
        else if (TextUtils.isEmpty(password)){
            fragmentLoginBinding.passwordEt.error="Please enter password"
        }
        else if (password.length<6){
            fragmentLoginBinding.passwordEt.error="Password must at least 6 character long"
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
                Toast.makeText(getActivity(), "LoggedIn as $email", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_successFragment)
               // startActivity(Intent(getActivity(),ForgotPasswordFragment::class.java))
               // getActivity()?.finish()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(getActivity(), "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        val firebaseUser=firebaseAuth.currentUser
        if (firebaseUser!=null){
           // startActivity(Intent(getActivity(),ForgotPasswordFragment::class.java))
            findNavController().navigate(R.id.action_loginFragment_to_successFragment)
           // getActivity()?.finish()
        }
    }
}