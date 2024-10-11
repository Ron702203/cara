<%-- 
    Document   : Search
    Created on : Apr 21, 2023, 7:26:13 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="apple-touch-icon" href="./assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="./assets/img/favicon.ico">

        <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/templatemo.css">
        <link rel="stylesheet" href="./assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="./assets/css/fontawesome.min.css">
    </head>
    <body>
        <%@include file="./inc/header.jsp" %>


        <div class="row">
            <c:forEach items="${productList}" var="product">
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="ProductDetailServlet?product_id=${product.id}">
                            <img src="${product.img}" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$240.00</li>
                            </ul>
                            <a href="ProductDetailServlet?product_id=${product.id}" class="h2 text-decoration-none text-dark">${product.name}</a>
                            <p class="card-text">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt in culpa qui officia deserunt.
                            </p>
                            <p class="text-muted">Reviews (24)</p>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</body>
</html>
