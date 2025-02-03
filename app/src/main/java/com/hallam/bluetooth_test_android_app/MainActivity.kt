package com.hallam.bluetooth_test_android_app

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hallam.bluetooth_test_android_app.databinding.ActivityMainBinding
import com.hallam.bluetooth_test_android_app.databinding.FragmentSendConfirmationBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var instructions:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)


        binding.instructions.setOnClickListener {
            fragmentLoader(PromptList())
        }
        binding.sendPrompt.setOnClickListener{

            fragmentLoader(SendConfirmation())
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun fragmentLoader(fragLoad: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.FragLayout, fragLoad)
        ft.commit()
    }
}
