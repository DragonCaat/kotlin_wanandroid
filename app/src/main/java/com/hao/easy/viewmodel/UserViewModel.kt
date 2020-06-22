package com.hao.easy.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hao.easy.Config
import com.hao.easy.base.extensions.io_main
import com.hao.easy.base.extensions.subscribeBy
import com.hao.easy.base.viewmodel.BaseViewModel
import com.hao.easy.repository.Api
import com.hao.easy.user.User

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class UserViewModel : BaseViewModel() {

    var loginLiveData = MutableLiveData<User>()

    var logoutLiveData = MutableLiveData<String>()

    override fun onResume() {
        loginLiveData.value = Config.user
    }

    fun logout() {
        Api.logout().io_main().subscribeBy({
            logoutLiveData.value = null
        }, {
            logoutLiveData.value = null
        }).add()
    }
}