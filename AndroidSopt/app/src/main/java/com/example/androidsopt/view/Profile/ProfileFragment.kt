package com.example.androidsopt.view.Profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.androidsopt.R
import com.example.androidsopt.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        initSettings()
        initTransactionEvent()
        initImage()

        return binding.root
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        childFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit()
        binding.btnFollower.isSelected = true //처음 화면 보여질 시에

        binding.btnFollower.setOnClickListener {

            childFragmentManager.beginTransaction()
                .replace(R.id.container_view, followerFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            binding.btnFollower.isSelected = true;
            binding.btnRepo.isSelected = false;
        }
        binding.btnRepo.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_view, repositoryFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            binding.btnRepo.isSelected = true
            binding.btnFollower.isSelected = false


        }


    }

    private fun initSettings() {

        binding.ibSettings.setOnClickListener {
            val intent = Intent(this@ProfileFragment.context, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initImage() {
        Glide.with(this)
            .load("https://avatars.githubusercontent.com/u/89780201?s=200&v=4")
            .circleCrop()
            .into(binding.imageView)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
