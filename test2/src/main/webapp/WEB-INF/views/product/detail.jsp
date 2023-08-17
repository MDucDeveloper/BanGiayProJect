<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/6432a84392.js" crossorigin="anonymous"></script>

<main>
    <div class="container-fluid row">
        <div class="col-lg-8">
                ChiTiet
                <h1>${items.ten}</h1>
                <h1>${items.loaigiay.ten}</h1>

                CungLoai
                <ul>
                    <c:forEach var="l" items="${items.loaigiay.products}">
                        <li>
                            <a href="/product/detail/${l.id}">${l.ten}</a>
                        </li>
                    </c:forEach>
                </ul>
        </div>
        <div class="col-lg-4">
            <div>
                <b class="fas fa-shopping-cart"></b>Danh mục
            </div>
            <div class="list-group">
                <c:forEach items="${cates}" var="loai">
                    <a class="list-group-item" href="/product/list?cid=${loai.id}">${loai.ten}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</main>