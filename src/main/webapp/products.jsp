<%@page import="java.util.List"%>
<%@page import="models.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
        <title>Products</title>
    </head>
    <div class="container">
            <h1>Products</h1>
            <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Well done!</strong> ${message} <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </c:if>
            <form method="GET" action="ProductServlet">
                <div class="form-group">
                    <div class="input-group mb-1">
                        <input type="text" name="filter" id="filter" class="form-control" placeholder="Buscar" aria-label="Nombre del cliente" aria-describedby="button-addon2">
                        <button class="btn-info" type="submit" id="button-addon2">Search</button>
                    </div>
                </div>
            </form>
            <div class="form-group m-0">
                <table class="table table-hover border table-striped">
                    <thead>
                    <form method="POST" action="addProduct"> 
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Category Name</th>
                        </tr>
                        <tr>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Id" id="productID" name="productID">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Name" id="productName" name="productName">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input name="category" id="category" type="text" placeholder="Category">
                                </div></th>
                            <th scope="col"><div class="input-group mb-1">
                                    <button class="btn btn-primary" type="submit" id="button-addon2" id="add" name="add">Add</button>
                                </div></th>
                        </tr>
                    </form>
                    </thead>
                    <tbody>
                       
                        <c:forEach items="${products}" var="product">
                            <tr class="table-active">
                                <td>${product.productId}</td>
                                <td>${product.productName}</td>
                                <td>${product.categoryId.categoryName}></td>  
                                
                                <td><div class="btn-group" role="group" aria-label="Basic example">
                                        <form method="POST" action="throwUpdateProduct?filter=${product.productId}">  
                                            <button type="submit" class="btn btn-primary" id="btn-abrir-popup">Update</button>  
                                        </form>  
                                        <form method="POST" action="deleteProduct?productId=${product.productId}">
                                            <button type="submit" class="btn btn-primary" id="borrar" name="borrar" class="jsBtn_2">Delete</button>
                                        </form>

                                    </div></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
