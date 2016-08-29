package com.IspNotViolated.service.Impl;

import com.IspNotViolated.domain.Ostrich;
import com.IspNotViolated.service.IOstrich;

/**
 * Created by student on 2016/03/24.
 */
public class OstrichImpl implements IOstrich {
    public Ostrich getOstrich() {
        return new Ostrich();
    }
}
