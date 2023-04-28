package com.cats.mabanquetest.ui.fragment.account.view

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cats.mabanquetest.R
import com.cats.mabanquetest.databinding.FragmentAccountBinding
import com.cats.mabanquetest.ui.fragment.account.adapter.AccountListAdapter
import com.cats.mabanquetest.ui.fragment.account.viewmodel.AccountViewModel
import com.cats.mabanquetest.ui.fragment.account.viewmodel.OperationViewModel
import com.cats.mabanquetest.ui.fragment.common.GenericFragment
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UPPER_BOUND_VIOLATED")
@AndroidEntryPoint
class AccountFragment : GenericFragment<FragmentAccountBinding>(layoutId = R.layout.fragment_account) {

    private val viewModel: AccountViewModel by activityViewModels()
    private val operationViewModel: OperationViewModel by activityViewModels()

    override fun onCreate() {

        viewModel.cabankList.observe(this) {
            var caAdapter = AccountListAdapter(it)
            viewDataBinding?.expandableBankList?.setAdapter(caAdapter)
            viewDataBinding?.expandableBankList?.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                operationViewModel.setAccountValue(caAdapter.getChild(groupPosition, childPosition));
                findNavController().navigate(R.id.action_nav_account_to_nav_operation)
                false
            }

        }

        viewModel.otherbankList.observe(this) {
            var otherAdapter = AccountListAdapter(it)
            viewDataBinding?.expandableOtherList?.setAdapter(otherAdapter)
            viewDataBinding?.expandableOtherList?.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                operationViewModel.setAccountValue(otherAdapter.getChild(groupPosition, childPosition));
                findNavController().navigate(R.id.action_nav_account_to_nav_operation)
                false
            }
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}