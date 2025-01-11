package com.example.dailymate

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dailymate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // drawableEnd 클릭 이벤트 처리
        binding.loginPasswordEt.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = binding.loginPasswordEt.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (binding.loginPasswordEt.right - drawableEnd.bounds.width())) {
                    isPasswordVisible = !isPasswordVisible

                    if (isPasswordVisible) {
                        binding.loginPasswordEt.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        binding.loginPasswordEt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            null,
                            null,
                            ContextCompat.getDrawable(this, R.drawable.ic_visibility_on),
                            null
                        )
                    } else {
                        binding.loginPasswordEt.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        binding.loginPasswordEt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            null,
                            null,
                            ContextCompat.getDrawable(this, R.drawable.ic_visibility_off),
                            null
                        )
                    }

                    // 커서 위치 유지
                    binding.loginPasswordEt.setSelection(binding.loginPasswordEt.text?.length ?: 0)
                    return@setOnTouchListener true
                }
            }
            false
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.loginIdEt.text.toString().trim()
            val password = binding.loginPasswordEt.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                // 이메일 또는 비밀번호가 비어 있으면 Toast 메시지 표시
                Toast.makeText(this, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // 입력이 완료되면 다음 화면으로 이동
                val login2Intent = Intent(this, Login2Activity::class.java)
                startActivity(login2Intent)

                // 1초 뒤 홈 화면으로 이동
                Handler(Looper.getMainLooper()).postDelayed({
                    val homeIntent = Intent(this, HomeFragment::class.java)
                    startActivity(homeIntent)
                    finish() // 현재 Activity 종료
                }, 1000)
            }
        }
    }
}