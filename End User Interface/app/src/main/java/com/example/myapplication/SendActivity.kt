package com.example.myapplication

import android.app.AlertDialog
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
    private lateinit var label: EditText
    private var currentToast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        origin = findViewById(R.id.origin)
        destination = findViewById(R.id.destination)
        label = findViewById(R.id.label)
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
    fun register_package(v: View?) {
        val popupView = layoutInflater.inflate(R.layout.activity_confirmation_popup, null)

        // Create the dialog
        val builder = AlertDialog.Builder(this)
        builder.setView(popupView)
        val confirmButton = popupView.findViewById<Button>(R.id.confirmButton)
        val dialog = builder.create()
        dialog.show()

        confirmButton.setOnClickListener {
            runOnUiThread {
                origin.text.clear()
                destination.text.clear()
                label.text.clear()
            }
            dialog.dismiss()
        }

        /*
        ***Register to server, to be implmented***

        GlobalScope.launch {
            val str = register()
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
    fun home(v: View) {
        val intent = Intent(this@SendActivity, ChooseActivity::class.java)
        startActivity(intent)
    }


}