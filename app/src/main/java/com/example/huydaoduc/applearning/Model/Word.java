package com.example.huydaoduc.applearning.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by HuyDaoDuc on 03/03/2018.
 */

public class Word implements Serializable, Cloneable {
    private int Id;
    private String Ten;
    private String Mota;
    private String TheLoai;
    private byte[] Image;
    private byte[] Sound;

    public static MediaPlayer mediaPlayer = new MediaPlayer();            // dùng để phát âm thanh

    public Word(){

    }

    // clone
    public Word(Word word){
        Id = word.getId();
        Ten = word.getTen();
        Mota = word.getMota();
        Image = word.getImage();
        Sound = word.getSound();
    }

    public Word(String ten, String mota){
        Ten = ten;
        Mota = mota;
    }

    public Word(int id, String ten, String mota, String theLoai, byte[] image, byte[] sound) {
        Id = id;
        Ten = ten;
        Mota = mota;
        TheLoai = theLoai;
        Image = image;
        Sound = sound;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public byte[] getSound() {
        return Sound;
    }

    public void setSound(byte[] sound) {
        Sound = sound;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        Word.mediaPlayer = mediaPlayer;
    }
}
