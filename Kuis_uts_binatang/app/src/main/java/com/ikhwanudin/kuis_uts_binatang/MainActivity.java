package com.ikhwanudin.kuis_uts_binatang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextNama;
    private EditText editTextDesg;
    private EditText editTextJumlah;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi dari View
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextJumlah = (EditText) findViewById(R.id.editTextJumlah);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String name = editTextNama.getText().toString().trim();
        final String desg = editTextDesg.getText().toString().trim();
        final String sal = editTextJumlah.getText().toString().trim();

        if (!name.isEmpty() && !desg.isEmpty() && !sal.isEmpty()) {
            class AddEmployee extends AsyncTask<Void,Void,String>{

                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                }

                @Override
                protected String doInBackground(Void... v) {
                    HashMap<String,String> params = new HashMap<>();
                    params.put(konfigurasi.KEY_EMP_NAMA,name);
                    params.put(konfigurasi.KEY_EMP_JENIS_BINATANG,desg);
                    params.put(konfigurasi.KEY_EMP_JUMLAH,sal);

                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                    return res;
                }
            }

            AddEmployee ae = new AddEmployee();
            ae.execute();
        }else {
            Toast.makeText(this, "Mohon isi semua formnya", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(this,TampilSemuaBinatang.class));
        }
    }
}
