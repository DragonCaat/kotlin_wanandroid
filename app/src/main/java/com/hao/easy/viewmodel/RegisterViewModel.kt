package com.hao.easy.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hao.easy.base.extensions.io_main
import com.hao.easy.base.extensions.subscribeBy
import com.hao.easy.base.viewmodel.BaseViewModel
import com.hao.easy.repository.Api

/**
 * @author Yang Shihao
 * @date 2018/11/25
 */
class RegisterViewModel : BaseViewModel() {

    var registerLiveData = MutableLiveData<String>()

    fun register(username: String, password: String) {
        Api.register(username, password, password).io_main().subscribeBy({
            registerLiveData.value = null
        }, {
            registerLiveData.value = it
        }).add()
    }
}