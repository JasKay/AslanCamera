package com.example.aslancamera

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button;

/* A test? */

class MainActivity : AppCompatActivity() {
//    private ImageView myImage;
//    private Button myButton;

    private val PERMISSION_CODE: Int =100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button click
        button.setOnClickListener{
            //if system OS is Marshmallow or above, we need to request runtime permission
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    //permission was not enabled
                    val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    //show popup to request permisiion
                    requestPermissions(permission, PERMISSION_CODE)
                }
            else{
                    //permission already granted
                    openCamera()
                }
            } else{
                //system OS is < Marshmallow
                openCamera()
            }
        }
    }

    private fun openCamera() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
