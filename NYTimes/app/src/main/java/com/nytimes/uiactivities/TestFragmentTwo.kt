package com.nytimes.uiactivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.nytimes.R

class TestFragmentTwo : Fragment()
{
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        val view = inflater.inflate(R.layout.test_xml_file, container, false)
        var textView = view.findViewById<TextView>(R.id.test_fragment_text_view)
        textView.text = "1"
        var buttonView = view.findViewById<Button>(R.id.test_fragment_button_view)
        buttonView.text = "Go To first"
        buttonView.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_testFragmentTwo_to_testFragmentOne)
        }
        return view
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}