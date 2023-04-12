package com.example.unitconverter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.unitconverter.R
import com.example.unitconverter.RoomDb.History
import com.example.unitconverter.RoomDb.HistoryDatabase
import com.example.unitconverter.databinding.FragmentHomeBinding

import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        val units = resources.getStringArray(R.array.units)
        val arrayAdapter= ArrayAdapter(requireContext(),R.layout.drop_down_menu,units)
       binding?.autoCompleteTextView?.setAdapter(arrayAdapter)

        binding?.floatingActionButton?.setOnClickListener {

            findNavController().navigate(R.id.historyFragment)

        }
        binding?.BtnConverter?.setOnClickListener {

            val inputUnit = binding?.unitseditText?.text.toString()
            val inputvalue = binding?.editText?.text.toString().toFloat()


            val kg:String? = "KG"
            val meter:String? = "METER"
            val second:String? = "SECOND"


            if (inputUnit == kg){
                val result = inputvalue * 2.2003
                binding?.converterTextView?.setText(result.toString())
                writeData()

            }

            else if (inputUnit == meter){
                val result = inputvalue * 3.2003
                binding?.converterTextView?.setText(result.toString())
                writeData()

            }
            else if (inputUnit == second){
                val result = inputvalue * 4.2003
                binding?.converterTextView?.setText(result.toString())
                writeData()

            }

        }

        return (binding?.root)
    }

    private fun writeData() {

        val unit = binding?.unitseditText?.text.toString()
        val inputValues = binding?.editText?.text.toString()
        val result = binding?.converterTextView?.text.toString()

        if (unit.isNotEmpty() && inputValues.isNotEmpty()) {
            lifecycleScope.launch {
                val history = History(unit = unit, inputValues = inputValues, result = result)
                HistoryDatabase(requireContext()).historyDao().insertHistory(history)
                Toast.makeText(context,"Successfully written",Toast.LENGTH_SHORT).show()
                binding?.unitseditText?.text?.clear()
                binding?.editText?.text?.clear()
                binding?.converterTextView?.text?.toString()
            }

        }
        else {
            Toast.makeText(context, "PLease Enter Data", Toast.LENGTH_SHORT).show()
        }
    }

}