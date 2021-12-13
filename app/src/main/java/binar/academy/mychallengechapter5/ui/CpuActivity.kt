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
import binar.academy.mychallengechapter5.databinding.ActivityCpuBinding

@RequiresApi(Build.VERSION_CODES.M)
open class CpuActivity : AppCompatActivity(), Callback, CallbackDialog {

    private lateinit var binding: ActivityCpuBinding

    val name by lazy { intent.getStringExtra("name") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCpuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pemain1.text = name

        val btnPemain = arrayOf(
            binding.ivPemainBatu,
            binding.ivPemainKertas,
            binding.ivPemainGunting,
        )

        val btnCom = arrayOf(
            binding.ivComBatu,
            binding.ivComKertas,
            binding.ivComGunting,
        )

        val controller = Controller(this, name, "Cpu")

        btnPemain.forEachIndexed { index, ImageView ->
            ImageView.setOnClickListener {
                val hasilCom = btnCom.random()
                Log.d("${btnPemain[index].contentDescription}", "Clicked")
                hasilCom.setBackgroundResource(R.drawable.shape_backround)
                disableClick(false)
                controller.cekSuit(
                    btnPemain[index].contentDescription.toString(),
                    hasilCom.contentDescription.toString())

                Toast.makeText(this, "$name Memilih ${btnPemain[index].contentDescription} ", Toast.LENGTH_SHORT)
                    .show()
                Log.d("$name", "Memilih ${btnPemain[index].contentDescription}")

                Toast.makeText(this, "CPU Memilih ${hasilCom.contentDescription} ", Toast.LENGTH_SHORT)
                    .show()
                Log.d("CPU", "Memilih ${hasilCom.contentDescription}")
                btnPemain.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain[index].setBackgroundResource(R.drawable.shape_backround)
            }
        }
        binding.ivReset.setOnClickListener {
            Toast.makeText(this, "Mulai Lagi Broo...!", Toast.LENGTH_SHORT)
                .show()
            Log.d("reset", "Clicked")
            reset(android.R.color.transparent)
        }

        binding.ivclose.setOnClickListener {
            finish()
        }
    }

    private fun disableClick(isEnable: Boolean) {
        binding.ivPemainBatu.isEnabled = isEnable
        binding.ivPemainKertas.isEnabled = isEnable
        binding.ivPemainGunting.isEnabled = isEnable
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

        disableClick(true)

    }
}

//    private fun cek(pemain: CharSequence, com: CharSequence) {
//        if (pemain == com) {
//            binding.hasil.setBackgroundColor(getColor(R.color.red))
//            binding.hasil.setTextColor(getColor(R.color.black))
//            binding.hasil.setText(R.string.seri)
//        } else if (pemain == binding.ivPemainBatu.contentDescription && com == binding.ivComGunting.contentDescription || pemain == binding.ivPemainGunting.contentDescription && com == binding.ivComKertas.contentDescription || pemain == binding.ivPemainKertas.contentDescription && com == binding.ivComBatu.contentDescription) {
//            binding.hasil.setBackgroundColor(getColor(R.color.blue_seri))
//            binding.hasil.setTextColor(getColor(R.color.black))
//            binding.hasil.setText(R.string.pemain_menang)
//        } else {
//            binding.hasil.setBackgroundColor(getColor(R.color.green_hasil))
//            binding.hasil.setTextColor(getColor(R.color.black))
//            binding.hasil.setText(R.string.pemain2_menang)
//        }
//        Log.d("Hasil", "$pemain VS $com")
//    }

