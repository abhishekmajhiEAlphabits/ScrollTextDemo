package com.example.scrolltextdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.ScrollView
import com.example.scrolltextdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvOut.text = " Hi 0"

        //binding.tvOut.movementMethod = ScrollingMovementMethod()


//        var a: String = "Hi 0"
//        for (i in 1..100) {
//            a = a.plus("Hi$i\n")
//            Log.d("hardikkamothi", "a is $a")
//        }
//        Log.d("hardikkamothi", a)


//        Thread({
//            Runnable {
//                kotlin.run {
//                    a.onEach {
//                        binding.tvOut.text = a
//                        Thread.sleep(10)
//                    }
//                }
//            }
//            println("running from lambda: ${Thread.currentThread()}")
//        }).start()

//        for (i in 1..20000) {
//            binding.tvOut.append("dummy$i\n")
////            binding.scrollOut.post(Runnable {
////                kotlin.run {
////                    binding.tvOut.append("dummy\n")
////                    binding.scrollOut.fullScroll(ScrollView.FOCUS_DOWN)
////
////                }
////            })
////               binding.tvOut.post { Runnable {
////
////               } }
////            binding.scrollOut.smoothScrollTo(0,binding.tvOut.bottom)
//            //binding.tvOut.movementMethod = ScrollingMovementMethod()
//        }

        // var tvOutHeight = binding.tvOut.height

        // var lineTopValue = binding.tvOut.lineCount - tvOutHeight


//        Log.d(
//            "adapter",
//            "scroll LineCount :" + binding.tvOut.lineCount + " - tvOut height" + binding.tvOut.height + " = " + lineTopValue
//        );
//        if(lineTopValue > 0 ){
//            var scrollAmount : Int = binding.tvOut.layout.getLineTop(lineTopValue)
//            Log.d("adapter","scroll scrollAmount :: "+scrollAmount);
//            // if there is no need to scroll, scrollAmount will be <=0
//            if (scrollAmount > 0) {
//                Log.d("adapter","scroll amount :: "+scrollAmount);
//                binding.tvOut.scrollTo(0, scrollAmount);
//                binding.tvOut.scrollBy(0,scrollAmount);
//            }
//            else {
//                Log.d("adapter","scroll scrollAmount :: 0");
//                binding.tvOut.scrollTo(0, 0);
//            }
//        }
    }

    fun appendText(view: View) {

        backGroundTask()

//        binding.tvOut.append("dummy\n")
//        binding.scrollOut.fullScroll(ScrollView.FOCUS_DOWN)

//        binding.tvOut.append("Scrolled\n")
//        binding.scrollOut.post(Runnable { kotlin.run {
//
//                binding.tvOut.append("dummy\n")
//                binding.scrollOut.fullScroll(ScrollView.FOCUS_DOWN)
//
//        } })


    }


    fun backGroundTask() {
        Thread(Runnable {
            kotlin.run {
                for (i in 1..1000) {
                    Thread.sleep(10)
                    runOnUiThread(Runnable {
                        kotlin.run {
                            binding.tvOut.append(" hi$i\n")
                            binding.scrollOut.fullScroll(ScrollView.FOCUS_DOWN)
                            //binding.tvOut.text = a.plus("Hi$i\n")
                        }
                    })
                }
            }

        }).start()

    }
}