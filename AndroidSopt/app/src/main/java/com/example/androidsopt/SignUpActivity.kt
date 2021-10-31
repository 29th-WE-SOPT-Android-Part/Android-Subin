package com.example.androidsopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidsopt.databinding.ActivitySignInBinding
import com.example.androidsopt.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)
        btnEvent()
    }
    private fun btnEvent(){
        val intent = Intent(this, SignInActivity::class.java)
        binding.apply{
            btnsignup.setOnClickListener{
                val userName = etName.text.toString()
                val userId = etId.text.toString()
                val userPW = etId2.text.toString()

                if (userName.isNotEmpty() && userId.isNotEmpty() && userPW.isNotEmpty()){
                    intent
                        .putExtra("id", userId)
                        .putExtra("pw", userPW)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    }


//activity_sign_up
//binding.btnsignup.setOnClickListener{
//    if (binding.etId.text.toString().equals("")||binding.etId2.text.toString().equals("")||binding.etName.text.toString().equals("")) {
//        Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_LONG).show()
//    }
//    else
//        finish()
//}