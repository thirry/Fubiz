package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.ev.gone.fubiz.Manager.ListViewAdapter;
import com.ev.gone.fubiz.R;

public class AlphaSettingActivity extends AppCompatActivity {


    String songs[] = new String[]{"Requiem", "The Magic Flute", "Piano Sonata No. 11", "Symphony No. 40", "Don Giovanni", "Ave verum corpus"};
    String settimes[] = new String[]{"5 mins", "10 mins", "15 mins", "20 mins", "25 mins", "30 mins", "35 mins", "40 mins", "45 mins", "50 mins", "55 mins", "60 mins"};

    View alpha_btn;
    View setting_time;

    Button backto_alpha_main;

//    Integer[] imgid = {
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//            R.drawable.betal_thirs,
//    };
//

    ListViewAdapter adapter_alpha;
    ListViewAdapter adapter_countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_setting);


        alpha_btn = (View) findViewById(R.id.alpha_setting);
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListView song = (ListView) findViewById(R.id.listview);
                adapter_alpha = new ListViewAdapter(AlphaSettingActivity.this, songs);
                song.setTextFilterEnabled(true);
                song.setAdapter(adapter_alpha);

            }
        });


        setting_time = (View) findViewById(R.id.yanging_setting);
        setting_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListView settime = (ListView) findViewById(R.id.listview);
                adapter_countdown = new ListViewAdapter(AlphaSettingActivity.this, settimes);
//                settime.setTextFilterEnabled(true);
                settime.setAdapter(adapter_countdown);

            }
        });


        backto_alpha_main = (Button) findViewById(R.id.backto_alpha_main);
        backto_alpha_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent redirect_one = new Intent(AlphaSettingActivity.this, AlphaActivity.class);
                startActivity(redirect_one);


            }
        });


    }
}
