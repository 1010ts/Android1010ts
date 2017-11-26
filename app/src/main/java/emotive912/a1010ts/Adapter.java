package emotive912.a1010ts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class Adapter extends RecyclerView.Adapter<Adapter.TruckHolder> {

    @Override
    public TruckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TruckHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class TruckHolder extends RecyclerView.ViewHolder{

        public TruckHolder(View itemView) {
            super(itemView);
        }

    }
}
