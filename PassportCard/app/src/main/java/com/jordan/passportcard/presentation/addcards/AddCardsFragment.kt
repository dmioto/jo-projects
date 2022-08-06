package com.jordan.passportcard.presentation.addcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jordan.passportcard.databinding.FragmentAddCardsBinding
import com.jordan.passportcard.databinding.FragmentShowCardsBinding
import com.jordan.passportcard.domain.entity.PassportCard
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class AddCardsFragment : Fragment() {

    private val viewModel: AddCardsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAddCardsBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            setupLayout(this)
            observeChanges(this)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeChanges(binding: FragmentAddCardsBinding) {

        binding.btnAdd.setOnClickListener {

            val passport = PassportCard(
                name = binding.tilName.editText?.text.toString(),
                document = binding.tilDocument.editText?.text.toString(),
                expiration = binding.tilExpirationDate.editText?.text.toString(),
                telephone = binding.tilTelephone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                color = "fadf",
                nationality = binding.tilNationality.editText?.text.toString()
            )

            viewModel.addPassportData(passport)

            findNavController().popBackStack()
        }
    }

    private fun setupLayout(binding: FragmentAddCardsBinding) {
        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}