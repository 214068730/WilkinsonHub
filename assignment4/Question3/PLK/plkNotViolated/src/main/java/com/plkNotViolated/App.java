package com.plkNotViolated;

import com.plkNotViolated.domain.Band;
import com.plkNotViolated.domain.Drummer;
import com.plkNotViolated.domain.Singer;
import com.plkNotViolated.service.Impl.DrummerImpl;
import com.plkNotViolated.service.Impl.SingerImpl;

/**
 * PLK not being violated
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
