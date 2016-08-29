package com.plkNotViolated.domain;

import com.plkNotViolated.domain.Drummer;
import com.plkNotViolated.domain.Singer;

/**
 * Created by student on 2016/03/27.
 */
public class Band
{
    private Singer singer;
    private Drummer drummer;
    private String bandName;

    public Band(Singer singer, Drummer drummer, String bandName) {
        this.singer = singer;
        this.drummer = drummer;
        this.bandName = bandName;
    }

    public String getsMember(){
        return(singer.getName()+"\n"+drummer.getName());
    }


    public String getBandSinger(){
        return singer.getName();
    }


    public String getBandDrummer(){
        return drummer.getName();
    }

    public String getBandName(){
        return bandName;
    }
}
