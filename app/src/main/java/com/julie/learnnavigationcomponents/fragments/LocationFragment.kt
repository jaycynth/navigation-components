package com.julie.learnnavigationcomponents.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.julie.learnnavigationcomponents.R


class LocationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tv = view?.findViewById<TextView>(R.id.textViewAmountl)
        //val amount = arguments?.getString("amount")
        val amount = arguments?.let { LocationFragmentArgs.fromBundle(it).amount }
        tv?.text = amount.toString()
    }
}
