package com.example.hemant.agroinc;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hemant on 20-Mar-18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private List<CropDetails> cropList;
    private List<CropDetails> cropListFiltered;
    private CropAdapterListener listener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public ImageView thumbnail;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(view.getContext(),SensorResults.class);
                    i.putExtra("cropName",title.getText().toString());
                    view.getContext().startActivity(i);
                }
            });


        }
    }
    public MyAdapter(Context mContext, List<CropDetails> cropList) {
        this.mContext = mContext;
        this.cropList = cropList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_agrih, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CropDetails crop = cropList.get(position);
        holder.title.setText(crop.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(crop.getThumbnail()).into(holder.thumbnail);
    }





    /**
     * Showing popup menu when tapping on 3 dots

    /**
     * Click listener for popup menu items
     */


    @Override
    public int getItemCount() {
        return cropList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    cropListFiltered = cropList;
                } else {
                    List<CropDetails> filteredList = new ArrayList<>();
                    for (CropDetails row : cropList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) ) {
                            filteredList.add(row);
                        }
                    }

                    cropListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = cropListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                cropListFiltered = (ArrayList<CropDetails>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface CropAdapterListener {
        void onCropSelected(CropDetails cropDetails);
    }
}
