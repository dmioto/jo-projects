package com.jordan.passportcard.presentation.showcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jordan.passportcard.R
import com.jordan.passportcard.databinding.FragmentShowCardsBinding
import com.jordan.passportcard.domain.entity.PassportCard
import com.jordan.passportcard.presentation.showcards.adapter.ShowCardsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowCardsFragment : Fragment() {

    private val viewModel: ShowCardsViewModel by viewModel()

    lateinit var binding: FragmentShowCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentShowCardsBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            binding = this
            setupLayout(this)
            observeChanges(this)
        }.root
    }

    override fun onStart() {
        super.onStart()
        observeChanges(binding)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeChanges(binding: FragmentShowCardsBinding) {

        viewModel.getPassportData()

        viewModel.passportCards.observe(viewLifecycleOwner) {
            onShowCardSuccess(it, binding)
        }
    }

    private fun onShowCardSuccess(passports: List<PassportCard>, binding: FragmentShowCardsBinding) {
        binding.rvCards.apply {
            adapter = ShowCardsAdapter(passports)
        }
    }

    private fun setupLayout(binding: FragmentShowCardsBinding) {
        binding.btnShowAdd.setOnClickListener {
            navigateAddCard()
        }
    }

    private fun navigateAddCard() {
        findNavController().navigate(R.id.action_showCardsFragment_to_addCardFragment)
    }

}