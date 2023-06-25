package pe.senati.projectoshein.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.senati.projectoshein.R;
import pe.senati.projectoshein.bean.Producto;

public class SheinAdapter extends RecyclerView.Adapter<SheinAdapter.ViewHolder> {

    List<Producto> lstProducto;

    public SheinAdapter(List<Producto> lstProducto){
        this.lstProducto = lstProducto;
    }

    @NonNull
    @Override
    public SheinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false) ) ;
    }

    @Override
    public void onBindViewHolder(@NonNull SheinAdapter.ViewHolder holder, int position) {
        final  Producto producto = lstProducto.get(position);
        "https:// ssss, / jajajaj/img/productos" +producto.getId() + ".png"
        holder.ivDetalle.setText(producto.getDetalle());
        holder.ivColor.setText(producto.getColor());
        holder.ivPrecio.setText(producto.getPrecio());

        holder.itemView.setOnClickListener(view ->{Navigation.findNavController( view ).navigate( R.id.nav_producto);});
        holder.ivImagen.setOnClickListener(view ->{Navigation.findNavController( view ).navigate( R.id.nav_producto);});

    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImagen;
        TextView ivDetalle;
        TextView ivPrecio;
        TextView ivColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen_item_shein);
            ivDetalle = itemView.findViewById(R.id.ivDetalle_item_shein);
            ivPrecio = itemView.findViewById(R.id.ivPrecio_item_shein);
            ivColor = itemView.findViewById(R.id.ivColor_item_shein);
        }
    }
}

