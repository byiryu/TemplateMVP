@file:JvmName("Api")

package com.byiryu.templatemvp.api


import android.content.Context
import android.util.Base64
import android.util.Log
import com.byiryu.templatemvp.data.model.Res
import com.byiryu.templatemvp.utils.ApplicationCons
import com.byiryu.templatemvp.utils.ProgressDialogManager

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@JvmOverloads
fun <T : Any> Call<Res<T>>.call(
    isProgress: Boolean = true,
    context : Context,
    listener: OnResultListener<Res<T>>
) {
    if (isProgress) {

        ProgressDialogManager.getInstance().show(context)
    }
    this.enqueue(object : ApiCallback<Res<T>>() {
        override fun onSuccess(call: Call<Res<T>>?, response: Response<Res<T>>?, data: Res<T>?) {

            Log.e("success", "success")
            if (isProgress) {
                ProgressDialogManager.getInstance().clear()
            }
            if (data != null && data.code == ApplicationCons.STATUS_CODE_SUCCESS) {
                listener.onResult(true, call, response, data)
            } else {
                listener.onResult(false, call, response, data)
            }
        }


        override fun onFail(call: Call<Res<T>>?, response: Response<Res<T>>?) {
            Log.e("fail", "fail")
            if (isProgress) {
                ProgressDialogManager.getInstance().clear()
            }
            listener.onResult(false, call, null, null)
        }
    })
}

interface OnResultListener<T> {
    /**
     * Callback when communicate has processed.
     *
     * @param[isResult] success if returnCode is 1 and status code is 200, false - other
     * @param[call] [Call] object
     * @param[response] [Response] object
     * @param[data] generic class
     */
    fun onResult(isResult: Boolean, call: Call<T>?, response: Response<T>?, data: T?)
}

abstract class ApiCallback<T> : Callback<T> {
    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response!!.code() == 200) {
            onSuccess(call, response, response.body())
        } else {
            onFail(call, response)
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
//        NyanCat.tag(com.byiryu.templatemvp.api.ApiCallback::class.java.simpleName).e(t)
        onFail(call, null)
    }

    abstract fun onSuccess(call: Call<T>?, response: Response<T>?, data: T?)
    abstract fun onFail(call: Call<T>?, response: Response<T>?)
}

/**
 * getting server image path from relative path
 */
//@JvmOverloads
//fun getServerImagePath(path: String, resolution: String = FILE_480): String {
//    if (path.contains(String.format("%s%s", BASE_FILE, resolution))) {
//        return path
//    }
//
//    return String.format("%s%s%s", BASE_FILE, resolution, path)
//}

fun <T> List<T>.toEncode() = Base64.encodeToString(Gson().toJson(this).toByteArray(charset("UTF-8")), Base64.NO_WRAP)
fun <T> toEncode(vararg items: T) =
    Base64.encodeToString(Gson().toJson(items.toList()).toByteArray(charset("UTF-8")), Base64.NO_WRAP)