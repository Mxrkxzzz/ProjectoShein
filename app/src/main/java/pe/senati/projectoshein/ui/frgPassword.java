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
import pe.senati.projectoshein.databinding.FragmentFrgLoginBinding;
import pe.senati.projectoshein.databinding.FragmentFrgPasswordBinding;

public class frgPassword extends Fragment {

    FragmentFrgPasswordBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFrgPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.btnEnviarAtras.setOnClickListener(view11 -> navController.navigate(R.id.nav_yo));
    }
}