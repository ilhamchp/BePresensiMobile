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

class MainActivity : AppCompatActivity(){

    lateinit var homeFragment: HomeActivity
    lateinit var profilFragment: ProfilActivity
    lateinit var riwayatFragment: RiwayatActivity
    lateinit var suratFragment: SuratActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set default fragment on start
        homeFragment = HomeActivity()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        //fragment yang muncul ketika icon bottom navigation diklik
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){

                //Home
                R.id.bottomNavigationHome -> {
                    homeFragment = HomeActivity()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                //Profil
                R.id.bottomNavigationProfil -> {
                    profilFragment = ProfilActivity()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, profilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                //Riwayat
                R.id.bottomNavigationRiwayat -> {
                    riwayatFragment = RiwayatActivity()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, riwayatFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                //Surat
                R.id.bottomNavigationSurat -> {
                    suratFragment = SuratActivity()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, suratFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}