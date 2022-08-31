package com.example.cbubank.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.cbubank.R
import com.example.cbubank.presenters.SplashViewModel
import com.example.cbubank.presenters.impl.SplashViewModelImpl

class SplashScreen:Fragment(R.layout.screen_splash) {
    private val viewModel:SplashViewModel by viewModels<SplashViewModelImpl>()
    private val navController by lazy { findNavController() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this,openMainScreenObserver)

    }
    private val openMainScreenObserver = Observer<Unit>{
        navController.navigate(R.id.action_splashScreen_to_mainScreen)
    }

}