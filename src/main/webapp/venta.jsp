<%@page import="java.util.List"%>
<%@page import="models.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hacer Una Venta!</h1>
        <form method="POST" action="addVenta"> 
                <th scope="col"><div class="form-group">
                        <label for="Name">Identificacion de Venta: </label>
                        <input class="form-control form-control-sm" type="text" placeholder="Id" id="identificacion" name="identificacion">
                    </div></th>
                <th scope="col"><div class="form-group">
                        <label for="Name">Customer ID:</label>
                        <input class="form-control form-control-sm" list="customers" type="text" placeholder="Customers" id="productName" name="productName">
                        <datalist id="customers">
                            <c:forEach items="${customers}" var="customer">
                                <option value="${customer.customerName}">
                            </c:forEach>
                        </datalist>
                    </div></th>
                <th scope="col"><div class="form-group">
                        <label for="Name">Producto ID:</label>
                        <input class="form-control form-control-sm" list="products" type="text" placeholder="Address" id="productId" name="productId">
                        <datalist id="products">
                            <c:forEach items="${products}" var="product">
                                <option value="${product.productName}">
                            </c:forEach>
                        </datalist>
                    </div></th>
                <th scope="col"><div class="form-group">
                        <label for="Name">Cantidad: </label>
                        <input class="form-control form-control-sm" type="text" placeholder="Address" id="cantidad" name="cantidad">
                    </div></th>
                <th scope="col"><div class="form-group">
                        <label for="Name">precioUnid: </label>
                        <input class="form-control form-control-sm" type="text" placeholder="Address" id="PrecioUnidad" name="PrecioUnidad">
                    </div></th>
                <th scope="col"><div class="input-group mb-1">
                        <button class="btn btn-primary" type="submit" id="button-addon2" id="update" name="update">Hacer Compra</button>
                    </div></th>
            </tr>
        </form>           
    </body>
</html>
