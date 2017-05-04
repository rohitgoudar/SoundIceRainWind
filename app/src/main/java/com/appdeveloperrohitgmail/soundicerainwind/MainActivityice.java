package com.appdeveloperrohitgmail.soundicerainwind;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivityice extends AppCompatActivity {
    MediaPlayer a,b,c,d,e,f;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainice);
        a = MediaPlayer.create(this, R.raw.breaking_ice);
        b = MediaPlayer.create(this, R.raw.breaking_ice_02);
        c = MediaPlayer.create(this, R.raw.ice_block_drop);
        d = MediaPlayer.create(this, R.raw.ice_collecting);
        e = MediaPlayer.create(this, R.raw.ice_cracking);
        f = MediaPlayer.create(this, R.raw.rain_heavy);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }
    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }
    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public void play1(View view) {
        if (a.isPlaying()) {
            a.pause();
        } else {
            a.start();
        }
    }

    public void play2(View view) {

        if (f.isPlaying()) {
            f.pause();
        } else {
            f.start();
        }
    }

    public void play3(View view) {

        if (e.isPlaying()) {
            e.pause();
        } else {
            e.start();
        }
    }

    public void play4(View view) {
        if (d.isPlaying()) {
            d.pause();
        } else {
            d.start();
        }
    }

    public void play5(View view) {
        if (c.isPlaying()) {
            c.pause();
        } else {
            c.start();
        }
    }

    public void play6(View view) {
        if (b.isPlaying()) {
            b.pause();
        } else {
            b.start();
        }
    }

    public void mainpage(View view) {
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(MainActivityice.this, MainActivity1.class));
                finish();
            }
        }, secondsDelayed * 3);
        stopPlaying();
    }

    private void stopPlaying() {
        if (a != null) {
            a.stop();
            a.release();
            a = null;
        }
        if (b != null) {
            b.stop();
            b.release();
            b = null;
        }
        if (c != null) {
            c.stop();
            c.release();
            c = null;
        }
        if (d != null) {
            d.stop();
            d.release();
            d = null;
        }
        if (e != null) {
            e.stop();
            e.release();
            e = null;
        }
        if (f != null) {
            f.stop();
            f.release();
            f = null;
        }
    }
}
