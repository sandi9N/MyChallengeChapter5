package binar.academy.mychallengechapter5.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import binar.academy.mychallengechapter5.R
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnpemain = findViewById<ImageView>(R.id.ivsatu)
        val btncom = findViewById<ImageView>(R.id.ivdua)
        val tvPemain1 = findViewById<TextView>(R.id.tv1)
        val tvPemain2 = findViewById<TextView>(R.id.tv2)
        val menuActivity = findViewById<View>(R.id.menuactivity)

        val name = intent.getStringExtra("name")
        tvPemain1.text = "$name Vs Pemain"
        tvPemain2.text = "$name Vs CPU"




        Glide.with(this)
            .load("https://raw.githubusercontent.com/rahmatsugiarto/asset-image-binar-cc5/master/landing-page1.png")
            .into(btnpemain)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/rahmatsugiarto/asset-image-binar-cc5/master/landing-page2.png")
            .into(btncom)

        btncom.setOnClickListener {
            val intent = Intent(this, CpuActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)

        }
        btnpemain.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)

        }

        Snackbar.make(menuActivity, "Selamat Datang $name", Snackbar.LENGTH_LONG)
            .setAction("Tutup") {

            }.show()
    }

}