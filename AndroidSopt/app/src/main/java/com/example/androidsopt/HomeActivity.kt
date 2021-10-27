package com.example.androidsopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsopt.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var position=FOLLOWER_POSITION
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        initTransactionEvent()
        setContentView(binding.root)
    }

    private fun initTransactionEvent(){
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit()

        binding.btnRepo.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position){
                FOLLOWER_POSITION -> {
                    transaction.replace(R.id.container_view,repositoryFragment)
                    position = REPOSITORY_POSITION
                }
            }
            transaction.commit()
        }

        binding.btnFollower.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()

            when (position){
                REPOSITORY_POSITION -> {
                    transaction.replace(R.id.container_view, followerFragment)
                    position = FOLLOWER_POSITION
                }
            }
            transaction.commit()
        }
    }

    companion object {
        const val FOLLOWER_POSITION = 1
        const val REPOSITORY_POSITION = 2
    }
}