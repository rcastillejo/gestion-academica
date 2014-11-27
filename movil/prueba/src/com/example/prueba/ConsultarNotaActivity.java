package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sacooliveros.gestionacademica.bean.AlumnoBean;
import com.sacooliveros.intranet.bean.UsuarioBean;
import com.sacooliveros.intranet.controller.AlumnoController;
import com.sacooliveros.intranet.controller.GestionAcademicaService;
import com.sacooliveros.intranet.controller.LoginController;
import com.sacooliveros.intranet.util.HyundaiProgressDialog;
import com.sacooliveros.intranet.util.LoadTaskDialog;
import com.sacooliveros.intranet.util.Loadingable;

public class ConsultarNotaActivity extends MenuActivity implements OnClickListener, Loadingable{
	TextView txtAlumno, txtTipCentro, txtCentro, txtLocal, txtAula;
	TextView txtTipGrado, txtGrado, txtSeccion, txtNivel, txtCorreo;
	TextView txtTurno;
	Button btnRegresar;
	String mensaje;
	AlumnoBean bean;
	UsuarioBean usuario;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asigna el layout de la pantalla que se va a mostrar.
        //Esto permite obtener todos los recursos de la pantalla referenciada.
        setContentView(R.layout.frm_consulta_alumno);
        
        obtenerElementos();
        
        asignarEventos();

        cargarDatos();
    }

	private UsuarioBean getUsuario(){
		/*UsuarioBean usuario = new UsuarioBean();
		usuario.setUsername("151300763");
		return usuario;*/
		return LoginController.getInstance().getSession();
	}
	
	private void rellenarElementos(){
		txtAlumno.setText(bean.getNombres() + " " + bean.getApellidoPaterno() + " " +bean.getApellidoMaterno());
		txtTipCentro.setText(bean.getTipoCentro());
		txtCentro.setText(bean.getCentro());
		txtLocal.setText(bean.getLocal());
		txtAula.setText(bean.getAula());
		txtTipGrado.setText(bean.getTipoGrado());
		txtGrado.setText(bean.getGrado());
		txtSeccion.setText(bean.getSeccion());
		txtNivel.setText(bean.getNivel());
		txtCorreo.setText(bean.getCorreo());
		txtTurno.setText(bean.getTurno());		
	}

    //Obteniendo los recursos de los botones:
    //R, obtengo el identificador del recurso
    //findViewById, obtengo la referencia del objeto
    private void obtenerElementos(){        
    	txtAlumno = (TextView) findViewById(R.id.pantalla1_dato1);        
    	txtTipCentro = (TextView) findViewById(R.id.pantalla1_dato3);
    	txtCentro = (TextView) findViewById(R.id.pantalla1_dato4);
    	txtLocal = (TextView) findViewById(R.id.pantalla1_dato5);
    	txtAula = (TextView) findViewById(R.id.pantalla1_dato6);
    	txtTipGrado = (TextView) findViewById(R.id.pantalla1_dato7);
    	txtGrado = (TextView) findViewById(R.id.pantalla1_dato8);
    	txtSeccion = (TextView) findViewById(R.id.pantalla1_dato9);
    	txtNivel = (TextView) findViewById(R.id.pantalla1_dato10);
    	txtCorreo = (TextView) findViewById(R.id.pantalla1_dato11);
    	txtTurno = (TextView) findViewById(R.id.pantalla1_dato12);
        btnRegresar = (Button) findViewById(R.id.pantalla1_boton1);

    }
    

    private void asignarEventos(){
    	btnRegresar.setOnClickListener(this);
        //boton2.setOnClickListener(this);
    }
    
    
    private void cargarDatos(){
		new LoadTaskDialog(ConsultarNotaActivity.this, null,
				new HyundaiProgressDialog(ConsultarNotaActivity.this)).execute();
    }
    
    public void onClick(View v){
    	Intent i;
    	
    	if(v.equals(btnRegresar)){
    		i = new Intent(this, MenuActivity.class);    		
    	}else{
    		i = new Intent(this, ConsultarNotaActivity.class);    		
    	}
    	startActivity(i);
    }
    
	@Override
	public void beforeLoadingData() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void loadingData() {
		String alumnoId;
		mensaje = "";
		try {
			alumnoId = getUsuario().getUsername();
			bean = AlumnoController.getInstance().consultar(alumnoId);
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
