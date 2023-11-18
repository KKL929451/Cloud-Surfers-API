package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
    }
    fun send(v: View){
        val intent = Intent(this@ChooseActivity, SendActivity::class.java)
        startActivity(intent)
    }
    fun track(v: View){
        val intent = Intent(this@ChooseActivity, PackageListActivity::class.java)
        startActivity(intent)
    }
    fun logout(v: View){
        val intent = Intent(this@ChooseActivity, ChooseIdentityActivity::class.java)
        startActivity(intent)
    }

}