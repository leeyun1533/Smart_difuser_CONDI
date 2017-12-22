package com.example.food8.condi_android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ControlCircleView extends android.support.v7.widget.AppCompatImageView {

	private float angle = 0f;
	private float theta_old = 0f;

//	float width = 300;
//	float height = 300;
	
	float width = 240;
	float height = 240;
	
	//
	float max = 0f;
	float min = 0f;

	private RotaryKnobListener listener;

	public interface RotaryKnobListener {
		// public void onKnobChanged(int arg);
		public void onKnobChanged(int arg, float value);
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
		float sx = x - (width / 2.0f);
		float sy = y - (height / 2.0f);

		float length = (float) Math.sqrt(sx * sx + sy * sy);
		float nx = sx / length;
		float ny = sy / length;
		float theta = (float) Math.atan2(ny, nx);

		final float rad2deg = (float) (180.0 / Math.PI);
		float theta2 = theta * rad2deg;

		return (theta2 < 0) ? theta2 + 360.0f : theta2;
	}

	public void initialize() {

		this.setImageResource(R.drawable.knob);
		setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int action = event.getAction();
				int actionCode = action & MotionEvent.ACTION_MASK;
				
				if (actionCode == MotionEvent.ACTION_POINTER_DOWN) {
					float x = event.getX(0);
					float y = event.getY(0);
					theta_old = getTheta(x, y);
					
				} else if (actionCode == MotionEvent.ACTION_MOVE) {
					invalidate();
					float x = event.getX(0);
					float y = event.getY(0);

					float theta = getTheta(x, y);
					float delta_theta = theta - theta_old;
			
					theta_old = theta;

					int direction = (delta_theta > 0) ? 1 : -1;
					
//					angle += 3 * direction;
					//  angle�̶�  notifyListener()������ 
					// �ޱ��ϰ� �̹��� �����̼����� �簻�� �Ѵ�
//					angle = angle + ( 3 * direction );
//					notifyListener(direction);
					
					if ( angle > max ) {
						if( direction == -1 ) {
							angle = angle + (3 * direction);
							notifyListener(direction, angle);
						}
					} else if (angle < min) {
						if( direction == 1 ) {
							angle = angle + (3 * direction);
							notifyListener(direction, angle);
						}
					} else {
						angle = angle + (3 * direction);
						notifyListener(direction, angle);
					}
					
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
	private void notifyListener(int arg, float value) {
		if (null != listener)
			//
			listener.onKnobChanged(arg, value);
	}

	protected void onDraw(Canvas c) {
		// c.rotate(angle, 150, 150);
		c.rotate(angle, 120, 120);
		super.onDraw(c);
	}

}
