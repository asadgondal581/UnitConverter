package com.example.unitconverter.Adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.unitconverter.RoomDb.History
import com.example.unitconverter.databinding.CardViewDesignBinding


class CustomAdapter :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var mList: ArrayList<History> = ArrayList()
    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.binding.titleTextView.text = ItemsViewModel.unit
        holder.binding.subtitleTextView.text = ItemsViewModel.inputValues
        holder.binding.descriptionTextView.text = ItemsViewModel.result

        holder.binding.titleTextView.setOnClickListener {

        }


    }


    fun setData(data: List<History>) {
        mList.apply {
            clear()
            addAll(data)
        }


    }


    class ViewHolder(var binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root) {}
}
