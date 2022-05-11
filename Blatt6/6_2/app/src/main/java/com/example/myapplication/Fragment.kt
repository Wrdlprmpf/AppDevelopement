package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var input: EditText
    lateinit var output: TextView
    lateinit var conversionInput:EditText
    lateinit var conversionBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var layout = inflater.inflate(R.layout.fragment_one, container, false)

        input = layout.findViewById(R.id.textInput)
        output = layout.findViewById(R.id.textOutput)
        conversionInput = layout.findViewById(R.id.textConversionRate)
        conversionBtn = layout.findViewById(R.id.btnConvert)
        conversion()

        conversionBtn.setOnClickListener{
            conversion()
        }
        return layout
    }

    fun conversion(){
        output.setText((input.text.toString().toFloat()*conversionInput.text.toString().toFloat()).toString())
        println(conversionInput.text)

    }

}