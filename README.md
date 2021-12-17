## Android-Subin

![github_김수빈_ver1-13](https://user-images.githubusercontent.com/70698151/135754037-394c5c7f-9615-4206-8dc4-df985f512e75.png)


----------


## 🔴 세미나 과제
### 📝목차
[1️⃣Week](#week1-assignment)

[2️⃣Week](#week2-assignment)

[3️⃣Week](#week3-assignment)

[4️⃣Week](#week4-assignment)

[7️⃣Week](#week7-assignment)

----

### 1️⃣Week
#### Week1 assignment
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
    
 ----
### 2️⃣Week
#### Week2 assignment
* FollowerFragment , RepositoryFragment, HomeActivity
  * ## FollowerRecyclerView
    ```kotlin
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_follower"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:itemCount="4"
        tools:listitem="@layout/item_sample_list" />
    ```
    
   * ## FollowerFragment
     ```kotlin
              class FollowerFragment : Fragment() {
             private var _binding : FragmentFollowerBinding? = null
             private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
             // adapter 초기화
             private lateinit var followerAdapter : FollowerAdapter

             override fun onCreateView(
                 inflater: LayoutInflater, container: ViewGroup?,
                 savedInstanceState: Bundle?
             ): View? {
                 _binding = FragmentFollowerBinding.inflate(layoutInflater,container,false)
                 initAdapter()
                 return binding.root

             }

             override fun onDestroyView() {
                 super.onDestroyView()
                 _binding=null
             }

             private fun initAdapter() {
                 //adapter 초기화
                 followerAdapter = FollowerAdapter()
                 //adatper와 recyclerview 연동
                 binding.rvFollower.adapter = followerAdapter

                 followerAdapter.userList.addAll(
                     listOf(
                         UserData("김수빈", "안드로이드"),
                         UserData("문다빈", "안드로이드 파트장"),
                         
                        "UserData 데이터 삽입 내용"
                     )
                 )
                 followerAdapter.notifyDataSetChanged()
             }
         }
     ```
    * ## FollowerAdapter
      ```kotlin
     
            class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
                val userList = mutableListOf<UserData>()

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
                    val binding = ItemSampleListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,false
                    )
                    return FollowerViewHolder(binding)
                }

                override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
                   holder.onBind(userList[position])
                }

                override fun getItemCount(): Int = userList.size

                // Binding 객체를 생성자로 가지는 ViewHolder 클래스 생성
                class FollowerViewHolder(private val binding: ItemSampleListBinding)
                    : RecyclerView.ViewHolder(binding.root){
                        fun onBind(data : UserData){
                            binding.tvName.text=data.name
                            binding.tvIntroduce.text=data.introduction
                        }
                    }
            }
       ```
     <details>
       <summary>📌 FollowerRecyclerView 설명</summary>
        <div markdown="1">
         
           1) "팔로워 목록" 버튼 클릭시 팔로워 목록을 linearlayout으로 보여주기
         
           2) UserData data class를 만들어 name과 introduction을 만들어줌 
         
           3) data를 활용해 followeradapter에서 " val userList = mutableListOf<UserData>() " 리스트를 만들어 데이터 삽입
         
           4) adapter : 데이터 가져오기 , fragment : adapter와 recyclerview 연동 및 데이터 삽입
        
         </div>
     </details>
 
  * ## RepositoryRecyclerView
    ```kotlin
           <androidx.recyclerview.widget.RecyclerView
                  android:id="@+id/rv_repository"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  android:layout_marginStart="10dp"
                  android:layout_marginEnd="10dp"
                  app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:spanCount="2"
                  tools:itemCount="4"
                  tools:listitem="@layout/item_repository" />
    ```
     ##### 1). layoutManger로 "Grid Layout"으로 만들기 

     ##### 2). spanCount와 itemCount로 개수 정하기

     ##### 3). RepositoryAdapter, Fragment역시 Follower와 코드 유사.
 
   * ## HomeActivity
      ```kotlin
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
      ```
 
     ##### 1). default로 "FollowerRecyclerView" 담은 Fragment보여주기 --> position값에 따라 transaction.replace() 변경
   
     ##### 2). "레포지토리 목록" 버튼(btnRepo) 누르면 "ropositoryFragment"로 전환
 
   * ## 📲 실행화면
    
|Home화면|
|:------:|
|<img src=https://user-images.githubusercontent.com/62291759/138426781-6179a2b6-5c7e-4807-a0f5-c176d679468a.gif width="200" height="450">| 
 
 
 #### 📌 2️⃣Week 배운내용 및 성장한 내용
 ##### * 목록을 나타내기 위해서 전에 개발할 때는 recyclerview활용하지 않았는데 이번 과제를 통해 재생산이 되는 이 뷰 장점을 알게 됨.  
 ##### * Fragment를 활용하면 한 화면에 다양한 동작을 갖는 뷰를 구현할 수 있다는 점을 알게 됨.
 ##### * Adapter : viewHolder를 생성하고 ItemLayout을 ViewHolder에 넘겨준다.
 ##### * onBind() 함수는 ViewHolder가 가진 View에 Adapter로 부터 전달받은 데이터를 붙여준다.
 ##### * 시험기간이라 역시나,,,LV.1 과제만 해서 아쉽,,, 셤끝나고 LV2,LV3 도전 ❗
 
 #### 📝 To-do
 ##### 1. Adatper와 Fragment 그리고 layout에 대해 복습할 것
 ##### 2. level 2, level 3 과제 하기
 ##### 3. 개념 설명 기록하기
 
----
 
### 3️⃣Week
#### Week3 assignment
   
   ### ✔Level 1
 
   * ####  Button, EditText Design
 
     * ##### button 클릭시 글자 색 바꾸기
 
     ```kotlin
 
      <selector xmlns:android="http://schemas.android.com/apk/res/android">
           <item android:color="@color/black" android:state_pressed="false" />
            <item android:color="@color/white" android:state_pressed="true"/>

      </selector>
 
      ```
 
      * ##### button 클릭시 버튼 색 바꾸기

      ```kotlin

        <selector xmlns:android="http://schemas.android.com/apk/res/android">
             <item android:drawable="@drawable/button_fill_gray" android:state_pressed="false" />
             <item android:drawable="@drawable/button_fill_color" android:state_pressed="true"/>
        </selector>

      ```
 
      * ##### EditText 입력할 때 색상 바꾸기

       ```kotlin

        <selector xmlns:android="http://schemas.android.com/apk/res/android">
             <item android:drawable="@drawable/rectangle_fill_gray" android:state_focused="false"/>
             <item android:drawable="@drawable/rectangle_border_pink" android:state_focused="true"/>
        </selector>

       ```
 
   * ####  TabLayout
 
     * ##### HomeFragment의 TabLayout
 
        ```kotlin

          private fun initAdapter(){
                val fragmentList=listOf(HomeFollowerFragment(),HomeFollowingFragment())

                homeFollowViewPagerAdapter=HomeFollowViewPagerAdapter(this)
                homeFollowViewPagerAdapter.fragments.addAll(fragmentList)

                binding.vpHomefragment.adapter=homeFollowViewPagerAdapter

            }

          private fun initTabLayout(){
                val tabLabel=listOf("팔로잉","팔로워")
                // tablayout이랑 viepager2 연결
                TabLayoutMediator(binding.homeTablayout,binding.vpHomefragment){
                        tab,position->
                    tab.text=tabLabel[position]
                }.attach()
            }

        ```
 
     ### ✔Level 2
 
     * ####  중첩스크롤 문제 해결 -> NestedScrollableHost
 
       * ##### ProfileFragment.xml에서 viewpager2를 NestedScrollableHost로 감싸기

         ```kotlin

          <com.example.androidsopt.NestedScrollableHost
             android:layout_width="match_parent"
             android:layout_height="0dp"
             app:layout_constraintTop_toBottomOf="@+id/home_tablayout"
             app:layout_constraintBottom_toBottomOf="parent"
             app:layout_constraintStart_toStartOf="parent"
             app:layout_constraintEnd_toEndOf="parent">
                <androidx.viewpager2.widget.ViewPager2
                    android:id="@+id/vp_homefragment"
                    android:background="#dfdfdf"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent" />
          </com.example.androidsopt.NestedScrollableHost>

         ```
      * ####  Follower__각각 아이템에 이미지 url 활용하여 다른 이미지 보여주기

         * ##### FollowerAdapter, UserData, FollowerFragment
          
            ##### (1).먼저 UserData에 "val Img : String" 변수 추가해주기
          
            ##### (2).FollowerAdatper : Glide.circleCrop()으로 사진 둥글게 나타내기 , into()로 팔로우 프로필과 
   
           ```kotlin
 
            class FollowerViewHolder(private val binding: ItemSampleListBinding) :
                  RecyclerView.ViewHolder(binding.root) {
                  fun onBind(data: UserData) {
                      binding.tvName.text = data.name
                      binding.tvIntroduce.text = data.introduction
                      Glide.with(binding.root)
                          .load(data.Img)
                          .circleCrop()
                          .into(binding.ivProfile)
                  }

             }
 
           ```
             ##### (3).FollowerFragment
 
           ```kotlin
            private fun initAdapter() {
                //adapter 초기화
              followerAdapter = FollowerAdapter()
                //adatper와 recyclerview 연동
              binding.rvFollower.adapter = followerAdapter
              val img1 ="http://image.cine21.com/resize/cine21/still/2019/0624/16_07_21__5d1076a9eca7f[W578-].JPG"
              val img2 ="http://image.cine21.com/resize/cine21/still/2019/0624/16_15_30__5d1078925c7c5[W578-].jpg"
              val img3 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20210118_180%2F161094482719298FEG_JPEG%2FB01MU764R0_9.jpg&type=sc960_832"
              val img4 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160902_16%2Fdynamote_1472795070315jifGn_JPEG%2F1.jpeg&type=sc960_832"
              val img5 ="img url(길어서 생략)"
              val img6 ="img url(길어서 생략)"

              followerAdapter.userList.addAll(
                  listOf(
                      UserData(img1,"김수빈", "안드로이드"),
                      UserData(img2,"문다빈", "안드로이드 파트장"),
                      UserData(img3,"김현아", "기획 파트장"),
                      UserData(img4,"이성현", "디자인 파트장"),
                      UserData(img5,"김우영", "서버 파트장"),
                      UserData(img6,"김의진", "웹 파트장")
                   )
                )
                followerAdapter.notifyDataSetChanged()
            }
 
           ```
 
 * ## 📲 실행화면 
   #### profile화면에서 repository, follower화면 확인 + home화면에서 팔로잉, 팔로워 확인. 각각 아이템에 이미지 url첨부 + 중첩스크롤 해결
 
 |week3실행화면|
 |:----------:|
 |<img src=https://user-images.githubusercontent.com/62291759/139587961-b9c98f82-aded-4a5d-9a3b-c421dc4be850.gif width="200" height="450">|<img src=https://user-images.githubusercontent.com/62291759/139589051-a0ed7d13-8206-4a80-9a70-0bca95f3f528.gif width="200" height="450">|
 
 * ## 📌 이거..왜 안바뀔까요오???ㅜㅜㅜㅜ 😂😢😂😢
 #### button selected 여부로 코드 구현했는데 실행하면 에뮬레이터에서 적용이 안됩니다요.... 어디가 틀렸는지 알수가없숩니다...알려주쎄여... 이부분만 2시간동안 째려봐써여👀
 #### 클릭할 때만 바뀝니다...유지가 안된다고할까..?? 
 
|Button색상 안바뀜|
|:--------------:|
|<img src=https://user-images.githubusercontent.com/62291759/139589051-a0ed7d13-8206-4a80-9a70-0bca95f3f528.gif width="200" height="450">|

 ### Button is selected 관련 코드
      
    ```kotlin
      
         private fun initTransactionEvent(){
           val followerFragment = FollowerFragment()
           val repositoryFragment = RepositoryFragment()

            childFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit()
            binding.btnFollower.isSelected = true //처음 화면 보여질 시에

            binding.btnFollower.setOnClickListener{

              childFragmentManager.beginTransaction()
                      .replace(R.id.container_view, followerFragment)
                      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                      .commit()
              binding.btnFollower.isSelected=true
              binding.btnRepo.isSelected=false
             }
             binding.btnRepo.setOnClickListener {
              childFragmentManager.beginTransaction()
                  .replace(R.id.container_view,repositoryFragment)
                  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                  .commit()
              binding.btnRepo.isSelected=true
              binding.btnFollower.isSelected=false


             }
 

          }
      
    ```

#### 📌 3️⃣Week 배운내용 및 성장한 내용
##### * TapLayout의 기능과 ViewPager2의 특징을 알게됨 (특히 ViewPager와 ViewPager2의 차이)
##### * ViewPager2는 리사이클러뷰 기반으로 동작하고 notifyDataChanged()통해 UI 업데이터 가능함. 그리고 수평, 수직 스크롤 모두 지원!
##### * Fragment안에 Fragment 구현시에 코드가 달라진다. (아래코드첨부)
##### * childFragmentManager.beginTransaction().add(R.id.container_view, followerFragment).commit() --> ProfileFragment에서 구현시에 사용.
##### * 디자인 font첨부와 이미지 url 그리고 navigation 하단바 - 구현할 때는 조금...귀찮거 힘든데 막상 만들어 보면 앱다운 앱같다 ㅎㅎ
##### * 이제 DataBinding을 공부해서 더 간결하고 육안으로 보기 편한 코드를 짜봐야겠다!!!!!
##### * 버튼 클릭시 색 변환이... 코드 로직은 틀린 거 없어 보이는데 왜 적용이 안될까.... 이 문제에서만 2시간 붙잡고 있었는데 해결못했따...또르륵😥

#### 📝 To-do
##### 1. ViewPager2, TapLayout 정리하기
##### 2. level 3 과제 하기 +DataBinding으로 코드 refactor하기

---
 
 ### 4️⃣Week
#### Week4 assignment
 
  ### ✔Level 1
       
  * ####  POSTMAN 테스트
   
    * ##### 회원가입 성공
     
      <img width="561" alt="회원가입" src="https://user-images.githubusercontent.com/62291759/141410672-ba81bd0f-6768-40a7-94ac-d9a838ef7b9e.png">
      <img width="504" alt="회원가입성공" src="https://user-images.githubusercontent.com/62291759/141410644-660c7d4a-1cea-486b-8556-82d22cde2938.png">
 
    * #####  로그인 성공
 
      <img width="504" src="https://user-images.githubusercontent.com/62291759/141410513-35ba820f-0031-4779-aa7e-c814adaf1d69.png">
     
    * #####  이메일로 유저 찾기 성공
 
      <img width="505" alt="이메일유저조회성공" src="https://user-images.githubusercontent.com/62291759/141410696-3f3e6ca7-399e-4cde-acbe-de0dbcb01d88.png">
   
 
 * ####  회원가입
 
   * ##### SignUp - Retrofit Interface
  
     ##### 서버와의 의사소통 방식, 일종의 상호작용 방법을 정의
 
   ```kotlin
 
     interface SignUpService {
       @Headers("Content-Type: application/json")
       @POST("user/signup")
      fun postSignup(
            @Body body : RequestSignUpData
       ) :Call<ResponseSignUpData>
      }
 
   ```

    * ##### SignUp - request/response 객체 설계
 
    ```kotlin
 
      data class RequestSignUpData(
        @SerializedName("email")
        val id : String,
        val name : String,
        val password : String
       )

 
     ```
 
     ```kotlin

        data class ResponseSignUpData(
           val status : Int,
           val success : Boolean,
           val message : String,
           val data : Data
            ) {
         data class Data(
               val id: Int,
               val name: String,
               val email: String
            )
         }
 
      ```  
 
      * ##### SignUp - Callback 등록하여 통신 요청
 
        ##### Call 객체의 비동기 작업 이후 작업이 끝날때 할 행동을 Callback 객체로 표현

      ```kotlin
 
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
 
      ```
  * ####  로그인
 
    * ##### SignIn - Callback 등록하여 통신 요청
 
      ##### 회원가입과 data, interface 유사하므로 skip 
 
      ##### call 객체에 enqueue를 호출하여 실제 서버통신을 비동기적으로 요청, 만약 body()에 값이 없을 경우 or response.isSuccessful이 false인 경우 서버통신 실패
 
    ```kotlin
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

 
    ```
 
 * ## 📲 실행화면
 
 |week4실행화면|
 |:----------:|
 |<img src=https://user-images.githubusercontent.com/62291759/141471708-40781365-b068-4205-a8b6-3438fbca410e.gif width="200" height="450">|
 
#### 📌 4️⃣Week 배운내용 및 성장한 내용
##### * retrofit interface, resoponse/request 객체 구현
##### * postman 실습
##### * Callback 등록하여 통신 요청하는 방법 / 비동기 작업


#### 📝 To-do
##### 1. Okhttp 활용해보기
##### 2. 비동기처리 라이브러리로 구현해보기
 
----
 
 ### 7️⃣Week
 #### Week7 assignment

  ### ✔Level 1
       
   * ####  onBoarding
 
      ##### NavigationComponent 활용하여 온보딩 화면 만들기
  
      * fragment1,2,3으로 SOPT Hub 로그인 화면 전까지 온보딩 구현
      * 각 fragment 전환은 버튼을 눌러 이동
   
       ```kotlin

        <navigation xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:app="http://schemas.android.com/apk/res-auto"
          xmlns:tools="http://schemas.android.com/tools"
          android:id="@+id/nav_sample"
          app:startDestination="@id/firstFragment">

        <fragment
            android:id="@+id/firstFragment"
            android:name="com.example.androidsopt.view.onBoarding.FirstFragment"
            android:label="fragment_first"
            tools:layout="@layout/fragment_first" >
            <action
                android:id="@+id/action_firstFragment_to_secondFragment"
                app:destination="@id/secondFragment" />
        </fragment>
        <fragment
            android:id="@+id/thirdFragment"
            android:name="com.example.androidsopt.view.onBoarding.ThirdFragment"
            android:label="fragment_third"
            tools:layout="@layout/fragment_third" >
            <action
                android:id="@+id/action_thirdFragment_to_signInActivity"
                app:destination="@id/signInActivity" />
        </fragment>
        <fragment
            android:id="@+id/secondFragment"
            android:name="com.example.androidsopt.view.onBoarding.SecondFragment"
            android:label="fragment_second"
            tools:layout="@layout/fragment_second" >
            <action
                android:id="@+id/action_secondFragment_to_thirdFragment"
                app:destination="@id/thirdFragment" />

        </fragment>
        <activity
            android:id="@+id/signInActivity"
            android:name="com.example.androidsopt.view.Login.SignInActivity"
            android:label="activity_sign_in"
            tools:layout="@layout/activity_sign_in" />
        </navigation>

       ```

   * ####  자동로그인 / 자동로그인 해제 구현하기
 
      ##### SharedPreferences 활용하여 자동로그인 
 
       ```kotlin
        object SharedPreferences {

           private const val STORAGE_KEY = "USER_AUTH"
           private const val AUTO_LOGIN = "AUTO_LOGIN"

           fun getAutoLogin(context: Context): Boolean {
               val preferences = context.getSharedPreferences("USER_AUTH",Context.MODE_PRIVATE)
               return preferences.getBoolean(AUTO_LOGIN, false)

           }
           fun setAutoLogin(context: Context, value :Boolean) {
               val preferences = context.getSharedPreferences("USER_AUTH",Context.MODE_PRIVATE)
               preferences.edit()
                   .putBoolean(AUTO_LOGIN, value)
                   .apply()

         }
       
 
       ```
 
      ##### SettingActivity - 자동로그인 해제(tvCancel) 클릭 시 remove, clear() 자동로그인 해제
 
       ```kotlin
     
        private fun initClickEvent() {
        binding.tvCancel.setOnClickListener {

            val sp : SharedPreferences = getSharedPreferences("USER_AUTH", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sp.edit()
            editor.remove("USER_AUTH")
            editor.clear()
            editor.commit()

             }
        }
        
 
       ```
  * ####  패키징
  
    ##### 직관적으로 쉽게 알아볼 수 있도록 data/network/util/view 로 패키지를 생성
    ##### 이때 view폴더에 각 구현한 Activity/Fragment 단위로 하위 패키지를 생성
 
 
         ┣ 📂util
         ┣ 📂network : 서버통신관련
         ┣ 📂data
         ┣ 📂view
            ┣ 📂Home
            ┣ 📂Profile
            ┣ 📂Login
            ┣ 📂Camera
            ┗ 📂onBoarding
 
 
 * ## 📲 실행화면
 
 |week7 온보딩 |  자동로그인 | 자동로그인 알림 |자동로그인 해제|
 |:----------:|:----------:|:--------------:|:--------------|
 |<img src=https://user-images.githubusercontent.com/62291759/146507881-bab37642-bc0d-4472-91fa-1d11ec4c5605.gif width="200" height="450">|<img src=https://user-images.githubusercontent.com/62291759/146507920-898ca7eb-3cf2-4224-932c-15b5d2507e5e.gif width="200" height="450">|<img src=https://user-images.githubusercontent.com/62291759/146507960-9ad94417-62ed-45ea-8ada-6a111168fda4.gif width="200" height="450">|<img src=https://user-images.githubusercontent.com/62291759/146507993-5a266f43-33d2-48ce-8574-14845cd57e0d.gif width="200" height="450">
 
#### 📌 7️⃣Week 배운내용 및 성장한 내용
##### * 온보딩 정의 및 NavigationComponent활용
##### * 자동로그인 로직 , SharedPreferences
##### * 패키징의 중요성 --> 한눈에 잘보여 파일 찾을 때 매우매우 편리함!~!~!
