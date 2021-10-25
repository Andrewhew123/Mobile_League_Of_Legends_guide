package com.example.lol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class game_roles extends AppCompatActivity {

    SQLiteDatabase database;
    Dialog dialog;
    DatabaseHelper helper;
    AlertDialog.Builder builder;
    AlertDialog alert;
    Intent intent;
    Spinner spRoles;
    EditText etName;
    Button btnSave, btnCancel, btnTop, btnMid, btnBot, btnJungler, btnClear;
    Button btnShowTop, btnShowMid, btnShowBot, btnShowJungler;
    String name;
    String roles[] = {"Mage", "Marksman", "Fighter", "Tank", "Assasin", "Support"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_roles);

        helper = new DatabaseHelper(game_roles.this);

        btnTop = findViewById(R.id.btnTop);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(game_roles.this,R.style.custom_dialog_style);
                dialog.setTitle("Top Lane");
                dialog.setContentView(R.layout.roles_dialog);

                etName = dialog.findViewById(R.id.etName);
                spRoles = dialog.findViewById(R.id.spRoles);
                adapter = new ArrayAdapter<>(game_roles.this,android.R.layout.simple_list_item_1, roles);
                spRoles.setAdapter(adapter);

                btnSave = dialog.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (etName.length()!=0){
                            name = etName.getText().toString();
                            String str = roles[spRoles.getSelectedItemPosition()];
                            database = helper.getWritableDatabase();

                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", name);
                            contentValues.put("roles", roles[spRoles.getSelectedItemPosition()]);

                            database.insert("top", null,contentValues);
                            database.close();
                            dialog.dismiss();

                            Toast.makeText(game_roles.this,"U have added Favorite Top Lane Champion",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(game_roles.this,"Please fill in your Favorite Champion", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                btnClear = dialog.findViewById(R.id.btnClear);
                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder = new AlertDialog.Builder(game_roles.this);
                        builder.setTitle("Clear All");
                        builder.setMessage("Are you sure you wanted to clear all Favorite Top Lane Role");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                database = helper.getWritableDatabase();
                                database.execSQL("delete from top");
                                Toast.makeText(game_roles.this, "You had clear all Favorite Top Lane Role", Toast.LENGTH_SHORT).show();
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
            }
        });
        btnMid = findViewById(R.id.btnMid);
        btnMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(game_roles.this,R.style.custom_dialog_style);
                dialog.setTitle("Middle Lane");
                dialog.setContentView(R.layout.roles_dialog);

                etName = dialog.findViewById(R.id.etName);
                spRoles = dialog.findViewById(R.id.spRoles);
                adapter = new ArrayAdapter<>(game_roles.this,android.R.layout.simple_list_item_1, roles);
                spRoles.setAdapter(adapter);

                btnSave = dialog.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (etName.length()!=0){
                            name = etName.getText().toString();
                            String str = roles[spRoles.getSelectedItemPosition()];
                            database = helper.getWritableDatabase();

                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", name);
                            contentValues.put("roles", roles[spRoles.getSelectedItemPosition()]);

                            database.insert("mid", null,contentValues);
                            database.close();
                            dialog.dismiss();

                            Toast.makeText(game_roles.this,"U have added favorite Middle Lane Champion",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(game_roles.this,"Please fill in your Favorite Champion", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                btnClear = dialog.findViewById(R.id.btnClear);
                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder = new AlertDialog.Builder(game_roles.this);
                        builder.setTitle("Clear All");
                        builder.setMessage("Are you sure you wanted to clear all Favorite Middle Lane Role");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                database = helper.getWritableDatabase();
                                database.execSQL("delete from mid");
                                Toast.makeText(game_roles.this, "You had clear all Favorite Middle Lane Role", Toast.LENGTH_SHORT).show();
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
            }
        });
        btnBot = findViewById(R.id.btnBot);
        btnBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(game_roles.this,R.style.custom_dialog_style);
                dialog.setTitle("Bottom Lane");
                dialog.setContentView(R.layout.roles_dialog);

                etName = dialog.findViewById(R.id.etName);
                spRoles = dialog.findViewById(R.id.spRoles);
                adapter = new ArrayAdapter<>(game_roles.this,android.R.layout.simple_list_item_1, roles);
                spRoles.setAdapter(adapter);

                btnSave = dialog.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (etName.length()!=0){
                            name = etName.getText().toString();
                            String str = roles[spRoles.getSelectedItemPosition()];
                            database = helper.getWritableDatabase();

                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", name);
                            contentValues.put("roles", roles[spRoles.getSelectedItemPosition()]);

                            database.insert("bot", null,contentValues);
                            database.close();
                            dialog.dismiss();

                            Toast.makeText(game_roles.this,"U have added Favorite Bottom Lane Champion",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(game_roles.this,"Please fill in your Favorite Champion", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                btnClear = dialog.findViewById(R.id.btnClear);
                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder = new AlertDialog.Builder(game_roles.this);
                        builder.setTitle("Clear All");
                        builder.setMessage("Are you sure you wanted to clear all Favorite Bottom Lane Role");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                database = helper.getWritableDatabase();
                                database.execSQL("delete from bot");
                                Toast.makeText(game_roles.this, "You had clear all Favorite Bottom Lane Role", Toast.LENGTH_SHORT).show();
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
            }
        });
        btnJungler = findViewById(R.id.btnJungler);
        btnJungler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(game_roles.this,R.style.custom_dialog_style);
                dialog.setTitle("Jungler");
                dialog.setContentView(R.layout.roles_dialog);

                etName = dialog.findViewById(R.id.etName);
                spRoles = dialog.findViewById(R.id.spRoles);
                adapter = new ArrayAdapter<>(game_roles.this,android.R.layout.simple_list_item_1, roles);
                spRoles.setAdapter(adapter);

                btnSave = dialog.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (etName.length()!=0){
                            name = etName.getText().toString();
                            String str = roles[spRoles.getSelectedItemPosition()];
                            database = helper.getWritableDatabase();

                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", name);
                            contentValues.put("roles", roles[spRoles.getSelectedItemPosition()]);

                            database.insert("jungler", null,contentValues);
                            database.close();
                            dialog.dismiss();

                            Toast.makeText(game_roles.this,"U have added Favorite Jungler Champion",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(game_roles.this,"Please fill in your Favorite Champion",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                btnClear = dialog.findViewById(R.id.btnClear);
                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder = new AlertDialog.Builder(game_roles.this);
                        builder.setTitle("Clear All");
                        builder.setMessage("Are you sure you wanted to clear all Favorite Jungler Role");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                database = helper.getWritableDatabase();
                                database.execSQL("delete from jungler");
                                Toast.makeText(game_roles.this, "You had clear all Favorite Jungler Role", Toast.LENGTH_SHORT).show();
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
                intent = new Intent(game_roles.this,about_lol.class);
                startActivity(intent);
                break;
            case R.id.cm_champion:
                intent = new Intent(game_roles.this,grid_champions.class);
                startActivity(intent);
                break;
            case R.id.cm_edit:
                Toast.makeText(game_roles.this,"Add Roles",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cm_show:

                dialog = new Dialog(game_roles.this,R.style.custom_dialog_style2);
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
                        Toast.makeText(game_roles.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(game_roles.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(game_roles.this,message,Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(game_roles.this,message,Toast.LENGTH_SHORT).show();
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
                builder = new AlertDialog.Builder(game_roles.this);
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
}