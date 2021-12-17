package com.example.androidsopt.view.Profile


import android.content.SharedPreferences
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsopt.databinding.ActivitySettingBinding


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

            val sp : SharedPreferences = getSharedPreferences("USER_AUTH", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sp.edit()
            editor.remove("USER_AUTH")
            editor.clear()
            editor.commit()

        }
    }
}

