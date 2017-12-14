package com.flyinbed.fnetwork.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by flyinbed on 17/12/11.
 */
object NetworkUtils{

    @SuppressLint("MissingPermission")
    fun isNetConneted(context: Context):Boolean{
        val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo : NetworkInfo?= connectManager.activeNetworkInfo
        if(networkInfo==null){
            return  false
        }else{
            return networkInfo.isAvailable&& networkInfo.isConnected
        }

    }

    @SuppressLint("MissingPermission")
    fun isNetworkConnected(context: Context, typeMoblie : Int): Boolean{
        if(!isNetConneted(context)){
            return false
        }
        val connectManager  = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo : NetworkInfo = connectManager.getNetworkInfo(typeMoblie)
        return  networkInfo.isConnected && networkInfo.isAvailable
    }

    fun isPhoneNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_MOBILE
        return isNetworkConnected(context,typeMobile)
    }

    fun isWifiNetConnected(context: Context) : Boolean{
        val typeMobile = ConnectivityManager.TYPE_WIFI
        return  isNetworkConnected(context,typeMobile)
    }



}