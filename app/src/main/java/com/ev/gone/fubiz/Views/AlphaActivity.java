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

public class AlphaActivity extends AppCompatActivity {

    Button btn_backtohome;
    Button setting;
    Button time_setting;

    Button alpha_ic;
    Button volume_ocean;
    boolean isPlay = false;

    boolean isOcean = false;
    boolean isOcean_nd = true;
    boolean isOcean_rd = true;


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
        alpha_ic.setOnClickListener(alphaTogglePlayButton);
        volume_ocean = (Button) findViewById(R.id.ocean_volume);
        volume_ocean.setOnClickListener(oceanTogglePlayButton);

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

    View.OnClickListener alphaTogglePlayButton = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (isPlay) {
                v.setBackgroundResource(R.mipmap.alphaic);
            } else {
                v.setBackgroundResource(R.mipmap.alphaic_active);
            }

            isPlay = !isPlay; // reverse
        }

    };


    View.OnClickListener oceanTogglePlayButton = new View.OnClickListener() {

        View a;

        @Override
        public void onClick(View v) {


            if (isOcean && isOcean_nd && isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_max);


            } else if (!isOcean && isOcean_nd && isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_low);
                isOcean_nd = !isOcean_nd;

            } else if (isOcean && !isOcean_nd && isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
//                isOcean_nd = isOcean_nd;
                isOcean = !isOcean;
                isOcean_rd = !isOcean_rd;

            } else if (isOcean && !isOcean_nd && !isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_max);
                isOcean_nd = !isOcean_nd;
//                isOcean_rd =!isOcean_rd;
            } else if (isOcean && isOcean_nd && !isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_mute);
                isOcean_rd = !isOcean_rd;

            } else if (isOcean && isOcean_nd && isOcean_rd) {
                v.setBackgroundResource(R.mipmap.volume_ocean_low);
            }


            isOcean = !isOcean;

//            if (isOcean) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_max);
//                isOcean_nd = false;
//
//            } else if (isOcean_nd = false) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_low);
//                isOcean_nd = true;
//                isOcean = true;
//
//            } else if(isOcean = true) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
//                isOcean = false;
//            }

//            if (isOcean_nd = true){
//                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
//
//            }else{
//                v.setBackgroundResource(R.mipmap.volume_ocean_max);
//            }

//            if (!isOcean){
//                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
//            }else{
//                v.setBackgroundResource(R.mipmap.volume_ocean_max);
//
//            }

//            isOcean = !isOcean; // reverse
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
