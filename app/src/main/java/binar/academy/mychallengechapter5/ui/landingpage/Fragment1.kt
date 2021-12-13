package binar.academy.mychallengechapter5.ui.landingpage

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import binar.academy.mychallengechapter5.R
import com.bumptech.glide.Glide


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivLanding1 = view.findViewById<ImageView>(R.id.ivlandingpage1)
        Glide.with(view)
            .load("https://raw.githubusercontent.com/rahmatsugiarto/asset-image-binar-cc5/master/landing-page1.png")
            .into(ivLanding1)
    }
}