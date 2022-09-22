package uz.orifjon.calculatornative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import uz.orifjon.calculatornative.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sampleText.text = plus(12.0,12.0).toString() + minus(31.0,31.0).toString()
    }


    external fun plus(a:Double,b:Double): Double
    external fun minus(a:Double,b:Double): Double
    external fun multiply(a:Double,b:Double): Double
    external fun divide(a:Double,b:Double): Double

    companion object {
        init {
            System.loadLibrary("calculatornative")
        }
    }
}