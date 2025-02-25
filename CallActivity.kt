package com.example.mca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mca.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    private lateinit var callBinding: ActivityCallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_call)
        callBinding=ActivityCallBinding.inflate(layoutInflater)
        setContentView(callBinding.root)

        callBinding.btnCall.setOnClickListener {
            if(callBinding.edtNumber.text!!.isNotEmpty())
            {
                if (callBinding.edtNumber.text!!.length  <=10 && callBinding.edtNumber.text!!.length >=10)
                {
                    var intent=Intent(Intent.ACTION_CALL)
                    intent.setData(Uri.parse("tel:${callBinding.edtNumber.text.toString()}"))
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Please enter valid number",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"Please fill your field",Toast.LENGTH_LONG).show()
            }
        }
    }
}