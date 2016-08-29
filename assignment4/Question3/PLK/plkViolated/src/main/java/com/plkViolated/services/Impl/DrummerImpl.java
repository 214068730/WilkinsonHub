package com.plkViolated.services.Impl;

import com.plkViolated.domain.Drummer;
import com.plkViolated.services.IDrummer;

/**
 * Created by student on 2016/03/26.
 */
public class DrummerImpl implements IDrummer {
    public Drummer getDrummer() {
        Drummer drummer = new Drummer();
        drummer.setDrummer("Siraaj");
        drummer.setAge(21);
        return drummer;
    }
}
