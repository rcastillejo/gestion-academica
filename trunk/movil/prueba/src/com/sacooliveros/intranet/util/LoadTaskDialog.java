package com.sacooliveros.intranet.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class LoadTaskDialog extends AsyncTask<Void, Integer, Void> {
	// Before running code in the separate thread
	Loadingable component;

	private ProgressDialog pd;
	private String message;
	private Activity context;

	public LoadTaskDialog(Loadingable component, String message,
			ProgressDialog pd) {
		this.component = component;
		this.pd = pd;
		try {
			this.context = (Activity) component;
		} catch (Exception e) {
			this.context = null;
		}

		if (message == null) {
			//this.message = DSBApplication.getContext().getResources().getString(R.string.loading_str);
			this.message = "loading";
		} else {
			this.message = message;
		}
	}

	public LoadTaskDialog(Loadingable component, String message) {
		this.component = component;
		this.pd = null;
		try {
			this.context = (Activity) component;
		} catch (Exception e) {
			this.context = null;
		}

		if (message == null) {
			this.message = "loading";
			//this.message = DSBApplication.getContext().getResources()
				//	.getString(R.string.loading_str);
		} else {
			this.message = message;
		}
	}

	@Override
	protected void onPreExecute() {
		component.beforeLoadingData();
		if (component != null) {
			if (pd == null) {
				pd = new ProgressDialog(context);
			}
			pd.setCancelable(false);
			pd.setMessage(message);
			pd.show();
		}
		
	}

	@Override
	protected Void doInBackground(Void... params) {
		// Get the current thread's token
		synchronized (this) {
			component.loadingData();
		}

		return null;

	}

	@Override
	protected void onPostExecute(Void result) {

		component.afterLoadingData();

		if (pd != null && pd.isShowing()) {
			pd.dismiss();
		}
	}

}