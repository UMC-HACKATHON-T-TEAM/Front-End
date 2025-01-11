package com.example.dailymate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dailymate.databinding.FragmentFortuneBinding

class FortuneFragment : Fragment() {

    private lateinit var binding: FragmentFortuneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFortuneBinding.inflate(inflater, container, false)

        return binding.root
    }
}