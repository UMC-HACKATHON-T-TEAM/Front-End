package com.example.dailymate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dailymate.databinding.ActivityMypageEditBinding

class MyPageEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}