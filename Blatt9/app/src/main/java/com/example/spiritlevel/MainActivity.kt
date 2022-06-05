package com.example.spiritlevel

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.atan2


class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager:SensorManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorSetup()
    }
    var gData = FloatArray(3) // accelerometer
    var mData = FloatArray(3) // magnetometer
    var rMat = FloatArray(9)
    var iMat = FloatArray(9)
    var orientation = FloatArray(3)
    var mAzimuth = 0;
    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.sensor?.type== Sensor.TYPE_ACCELEROMETER){
            gData = event.values.clone();
        }
        if(event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD){
            mData = event.values.clone();
        }
        var angle = atan2(gData[0].toDouble(), gData[1].toDouble())/(Math.PI/180)
        Log.d("TAG",angle.toString())
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
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
}