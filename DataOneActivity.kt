package com.example.mca

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mca.databinding.ActivityDataOneBinding

class DataOneActivity : AppCompatActivity() {
    private lateinit var dataOneBinding: ActivityDataOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataOneBinding = ActivityDataOneBinding.inflate(layoutInflater)
        setContentView(dataOneBinding.root)


        var data : String = dataOneBinding.edtUserName.text.toString()

        dataOneBinding.btnSendContent.setOnClickListener{
          // startActivity(Intent(this,DataTwoActivity::class.java).putExtra("DATA",data))
            if(dataOneBinding.edtUserName.text!!.isEmpty()){
                Toast.makeText(this,"Please Enter Value....!",Toast.LENGTH_LONG).show()
            }
            else{
                startActivity(Intent(this,DataTwoActivity::class.java).putExtra("DATA",dataOneBinding.edtUserName.text.toString()))
            }

            var intent : Intent
            intent = Intent(Intent.ACTION_SEND)
            intent.setAction(Intent.EXTRA_TEXT)
            intent.setType("text/plain")
            startActivity(intent)
        }

        }
    }
