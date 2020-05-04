package com.example.androidselflearningtutorials.first_recycler_view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Data.NewsListModel;
import com.example.androidselflearningtutorials.R;

public class NewsListPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_page_layout);
        LoadViews();
    }

    private void LoadViews()
    {
        TextView howTOTextView = findViewById(R.id.how_to_recyclerview_text);
        howTOTextView.setText("Add dependency to build.gradle, add a adapter to display items, add teo xml files for the total list and for each list item");

        NewsListModel[] newsListModels = com.example.Data.ListItemsData.GetNewsItems();

        RecyclerView newsRecyclerView = (RecyclerView)findViewById(R.id.news_recycler_view);
        NewsListPageAdaptor newsListPageAdaptor = new NewsListPageAdaptor(newsListModels);
        newsRecyclerView.setHasFixedSize(true);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsRecyclerView.setAdapter(newsListPageAdaptor);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.first_recycler_view_back_button:
                    this.finish();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Log.e(this.getLocalClassName(), ex.getMessage());
        }
    }
}
