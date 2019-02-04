package haitham.kinneret.fastgoodfood.Activities;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import haitham.kinneret.fastgoodfood.R;

/**
 * Created by Haitham + Fares on 1/13/2018.
 */

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String versionName = "";
        try {
            PackageInfo pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = pinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();
        }

        TextView aboutTextView = (TextView) findViewById(R.id.about_text_view);

        Spanned aboutText = Html.fromHtml("<h1>FastGood, " + versionName + "</h1>"
                + getString(R.string.about_text));
        aboutTextView.setText(aboutText);
    }
}