package com.jtk.bepresensi.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jtk.bepresensi.R
import com.jtk.bepresensi.ui.home.HomeActivity
import com.jtk.bepresensi.ui.profil.ProfilActivity
import com.jtk.bepresensi.ui.riwayat.RiwayatActivity
import com.jtk.bepresensi.ui.surat.SuratActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //set default fragment on start
        replaceFragment(HomeActivity())
    }

    //Bottom navigation ketika diklik
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.bottomNavigationHome ->{
                replaceFragment(HomeActivity())
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottomNavigationProfil ->{
                replaceFragment(ProfilActivity())
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottomNavigationRiwayat ->{
                replaceFragment(RiwayatActivity())
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottomNavigationSurat ->{
                replaceFragment(SuratActivity())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
}