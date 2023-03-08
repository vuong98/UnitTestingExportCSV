package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WriteTestcasesToJson.readToJson("")

          val nameMethod = WriteTestcasesToJson.javaClass.methods

          Log.d(Constants.DEBUG_LOG, "${nameMethod[0].name}" )
         // WriteTestcasesToJson.writeToCSV("result.csv","app/src/main/assets/","");
    }
}