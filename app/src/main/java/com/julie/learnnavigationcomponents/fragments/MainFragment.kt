package com.julie.learnnavigationcomponents.fragments


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.julie.learnnavigationcomponents.R
import kotlinx.android.synthetic.main.fragment_main.*


@Suppress("NAME_SHADOWING")
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
            R.id.location -> {
                val locationAmount: EditText = view!!.findViewById(R.id.editAmountLocation)
                if(!TextUtils.isEmpty(locationAmount.text.toString())){
                    val locationAmount = locationAmount.text.toString().toInt()

                    val bundle = bundleOf("amount" to locationAmount)
                    v.findNavController().navigate(R.id.action_mainFragment_to_locationFragment, bundle)
                }else{
                    Toast.makeText(activity,"Enter amount first", Toast.LENGTH_SHORT).show()
                }

                //only for navigation
                //navController!!.navigate(R.id.action_mainFragment_to_locationFragment)

            }

            R.id.deals -> {
                val amountTv: EditText = view!!.findViewById(R.id.editTextAmount)
                if(!TextUtils.isEmpty(amountTv.text.toString())){
                    val amount = amountTv.text.toString().toInt()
                val action = MainFragmentDirections.actionMainFragmentToDealsFragment().setMyArg(amount)
                v.findNavController().navigate(action)
                }else{
                    Toast.makeText(activity,"Enter amount first",Toast.LENGTH_SHORT).show()
                }
            }
            R.id.orders -> navController !!.navigate(R.id.action_mainFragment_to_ordersFragment)
            R.id.profile -> navController !!.navigate(R.id.action_mainFragment_to_profileFragment)
            R.id.support -> navController !!.navigate(R.id.action_mainFragment_to_supportFragment)

        }
    }



}
