## Android-Subin

![github_김수빈_ver1-13](https://user-images.githubusercontent.com/70698151/135754037-394c5c7f-9615-4206-8dc4-df985f512e75.png)


----------


## 🔴 세미나 과제
### 📝목차
[1️⃣Week](#week1-assignment)

[2️⃣Week](#week2-assignment)

[3️⃣Week](#week3-assignment)

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

