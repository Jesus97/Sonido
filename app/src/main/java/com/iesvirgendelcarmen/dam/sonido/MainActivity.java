package com.iesvirgendelcarmen.dam.sonido;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    GestorSonido snd;

    SeekBar volumen;
    SeekBar balance;
    SeekBar frecuencia;

    int laser;
    int gato;
    int disparo;
    int explosion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volumen = (SeekBar) findViewById(R.id.barraVolumen);
        balance = (SeekBar) findViewById(R.id.barraBalance);
        frecuencia = (SeekBar) findViewById(R.id.barraFrecuencia);

        snd = new GestorSonido(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //CONFIGURACION SEEKBAR
        SeekBar.OnSeekBarChangeListener barChange;

        barChange = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean b) {
                switch (seekBar.getId()) {
                    case R.id.barraVolumen:snd.ajustaVolumen((float) progreso / 100.f);
                        break;
                    case R.id.barraBalance:snd.ajustaBalance((float) progreso /100.f);
                        break;
                    case R.id.barraFrecuencia:snd.ajustaFrecuencia((float) progreso / 100.0f);
                        break;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        SeekBar sbVolumen = (SeekBar) findViewById(R.id.barraVolumen);
        sbVolumen.setOnSeekBarChangeListener(barChange);

        SeekBar sbFrecuencia = (SeekBar) findViewById(R.id.barraFrecuencia);
        sbFrecuencia.setOnSeekBarChangeListener(barChange);

        SeekBar sbBalance = (SeekBar) findViewById(R.id.barraBalance);
        sbBalance.setOnSeekBarChangeListener(barChange);

        laser = snd.carga(R.raw.laser);
        gato = snd.carga(R.raw.gato);
        explosion = snd.carga(R.raw.explosion);
        disparo = snd.carga(R.raw.disparo);

    }

    public void pulsado(View view){
        int id = view.getId();

        switch (id) {
            case R.id.botonBomba:snd.suena(explosion);
                break;
            case R.id.botonDisparo:snd.suena(disparo);
                break;
            case R.id.botonMaullido:snd.suena(gato);
                break;
            case R.id.botonLaser:snd.suena(laser);
           break;}
    }
}
