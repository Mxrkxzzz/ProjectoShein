package pe.senati.projectoshein.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import pe.senati.projectoshein.R;
import pe.senati.projectoshein.bean.Producto;
import pe.senati.projectoshein.dao.ProductoDao;
import pe.senati.projectoshein.databinding.FragmentFrgProductoBinding;

public class frgProducto extends Fragment {

    FragmentFrgProductoBinding binding;
    ProductoDao productoDao;
    List<Producto> lstProducto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frg_producto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}