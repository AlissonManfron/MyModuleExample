package com.alisson.mymoduleexample.feature.list

import androidx.lifecycle.MutableLiveData
import com.alisson.domain.entities.AndroidJob
import com.alisson.domain.usecases.GetJobsUseCases
import com.alisson.mymoduleexample.feature.viewmodel.BaseViewModel
import com.alisson.mymoduleexample.feature.viewmodel.StateMachineSingle
import com.alisson.mymoduleexample.feature.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class AndroidJobListViewModel(
    val useCase: GetJobsUseCases,
    val uiScheduler: Scheduler
): BaseViewModel() {

    val state = MutableLiveData<ViewState<List<AndroidJob>>>().apply {
        value = ViewState.Loading
    }

    fun getJobs(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }

    fun onTryAgainRequired() {
        getJobs(forceUpdate = true)
    }
}