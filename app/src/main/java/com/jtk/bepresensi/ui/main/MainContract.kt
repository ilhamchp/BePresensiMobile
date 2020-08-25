package com.jtk.bepresensi.ui.main

import androidx.fragment.app.Fragment
import com.jtk.bepresensi.models.Comics
import com.jtk.bepresensi.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View{
        fun replaceFragment(fragment: Fragment)
    }

    interface Presenter:BaseContract.Presenter<View>{
    }
}