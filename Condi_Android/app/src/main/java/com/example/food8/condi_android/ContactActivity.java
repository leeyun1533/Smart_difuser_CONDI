package com.example.food8.condi_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactActivity extends AppCompatActivity {
    Intent intent;
    boolean[] array;
    String sendData = "asdf";
    Retrofit retrofit;
    ApiService apiService;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        intent = getIntent();
        array = getIntent().getBooleanArrayExtra("array");
        textView = (TextView) findViewById(R.id.resultText);
        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        button = (Button)findViewById(R.id.btnget);
        apiService = retrofit.create(ApiService.class);
        if(array[0]&&!array[1]&&!array[2]){     //1번 참
            sendData = "delighted";
        }else if(!array[0]&&array[1]&&!array[2]){   //2번참
            sendData = "happy";
        }else if(!array[0]&&!array[1]&&array[2]){   //3번 참
            sendData = "nervous";
        }else if(array[0]&&array[1]&&!array[2]){    //1,2 참
            sendData = "gloomy";
        }else if(array[0]&&!array[1]&&array[2]){    //1,3 참
            sendData = "serious";
        }else if(!array[0]&&array[1]&&array[2]){    //2,3 참
            sendData = "love";
        }
        textView.setText(sendData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> data = apiService.getData(sendData);
                data.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.v("Test",response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(getApplicationContext(),PlayActivity.class);
                startActivity(intent);
            }
        });

    }
}
