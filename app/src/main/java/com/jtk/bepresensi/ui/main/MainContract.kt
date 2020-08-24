package com.jtk.bepresensi.ui.main

import com.jtk.bepresensi.models.Comics
import com.jtk.bepresensi.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View{

        fun onGetComicSuccess(comic : Comics)
        fun onDomainError(msg: String)

    }

    interface Presenter:BaseContract.Presenter<View>{
        fun getComic(nomor :Int)
    }
}