package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.ASSERT
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    val logtag = "LifeCycleInfo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cycleInfo = "onCreate"
        Log.d("LifeCycleDebug",cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onStart() {
        super.onStart()
        val cycleInfo = "onStart"
        Log.i(logtag,cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onRestart() {
        super.onRestart()
        val cycleInfo = "onRestart"
        Log.v("LifeCycleVerbose",cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onResume() {
        super.onResume()
        val cycleInfo = "onResume"
        Log.w("LifeCycleWarning",cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onPause() {
        super.onPause()
        val cycleInfo = "onPause"
        Log.e("LifeCycleError",cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onStop() {
        super.onStop()
        val cycleInfo = "onStop"
        Log.i(logtag,cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        val cycleInfo = "onDestroy"
        Log.i(logtag,cycleInfo);
        val toast = Toast.makeText(applicationContext, cycleInfo, Toast.LENGTH_SHORT)
        toast.show()
    }
}