package com.example.mybeers.activity;

import static com.example.mybeers.activity.MainActivity.BEER_LIST_KEY;
import static com.example.mybeers.activity.MainActivity.EXTRA_LIST_KEY;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;
import com.example.mybeers.R;
import com.example.mybeers.model.Root;

public class ScrollingActivity extends AppCompatActivity {
    private ImageView scrollPicture;
    private TextView scrollName;
    private TextView scrollTagline;
    private TextView scrollDescription;
    private Root root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
       // Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        root = (Root) getIntent().getSerializableExtra(EXTRA_LIST_KEY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItem();
    }

    private void setViewItem(){
        scrollPicture = findViewById(R.id.desc_picture);
        scrollName = findViewById(R.id.desc_name);
        scrollTagline = findViewById(R.id.desc_tagline);
        scrollDescription = findViewById(R.id.desc_description);


        scrollName.setText(root.getName());
        scrollTagline.setText(root.getTagline());
        scrollDescription.setText(root.getDescription());
        Glide.with(this)
                .load(root.getImage_url())
                .into(scrollPicture);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }
}
