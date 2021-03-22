package com.example.muhammadfaiz_32872_if633_bl_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class SongActivity extends AppCompatActivity{

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tunes;
            getSupportActionBar().setTitle("Daftar Lagu");
            getAlert();
        }

        private void getAlert() {
            AlertDialog.Builder alert = new AlertDialog.Builder(SongActivity.this);
            String alertMessage1 = "Welcome";
            String alertMessage2 = "Faiz Ramdhani";
            String alertMessage3 = "00000032872";
            alert.setMessage(alertMessage1+"\n"+alertMessage2+"\n"+alertMessage3);

            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.menuProfile){
                startActivity(new Intent(SongActivity.this, ProfileActivity.class));
            }
            if(id == R.id.menuLogOut){
                startActivity(new Intent(SongActivity.this, MainActivity.class));
            }
            return true;
        }

        public ArrayList<File> findSong(File root){
            ArrayList<File> at = new ArrayList<File>();
            File[] files = root.listFiles();
            for(File singleFile : files){
                if(singleFile.isDirectory() && !singleFile.isHidden()){
                    at.addAll(findSong(singleFile));
                }
                else{
                    if(singleFile.getName().endsWith(".mp3") ||
                            singleFile.getName().endsWith(".wav")){
                        at.add(singleFile);
                    }
                }
            }
            return at;
        }
        void display(){
            final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
            Object items = new String[mySongs.size()];
            for(int i=0;i<mySongs.size();i++){
                //toast(mySongs.get(i).getName().toString());
                items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
            }
            ArrayAdapter<String> adp = new
                    ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            AbsListView listView;
            listView.setAdapter(adp);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int
                        position, long l) {

                    String songName = listView.getItemAtPosition(position).toString();
                    startActivity(new Intent(getApplicationContext(),Tunes.class)

                            .putExtra("pos",position).putExtra("songs",mySongs).putExtra("songname",songName));
                }
            });
        }

    }package com.example.muhammadfaiz_32872_if633_bl_uts;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.Manifest;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Environment;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.io.File;
        import java.util.ArrayList;

        

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_song);
            getSupportActionBar().setTitle("Daftar Lagu");
            getAlert();
        }

        private void getAlert() {
            AlertDialog.Builder alert = new AlertDialog.Builder(LaguActivity.this);
            String alertMessage1 = "Welcome";
            String alertMessage2 = "Faiz Ramdhani;
            String alertMessage3 = "00000032872";
            alert.setMessage(alertMessage1+"\n"+alertMessage2+"\n"+alertMessage3);

            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.menuProfile){
                startActivity(new Intent(LaguActivity.this, ProfileActivity.class));
            }
            if(id == R.id.menuLogOut){
                startActivity(new Intent(LaguActivity.this, MainActivity.class));
            }
            return true;
        }

        public ArrayList<File> findSong(File root){
            ArrayList<File> at = new ArrayList<File>();
            File[] files = root.listFiles();
            for(File singleFile : files){
                if(singleFile.isDirectory() && !singleFile.isHidden()){
                    at.addAll(findSong(singleFile));
                }
                else{
                    if(singleFile.getName().endsWith(".mp3") ||
                            singleFile.getName().endsWith(".wav")){
                        at.add(singleFile);
                    }
                }
            }
            return at;
        }
        void display(){
            final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
            items = new String[ mySongs.size() ];
            for(int i=0;i<mySongs.size();i++){
                //toast(mySongs.get(i).getName().toString());
                items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
            }
            ArrayAdapter<String> adp = new
                    ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adp);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int
                        position, long l) {

                    String songName = listView.getItemAtPosition(position).toString();
                    startActivity(new Intent(getApplicationContext(),Tunes.class)

                            .putExtra("pos",position).putExtra("songs",mySongs).putExtra("songname",songName));
                }
            });
        }

    }package com.example.muhammadfaiz_32872_if633_bl_uts;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.Manifest;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Environment;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.io.File;
        import java.util.ArrayList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_song);
            getSupportActionBar().setTitle("Song List");
            getAlert();
        }

        private void getAlert() {
            AlertDialog.Builder alert = new AlertDialog.Builder(LaguActivity.this);
            String alertMessage1 = "Welcome";
            String alertMessage2 = "Faiz Ramdhani";
            String alertMessage3 = "00000032872";
            alert.setMessage(alertMessage1+"\n"+alertMessage2+"\n"+alertMessage3);

            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.menuProfile){
                startActivity(new Intent(LaguActivity.this, ProfileActivity.class));
            }
            if(id == R.id.menuLogOut){
                startActivity(new Intent(LaguActivity.this, MainActivity.class));
            }
            return true;
        }

        public ArrayList<File> findSong(File root){
            ArrayList<File> at = new ArrayList<File>();
            File[] files = root.listFiles();
            for(File singleFile : files){
                if(singleFile.isDirectory() && !singleFile.isHidden()){
                    at.addAll(findSong(singleFile));
                }
                else{
                    if(singleFile.getName().endsWith(".mp3") ||
                            singleFile.getName().endsWith(".wav")){
                        at.add(singleFile);
                    }
                }
            }
            return at;
        }
        void display(){
            final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
            items = new String[ mySongs.size() ];
            for(int i=0;i<mySongs.size();i++){
                //toast(mySongs.get(i).getName().toString());
                items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
            }
            ArrayAdapter<String> adp = new
                    ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adp);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int
                        position, long l) {

                    String songName = listView.getItemAtPosition(position).toString();
                    startActivity(new Intent(getApplicationContext(),Tunes.class)

                            .putExtra("pos",position).putExtra("songs",mySongs).putExtra("songname",songName));
                }
            });
        }

    }
}