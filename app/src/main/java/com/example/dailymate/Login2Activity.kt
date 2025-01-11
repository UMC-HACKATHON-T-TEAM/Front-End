package com.example.dailymate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dailymate.databinding.ActivityLogin2Binding

class Login2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 화면에 필요한 UI나 로직을 작성 가능 (예: 환영 메시지)
    }
}