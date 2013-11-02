
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>
		
		<head>
		
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Vadim Demidov Web</title>
			
			<!-- Bootstrap css responsive-->
    	    <link href="resources/css/bootstrap.css" rel="stylesheet">
    	    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
						
		</head>
		
		<body>
			
			<!-- JQuery and Bootstrap file-->
			<script src="resources/js/jquery-1.10.2.min.js"></script>
			<script src="resources/js/bootstrap.min.js"></script>
			<script src="resources/js/jquery.scrollTo.js"></script> 
			<script src="resources/js/jquery.nav.js"></script>
		
			<div class="navbar navbar-fixed-bottom" id="mymenu">
				<div class="navbar-inner">
					<div class="container">
					     	<ul class="nav pull-right">	
								<li><a href="#section-1"><b>PROJECTS</b></a> </li>							
								<li><a href="#section-2"><b>SOCIAL</b></a></li>	
								<li><a href="#section-3"><b>ABOUT ME</b></a></li>	
								<li><a href="#section-4"><b>ORDER EVENT</b></a></li>
							</ul>	
							<ul class="nav pull-left">
								<li><a href="#">Welcome: ${userName}</a>
							</ul>											
						</div>			
					</div>			
				</div>
			
			
				<div id="myslide" class="carousel slide">
					<div class="carousel-inner">
					
						<div class="active item"><img src="resources/img/background_java.jpg">
							<div class="carousel-caption">Hello1</div>
						</div>
						
						<div class="item"><img src="resources/img/background_java.jpg">
							<div class="carousel-caption">Hello2</div>
						</div>
						
						<div class="item"><img src="resources/img/background_java.jpg">
							<div class="carousel-caption">Hello3</div>
						</div>					
					</div>
				
						<a class="carousel-control left" href="#myslide" data-slide="prev">&lsaquo;
							<span class="icon-prev"></span>
						</a>
						<a class="carousel-control right" href="#myslide" data-slide="next">&rsaquo;
							<span class="icon-next"></span>
						</a>
				</div>
				
				<div class="hero-unit" id="section-1">	
					<div class="row">
						<div class="span6">
							<p><font color="#ffffff">Here is going to be  ooasmr.ru sait<br/>
							Image or some text and image</font>
							</p>
							<a href="#" class="btn">Go see site</a>
						</div>			
						<div class="span6">
							<p><font color="#ffffff">Here is going to be my project<br/>
							Image or some text and image</font>
							</p>
							<a href="#" class="btn">Go see web app</a>
						</div>	
					</div>		
				</div>
				
				<div class="hero-unit" id="section-2">
					<p><font color="#ffffff">Here is going to be a social stream<br/>
					</font></p>
					<p><font color="#ffffff">Here is continue....<br/>
					My facebook page and other.</font>
					</p>
					<a href="#" class="btn">See Java</a>	
				</div>
				
				<div class="hero-unit" id="section-3">
					<div class="row">
						<div class="span2">
							<p><font color="#ffffff">Here is going to be my photo<br/></font></p>
						</div>
						<div class="span10">
							<p><font color="#ffffff">Here is going to be my biografy description<br/>
							And here continue....</font></p>
							<a href="#" class="btn">See Java</a>
						</div>
					</div>	
				</div>
			
				<div class="hero-unit" id="section-4">
					<div class="row">
						<div class="span12">
							<p><font color="#ffffff">Some text of order and picture continue....</font></p>
							<a href="event" class="btn">Go to order</a>
						</div>
					</div>	
				</div>
			
				<script type="text/javascript">			
					$(document).ready(function(){					
						$('.carousel').carousel({
							interval: 4000
						});		
						
						$('#mymenu').onePageNav({
							begin: function() {
							console.log('start')},
							end: function() {
							console.log('stop')}
						});
						
					});
				</script> 
									
		</body>
				
	</html>