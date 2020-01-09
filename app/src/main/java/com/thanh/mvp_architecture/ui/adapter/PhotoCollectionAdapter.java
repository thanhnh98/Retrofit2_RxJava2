package com.thanh.mvp_architecture.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thanh.mvp_architecture.R;
import com.thanh.mvp_architecture.model.PhotoModel;

import java.util.List;

import io.reactivex.Observable;

public class PhotoCollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<PhotoModel> mData;

    public PhotoCollectionAdapter(Context context, List<PhotoModel> mData){

        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType<mData.size()){
            return new ViewHolderPhotoItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_photo,parent,false));
        }
        return new ViewHolderPhotoItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_loadmore,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderPhotoItem viewHolder;
        if(position<mData.size()){
            viewHolder=(ViewHolderPhotoItem)holder;
            viewHolder.tv_name.setText(mData.get(position).getName());
            viewHolder.tv_desc.setText("They là mô tả");
            Picasso.get().load(mData.get(position).getUrl()).into(viewHolder.img);
        }


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size()+1;
    }


    public class ViewHolderPhotoItem extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_desc;
        ImageView img;
        public ViewHolderPhotoItem(@NonNull View itemView) {
            super(itemView);
            tv_desc=itemView.findViewById(R.id.tv_desc);
            tv_name=itemView.findViewById(R.id.tv_name);
            img=itemView.findViewById(R.id.img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "item: "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    public class ViewHolderLoadMore extends RecyclerView.ViewHolder{
        public ViewHolderLoadMore(@NonNull View view){
            super(view);
        }
    }
}
