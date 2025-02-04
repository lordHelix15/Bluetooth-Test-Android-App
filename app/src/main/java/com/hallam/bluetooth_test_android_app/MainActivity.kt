package com.hallam.bluetooth_test_android_app

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hallam.bluetooth_test_android_app.databinding.ActivityMainBinding
import com.hallam.bluetooth_test_android_app.databinding.FragmentSendConfirmationBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var PromptList:ArrayList<String>
    private lateinit var fragOpened:String
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.instructions.setOnClickListener {
            var listOfPrompts="List of Usable Prompts"

            for(prompt in PromptList){
                listOfPrompts+="\n - ${prompt}"
            }

            fragmentLoader(PromptList())
            fragOpened = "instruction"
            Toast.makeText(this,fragOpened,Toast.LENGTH_SHORT).show()
        }
        binding.sendPrompt.setOnClickListener{
            //
            if(binding.textInputEditText.getText().toString()==""){
                Toast.makeText(this,"Propmt Input has an invalid Prompt Please Look at the Prompts in the @string/instructBtn",Toast.LENGTH_SHORT).show()

            }

            fragOpened = "sendPrompt"
            Toast.makeText(this,fragOpened,Toast.LENGTH_SHORT).show()

            //if(binding.textInputEditText.text)
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun fragmentLoader(fragLoad: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.FragLayout, fragLoad)
        ft.commit()
    }
}
