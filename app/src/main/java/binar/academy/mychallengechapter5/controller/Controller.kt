package binar.academy.mychallengechapter5.controller

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import binar.academy.mychallengechapter5.R


class Controller(val callback: Callback,val pemain1 : String?, val pemain2 : String) : InterfaceController {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun cekSuit(pemain: String, com: String) {
        if (pemain == com) {
            Log.d("Hasil", "Draw")
            callback.hasil("Seri!")

        } else if (pemain == "batu" && com == "gunting" || pemain == "gunting" && com == "kertas" || pemain == "kertas" && com == "batu") {
            Log.d("Hasil", "pemain 1 win")
            callback.hasil("$pemain1 Menang!")

        } else {
            Log.d("Hasil", "pemain 2/com win")
            callback.hasil("$pemain2 Menang!")
        }
        Log.d("Hasil", "$pemain VS $com")
    }
}