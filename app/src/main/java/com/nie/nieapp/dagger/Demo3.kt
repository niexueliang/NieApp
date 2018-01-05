package com.nie.nieapp.dagger

import android.content.Context
import android.widget.Toast
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject


class MainPresenter @Inject constructor(private val context: Context) {
    fun loadData() {
        Toast.makeText(context, "didadia", Toast.LENGTH_LONG).show()
    }
}

@Module
class MainModule constructor(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
}

@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: Dragger2Activity)
}

