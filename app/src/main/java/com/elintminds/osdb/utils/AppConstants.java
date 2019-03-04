package com.elintminds.osdb.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class AppConstants {


    public static final int MY_CAMERA_PERMISSION_CODE = 11;


    public static Uri getOutputMediaFileUri(Context context) {
        Uri imageUri = null;
        File mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp;
        File mediaFile = null;
        try {
            mediaFile = File.createTempFile(imageFileName, ".jpg", mediaStorageDir);
        } catch (IOException e) {
            Log.e("IMG FILE ERROR", "" + e.getMessage());
        }
        if (mediaFile != null) {
            imageUri = Uri.fromFile(mediaFile);
        }
        return imageUri;
    }


    public static Bitmap decodeBitmapFromSDCard(String filePath, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, bmOptions);

        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / reqWidth, photoH / reqHeight);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        return BitmapFactory.decodeFile(filePath, bmOptions);
    }


    public static Uri getImageUri(Context context, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public static int rotationAngle(String filePath) {
        int rotation = 0;
        ExifInterface ei = null;
        try {
            ei = new ExifInterface(filePath);

            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:

                    rotation = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:

                    rotation = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:

                    rotation = 270;
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotation;
    }

    public static String getRealPathFromURI(Context context, Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }


    private static String getExternalFolderPath() {
        String extFoldPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        return extFoldPath;
    }


    private static void createFirstwallDir() {
        File firstwallDir = new File(getExternalFolderPath() + "/OSDB/");
        if (!firstwallDir.exists()) {
            firstwallDir.mkdir();
        }
    }

    public static Bitmap getThumbnail(String url) {

        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

        mediaMetadataRetriever.setDataSource(url, new HashMap<String, String>());
        Bitmap bmFrame = mediaMetadataRetriever.getFrameAtTime(1000); //unit in microsecond
        return bmFrame;
    }


    public static String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        String newDate = null;
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return spf.format(date);
    }


    public static String convertDateFormat(String date) {

        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        Date newDate = null;
        try {
            newDate = spf.parse(date);
            spf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
            date = spf.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    private String getDobFormat(String dob) {
        //1989-02-25
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date newDate = null;
        try {
            newDate = spf.parse(dob);
            spf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            dob = spf.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dob;
    }


}
