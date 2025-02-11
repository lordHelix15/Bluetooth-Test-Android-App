package com.hallam.bluetooth_test_android_app

import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hallam.bluetooth_test_android_app.databinding.ActivityMainBinding
import com.hallam.bluetooth_test_android_app.databinding.FragmentSendConfirmationBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var promptsList:ArrayList<String>
    private lateinit var fragOpened:String

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("testLogger","Initalize onCreate")
        promptsList =ArrayList<String>()
        setPromptList()
        fragOpened = ""

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.instructions.setOnClickListener {
            Log.i("testLogger","Triggered instructions_Onclick")
            resetPromptList()
            var listOfPrompts="List of Usable Prompts"

            for(prompt in promptsList){
                listOfPrompts+="\n - $prompt"
            }

            val bundle=Bundle()
            bundle.putString("@string/argumentKey",listOfPrompts)
            val listFrag = PromptList()
            listFrag.arguments = bundle
            fragmentLoader(listFrag)
            fragOpened = "instruction"

            Toast.makeText(this,fragOpened,Toast.LENGTH_SHORT).show()
        }

        binding.sendPrompt.setOnClickListener{
            Log.i("testLogger","Triggered sendPrompt_Onclick")

            var promptSent=""
            val userInput = binding.inputPrompt.getText().toString()
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

        }
        Log.i("testLogger","Created sendPrompt_Onclick")
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.i("testLogger","onCreate Fully Initialized")
    }
    //Setting the promptList so the user able to send the prompt to the bluetooth module that is connected to the Arduino.
    // Bluetooth Module: HC-05 chip
    private fun setPromptList(){
        Log.i("testLogger","Triggered setPromptList()")
        promptsList.add("startTimer")
        promptsList.add("stopTimer")
        promptsList.add("clearLCD")
        promptsList.add("cycleEndCharacter")
        //promptsList.add("")
        //promptsList.add("")
        Log.i("testLogger"," setPromptList() Finnished")
    }

    private fun resetPromptList(){
        Log.i("testLogger","Triggered resetPromptList()")
        promptsList.clear()
        setPromptList()
        Log.i("testLogger","resetPromptList() finished")
    }
//This function allows continous use of sending a message over bluetooth connection
    // Placeholder Function
    private fun sendMsgBluetooth():Boolean{
        var IsSent:Boolean
        val random:Random
        try {
            random =Random()
            IsSent = true;
            if(random.nextInt(1)==1){
                throw Exception()
            }
        }catch (ex:Exception){
            IsSent = false
        }
        return IsSent;
    }

    //Load Fragments
    private fun fragmentLoader(fragLoad: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.FragLayout, fragLoad)
        ft.commit()
    }
}
