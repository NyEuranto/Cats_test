package com.cats.mabanquetest.ui.fragment.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class GenericFragment <D : ViewDataBinding>(private val layoutId: Int): Fragment() {
    var viewDataBinding: D? = null

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater,
            layoutId,
            container,
            false
        ) as D?
        return viewDataBinding?.root
    }

    final override fun onStart() {
        super.onStart()
        onCreate()
    }

    abstract fun onCreate()

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding = null
    }
}