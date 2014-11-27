package com.example.prueba;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MenuActivity extends Activity  implements OnClickListener{
	private Button btnConsultar, btnNotas,btnOtros;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_menu);

        
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
        
        btnConsultar = (Button) findViewById(R.id.main_boton1);
        btnOtros = (Button) findViewById(R.id.main_boton2);    	
    }

    private void asignarEventos(){
    	btnConsultar.setOnClickListener(this);
    	btnOtros.setOnClickListener(this);
    	btnNotas.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		Intent i;
		if(v.equals(btnConsultar)){
    		i = new Intent(this, ConsultarAlumnoActivity.class);    		
    		startActivity(i);
		}else if(v.equals(btnNotas)){
        		i = new Intent(this, ConsultarNotaActivity.class);    		
        		startActivity(i);
		}else if (v.equals(btnOtros)){
			i = new Intent(this, Pantalla2.class);			
			startActivity(i);
		}
	}
}
