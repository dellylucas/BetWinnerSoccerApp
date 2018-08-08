package data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dellyfl.betwinnersoccer.R;

import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {
    private List<String> items;

    public PartAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_part, parent, false);
        return new PartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int i) {
        holder.mequipoU.setText(items.get(i));
        holder.mhorapart.setText("horass: 4:00 pm");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class PartViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView mequipoU;
        public TextView mhorapart;

        public PartViewHolder(View v) {
            super(v);
            mequipoU = (TextView) v.findViewById(R.id.equipoUno);
            mhorapart = (TextView) v.findViewById(R.id.hora);
        }
    }
}
