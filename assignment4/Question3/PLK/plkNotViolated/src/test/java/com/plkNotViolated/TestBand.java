package com.plkNotViolated;

import com.plkNotViolated.domain.Band;
import com.plkNotViolated.domain.Drummer;
import com.plkNotViolated.domain.Singer;
import com.plkNotViolated.service.IDrummer;
import com.plkNotViolated.service.ISinger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/03/27.
 */
public class TestBand {

    private ISinger singer;
    private IDrummer drummer;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singer = (ISinger)ctx.getBean("singer");
        drummer =(IDrummer)ctx.getBean("drummer");
    }

    @Test
    public void testSinger() throws Exception {
        Singer bandSinger = singer.getSinger();
        Assert.assertEquals(bandSinger.getName(),"Kashiefa");
        Assert.assertEquals(bandSinger.getAge(),21);
    }

    @Test
    public void testDrummer() throws Exception {
        Drummer bandDrummer = drummer.getDrummer();
        Assert.assertEquals(bandDrummer.getName(),"Siraaj");
        Assert.assertEquals(bandDrummer.getAge(),21);
    }

    @Test
    public void testBand() throws Exception {
        Singer bandSinger = singer.getSinger();
        Drummer bandDrummer = drummer.getDrummer();
        Band band = new Band(bandSinger,bandDrummer,"SiKash");
        Assert.assertEquals(band.getBandName(),"SiKash");
        Assert.assertEquals(band.getBandSinger(),"Kashiefa");
        Assert.assertEquals(band.getBandDrummer(),"Siraaj");


    }
}
