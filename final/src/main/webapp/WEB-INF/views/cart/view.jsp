<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/6432a84392.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>


<div  class="container">
    <table class="table table-hover" name="table">
        <thead>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th colspan="2">Quantity</th>
            <th>Amount</th>
        </thead>
        <tbody>
            <tr ng-repeat="item in cart.items">
                <td>{{item.id}}</td>
                <td>{{item.ten}}</td>
                <td>{{item.gia}}</td>
                <td>{{item.qty}}</td>
                <td><input ng-change="cart.saveToLocalStorage()" ng-model="item.qty" type="number" min="1" style="width: 50px"></td>
                <td>{{item.qty*item.gia}}</td>
                <td>
                    <button ng-click="cart.remove(item.id)" class="btn btn-danger">Delete</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div>
        <button ng-click="cart.clear()" class="btn btn-dark">Clear</button>
        <button class="btn btn-primary">
            <a style="color: white" href="/order/checkout">Checkout</a>
        </button>
    </div>

</div>