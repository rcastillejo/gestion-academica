package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Pantalla2 extends MainActivity implements OnClickListener{

	

	Button boton1;
	ImageView  imagen1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.pantalla1);
                
        obtenerElementos();
        
        asignarEventos();                
    }
    

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        
        
        boton1 = (Button) findViewById(R.id.pantalla2_boton1);
        imagen1 = (ImageView) findViewById(R.id.pantalla2_imagen1);    	
    }
    

    private void asignarEventos(){
        boton1.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		Intent i;
		if(v.equals(boton1)){
    		i = new Intent(this, Pantalla1.class);
    		startActivity(i);
		}
		
	}

}
