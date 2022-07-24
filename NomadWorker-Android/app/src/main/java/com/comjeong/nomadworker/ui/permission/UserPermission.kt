package com.comjeong.nomadworker.ui.permission

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.comjeong.nomadworker.ui.permission.UserPermission.requestPhotoGalleryPermission
import java.util.jar.Manifest

object UserPermission {
    fun Activity.isGrantedLocationPermission() : Boolean {
        val fineLocation = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocation = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_COARSE_LOCATION)

        return (fineLocation == PackageManager.PERMISSION_GRANTED) && (coarseLocation == PackageManager.PERMISSION_GRANTED)
    }

    fun Activity.isGrantedPhotoGalleryPermission() : Boolean {
        val photoGallery = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE)

        return photoGallery == PackageManager.PERMISSION_GRANTED
    }

    fun Activity.isGrantedAllPermission() : Boolean {
        return isGrantedLocationPermission() && isGrantedPhotoGalleryPermission()
    }

    fun Activity.requestLocationPermission(){
        ActivityCompat.requestPermissions(this,
        arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION),1)
    }

    fun Activity.requestPhotoGalleryPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),2)
    }

    fun Activity.requestAllPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.READ_EXTERNAL_STORAGE),3)
    }

    fun isGrantedPermission(grantResults : IntArray) : Boolean {
        var i = 0
        while (i < grantResults.size){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                return false
            }
            i += 1
        }
        return true
    }
}