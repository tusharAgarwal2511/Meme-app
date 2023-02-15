package com.example.memeapp

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.memeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding : ActivityMainBinding
    private lateinit var apiViewModel : ApiViewModel

    private lateinit var memeImageURl : String //string that golds the image url

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        checkDeviceTheme() // sets background according to the device theme

        // creating the object of ApiViewModel
        apiViewModel = ViewModelProvider(this)[ApiViewModel::class.java]

        // the url of the meme image
        memeImageURl = apiViewModel.memeImageUrl
        mainActivityBinding.btnNextMeme.setOnClickListener {

            Log.e("MyTag", memeImageURl)
        }
    }


    //function to check if device is in night mode or day mode
    private fun checkDeviceTheme(){

        /**
         *
         * Checking if device is in dark mode or light mode
         * if device is in light mode the main layout background color will be background_light
         * and if device is in dark mode the main layout will be background_dark
         *
         */
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                mainActivityBinding.rootLayout.setBackgroundColor(resources.getColor(R.color.background_dark))
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                mainActivityBinding.rootLayout.setBackgroundColor(resources.getColor(R.color.background_light))
            }
        }
    }

}