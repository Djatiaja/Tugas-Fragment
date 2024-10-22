package com.example.tugasfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasfragment.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            usernameText.setText(intent.getStringExtra("username"))
            emailText.setText(intent.getStringExtra("email"))
            fullanameText.setText(intent.getStringExtra("fullname"))
            passwordText.setText(intent.getStringExtra("password"))
        }
    }
}