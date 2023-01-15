package com.example.userlistapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userlistapp.R
import com.example.userlistapp.databinding.ItemListItemBinding
import com.example.userlistapp.models.UserListItem

class ItemListAdapter(val mContext: Context, val listOfUsers: List<UserListItem>) : RecyclerView.Adapter<ItemListAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = DataBindingUtil.inflate<ItemListItemBinding>(LayoutInflater.from(parent.context), R.layout.item_list_item,parent,false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val currentUser = listOfUsers[position]

        holder.bind(mContext,currentUser,currentUser.urls.thumb,currentUser.user.profileImage.medium)
    }

    override fun getItemCount(): Int = listOfUsers.size

    class UserListViewHolder(val binding: ItemListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(mContext: Context, userListItem: UserListItem, itemUrl: String, profileImageUrl: String){
            binding.userListItem = userListItem
            Glide.with(mContext).load(itemUrl).into(binding.imageViewItem)
            Glide.with(mContext).load(profileImageUrl).into(binding.imageViewProfilePicture)
            if (userListItem.description != null){
                binding.textViewDesc.text = userListItem.description.toString()
            } else{
                if (userListItem.altDescription != null){
                    binding.textViewDesc.text = userListItem.altDescription.toString()
                } else{
                    binding.textViewDesc.visibility = View.GONE
                }
            }
        }
    }
}