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

public class champions_list2 extends AppCompatActivity {

    SQLiteDatabase database;
    Dialog dialog;
    DatabaseHelper helper;
    AlertDialog.Builder builder;
    AlertDialog alert;
    Intent intent;
    Button btnShowTop, btnShowMid, btnShowBot, btnShowJungler, btnCancel;
    ListView lvlol;
    String champions[], ability[], atkspeed[], atkdmg[], num[];

    int imgChampions[] = {R.drawable.ashe2, R.drawable.caitlyn2, R.drawable.missfortune2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_list2);

        helper = new DatabaseHelper(champions_list2.this);

        lvlol = findViewById(R.id.lvlol);
        champions=getResources().getStringArray(R.array.marksman);
        ability=getResources().getStringArray(R.array.marksmanAbility);
        atkspeed=getResources().getStringArray(R.array.MarksmanAtkSpeed);
        atkdmg=getResources().getStringArray(R.array.MarksmanAtkDmg);
        num=getResources().getStringArray(R.array.num);

        MyAdapter adapter = new MyAdapter(champions_list2.this);
        lvlol.setAdapter(adapter);

        lvlol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(champions_list2.this, champions[i], Toast.LENGTH_SHORT).show();
                Toast.makeText(champions_list2.this, ability[i], Toast.LENGTH_SHORT).show();
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
                intent = new Intent(champions_list2.this,about_lol.class);
                startActivity(intent);
                break;
            case R.id.cm_champion:
                intent = new Intent(champions_list2.this,grid_champions.class);
                startActivity(intent);
                break;
            case R.id.cm_edit:
                intent = new Intent(champions_list2.this,game_roles.class);
                startActivity(intent);
                break;
            case R.id.cm_show:

                dialog = new Dialog(champions_list2.this,R.style.custom_dialog_style2);
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
                        Toast.makeText(champions_list2.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(champions_list2.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(champions_list2.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(champions_list2.this,message,Toast.LENGTH_SHORT).show();
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
                builder = new AlertDialog.Builder(champions_list2.this);
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
        TextView tvName, tvAbility, tvAtkSpeed, tvAtkDmg, tvNum;

        public MyAdapter(Context ctxt) {

            context = ctxt;
        }

        @Override
        public int getCount() {
            return champions.length;
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
                view = getLayoutInflater().from(context).inflate(R.layout.item_layout,viewGroup,false);
            }
            img = view.findViewById(R.id.imgChampions);
            tvName = view.findViewById(R.id.tvName);
            tvAbility = view.findViewById(R.id.tvAbility);
            tvAtkSpeed = view.findViewById(R.id.tvAtkSpeed);
            tvAtkDmg = view.findViewById(R.id.tvAtkDmg);
            tvNum = view.findViewById(R.id.tvNum);

            img.setImageResource(imgChampions[i]);
            tvName.setText(champions[i]);
            tvAbility.setText(ability[i]);
            tvAtkSpeed.setText(atkspeed[i]);
            tvAtkDmg.setText(atkdmg[i]);
            tvNum.setText(num[i]);

            return view;
        }
    }
}