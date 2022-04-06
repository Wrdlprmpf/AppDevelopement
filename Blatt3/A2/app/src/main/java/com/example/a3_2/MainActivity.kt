package at.aau.a3_2

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a3_2.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding
private var circleX = 0F
private var circleY = 0F

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val holder = binding.surfaceView.holder
            val canvas = holder.lockCanvas()
            canvas.drawColor(Color.BLACK)
            val x = Random.nextInt(0, canvas.width).toFloat()
            val y = Random.nextInt(0, canvas.height).toFloat()
            val r = Random.nextInt(50, 100).toFloat()
            val paint = Paint()
            paint.color = Color.RED
            canvas.drawCircle(x, y, r, paint)
            circleX = x
            circleY = y
            holder.unlockCanvasAndPost(canvas)
        }

        binding.surfaceView.setOnTouchListener { _, event ->
            if (event != null && event.action == MotionEvent.ACTION_DOWN) {
                event.x
                val distance = sqrt(
                    (event.x - circleX).toDouble().pow(2.0) +
                            (event.y - circleY).toDouble().pow(2.0)
                )
                Log.d("TAG", "${event.x} - $circleX, ${event.y} - $circleY, $distance")
                Toast.makeText(
                    this,
                    "Distance: $distance",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return@setOnTouchListener false
        }
    }
}