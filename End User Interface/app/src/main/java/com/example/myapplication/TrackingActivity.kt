package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TrackingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracking)
        /*
         ***Fetch data from Flask server, to be implmented***

         GlobalScope.launch {
            val str = track()
            runOnUiThread {
                if(str=="Correct"){
                    toast_maketext("Tracking your package " + packageID.text.toString())
                    val intent = Intent(this@InputActivity, TrackingActivity::class.java)
                    startActivity(intent)
                }
                else{
                    toast_maketext("Cannot find your package")
                }

            }
         }

        */
    }
    suspend fun track(): String {
        val client = HttpClient()
        val response = client.get(getString(R.string.server_ip)+getString(R.string.track_package)+"packageID")
        return response.body()
    }
    fun home(v: View) {
        val intent = Intent(this@TrackingActivity, ChooseActivity::class.java)
        startActivity(intent)
    }

}