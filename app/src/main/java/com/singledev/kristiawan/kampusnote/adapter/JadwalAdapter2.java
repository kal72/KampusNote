package com.singledev.kristiawan.kampusnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenter;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;
import com.singledev.kristiawan.kampusnote.presenter.MainView;
import com.singledev.kristiawan.kampusnote.presenter.MainpresenterImp;
import com.singledev.kristiawan.kampusnote.view.FormEditJadwalActivity;
import com.singledev.kristiawan.kampusnote.view.fragment.JadwalFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 25/09/2016.
 */

public class JadwalAdapter2 extends RecyclerView.Adapter<JadwalAdapter2.JadwalHolder>{
    List<Matakuliah> makulList = new ArrayList<>();
    Context mContext;
    JadwalView jadwalView;

    public JadwalAdapter2(Context mContext, JadwalView jadwalView) {
        this.mContext = mContext;
        this.jadwalView = jadwalView;



    }

    @Override
    public JadwalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JadwalHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_jadwal_view_2, parent, false));
    }

    @Override
    public int getItemCount() {
        return makulList.size();
    }

    @Override
    public void onBindViewHolder(JadwalHolder holder, int position) {
        Matakuliah mk = makulList.get(position);
        holder.header.setText(mk.getNama());
        holder.mainRuangan.setText(mk.getRuangan());
        holder.mainJam.setText("Jam "+mk.getJamMulai()+"-"+mk.getJamBerakhir());
        holder.footer.setText(mk.getTime());


    }

    public void addList(List<Matakuliah> makul){
        //System.out.println("----------------------"+makul.get(0).getHari());
        makulList = makul;
        notifyDataSetChanged();
    }


    class JadwalHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView header;
        TextView mainRuangan;
        TextView mainJam;
        TextView footer;
        ImageView delete;

        public JadwalHolder(View itemView) {
            super(itemView);
            header = (TextView)itemView.findViewById(R.id.header_jadwal);
            mainRuangan = (TextView)itemView.findViewById(R.id.main_ruangan);
            mainJam = (TextView)itemView.findViewById(R.id.main_jam);
            footer = (TextView)itemView.findViewById(R.id.footer_alarm);
            delete = (ImageView)itemView.findViewById(R.id.jadwal_delete);
            delete.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

//            JadwalPresenterImp imp = new JadwalPresenterImp(jadwalView);
//            imp.setFragment("");
            if (view.getId() == R.id.jadwal_delete){
                new MaterialDialog.Builder(mContext)
                        .content(R.string.content)
                        .positiveText(R.string.ya)
                        .negativeText(R.string.tidak)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                JadwalPresenterImp imp = new JadwalPresenterImp(jadwalView);
                                imp.deleteMakul(makulList.get(getAdapterPosition()).getId());
                                makulList.remove(getAdapterPosition());
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }else {
                Intent i = new Intent(mContext, FormEditJadwalActivity.class);
                i.putExtra("id", makulList.get(getAdapterPosition()).getId().intValue());
                mContext.startActivity(i);

                System.out.println("======================================== "+makulList.get(getAdapterPosition()).getId());
            }


        }
    }
}
