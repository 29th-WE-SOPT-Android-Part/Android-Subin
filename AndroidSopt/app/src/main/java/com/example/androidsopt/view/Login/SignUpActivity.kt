package com.example.androidsopt.view.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidsopt.network.ServiceCreator
import com.example.androidsopt.data.RequestSignUpData
import com.example.androidsopt.data.ResponseSignUpData
import com.example.androidsopt.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.apply {
            btnsignup.setOnClickListener {
                initNetwork()
                finish()
            }
        }
    }

    private fun initNetwork() {
        val requestSignupData = RequestSignUpData(
                id = binding.etId.text.toString(),
                name = binding.etName.text.toString(),
                password = binding.etId2.text.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreator.signupService.postSignup(requestSignupData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignUpActivity, "${data?.email}님 회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkText", "error:$t")
            }
        })
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


//private fun btnEvent(){
//    val intent = Intent(this, SignInActivity::class.java)
//    binding.apply{
//        btnsignup.setOnClickListener{
//            val userName = etName.text.toString()
//            val userId = etId.text.toString()
//            val userPW = etId2.text.toString()
//
//            if (userName.isNotEmpty() && userId.isNotEmpty() && userPW.isNotEmpty()){
//                intent
//                        .putExtra("id", userId)
//                        .putExtra("pw", userPW)
//                startActivity(intent)
//                finish()
//
//            } else {
//                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }
//}