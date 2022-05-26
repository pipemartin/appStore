
package service;
import java.util.List;
import models.Venta;
public interface VentaService {
    public List<Venta> findAllVenta();
    public List<Venta> findAllVenta(String filter);
    public List<Venta> findIdVenta(Integer filter);
    public Venta findVentabyId(Venta venta); 
    public void insertVenta(Venta venta);
    public void deleteVenta(Venta venta);
    public void updateVenta(Venta venta);
}
