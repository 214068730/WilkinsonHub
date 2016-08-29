package com.violatedIsp.service.Impl;

import com.violatedIsp.domain.Ostrich;
import com.violatedIsp.service.IOstrich;

/**
 * Created by student on 2016/03/24.
 */
public class OstrichImpl implements IOstrich {
    public Ostrich getOstrich() {
        return new Ostrich();
    }
}
