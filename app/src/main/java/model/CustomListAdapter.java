package model;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lebeau.gesthalte.R;
import com.lebeau.gesthalte.RegistreActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {
    private List<String> nomComplets;
    private Context context;
    DBAdapter dbAdapter;
    public CustomListAdapter(List<String> nomComplet, @NonNull Context context) {
        super(context, R.layout.enfant_list, nomComplet);
        this.context = context;
        this.nomComplets = nomComplet;
        dbAdapter = new DBAdapter(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.enfant_list, parent, false);
        TextView lblEnfantNom = row.findViewById(R.id.lblEnfantNom);
        lblEnfantNom.setText(nomComplets.get(position));
        CheckBox checkBox = row.findViewById(R.id.chkPresent);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    dbAdapter.modifierPresence(true, RegistreEnfants.getInstance().getEnfant(position).get_id());
                } else {
                    dbAdapter.modifierPresence(false, RegistreEnfants.getInstance().getEnfant(position).get_id());
                }
            }
        });
        return row;
    }
}
