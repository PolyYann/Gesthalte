package com.lebeau.gesthalte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import model.Enfant;

public class ModifierAdapter extends RecyclerView.Adapter<ModifierAdapter.ViewHolder> {
    Context context;
    String[] label;
    String[] value;

    public ModifierAdapter(Context context,String[] label,String[] value) {
        this.context = context;
        this.label = label;
        this.value = value;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ligne_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lblLigneItem.setText(label[position]);
        holder.txtLigneItem.setText(value[position]);

    }

    @Override
    public int getItemCount() {
        return label.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lblLigneItem;
        EditText txtLigneItem;
        public ViewHolder(View itemView) {
            super(itemView);
            lblLigneItem = (TextView) itemView.findViewById(R.id.lblLigneItem);
            txtLigneItem = (EditText) itemView.findViewById(R.id.txtLigneItem);
        }

    }
}
