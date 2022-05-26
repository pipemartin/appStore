
package data;

import java.util.List;
import models.Customer;
import models.ListVenta;

public interface ListVentaDAO {
    public List<ListVenta> findAllListVentas();
    public List<ListVenta> findAllListVenta(Integer filter);
    public void insertListVenta(ListVenta listventa);
    public void deleteListVenta(ListVenta listventa);
}
