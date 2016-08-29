package com.plkNotViolated.service.Impl;

import com.plkNotViolated.domain.Singer;
import com.plkNotViolated.service.ISinger;

/**
 * Created by student on 2016/03/27.
 */
public class SingerImpl implements ISinger {
    public Singer getSinger() {
        Singer singer = new Singer();
        singer.setName("Kashiefa");
        singer.setAge(21);
        return singer;
    }
}
