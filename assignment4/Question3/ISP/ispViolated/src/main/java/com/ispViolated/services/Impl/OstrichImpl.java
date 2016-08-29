package com.ispViolated.services.Impl;

import com.ispViolated.domain.Ostrich;
import com.ispViolated.services.IOstrich;

/**
 * Created by student on 2016/03/27.
 */
public class OstrichImpl implements IOstrich {
    public Ostrich getOstrich() {
        return new Ostrich();
    }
}

