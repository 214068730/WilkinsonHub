package com.ispViolated.services.Impl;

import com.ispViolated.domain.Dove;
import com.ispViolated.services.IDove;

/**
 * Created by student on 2016/03/27.
 */
public class DoveImpl implements IDove {
    public Dove getDove() {
        return new Dove();
    }
}
