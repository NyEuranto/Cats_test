package com.cats.mabanquetest.ui.fragment.uptoyou.view

import com.cats.mabanquetest.R
import com.cats.mabanquetest.databinding.FragmentAboutUsBinding
import com.cats.mabanquetest.ui.fragment.common.GenericFragment
import com.cats.mabanquetest.ui.fragment.uptoyou.viewmodel.AboutUsViewModel

class AboutUsFragment : GenericFragment<FragmentAboutUsBinding>(layoutId = R.layout.fragment_about_us) {

    private lateinit var viewModel: AboutUsViewModel

    override fun onCreate() {
    }

}