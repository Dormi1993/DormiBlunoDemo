package com.dfrobot.angelo.blunobasicdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class LoginActivity extends Activity{

    int wait_time_ms = 3000;

    public void onCreate(Bundle savedInstanceState) {
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_login);

//		Intent intent = new Intent();
//		intent.setClass(LoginActivity.this, PeripheralActivity.class);
//		startActivity(intent);
//		LoginActivity.this.finish();
//		finish();
//
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        Animation myAnimation_Alpha=new AlphaAnimation(0.1f, 1.0f);
        myAnimation_Alpha.setDuration(100);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_log);
        ll.startAnimation(myAnimation_Alpha);
        //BaseApp.getInstance().addActivity(this);

        Thread waitThread = new Thread() {
            public void run() {

                while(wait_time_ms > 0)
                {
                    wait_time_ms -= 100;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        };
        waitThread.start();
    }

    public boolean onTouchEvent(MotionEvent e) {
        wait_time_ms = 0;
        return true;
    }
}
