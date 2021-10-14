package com.example.androidsopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidsopt.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)

        val id=binding.etId.text.toString()
//        val pw=binding.etId2.text.toString()
        val intent= Intent(this, SignUpActivity::class.java)
        //회원가입 버튼 누르면 SignUpActivity로 이동
        val intent2=Intent(this, HomeActivity::class.java)


        binding.btnSign.setOnClickListener{
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            if (binding.etId.text.toString().equals("")||binding.etId2.text.toString().equals("")) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, binding.etId.text.toString() + " 님 환영합니다.", Toast.LENGTH_SHORT)
                    .show()
                startActivity(intent2)
            }
        }
        setContentView(binding.root)
    }
    }

