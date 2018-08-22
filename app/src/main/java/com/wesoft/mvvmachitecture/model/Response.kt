package com.wesoft.mvvmachitecture.model

import com.google.gson.annotations.SerializedName

/**
 * Created by james on 2018/8/22.
 */

data class Category(
        @SerializedName("error") var error: Boolean,
        @SerializedName("results") var dataList: List<CategoryBean>
)

data class CategoryBean(
        @SerializedName("_id") var id: String,
        @SerializedName("en_name") var enName: String,
        @SerializedName("name") var name: String,
        @SerializedName("rank") var rank: Int
)