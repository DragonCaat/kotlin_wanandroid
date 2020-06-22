package com.hao.easy.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hao.easy.Config
import com.hao.easy.base.extensions.io_main
import com.hao.easy.base.extensions.subscribeBy
import com.hao.easy.base.viewmodel.BaseViewModel
import com.hao.easy.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class LoginViewModel : BaseViewModel() {

    var loginLiveData = MutableLiveData<String>()

    fun login(username: String, password: String) {
        Api.login(username, password).io_main().subscribeBy({
            Config.logged(it!!)
            loginLiveData.value = null
        }, {
            loginLiveData.value = it
        }).add()
    }
}