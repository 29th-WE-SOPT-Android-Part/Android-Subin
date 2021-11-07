package com.example.androidsopt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidsopt.databinding.FragmentFollowerBinding

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
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_follower, container, false)
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
        val img1 ="http://image.cine21.com/resize/cine21/still/2019/0624/16_07_21__5d1076a9eca7f[W578-].JPG"
        val img2 ="http://image.cine21.com/resize/cine21/still/2019/0624/16_15_30__5d1078925c7c5[W578-].jpg"
        val img3 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20210118_180%2F161094482719298FEG_JPEG%2FB01MU764R0_9.jpg&type=sc960_832"
        val img4 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160902_16%2Fdynamote_1472795070315jifGn_JPEG%2F1.jpeg&type=sc960_832"
        val img5 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20101209_41%2Fmny0824_1291869482392cvHVM_JPEG%2Ftangled2.jpg&type=sc960_832"
        val img6 ="https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAxNzA5MjRfMjIg%2FMDAxNTA2MjQ5ODA1MTg2.-tYXl_56-BfmEN62G5TFnC6XoUR5tqhJ-LA2o2sVeGMg.54gfTUxdpRQPw231R5AEKEijxmFXk5xS_5dSbHUCTQEg.JPEG.hundobo%2FexternalFile.jpg&type=sc960_832"

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
}
