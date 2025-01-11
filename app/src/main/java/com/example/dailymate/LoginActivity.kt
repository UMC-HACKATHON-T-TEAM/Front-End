package com.example.dailymate

import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
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
    }
}