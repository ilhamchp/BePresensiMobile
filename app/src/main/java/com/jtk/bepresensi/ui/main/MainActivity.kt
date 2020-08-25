package com.jtk.bepresensi.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jtk.bepresensi.R
import com.jtk.bepresensi.ui.home.HomeFragment
import com.jtk.bepresensi.ui.profil.ProfilFragment
import com.jtk.bepresensi.ui.riwayat.RiwayatFragment
import com.jtk.bepresensi.ui.surat.SuratFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView(){
        //set default fragment on start
        replaceFragment(HomeFragment())

        //Bottom navigation ketika diklik
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.bottomNavigationHome ->{
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottomNavigationProfil ->{
                    replaceFragment(ProfilFragment())
                    true
                }
                R.id.bottomNavigationRiwayat ->{
                    replaceFragment(RiwayatFragment())
                    true
                }
                R.id.bottomNavigationSurat ->{
                    replaceFragment(SuratFragment())
                    true
                }
                else-> false
            }
        }

        // Bottom navigation jika klik di fragment yang aktif
        bottom_navigation.setOnNavigationItemReselectedListener {
            //do nothing
        }

    }


    override fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()    }
}