package com.example.basic_camera

import android.app.Activity
import android.content.Context
import androidx.core.content.FileProvider
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

private const val FILE_NAME = "photo"

class MainActivity : AppCompatActivity() {

    private lateinit var photoFile: File
    private lateinit var logFile: File
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageView = findViewById(R.id.image)
        textView = findViewById(R.id.text)
        button = findViewById(R.id.take_photo)

        button.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            logFile = getLogFile(FILE_NAME)
            photoFile = getPhotoFile(FILE_NAME)

            val fileContents = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = fileContents.format(Date()).toString()
            logFile.writeBytes(currentDate.toByteArray())
            textView.text = String(logFile.readBytes())

            val fileProvider = FileProvider.getUriForFile(this, "com.example.basic_camera.fileprovider", photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
            startActivityForResult(takePictureIntent, 42)
        }
    }


    private fun makeLogDir(context: Context): File {
        val logDirectory = File(context.applicationContext.filesDir, "cs4518_logs")
//        val phoDirectory = File(context.applicationContext.filesDir, "cs4518_photos")
        if (!logDirectory.exists()) {
            logDirectory.mkdir()
        }
//        if (!phoDirectory.exists()) {
//            phoDirectory.mkdir()
//        }
        return logDirectory
    }
    private fun makePhotoDir(context: Context): File {
        val photoDirectory = File(context.applicationContext.filesDir, "cs4518_photos")
        if (!photoDirectory.exists()) {
            photoDirectory.mkdir()
        }
        return photoDirectory
    }

    private fun getPhotoFile(fileName: String): File {
        return File.createTempFile(fileName, ".jpg", makePhotoDir(this))
    }

    private fun getLogFile(fileName: String): File {
        return File.createTempFile(fileName, ".txt", makeLogDir(this))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            val imageBitmap = BitmapFactory.decodeFile(photoFile.absolutePath)
            imageView.setImageBitmap(imageBitmap)
        }
        else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}