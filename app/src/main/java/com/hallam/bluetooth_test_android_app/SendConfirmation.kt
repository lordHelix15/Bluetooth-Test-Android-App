package com.hallam.bluetooth_test_android_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hallam.bluetooth_test_android_app.databinding.FragmentSendConfirmationBinding

class SendConfirmation : Fragment() {
    lateinit var binding:FragmentSendConfirmationBinding
lateinit var promptSent:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var bundle = arguments

        val promptSent = bundle?.getString("@string/argumentKey").toString()
        binding = FragmentSendConfirmationBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.sentPrompt.text = promptSent+" has been sent to the Arduino"
        return binding.root

        //return inflater.inflate(R.layout.fragment_send_confirmation, container, false)
    }
}