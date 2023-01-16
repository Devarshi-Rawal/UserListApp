package com.example.userlistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.userlistapp.R
import com.example.userlistapp.databinding.FragmentItemDetailBinding

class ItemDetailFragment : Fragment() {

    //binding variable created
    lateinit var binding: FragmentItemDetailBinding

    //initialized arguments variable
    private val args: ItemDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_item_detail, container, false)

        showItemDetails()

        return binding.root
    }

    private fun showItemDetails(){
        Glide.with(requireActivity()).load(args.imageUrl).into(binding.imageViewItem)
        if (args.imageDesc.isNotEmpty()) {
            binding.textViewDescription.text = args.imageDesc
        } else{
            binding.textViewDescription.visibility = View.GONE
        }

        binding.imageViewExit.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}