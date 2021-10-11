## Android-Subin

![github_김수빈_ver1-13](https://user-images.githubusercontent.com/70698151/135754037-394c5c7f-9615-4206-8dc4-df985f512e75.png)


----------


## 🔴 세미나 과제

### 1️⃣Week
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
    > ###### 로그인 시 아이디 혹은 비밀번호 칸 중 하나라도 입력되지 않았으면 toast.message로 "로그인 실패" 알림
    > ###### 로그인 성공하면 아이디 edittext 값을 string으로 가져와 "아이디+ 환영합니다"로 알림
    > ###### 로그인 성공 -> 클릭하면 HomeActivity 자기소개 화면으로 화면 이동
    > ###### ❗ binding을 scope으로 묶지 않았지만 다음 과제부터 진행해볼 것!!
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
    > ###### 아이디, 비밀번호, 이름 중 하나라도 입력되지 않았으면 toast.message로 "입력되지 않은 정보 존재" 알림
    > ###### intent가 아닌 finish()로 스택에 화면이 쌓이지 않도록 구현
    > ###### ❗ binding을 scope으로 묶지 않았지만 다음 과제부터 진행해볼 것
    > ###### ❗ 변수를 만들어 if조건문 간결하게 구현해볼 것
    ****
  
    #### ✔ 실행화면
    
|로그인-홈|회원가입|
|:------:|:---:|
|<img src=https://user-images.githubusercontent.com/62291759/136788922-abb6ffa9-12d4-402d-a546-d11d6a192664.gif width="200" height="450">| <img src=https://user-images.githubusercontent.com/62291759/136788947-5da8bfb2-bae7-464c-8551-7eafb3767ca5.gif width="200" height="450">|
###### 로딩이 오래걸려 자판이 보이지 않는 점 양해부탁드려오😥

  
   #### 📌 1️⃣Week 배운내용 및 성장한 내용
   ##### * binding을 통해 간결한 코드 작성
   ##### * constraintlayout의 특징을 알게되며 다른 layout보다 자유자재로 item이나 textview등을 배치할 수 있는 장점을 알게됨.
   ##### * intent와 finish의 차이점
   ##### * 둥근 모서리를 가진 edittext테두리 
   
     ```
      <shape xmlns:android="http://schemas.android.com/apk/res/android"
      android:shape="rectangle">
        <stroke
            android:width="2dp"
            android:color="#FF00CC" />
        <corners android:radius="4dp"/>
        <solid
            android:color="#FFFFFF" />

        </shape>

      ```
   #### 📝 To-do
   ##### 1. binding scope으로 구현하여 간결하게 코드짜기
   ##### 2. 변수 활용 적극적으로!
   ##### 3. 앞으로 level 2, level 3 과제 하기
   ##### 4. 개념 설명 기록하기
    
   
