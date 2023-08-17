<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/6432a84392.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>


<div class="container">
   <div class="row">
       <div class="col-lg-8 row">
           <c:forEach items="${items}" var="sp">
               <div class="col-lg-4">
                   <div class="panel panel-primary poly-item text-center">
                       <div class="panel-heading">
                           <div class="panel-title">${sp.ten}</div>
                       </div>
                       <div class="panel-body">
                           <a href="/product/detail/${sp.id}">
                               <img src="/images/${sp.image}">
                           </a>
                       </div>
                       <div class="panel-footer text-right">
                           <b class="pull-left">${sp.gia}</b>
                           <button ng-click="cart.add(${sp.id})" class="btn btn-success">
                               <i class="fas fa-shopping-cart"></i>
                           </button>
                       </div>
                   </div>
               </div>
           </c:forEach>
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
</div>

