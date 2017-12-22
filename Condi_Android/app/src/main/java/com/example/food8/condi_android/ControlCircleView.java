package com.example.food8.condi_android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ControlCircleView extends android.support.v7.widget.AppCompatImageView {

	private float angle = 0f;
	private float theta_old = 0f;

	//
	float max = 0f;
	float min = 0f;

	private RotaryKnobListener listener;

	public interface RotaryKnobListener {
		// public void onKnobChanged(int arg);
		public void onKnobChanged(float arg, float value);
	}
	
	//
	public void setKnobMaxMin(float max, float min) {
		this.max = max;
		this.min = min;
	}

	public void setKnobListener(RotaryKnobListener l) {
		listener = l;
	}

	public ControlCircleView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ControlCircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public ControlCircleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}

	private float getTheta(float x, float y) {
		float sx = x - (this.getWidth() / 2.0f);
		float sy = y - (this.getHeight() / 2.0f);

		float length = (float) Math.sqrt(sx * sx + sy * sy);
		float nx = sx / length;
		float ny = sy / length;
		float theta = (float) Math.atan2(ny, nx);

		final float rad2deg = (float) (180.0 / Math.PI);
		float theta2 = theta * rad2deg;

		return theta2;
	}

	public void initialize() {

		this.setImageResource(R.drawable.knob);
		setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int action = event.getAction();
				int actionCode = action & MotionEvent.ACTION_MASK;

				if ( actionCode == MotionEvent.ACTION_DOWN) {
					float x = event.getX(0);
					float y = event.getY(0);
					theta_old = getTheta(x, y);
					
				} else if (actionCode == MotionEvent.ACTION_MOVE) {
					invalidate();
					float x = event.getX(0);
					float y = event.getY(0);

					float theta = getTheta(x, y);
					float delta_theta ;
					if(180 < theta - theta_old){
						delta_theta = (theta - theta_old) - 360;
					}else if(-180 < theta - theta_old){
						delta_theta = (theta - theta_old) + 360;
					}else {
						delta_theta = (theta - theta_old);
					}
					Log.v("x + y : ",String.valueOf(x)+"    \n"+String.valueOf(y)+"    \n"+String.valueOf(v.getWidth())+"    \n"+String.valueOf(v.getHeight()));
					theta_old = theta;

					float direction = delta_theta;
					
//					angle += 3 * direction;
					//  angle�̶�  notifyListener()������ 
					// �ޱ��ϰ� �̹��� �����̼����� �簻�� �Ѵ�
//					angle = angle + ( 3 * direction );
//					notifyListener(direction);
					angle = angle + (direction);
					Log.v("dir",direction+"");
//					angle = angle > 180 ? (angle - 360) :angle ;
//					angle = angle < -180 ?(angle + 360) :angle ;
					if(angle > 180f){

						Log.v("AngleTrue",String.valueOf(angle));
						angle -= 360;
						Log.v("AngleTrue",String.valueOf(angle));
					}
					else if(angle < -180f){
						angle += 360;
					}
					if(angle > 180f){

						Log.v("AngleTrue",String.valueOf(angle));
						angle -= 360;
						Log.v("AngleTrue",String.valueOf(angle));
					}
					notifyListener(direction, angle);
					Log.v("Angle",String.valueOf(angle));
				}
				return true;
			}

		});
	}

	/*
	private void notifyListener(int arg) {
		if (null != listener)
			listener.onKnobChanged(arg);
	}
	*/
	
	//
	private void notifyListener(float arg, float value) {
		if (null != listener)
			//
			listener.onKnobChanged(arg, value);
	}

	protected void onDraw(Canvas c) {
		// c.rotate(angle, 150, 150);
		c.rotate(angle, getWidth()/2.0f, getHeight()/2.0f);
		super.onDraw(c);
	}

}
