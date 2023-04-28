package com.cats.mabanquetest.ui.fragment.account.view

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cats.mabanquetest.R
import com.cats.mabanquetest.databinding.FragmentOperationBinding
import com.cats.mabanquetest.ui.fragment.account.adapter.OperationAdapter
import com.cats.mabanquetest.ui.fragment.account.viewmodel.OperationViewModel
import com.cats.mabanquetest.ui.fragment.common.GenericFragment
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UPPER_BOUND_VIOLATED")
@AndroidEntryPoint
class OperationFragment : GenericFragment<FragmentOperationBinding>(layoutId = R.layout.fragment_operation) {
    private val viewModel: OperationViewModel by activityViewModels()

    override fun onCreate() {
        viewModel.account.observe(this) {
            with(viewDataBinding) {
                this!!.balance?.text = it.balance.toString()+" €"
                this!!.accountName?.text = it.label
                operationListview?.adapter = OperationAdapter(it.operations)
            }
        }
        viewDataBinding?.headerTitle?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}