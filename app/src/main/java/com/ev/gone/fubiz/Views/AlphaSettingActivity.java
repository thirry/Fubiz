package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ev.gone.fubiz.Manager.ListViewAdapter;
import com.ev.gone.fubiz.Manager.SongManager;
import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.Models.Songs;
import com.ev.gone.fubiz.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AlphaSettingActivity extends AppCompatActivity {


//    String settimes[] = new String[]{"5 mins", "10 mins", "15 mins", "20 mins", "25 mins", "30 mins", "35 mins", "40 mins", "45 mins", "50 mins", "55 mins", "60 mins"};

    View alpha_btn;
//    View setting_time;

    Button backto_alpha_main;

    DatabaseReference mData;
    String mDatase[];




    // data
    ArrayList<String> ListSong;
    ArrayAdapter data_adapter = null;

    ArrayList<String> ListUrl;

    ListViewAdapter data_adapter_test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_setting);


        // mapping with data
        mData = FirebaseDatabase.getInstance().getReference();



        SongManager.getInstance().load();
//        mSongsName = SongManager.getInstance().getSongName();

        final ListView lvsong = (ListView) findViewById(R.id.listview);

        ListSong = new ArrayList<String>();
        ListUrl = new ArrayList<String>();

//        data_adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListSong);
//        lvsong.setAdapter(data_adapter);


        data_adapter_test = new ListViewAdapter(AlphaSettingActivity.this, ListSong);
        lvsong.setAdapter(data_adapter_test);



        alpha_btn = (View) findViewById(R.id.alpha_setting);
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.child("Song").addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        Songs info = dataSnapshot.getValue(Songs.class);
                        ListSong.add(info.name);
                        ListUrl.add(info.url);
                        data_adapter_test.notifyDataSetChanged();

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

//                adapter_alpha = new ListViewAdapter(AlphaSettingActivity.this, mSongsName);
//                lvsong.setAdapter(adapter_alpha);
//
//                //end
//
//                lvsong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        Toast.makeText(getApplicationContext(),
//                                "Selected " + mSongsName[position], Toast.LENGTH_SHORT).show();
//
//                        ArrayList<Songs> songArrayList = SongManager.getInstance().getSongs();
//                        Songs songs = songArrayList.get(position);
//
//                        Intent intent = new Intent(AlphaSettingActivity.this, AlphaActivity.class);
//                        intent.putExtra("fetch_song_name", songs);
//                        startActivity(intent);
//                    }
//                });

            }
        });


        lvsong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(0).toString());


                    myIntent.putExtra("push_url", ListUrl.get(0));
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(1).toString());


                    myIntent.putExtra("push_url", ListUrl.get(1));
                    startActivityForResult(myIntent, 1);
                }

                if (position == 2){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(2).toString());


                    myIntent.putExtra("push_url", ListUrl.get(2));
                    startActivityForResult(myIntent, 2);
                }

            }
        });

//        setting_time = (View) findViewById(R.id.yanging_setting);
//        setting_time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ListView settime = (ListView) findViewById(R.id.listview);
//                adapter_countdown = new ListViewAdapter(AlphaSettingActivity.this, settimes);
//                settime.setTextFilterEnabled(true);
//                settime.setAdapter(adapter_countdown);
//            }
//        });


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
