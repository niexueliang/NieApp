package com.nie.nieapp.mvvm.room
import android.arch.persistence.room.*
import android.content.Context

/**
 * 说明：
 * Created by code_nil on 2018/2/26.
 * 君子自强不息
 */
@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        MyDatabase::class.java, "my.db")
                        .build()
    }
}

fun Context.databases() = MyDatabase.getInstance(this)