package com.nie.nieapp.mvvm.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * 说明：用户实体
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
@Entity(tableName = "users")
data class User(var name: String = "",
                var age: Int = 0,
                @PrimaryKey(autoGenerate = true)
                var id: Long = 0)