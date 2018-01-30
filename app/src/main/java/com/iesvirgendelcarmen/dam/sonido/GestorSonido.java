package com.iesvirgendelcarmen.dam.sonido;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;

public class GestorSonido extends AppCompatActivity{

    private float frecuencia = (float) 1.0;
    private float balance = (float) 0.5;
    private float volumen = (float) 0.5;
    private float derecho = (float) 1.0;
    private float izquierdo = (float) 1.0;

    SoundPool sndPool;
    Context pContext;

    public GestorSonido(Context appContext) {

    sndPool = new SoundPool(16,AudioManager.STREAM_MUSIC, 100);
    pContext = appContext;}

    public int carga(int sound_id) {
        return sndPool.load(pContext, sound_id, 1);
    }

    public void suena(int sound_id) {
        sndPool.play(sound_id, 1, 1, 1, 0, frecuencia);
    }

    public void ajustaFrecuencia(float varFrecuencia) {
        if(varFrecuencia < 0.01f) frecuencia = 0.01f;
        if(varFrecuencia > 2.0f) frecuencia = 2.0f;
    }

    public void ajustaBalance(float varBalance) {
        this.balance = varBalance;
        ajustaVolumen(volumen);
    }

    public void ajustaVolumen(float varVolumen) {
        this.volumen = varVolumen;
        if (balance < 1.0f) {
            izquierdo = varVolumen;
            derecho = varVolumen*balance;
        } else {
            derecho = varVolumen;
            izquierdo = varVolumen*(2.0f - balance);
        }
    }

    public void unloadAll() { sndPool.release();}
}
