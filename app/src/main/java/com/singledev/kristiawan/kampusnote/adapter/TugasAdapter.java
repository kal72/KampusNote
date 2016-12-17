package com.singledev.kristiawan.kampusnote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singledev.kristiawan.kampusnote.R;

/**
 * Created by ASUS on 25/09/2016.
 */

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.TugasHolder> {

    @Override
    public TugasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TugasHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tugas_view, parent, false));
    }

    @Override
    public void onBindViewHolder(TugasHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    class TugasHolder extends RecyclerView.ViewHolder{

        public TugasHolder(View itemView) {
            super(itemView);
        }
    }
}
