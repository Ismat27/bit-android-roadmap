package com.alat.roadmap

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
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