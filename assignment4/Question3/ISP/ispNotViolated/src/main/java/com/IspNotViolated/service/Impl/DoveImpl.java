package com.IspNotViolated.service.Impl;

import com.IspNotViolated.domain.Dove;
import com.IspNotViolated.service.IDove;

/**
 * Created by student on 2016/03/24.
 */
public class DoveImpl implements IDove {
    public Dove getDove() {
        return new Dove();
    }
}
