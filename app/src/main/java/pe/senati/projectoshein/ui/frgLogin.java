package pe.senati.projectoshein.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import pe.senati.projectoshein.R;
import pe.senati.projectoshein.bean.Cliente;
import pe.senati.projectoshein.dao.ClienteDao;
import pe.senati.projectoshein.databinding.FragmentFrgLoginBinding;

public class frgLogin extends Fragment {

    FragmentFrgLoginBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFrgLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.btnInicioSesion.setOnClickListener(view11 -> navController.navigate(R.id.nav_login));
        binding.btnRegistro.setOnClickListener(view11 -> navController.navigate(R.id.nav_registro));
        binding.btnCerrar.setOnClickListener(view11 -> navController.navigate(R.id.nav_yo));
        binding.tvPassword.setOnClickListener(view11 -> navController.navigate(R.id.nav_password));
        binding.btnContinuarInicio.setOnClickListener(view11 -> btnContinuarInicio_Click());
    }

    private void btnContinuarInicio_Click() {
        String sCorreo = binding.tilCorreo.getEditText().getText().toString();
        String sPassword = binding.tilPassword.getEditText().getText().toString();

        if (sCorreo.isEmpty() || sPassword.isEmpty() ){

            return;
        }

        Cliente cliente = new Cliente();
        cliente.setCorreo( sCorreo );
        cliente.setPassword( sPassword );

        ClienteDao daoCliente = new ClienteDao( getContext() );
        if ( daoCliente.Login(cliente) ) {
            navController.navigate(R.id.nav_yo);
            return;
        }


        Snackbar.make(getView(),"Usuario y/o constraseña invalido", Snackbar.LENGTH_LONG ).show();
        binding.tilCorreo.getEditText().setText("");
        binding.tilPassword.getEditText().setText("");
    }

}