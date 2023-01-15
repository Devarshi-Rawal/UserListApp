package com.example.userlistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.userlistapp.R
import com.example.userlistapp.adapters.ItemListAdapter
import com.example.userlistapp.databinding.FragmentItemListBinding
import com.example.userlistapp.viewmodels.UserListViewModel
import kotlinx.coroutines.launch

class ItemListFragment : Fragment() {

    //binding variable created
    lateinit var binding: FragmentItemListBinding
    //viewmodel instance created and initialized
    val viewModel: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_item_list,container,false)

        //code from here
        setRecyclerView()

        return binding.root
    }

    //method to collect data from state flow and set in recyclerview
    private fun setRecyclerView(){
        lifecycleScope.launch{
            viewModel.getAllUserList()

            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.userListStateFlow.collect{
                    binding.recyclerViewUserList.adapter = ItemListAdapter(requireContext(),it)
                }
            }
        }
    }
}