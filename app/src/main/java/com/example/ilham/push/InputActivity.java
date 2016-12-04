package com.example.ilham.push;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilham.push.database.DataContract;
import com.example.ilham.push.database.DataHelper;

public class InputActivity extends AppCompatActivity {

    DataHelper helper;
    EditText editTextTitle;
    EditText editTextAlamat;
    EditText editTextHarga;
    EditText editTextNoTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        helper = new DataHelper(getApplicationContext());

        initView();
    }

    public void initView(){
        editTextTitle = (EditText) findViewById(R.id.title);
        editTextAlamat = (EditText) findViewById(R.id.alamat);
        editTextHarga = (EditText) findViewById(R.id.harga);
        editTextNoTelp = (EditText) findViewById(R.id.telp);
    }

    public void save(View view){

        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataContract.COLUMN_NAME_TITLE, editTextTitle.getText().toString());
        values.put(DataContract.COLUMN_NAME_ALAMAT, editTextAlamat.getText().toString());
        values.put(DataContract.COLUMN_NAME_TELP, editTextNoTelp.getText().toString());
        values.put(DataContract.COLUMN_NAME_HARGA, editTextHarga.getText().toString());

        long newRowId = database.insert(DataContract.TABLE_NAME, null, values);

        if (newRowId != -1){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

            finish();
        }
    }
}
