package com.alat.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.alat.roadmap.databinding.FragmentUpdateBinding
import com.alat.roadmap.utils.RequestStatus
import com.alat.roadmap.viewmodel.UpdateViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UpdateFragment : DialogFragment() {

    private val viewModel by viewModels<UpdateViewModel> { UpdateViewModel.Factory }
    private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSubmitNewPassword.setOnClickListener {
                val email = etConfirmNewPassword.text.toString()
                val password = etNewPassword.text.toString()
                val confirmPassword = etConfirmNewPassword.text.toString()
                if (password == confirmPassword) {
                    viewModel.update(email, password)
                }
            }
        }

        viewModel.updateStatus.observe(viewLifecycleOwner) {
            when (it) {
                is RequestStatus.Loading -> {}
                is RequestStatus.Success -> {
                    Toast.makeText(
                        requireContext(),
                        "password updated successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is RequestStatus.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "unable to update password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is RequestStatus.Uninitialized -> {}
            }
        }

    }

    companion object {

    }
}

class UpdateBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update, container, false)
    }
}
