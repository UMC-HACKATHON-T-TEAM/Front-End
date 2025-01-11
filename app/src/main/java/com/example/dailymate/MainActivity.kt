package com.example.dailymate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dailymate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        // 스플래시에서 전달된 데이터 처리
        val navigateTo = intent.getStringExtra("navigateTo")
        if (navigateTo == "recommend") {
            binding.bottomNavigationView.selectedItemId = R.id.nav_recommend
        }
    }

    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.nav_schedule -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, ScheduleFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_recommend -> {
                    // RecommendSplash 실행
                    val intent = Intent(this, RecommendSplash::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener false
                }
                R.id.nav_fortune -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, FortuneFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, MyPageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
