package com.udacity.shoestore.models

import android.widget.EditText
import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        view: EditText, oldValue: Double,
        value: Double
    ): String {
       return value.toString()
    }

    @JvmStatic fun stringToDouble(
        view: EditText, oldValue: String,
        value: String
    ): Double {
        return value.toDouble()
    }
}