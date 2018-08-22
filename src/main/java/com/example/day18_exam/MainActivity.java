package com.example.day18_exam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //调用队
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //执行图片请求 地址 请求成功 压缩大的大小 图片类型 请求失败监听事件
        ImageRequest imageRequest = new ImageRequest("http://img.pcauto.com.cn/images/pcautogallery/modle/article/201712/22/15139408830118180_660.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(final Bitmap response) {

                Log.i("Zzzz",response.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(response);
                    }
                });

            }
        }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Zzzz","请求失败");
            }
        });
        requestQueue.add(imageRequest);
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
    }
}
