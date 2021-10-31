package com.example.androidsopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidsopt.databinding.FragmentHomeFollowerBinding

class HomeFollowerFragment : Fragment() {

    private lateinit var binding: FragmentHomeFollowerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeFollowerBinding.inflate(inflater, container, false)
        return binding.root

    }
}