package com.wesoft.mvvmachitecture.repository


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.wesoft.mvvmachitecture.base.BaseRepository
import com.wesoft.mvvmachitecture.model.Category
import com.wesoft.mvvmachitecture.model.CategoryBean
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james on 2018/8/21.
 */

@Singleton
class MainRepository @Inject constructor(): BaseRepository() {

    fun getResult(): String = "Test"

    fun getCategories(): LiveData<List<CategoryBean>> {
        return object : NetworkBoundResource<List<CategoryBean>, Category>(dispose) {
            override fun cache(data: List<CategoryBean>) {

            }

            override fun shouldFetch(data: List<CategoryBean>): Boolean {
                return true
            }

            override fun loadFromDB(): LiveData<List<CategoryBean>> {
                return MediatorLiveData<List<CategoryBean>>()
            }


            override fun callApi(): Flowable<Category>  = apiService.getToday()

        }.asLiveData()
    }
}