package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChooseIdentityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_identity)
    }
    fun shipping(v: View){
        val intent = Intent(this@ChooseIdentityActivity, ChooseActivity::class.java)
        startActivity(intent)
    }
    fun user(v: View){
        val intent = Intent(this@ChooseIdentityActivity, InputActivity::class.java)
        startActivity(intent)
    }
}