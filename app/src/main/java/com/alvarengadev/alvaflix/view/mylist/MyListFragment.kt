package com.alvarengadev.alvaflix.view.mylist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvarengadev.alvaflix.R

class MyListFragment : Fragment() {

    companion object {
        fun newInstance() = MyListFragment()
    }

    private lateinit var viewModel: MyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}