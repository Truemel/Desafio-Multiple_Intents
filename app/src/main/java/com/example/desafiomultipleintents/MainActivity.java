package com.example.desafiomultipleintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private Button but1, next;

    public final static int REQUEST_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        but1 = findViewById(R.id.button1);
        but1.setOnClickListener(this);
        next = findViewById(R.id.nextBu);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == but1.getId()){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, REQUEST_PHOTO);
        }else if(v.getId() == next.getId()){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PHOTO && resultCode == RESULT_OK)
            image.setImageBitmap((Bitmap)data.getExtras().get("data"));
    }
}
