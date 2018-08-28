package com.wesoft.mvvmachitecture.repository


import com.wesoft.mvvmachitecture.App
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
class MainRepository @Inject constructor(private val app: App): BaseRepository() {

    fun getCategories(): Flowable<MutableList<CategoryBean>> {
        return object : NetworkBoundResource<MutableList<CategoryBean>, BaseResponse<MutableList<CategoryBean>>>(app) {

            override fun loadFromDB(): MutableList<CategoryBean>? {
                val dataList = arrayListOf<CategoryBean>()
                dataList.add(CategoryBean("1", "wesoft", "慧讯软件", 1))
                dataList.add(CategoryBean("1", "wesoft", "慧讯软件", 2))
                dataList.add(CategoryBean("1", "wesoft", "慧讯软件", 3))
                return dataList
            }

            override fun shouldLoadFromCache(): Boolean = true

            override fun shouldFetch(data: MutableList<CategoryBean>?): Boolean = (data == null || data.isEmpty())

            override fun cache(data: MutableList<CategoryBean>) {

            }

            override fun callApi(): Flowable<BaseResponse<MutableList<CategoryBean>>> {
                return apiService.getToday()
            }

        }.asFlowable()
    }
}