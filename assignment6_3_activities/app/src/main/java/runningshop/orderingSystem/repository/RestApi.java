package runningshop.orderingSystem.repository;

import java.util.List;

import runningshop.orderingSystem.domain.customer.Customer;

/**
 * Created by Siraaj on 09/02/2016.
 */

public interface RestApi<S,ID> {
    S get(ID id);

    void post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
