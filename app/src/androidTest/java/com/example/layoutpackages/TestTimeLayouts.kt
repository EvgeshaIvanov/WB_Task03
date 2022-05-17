package com.example.layoutpackages

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class TestTimeLayouts {

    private val layoutInflater by lazy { LayoutInflater.from(getInstrumentation().targetContext) }

    @Test

    fun test() {

        Log.i("time", "constraint facebook : ${getLayoutTimeInSec(R.layout.fragment_facebook_c_l)} sec")
        Log.i("time", "linear facebook: ${getLayoutTimeInSec(R.layout.fragment_facebook)} sec")

        Log.i("time", "constraint audio player : ${getLayoutTimeInSec(R.layout.fragment_audio_player_c_l)} sec")
        Log.i("time", "linear audio player: ${getLayoutTimeInSec(R.layout.fragment_audio_player)} sec")

        Log.i("time", "constraint telegramm : ${getLayoutTimeInSec(R.layout.fragment_telegramm_profile_c_l)} sec")
        Log.i("time", "linear telegramm: ${getLayoutTimeInSec(R.layout.fragment_telegramm_profile)} sec")

        Log.i("time", "constraint calculator : ${getLayoutTimeInSec(R.layout.fragment_calculator_c_l)} sec")
        Log.i("time", "linear calculator: ${getLayoutTimeInSec(R.layout.fragment_calculator)} sec")

    }
    private fun getLayoutTimeInSec(@LayoutRes layoutRes: Int): Long{
        return getLayoutTime(layoutRes) / 1000
    }
    private fun getLayoutTime(@LayoutRes layoutRes: Int): Long {
        val startTime = System.currentTimeMillis()
        for (i in 0..999) {
            layoutInflater.inflate(layoutRes, null).apply {
                layoutParams = ViewGroup.LayoutParams(0, 0)
                measure(
                    View.MeasureSpec.makeMeasureSpec(1000, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
                layout(0, 0, measuredWidth, measuredHeight)
            }
        }
        return System.currentTimeMillis() - startTime
    }
}