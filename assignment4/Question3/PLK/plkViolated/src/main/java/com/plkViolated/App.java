package com.plkViolated;

import com.plkViolated.domain.Band;
import com.plkViolated.domain.Drummer;
import com.plkViolated.domain.Singer;
import com.plkViolated.services.Impl.DrummerImpl;
import com.plkViolated.services.Impl.SingerImpl;

/**
 * PLK violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Singer singer = new SingerImpl().getSinger();
        Drummer drummer = new DrummerImpl().getDrummer();
        Band band = new Band(singer,drummer,"siKash");
        System.out.println("Band name: "+band.getBandName());
        System.out.println("Members:\n\t"+band.getBandSinger()+"\n\t"+band.getBandDrummer());


    }
}
