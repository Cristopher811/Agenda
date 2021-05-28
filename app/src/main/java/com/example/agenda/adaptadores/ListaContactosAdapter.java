package com.example.agenda.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.entidades.Contacto;
import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactiViewHolder> {
    ArrayList<Contacto> listaContactos;
    public ListaContactosAdapter(ArrayList<Contacto>listaContactos){
        this.listaContactos = listaContactos;
    }
    @NonNull
    @Override
    public ContactiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contactos, null, false);
        return new ContactiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaContactosAdapter.ContactiViewHolder holder, int position) {
        holder.viewNombre.setText(listaContactos.get(position).getNombre());
        holder.viewTelefono.setText(listaContactos.get(position).getTelefono());
        holder.viewEmail.setText(listaContactos.get(position).getEmail());
    }
    @Override
    public int getItemCount() {
        return listaContactos.size();
    }
    public class ContactiViewHolder extends RecyclerView.ViewHolder{
        TextView viewNombre, viewTelefono, viewEmail;
        public ContactiViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.textViewNombre);
            viewTelefono = itemView.findViewById(R.id.textViewTelefono);
            viewEmail = itemView.findViewById(R.id.textViewCorreo);
        }
    }
}
