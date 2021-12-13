package binar.academy.mychallengechapter5.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import binar.academy.mychallengechapter5.R
import binar.academy.mychallengechapter5.controller.CallbackDialog


class DialogFragment : DialogFragment() {
    var callbackDialog: CallbackDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonmain = view.findViewById<Button>(R.id.buttonmain)
        val buttonmenu = view.findViewById<Button>(R.id.buttonmenu)
        val tvhasil = view.findViewById<TextView>(R.id.tvmenang)

        if (arguments != null) {
            val hasil = arguments?.getString("hasil")
            tvhasil.text = hasil
        }

        buttonmain.setOnClickListener {
            dismiss()
            callbackDialog?.reset(android.R.color.transparent)
        }

        buttonmenu.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callbackDialog = context as CallbackDialog
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
