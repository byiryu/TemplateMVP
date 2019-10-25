package com.byiryu.templatemvp.ui.fragment.B;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.data.model.Recycler;

import java.util.ArrayList;

import javax.inject.Inject;

public class BRecyclerViewAdapter extends RecyclerView.Adapter<BViewHolder> implements BRecyclerViewContract.View, BRecyclerViewContract.Model {
    private static final String TAG = "BRecyclerViewAdapter";

    private ArrayList<Recycler> items;
    private Context context;
    private RequestManager requestManager;
    private RequestOptions requestOptions;
    private Callback callback;



    public BRecyclerViewAdapter() { }

    @Override
    public void onBindViewHolder(BViewHolder viewHolder, int position) {

        if (viewHolder == null)
            return;
        else {
            viewHolder.onBind(items.get(position), position, requestManager, requestOptions);
        }
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new BViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.view_b_recycler_item, parent, false),
                parent.getContext(), callback
        );

    }


    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }


    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<?> items) {
        this.items = (ArrayList<Recycler>) items;
    }

    @Override
    public void clearItem() {
        if(items != null){
            items.clear();
        }
    }

    @Override
    public void setGlide(Context context, RequestManager requestManager, RequestOptions requestOptions) {
        this.context = context;
        this.requestManager = requestManager;
        this.requestOptions = requestOptions;
    }

    @Override
    public void setOnclickListener(Callback onclickListener) {
        this.callback = onclickListener;
    }


    public interface Callback {
        void clickListener(String txt);
    }
}
