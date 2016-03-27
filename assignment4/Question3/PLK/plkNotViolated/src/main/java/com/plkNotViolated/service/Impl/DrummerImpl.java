package com.plkNotViolated.service.Impl;

import com.plkNotViolated.domain.Drummer;
import com.plkNotViolated.service.IDrummer;

/**
 * Created by student on 2016/03/27.
 */
public class DrummerImpl implements IDrummer {
    public Drummer getDrummer() {
        Drummer drummer = new Drummer();
        drummer.setDrummer("Siraaj");
        drummer.setAge(21);
        return drummer;
    }
}
