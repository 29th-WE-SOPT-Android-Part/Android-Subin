# Android-Subin

![github_김수빈_ver1-13](https://user-images.githubusercontent.com/70698151/135754037-394c5c7f-9615-4206-8dc4-df985f512e75.png)


----------


# 🔴 세미나 과제

## 1️⃣Week
* SignInActivity , SignUpActivity, HomeActivity
  * ## SignInActivity
   ```kotlin
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
    ```
    > ###### 공백임을 equals()를 통해 구현 (empty여부로 구현도 가능)
    > ###### binding을 scope으로 묶지 않았지만 다음 과제부터 진행해볼 것
   * ## SignUpActivity
   ```kotlin
       binding= ActivitySignUpBinding.inflate(layoutInflater)
        binding.btnsignup.setOnClickListener{
                if (binding.etId.text.toString().equals("")||binding.etId2.text.toString().equals("")||binding.etName.text.toString().equals("")) {
                    Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_LONG).show()
                }
            else
               finish()
        }

        setContentView(binding.root)
    }
    ```
    > ###### 공백임을 equals()를 통해 구현 (empty여부로 구현도 가능)
    > ###### intent가 아닌 finish()로 스택에 화면이 쌓이지 않도록 구현
    > ###### binding을 scope으로 묶지 않았지만 다음 과제부터 진행해볼 것
   
   
