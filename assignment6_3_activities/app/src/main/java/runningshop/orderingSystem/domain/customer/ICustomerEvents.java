package runningshop.orderingSystem.domain.customer;

/**
 * Created by Siraaj on 04/17/2016.
 */
public interface ICustomerEvents {
    public void customerAccountCreated();
    public void viewCustomerAccount(Long customerCode);

}
