package com.ev.gone.fubiz;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    CircleMenu circleMenu;
    CircleMenu circleMenuSe;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);


//        circleMenuSe = (CircleMenu) findViewById(R.id.circle_menu);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(MainActivity.this, Loading.class);
//                startActivity(homeIntent);
//                finish();
//            }
//        }, SLASH_TIME_OUT);


//        final MediaPlayer slideSound = MediaPlayer.create(this, R.raw.silde);
//
//        Button slider = (Button) findViewById(R.id.circle_menur);
//
//        slider.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                slideSound.start();
//            }
//
//        });

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);

        circleMenu.addSubMenu(Color.parseColor("#C27DF3"), R.mipmap.omega)
                .addSubMenu(Color.parseColor("#9DFCF7"), R.mipmap.alpha)
                .addSubMenu(Color.parseColor("#FF885D"), R.mipmap.delta)
                .addSubMenu(Color.parseColor("#FFD088"), R.mipmap.gamma)
                .addSubMenu(Color.parseColor("#CDB7A0"), R.drawable.betal_thirs)
                .addSubMenu(Color.parseColor("#88C0FF"), R.mipmap.theta);


        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Toast.makeText(MainActivity.this, "xxx button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 1:
                                                             Intent redirectAlpha = new Intent(MainActivity.this, AlphaActivity.class);
                                                             startActivity(redirectAlpha);
                                                             break;
                                                         case 2:
                                                             Toast.makeText(MainActivity.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 3:
                                                             Toast.makeText(MainActivity.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 4:
                                                             Toast.makeText(MainActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case 5:
                                                             Intent redirect = new Intent(MainActivity.this, AlphaActivity.class);
                                                             startActivity(redirect);
                                                             break;

                                                     }
                                                 }
                                             }

        );
//
//        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
//
//                                                     @Override
//                                                     public void onMenuOpened() {
//                                                         Toast.makeText(MainActivity.this, "Menu Opend", Toast.LENGTH_SHORT).show();
//                                                     }
//
//                                                     @Override
//                                                     public void onMenuClosed() {
//                                                         Toast.makeText(MainActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
//                                                     }
//                                                 }
//        );


    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

}
