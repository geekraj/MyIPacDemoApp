package com.ipac.myipac.pagination

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ipac.myipac.R
import com.ipac.myipac.databinding.UserRowBinding
import com.ipac.myipac.db.model.Result

class PagingAdapter(private val context: Context?) :
    PagingDataAdapter<Result, PagingAdapter.PagingViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
    }


    inner class PagingViewHolder(private val viewBinding: UserRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val viewBinding: UserRowBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_row, parent, false)
        return PagingViewHolder(viewBinding)
    }
}

private val DIFF_CALLBACK: DiffUtil.ItemCallback<Result> =
    object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.equals(newItem)
        }
    }
