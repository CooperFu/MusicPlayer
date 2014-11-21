package io.naotou.musicplayer.engine;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

/**
 * Created by Jack_Cooper on 2014/11/21, 20:01.
 * Have a nice day!
 */
public class MediaEngine {
    private MediaEngine() {

    }

    public static MediaEngine mediaEngine = new MediaEngine();

    public static MediaEngine getInstance() {

        return mediaEngine;
    }

    public void loadMusicList(Context context) {

        ContentResolver contentResolver = context.getContentResolver();
        //MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        //这个路径的uri 就是系统保存媒体的数据库.
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DURATION,MediaStore.Audio.Media.DATA}, null, null, null);
        while (cursor.moveToNext()) {
            cursor.getString(0);
        }
    }
}
