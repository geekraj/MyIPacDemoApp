package com.ipac.myipac.ui.main

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ipac.myipac.R
import com.ipac.myipac.databinding.FragmentDetailsBinding
import com.ipac.myipac.db.model.Result

class DetailsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(user: Result) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("user", user)
            }
        }
    }

    private var user: Result? = null
    override fun onAttach(context: Context) {
        user = arguments?.getParcelable("user")
        super.onAttach(context)
    }

    private lateinit var fragmentDetailsBinding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        fragmentDetailsBinding.user = user

        val mRootView = fragmentDetailsBinding.root
        fragmentDetailsBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        enableBackButton()
        //Displaying image
        Glide.with(requireActivity().applicationContext)
            .load(user?.picture?.large)
            .into(fragmentDetailsBinding.imageView)
        fragmentDetailsBinding.user = user
        //Different user Background based on Gender
        if (user?.gender.equals("Male", ignoreCase = true)){
            fragmentDetailsBinding.llCompleteView.setBackgroundColor(Color.parseColor("#00FF00"))
            fragmentDetailsBinding.tvHeading.setBackgroundColor(Color.parseColor("#00FF00"))
        }else{
            fragmentDetailsBinding.llCompleteView.setBackgroundColor(Color.parseColor("#FFC0CB"))
            fragmentDetailsBinding.tvHeading.setBackgroundColor(Color.parseColor("#FFC0CB"))
        }
    }

    private fun enableBackButton() {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeButtonEnabled(true)
    }
}