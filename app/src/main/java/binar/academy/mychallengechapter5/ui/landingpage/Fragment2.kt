package binar.academy.mychallengechapter5.ui.landingpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import binar.academy.mychallengechapter5.R
import com.bumptech.glide.Glide

class Fragment2: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivLanding2 = view.findViewById<ImageView>(R.id.ivlandingpage2)
        Glide.with(view)
            .load("https://raw.githubusercontent.com/rahmatsugiarto/asset-image-binar-cc5/master/landing-page2.png")
            .into(ivLanding2)
    }
}