const app = angular.module("shopping-cart-app",[]);
// const scrollingImage = document.querySelector('.scrolling-image');
// const frame = document.querySelector('.frame');
//
// window.addEventListener('scroll', () => {
//     const scrollPercent = (window.scrollY / (document.body.scrollHeight - window.innerHeight)) * 100;
//     const yAxis = (frame.clientHeight / 2) - (scrollPercent / 2);
//     scrollingImage.style.transform = `translateY(${yAxis}px)`;
// });

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    // Đảm bảo rằng đã inject $http vào controller
    $scope.spBanChay = [];
    $scope.spGiamGia = [];
    $scope.spMoi = [];
    $scope.initialize = function (){
        $http.get("/rest/products").then(resp=>{
            $scope.spBanChay = resp.data;
            $scope.spMoi = resp.data;
            $scope.spGiamGia = resp.data;
        })
    }
    $scope.pager = {
        page:0,
        size:4,
        get items(){
            const start = this.page * this.size;
            return $scope.spBanChay.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1*$scope.spBanChay.length/this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page>(this.count-1)){
                this.first();
            }
        },
        last(){
            this.page = this.count -1;
        }
    };
    $scope.pagerMoi = {
        page:0,
        size:4,
        get items(){
            const start = this.page * this.size;
            return $scope.spMoi.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1*$scope.spMoi.length/this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page>(this.count-1)){
                this.first();
            }
        },
        last(){
            this.page = this.count -1;
        }
    };
    $scope.pagerGiamGia = {
        page:0,
        size:4,
        get items(){
            const start = this.page * this.size;
            return $scope.spMoi.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1*$scope.spMoi.length/this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page>(this.count-1)){
                this.first();
            }
        },
        last(){
            this.page = this.count -1;
        }
    };

    $scope.cart = {
        items: [],
        add: function (id) {
            var item = this.items.find(function (item) {
                return item.id == id;
            });
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(function (resp) {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                }.bind(this)); // Sử dụng bind để đảm bảo this đúng context trong hàm callback
            }
        },
        //Luu gio hang vao localstorage
        saveToLocalStorage: function () {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        //Tong so luong cac mat hang trong gio
        get count(){
            return this.items.map(item => item.qty).reduce((total,qty) => total += qty,0);
        },

        //Tong tien cac mat hang trong gio
        get amount(){
            return this.items.map(item => item.qty * item.gia).reduce((total,qty) => total += qty,0);
        },
        //Doc gio hang tu localstorage
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json? JSON.parse(json):[];
            // var date = new Date();
            // alert('Hom nay la ngay'+ date);
        },
        //Xoa sp khoi gio hang
        remove(id){
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },

        clear(){
            this.items = [];
            this.saveToLocalStorage();
        },
    };

    $scope.cart.loadFromLocalStorage();

    var today = new Date();
    var day = today.getDate();
    var month = today.getMonth()+1;
    var year = today.getFullYear();
    var date = year+"/"+month+"/"+day;
    $scope.order={
        ngaydathang:new Date(),
        diachi:"",
        tongtien:$scope.cart.amount,
        purchase(){
            var order = angular.copy(this);
            //Thuc hien dat hang
            $http.post("/rest/orders",order).then(resp =>{
                $scope.cart.clear();
                location.href = "/order/detail/"+resp.data.id;
                alert("Dat hang thanh cong!");
            }).catch(e =>{
                alert("Loi dat hang!");
                console.log(e);
            })
        },
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return{
                    product:{id:item.id},
                    giaban:item.gia,
                    soluong:item.qty,
                }
            })
        }
    }

    $scope.initialize();
});

