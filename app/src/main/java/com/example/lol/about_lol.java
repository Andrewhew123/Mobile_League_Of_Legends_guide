package com.example.lol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class about_lol extends AppCompatActivity {

    SQLiteDatabase database;
    Dialog dialog;
    DatabaseHelper helper;
    AlertDialog.Builder builder;
    AlertDialog alert;
    Intent intent;
    Button btnShowTop, btnShowMid, btnShowBot, btnShowJungler, btnCancel, btnLearnMore;
    TextView tvAbout, tvGuide;
    ListView lvGuide;
    String guide[];

    int imgGuide[] = {R.drawable.about1, R.drawable.about2, R.drawable.about3, R.drawable.about4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_lol);

        helper = new DatabaseHelper(about_lol.this);

        tvAbout = findViewById(R.id.tvAbout);
        tvAbout.setText("League of Legends is a multiplayer online battle arena video game developed and published by Riot Games for Microsoft Windows and macOS. Inspired by Defense of the Ancients, the game follows a freemium model. The game was released on October 27, 2009.");
        tvGuide = findViewById(R.id.tvGuide);
        tvGuide.setText("Each team assigns their players to different areas of Summoner's Rift, the most commonly used map in League of Legends, to face off against an opponent and attempt to gain control for their team. As the game progresses, players complete a variety of tasks, including collecting computer-controlled minions, removing turrets, and eliminating champions.");
        guide=getResources().getStringArray(R.array.guide);
        lvGuide = findViewById(R.id.lvGuide);

        MyAdapter adapter = new MyAdapter(about_lol.this);
        lvGuide.setAdapter(adapter);

        lvGuide.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(about_lol.this, guide[i], Toast.LENGTH_SHORT).show();
            }
        });

        btnLearnMore = findViewById(R.id.btnLearnMore);
        btnLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://leagueoflegends.fandom.com/wiki/League_of_Legends"));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.cm_about:
                Toast.makeText(about_lol.this,"About LoL",Toast.LENGTH_SHORT).show();
            break;
            case R.id.cm_champion:
                intent = new Intent(about_lol.this,grid_champions.class);
                startActivity(intent);
                break;
            case R.id.cm_edit:
                intent = new Intent(about_lol.this,game_roles.class);
                startActivity(intent);
                break;
            case R.id.cm_show:

                dialog = new Dialog(about_lol.this,R.style.custom_dialog_style2);
                dialog.setTitle("Show Favorite Roles");
                dialog.setContentView(R.layout.show_roles_dialog);

                btnShowTop = dialog.findViewById(R.id.btnShowTop);
                btnShowTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = "";
                        int i = 1;

                        database = helper.getReadableDatabase();

                        Cursor cursor = database.rawQuery("select * from top", null);
                        if (cursor.getCount()>0){
                            cursor.moveToFirst();
                            do {
                                message += i + ". " + "Champion: " + cursor.getString(1) + "\n" + "Class: " + cursor.getString(2) + "\n\n";
                                i++;
                            } while (cursor.moveToNext());
                        }
                        Toast.makeText(about_lol.this,message,Toast.LENGTH_SHORT).show();
                        database.close();
                    }
                });
                btnShowMid = dialog.findViewById(R.id.btnShowMid);
                btnShowMid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = "";
                        int i = 1;

                        database = helper.getReadableDatabase();

                        Cursor cursor = database.rawQuery("select * from mid", null);
                        if (cursor.getCount()>0){
                            cursor.moveToFirst();
                            do {
                                message += i + ". " + "Champion: " + cursor.getString(1) + "\n" + "Class: " + cursor.getString(2) + "\n\n";
                                i++;
                            } while (cursor.moveToNext());
                        }
                        Toast.makeText(about_lol.this,message,Toast.LENGTH_SHORT).show();
                        database.close();
                    }
                });
                btnShowBot = dialog.findViewById(R.id.btnShowBot);
                btnShowBot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = "";
                        int i = 1;

                        database = helper.getReadableDatabase();

                        Cursor cursor = database.rawQuery("select * from bot", null);
                        if (cursor.getCount()>0){
                            cursor.moveToFirst();
                            do {
                                message += i + ". " + "Champion: " + cursor.getString(1) + "\n" + "Class: " + cursor.getString(2) + "\n\n";
                                i++;
                            } while (cursor.moveToNext());
                        }
                        Toast.makeText(about_lol.this,message,Toast.LENGTH_SHORT).show();
                        database.close();
                    }
                });
                btnShowJungler = dialog.findViewById(R.id.btnShowJungler);
                btnShowJungler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = "";
                        int i = 1;

                        database = helper.getReadableDatabase();

                        Cursor cursor = database.rawQuery("select * from jungler", null);
                        if (cursor.getCount()>0){
                            cursor.moveToFirst();
                            do {
                                message += i + ". " + "Champion: " + cursor.getString(1) + "\n" + "Class: " + cursor.getString(2) + "\n\n";
                                i++;
                            } while (cursor.moveToNext());
                        }
                        Toast.makeText(about_lol.this,message,Toast.LENGTH_SHORT).show();
                        database.close();
                    }
                });
                btnCancel = dialog.findViewById(R.id.btnCancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.cm_exit:
                builder = new AlertDialog.Builder(about_lol.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you wanted to quit my application");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        System.exit(1);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alert.dismiss();
                    }
                });
                alert = builder.create();
                alert.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends BaseAdapter {
        Context context;
        ImageView img;
        TextView tvGuide;

        public MyAdapter(Context ctxt) {

            context = ctxt;
        }

        @Override
        public int getCount() {
            return guide.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = getLayoutInflater().from(context).inflate(R.layout.about_item_layout,viewGroup,false);
            }
            img = view.findViewById(R.id.imgGuide);
            tvGuide = view.findViewById(R.id.listGuide);

            img.setImageResource(imgGuide[i]);
            tvGuide.setText(guide[i]);

            return view;
        }
    }
}