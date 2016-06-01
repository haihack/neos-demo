package neos.haihack.com.demoneos.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import neos.haihack.com.demoneos.R;

/**
 * Created by LinNH on 5/31/2016.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ItemGridView> {

    public List<String> listImg = new ArrayList<>();

    public PhotoAdapter() {
    }

    public void setData(List<String> data) {
        listImg.clear();
        listImg.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public ItemGridView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new ItemGridView(view);
    }

    @Override
    public void onBindViewHolder(ItemGridView holder, int position) {
        ItemGridView programViewHolder = (ItemGridView) holder;
        programViewHolder.setData(listImg);
    }

    @Override
    public int getItemCount() {
        return listImg.size();
    }

    public class ItemGridView extends RecyclerView.ViewHolder {
        public ImageView imgView;

        public ItemGridView(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.img_show);
        }

        public void setData(List<String> listImg) {
            Log.d(",","============ list sixe--------" + listImg.size());
            Glide.with(itemView.getContext()).load(listImg.get(getAdapterPosition())).into( imgView);
        }
    }
}
