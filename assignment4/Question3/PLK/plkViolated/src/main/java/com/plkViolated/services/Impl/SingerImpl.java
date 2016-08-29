package com.plkViolated.services.Impl;

import com.plkViolated.domain.Singer;
import com.plkViolated.services.ISinger;

/**
 * Created by student on 2016/03/26.
 */
public class SingerImpl implements ISinger {
    public Singer getSinger() {
        Singer singer = new Singer();
        singer.setName("Kashiefa");
        singer.setAge(21);
        return singer;
    }
}
