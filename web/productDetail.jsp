<%-- 
    Document   : ProductDetail
    Created on : Apr 17, 2023, 8:32:38 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--===============================================================================================-->	

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
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" src="${product.img}" alt="Card image cap" id="product-detail">
                        </div>
                        <div class="row">
                            <!--Start Controls-->
                            <div class="col-1 align-self-center">
                                <a href="#multi-item-example" role="button" data-bs-slide="prev">
                                    <i class="text-dark fas fa-chevron-left"></i>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </div>
                            <!--End Controls-->
                            <!--Start Carousel Wrapper-->
                            <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item" data-bs-ride="carousel">
                                <!--Start Slides-->
                                <div class="carousel-inner product-links-wap" role="listbox">

                                    <!--First slide-->
                                    <div class="carousel-item active">
                                        <div class="row">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 1">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 2">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 3">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.First slide-->

                                    <!--Second slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 4">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 5">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 6">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.Second slide-->

                                    <!--Third slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 7">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 8">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${product.img}" alt="Product Image 9">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.Third slide-->
                                </div>
                                <!--End Slides-->
                            </div>
                            <!--End Carousel Wrapper-->
                            <!--Start Controls-->
                            <div class="col-1 align-self-center">
                                <a href="#multi-item-example" role="button" data-bs-slide="next">
                                    <i class="text-dark fas fa-chevron-right"></i>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                            <!--End Controls-->
                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2">${product.name}</h1>
                                <p class="h3 py-2">${product.price}</p>
                                <p class="py-2">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <span class="list-inline-item text-dark">Rating 4.8 | 36 Comments</span>
                                </p>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Brand:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>Easy Wear</strong></p>
                                    </li>
                                </ul>

                                <h6>Description:</h6>
                                <p>${product.description}</p>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Avaliable Color :</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>White / Black</strong></p>
                                    </li>
                                </ul>

                                <h6>Specification:</h6>
                                <ul class="list-unstyled pb-3">
                                    <li>Lorem ipsum dolor sit</li>
                                    <li>Amet, consectetur</li>
                                    <li>Adipiscing elit,set</li>
                                    <li>Duis aute irure</li>
                                    <li>Ut enim ad minim</li>
                                    <li>Dolore magna aliqua</li>
                                    <li>Excepteur sint</li>
                                </ul>

                                <form action="CartServlet" method="POST">
                                    <input type="hidden" name="product-title" value="Activewear">
                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item">Size :
                                                    <input type="hidden" name="product-size" id="product-size" value="S">
                                                </li>
                                                <li class="list-inline-item"><span class="btn btn-success btn-size">S</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success btn-size">M</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success btn-size">L</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success btn-size">XL</span></li>
                                            </ul>
                                        </div>
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item text-right">
                                                    Quantity
                                                    <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                                </li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                                <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <button type="submit" class="btn btn-success btn-lg" name="submit" value="buy">Buy</button>
                                        </div>
                                        <div class="form-group">
                                            <form action="CartServlet" method="post">
                                                <input type="hidden" name="product_id" value="${product.id}"/>
                                                <input type="hidden" name="quantity" value="1"/>
                                                <input type="hidden" name="action" value="create"/>
                                                <button type="submit" class="cart">Add to cart</button>
                                            </form>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
