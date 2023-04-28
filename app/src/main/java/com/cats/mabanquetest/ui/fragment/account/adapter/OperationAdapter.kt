package com.cats.mabanquetest.ui.fragment.account.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cats.mabanquetest.R
import com.cats.mabanquetest.datamanager.model.Operation
import com.cats.mabanquetest.utilities.DateUtils

class OperationAdapter(val operationList : List<Operation>) : RecyclerView.Adapter<OperationAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(operation: Operation) {
            itemView.findViewById<TextView>(R.id.operation_title).text = operation.title
            itemView.findViewById<TextView>(R.id.operation_date).text = DateUtils.formatDateFromTime(operation.date)
            itemView.findViewById<TextView>(R.id.operation_amount).text = operation.amount.replace(",",".", true) + " €"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_operation_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(operationList[position])
    }

    override fun getItemCount(): Int = operationList.size

}