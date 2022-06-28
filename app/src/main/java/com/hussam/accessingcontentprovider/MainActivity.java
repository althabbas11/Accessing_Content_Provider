package com.hussam.accessingcontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Uri CONTENT_URI =
            Uri.parse("content://com.demo.user.provider/users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDetails(View view) {
// يصنلا لقحلا اذه يف ةلماك لودجلا ليصافت جاردإ
        TextView resultView = (TextView)
                findViewById(R.id.res);
// ىوتحم URIل رشؤم نئاك ءاشنإ
        Cursor cursor =
                getContentResolver().query(Uri.parse("content://com.demo.user.provider/users"), null, null, null, null);
// لماكلاب لودجلا ةعابطل رشؤملا راركت
        if (cursor.moveToFirst()) {
            StringBuilder strBuild = new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n" + cursor.getString(0) + "-" +
                        cursor.getString(1));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        } else {
            resultView.setText("No Records Found");
        }
    }

}