package com.cats.mabanquetest.ui.fragment.account.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cats.mabanquetest.R
import com.cats.mabanquetest.datamanager.model.Account
import com.cats.mabanquetest.datamanager.model.Bank

class AccountListAdapter (
    private val dataList: List<Bank>
) : BaseExpandableListAdapter() {
    override fun getGroupCount() = dataList.size
    override fun getChildrenCount(groupPosition: Int) = dataList[groupPosition].accounts.size
    override fun getGroup(groupPosition: Int) = dataList[groupPosition]
    override fun getChild(groupPosition: Int, childPosition: Int) = dataList[groupPosition].accounts[childPosition]
    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()
    override fun getChildId(groupPosition: Int, childPosition: Int) = dataList[groupPosition].accounts[childPosition].id.toLong()
    override fun hasStableIds() = true

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        val root = convertView
            ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bank_name_view, parent, false)
        root.findViewById<TextView>(R.id.bank_name)?.text = dataList[groupPosition].name
        val sumAmount : Float = dataList[groupPosition].accounts.map { it.balance }.reduce { sum, element -> sum + element }.toFloat()
        root.findViewById<TextView>(R.id.sum_amount)?.text = "$sumAmount €"
        root.findViewById<ImageView>(R.id.right_arrow)?.setImageResource(
            if (isExpanded) {
                R.drawable.ic_arrow_up
            } else {
                R.drawable.ic_arrow_down
            }
        )
        return root
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        val root = convertView
            ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.item_account_view, parent, false)
        root.findViewById<TextView>(R.id.account_name)?.text = dataList[groupPosition].accounts[childPosition].label
        root.findViewById<TextView>(R.id.amount)?.text =  dataList[groupPosition].accounts[childPosition].balance.toString()+" €"
        return root
    }



    /**
     * If false, [ExpandableListView.setOnChildClickListener] will not be invoked.
     */
    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}