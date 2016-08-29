package com.plkViolated.domain;

import com.plkViolated.domain.Drummer;
import com.plkViolated.domain.Singer;
import com.plkViolated.services.IDrummer;
import com.plkViolated.services.ISinger;

/**
 * Created by student on 2016/03/26.
 */
public class Band {
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

    public Singer getSinger(){
        return singer;
    }

    public String getBandSinger(){
        return getSinger().getName();
    }

    public Drummer getDrummer(){
        return drummer;
    }

    public String getBandDrummer(){
        return getDrummer().getName();
    }

    public String getBandName(){
        return bandName;
    }
}
