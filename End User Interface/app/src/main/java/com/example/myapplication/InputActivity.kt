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

class InputActivity : AppCompatActivity() {
    private lateinit var packageID: EditText
    private var currentToast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        packageID = findViewById(R.id.PackageID)
    }

    suspend fun track(): String {
        val client = HttpClient()
        val response = client.get(getString(R.string.server_ip)+getString(R.string.track_package)+packageID.text.toString())
        return response.body()
    }

    fun toast_maketext(text: String){
        currentToast?.cancel()
        currentToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        currentToast?.show()
    }
    fun track_package(v: View?) {
        GlobalScope.launch {
            val str = track()
            runOnUiThread {
                if(str=="Correct"){
                    toast_maketext("Tracking your package " + packageID.text.toString())
                    val intent = Intent(this@InputActivity,     CustomerTrackingActivity::class.java)
                    startActivity(intent)
                }
                else{
                    toast_maketext("Cannot find your package")
                }

            }
        }
    }
    fun logout(v: View){
        val intent = Intent(this@InputActivity, ChooseIdentityActivity::class.java)
        startActivity(intent)
    }
}