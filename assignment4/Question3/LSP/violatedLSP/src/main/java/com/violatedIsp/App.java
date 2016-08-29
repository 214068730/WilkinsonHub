package com.violatedIsp;

import com.violatedIsp.domain.Dove;
import com.violatedIsp.domain.Ostrich;
import com.violatedIsp.service.Impl.DoveImpl;
import com.violatedIsp.service.Impl.OstrichImpl;

/**
 *violated ISP
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
