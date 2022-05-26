
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import models.ListVenta;
import models.Product;
import models.Venta;
import service.CustomerService;
import service.ListVentaService;
import service.ProductService;
import service.VentaService;


@WebServlet(name = "ListVentaServlet", urlPatterns = {"/throwVenta","/addVenta","/deleteVenta"})
public class ListVentaServlet extends HttpServlet {

    @Inject
    ListVentaService lventService;
    
    @Inject
    CustomerService catService;
    
    @Inject
    ProductService cService;
    
    @Inject
    VentaService ventService;
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);
        String action = request.getParameter("action");
        
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        System.out.println("Action CS ListVenta Servlet:" + action);
        switch (action) {
            case "listventa":
                listAllVentas(request, response);
                break;
            case "/throwVenta":
                throwVenta(request, response);
                break;
            case "/addVenta":
                insertVenta(request, response);
                break;
            case "/deleteVenta":
                deleteVenta(request, response);
                listAllVentas(request, response);
                break;
        }
        listAllVentas(request, response);
        return;
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        System.out.println("Action GET ListVenta Servlet:" + action);
        switch (action) {
            case "listventa":
                listAllVentas(request, response);
                
                break;
            case "/throwVenta":
                throwVenta(request, response);
                break;
            
        }
        listAllVentas(request, response);
        return;
    }

    protected void listAllVentas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ListVenta> c = lventService.findAllListVentas();
        System.out.println(c.get(0).getVentaId().getClass());
        System.out.println(c.get(0).getIdentificacionVenta());
        request.setAttribute("listventa", c);
        request.getRequestDispatcher("/listVenta.jsp").forward(request, response);
        return;
    }
    
    protected void throwVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> c = catService.findAllCustomer();
        request.setAttribute("customers", c);
        List<Product> cus = cService.findAllProduct();
        request.setAttribute("products", cus);
        request.getRequestDispatcher("/venta.jsp").forward(request, response);
        return;
    }
    
    protected void insertVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venta v = new Venta();
        v.setIdentificacionVenta(Integer.parseInt(request.getParameter("identificacion")));
        //------------------------------------------------------------
        Customer custom = new Customer();
        //custom.setCustomerName(request.getParameter("productName"));
        List<Customer> cos = catService.findByCustomerName(request.getParameter("productName"));
        custom.setCustomerID(cos.get(0).getCustomerID());
        System.out.println(cos.get(0).getCustomerID());
        System.out.println(cos.get(0).getCustomerName());
        v.setCustomerId(custom);
        
        //-----------------------------------------------------------
        Product p = new Product();
        //p.setProductName(request.getParameter("productId"));
        List<Product> cus = cService.findByProductName(request.getParameter("productId"));
        p.setProductId(cus.get(0).getProductId());
        System.out.println(cus.get(0).getProductId());
        System.out.println(cus.get(0).getProductName());
        v.setProductId(p);
        //------------------------------------------------------------
        v.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        //----------------------------------------------------------------
        v.setPrecioUnid(Integer.parseInt(request.getParameter("PrecioUnidad")));
        //--------------------------------------------------------------------------
        ventService.insertVenta(v);
        //--------------------------------------------------------------------------
        ListVenta lisven = new ListVenta();
        lisven.setVentaId(4);
        lisven.setIdentificacionVenta(v);
        lventService.insertListVenta(lisven);
        //---------------------------------------------------------------------------
        request.setAttribute("message","venta successfully Create!");
        
        List<ListVenta> c = lventService.findAllListVentas();
        request.setAttribute("listventa", c);
        request.getRequestDispatcher("/listVenta.jsp").forward(request, response);
        return;
        
    }
    protected void deleteVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venta v = new Venta();
        String identificacionVenta = request.getParameter("productId");
        System.out.println(identificacionVenta);
        v.setIdentificacionVenta(Integer.parseInt(identificacionVenta));
        v = ventService.findVentabyId(v);
        if (v != null) {
            ventService.deleteVenta(v);
            request.setAttribute("message", "Venta successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Customer!");
        }
    }
}

