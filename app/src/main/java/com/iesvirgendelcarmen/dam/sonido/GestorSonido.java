package com.iesvirgendelcarmen.dam.sonido;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class GestorSonido {

    SoundPool sndPool;
    Context pContext;

    public GestorSonido(Context appContext) {

    sndPool = new SoundPool(16,AudioManager.STREAM_MUSIC, 100);
    pContext = appContext;}

    public int carga(int sound_id) {
        return sndPool.load(pContext, sound_id, 1);
    }

    public void suena(int sound_id) {
        sndPool.play(sound_id, 1, 1, 1, 0, 1);
    }


    public void unloadAll() { sndPool.release();}
}
