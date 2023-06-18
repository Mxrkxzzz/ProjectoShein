package pe.senati.projectoshein.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.senati.projectoshein.R;
import pe.senati.projectoshein.bean.Cliente;
import pe.senati.projectoshein.dao.ClienteDao;
import pe.senati.projectoshein.databinding.FragmentFrgRegistroBinding;

public class frgRegistro extends Fragment {

    FragmentFrgRegistroBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFrgRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.btnInicioSesion.setOnClickListener(view11 -> navController.navigate(R.id.nav_login));
        binding.btnRegistro.setOnClickListener(view11 -> navController.navigate(R.id.nav_registro));
        binding.btnCerrar.setOnClickListener(view11 -> navController.navigate(R.id.nav_yo));
        binding.btnContinuarRegistro.setOnClickListener(view12 -> btnContinuarRegistro_Click());


    }

    private void btnContinuarRegistro_Click() {
        String sCorreo =  binding.tilCorreo.getEditText().getText().toString();
        String sPassword =  binding.tilPassword.getEditText().getText().toString();
        String sMensaje = "";


        //Error -> til...
        if (sCorreo.isEmpty()) sMensaje ="Ingrese su correo electronico o numero de telefono";
        if (sPassword.isEmpty()) sMensaje ="Ingrese su contraseña para continuar";

        if ( !sMensaje.isEmpty() ) return;


        Cliente cliente = new Cliente();
        cliente.setCorreo( sCorreo );
        cliente.setPassword( sPassword );

        ClienteDao daoCliente = new ClienteDao( getContext() );
        daoCliente.Guardar(cliente);
    }
}
