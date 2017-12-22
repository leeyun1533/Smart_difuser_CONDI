package com.example.food8.condi_android;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ControlActivity extends AppCompatActivity {

	private TextView txtView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);
		
		//
		txtView = (TextView)findViewById(R.id.txtView);
		
		ControlCircleView jogView = (ControlCircleView)findViewById(R.id.jogView);
		
		//
		jogView.setKnobMaxMin(180.0f, -180.0f);
		txtView.setText("�ִ� 138  �ּ� -138");
		
		jogView.setKnobListener(new ControlCircleView.RotaryKnobListener() {
			
			@Override
			public void onKnobChanged(int arg, float value) {
				// TODO Auto-generated method stub
				
				txtView.setText(String.valueOf(value));
				
				if( arg > 0 ) {
					Log.w("...", "������ ȸ��");
					
				} else {
					Log.w("...", "���� ȸ��");
					
				}
				
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
