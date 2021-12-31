package com.example

import android.util.Log
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import com.example.components.ErrorMessage
import retrofit2.HttpException
import java.io.IOException

fun Fragment.displayedChild(value: Int, vf: ViewFlipper) {
    vf.displayedChild = value
}

fun convertErrorApi(error: Throwable): ErrorMessage {
    if(error is HttpException){
        try {
            return ErrorMessage(error.code(), error.message.toString())
        }catch (e: IOException){
            Log.d("error", " ${e.printStackTrace()}")
        }
    }
    return ErrorMessage()
}



