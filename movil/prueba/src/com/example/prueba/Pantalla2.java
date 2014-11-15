package com.example.prueba;

import com.sacooliveros.intranet.bean.AlumnoBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.util.Loadingable;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Se debe implementar la interfaz android.view.View.OnClickListener para el evento click
public class Pantalla2 extends MainActivity implements OnClickListener, Loadingable{
	String mensaje;
	Button boton1, boton2;
	EditText txtAlumnoId;
	EditText caja1, caja2;
	AlumnoBean bean;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.pantalla2);
                
        obtenerElementos();
        
        asignarEventos();                
    }
    

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        
        caja1 = (EditText) findViewById(R.id.pantalla2_textbox1);
        caja2 = (EditText) findViewById(R.id.pantalla2_textbox2);
        
        boton1 = (Button) findViewById(R.id.pantalla2_boton1);
        boton2 = (Button) findViewById(R.id.pantalla2_boton2);    	
    }
    

    private void asignarEventos(){
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }
    
    
    public void onClick(View v){
    	String texto;
    	Intent i;
    	
    	if(v.equals(boton1)){
    		

    		new LoadTaskDialog(Pantalla2.this, null,
    				new HyundaiProgressDialog(Pantalla2.this)).execute();	
    		
    		
    		//Obtener texto
    		/*texto = caja1.getText().toString();
    		Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();*/
    	}else{
    		//Redireccionar a la pantalla2
    		i = new Intent(this, Pantalla2.class);
    		startActivity(i);
    	}
    }


	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void loadingData() {
		// TODO Auto-generated method stub
		String alumnoId;
		mensaje = "";
		try {
			alumnoId = "1"; //caja1.getText().toString();
			AlumnoController.getInstance().consultar(alumnoId);
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
	}

	@Override
	public void afterLoadingData() {
		// TODO Auto-generated method stub
		if (mensaje.length() == 0){
			caja1.setText(bean.getApellidos());
			caja2.setText(bean.getNombres());
		}else{
			Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
		}
		
	}
}
