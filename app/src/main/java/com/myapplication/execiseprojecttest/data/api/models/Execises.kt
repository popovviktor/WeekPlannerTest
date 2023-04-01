package com.myapplication.execiseprojecttest.data.api.models

import com.google.gson.annotations.SerializedName

data class Execises (
 @SerializedName("execises" ) var execises : ArrayList<Execise> = arrayListOf()
)
data class Execise(
    @SerializedName("date" ) var date : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("month" ) var month : String? = null,
    @SerializedName("dayofweek" ) var dayofweek : String? = null
)
