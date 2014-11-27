package com.example.prueba;


import com.sacooliveros.gestionacademica.bean.LoginBean;
import com.sacooliveros.intranet.controller.LoginController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity  implements OnClickListener, Loadingable{
	private EditText txtUsuario, txtPassword;
	private Button btnIngresar, btnSalir;
	private LoginBean bean;
	private String mensaje;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_login);

        
        obtenerElementos();
        
        asignarEventos();                
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void obtenerElementos(){
        txtUsuario = (EditText) findViewById(R.id.frmlogin_textbox1);
        txtPassword = (EditText) findViewById(R.id.frmlogin_textbox2);
        btnIngresar = (Button) findViewById(R.id.frmlogin_boton1);
        btnSalir = (Button) findViewById(R.id.frmlogin_boton2);    	
    }

    private void asignarEventos(){
    	btnIngresar.setOnClickListener(this);
    	btnSalir.setOnClickListener(this);
    }
    
    private void login(){
		new LoadTaskDialog(LoginActivity.this, null,
				new HyundaiProgressDialog(LoginActivity.this)).execute();
    }
    
	@Override
	public void onClick(View v) {
		Intent i;
		if(v.equals(btnIngresar)){
			login();
		}else if (v.equals(btnSalir)){
			/*i = new Intent(this, Pantalla2.class);			
			startActivity(i);*/
		}
	}


	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void loadingData() {
		String usuario;
		String password;
		mensaje = "";
		try {
			usuario = txtUsuario.getText().toString();
			password = txtPassword.getText().toString();
			bean = LoginController.getInstance().login(usuario, password);			
			if(bean.getMensajeError() != null){
				mensaje = bean.getMensajeError();
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
	}


	@Override
	public void afterLoadingData() {
		Intent i;
		
		if (mensaje.length() == 0){
			i = new Intent(this, MenuActivity.class);    		
    		startActivity(i);			
		}else{
			Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
		}
	}
}
