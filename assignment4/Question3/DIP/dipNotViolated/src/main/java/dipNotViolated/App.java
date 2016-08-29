package dipNotViolated;

import dipNotViolated.service.Impl.Honda;
import dipNotViolated.domain.Manufacture;
import dipNotViolated.service.Impl.Nissan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
            Manufacture manufacture = new Manufacture();


            manufacture.createCar(new Honda());
            manufacture.display();
            manufacture.createCar(new Nissan());
            manufacture.display();
    }
}
