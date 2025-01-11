package com.example.dailymate

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.dailymate.databinding.ActivityRecommendLoadingBinding

class RecommendSplash : AppCompatActivity() {

    private lateinit var binding: ActivityRecommendLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityRecommendLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3초 후 RecommendFragment로 전환
        Handler(Looper.getMainLooper()).postDelayed({
            // MainActivity로 돌아가면서 RecommendFragment를 표시
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("navigateTo", "recommend")
            startActivity(intent)
            finish() // RecommendSplash 종료
        }, 3000) // 3초 대기
    }
}