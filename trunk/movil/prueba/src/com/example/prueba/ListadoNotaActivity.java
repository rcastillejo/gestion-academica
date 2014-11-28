package com.example.prueba;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.gestionacademica.bean.NotaBean;
import com.sacooliveros.gestionacademica.bean.PeriodoBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.controller.NotaController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ListadoNotaActivity extends MenuActivity implements OnClickListener, Loadingable{

	TextView txtNombres, txtApellidos, txtPeriodo;
	Button btnRegresar;
	ListView lstNotas;
	ListadoNotasAdapter adapter;
	List<NotaBean> data;
	String mensaje;
	PeriodoBean beanSelected;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_notas);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }

	
	private void rellenarElementos(){
		AlumnoBean session = AlumnoController.getInstance().getSession(); 
		txtNombres.setText(session.getNombres());
		txtApellidos.setText(session.getApellidoPaterno() + " " + session.getApellidoMaterno());
		
		txtPeriodo.setText(beanSelected.getNombre());
		// Configuracion de atributos <Cabecera, boton>
		
		adapter = new ListadoNotasAdapter(this,
				R.layout.frm_notas_item, data);
		lstNotas.setAdapter(adapter);
		/*lstPeriodos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int pos = arg2;
				NotaController.getInstance().select(pos);
	    		Intent i = new Intent(getBaseContext(), ConsultarNotaActivity.class);
	        	startActivity(i);
				//Toast.makeText(ListadoPeriodoActivity.this, "hola:"+pos, 20).show();
			}
		});*/
	}

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        

    	btnRegresar = (Button) findViewById(R.id.frmNotas_btnRegresar);
    	txtPeriodo = (TextView) findViewById(R.id.frmNotas_txtPeriodo);
    	lstNotas = (ListView) findViewById(R.id.frmNotas_lstNotas);
		txtNombres = (TextView) findViewById(R.id.frmNotas_txtNombres);
		txtApellidos = (TextView) findViewById(R.id.frmNotas_txtApellidos);
		

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		beanSelected = NotaController.getInstance().getItemSelected();
		new LoadTaskDialog(ListadoNotaActivity.this, null,
				new HyundaiProgressDialog(ListadoNotaActivity.this)).execute();
    }

	@Override
    public void onClick(View v){
    	if(v.equals(btnRegresar)){
    		finish();	
    	}
    }

	
	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void loadingData() {
		mensaje = "";
		try {

			if(beanSelected.getMensajeError() != null){
				mensaje = beanSelected.getMensajeError();
			}else{
				data = beanSelected.getNotas();
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
	}

	@Override
	public void afterLoadingData() {
		if (mensaje == null || mensaje.length() == 0){
			rellenarElementos();
		}else{
			Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
		}
		
	}

	
}
