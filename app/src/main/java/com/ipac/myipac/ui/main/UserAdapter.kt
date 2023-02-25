package com.ipac.myipac.ui.main

import android.R.attr.path
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ipac.myipac.R
import com.ipac.myipac.databinding.UserRowBinding
import com.ipac.myipac.db.model.Result


class UserAdapter(
    private val context: Context?,
    private val userRowClickListener: UserClickListener
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var userList: List<Result> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val viewBinding: UserRowBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_row, parent, false)
        return UserViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindDataToUI(position)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(private val viewBinding: UserRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bindDataToUI(position: Int) {
            val userItem = userList[position]
            Glide.with(context!!)
                .load(userItem.picture?.thumbnail)
                .apply(RequestOptions().override(250, 250))
                .into(viewBinding.imageView)
            viewBinding.user = userList[position]
            viewBinding.clickListener = userRowClickListener
        }
    }

    fun setUsers(usersList: List<Result>) {
        this.userList = usersList
        notifyDataSetChanged()
    }
}