package com.jtk.bepresensi.di.component

import com.jtk.bepresensi.di.module.ActivityModule
import com.jtk.bepresensi.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}