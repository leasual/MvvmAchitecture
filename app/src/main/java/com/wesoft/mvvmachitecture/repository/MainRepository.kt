package com.wesoft.mvvmachitecture.repository


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.wesoft.mvvmachitecture.base.BaseRepository
import com.wesoft.mvvmachitecture.model.CategoryBean
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james on 2018/8/21.
 */

@Singleton
class MainRepository @Inject constructor(): BaseRepository() {

    fun getResult(): String = "Test"

    fun getCategories(): LiveData<List<CategoryBean>> {
        return object : NetworkBoundResource<List<CategoryBean>, List<CategoryBean>>(dispose) {
            override fun cache(data: List<CategoryBean>) {

            }

            override fun shouldFetch(data: List<CategoryBean>): Boolean {
                return true
            }

            override fun loadFromDB(): LiveData<List<CategoryBean>> {
                return MediatorLiveData<List<CategoryBean>>()
            }


            override fun callApi(): LiveData<List<CategoryBean>>  = apiService.getToday()

        }.asLiveData()
    }
}