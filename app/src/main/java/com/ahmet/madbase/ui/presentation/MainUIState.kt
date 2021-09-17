package com.ahmet.madbase.ui.presentation

sealed class MainUIState{
    object SUCCESS : MainUIState()
    object ERROR : MainUIState()
    object LOADING : MainUIState()
    object EMPTY : MainUIState()
}
