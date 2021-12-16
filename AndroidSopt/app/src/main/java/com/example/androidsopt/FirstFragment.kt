package com.example.androidsopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidsopt.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private  var _binding :FragmentFirstBinding ?=null
    private val binding get()= _binding ?: error("Binding이 초기화 되지 않았습니다.")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentFirstBinding.inflate(layoutInflater, container,false)

        binding.btnFirst.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return binding.root

//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    }
