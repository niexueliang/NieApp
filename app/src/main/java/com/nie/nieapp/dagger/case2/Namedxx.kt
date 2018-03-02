package com.nie.nieapp.dagger.case2

import java.lang.annotation.Documented
import javax.inject.Qualifier

/**
 * 说明：
 * Created by code_nil on 2018/2/27.
 * 君子自强不息
 */
@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class Namedxx(val value: String = "")