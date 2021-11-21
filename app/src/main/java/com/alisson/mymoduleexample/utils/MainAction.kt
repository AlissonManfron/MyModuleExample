package com.alisson.mymoduleexample.utils

sealed class MainAction {
    object SHOW_JOBS: MainAction()
    object LEAVE_APP: MainAction()
}