package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ViewGroup scrollView;
    ImageView icon;
    TextView txtMsg;
    int index;
    ImageView fullImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView=findViewById(R.id.scrollView);
        txtMsg=findViewById(R.id.message);
        fullImage=findViewById(R.id.fullImage);
        try{
            String absolutePath= Environment.getExternalStorageDirectory().getAbsolutePath();
            String pathPicture=absolutePath+"/Pictures";
            File sdPictureFiles=new File(pathPicture);
            File[] files=sdPictureFiles.listFiles();
            File file;
            for(index=0; index<files.length; index++){
                file=files[index];
                final View frame=getLayoutInflater().inflate(R.layout.frame_icon_caption, null);
                icon=frame.findViewById(R.id.icon);
                Bitmap bm=BitmapFactory.decodeFile(file.getAbsolutePath());
                icon.setImageBitmap(bm);
                scrollView.addView(frame);
                frame.setId(index);
                frame.setOnClickListener(v -> {
                    String text="Obrazek nr: "+frame.getId();
                    txtMsg.setText(text);
                    fullImage.setImageBitmap(bm);
                });
            }
        }catch(Exception e){
            txtMsg.append(e.getMessage());
        }

    }

}