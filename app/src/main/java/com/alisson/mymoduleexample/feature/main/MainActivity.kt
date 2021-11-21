package com.alisson.mymoduleexample.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.alisson.mymoduleexample.R
import com.alisson.mymoduleexample.databinding.ActivityMainBinding
import com.alisson.mymoduleexample.extensions.exhaustive
import com.alisson.mymoduleexample.feature.list.AndroidJobsListActivity
import com.alisson.mymoduleexample.utils.MainAction
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupViewModel()
    }

    private fun setupViewModel() {

        viewModel.mainActionLiveData.observe(this, { event ->
            event.getContentIfNotHandled()?.let { mainAction ->
                when(mainAction) {
                    MainAction.SHOW_JOBS -> startActivity(AndroidJobsListActivity.launchIntent(this))
                    MainAction.LEAVE_APP -> finish()
                }.exhaustive
            }
        })
    }
}