package tuncay.yilmaz.com.facedetection1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private FaceOverlayView mFacewOverlayView;
    public static final int IMAGE_GALLERY_REQUEST = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        // where do we want to find the data?
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        // finally, get a URI representation
        Uri data = Uri.parse(pictureDirectoryPath);
        // set the data and type.  Get all image types.
        photoPickerIntent.setDataAndType(data, "image/*");
        // we will invoke this activity, and get something back from it.
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);


     /*   mFacewOverlayView = (FaceOverlayView) findViewById(R.id.face_overlay);
       InputStream stream = getResources().openRawResource(R.raw.f);
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mFacewOverlayView.setmBitmap(bitmap);
        */

    }
    @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    if (resultCode == RESULT_OK) {
        // if we are here, everything processed successfully.
        if (requestCode == IMAGE_GALLERY_REQUEST) {
            // if we are here, we are hearing back from the image gallery.
            // the address of the image on the SD Card.
            Uri imageUri = data.getData();
            // declare a stream to read the image data from the SD Card.
            InputStream inputStream;
            // we are getting an input stream, based on the URI of the image.
            try {
                inputStream = getContentResolver().openInputStream(imageUri);
                // get a bitmap from the stream.
               Bitmap image = BitmapFactory.decodeStream(inputStream);

                mFacewOverlayView = (FaceOverlayView) findViewById(R.id.face_overlay);
    /*   InputStream stream = getResources().openRawResource(R.raw.f);
        Bitmap bitmap = BitmapFactory.decodeStream(stream);*/
                mFacewOverlayView.setmBitmap(image);



            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // show a message to the user indictating that the image is unavailable.
                Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
            }
        }
    }}






}
