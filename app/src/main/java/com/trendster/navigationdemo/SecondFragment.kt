package com.trendster.navigationdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mView = inflater.inflate(R.layout.fragment_second, container, false)

        val myNumber = args.number.toString()

        mView.textView2.text = myNumber

        mView.textView2.setOnClickListener {Navigation
            .findNavController(mView)
            .navigate(R.id.action_second_to_first)
        }

        return mView
    }

}