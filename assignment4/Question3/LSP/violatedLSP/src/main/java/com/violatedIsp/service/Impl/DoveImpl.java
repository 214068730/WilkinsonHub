package com.violatedIsp.service.Impl;

import com.violatedIsp.domain.Dove;
import com.violatedIsp.service.IDove;

/**
 * Created by student on 2016/03/24.
 */
public class DoveImpl implements IDove {
    public Dove getDove() {
        return new Dove();
    }
}
