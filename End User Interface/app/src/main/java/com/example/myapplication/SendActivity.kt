package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray

class SendActivity : AppCompatActivity() {
    private lateinit var origin: EditText
    private lateinit var destination: EditText
    private var currentToast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        origin = findViewById(R.id.origin)
        destination = findViewById(R.id.destination)
    }

    /*suspend fun track(): String {
        val client = HttpClient()
        val response = client.get(getString(R.string.server_ip)+getString(R.string.track_package)+packageID.text.toString())
        return response.body()
    }

     */

    fun toast_maketext(text: String){
        currentToast?.cancel()
        currentToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        currentToast?.show()
    }
    fun send_package(v: View?) {
        toast_maketext("Tracking your package from " + origin.text.toString()+" to "+destination.text.toString())
        val intent = Intent(this@SendActivity, TrackingActivity::class.java)
        startActivity(intent)
        /*GlobalScope.launch {
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


}