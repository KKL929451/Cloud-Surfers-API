package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PackageListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_list)
    }


    private var currentToast: Toast? = null
    fun toast_maketext(text: String){
        currentToast?.cancel()
        currentToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        currentToast?.show()
    }
    fun home(v: View) {
        val intent = Intent(this@PackageListActivity, ChooseActivity::class.java)
        startActivity(intent)
    }
    fun track_package(v: View?) {
        val packageID = v?.tag.toString()
        toast_maketext("Tracking your package $packageID")
        val intent = Intent(this@PackageListActivity, TrackingActivity::class.java)
        startActivity(intent)
    }
}