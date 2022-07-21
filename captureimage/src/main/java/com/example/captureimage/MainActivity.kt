package com.example.captureimage


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    private lateinit var imageViewprofile: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewprofile = findViewById<ImageView?>(R.id.capture)


        imageViewprofile.setOnClickListener {

            chooseProfilePictures()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun chooseProfilePictures() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dailogview: View = layoutInflater.inflate(R.layout.alertdialog, null)
        builder.setView(dailogview)


        val imageViewCamera: ImageView = dailogview.findViewById(R.id.camera)
        val imageViewGallery: ImageView = dailogview.findViewById(R.id.gallery)

        val alertDialogProfilePicture: AlertDialog = builder.create()
        alertDialogProfilePicture.show()



        imageViewGallery.setOnClickListener()
        {
            alertDialogProfilePicture.dismiss()
            if (checkAndRequestGalleryPermissions()) {

                takePictureFromGallery()
            }
        }
        imageViewCamera.setOnClickListener()
        {
            alertDialogProfilePicture.dismiss()
            if (checkAndRequestCameraPermissions()) {

                takePictureFromCamera()

            }
        }

    }

    private fun checkAndRequestCameraPermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            val galleryPermission: Int =
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if (galleryPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA), 20
                )
                return false

            }
        }
        return true
    }

    private fun checkAndRequestGalleryPermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            val galleryPermission = ActivityCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            if (galleryPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    30
                )
                return false
            }
        }
        return true
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val selectedImageUri: Uri? = data?.data
                imageViewprofile.setImageURI(selectedImageUri)
            }
            2 -> if (resultCode == RESULT_OK) {
                val bundle = data?.extras
                val bitmapImage = bundle!!["data"] as Bitmap?
                imageViewprofile.setImageBitmap(bitmapImage)
            }
        }
    }

    private fun takePictureFromGallery() {
        val pickPhoto: Intent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, 1)
    }

    private fun takePictureFromCamera() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePicture.resolveActivity(packageManager) != null) {
            startActivityForResult(takePicture, 2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromCamera()
        } else if (requestCode == 30 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromGallery()
        } else Toast.makeText(this@MainActivity, "Permission not Granted", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT)
            Toast.makeText(applicationContext,"Portrait Mode",Toast.LENGTH_LONG).show()
        else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(applicationContext,"Landscape Mode",Toast.LENGTH_SHORT).show()
    }
}