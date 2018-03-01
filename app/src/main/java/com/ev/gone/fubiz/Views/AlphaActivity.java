package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ev.gone.fubiz.R;

/**
 * Created by gone on 2/24/18.
 */

public class AlphaActivity extends AppCompatActivity{

    Button btn_backtohome;
    Button setting;
    Button time_setting;

    Button alpha_ic;
    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_main);

        btn_backtohome = (Button) findViewById(R.id.backtohome);
        btn_backtohome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent redirect = new Intent(AlphaActivity.this, MainActivity.class);
                startActivity(redirect);

            }

        });

        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent redirect = new Intent(AlphaActivity.this, AlphaSettingActivity.class);
                startActivity(redirect);

            }

        });


        time_setting = (Button) findViewById(R.id.time_setting);
        time_setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent redirect = new Intent(AlphaActivity.this, MainActivity.class);
                startActivity(redirect);

            }

        });

        //animate fo button
        alpha_ic = (Button) findViewById(R.id.alpha_ic);
        alpha_ic.setOnClickListener(mTogglePlayButton);

//        alpha_ic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (v == alpha_ic){
//                    alpha_ic.setBackgroundResource(R.mipmap.alphaic_active);
//                }
//            }
//
//        });



    }

    View.OnClickListener mTogglePlayButton = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            // change your button background

            if(isPlay){
                v.setBackgroundResource(R.mipmap.alphaic);
            }else{
                v.setBackgroundResource(R.drawable.alphaic_active);
            }

            isPlay = !isPlay; // reverse
        }

    };

//    @Override
//    public void onClick(View v) {
//
//        alpha_ic = (Button) findViewById(R.id.alpha_ic);
//
//        if (v == alpha_ic){
//
//            alpha_ic.setBackgroundResource(R.mipmap.alphaic_active);
//
//        }else{
//
//            alpha_ic.setBackgroundResource(R.mipmap.alphaic);
//
//        }
//
//    }



}
