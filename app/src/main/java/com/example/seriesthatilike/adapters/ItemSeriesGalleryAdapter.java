//package com.example.seriesthatilike.adpters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.seriesthatilike.R;
//import com.example.seriesthatilike.models.ItemSeriesGalleryModel;
//
//import java.util.List;
//
//public class ItemSeriesGalleryAdapter extends RecyclerView.Adapter<ItemSeriesGalleryAdapter.ItemViewHolder> {
//    private List<ItemSeriesGalleryModel> itemList;
//    private Context context;
//    public ItemSeriesGalleryAdapter(Context context, List<ItemSeriesGalleryModel> itemList) {
//        this.context = context;
//        this.itemList = itemList;
//    }
//
//    @NonNull
//    @Override
//    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_model_design_series_gallery, parent, false);
//
//        return new ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
//        ItemSeriesGalleryModel item = itemList.get(position);
//
//        holder.img_series_gallery.setImageURI(item.getImg_series_gallery());
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class ItemViewHolder extends RecyclerView.ViewHolder{
//        ImageView img_series_gallery;
//        TextView txt_series_gallery;
//
//        public ItemViewHolder(@NonNull View itemView){
//            super(itemView);
//
//            img_series_gallery = itemView.findViewById(R.id.img_series_gallery);
//            txt_series_gallery = itemView.findViewById(R.id.txt_series_gallery);
//        }
//    }
//}