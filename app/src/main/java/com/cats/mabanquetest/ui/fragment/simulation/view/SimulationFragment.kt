package com.cats.mabanquetest.ui.fragment.simulation.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cats.mabanquetest.R
import com.cats.mabanquetest.databinding.FragmentAccountBinding
import com.cats.mabanquetest.databinding.FragmentSimulationBinding
import com.cats.mabanquetest.ui.fragment.common.GenericFragment
import com.cats.mabanquetest.ui.fragment.simulation.viewmodel.SimulationViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UPPER_BOUND_VIOLATED")
@AndroidEntryPoint
class SimulationFragment : GenericFragment<FragmentSimulationBinding>(layoutId = R.layout.fragment_simulation) {


    private lateinit var viewModel: SimulationViewModel

    override fun onCreate() {
        viewModel = ViewModelProvider(this).get(SimulationViewModel::class.java)
    }
}