package binar.academy.mychallengechapter5.ui.landingpage

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isVisible
import binar.academy.mychallengechapter5.R
import binar.academy.mychallengechapter5.ui.MenuActivity
import com.bumptech.glide.Glide

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivLanding3 = view.findViewById<ImageView>(R.id.ivlandingpage3)
        val etName = view.findViewById<EditText>(R.id.et_name)
        val btnNext = view.findViewById<ImageView>(R.id.ivNext)

        Glide.with(view)
            .load("https://raw.githubusercontent.com/rahmatsugiarto/asset-image-binar-cc5/master/landing-page3.png")
            .into(ivLanding3)

        etName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnNext.isVisible = s.toString().trim().isNotEmpty()
            }
        })

        btnNext.setOnClickListener {
            if (etName.text.isNotEmpty()) {

                val name = etName.text.toString()

                val intent = Intent(activity, MenuActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }


    }

}