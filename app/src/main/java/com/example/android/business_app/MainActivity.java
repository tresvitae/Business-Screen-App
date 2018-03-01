package com.example.android.business_app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    Opens e-mail app and gives possibility to send massage.
    */
    public void emailToUs(View view) {
        Intent emailToUs = new Intent(Intent.ACTION_SENDTO);
        emailToUs.setData(Uri.parse("mailto:"));
        emailToUs.putExtra(Intent.EXTRA_EMAIL, "rybka@gmail.com");
        emailToUs.putExtra(Intent.EXTRA_SUBJECT, "Hello Rybka shop!");
        if (emailToUs.resolveActivity(getPackageManager()) != null) {
            startActivity(emailToUs);
        }
    }

    /*
    Opens map app and shows location of the Rybka shop.
     */
    public void showMap(View view) {
        Intent showMap = new Intent(Intent.ACTION_VIEW);
        showMap.setData(Uri.parse("geo:51.2682955, 22.568257"));
        if (showMap.resolveActivity(getPackageManager()) != null) {
            startActivity(showMap);
        }
    }

    /*
    If available, opens Facebok app, if not, shows facebook's page of Rybka on browser...
     */
    public void goFacebook(View view) {
        try {
            Intent facebook = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1870310679924174"));
            startActivity(facebook);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RYBKA-Lubelskie-Centrum-W%C4%99dkarskie-1870310679924174/")));
        }
    }

    /*
    If available, opens Twitter app, if not, shows twitter's page with some profile...
    */
    public void goTwitter(View view) {
        try {
            // get the Twitter app if possible
            MainActivity.this.getPackageManager().getPackageInfo("com.twitter.android", 0);
            Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=908018289674260480"));
            twitter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
            // no Twitter app, revert to browser
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Patryk_Futa")));
        }
    }

    /*
    If available, opens Youtube app, if not, shows youtube's page with some profile...
    */
    public void goYouTube(View view) {
        try {
            Intent goYouTube = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube.be/leszczeu"));
            startActivity(goYouTube);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/leszczeu")));
        }
    }
}