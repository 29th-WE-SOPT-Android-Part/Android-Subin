package com.example.androidsopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.androidsopt.databinding.ActivityHomeBinding
import com.example.androidsopt.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding :FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
//
        initTransactionEvent()
        initImage()
        binding.btnFollower.isSelected = true
        return binding.root
    }
    private fun initTransactionEvent(){
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        childFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit()

        binding.btnRepo.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_view,repositoryFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            binding.btnRepo.isSelected=true
            binding.btnFollower.isSelected=true


        }

        binding.btnFollower.setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.container_view, followerFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
                    binding.btnFollower.isSelected=true;
                    binding.btnRepo.isSelected=false;
        }
    }



    private fun initImage(){
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






//class ProfileFragment : Fragment() {
//    private var position=FOLLOWER_POSITION
//    private lateinit var binding: ActivityHomeBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding= ActivityHomeBinding.inflate(layoutInflater)
//        initTransactionEvent()
//        setContentView(binding.root)
//    }
//
//    private fun initTransactionEvent(){
//        val followerFragment = FollowerFragment()
//        val repositoryFragment = RepositoryFragment()
//
//        supportFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit()
//
//        binding.btnRepo.setOnClickListener {
//            val transaction = supportFragmentManager.beginTransaction()
//
//            when (position){
//                FOLLOWER_POSITION -> {
//                    transaction.replace(R.id.container_view,repositoryFragment)
//                    position = REPOSITORY_POSITION
//                }
//            }
//            transaction.commit()
//        }
//
//        binding.btnFollower.setOnClickListener{
//            val transaction = supportFragmentManager.beginTransaction()
//
//            when (position){
//                REPOSITORY_POSITION -> {
//                    transaction.replace(R.id.container_view, followerFragment)
//                    position = FOLLOWER_POSITION
//                }
//            }
//            transaction.commit()
//        }
//    }
//
//    companion object {
//        const val FOLLOWER_POSITION = 1
//        const val REPOSITORY_POSITION = 2
//    }
