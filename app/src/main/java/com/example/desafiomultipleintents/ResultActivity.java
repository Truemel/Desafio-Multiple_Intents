package com.example.desafiomultipleintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button web, share;
    private boolean photo;
    private String uri;
    private static final int VIEW_WEB = 1;
    private final static int SHARE_DATA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        photo = bundle.getBoolean("photo");
        uri = bundle.getString("uri");

        web = findViewById(R.id.webBu);
        share = findViewById(R.id.share);
        web.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == web.getId()){
            viewWeb();
        }else if(v.getId() == share.getId()){
            sendData();
        }
    }

    private void viewWeb(){
        Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivityForResult(inten, VIEW_WEB);
    }

    private void sendData(){
        Intent inten = new Intent();
        inten.setAction(Intent.ACTION_SEND);
        inten.putExtra("message", photo+" "+uri);
        inten.setType("text/plain");
        startActivityForResult(inten, SHARE_DATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("AAA", "YES");
        if(requestCode == VIEW_WEB)
            Toast.makeText(this, "Ver web", Toast.LENGTH_LONG).show();
        if(requestCode == SHARE_DATA)
            Toast.makeText(this, "Compartir mensaje", Toast.LENGTH_LONG).show();
    }
}
