
package service;

import java.util.List;
import models.ListVenta;
public interface ListVentaService {
    public List<ListVenta> findAllListVentas();
    public List<ListVenta> findAllListVenta(Integer filter);
    public void insertListVenta(ListVenta listventa);
    public void deleteListVenta(ListVenta listventa);
}
