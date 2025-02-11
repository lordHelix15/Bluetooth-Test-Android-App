package com.hallam.bluetooth_test_android_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hallam.bluetooth_test_android_app.databinding.FragmentPromptListBinding


class PromptList : Fragment() {
    lateinit var promptList:String
    lateinit var binding: FragmentPromptListBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPromptListBinding.inflate(layoutInflater)
        val promptBundle = arguments
        promptList = promptBundle?.getString("@string/argumentKey").toString()
        binding.promptList.text = promptList

    return binding.root
    //return inflater.inflate(R.layout.fragment_prompt_list, container, false)
    }
}