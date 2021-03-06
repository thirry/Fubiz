package com.ev.gone.fubiz.Views;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ev.gone.fubiz.Adapters.LinkSongsAdapter;
import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.Models.Songs;
import com.ev.gone.fubiz.R;

import java.io.IOException;
import java.util.ArrayList;

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


    Button budhist_ic;
    boolean isPlay_piano = false;
    boolean isPiano = false;
    boolean isPiano_nd = true;
    boolean isPiano_rd = true;

    int maxVolume = 50;

    MediaPlayer mPlayers;
    MediaPlayer mPlayer;

    Button hehe;

    Boolean wifiConnected;
    Boolean mobileConnected;

    private Toast mToastToShow;



    private Songs mSong;

    private TextView tvTest;

    private ArrayList<LinkSongs> mList;
    private LinkSongsAdapter mLinkSongsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_main);

        checkConnection();

        mPlayers = new MediaPlayer();


//        Intent intent = getIntent();
//        mSong = (Songs) intent.getSerializableExtra("fetch_song_name") ;
//
//        tv_test = findViewById(R.id.tvTest_alpha);
//        mList = SongManager.getInstance().getLinkSongs(mSong);
//        mLinkSongsAdapter = new LinkSongsAdapter( this, R.layout.items_link_song, mList);
//        tv_test.setAdapter(mLinkSongsAdapter);


        tvTest = findViewById(R.id.tvTest_alpha);

        Intent intent = getIntent();

        tvTest.setText(intent.getStringExtra("push_song"));

        final String str = intent.getStringExtra("push_url");


//        try{
//
//            mPlayers.setDataSource(str);
//            mPlayers.prepare();
////            mPlayers.start();
//
//        }catch (IOException e){
//            Log.v("lost data", e.getMessage());
//        }

        if (str == null){

//            Toast.makeText(getApplicationContext(), "You need choose a song.",
//                    Toast.LENGTH_SHORT).show();
            mPlayers = MediaPlayer.create(this, R.raw.clairdelune);

        }else{

            try{

                mPlayers.setDataSource(str);
                mPlayers.prepare();

            }catch (IOException e){
                Log.v("lost data", e.getMessage());
            }

        }

        //alpha waves button
        final MediaPlayer mPlayerAlpha = MediaPlayer.create(this, R.raw.alpha10dot0hz);

        //animate fo button
        alpha_ic = (Button) findViewById(R.id.alpha_ic);




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

                mPlayers.reset();
                mPlayers.pause();
                mPlayerAlpha.reset();
                mPlayerAlpha.pause();

                Intent redirect = new Intent(AlphaActivity.this, AlphaSettingActivity.class);
                startActivity(redirect);

            }

        });


        time_setting = (Button) findViewById(R.id.time_setting);
        time_setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent redirect = new Intent(AlphaActivity.this, CountdownActivity.class);
                startActivity(redirect);

            }

        });

        alpha_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPlay) {
                    v.setBackgroundResource(R.mipmap.alphaic);
                    mPlayerAlpha.pause();
                } else {
                    v.setBackgroundResource(R.mipmap.alphaic_active);
                    mPlayerAlpha.start();
                    mPlayerAlpha.setVolume((float) 0.3, (float) 0.3);
                    mPlayerAlpha.setLooping(true);
                }

                isPlay = !isPlay; // reverse
            }
        });


        // piano button
        budhist_ic = (Button) findViewById(R.id.budhist_ic);
        budhist_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(str);

                if (isPiano && isPiano_nd && isPiano_rd) {
                    v.setBackgroundResource(R.mipmap.volume_piano_max);


                } else if (!isPiano && isPiano_nd && isPiano_rd) {
                    isPiano_nd = !isPiano_nd;

                    v.setBackgroundResource(R.mipmap.volume_piano_low);
                    mPlayers.start();
                    mPlayers.setVolume((float) 0.4, (float) 0.4);
                    mPlayers.setLooping(true);

                } else if (isPiano && !isPiano_nd && isPiano_rd) {

                    v.setBackgroundResource(R.mipmap.volume_piano_middle);

                    isPiano = !isPiano;
                    isPiano_rd = !isPiano_rd;
                    mPlayers.start();
                    mPlayers.setVolume((float) 0.7, (float) 0.7);
                    mPlayers.setLooping(true);

                } else if (isPiano && !isPiano_nd && !isPiano_rd) {

                    v.setBackgroundResource(R.mipmap.volume_piano_max);
                    isPiano_nd = !isPiano_nd;
                    mPlayers.start();
                    mPlayers.setVolume((float) 1.0, (float) 1.0);

                } else if (!isPiano && isPiano_nd && !isPiano_rd) {
                    v.setBackgroundResource(R.mipmap.budhist);
                    isPiano_rd = !isPiano_rd;

                    mPlayers.pause();

                } else if (!isPiano && isPiano_nd && !isPiano_rd) {

                    v.setBackgroundResource(R.mipmap.volume_piano_low);
                    mPlayers.start();
                    mPlayers.setVolume((float) 0.4, (float) 0.4);
                    mPlayers.setLooping(true);

                }
                isPiano = !isPiano;
            }
        });

        Intent intentocean = new Intent(AlphaActivity.this, CountdownActivity.class);



        final MediaPlayer mPlayerOcean = MediaPlayer.create(this, R.raw.oceansounds);

        intentocean.putExtra("lol", mPlayerOcean + " ");

        volume_ocean = (Button) findViewById(R.id.ocean_volume);
        volume_ocean.setOnClickListener(new View.OnClickListener() {

            View a;

            @Override
            public void onClick(View v) {


                if (isOcean && isOcean_nd && isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_max);
                    mPlayerOcean.pause();

                } else if (!isOcean && isOcean_nd && isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_low);
                    isOcean_nd = !isOcean_nd;

                    mPlayerOcean.start();
                    mPlayerOcean.setVolume((float) 0.4, (float) 0.4);


                } else if (isOcean && !isOcean_nd && isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_middle);
//                  isOcean_nd = isOcean_nd;
                    isOcean = !isOcean;
                    isOcean_rd = !isOcean_rd;

//                    mPlayerOcean.start();
                    mPlayerOcean.setVolume((float) 0.7, (float) 0.7);

                } else if (isOcean && !isOcean_nd && !isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_max);
                    isOcean_nd = !isOcean_nd;
//                isOcean_rd =!isOcean_rd;

//                    mPlayerOcean.start();
                    mPlayerOcean.setVolume((float) 1.0, (float) 1.0);

                } else if (!isOcean && isOcean_nd && !isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_mute);
                    isOcean_rd = !isOcean_rd;

                    mPlayerOcean.pause();


                } else if (isOcean && isOcean_nd && isOcean_rd) {
                    v.setBackgroundResource(R.mipmap.volume_ocean_low);
                    mPlayerOcean.start();
                    mPlayerOcean.setVolume((float) 0.4, (float) 0.4);

                }

                isOcean = !isOcean;

            }

        });

    }


    private void checkConnection(){

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Service.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){

            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if (wifiConnected){


            }else{


            }


        }else {
           showToast();
        }
    }

    public void showToast() {
        // Set the toast and duration
        int toastDurationInMilliSeconds = 10000;
        mToastToShow = Toast.makeText(this, "You are in offline-mode", Toast.LENGTH_LONG);

        // Set the countdown to display the toast
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                mToastToShow.show();
            }
            public void onFinish() {
                mToastToShow.cancel();
            }
        };

        // Show the toast and starts the countdown
        mToastToShow.show();
        toastCountDown.start();
    }


}

































































// /////////

//out create function


//
//    View.OnClickListener pianoTogglePlayButton = new View.OnClickListener() {
//
//        View a;
//
//        @Override
//        public void onClick(View v) {
//
//
//            if (isPiano && isPiano_nd && isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.volume_piano_max);
//
//
//            } else if (!isPiano && isPiano_nd && isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.volume_piano_low);
//                isPiano_nd = !isPiano_nd;
//
//            } else if (isPiano && !isPiano_nd && isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.volume_piano_middle);
//
//                isPiano = !isPiano;
//                isPiano_rd = !isPiano_rd;
//
//            } else if (isPiano && !isPiano_nd && !isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.volume_piano_max);
//                isPiano_nd = !isPiano_nd;
//
//            } else if (!isPiano && isPiano_nd && !isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.budhist);
//                isPiano_rd = !isPiano_rd;
//
//            } else if (!isPiano && isPiano_nd && !isPiano_rd) {
//                v.setBackgroundResource(R.mipmap.volume_piano_low);
//            }
//
//
//            isPiano = !isPiano;
//
//        }
//
//    };


//    View.OnClickListener oceanTogglePlayButton = new View.OnClickListener() {
//
//        View a;
//
//        @Override
//        public void onClick(View v) {
//
//
//            if (isOcean && isOcean_nd && isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_max);
//
//
//            } else if (!isOcean && isOcean_nd && isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_low);
//                isOcean_nd = !isOcean_nd;
//
//            } else if (isOcean && !isOcean_nd && isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
////                isOcean_nd = isOcean_nd;
//                isOcean = !isOcean;
//                isOcean_rd = !isOcean_rd;
//
//            } else if (isOcean && !isOcean_nd && !isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_max);
//                isOcean_nd = !isOcean_nd;
////                isOcean_rd =!isOcean_rd;
//            } else if (!isOcean && isOcean_nd && !isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_mute);
//                isOcean_rd = !isOcean_rd;
//
//            } else if (isOcean && isOcean_nd && isOcean_rd) {
//                v.setBackgroundResource(R.mipmap.volume_ocean_low);
//            }
//
//
//            isOcean = !isOcean;
//
////            if (isOcean) {
////                v.setBackgroundResource(R.mipmap.volume_ocean_max);
////                isOcean_nd = false;
////
////            } else if (isOcean_nd = false) {
////                v.setBackgroundResource(R.mipmap.volume_ocean_low);
////                isOcean_nd = true;
////                isOcean = true;
////
////            } else if(isOcean = true) {
////                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
////                isOcean = false;
////            }
//
////            if (isOcean_nd = true){
////                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
////
////            }else{
////                v.setBackgroundResource(R.mipmap.volume_ocean_max);
////            }
//
////            if (!isOcean){
////                v.setBackgroundResource(R.mipmap.volume_ocean_middle);
////            }else{
////                v.setBackgroundResource(R.mipmap.volume_ocean_max);
////
////            }
//
////            isOcean = !isOcean; // reverse
//        }
//
//    };


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


//}
