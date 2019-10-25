package com.byiryu.templatemvp.ui.fragment.B;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.byiryu.templatemvp.R;
import com.byiryu.templatemvp.data.model.Recycler;
import com.byiryu.templatemvp.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BViewHolder extends BaseViewHolder {

    private static final String TAG = "BViewHolder";

    private Context context;
    private BRecyclerViewAdapter.Callback callback;

    @BindView(R.id.recyclerview_contents_txt)
    TextView textView;

    public BViewHolder(View itemView, Context context, BRecyclerViewAdapter.Callback callback) {

        super(itemView);

        ButterKnife.bind(this,itemView);

        this.context = context;
        this.callback = callback;

    }

    @Override
    protected void clear() {

    }

    public void onBind(Recycler item, int position, RequestManager requestManager, RequestOptions requestOptions){

//        requestOptions.centerCrop();
//        requestManager.load(item.title_url).into(url);
//        requestManager.load(item.url).apply(requestOptions).into(imageView);

        textView.setText(item.getTxt());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback != null){
                    callback.clickListener(item.getTxt());
                }
            }
        });

    }
}
