package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoeViewModel=viewModel

        binding.setLifecycleOwner(this)

        binding.saveShoeButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

            val shoe = Shoe(name = binding.editShoeName.text.toString(),
                            company = binding.editcompanyName.text.toString(),
                            size = binding.editshoeSize.text.toString().toDouble(),
                            description = binding.editshoeDescription.text.toString())
            viewModel.saveCurrentDetail(shoe)
//            Toast.makeText(activity, checkFill().toString(), Toast.LENGTH_LONG).show()

        }

        binding.cancelShoeButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
//    private fun checkFill(): Boolean {
//        return (binding.editShoeName.text.isNullOrEmpty() && binding.editcompanyName.text.isNullOrEmpty() &&
//                binding.editshoeSize.text.isNullOrEmpty() && binding.editshoeDescription.text.isNullOrEmpty())
//    }
}