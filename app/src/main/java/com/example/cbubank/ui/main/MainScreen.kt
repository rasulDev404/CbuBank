package com.example.cbubank.ui.main

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cbubank.R
import com.example.cbubank.databinding.ScreenMainBinding
import com.example.cbubank.presenters.MainViewModel
import com.example.cbubank.presenters.impl.MainViewModelImpl
import com.example.cbubank.ui.dialog.Dialog
import com.example.cbubank.ui.main.adapter.MainAdapter

class MainScreen : Fragment(R.layout.screen_main) {
    private val adapter = MainAdapter()
    private val binding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openDialogLiveData.observe(this) {
            val dialog = Dialog(it)
            dialog.show(childFragmentManager, "dialog")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        binding.rvMain.adapter = adapter
        adapter.setItemClickListener {

            viewModel.itemClick(it)
        }
        subscribeDataObservers()

    }

    private fun setClickListeners() {
        binding.refresh.setOnClickListener {
            viewModel.updateAllData()
        }
    }

    private fun subscribeDataObservers() {
        viewModel.listLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.progressLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }
}