<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
<title>UserInof</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/owl.carousel.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/jquery.min.js"></script>
<!-- cart -->
		<script src="js/simpleCart.min.js"> </script>
	<!-- cart -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="js/imagezoom.js"></script>

						<!-- FlexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});

function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}

function delCookie()
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var uval=getCookie("userCookie");
	var cval=getCookie("cartCookie");
	if(uval!=null)
		document.cookie= "userCookie" + "="+uval+";expires="+exp.toGMTString();
	if(cval!=null)
		document.cookie="cartCookie" + "="+cval+";expires="+exp.toGMTString();
	document.getElementById("loginoutform").submit();
}
function delCarCookie()
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie("cartCookie");
	if(cval!=null)
		document.cookie="cartCookie" + "="+cval+";expires="+exp.toGMTString();
}
function checkUser(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var passwordagain = document.getElementById("passwordagain").value;
	if(email == ""  ){
		alert("邮箱不能为空");
		return false;
	}
	if(password == ""  ){
		alert("密码不能为空");
		return false;
	}
	if(password != passwordagain){
		alert("两次输入的密码不同");
		return false
	}
	document.getElementById("formid").submit();
}
</script>

</head>
<body>
	<!--header-->
		<div class="header">
			<div class="header-top">
			<div class="container">
				 <div class="lang_list">
					<select tabindex="4" class="dropdown1">
						<option value="" class="label" value="">En</option>
						<option value="1">English</option>
						<option value="2">French</option>
						<option value="3">German</option>
					</select>
   			</div>
				<div class="top-right">
				<ul>
					<li class="text"><a href="login">login</a>
					<li><div class="cart box_1">
							<a href="checkout.html">
								 <span class="simpleCart_total"> $${price}</span>
							</a>	
							<p></p>
							<div class="clearfix"> </div>
						</div></li>
				</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			</div>
			<div class="header-bottom">
					<div class="container">
<!--/.content-->
<div class="content white">
	<nav class="navbar navbar-default" role="navigation">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        <h1 class="navbar-brand"><a  href="index.html">fashion wear</a></h1>
	    </div>
	    <!--/.navbar-header-->
	
	     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
			<li><a href="index.html">Home</a></li>
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Men <b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-3">
			            <div class="row">
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Women</a></li>
						            <li><a class="list1" href="products.html">PrettySecrets</a></li>
						            <li><a class="list1" href="products.html">N-Gal</a></li>
						            <li><a class="list1" href="products.html">Lobster</a></li>
						            <li><a class="list1" href="products.html">Citypret</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Kids</a></li>
						            <li><a class="list1" href="products.html">River Island</a></li>
						            <li><a class="list1" href="products.html">Penny</a></li>
						            <li><a class="list1" href="products.html">Nidhi Munim</a></li>
						            <li><a class="list1" href="products.html">Divaat</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Men</a></li>
						            <li><a class="list1" href="products.html">Fiesta Clara</a></li>
						            <li><a class="list1" href="products.html">Quiksilver</a></li>
						            <li><a class="list1" href="products.html">Incult</a></li>
						            <li><a class="list1" href="products.html">Proline</a></li>
					            </ul>
				            </div>
			            </div>
		            </ul>
		        </li>
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">women <b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-3">
			            <div class="row">
				            <div class="col-sm-4">
					           <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Women</a></li>
						            <li><a class="list1" href="products.html">PrettySecrets</a></li>
						            <li><a class="list1" href="products.html">N-Gal</a></li>
						            <li><a class="list1" href="products.html">Lobster</a></li>
						            <li><a class="list1" href="products.html">Citypret</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					             <ul class="multi-column-dropdown">
						            <li><a class="list"  href="products.html">Kids</a></li>
						            <li><a class="list1" href="products.html">River Island</a></li>
						            <li><a class="list1" href="products.html">Penny</a></li>
						            <li><a class="list1" href="products.html">Nidhi Munim</a></li>
						            <li><a class="list1" href="products.html">Divaat</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a  class="list" href="products.html">Men</a></li>
						            <li><a class="list1" href="products.html">Fiesta Clara</a></li>
						            <li><a class="list1" href="products.html">Quiksilver</a></li>
						            <li><a class="list1" href="products.html">Incult</a></li>
						            <li><a class="list1" href="products.html">Proline</a></li>
					            </ul>
				            </div>
			            </div>
		            </ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">kids <b class="caret"></b></a>
		            <ul class="dropdown-menu multi-column columns-3">
			            <div class="row">
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Women</a></li>
						            <li><a class="list1" href="products.html">PrettySecrets</a></li>
						            <li><a class="list1" href="products.html">N-Gal</a></li>
						            <li><a class="list1" href="products.html">Lobster</a></li>
						            <li><a class="list1" href="products.html">Citypret</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					             <ul class="multi-column-dropdown">
						            <li><a  class="list" href="products.html">Kids</a></li>
						            <li><a class="list1" href="products.html">River Island</a></li>
						            <li><a class="list1" href="products.html">Penny</a></li>
						            <li><a class="list1" href="products.html">Nidhi Munim</a></li>
						            <li><a class="list1" href="products.html">Divaat</a></li>
					            </ul>
				            </div>
				            <div class="col-sm-4">
					            <ul class="multi-column-dropdown">
						            <li><a class="list" href="products.html">Men</a></li>
						            <li><a class="list1" href="products.html">Fiesta Clara</a></li>
						            <li><a class="list1" href="products.html">Quiksilver</a></li>
						            <li><a class="list1" href="products.html">Incult</a></li>
						            <li><a class="list1" href="products.html">Proline</a></li>
					            </ul>
				            </div>
			            </div>
		            </ul>
		        </li>
					<li><a href="products.html">Top</a></li>
					<li><a href="products.html">Bikini</a></li>
	        </ul>
	    </div>
	    <!--/.navbar-collapse-->
	</nav>
	<!--/.navbar-->
</div>
			   <div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
			
<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!--header-->
			<div class="content">
 <!-- registration -->
	<div class="main-1">
		<div class="container">
			<div class="register">
		  	  <form method = 'post' action = 'submit_usermessage'id="formid" >
				 <div class="register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>姓<label>*</label></span>
						<input name = "firstName" type="text" id="firstName" value=${user.firstname}>
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>名<label>*</label></span>
						<input  name = "lastName" type="text"id="lastName" value=${user.lastname}>
					 </div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <label class="checkbox">
					   </a>
					 </div>
				     <div class="register-bottom-grid">
						    <h3>更改密码</h3>
							 <div class="wow fadeInLeft" data-wow-delay="0.4s">
								<span>Password<label>*</label></span>
								<input name="password" type="password" id="password">
							 </div>
							 <div class="wow fadeInRight" data-wow-delay="0.4s">
								<span>Confirm Password<label>*</label></span>
								<input type="password"id="passwordagain">
							 </div>
					 </div>
				  <div class="clearfix"> </div>
				 	  <div class="register-but">
					  <input type="button" value="submit" onclick = "checkUser();">
					  <div class="clearfix"> </div>
				  </div>
				</form>
				<form method = 'get' action = "login" id="loginoutform">
					<div class="clearfix"> </div>
					<div class="register-but">
						<input type="button" value="退出登录" onclick = "delCookie();">
						<div class="clearfix"> </div>
					</div>
				</form>
		   </div>
		 </div>
	</div>
<!-- registration -->

<div class="subscribe">
	 <div class="container">
	 <div class="subscribe1">
		 <h4>the latest from fashion wear</h4>
		 </div>
		 <div class="subscribe2">
		 <form>
			 <input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
			 <input type="submit" value="JOIN">
		 </form>
	 </div>
	 <div class="clearfix"></div>
	 </div>
</div>
</div>

	<!--footer-->
		<div class="footer-section">
			<div class="container">
				<div class="footer-grids">
					<div class="col-md-2 footer-grid">
					<h4>company</h4>
					<ul>
						<li><a href="products.html">products</a></li>
						<li><a href="#">Work Here</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Happenings</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
					<div class="col-md-2 footer-grid">
					<h4>service</h4>
					<ul>
						<li><a href="#">Support</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Warranty</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
					</div>
					<div class="col-md-2 footer-grid">
					<h4>order & returns</h4>
					<ul>
						<li><a href="#">Order Status</a></li>
						<li><a href="#">Shipping Policy</a></li>
						<li><a href="#">Return Policy</a></li>
						<li><a href="#">Digital Gift Card</a></li>
					</ul>
					</div>
					<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
					</div>
					<div class="col-md-4 footer-grid1">
					<div class="social-icons">
						<a href="#"><i class="icon"></i></a>
						<a href="#"><i class="icon1"></i></a>
						<a href="#"><i class="icon2"></i></a>
						<a href="#"><i class="icon3"></i></a>
						<a href="#"><i class="icon4"></i></a>
					</div>
					<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
					</div>
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
	<!--footer-->
			
</body>
</html>