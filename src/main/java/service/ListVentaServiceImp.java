package service;


import data.ListVentaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.Customer;
import models.ListVenta;


@Stateless
public class ListVentaServiceImp implements ListVentaService{
    
    @Inject
    private ListVentaDAO pDAO;

    @Override
    public List<ListVenta> findAllListVentas() {
        return pDAO.findAllListVentas();
    }
    
    @Override
    public List<ListVenta> findAllListVenta(Integer filter) {
        return pDAO.findAllListVenta(filter);
    }
    @Override
    public void insertListVenta(ListVenta listventa) {
        pDAO.insertListVenta(listventa);
    }

    @Override
    public void deleteListVenta(ListVenta listventa) {
        pDAO.deleteListVenta(listventa);
    }
}

