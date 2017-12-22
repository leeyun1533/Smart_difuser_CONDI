package com.example.food8.condi_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    Retrofit retrofit;
    ApiService apiService;
=======
>>>>>>> 4b2eb4f3c91712c2d8d433a6e3333f0b22b57fae
    Button btn_yes,btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);
=======
>>>>>>> 4b2eb4f3c91712c2d8d433a6e3333f0b22b57fae
        btn_yes = (Button)findViewById(R.id.btn_yes);
        btn_no = (Button)findViewById(R.id.btn_no);

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ControlActivity.class);
                startActivity(intent);
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(intent);
            }
        });

    }
}
