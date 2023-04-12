package com.example.unitconverter.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unitconverter.Adapters.CustomAdapter
import com.example.unitconverter.RoomDb.History
import com.example.unitconverter.RoomDb.HistoryDatabase
import com.example.unitconverter.databinding.FragmentHistoryBinding
import kotlinx.coroutines.launch


class HistoryFragment : androidx.fragment.app.Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private var mList:History? = null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHistoryBinding.inflate(LayoutInflater.from(context), container, false)
        displayData()
        return (binding?.root)
    }


    private  fun displayData() {
        lifecycleScope.launch {
            val history = HistoryDatabase(requireContext()).historyDao().getHistory()
            binding?.recyclerview?.apply {
                layoutManager=LinearLayoutManager(requireContext())
                adapter=CustomAdapter().apply {
                    setData(history)
                }
            }

        }

    }


}