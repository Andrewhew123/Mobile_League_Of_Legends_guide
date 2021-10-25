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
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class grid_champions extends AppCompatActivity {

    SQLiteDatabase database;
    Dialog dialog;
    DatabaseHelper helper;
    AlertDialog.Builder builder;
    AlertDialog alert;
    Intent intent;
    Button btnShowTop, btnShowMid, btnShowBot, btnShowJungler, btnCancel;
    GridView lvlol;
    int imgClass[] = {R.drawable.mage7, R.drawable.marksman7, R.drawable.fighter7, R.drawable.tank7, R.drawable.assassin7, R.drawable.support7};
    String nameClass[] = {"Mage", "Marksman", "Fighter", "Tank", "Assasin", "Support"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_champions);

        helper = new DatabaseHelper(grid_champions.this);

        lvlol = findViewById(R.id.lvlol);

        MyAdapter adapter = new MyAdapter(grid_champions.this);
        lvlol.setAdapter(adapter);

        lvlol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(grid_champions.this,champions_list.class);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(grid_champions.this,champions_list2.class);
                    startActivity(intent);
                }
                if (position ==  2) {
                    Intent intent = new Intent(grid_champions.this,champions_list3.class);
                    startActivity(intent);
                }
                if (position ==  3) {
                    Intent intent = new Intent(grid_champions.this,champions_list4.class);
                    startActivity(intent);
                }
                if (position ==  4) {
                    Intent intent = new Intent(grid_champions.this,champions_list5.class);
                    startActivity(intent);
                }
                if (position ==  5) {
                    Intent intent = new Intent(grid_champions.this,champions_list6.class);
                    startActivity(intent);
                }
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
                intent = new Intent(grid_champions.this,about_lol.class);
                startActivity(intent);
                break;
            case R.id.cm_champion:
                Toast.makeText(grid_champions.this,"Champion",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cm_edit:
                intent = new Intent(grid_champions.this,game_roles.class);
                startActivity(intent);
                break;
            case R.id.cm_show:

                dialog = new Dialog(grid_champions.this,R.style.custom_dialog_style2);
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
                        if (cursor.getCount()>0) {
                            cursor.moveToFirst();
                                do {
                                    message += i + ". " + "Champion: " + cursor.getString(1) + "\n" + "Class: " + cursor.getString(2) + "\n\n";
                                    i++;
                                } while (cursor.moveToNext());
                            }
                        Toast.makeText(grid_champions.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(grid_champions.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(grid_champions.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(grid_champions.this,message,Toast.LENGTH_SHORT).show();
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
                builder = new AlertDialog.Builder(grid_champions.this);
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
        TextView name;
        ImageView image;

        public MyAdapter(Context ctxt){

            context = ctxt;
        }

        @Override
        public int getCount() {
            return nameClass.length;
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
                view = getLayoutInflater().from(context).inflate(R.layout.grid_item_layout, viewGroup, false);
            }
            image = view.findViewById(R.id.ivImage);
            name = view.findViewById(R.id.ivName);
            image.setImageResource(imgClass[i]);
            name.setText(nameClass[i]);
            return view;
        }

    }

}