package runningshop.assignment7.repository;

import android.database.Cursor;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Siraaj on 04/20/2016.
 */
public interface Repository<E,ID> {
    E findByid(ID id);
    E save(E entity);
    E update(E entity);
    E delete(E entity);
    Set<E> findAll() throws SQLException;
    int deleteAll();
    Cursor selectAll();
}
