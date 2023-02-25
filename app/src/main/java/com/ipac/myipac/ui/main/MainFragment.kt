package com.ipac.myipac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ipac.myipac.MainActivity
import com.ipac.myipac.R
import com.ipac.myipac.databinding.FragmentMainBinding
import com.ipac.myipac.db.model.Result
import com.ipac.myipac.util.replaceFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), UserClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val userViewModel by viewModel<MainViewModel>()
    private lateinit var userAdapter: UserAdapter
    private lateinit var fragmentMainBinding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        fragmentMainBinding.viewModel = userViewModel
        userAdapter = UserAdapter(context, this)
        fragmentMainBinding.rvUsers.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        fragmentMainBinding.rvUsers.adapter = userAdapter
        userViewModel.getUsers(20)
        userViewModel.usersList.observe(viewLifecycleOwner, Observer {
            if (it!!.isNotEmpty()) {
                userAdapter.setUsers(it)
            }
        })
        return fragmentMainBinding.root
    }

    override fun rowClick(user: Result) {
        (activity as MainActivity).replaceFragment(
            DetailsFragment.newInstance(user),
            R.id.container, "userDetails"
        )
    }

}