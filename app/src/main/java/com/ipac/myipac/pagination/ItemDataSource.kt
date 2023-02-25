package com.ipac.myipac.pagination

import android.os.Parcel
import android.os.Parcelable
import androidx.paging.PageKeyedDataSource
import com.ipac.myipac.db.model.Result
import com.ipac.myipac.db.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDataSource() : PageKeyedDataSource<Int, Result>(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        RetrofitClient.getInsance()
            .api
            .getUsers(params.key)
            .enqueue(object : Callback<UserResponse?> {
                override fun onResponse(
                    call: Call<UserResponse?>,
                    response: Response<UserResponse?>
                ) {
                    if (response.body() != null) {
                        val key: Int = if (response.body()!!.has_more) params.key.toInt() + 1 else 0
                        callback.onResult(response.body()!!.results, key)
                    }
                }

                override fun onFailure(call: Call<UserResponse?>, t: Throwable) {}
            })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        RetrofitClient.getInsance()
            .api
            .getUsers(params.key)
            .enqueue(object : Callback<UserResponse?> {
                override fun onResponse(
                    call: Call<UserResponse?>,
                    response: Response<UserResponse?>
                ) {
                    if (response.body() != null) {
                        val key: Int? = if (params.key > 1) params.key - 1 else null
                        callback.onResult(response.body()!!.results, key)
                    }
                }

                override fun onFailure(call: Call<UserResponse?>, t: Throwable) {}
            })
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        RetrofitClient.getInsance()
            .api
            .getUsers(
                20
            )
            .enqueue(object : Callback<UserResponse?> {
                override fun onResponse(
                    call: Call<UserResponse?>,
                    response: Response<UserResponse?>
                ) {
                    if (response.body() != null) {
                        callback.onResult(
                            response.body()!!.results,
                            null,
                            0 + 1
                        )
                    }
                }

                override fun onFailure(call: Call<UserResponse?>, t: Throwable) {}
            })
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemDataSource> {
        override fun createFromParcel(parcel: Parcel): ItemDataSource {
            return ItemDataSource(parcel)
        }

        override fun newArray(size: Int): Array<ItemDataSource?> {
            return arrayOfNulls(size)
        }
    }


}