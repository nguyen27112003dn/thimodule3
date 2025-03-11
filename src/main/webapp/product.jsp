<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Management Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-4">🔍 Find Product</h2>
    <c:if test="${not empty sessionScope.successMessage}">
        <div id="success-alert" class="alert alert-success alert-dismissible fade show mt-3" role="alert">
            <i class="fas fa-check-circle"></i> ${sessionScope.successMessage}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <c:remove var="successMessage" scope="session"/>
    </c:if>
    <script>
        function confirmDelete(productId) {
            if (confirm("Bạn có chắc cắn muốn xóa sản phẩm với ID: " + productId + "?")) {
                window.location.href = "/products?action=deleteProduct&id=" + productId;
            }
        }

        setTimeout(function () {
            let alertBox = document.getElementById('success-alert');
            if (alertBox) {
                alertBox.style.transition = "opacity 0.5s ease";
                alertBox.style.opacity = "0";
                setTimeout(() => alertBox.remove(), 500);
            }
        }, 1000);
    </script>
    <div class="row g-3">
        <div class="col-md-3">
            <input type="text" class="form-control" placeholder="Product Name">
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control" placeholder="Enter Price">
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control" placeholder="Enter Category">
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control" placeholder="Enter Color">
        </div>
        <div class="col-md-1">
            <button class="btn btn-primary"><i class="fas fa-sync"></i></button>
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary"><i class="fas fa-search"></i> Search</button>
        </div>
    </div>

    <button class="btn btn-dark mt-3"><i class="fas fa-plus"></i> <a href="/products?action=create">Add Product </a>
    </button>

    <table class="table table-bordered text-center mt-3">
        <thead class="table-primary">
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="product" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${product.productID}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productPrice}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.productDescription}"/></td>
                <td><c:out value="${product.category.nameCategory}"/></td>
                <td>
                    <a href="#" class="text-warning"><i class="fas fa-edit"></i> Edit</a></td>
                <td>
                    <a href="#" class="text-danger" onclick="confirmDelete(${product.productID})">
                        <i class="fas fa-trash"></i> Delete
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
