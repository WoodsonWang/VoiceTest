package com.example.woodson.voicetest;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button ringsubtract;
    private Button ringadd;
    private Button voiceadd;
    private Button voicesubtract;
    private Button systemadd;
    private Button systemsubtract;
    private TextView system;
    private Button musicadd;
    private Button musicsubtract;
    private TextView music;
    private Button alarmadd;
    private Button alarmsubtract;
    private TextView alarm;
    private Button notificationadd;
    private Button notificationsubtract;
    private TextView notification;
    private AudioManager audio;
    private TextView ring;
    private TextView voicecall;
    private Button initialize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audio = (AudioManager) getSystemService(AUDIO_SERVICE);
        initView();

    }


    private void initView() {
        ringsubtract = (Button) findViewById(R.id.ringsubtract);
        ringadd = (Button) findViewById(R.id.ringadd);
        voiceadd = (Button) findViewById(R.id.voiceadd);
        voicesubtract = (Button) findViewById(R.id.voicesubtract);
        systemadd = (Button) findViewById(R.id.systemadd);
        systemsubtract = (Button) findViewById(R.id.systemsubtract);
        system = (TextView) findViewById(R.id.system);
        musicadd = (Button) findViewById(R.id.musicadd);
        musicsubtract = (Button) findViewById(R.id.musicsubtract);
        music = (TextView) findViewById(R.id.music);
        alarmadd = (Button) findViewById(R.id.alarmadd);
        alarmsubtract = (Button) findViewById(R.id.alarmsubtract);
        alarm = (TextView) findViewById(R.id.alarm);
        notificationadd = (Button) findViewById(R.id.notificationadd);
        notificationsubtract = (Button) findViewById(R.id.notificationsubtract);
        notification = (TextView) findViewById(R.id.notification);

        ringsubtract.setOnClickListener(this);
        ringadd.setOnClickListener(this);
        voiceadd.setOnClickListener(this);
        voicesubtract.setOnClickListener(this);
        systemadd.setOnClickListener(this);
        systemsubtract.setOnClickListener(this);
        musicadd.setOnClickListener(this);
        musicsubtract.setOnClickListener(this);
        alarmadd.setOnClickListener(this);
        alarmsubtract.setOnClickListener(this);
        notificationadd.setOnClickListener(this);
        notificationsubtract.setOnClickListener(this);
        ring = (TextView) findViewById(R.id.ring);
        voicecall = (TextView) findViewById(R.id.voicecall);
        initialize = (Button) findViewById(R.id.initialize);
        initialize.setOnClickListener(this);
        initText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ringsubtract:
                ring.setText(lowerAndgetVoice(AudioManager.STREAM_RING));
                break;
            case R.id.ringadd:
                ring.setText(raiseAndgetVoice(AudioManager.STREAM_RING));
                break;
            case R.id.voiceadd:
                voicecall.setText(raiseAndgetVoice(AudioManager.STREAM_VOICE_CALL));
                break;
            case R.id.voicesubtract:
                voicecall.setText(lowerAndgetVoice(AudioManager.STREAM_VOICE_CALL));
                break;
            case R.id.systemadd:
                system.setText(raiseAndgetVoice(AudioManager.STREAM_SYSTEM));
                break;
            case R.id.systemsubtract:
                system.setText(lowerAndgetVoice(AudioManager.STREAM_SYSTEM));
                break;
            case R.id.musicadd:
                music.setText(raiseAndgetVoice(AudioManager.STREAM_MUSIC));
                break;
            case R.id.musicsubtract:
                music.setText(lowerAndgetVoice(AudioManager.STREAM_MUSIC));
                break;
            case R.id.alarmadd:
                alarm.setText(raiseAndgetVoice(AudioManager.STREAM_ALARM));
                break;
            case R.id.alarmsubtract:
                alarm.setText(lowerAndgetVoice(AudioManager.STREAM_ALARM));
                break;
            case R.id.notificationadd:
                notification.setText(raiseAndgetVoice(AudioManager.STREAM_NOTIFICATION));
                break;
            case R.id.notificationsubtract:
                notification.setText(lowerAndgetVoice(AudioManager.STREAM_NOTIFICATION));
                break;
            case R.id.initialize:
                initText();
                break;
        }
    }

    public String lowerAndgetVoice(int type) {
        audio.adjustStreamVolume(type, AudioManager.ADJUST_LOWER, 0);
        return audio.getStreamVolume(type) + "";
    }

    public String raiseAndgetVoice(int type) {
        audio.adjustStreamVolume(type, AudioManager.ADJUST_RAISE, 0);
        return audio.getStreamVolume(type) + "";
    }
    public void initText(){
        ring.setText(audio.getStreamVolume(AudioManager.STREAM_RING) + "");
        voicecall.setText(audio.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + "");
        system.setText(audio.getStreamVolume(AudioManager.STREAM_SYSTEM) + "");
        music.setText(audio.getStreamVolume(AudioManager.STREAM_MUSIC) + "");
        alarm.setText(audio.getStreamVolume(AudioManager.STREAM_ALARM) + "");
        notification.setText(audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION) + "");
    }

}
