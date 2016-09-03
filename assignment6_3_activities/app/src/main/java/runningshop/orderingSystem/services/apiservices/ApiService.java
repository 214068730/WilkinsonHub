package runningshop.orderingSystem.services.apiservices;

import java.util.List;

/**
 * Created by Siraaj on 09/02/2016.
 */

public interface ApiService<S,ID>
{
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
