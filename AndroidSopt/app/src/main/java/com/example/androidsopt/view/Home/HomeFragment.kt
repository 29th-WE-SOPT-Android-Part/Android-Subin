package com.example.androidsopt.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidsopt.adapter.HomeFollowViewPagerAdapter
import com.example.androidsopt.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding ?=null
    private val binding get()= _binding ?: error("Binding이 초기화 되지 않았습니다.")
    private lateinit var homeFollowViewPagerAdapter: HomeFollowViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter(){
        val fragmentList=listOf(HomeFollowerFragment(), HomeFollowingFragment())

        homeFollowViewPagerAdapter= HomeFollowViewPagerAdapter(this)
        homeFollowViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHomefragment.adapter=homeFollowViewPagerAdapter

    }

    private fun initTabLayout(){
        val tabLabel=listOf("팔로잉","팔로워")
// tablayout이랑 viepager2 연결
        TabLayoutMediator(binding.homeTablayout,binding.vpHomefragment){
                tab,position->
            tab.text=tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}