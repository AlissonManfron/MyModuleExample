package com.alisson.mymoduleexample.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alisson.mymoduleexample.feature.viewmodel.BaseViewModel
import com.alisson.mymoduleexample.utils.Event
import com.alisson.mymoduleexample.utils.MainAction

class MainViewModel: BaseViewModel() {
    private val _mainActionLiveData = MutableLiveData<Event<MainAction>>()
    val mainActionLiveData: LiveData<Event<MainAction>> = _mainActionLiveData

    fun onShowAndroidJobsRequire() {
        _mainActionLiveData.postValue(Event(MainAction.SHOW_JOBS))
    }

    fun onOutAppLiveData() {
        _mainActionLiveData.postValue(Event(MainAction.LEAVE_APP))
    }
}