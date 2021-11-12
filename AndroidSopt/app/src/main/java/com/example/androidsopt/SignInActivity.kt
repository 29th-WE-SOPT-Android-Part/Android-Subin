package com.example.androidsopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidsopt.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    //intent값 가져오기
    private lateinit var getResultTextView: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        binding.btnLogin.setOnClickListener {
            initNetwork()
        }

        SignUpBtnEvent()

        setContentView(binding.root)

    }

    private fun initNetwork() {
        val requestSignInData = RequestSignInData(
                id = binding.etId.text.toString(),
                password = binding.etId2.text.toString()
        )

        val call: Call<ResponseSignInData> = ServiceCreator.signinService.postLogin(requestSignInData)

        call.enqueue(object : Callback<ResponseSignInData> {
            override fun onResponse(
                    call: Call<ResponseSignInData>,
                    response: Response<ResponseSignInData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else
                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ResponseSignInData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }



    private fun SignUpBtnEvent() {
        binding.btnSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}
//val id: String =binding.etId.text.toString()
////        val pw=binding.etId2.text.toString()
//val intent= Intent(this, SignUpActivity::class.java)
////회원가입 버튼 누르면 SignUpActivity로 이동
//val intent2=Intent(this, HomeActivity::class.java)
//
//
//binding.btnSign.setOnClickListener{
//    startActivity(intent)
//}
//
//binding.btnLogin.setOnClickListener{
//    if (binding.etId.text.toString().equals("")||binding.etId2.text.toString().equals("")) {
//        Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
//    }
//    else {
//        Toast.makeText(this, binding.etId.text.toString() + " 님 환영합니다.", Toast.LENGTH_SHORT)
//            .show()
//        startActivity(intent2)
//    }
//}
//setContentView(binding.root)


// week1- lv2 intent
//class SignInActivity : AppCompatActivity() {
//    private lateinit var binding: ActivitySignInBinding
//
//    //intent값 가져오기
//    private lateinit var getResultTextView: ActivityResultLauncher<Intent>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySignInBinding.inflate(layoutInflater)
//
//        setContentView(binding.root)
//        LoginBtnEvent()
//        SignUpBtnEvent()
//    }
//
//    private fun LoginBtnEvent() {
//        val intentHome = Intent(this, HomeActivity::class.java)
//        binding.apply {
//            btnLogin.setOnClickListener {
//                val userId = etId.text.toString()
//                val userPW = etId2.text.toString()
//
//                if (userId.isNotEmpty() && userPW.isNotEmpty()) {
//                    startActivity(intentHome)
//                    Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT)
//                            .show()
//                } else {
//                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//    private fun SignUpBtnEvent() {
//        val start = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult -> }
//        binding.btnSign.setOnClickListener {
//            start.launch(Intent(this, SignUpActivity::class.java))
//        }
//
//        if (intent.hasExtra("id") && intent.hasExtra("pw")) {
//            val id = intent.getStringExtra("id")
//            val pw = intent.getStringExtra("pw")
//
//            binding.etId.setText(id)
//            binding.etId2.setText(pw)
//        }
//    }
//
//}
//