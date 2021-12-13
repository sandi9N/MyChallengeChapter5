package binar.academy.mychallengechapter5.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import binar.academy.mychallengechapter5.R
import binar.academy.mychallengechapter5.controller.Callback
import binar.academy.mychallengechapter5.controller.CallbackDialog
import binar.academy.mychallengechapter5.controller.Controller
import binar.academy.mychallengechapter5.databinding.ActivityPlayerBinding

@RequiresApi(Build.VERSION_CODES.M)
open class PlayerActivity : AppCompatActivity(), Callback, CallbackDialog {

    private lateinit var binding: ActivityPlayerBinding

    val name by lazy { intent.getStringExtra("name") }
    var hasilPemain1 = ""
    var hasilPemain2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pemain1.text = name

        val btnPemain1 = arrayOf(
            binding.ivPemainBatu,
            binding.ivPemainKertas,
            binding.ivPemainGunting,
        )

        val btnPemain2 = arrayOf(
            binding.ivComBatu,
            binding.ivComKertas,
            binding.ivComGunting,
        )


        disableClickDua(false)
        val controller = Controller(this, name, "Pemain 2")
        btnPemain1.forEachIndexed { index, ImageView ->
            Log.e("pemain satu", "klikk")
            ImageView.setOnClickListener {
                hasilPemain1 = btnPemain1[index].contentDescription.toString()
                Log.d("PEMAIN SATU", "Memilih $hasilPemain1")
                Toast.makeText(this, "$name Memilih $hasilPemain1", Toast.LENGTH_SHORT)
                    .show()
                disableClickSatu(false)
                disableClickDua(true)

                btnPemain1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain1[index].setBackgroundResource(R.drawable.shape_backround)
            }
        }

        btnPemain2.forEachIndexed { index, ImageView ->
            Log.e("pemain Dua", "klikk")
            ImageView.setOnClickListener {
                hasilPemain2 = btnPemain2[index].contentDescription.toString()
                Log.d("PEMAIN DUA", "Memilih $hasilPemain2")
                Toast.makeText(this, "Pemain 2 Memilih $hasilPemain2", Toast.LENGTH_SHORT)
                    .show()
                disableClickDua(false)
                if (hasilPemain1 != "") {
                    controller.cekSuit(hasilPemain1, hasilPemain2)
                }

                btnPemain2.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain2[index].setBackgroundResource(R.drawable.shape_backround)
            }
        }

        binding.ivReset.setOnClickListener {
            Toast.makeText(this, "Mulai Lagi Broo...!", Toast.LENGTH_SHORT)
                .show()
            Log.d("reset", "Clicked")
            reset(android.R.color.transparent)

        }


        binding.ivclose.setOnClickListener{
            finish()
        }
    }

    private fun disableClickSatu(isEnable: Boolean) {
        binding.ivPemainBatu.isEnabled = isEnable
        binding.ivPemainKertas.isEnabled = isEnable
        binding.ivPemainGunting.isEnabled = isEnable
    }

    private fun disableClickDua(isEnable: Boolean) {
        binding.ivComBatu.isEnabled = isEnable
        binding.ivComKertas.isEnabled = isEnable
        binding.ivComGunting.isEnabled = isEnable
    }

    override fun hasil(hasil: String) {
        val dialogFragment = DialogFragment()
        val bundle = Bundle()
        bundle.putString("hasil", hasil)
        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "")

    }

    override fun reset(bg: Int) {
        binding.ivPemainBatu.setBackgroundResource(bg)
        binding.ivPemainKertas.setBackgroundResource(bg)
        binding.ivPemainGunting.setBackgroundResource(bg)
        binding.ivComBatu.setBackgroundResource(bg)
        binding.ivComKertas.setBackgroundResource(bg)
        binding.ivComGunting.setBackgroundResource(bg)

        disableClickSatu(true)
        disableClickDua(false)

        hasilPemain1 = ""
        hasilPemain2 = ""

    }

}
