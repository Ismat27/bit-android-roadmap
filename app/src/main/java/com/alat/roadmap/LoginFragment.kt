package com.alat.roadmap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alat.roadmap.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvForgotPassword.setOnClickListener {
            proceedToForgotPassword()
        }
        binding.loginButton.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        val id = R.id.action_loginFragment_to_postFragment
        findNavController().navigate(id)
    }

    private fun proceedToForgotPassword() {
        val email = binding.etEmail.text.toString()
        try {
            val direction =
                LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment(email)
            findNavController().navigate(direction)
        } catch (e: IllegalArgumentException) {
            Log.d("", "navigation fail")
        }
    }

}