package com.example.androidsopt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsopt.databinding.ItemRepositoryBinding
import java.nio.file.Files.size

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    val repoList = mutableListOf<RepoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate( //repository 데이터 inflate
            LayoutInflater.from(parent.context),
            parent, false
        )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repoList[position]) // RepoData 변수 repoList인데 위치

    }

    override fun getItemCount(): Int = repoList.size

    class RepositoryViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepoData) {
            binding.tvTitle.text = data.title
            binding.tvContent.text = data.content
        }
    }
}