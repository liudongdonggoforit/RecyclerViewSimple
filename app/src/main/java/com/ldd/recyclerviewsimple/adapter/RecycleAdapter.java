package com.ldd.recyclerviewsimple.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldd.recyclerviewsimple.R;

/**
 * Created by Mr.liu
 * On 2016/6/29
 * At 11:14
 * RecyclerViewSimple
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /** item 的类型 */
    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_CONTENT = 1;
    private static final int ITEM_TYPE_FOOT = 2;
    private Context mContext;
    private String [] subjects;
    private LayoutInflater mLayoutInflater;
    private int mHeaderCount = 1;//头部view的数量
    private int mFootCount = 1;//尾部view的数量

    public RecycleAdapter(Context mContext, String[] subjects) {
        this.mContext = mContext;
        this.subjects = subjects;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 自定义ViewHold  内容ViewHolder
     */
    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.subject);
        }
    }

    /**
     *  HeaderViewHolder
     */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    /**
     * FootViewHolder
     */
    public static class FootViewHolder extends RecyclerView.ViewHolder{

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 判断当前view是不是HeaderView
     * @param position
     * @return
     */
    public boolean isHeaderView(int position){
        return mHeaderCount!=0 && position <mHeaderCount;
    }

    public boolean isFootView(int position){
        return mFootCount!=0 && position >= mHeaderCount + subjects.length;
    }

    /**
     * 当前item的类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount!=0&&position < mHeaderCount){
            return ITEM_TYPE_HEADER;
        }else if(mFootCount!=0&&position >= mHeaderCount+subjects.length){
            return ITEM_TYPE_FOOT;
        }else{
            return ITEM_TYPE_CONTENT;
        }
    }

    /**
     * 创建新view 被LayoutManage所调用
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE_HEADER){
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.item_recycle_header, parent, false));
        }else if (viewType == ITEM_TYPE_CONTENT){
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_recyclerview, parent, false));
        }else if (viewType == ITEM_TYPE_FOOT){
            return new FootViewHolder(mLayoutInflater.inflate(R.layout.item_recycle_header,parent,false));
        }
        return null;
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
//        ContentViewHolder contentViewHolder = new ContentViewHolder(view);
//        return contentViewHolder;
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder){
            ((ContentViewHolder)holder).mTextView.setText(subjects[position - mHeaderCount]);
        }else if(holder instanceof FootViewHolder){

        }else if(holder instanceof HeaderViewHolder){

        }
    }

    /**
     * item 数量
     * @return
     */
    @Override
    public int getItemCount() {
        return subjects.length + mHeaderCount + mFootCount;
    }
}
