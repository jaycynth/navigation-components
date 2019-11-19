package com.julie.learnnavigationcomponents.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.julie.learnnavigationcomponents.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener{

    lateinit var navController: NavController
    //var navController : NavController ? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        location.setOnClickListener(this)
        deals.setOnClickListener(this)
        orders.setOnClickListener(this)
        profile.setOnClickListener(this)
        support.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.location -> navController!!.navigate(R.id.action_mainFragment_to_locationFragment)
            R.id.deals -> navController !!.navigate(R.id.action_mainFragment_to_dealsFragment2)
            R.id.orders -> navController !!.navigate(R.id.action_mainFragment_to_ordersFragment)
            R.id.profile -> navController !!.navigate(R.id.action_mainFragment_to_profileFragment)
            R.id.support -> navController !!.navigate(R.id.action_mainFragment_to_supportFragment)

        }
    }



}
