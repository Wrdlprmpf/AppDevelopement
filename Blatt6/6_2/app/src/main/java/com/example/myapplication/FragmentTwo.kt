package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTwo : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var spin:Spinner
    lateinit var btn:Button
    lateinit var input:EditText
    lateinit var output:TextView
    var pos = 0

    var units = arrayOf<String>(
        "centimeter to inch",
        "feet to inches",
        "mile to kilometer",
        "seamile to kilometer",
        "yard to meter"
    )

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
        var layout = inflater.inflate(R.layout.fragment_two, container, false)
        spin = layout.findViewById<Spinner>(R.id.spinnerFrag)
        btn = layout.findViewById<Button>(R.id.buttonFrag)
        input = layout.findViewById<EditText>(R.id.numberFrag)
        output = layout.findViewById<TextView>(R.id.outputFrag)

        // Inflate the layout for this fragment
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spin.onItemSelectedListener = this
        val adapter: ArrayAdapter<*> = ArrayAdapter<Any>(this.requireContext(), android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

        btn.setOnClickListener{
            conversion()
        }
    }

    fun conversion() {

        val inputText = this.input
        val outputText = this.output

        when (pos) {
            0 -> outputText.setText((inputText.text.toString().toInt() / 2.54).toString())
            1 -> outputText.setText((inputText.text.toString().toInt() * 12).toString())
            2 -> outputText.setText((inputText.text.toString().toInt() * 1.609).toString())
            3 -> outputText.setText((inputText.text.toString().toInt() * 1.852).toString())
            4 -> outputText.setText((inputText.text.toString().toInt() / 1.094).toString())
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        pos = position
        conversion()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}