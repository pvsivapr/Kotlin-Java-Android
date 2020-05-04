package com.example.androidselflearningtutorials.first_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Data.NewsListModel;
import com.example.androidselflearningtutorials.R;
import com.sivaprasad.controls.URLImage;

public class NewsListPageAdaptor extends RecyclerView.Adapter<NewsListPageAdaptor.NewsListHolder> {

    private NewsListModel[] newsListModels;

    public NewsListPageAdaptor(NewsListModel[] _newsListModels) {
        this.newsListModels = _newsListModels;
    }

    @NonNull
    @Override
    public NewsListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //To create item view
        LayoutInflater newsListInflater = LayoutInflater.from(parent.getContext());
        View newListItem = newsListInflater.inflate(R.layout.news_list_item_layout, parent, false);
        NewsListHolder newsListHolder = new NewsListHolder(newListItem);
        return newsListHolder;
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListHolder holder, int position) {
        //Handle data as per single item
        final NewsListModel newsListModel = newsListModels[position];
        holder.newsItemHeaderText.setText(newsListModel.getNewsHeader());
        holder.newsItemDescriptionText.setText(newsListModel.getNewsDescription());

        if (newsListModel.getImageType() == com.example.Data.NewsListModel.ImageType.FromURL) {
            try {
                URLImage loadImage = new URLImage(holder.newsItemDisplayImage);
                loadImage.execute(newsListModel.getImageURL());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (newsListModel.getImageType() == com.example.Data.NewsListModel.ImageType.FromFileName) {
            holder.newsItemDisplayImage.setBackgroundResource(R.drawable.minion);
            //holder.newsItemDisplayImage.setBackgroundResource(R.drawable.news_item1);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return newsListModels.length;
    }

    public class NewsListHolder extends RecyclerView.ViewHolder {
        public ImageView newsItemDisplayImage;
        public TextView newsItemHeaderText;
        public TextView newsItemDescriptionText;

        public NewsListHolder(@NonNull View itemView) {
            super(itemView);
            this.newsItemDisplayImage = (ImageView) itemView.findViewById(R.id.news_item_display_image);
            this.newsItemHeaderText = (TextView) itemView.findViewById(R.id.news_item_header_text);
            this.newsItemDescriptionText = (TextView) itemView.findViewById(R.id.news_item_description_text);
        }
    }
}
