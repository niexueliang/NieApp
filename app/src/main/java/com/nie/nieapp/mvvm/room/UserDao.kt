package com.nie.nieapp.mvvm.room

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun load(): Flowable<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User):Long

    @Delete
    fun delete(user: User):Int
}