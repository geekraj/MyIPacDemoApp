package com.ipac.myipac.pagination

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import javax.xml.transform.Result

class ItemDataSourceFactory : DataSource.Factory<Int, com.ipac.myipac.db.model.Result>() {
    private val itemLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, javax.xml.transform.Result>> =
        MutableLiveData()


    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return itemLiveDataSource
    }

    override fun create(): DataSource<Int, com.ipac.myipac.db.model.Result> {
        val itemDataSource = ItemDataSource()
        //deprecated
        //itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }
}
