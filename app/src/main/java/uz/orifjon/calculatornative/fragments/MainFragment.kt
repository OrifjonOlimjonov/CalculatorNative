package uz.orifjon.calculatornative.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.orifjon.calculatornative.R
import uz.orifjon.calculatornative.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var result: String


    private var plusBool: Boolean = false
    private var multiplyBool = false
    private var modBool = false
    private var minusBool = false
    private var plusResult = 0.0
    private var minusResult = 0.0
    private var multiplyResult = 0.0
    private var modResult = 0.0
    private var resultEnd = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        result = ""

        binding.apply {

            btnBack.setOnClickListener(this@MainFragment)
            btnOne.setOnClickListener(this@MainFragment)
            btnTwo.setOnClickListener(this@MainFragment)
            btnThree.setOnClickListener(this@MainFragment)
            btnFour.setOnClickListener(this@MainFragment)
            btnFive.setOnClickListener(this@MainFragment)
            btnSix.setOnClickListener(this@MainFragment)
            btnSeven.setOnClickListener(this@MainFragment)
            btnEight.setOnClickListener(this@MainFragment)
            btnNine.setOnClickListener(this@MainFragment)
            btnZero.setOnClickListener(this@MainFragment)
            btnClear.setOnClickListener(this@MainFragment)
            btnMod.setOnClickListener(this@MainFragment)
            btnSign.setOnClickListener(this@MainFragment)
            btnPoint.setOnClickListener(this@MainFragment)
            btnMultiply.setOnClickListener(this@MainFragment)
            btnMinus.setOnClickListener(this@MainFragment)
            btnPlus.setOnClickListener(this@MainFragment)
            btnEqual.setOnClickListener(this@MainFragment)

        }



        return binding.root
    }

    external fun plus(a: Double, b: Double): Double
    external fun minus(a: Double, b: Double): Double
    external fun multiply(a: Double, b: Double): Double
    external fun divide(a: Double, b: Double): Double

    companion object {
        init {
            System.loadLibrary("calculatornative")
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {

        when (p0!!.id) {
            R.id.btnOne -> {
                result += "1"
                binding.tv.text = result
            }
            R.id.btnTwo -> {
                result += "2"
                binding.tv.text = result
            }
            R.id.btnThree -> {
                result += "3"
                binding.tv.text = result
            }
            R.id.btnFour -> {
                result += "4"
                binding.tv.text = result
            }
            R.id.btnFive -> {
                result += "5"
                binding.tv.text = result
            }
            R.id.btnSix -> {
                result += "6"
                binding.tv.text = result
            }
            R.id.btnSeven -> {
                result += "7"
                binding.tv.text = result
            }
            R.id.btnEight -> {
                result += "8"
                binding.tv.text = result
            }
            R.id.btnNine -> {
                result += "9"
                binding.tv.text = result
            }
            R.id.btnZero -> if (binding.tv.text != "0") {
                result += "0"
                binding.tv.text = result
            }
            R.id.btnClear -> {
                binding.tv.text = "0"
                binding.tvResult.text = ""
                result = ""
                resultEnd = ""
                plusBool = false
                multiplyBool = false
                modBool = false
                minusBool = false
                plusResult = 0.0
                minusResult = 0.0
                multiplyResult = 0.0
                modResult = 0.0
            }
            R.id.btnBack -> {
                binding.tv.text = "0"
                result = ""
            }
            R.id.btnSign -> {
                val k: Double = binding.tv.text.toString().toDouble()
                if (k != 0.0) {
                    if (typeNumber(k)) {
                        val p = (k * -1).toLong()
                        binding.tv.text = p.toString()
                        result = p.toString()
                    } else {
                        binding.tv.text = (k * -1).toString()
                        result = (k * -1).toString()
                    }
                }
            }
            R.id.btnPoint -> {
                if (!result.contains(".")) {
                    result += if (result.isEmpty()) {
                        "0."
                    } else {
                        "."
                    }
                }
                binding.tv.text = result
            }
            R.id.btnPlus -> {
                val number1: Double = binding.tv.text.toString().toDouble()
                if (binding.tvResult.text.isEmpty()) {
                    plusResult = number1
                } else {
                    plusResult = binding.tvResult.text.toString().toDouble()
                    plusResult = plus(plusResult, number1) //TODO: Shu yerda Native plus
                }
                binding.tv.text = "0"
                if (plusResult - plusResult.toLong() == 0.0) {
                    binding.tvResult.text = plusResult.toLong().toString()
                } else {
                    val num: Double = plusResult
                    binding.tvResult.text = num.toFloat().toString()
                }
                resultEnd = plusResult.toString()
                result = ""
                plusBool = true
            }
            R.id.btnMinus -> {
                val number: Double = binding.tv.text.toString().toDouble()
                if (binding.tvResult.text.isEmpty()) {
                    minusResult = number
                } else {
                    minusResult = binding.tvResult.text.toString().toDouble()
                    minusResult = minus(minusResult, number)
                }
                binding.tv.text = "0"
                if (minusResult - minusResult.toLong() == 0.0) {
                    binding.tvResult.text = minusResult.toLong().toString()
                } else {
                    val num: Double = minusResult
                    binding.tvResult.text = num.toFloat().toString()
                }
                resultEnd = minusResult.toString()
                result = ""
                minusBool = true
            }
            R.id.btnMultiply -> {
                val number2: Double = binding.tv.text.toString().toDouble()
                if (binding.tvResult.text.isEmpty()) {
                    multiplyResult = number2
                } else {
                    multiplyResult = binding.tvResult.text.toString().toDouble()
                    multiplyResult = multiply(multiplyResult, number2) // TODO : NATIVE
                }
                binding.tv.text = "0"
                if (multiplyResult - multiplyResult.toLong() == 0.0) {
                    binding.tvResult.text = multiplyResult.toLong().toString()
                } else {
                    binding.tvResult.text = multiplyResult.toString()
                }
                resultEnd = multiplyResult.toString()
                result = ""
                multiplyBool = true
            }
            R.id.btnMod -> {
                val number3: Double = binding.tv.text.toString().toDouble()
                if (binding.tvResult.text.isEmpty()) {
                    modResult = number3
                } else {
                    modResult = binding.tvResult.text.toString().toDouble()
                    if (number3 == 0.0) {
                        Toast.makeText(
                            requireContext(),
                            "Cannot be divided by 0",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        modResult = divide(modResult, number3)
                    }
                }
                binding.tv.text = "0"
                if (modResult - modResult.toLong() == 0.0) {
                    binding.tvResult.text = modResult.toLong().toString()
                } else {
                    val num: Double = modResult
                    binding.tvResult.text = num.toFloat().toString()
                }
                resultEnd = modResult.toString()
                result = ""
                modBool = true
            }
            R.id.btnEqual -> {
                val resultAdd: Double = binding.tv.text.toString().toDouble()
                if (plusBool) {
                    val resultEquel = resultEnd.toDouble()
                    if (plus(resultEquel, resultAdd) - plus(resultEquel, resultAdd).toInt() == 0.0) {
                        binding.tv.text = (resultEquel + resultAdd).toInt().toString()
                    } else {
                        val num = plus(resultEquel, resultAdd) // TODO : Plus Native
                        binding.tv.text = num.toFloat().toString()
                    }
                    binding.tvResult.text = ""
                    plusResult = 0.0
                    plusBool = false
                }
                if (minusBool) {
                    val resultEquel = resultEnd.toDouble()
                    if (minus(resultEquel, resultAdd) - minus(
                            resultEquel,
                            resultAdd
                        ).toInt() == 0.0
                    ) {
                        binding.tv.text =
                            minus(resultEquel, resultAdd).toInt().toString() // TODO : NATIVE
                    } else {
                        val num = minus(resultEquel, resultAdd)
                        binding.tv.text = num.toFloat().toString()
                    }
                    binding.tvResult.text = ""
                    minusResult = 0.0
                    minusBool = false
                }
                if (multiplyBool) {
                    val resultEquel = resultEnd.toDouble()
                    if (multiply(resultEquel, resultAdd) - multiply(
                            resultEquel,
                            resultAdd
                        ).toInt() == 0.0
                    ) {
                        binding.tv.text =
                            multiply(resultEquel, resultAdd).toInt().toString() // TODO : NATIVE
                    } else {
                        binding.tv.text =
                            multiply(resultEquel, resultAdd).toString() // TODO : NATIVE
                    }
                    binding.tvResult.text = ""
                    multiplyResult = 0.0
                    multiplyBool = false
                }
                if (modBool) {
                    val resultEquel = resultEnd.toDouble()
                    if (resultAdd == 0.0) {
                        Toast.makeText(
                            requireContext(),
                            "Cannot be divided by 0",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.tv.text = "0"
                        result = ""
                    } else {
                        if (divide(resultEquel, resultAdd) - divide(
                                resultEquel,
                                resultAdd
                            ).toInt() == 0.0
                        ) {
                            binding.tv.text = divide(resultEquel, resultAdd).toInt().toString()
                        } else {
                            val num = divide(resultEquel, resultAdd) // TODO : NATIVE
                            binding.tv.text = num.toFloat().toString()
                        }
                    }
                    binding.tvResult.text = ""
                    modResult = 0.0
                    modBool = false
                }
                result = ""
            }
        }
    }

    private fun typeNumber(number: Double): Boolean {
        return number - number.toLong() == 0.0
    }
}