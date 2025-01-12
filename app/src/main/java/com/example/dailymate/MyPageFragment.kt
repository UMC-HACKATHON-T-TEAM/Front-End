package com.example.dailymate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.dailymate.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        // ic_edit ImageView 클릭 시 EditActivity로 이동
        val editIcon: ImageView = view.findViewById(R.id.imageView)
        editIcon.setOnClickListener {
            val intent = Intent(activity, MyPageEditActivity::class.java)
            startActivity(intent)
        }

        return view

    }
}