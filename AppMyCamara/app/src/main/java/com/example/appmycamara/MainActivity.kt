package com.example.appmycamara

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCamara = findViewById<Button>(R.id.btCamara)

        btCamara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "No tienes permiso..." ,Toast.LENGTH_SHORT).show()
            requestCamaraPermission()
        }else{
            Toast.makeText(this, "Ya cuenta on permiso a la camara" ,Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCamaraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            Toast.makeText(this, "Rechazo el permiso antes, debe activar permiso manualmente", Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso otorgado", Toast.LENGTH_SHORT).show()

                    //funcionalidades
                }else{
                    Toast.makeText(this, "Permiso NEGADO!!!", Toast.LENGTH_SHORT).show()

                }
                return
            }
        }
    }
}