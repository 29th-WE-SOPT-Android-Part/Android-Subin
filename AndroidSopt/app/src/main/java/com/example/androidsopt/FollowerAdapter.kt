package com.example.androidsopt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsopt.databinding.ItemSampleListBinding

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