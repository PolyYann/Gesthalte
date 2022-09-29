package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lebeau.gesthalte.R;
import com.lebeau.gesthalte.RegistreActivity;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<CheckedEnfant> {
    private ArrayList<CheckedEnfant> listEnfant;
    private Context context;

    public CustomListAdapter(Context context, ArrayList<CheckedEnfant> listEnfants) {
        super(context, R.layout.enfant_list, listEnfants);
        this.listEnfant = listEnfants;
        this.context = context;

    }



    private class ViewHolder {
        TextView lblEnfantNom;
        CheckBox chkPresent;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_registre, parent, false);
        TextView lblEnfantNom = rowView.findViewById(R.id.lblEnfantNom);
        CheckBox chkPresent = rowView.findViewById(R.id.chkPresent);
        lblEnfantNom.setText(listEnfant.get(position).getNomComplet());
        chkPresent.setChecked(listEnfant.get(position).isPresent());
        return rowView;
    }
}
