package com.ev.gone.fubiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.util.List;

public class AlphaSettingActivity extends AppCompatActivity {


    String songs[] = new String[]{"Requiem", "The Magic Flute", "Piano Sonata No. 11", "Symphony No. 40", "Don Giovanni", "Ave verum corpus"};

    View alpha_btn;

    Button backto_alpha_main;

    // Defined Array of images id
    Integer[] imgid = {
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,

    };


    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_setting);


        alpha_btn = (View) findViewById(R.id.alpha_setting);
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              Intent redirect = new Intent(AlphaSettingActivity.this, AlphaActivity.class);
//              startActivity(redirect);

                ListView song = (ListView) findViewById(R.id.listsong);
                adapter = new ListViewAdapter(AlphaSettingActivity.this, songs, imgid);
                song.setTextFilterEnabled(true);
                song.setAdapter(adapter);

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


//        ListView song = (ListView) findViewById(R.id.listsong);
////      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
//
//        adapter = new ListViewAdapter(AlphaSettingActivity.this, songs, imgid);
//        song.setTextFilterEnabled(true);
//        song.setAdapter(adapter);


    }
}
