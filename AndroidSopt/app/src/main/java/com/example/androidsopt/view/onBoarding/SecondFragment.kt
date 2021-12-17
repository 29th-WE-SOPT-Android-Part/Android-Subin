package com.example.androidsopt.view.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidsopt.R
import com.example.androidsopt.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SecondFragment : Fragment() {

    private  var _binding : FragmentSecondBinding?=null
    private val binding get()= _binding ?: error("Binding이 초기화 되지 않았습니다.")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSecondBinding.inflate(layoutInflater, container,false)

       binding.btnSecond.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
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