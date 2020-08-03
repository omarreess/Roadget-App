package com.omaressam.rode

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Check if it first time to open app to get intro
        checkToMakeIntro()


    }

    fun checkToMakeIntro(){
         val sharedPreferences: SharedPreferences = this.getSharedPreferences("intro,keeplogin" , Context.MODE_PRIVATE )

        if( sharedPreferences.contains("first time"))
        {//not 1st time
            }

        else
        {     //1st time

            val i = Intent(applicationContext, IntroActivity::class.java)
            startActivity(i)
            finish()

        }



    }




}