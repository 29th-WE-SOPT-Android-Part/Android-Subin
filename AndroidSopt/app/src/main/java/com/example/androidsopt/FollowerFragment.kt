package com.example.androidsopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidsopt.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    // adapter 초기화
    private lateinit var followerAdapter : FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater,container,false)
        initAdapter()
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun initAdapter() {
        //adapter 초기화
        followerAdapter = FollowerAdapter()
        //adatper와 recyclerview 연동
        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData("김수빈", "안드로이드"),
                UserData("문다빈", "안드로이드 파트장"),
                UserData("김현아", "기획 파트장"),
                UserData("이성현", "디자인 파트장"),
                UserData("김우영", "서버 파트장"),
                UserData("김의진", "웹 파트장")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
}
