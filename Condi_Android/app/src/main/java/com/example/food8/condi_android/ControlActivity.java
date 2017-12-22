package com.example.food8.condi_android;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ControlActivity extends AppCompatActivity {

	private TextView txtView;
	Retrofit retrofit;
	ApiService apiService;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);
		txtView = (TextView)findViewById(R.id.txtView);
		button = (Button)findViewById(R.id.button3);
		retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
		apiService = retrofit.create(ApiService.class);

		ControlCircleView jogView = (ControlCircleView)findViewById(R.id.jogView);
		//
		jogView.setKnobMaxMin(180.0f, -180.0f);
		txtView.setText("기분을 선택하세요");
		
		jogView.setKnobListener(new ControlCircleView.RotaryKnobListener() {
			
			@Override
			public void onKnobChanged(float arg, float value) {
				// TODO Auto-generated method stub
//				if(value>=-30.0&&value<30.0){
//					//구역1
//					txtView.setText("Delighted");
//				}else if(value>=30.0&&value<90.0){
//					//구역2
//					txtView.setText("Happy");
//				}else if(value>=90.0&&value<150.0){
//					//구역3
//					txtView.setText("Nervous");
//				}else if(value<-30.0&&value>=-90.0){
//					//구역4
//					txtView.setText("Love");
//				}else if(value<-90.0&&value>=-150.0){
//					//구역5
//					txtView.setText("Serious");
//				}else if((value<-150.0&&value>=-180.0)||(value<180.0&&value>=150.0)){
//					//구역5
//					txtView.setText("Gloomy");
//				}
				txtView.setText(String.valueOf(value));

			}
		});


		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Call<ResponseBody> data = apiService.getData(txtView.getText().toString().toLowerCase());
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
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rotary_knob_view, menu);
		return true;
	}

}
