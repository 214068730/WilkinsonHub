package com.srpViolated.service.Impl;

import com.srpViolated.domain.Rectangle;
import com.srpViolated.service.IRectangle;

/**
 * Created by student on 2016/03/23.
 */
public class RectangleImpl implements IRectangle {
    public Rectangle getRectangle() {
        return new Rectangle(7,5);
    }
}
