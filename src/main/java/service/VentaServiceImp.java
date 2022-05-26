import data.VentaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import models.Venta;
import service.VentaService;

@Stateless
public class VentaServiceImp implements VentaService{
    
    @Inject
    private VentaDAO pDAO;

    @Override
    public List<Venta> findAllVenta() {
        return pDAO.findAllVenta();
    }
    
    @Override
    public List<Venta> findAllVenta(String filter) {
        return pDAO.findAllVenta(filter);
    }
    
    @Override
    public List<Venta> findIdVenta(Integer filter) {
        return pDAO.findIdVenta(filter);
    }
   
    @Override
    public Venta findVentabyId(Venta venta) {
        return pDAO.findVentabyId(venta);
    }
    
    @Override
    public void insertVenta(Venta venta) {
        pDAO.insertVenta(venta);
    }

    @Override
    public void deleteVenta(Venta venta) {
        pDAO.deleteVenta(venta);
    }

    @Override
    public void updateVenta(Venta venta) {
        pDAO.updateVenta(venta);
    }
    
}
