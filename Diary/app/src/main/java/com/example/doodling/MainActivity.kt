package com.example.doodling

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import kotlinx.android.synthetic.main.loading.*
import kotlin.concurrent.thread
import com.example.doodling.Login as Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)

        //스크린 사이즈 가져오기
        val display = windowManager.defaultDisplay;
        val size = Point();//pixel로 저장됨
        display.getRealSize(size);
        val width = size.x;
        val height = size.y;

        activity_chagne();

    }

    fun activity_chagne(){
        Handler().postDelayed({
            var intent = Intent(this,Login::class.java);
            startActivity(intent);
            finish();
        }, 2000)
    }
}