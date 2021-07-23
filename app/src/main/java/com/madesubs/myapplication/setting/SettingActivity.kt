package com.madesubs.myapplication.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.madesubs.myapplication.R
import com.madesubs.myapplication.databinding.ActivitySettingBinding
import com.madesubs.myapplication.home.HomeFragment

class SettingActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.setting_title)

        binding.languange.setOnClickListener {
            val languange = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(languange)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                val uri = Uri.parse("movieapp://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
            R.id.nav_setting ->{
                Intent(this, SettingActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}