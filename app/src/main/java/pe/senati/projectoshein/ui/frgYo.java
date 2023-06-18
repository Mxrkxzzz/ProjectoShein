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

import pe.senati.projectoshein.MainActivity;
import pe.senati.projectoshein.R;
import pe.senati.projectoshein.dao.ClienteDao;
import pe.senati.projectoshein.databinding.FragmentFrgYoBinding;

public class frgYo extends Fragment {

    FragmentFrgYoBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFrgYoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.btnIniciarSesion.setOnClickListener(view11 -> navController.navigate(R.id.nav_registro));

        ClienteDao clienteDAO = new ClienteDao(getContext());
        MainActivity.ClienteLogin = clienteDAO.getCliente();

       binding.btnIniciarSesion.setVisibility( MainActivity.ClienteLogin == null ? View.VISIBLE : View.INVISIBLE);


        binding.tvCliente.setText( MainActivity.ClienteLogin == null ? "": MainActivity.ClienteLogin.getCorreo());//


    }

}