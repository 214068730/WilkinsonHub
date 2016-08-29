package com.ispViolated;

import com.ispViolated.domain.Dove;
import com.ispViolated.domain.Ostrich;
import com.ispViolated.services.Impl.DoveImpl;
import com.ispViolated.services.Impl.OstrichImpl;

/**
 * isp violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Dove dove = new DoveImpl().getDove();
        Ostrich ostrich = new OstrichImpl().getOstrich();

        dove.fly();
        dove.eat();

        dove.sleep();

        ostrich.fly();
        ostrich.eat();
        ostrich.sleep();
    }
}
