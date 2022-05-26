
package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Venta;

@Stateless //Indica que esta clase no permite crear objetos
public class VentaDAOImp implements VentaDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<Venta> findAllVenta() {
        return em.createNamedQuery("Venta.findAll").getResultList();
    }
    
    
    @Override
    public List<Venta> findAllVenta(String filter) {
        Query query;
        query = em.createQuery("SELECT c FROM detalleventa c WHERE c.IdentificacionVenta = :filter");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }
    
    @Override
    public List<Venta> findIdVenta(Integer filter) {
        Query query;
        query = em.createQuery("SELECT p FROM detalleventa p WHERE p.IdentificacionVenta = :filter");
        query.setParameter("filter", filter);
        return  query.getResultList();
    }

    @Override
    public Venta findVentabyId(Venta venta) {
        return em.find(Venta.class, venta.getIdentificacionVenta());
    }


    @Override
    public void insertVenta(Venta venta) {
        try {
            em.persist(venta);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        
    }

    @Override
    public void deleteVenta(Venta venta) {
        em.remove(em.merge(venta));
    }

    @Override
    public void updateVenta(Venta venta) {
        em.merge(venta);        
    }

    
}

