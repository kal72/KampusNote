package com.singledev.kristiawan.kampusnote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenter;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;
import com.singledev.kristiawan.kampusnote.presenter.MainView;
import com.singledev.kristiawan.kampusnote.presenter.MainpresenterImp;
import com.singledev.kristiawan.kampusnote.view.fragment.JadwalFragment;
import com.singledev.kristiawan.kampusnote.view.fragment.JadwalFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 25/09/2016.
 */

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalHolder>{
    List<Matakuliah> makul;
    List days = new ArrayList<>();
    Context mContext;
    JadwalView jadwalView;
    int s = 12;

    public JadwalAdapter(Context mContext, JadwalView jadwalView) {
        this.mContext = mContext;
        this.jadwalView = jadwalView;
        days.add("senin");
        days.add("selasa");
        days.add("rabu");
        days.add("kamis");
        days.add("jumat");
        days.add("sabtu");
        days.add("minggu");

    }

    @Override
    public JadwalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JadwalHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_jadwal_view, parent, false));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    @Override
    public void onBindViewHolder(JadwalHolder holder, int position) {
        String day = days.get(position).toString();
        switch (day)
        {
            case "senin":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setTextColor(mContext.getResources().getColor(R.color.primary_text));
                        txMakul.setCompoundDrawablesWithIntrinsicBounds(R.drawable.record10blue,0,0,0);
                        txMakul.setCompoundDrawablePadding(5);

                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "selasa":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "rabu":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "kamis":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "jumat":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "sabtu":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            case "minggu":
                holder.header.setText(day);
                for (Matakuliah mk : makul) {
                    if (mk.getHari().equals(day)){
                        TextView txMakul = new TextView(mContext);
                        txMakul.setTextSize(s);
                        txMakul.setText(mk.getNama());
                        holder.main.addView(txMakul);
                    }
                }
                break;
            default:

                break;
        }


    }

    public void add(List<Matakuliah> makul){
        this.makul = makul;
        notifyDataSetChanged();
    }


    class JadwalHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout main;
        TextView header;
        CardView cv;

        public JadwalHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_jadwal);
            main = (LinearLayout)itemView.findViewById(R.id.main_jadwal);
            header = (TextView)itemView.findViewById(R.id.header_jadwal);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String day = days.get(getAdapterPosition()).toString();
//            MainpresenterImp imp = new MainpresenterImp(mainView);
//            imp.fragmentChanged(2);
            JadwalPresenterImp imp = new JadwalPresenterImp(jadwalView);
            imp.setFragment(day);
        }


    }
}
