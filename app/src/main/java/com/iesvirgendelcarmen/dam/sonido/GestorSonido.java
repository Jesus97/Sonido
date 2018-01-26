package com.iesvirgendelcarmen.dam.sonido;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class GestorSonido {

    private float rate = (float) 1.0;
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
        sndPool.play(sound_id, 1, 1, 1, 0, rate);
    }

    public void ajustaFrecuencia(float speed) {
        if(rate < 0.01f) rate = 0.01f;
        if(rate > 2.0f) rate = 2.0f;
    }

    public void ajustaBalance(float balance) { }

    public void ajustaVolumen(float volumen) { }

    public void unloadAll() { sndPool.release();}
}
