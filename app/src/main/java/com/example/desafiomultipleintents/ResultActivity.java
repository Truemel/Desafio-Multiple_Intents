package com.example.desafiomultipleintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button web, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        web = findViewById(R.id.webBu);
        share = findViewById(R.id.share);
        web.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == web.getId()){
            Bundle bundle =  getIntent().getExtras();
            Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse(bundle.getString("uri")));
            startActivity(inten);
        }else if(v.getId() == share.getId()){
            Intent inten = new Intent();
            inten.setAction(Intent.ACTION_SEND);
            Bundle bundle = getIntent().getExtras();
            inten.putExtra("menssage", bundle.getBoolean("photo")+" "+bundle.getString("uri"));
            startActivity(inten);
        }
    }
}
