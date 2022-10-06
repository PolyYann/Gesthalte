package com.lebeau.gesthalte;
import androidx.appcompat.app.AppCompatActivity;import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import model.Enfant;

public class EnfantAdapter extends RecyclerView.Adapter<EnfantAdapter.ViewHolder> {
    private List<Enfant> enfants;
    private Context context;
    private EnfantDBHelper enfantDBHelper;

    public EnfantAdapter(List<Enfant> enfants, Context context) {
        this.enfants = enfants;
        this.context = context;
        enfantDBHelper = new EnfantDBHelper(context);
    }

    @NonNull
    @Override
    public EnfantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.enfant_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Enfant enfant = enfants.get(position);
        holder.lblEnfantNom.setText(new StringBuilder().append(enfant.getPrenom()).append(" ").append(enfant.getNom()).toString());
        if(enfant.isPresent()){
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()) {
                    enfant.setPresent(true);
                    enfantDBHelper.updateEnfant(enfant);
                }else{
                    enfant.setPresent(false);
                    enfantDBHelper.updateEnfant(enfant);
                }
            }
            });
        holder.btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modifierIntent = new Intent(view.getContext(), ModifierActivity.class);
                modifierIntent.putExtra("enfant",enfant);
                view.getContext().startActivity(modifierIntent);
            }
        });
        }

        @Override
        public int getItemCount () {
             return enfants.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView lblEnfantNom;
            TextView textViewId;
            CheckBox checkBox;
            Button btnModifier;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewId = itemView.findViewById(R.id.textViewId);
                lblEnfantNom = itemView.findViewById(R.id.lblEnfantNom);
                checkBox = itemView.findViewById(R.id.chkPresent);
                btnModifier = itemView.findViewById(R.id.btnModifier);

            }
        }
    }
