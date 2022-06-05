package com.example.spiritlevelnew

import android.app.Activity
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import kotlin.math.atan2
import android.util.DisplayMetrics




class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var degreeBar: ImageView
    lateinit var circle:ImageView
    var displayMetrics = DisplayMetrics()


    var gData = FloatArray(3) // accelerometer
    var mData = FloatArray(3) // magnetometer
    var rMat = FloatArray(9)
    var iMat = FloatArray(9)
    var orientation = FloatArray(3)
    var mAzimuth = 0;
    var oldDeg = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.degreeBar = findViewById(R.id.degreeBar)
        this.circle = findViewById(R.id.circle)
        sensorSetup()
    }

    private fun getScreenWidth(activity: Activity):Int{
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.sensor?.type== Sensor.TYPE_ACCELEROMETER){
            gData = event.values.clone();
        }
        if(event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD){
            mData = event.values.clone();
        }
        var angle = atan2(gData[0].toDouble(), gData[1].toDouble()) /(Math.PI/180)

        if(oldDeg != angle){
            Log.d("TAG",angle.toString())
            degreeBar.rotation = angle.toFloat();
            oldDeg=angle
        moveCircle(angle)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun sensorSetup(){
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager;
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(this,it,
                SensorManager.SENSOR_DELAY_NORMAL,
                SensorManager.SENSOR_DELAY_NORMAL)
        }
        sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)?.also {
            sensorManager.registerListener(this,it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private fun moveCircle(angle:Double){
        var width = getScreenWidth(this)
        var diff = width/180

        circle.x = (width/2)+(angle.toFloat()*diff)-50
        Log.d("Should be 0",circle.x.toString())

    }
}