package com.home.currency;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private Button btnGo;
    private TextView txUsd;
    private TextView txJpy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.edt_ntd);
        txUsd = findViewById(R.id.txt_US_none);
        txJpy = findViewById(R.id.txt_JP_none);
        btnGo = findViewById(R.id.btn_go);

        exchange();
    }

    private void exchange() {
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nt = edNtd.getText().toString();

                if (nt.equals("")){

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.problem)
                            .setMessage(R.string.please_enter_your_ntd_amount)
                            .setPositiveButton(R.string.ok, null)
                            .show();

                }else{

                    Float ntd = Float.parseFloat(nt);
                    Float usd = ntd * 30.9f;
                    Float jpy = ntd * 0.2f;
                    Log.d("MainActivity", getString(R.string.usd_is) + usd);
                    Log.d("MainActivity", getString(R.string.jpy_is) + jpy);


                    txUsd.setText(usd.toString());
                    txJpy.setText(usd.toString());

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.result)
                            .setMessage(getString(R.string.usd_is) + usd + "\n" + getString(R.string.jpy_is) + jpy)
                            .setPositiveButton(R.string.ok, null)
                            .show();


                }
            }
        });

    }
}
