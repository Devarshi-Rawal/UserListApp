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
import com.example.userlistapp.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {

    //binding variable created
    lateinit var binding: FragmentUserDetailBinding
    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_user_detail, container, false)

        showUserDetails()

        return binding.root
    }

    private fun showUserDetails(){
        Glide.with(requireActivity()).load(args.userProfilePicUrl).into(binding.imageViewProfilePic)
        binding.textViewUserName.text = args.userName
        binding.textViewUserLoc.text = args.userLocation
        binding.textViewUserBio.text = args.userBio

        binding.imageViewExit.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}