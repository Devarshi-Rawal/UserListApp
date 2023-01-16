package com.example.userlistapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userlistapp.R
import com.example.userlistapp.databinding.ItemListItemBinding
import com.example.userlistapp.fragments.ItemListFragmentDirections
import com.example.userlistapp.models.UserListItem

class ItemListAdapter(private val mContext: Context, private val listOfUsers: List<UserListItem>) : RecyclerView.Adapter<ItemListAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = DataBindingUtil.inflate<ItemListItemBinding>(LayoutInflater.from(parent.context), R.layout.item_list_item,parent,false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val currentUser = listOfUsers[position]

        holder.bind(mContext,currentUser,position,listOfUsers)
    }

    override fun getItemCount(): Int = listOfUsers.size

    class UserListViewHolder(val binding: ItemListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(mContext: Context, userListItem: UserListItem,position: Int, userList: List<UserListItem>){
            binding.userListItem = userListItem

            Glide.with(mContext).load(userListItem.urls.small).into(binding.imageViewItem)
            Glide.with(mContext).load(userListItem.user.profileImage.medium).into(binding.imageViewProfilePicture)

            if (userListItem.description != null){
                binding.textViewDesc.text = userListItem.description.toString()
            } else{
                if (userListItem.altDescription != null){
                    binding.textViewDesc.text = userListItem.altDescription.toString()
                } else{
                    binding.textViewDesc.visibility = View.GONE
                }
            }

            if (position == userList.size-1){
                binding.view.visibility = View.GONE
            }

            binding.textViewDesc.setOnClickListener {
                val description = if (userListItem.description != null){
                    userListItem.description.toString()
                } else{
                    if (userListItem.altDescription != null){
                        userListItem.altDescription.toString()
                    } else{
                        "Description Unavailable"
                    }
                }
                val action = ItemListFragmentDirections.actionUserListFragmentToItemDetailFragment(userListItem.urls.regular,description)
                binding.root.findNavController().navigate(action)
            }

            binding.imageViewItem.setOnClickListener {
                val description = if (userListItem.description != null){
                    userListItem.description.toString()
                } else{
                    if (userListItem.altDescription != null){
                        userListItem.altDescription.toString()
                    } else{
                        "Description Unavailable"
                    }
                }
                val action = ItemListFragmentDirections.actionUserListFragmentToItemDetailFragment(userListItem.urls.regular,description)
                binding.root.findNavController().navigate(action)
            }

            binding.imageViewProfilePicture.setOnClickListener {

                val location = if (userListItem.user.location != null){
                    userListItem.user.location.toString()
                } else{
                    "Loaction Unavailable"
                }

                val userBio = if (userListItem.user.bio != null){
                    userListItem.user.bio.toString()
                } else{
                    "User Bio Unavailable"
                }

                val action = ItemListFragmentDirections.actionUserListFragmentToUserDetailFragment(
                    userListItem.user.profileImage.large,userListItem.user.name,
                    location,userBio)
                binding.root.findNavController().navigate(action)
            }

            binding.textViewUserName.setOnClickListener {
                val location = if (userListItem.user.location != null){
                    userListItem.user.location.toString()
                } else{
                    "Loaction Unavailable"
                }
                val userBio = if (userListItem.user.bio != null){
                    userListItem.user.bio.toString()
                } else{
                    "User Bio Unavailable"
                }
                val action = ItemListFragmentDirections.actionUserListFragmentToUserDetailFragment(
                    userListItem.user.profileImage.large,userListItem.user.name,
                    location,userBio)
                binding.root.findNavController().navigate(action)
            }
        }
    }
}