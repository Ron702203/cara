<%-- 
    Document   : index
    Created on : May 8, 2023, 10:08:20 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <!-- Nucleo Icons -->
        <link href="./public/admin/assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./public/admin/assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="./public/admin/assets/css/material-dashboard.css?v=3.0.5" rel="stylesheet" />
        <!-- Nepcha Analytics (nepcha.com) -->
        <!-- Nepcha is a easy-to-use web analytics. No cookies and fully compliant with GDPR, CCPA and PECR. -->
        <script defer data-site="YOUR_DOMAIN_HERE" src="https://api.nepcha.com/js/nepcha-analytics.js"></script>
        <link rel="apple-touch-icon" href="./assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="./assets/img/favicon.ico">
    </head>
    <body class="g-sidenav-show  bg-gray-200">

        <%@include file="../inc/sidebar.jsp" %>
        <main class="main-content border-radius-lg ">
            <%@include file="../inc/navbar.jsp" %>
            <div class="container-fluid py-4">
                <div class="row">

                    <div class="col-12">
                        <div class="card my-4">
                            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                                <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                                    <h6 class="text-white text-capitalize ps-3">Product table</h6>
                                </div>
                            </div>
                            <div class="card-body px-0 pb-2">
                                <div class="table-responsive p-0">
                                    <table class="table align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">amount</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">product</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">order</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">price</th>

                                                <th class="text-secondary opacity-7"></th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach items="${orderDetailList}" var="orderDetail">
                                                <tr>
                                                    <td>
                                                        <div class="d-flex px-2 py-1">
                                                            <p class="text-xs font-weight-bold mb-0">${orderDetail.amount}</p>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex px-2 py-1">
                                                            <p class="text-xs font-weight-bold mb-0">${orderDetail.product.id}</p>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex px-2 py-1">
                                                            <p class="text-xs font-weight-bold mb-0">${orderDetail.order.code}</p>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex px-2 py-1">
                                                            <p class="text-xs font-weight-bold mb-0">${orderDetail.price}</p>
                                                        </div>
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%@include file="../inc/footer.jsp" %>
        </main>

    </body>
</html>
