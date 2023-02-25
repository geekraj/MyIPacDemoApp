package com.ipac.myipac.ui.main

import com.ipac.myipac.db.model.Result

interface UserClickListener {
    fun rowClick(heroItem: Result)
}