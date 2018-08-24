package com.wesoft.mvvmachitecture.repository


import com.wesoft.mvvmachitecture.base.BaseRepository
import com.wesoft.mvvmachitecture.model.BaseResponse
import com.wesoft.mvvmachitecture.model.CategoryBean
import com.wesoft.mvvmachitecture.vo.NetworkBoundResource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james on 2018/8/21.
 */

@Singleton
class MainRepository @Inject constructor(): BaseRepository() {

    fun getCategories(): Flowable<List<CategoryBean>> {
        return object : NetworkBoundResource<List<CategoryBean>, BaseResponse<List<CategoryBean>>>() {

            override fun loadFromDB(): Flowable<List<CategoryBean>>? {
                return null
            }

            override fun shouldFetch(data: List<CategoryBean>?): Boolean = (data == null || data.isEmpty())

            override fun cache(data: List<CategoryBean>) {

            }

            override fun callApi(): Flowable<BaseResponse<List<CategoryBean>>> {
                return apiService.getToday()
            }

        }.asFlowable()
    }
}