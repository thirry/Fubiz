package com.ev.gone.fubiz.Models;

import java.io.Serializable;

/**
 * Created by gone on 3/11/18.
 */

public class Songs implements Serializable {

    public String name;
    public int idsongs;

    public Songs() {

    }

    public Songs(String name, int idsongs) {
        this.name = name;
        this.idsongs = idsongs;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getIdsongs() {
//        return idsongs;
//    }
//
//    public void setIdsongs(int idsongs) {
//        this.idsongs = idsongs;
//    }
}
