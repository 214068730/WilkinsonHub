package runningshop.orderingSystem.services.apiservices.Impl;

import java.util.List;

import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.repository.RestApi;
import runningshop.orderingSystem.repository.rest.RestCustomerApi;
import runningshop.orderingSystem.services.apiservices.ApiCustomerService;

/**
 * Created by Siraaj on 09/02/2016.
 */

public class ApiCustomerServiceImpl implements ApiCustomerService {

    final RestApi<Customer,Long> rest = new RestCustomerApi();

    @Override
    public Customer findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Customer entity) {
        return rest.post(entity);
    }

    @Override
    public String update(Customer entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Customer entity) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
