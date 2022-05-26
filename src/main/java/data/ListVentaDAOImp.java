package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Customer;
import models.ListVenta;

@Stateless //Indica que esta clase no permite crear objetos
public class ListVentaDAOImp implements ListVentaDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<ListVenta> findAllListVentas() {
        return em.createNamedQuery("ListVenta.findAll").getResultList();
    }
    
    @Override
    public List<ListVenta> findAllListVenta(Integer filter) {
        Query query;
        query = em.createQuery("SELECT c FROM detalleventa c WHERE c.IdentificacionVenta IN (:filter)");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }
    @Override
    public void insertListVenta(ListVenta listventa) {
        try {
            em.persist(listventa);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        
    }

    @Override
    public void deleteListVenta(ListVenta listventa) {
        em.remove(em.merge(listventa));
    }
}
