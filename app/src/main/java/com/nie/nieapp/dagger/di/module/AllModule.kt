package com.nie.nieapp.dagger.di.module

import com.nie.nieapp.dagger.da.DaggerCommonActivity
import com.nie.nieapp.mvvm.MvvmActivity
import com.nie.nieapp.mvvm.MvvmModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 说明：所有的activity/fragment和相应的module都在这里建立关联
 * ContributesAndroidInjector 1、针对的是Android框架类型Activity，fragment等 2、注入方法不能包含参数
 * 注意：这种方式会自动生成对应的Subcomponent，因此不用创建公用的Subcomponent
 * Created by code_nil on 2018/1/30.
 * 君子自强不息
 *
 */
@Module
abstract class AllModule {
    // ContributesAndroidInjector作用-->要注入到生成的dagger.Subcomponent中的Module。
    @ContributesAndroidInjector(modules = [MvvmModule::class])
    abstract fun contributeMvvmActivity(): MvvmActivity

    @ContributesAndroidInjector(modules = [DaggerCommonModule::class])
    abstract fun conttDaggerNormalActivity(): DaggerCommonActivity

}