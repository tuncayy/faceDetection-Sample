package tuncay.yilmaz.com.facedetection1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tuncaymsi on 1/3/2017.
 */
public class main2 extends AppCompatActivity {
Button btn1;
    private FaceOverlayView mFacewOverlayView;
    public static final int IMAGE_GALLERY_REQUEST = 20;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        btn1 = (Button) findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);

            }
        });
    }




}
