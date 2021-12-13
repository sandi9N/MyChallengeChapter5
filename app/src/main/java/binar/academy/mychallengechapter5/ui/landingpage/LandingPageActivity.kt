package binar.academy.mychallengechapter5.ui.landingpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.viewpager2.widget.ViewPager2
import binar.academy.mychallengechapter5.R
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)


        val springDotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        val viewPager = findViewById<ViewPager2>(R.id.viewpager2)
        val fragments: ArrayList<Fragment> = arrayListOf(
            Fragment1(),
            Fragment2(),
            Fragment3()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter
        springDotsIndicator.setViewPager2(viewPager)
    }
}