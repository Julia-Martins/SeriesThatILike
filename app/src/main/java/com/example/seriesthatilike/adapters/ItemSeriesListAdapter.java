package com.example.seriesthatilike.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seriesthatilike.R;
import com.example.seriesthatilike.models.ItemSeriesListModel;

import java.util.List;

public class ItemSeriesListAdapter extends RecyclerView.Adapter<ItemSeriesListAdapter.ItemViewHolder>{
    protected List<ItemSeriesListModel> itemSeriesModel;
    protected Context context;

    public ItemSeriesListAdapter(){}
    public ItemSeriesListAdapter(List<ItemSeriesListModel> itemSeriesModel, Context context){
        this.itemSeriesModel = itemSeriesModel;
        this.context = context;
    }

    public void setItemSeriesModel(List<ItemSeriesListModel> itemSeriesModel){
        this.itemSeriesModel = itemSeriesModel;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_model_design_information, parent, false);

        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemSeriesListModel itemSeriesListModel = itemSeriesModel.get(position);

        holder.seriesName.setText(itemSeriesListModel.getSeriesName());
        holder.seriesDate.setText(itemSeriesListModel.getSeriesDate().toString());
        holder.intEpiNum.setText(itemSeriesListModel.getIntEpiNum());
        holder.intSeasonNum.setText(itemSeriesListModel.getIntSeasonNum());
        holder.seriesWatch.setChecked(itemSeriesListModel.isSeriesWatch());
        holder.seriesAddEp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Soon it will work!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView seriesName;
        TextView seriesDate;
        TextView seriesPlatform;
        TextView intEpiNum;
        TextView intSeasonNum;
        CheckBox seriesWatch;
        ImageButton seriesAddEp;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);

            seriesName = itemView.findViewById(R.id.txt_name_series_list);
            seriesDate = itemView.findViewById(R.id.txt_dt_watching_series_list);
            seriesPlatform = itemView.findViewById(R.id.txt_platform_series_list);
            intEpiNum = itemView.findViewById(R.id.txt_episodes_number_series_list);
            intSeasonNum = itemView.findViewById(R.id.txt_season_number_series_list);
            seriesWatch = itemView.findViewById(R.id.chk_watch_add_series);
            seriesAddEp = itemView.findViewById(R.id.img_add_episodes_series_list);
        }
    }
}
