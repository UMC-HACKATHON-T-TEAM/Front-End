package com.example.dailymate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailymate.databinding.FragmentRecommendBinding

class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecommendBinding
    private lateinit var adapter: RecommendScheduleRVAdapter

    // 더미 데이터 리스트
    private val scheduleList = listOf(
        Schedules("UMC 해커톤", "기깔나게 1등하기"),
        Schedules("22시 프로젝트 회의", "20시 회의 준비"),
        Schedules("알바", "보건증 챙겨가기")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        // RecyclerView의 레이아웃 매니저 설정
        binding.recommendScheduleRv.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        // RecyclerView 초기화
        adapter = RecommendScheduleRVAdapter(scheduleList)
        binding.recommendScheduleRv.adapter = adapter
    }
}