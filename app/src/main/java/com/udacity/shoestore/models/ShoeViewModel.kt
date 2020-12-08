package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {


    val shoeList=MutableLiveData<MutableList<Shoe>>()

    init {
//        Add a default first entry
        val shoe_default=Shoe("Shoe 1",10.5,"company 1","nice shoe")
        shoeList.value= mutableListOf<Shoe>(shoe_default)
    }

    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            shoeList.value?.add(it)
        }
    }
}
