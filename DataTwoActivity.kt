package com.example.mca

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mca.databinding.ActivityDataTwoBinding

class DataTwoActivity : AppCompatActivity() {
    private lateinit var dataTwoBinding: ActivityDataTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataTwoBinding = ActivityDataTwoBinding.inflate(layoutInflater)
        setContentView(dataTwoBinding.root)

        var name : String = intent.getStringExtra("DATA") as String

        dataTwoBinding.txtContent.text = name
    }
}