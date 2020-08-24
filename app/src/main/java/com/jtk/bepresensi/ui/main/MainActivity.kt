package com.jtk.bepresensi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jtk.bepresensi.R
import com.jtk.bepresensi.di.component.DaggerActivityComponent
import com.jtk.bepresensi.di.module.ActivityModule
import javax.inject.Inject
import android.content.Intent
import android.widget.Toast
import com.jtk.bepresensi.models.Comics
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)
        initView()
    }

    private fun initView(){
        btnNumber.setOnClickListener {

            //cek text kosong atau tidak
            if (txtNumber.text.toString().isEmpty()){
                Toast.makeText(this, "Text tidak boleh kosong", Toast.LENGTH_LONG).show()
            } else {
                //lakukan pemanggilan api
                presenter.getComic(nomor = txtNumber.text.toString().toInt())
            }
        }
    }

    private fun injectDependency() {

        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onGetComicSuccess(comic: Comics) {
        judulComic.text = comic.title
        tahunComic.text = comic.year
        Picasso.get().load(comic.gambar).into(gambarComic)
    }

    override fun onDomainError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}