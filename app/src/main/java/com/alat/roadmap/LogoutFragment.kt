package com.alat.roadmap

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.alat.roadmap.databinding.FragmentLogoutDialogBinding


class LogoutFragment(val onLogout: () -> Unit = {}) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val customDialog = AlertDialog.Builder(requireContext(), R.style.CustomDialog).create()
        val customDialogView = layoutInflater.inflate(R.layout.fragment_logout_dialog, null)
        val binding = FragmentLogoutDialogBinding.bind(customDialogView)

        binding.apply {
            btnLogout.setOnClickListener {
                onLogout()
                dismiss()
            }
            btnDismiss.setOnClickListener {
                dismiss()
            }
            iButtonCancel.setOnClickListener {
                dismiss()
            }
        }

        binding.btnLogout.setOnClickListener {
            onLogout()
            dismiss()
        }

        customDialog.setView(customDialogView)
        return customDialog
    }
}