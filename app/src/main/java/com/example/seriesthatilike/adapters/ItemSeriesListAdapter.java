package com.example.seriesthatilike.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.ParcelableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seriesthatilike.R;
import com.example.seriesthatilike.activities.ListSeriesGallery;
import com.example.seriesthatilike.models.ItemSeriesListModel;

import java.util.List;

public class ItemSeriesListAdapter extends RecyclerView.Adapter<ItemSeriesListAdapter.ItemViewHolder>{
    protected List<ItemSeriesListModel> itemSeriesModel;
    protected Context context;

    public ItemSeriesListAdapter(List<ItemSeriesListModel> itemSeriesModel, Context context){
        this.itemSeriesModel = itemSeriesModel;
        this.context = context;
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

        holder.uriSeries.setImageURI(Uri.parse(itemSeriesListModel.getUriSeries()));
        holder.uriPlatform.setImageURI(Uri.parse(itemSeriesListModel.getUriPlatform()));
        holder.seriesName.setText(itemSeriesListModel.getSeriesName());
        holder.seriesTitleDescription.setText(itemSeriesListModel.getSeriesTitleDescription());
        holder.seriesDescription.setText(itemSeriesListModel.getSeriesDescription());
        holder.seriesDate.setText(itemSeriesListModel.getSeriesDate().toString());
        holder.intEpiNum.setText(itemSeriesListModel.getIntEpiNum());
        holder.intSeasonNum.setText(itemSeriesListModel.getIntSeasonNum());
        holder.btnWatch.setImageURI(Uri.parse(itemSeriesListModel.getBtnWatch()));
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView uriSeries;
        ImageView uriPlatform;
        TextView seriesName;
        TextView seriesTitleDescription;
        TextView seriesDescription;
        TextView seriesDate;
        TextView intEpiNum;
        TextView intSeasonNum;
        ImageButton btnWatch;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);

            uriSeries = itemView.findViewById(R.id.img_series_list);
            uriPlatform = itemView.findViewById(R.id.img_platform_series_list);

            seriesName = itemView.findViewById(R.id.txt_series_list);
            seriesTitleDescription = itemView.findViewById(R.id.txt_title_description_series_list);
            seriesDescription = itemView.findViewById(R.id.txt_description_series_list);
            seriesDate = itemView.findViewById(R.id.txt_dt_watching_series_list);
            intEpiNum = itemView.findViewById(R.id.txt_episodes_number_series_list);
            intSeasonNum = itemView.findViewById(R.id.txt_season_number_series_list);

            btnWatch = itemView.findViewById(R.id.imgButton_watch_watched_will_watch_series_list);
        }
    }
}
