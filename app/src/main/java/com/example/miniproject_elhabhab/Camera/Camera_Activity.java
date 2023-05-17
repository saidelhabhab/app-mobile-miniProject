package com.example.miniproject_elhabhab.Camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.miniproject_elhabhab.R;

public class Camera_Activity extends AppCompatActivity {

    private Button openCamera;
    private ImageView captureImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        captureImg = findViewById(R.id.captureImg);
        openCamera = findViewById(R.id.OpenCamera);

        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open,100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap photo = (Bitmap) data.getExtras().get("data");
        captureImg.setImageBitmap(photo);

    }


}