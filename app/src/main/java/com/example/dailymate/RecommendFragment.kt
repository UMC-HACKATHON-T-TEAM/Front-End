package com.example.dailymate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordBinding.inflate(inflater, container, false)

        userPreferences = MyApplication.getUser()
        val token = userPreferences.getString("jwt", "") ?: ""

        binding.recordPlusBtn.setOnClickListener {
            // 바텀시트 클릭 이벤트 처리
            showBottomSheet()
        }

        // RecyclerView 설정
        setupRecyclerView()

        if (token.isNotEmpty()) {
            fetchPlantList(token)
        }

        return binding.root
    }
}