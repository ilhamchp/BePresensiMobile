package com.jtk.bepresensi.di.module

import android.app.Activity
import com.jtk.bepresensi.ui.main.MainContract
import com.jtk.bepresensi.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }


}