package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val shoe_selected = MutableLiveData<Shoe>()

    private val shoe_list=MutableLiveData<MutableList<Shoe>>()

    init {
//        Add a default first entry
        shoe_selected.value=Shoe("aa",10.5,"bb","cc")
        shoe_list.value= mutableListOf<Shoe>(shoe_selected.value!!)
    }

    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            shoe_list.value?.add(it)
        }
    }
}
