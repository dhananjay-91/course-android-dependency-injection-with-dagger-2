package com.techyourchance.dagger2course.screens.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseViewMvc(layoutInflater: LayoutInflater, parent:ViewGroup?, layoutId:Int) {


    val rootView = layoutInflater.inflate(layoutId, parent, false)

    fun<T:View?> findViewById(resId:Int) : T
    {
        return rootView.findViewById<T>(resId)
    }
}