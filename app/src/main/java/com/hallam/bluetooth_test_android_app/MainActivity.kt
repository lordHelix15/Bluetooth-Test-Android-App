package com.hallam.bluetooth_test_android_app

import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hallam.bluetooth_test_android_app.databinding.ActivityMainBinding
import com.hallam.bluetooth_test_android_app.databinding.FragmentSendConfirmationBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var promptsList:ArrayList<String>
    private lateinit var fragOpened:String

    override fun onStart(){
        setPromptList()
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.instructions.setOnClickListener {
            var listOfPrompts="List of Usable Prompts"

            for(prompt in promptsList){
                listOfPrompts+="\n - $prompt"
            }

            val bundle=Bundle()
            bundle.putString("","")
            val listFrag = PromptList()
            listFrag.arguments = bundle
            fragmentLoader(listFrag)
            fragOpened = "instruction"

            Toast.makeText(this,fragOpened,Toast.LENGTH_SHORT).show()
        }
        binding.sendPrompt.setOnClickListener{
            //
            var promptSent=""
            val userInput = binding.textInputEditText.getText().toString()
            if(userInput==""){
                Toast.makeText(this,"Prompt Input has an invalid Prompt Please Look at the Prompts in the @string/instructBtn",Toast.LENGTH_SHORT).show()
            }else{
                if(promptsList.contains(userInput)){
                    for(prmt in promptsList){
                        if(prmt.equals(userInput)){

                        }
                    }
                    //End
                    val bundle = Bundle()
                    bundle.putString("sent","$promptSent has been sent to ")
                    val loadFrag = SendConfirmation()
                    loadFrag.arguments = bundle
                    fragmentLoader(loadFrag )
                }
            }

            fragOpened = "sendPrompt"
            Toast.makeText(this,fragOpened,Toast.LENGTH_SHORT).show()

            //if(binding.textInputEditText.text)
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun setPromptList(){
        promptsList.add("startTimer()")
        promptsList.add("clearLCD()")
    }
    /*
    private fun resetPromptList(){
        promptsList.clear()
        setPromptList()
    }
     */
    //Load Fragments
    private fun fragmentLoader(fragLoad: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.FragLayout, fragLoad)
        ft.commit()
    }
}
