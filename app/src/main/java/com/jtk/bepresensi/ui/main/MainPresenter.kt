package com.jtk.bepresensi.ui.main

import android.util.Log
import com.jtk.bepresensi.api.ApiServiceInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainPresenter : MainContract.Presenter {

    private lateinit var view: MainContract.View


    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }


}