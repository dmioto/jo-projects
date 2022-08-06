package com.jordan.myrepository.presentation.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordan.myrepository.databinding.ItemRepoBinding
import com.jordan.myrepository.domain.entity.Repo

class RepoAdapter(private val repos: List<Repo>) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    class RepoViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo) {
            with(binding) {
                binding.repo = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding =
            ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val item = repos[position]

        holder.bind(item)
    }

    override fun getItemCount() = repos.size

}