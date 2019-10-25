package com.byiryu.templatemvp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Res<T>(
        @field:SerializedName("entity")
        var entity: T?,
        @field:SerializedName("code")
        var code : Int,
        @field:SerializedName("msg")
        var msg : String?



): Serializable{
    override fun toString(): String {
        return "Res(entity=$entity, code=$code, msg=$msg)"
    }
}



