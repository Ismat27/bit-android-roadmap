package com.alat.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alat.roadmap.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private val args: ForgotPasswordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val email = args.email
        binding.etEmail.setText(email)
        binding.continueButton.setOnClickListener {
            proceedToUpdate()
        }
        binding.tvLogin.setOnClickListener {
            backToLogin()
        }
    }

    private fun backToLogin() {
        findNavController().popBackStack(R.id.loginFragment, false)
    }

    private fun proceedToUpdate() {
//        val updateFragment = UpdateBottomSheetFragment()
//        updateFragment.isCancelable = false
//        updateFragment.show(childFragmentManager, "UpdateFragment")
        LogoutFragment { backToLogin() }.show(childFragmentManager, "logoutFragment")
    }

}