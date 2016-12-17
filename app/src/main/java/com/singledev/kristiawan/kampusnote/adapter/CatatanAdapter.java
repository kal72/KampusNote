package com.singledev.kristiawan.kampusnote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singledev.kristiawan.kampusnote.R;

/**
 * Created by ASUS on 25/09/2016.
 */

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.CatatanHolder> {

    @Override
    public CatatanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatatanHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_catatan_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CatatanHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class CatatanHolder extends RecyclerView.ViewHolder{

        public CatatanHolder(View itemView) {
            super(itemView);
        }
    }
}
