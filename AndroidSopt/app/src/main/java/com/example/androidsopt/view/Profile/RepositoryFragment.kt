package com.example.androidsopt.view.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidsopt.adapter.RepositoryAdapter
import com.example.androidsopt.data.RepoData
import com.example.androidsopt.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {

    private var _binding: FragmentRepositoryBinding?=null
    private val binding get() = _binding ?: error ("Binding이 초기화 되지 않았습니다!")
    private lateinit var repositoryAdapter: RepositoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRepositoryBinding.inflate(layoutInflater,container,false)
        initAdapter()
        return binding.root
        //return inflater.inflate(R.layout.fragment_repository, container, false)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    private fun initAdapter() {
        //adapter 초기화
        repositoryAdapter = RepositoryAdapter()
        //adatper와 recyclerview 연동
        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repoList.addAll(
            listOf(
                RepoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제과제과제과제과제"),
                RepoData("넥스트 안드 과제", "안드로이드 스터디 과제"),
                RepoData("서버 과제 레포지토리", "기획 파트장"),
                RepoData("솝탁 과제 레포지토리", "파이썬 알고리즘 과제"),
                RepoData("웹 과제 레포지토리", "웹 web 웹 web"),
                RepoData("ios 과제 레포지토리", "사과 파트 과제")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }
}