package com.sacooliveros.intranet.util;

import com.example.prueba.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;


public class HyundaiProgressDialog extends ProgressDialog {

	public HyundaiProgressDialog(Context context) {
		super(context);
		setIndeterminate(true);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_progress_dialog);
	}
	
	@Override
	public void show() {
		super.show();
		RotateAnimation anim = new RotateAnimation(0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		anim.setRepeatCount(Animation.INFINITE);
		anim.setDuration(700);

		ImageView imagen = (ImageView)findViewById(R.id.imgProgressImage);
		imagen.startAnimation(anim);
	}
}
