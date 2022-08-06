package com.jordan.passportcard.presentation.showcards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordan.passportcard.databinding.FragmentAddCardsBinding
import com.jordan.passportcard.databinding.ItemCardsBinding
import com.jordan.passportcard.domain.entity.PassportCard

class ShowCardsAdapter(private val cards: List<PassportCard>) :
    RecyclerView.Adapter<ShowCardsAdapter.ShowCardsViewHolder>() {

    class ShowCardsViewHolder(val binding: ItemCardsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PassportCard) {
            with(binding) {
                binding.passport = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCardsViewHolder {
        val binding = ItemCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ShowCardsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowCardsViewHolder, position: Int) {
        val item = cards[position]

        holder.bind(item)
    }

    override fun getItemCount() = cards.size

}