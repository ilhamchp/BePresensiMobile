package com.jtk.bepresensi.ui.main

import android.util.Log
import com.jtk.bepresensi.api.ApiServiceInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainPresenter :MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View
    private val ApiSevices: ApiServiceInterface = ApiServiceInterface.create()

    override fun getComic(nomor :Int) {
        val subscribe = ApiSevices.getComic(nomor).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("DOMAIN", it.toString())
                // view.onProgress(false)
                view.onGetComicSuccess(it)
            }, { error ->
                var msg = error.localizedMessage
                view.onDomainError(msg)
            })
        subscriptions.add(subscribe)
    }


    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }


}