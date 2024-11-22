package com.example.navigationcompose.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi())
}