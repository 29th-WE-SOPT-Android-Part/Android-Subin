package com.example.androidsopt.view.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidsopt.R
import com.example.androidsopt.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private  var _binding : FragmentThirdBinding?=null
    private val binding get()= _binding ?: error("Binding이 초기화 되지 않았습니다.")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentThirdBinding.inflate(layoutInflater, container,false)

        binding.btnThird.setOnClickListener{
            findNavController().navigate(R.id.action_thirdFragment_to_signInActivity)
            (activity as OnBoarding).finish()
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