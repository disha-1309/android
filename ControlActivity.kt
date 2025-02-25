package com.example.mca

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mca.databinding.ActivityControlBinding

class ControlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityControlBinding  // Corrected variable name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize ViewBinding
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle checkbox state change
        binding.checkTermsCondition.setOnCheckedChangeListener { _, isChecked ->
            binding.btnSubmit.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Handle radio button selection
        binding.rbGender.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbMale -> Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show()
                R.id.rbFemale -> Toast.makeText(this, "Female Selected", Toast.LENGTH_SHORT).show()
            }
        }

        // Optional: Handle Submit Button Click
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, "Form Submitted!", Toast.LENGTH_SHORT).show()
        }

        // Fix for edge-to-edge layout handling
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
