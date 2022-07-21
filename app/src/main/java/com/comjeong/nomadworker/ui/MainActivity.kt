package com.comjeong.nomadworker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.comjeong.nomadworker.R
import com.comjeong.nomadworker.databinding.ActivityMainBinding
import com.comjeong.nomadworker.ui.common.BaseActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationView()
        setNavigationBarVisibility()

    }

    private fun initNavigationView() {
        binding.bnvMain.setupWithNavController(findNavController())
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment

        return navHostFragment.navController
    }

    private fun setNavigationBarVisibility() {
        findNavController().addOnDestinationChangedListener { _, destination, _ ->
            binding.bnvMain.visibility =
                when (destination.id) {
                    R.id.navigation_feed, R.id.navigation_home,
                    R.id.navigation_search, R.id.navigation_my_page -> View.VISIBLE
                    else -> View.GONE
            }
        }
    }

}