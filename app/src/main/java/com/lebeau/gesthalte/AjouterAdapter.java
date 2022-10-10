package com.lebeau.gesthalte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AjouterAdapter extends RecyclerView.Adapter<AjouterAdapter.ViewHolder> {
    Context context;
    String[] list;

    public AjouterAdapter(Context context,String[] list) {
        this.context = context;
        this.list = list;
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
        holder.lblLigneItem.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
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


