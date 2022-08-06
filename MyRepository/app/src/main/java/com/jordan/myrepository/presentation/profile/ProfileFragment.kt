package com.jordan.myrepository.presentation.profile

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.jordan.myrepository.R
import com.jordan.myrepository.databinding.FragmentProfileBinding
import com.jordan.myrepository.domain.entity.Repo
import com.jordan.myrepository.presentation.profile.adapter.RepoAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment: Fragment() {

    private val viewModel: ProfileViewModel by viewModel()

    private lateinit var binding: FragmentProfileBinding
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentProfileBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            binding = this
            observeChanges()
        }.root
    }

    override fun onStart() {
        super.onStart()
        observeChanges()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeChanges() {

        viewModel.getPassportData("Jordan-moura")

        binding.btUpdate.setOnClickListener {
            viewModel.getPassportData(binding.etLogin.text.toString())
        }

        viewModel.repos.observe(viewLifecycleOwner) {
            when (it) {
                is ProfileViewModel.State.Success -> onRepoSuccess(it.list)
                else -> {
                    // do nothing
                }
            }
        }
    }

    private fun onRepoSuccess(repos: List<Repo>) {
        binding.rvRepos.adapter = RepoAdapter(repos)
    }
}