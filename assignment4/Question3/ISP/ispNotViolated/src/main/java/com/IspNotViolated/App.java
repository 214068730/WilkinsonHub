package com.IspNotViolated;

import com.IspNotViolated.domain.Dove;
import com.IspNotViolated.domain.Ostrich;
import com.IspNotViolated.service.Impl.DoveImpl;
import com.IspNotViolated.service.Impl.OstrichImpl;

/**
 * ISP not being violated
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Ostrich ostrich = new OstrichImpl().getOstrich();
        Dove dove = new DoveImpl().getDove();

        System.out.println("Dove");
        dove.fly();
        dove.eat();
        dove.sleep();

        System.out.println("\nOstrich");
        ostrich.eat();
        ostrich.sleep();


    }
}
