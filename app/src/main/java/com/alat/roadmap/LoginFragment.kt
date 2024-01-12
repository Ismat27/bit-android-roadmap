package com.alat.roadmap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alat.roadmap.databinding.FragmentLoginBinding
import com.alat.roadmap.viewmodel.OpeyemiViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: OpeyemiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[OpeyemiViewModel::class.java]
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodObserver()
        viewModel.updateOpeyemiFood("Eba and Efo")
        binding.tvForgotPassword.setOnClickListener {
            proceedToForgotPassword()
        }
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

    private fun foodObserver() {
        try {
            viewModel.likesFood.observe(viewLifecycleOwner) {food ->
                if (food != null) {
                    Toast.makeText(context, "$food Yes!!!", Toast.LENGTH_SHORT).show()
                }
            }

            viewModel.likesFood.observe((viewLifecycleOwner)){
                if (it != null ){
                    Toast.makeText(context, "$it Yes!!!", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e:Exception) {
            Log.e("ViewModelProvider", e.localizedMessage?.toString().toString())
        }
    }

}