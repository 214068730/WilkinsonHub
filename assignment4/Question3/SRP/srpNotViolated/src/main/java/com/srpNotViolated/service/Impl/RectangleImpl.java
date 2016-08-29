package com.srpNotViolated.service.Impl;

import com.srpNotViolated.domain.Rectangle;
import com.srpNotViolated.service.IRectangle;

/**
 * Created by student on 2016/03/23.
 */
public class RectangleImpl implements IRectangle {
    public Rectangle getRectangle() {
        return new Rectangle(8,5);
    }
}
