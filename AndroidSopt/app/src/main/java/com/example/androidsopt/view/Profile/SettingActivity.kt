package com.example.androidsopt.view.Profile
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsopt.databinding.ActivitySettingBinding
import com.example.androidsopt.view.Login.SharedPreferences
import com.example.androidsopt.view.Login.SignInActivity
import android.content.Context



class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)

        initClickEvent()
        setContentView(binding.root)
    }

    private fun initClickEvent() {
        binding.tvCancel.setOnClickListener {
            SharedPreferences.removeAutoLogin(this)
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

