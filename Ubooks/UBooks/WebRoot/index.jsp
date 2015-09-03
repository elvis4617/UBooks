<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>UBooks</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet"> 
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/lightbox.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <link id="css-preset" href="css/presets/preset1.css" rel="stylesheet">
  <link href="css/responsive.css" rel="stylesheet">

  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
  <![endif]-->
  
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <link rel="shortcut icon" href="images/favicon.ico">
</head><!--/head-->

<body>

  <!--.preloader-->
  <!-- <div class="preloader"> <i class="fa fa-circle-o-notch fa-spin"></i></div> -->
  <!--/.preloader-->

  <header id="home">
    <div id="home-slider" class="carousel slide carousel-fade" data-ride="carousel">
      <div class="carousel-inner">
        <div class="item active" style="background-image: url(images/slider/1.jpg)">
          <div class="caption">
            <h1 class="animated fadeInLeftBig">Welcome to <span>UBOOKS</span></h1>
            <p class="animated fadeInRightBig">Do not, for one repulse</p>
            <p class="animated fadeInRightBig">give up the purpose that you resolved to effect.</p>
            <form action="">
	            <input type="text" />
	     		<br/>
	            <a data-scroll class="btn btn-start animated fadeInUpBig" href="#services">Start now</a>
            </form>
          </div>
        </div>
        <div class="item" style="background-image: url(images/slider/2.jpg)">
          <div class="caption">
            <h1 class="animated fadeInLeftBig">Say Hello to <span>UBOOKS</span></h1>
            <p class="animated fadeInRightBig">Ignorance is not innocence but sin.</p>
            <form action="">
	            <input type="text" />
	     		<br/>
	            <a data-scroll class="btn btn-start animated fadeInUpBig" href="#services">Start now</a>
            </form>
          </div>
        </div>
        <div class="item" style="background-image: url(images/slider/3.jpg)">
          <div class="caption">
            <h1 class="animated fadeInLeftBig">We are <span>Creative</span></h1>
            <p class="animated fadeInRightBig">Time is a bird for ever on the wing.</p>
            <form action="">
	            <input type="text" />
	     		<br/>
	            <a data-scroll class="btn btn-start animated fadeInUpBig" href="#services">Start now</a>
            </form>
          </div>
        </div>
      </div>
      <a class="left-control" href="#home-slider" data-slide="prev"><i class="fa fa-angle-left"></i></a>
      <a class="right-control" href="#home-slider" data-slide="next"><i class="fa fa-angle-right"></i></a>

      <a id="tohash" href="#services"><i class="fa fa-angle-down"></i></a>

    </div><!--/#home-slider-->
    <div class="main-nav">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">
            <h1><img class="img-responsive" src="images/logo.png" alt="logo"></h1>
          </a>
          <div class="search-bar">
          <form id="header-form">
                <select>
                  <option>All</option>
                </select>
                <input id="header-critaria" type="text" />
                <input id="header-submit" type="submit" value="Search" />
          </form>
          </div>           
        </div>
         
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-right">           
            <li class="scroll active"><a href="#home">Home</a></li>
            <li class="scroll"><a class="page" href="#services">Service</a></li> 
            <li class="scroll"><a class="page"href="#books">Contact</a></li> 
            <li class="scroll"><a class="page"href="#about-us">About Us</a></li>                     
            <c:choose>
            	<c:when test="${empty sessionScope.session_user }">
            		<li class="scroll"><a href="<c:url value='/jsps/user/login.jsp'/>">Login</a></li>      
            		<li class="scroll"><a href="<c:url value='/jsps/user/regist.jsp'/>">Signup</a></li>      
            	</c:when>
            	<c:otherwise>
            		<li class="scroll"><a href="<c:url value='/jsps/user/UserServlet?method=exit'/>">Logout</a></li>      
            	</c:otherwise>
            </c:choose>
            
       
     
          </ul>
          
        </div>
      </div>
    </div><!--/#main-nav-->
  </header><!--/#home-->
  <section id="services">
  	<c:choose>
  		<c:when test="${not empty sessionScope.session_user }">
		    <div class="container">
		      <div class="row">
		        <div class="heading col-sm-12 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
		        	<div class="wrapper">
		      			<nav>
		      				<ul>
		      					<li><a href="">My Cart</a></li>
		      					<li><a href="">My Orders</a></li>
		      					<li><a href="">My Books</a></li>
		      				</ul>
		      			</nav>
		      	  </div>
		        </div>
		      </div> 
		    </div>
	    </c:when>
	 </c:choose>

    <div class="container">
      <div class="text-center our-services">
        <div class="row">

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
            <div class="service-icon">
              <i class="fa fa-flask"></i>
            </div>
            <div class="service-info">
              <h3>Brand Identity</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="450ms">
            <div class="service-icon">
              <i class="fa fa-umbrella"></i>
            </div>
            <div class="service-info">
              <h3>Creative Idea</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="550ms">
            <div class="service-icon">
              <i class="fa fa-cloud"></i>
            </div>
            <div class="service-info">
              <h3>Awesome Support</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="650ms">
            <div class="service-icon">
              <i class="fa fa-coffee"></i>
            </div>
            <div class="service-info">
              <h3>Professional Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="750ms">
            <div class="service-icon">
              <i class="fa fa-bitbucket"></i>
            </div>
            <div class="service-info">
              <h3>App Development</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="850ms">
            <div class="service-icon">
              <i class="fa fa-gift"></i>
            </div>
            <div class="service-info">
              <h3>Clean Code</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="650ms">
            <div class="service-icon">
              <i class="fa fa-coffee"></i>
            </div>
            <div class="service-info">
              <h3>Professional Design</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="750ms">
            <div class="service-icon">
              <i class="fa fa-bitbucket"></i>
            </div>
            <div class="service-info">
              <h3>App Development</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

          <div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="850ms">
            <div class="service-icon">
              <i class="fa fa-gift"></i>
            </div>
            <div class="service-info">
              <h3>Clean Code</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
            </div>
          </div>

         <div class="yahoo">
  	   		 <span class="disabled">&lt; </span>
  	   		 <span class="current">1</span>
  	   		 <a href="">2</a>
  	   		 <a href="">3</a>
  	   		 <a href="">4</a>
  	   		 <a href="">5</a>
  	   		 <a href="">6</a>
  	   		 <a href="">7</a>...
  	   		 <a href="">199</a>
  	   		 <a href="">200</a>
  	   		 <a href="">  &gt; </a>
	   	  </div>
        </div>
      </div>
    </div>
  </section><!--/#services-->
  
  <c:choose>
	<c:when test="${not empty sessionScope.sessionUser }">
	   <section id="portfolio">
	    <div class="container">
	      <div class="row">
	        <div class="heading text-center col-sm-8 col-sm-offset-2 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
	          <h2>Books</h2>
	          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam</p>
	        </div>
	      </div> 
	    </div>
	
	    <div class="container">
	      <div class="row">
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInRightBig" data-wow-duration="1000ms" data-wow-delay="300ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/1.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInLeftBig" data-wow-duration="1000ms" data-wow-delay="400ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/2.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInRightBig" data-wow-duration="1000ms" data-wow-delay="500ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/3.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInLeftBig" data-wow-duration="1000ms" data-wow-delay="600ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/4.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInRightBig" data-wow-duration="1000ms" data-wow-delay="700ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/5.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInLeftBig" data-wow-duration="1000ms" data-wow-delay="800ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/6.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInRightBig" data-wow-duration="1000ms" data-wow-delay="900ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/7.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	        
	        <div class="col-sm-3">
	          <div class="folio-item wow fadeInLeftBig" data-wow-duration="1000ms" data-wow-delay="1000ms">
	            <div class="folio-image">
	              <img class="img-responsive" src="images/portfolio/8.jpg" alt="">
	            </div>
	            <div class="overlay">
	              <div class="overlay-content">
	                <div class="overlay-text">
	                  <div class="folio-info">
	                    <h3>Time Hours</h3>
	                    <p>Design, Photography</p>
	                  </div>
	                  <div class="folio-overview">
	                    <span class="folio-link"><a class="folio-read-more" href="#" data-single_url="portfolio-single.html" ><i class="fa fa-link"></i></a></span>
	                    <span class="folio-expand"><a href="images/portfolio/portfolio-details.jpg" data-lightbox="portfolio"><i class="fa fa-search-plus"></i></a></span>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div> 
	
	      </div>
	    </div>
	     <div class="yahoo">
	           <span class="disabled">&lt; </span>
	           <span class="current">1</span>
	           <a href="">2</a>
	           <a href="">3</a>
	           <a href="">4</a>
	           <a href="">5</a>
	           <a href="">6</a>
	           <a href="">7</a>...
	           <a href="">199</a>
	           <a href="">200</a>
	           <a href="">  &gt; </a>
	        </div>
	    <div id="portfolio-single-wrap">
	      <div id="portfolio-single">
	      </div>
	    </div><!-- /#portfolio-single-wrap -->
	  </section><!--/#portfolio-->
	  </c:when>
	</c:choose>

  <section id="about-us" class="parallax">
    <div class="container">
      <div class="row">
        <div class="col-sm-6">
          <div class="about-info wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
            <h2>About us</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.Ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          </div>
        </div>
        <div class="col-sm-6">
          <div class="our-skills wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
            <div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
              <p class="lead">User Experiances</p>
              <div class="progress">
                <div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar"  aria-valuetransitiongoal="95">95%</div>
              </div>
            </div>
            <div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="400ms">
              <p class="lead">Web Design</p>
              <div class="progress">
                <div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar"  aria-valuetransitiongoal="75">75%</div>
              </div>
            </div>
            <div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="500ms">
              <p class="lead">Programming</p>
              <div class="progress">
                <div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar"  aria-valuetransitiongoal="60">60%</div>
              </div>
            </div>
            <div class="single-skill wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
              <p class="lead">Fun</p>
              <div class="progress">
                <div class="progress-bar progress-bar-primary six-sec-ease-in-out" role="progressbar"  aria-valuetransitiongoal="85">85%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section><!--/#about-us-->

  <section id="contact">
    <div id="google-map" class="wow fadeIn" data-latitude="42.391036" data-longitude="-72.526826" data-wow-duration="1000ms" data-wow-delay="400ms"></div>
    <div id="contact-us" class="parallax">
      <div class="container">
        <div class="row">
          <div class="heading text-center col-sm-8 col-sm-offset-2 wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
            <h2>Contact Us</h2>
          </div>
        </div>
        <div class="contact-form wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
          <div class="row">
            <div class="col-sm-6">
              <form id="main-contact-form" name="contact-form" method="post" action="#">
                <div class="row  wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <input type="text" name="name" class="form-control" placeholder="Name" required="required">
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="form-group">
                      <input type="email" name="email" class="form-control" placeholder="Email Address" required="required">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" name="subject" class="form-control" placeholder="Subject" required="required">
                </div>
                <div class="form-group">
                  <textarea name="message" id="message" class="form-control" rows="4" placeholder="Enter your message" required="required"></textarea>
                </div>                        
                <div class="form-group">
                  <button type="submit" class="btn-submit">Send Now</button>
                </div>
              </form>   
            </div>
            <div class="col-sm-6">
              <div class="contact-info wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                <ul class="address">
                  <li><i class="fa fa-map-marker"></i> <span> Address:</span> UMASS Amherst CICS </li>
                  <li><i class="fa fa-phone"></i> <span> Phone:</span> +928 336 2000  </li>
                  <li><i class="fa fa-envelope"></i> <span> Email:</span><a href="mailto:someone@yoursite.com"> Ubsupport@gmail.com</a></li>
                  <li><i class="fa fa-globe"></i> <span> Website:</span> <a href="#">www.ubooks.com</a></li>
                </ul>
              </div>                            
            </div>
          </div>
        </div>
      </div>
    </div>        
  </section><!--/#contact-->
  <footer id="footer">
    <div class="footer-top wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="300ms">
      <div class="container text-center">
        <div class="footer-logo">
          <a href="index.html"><img class="img-responsive" src="images/logo.png" alt=""></a>
        </div>
        <div class="social-icons">
          <ul>
            <li><a class="envelope" href="#"><i class="fa fa-envelope"></i></a></li>
            <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li> 
            <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
            <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
            <li><a class="tumblr" href="#"><i class="fa fa-tumblr-square"></i></a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-bottom">
      <div class="container">
        <div class="row">
          <div class="col-sm-6">
            <p> Credited to &copy; 2014 Oxygen Theme.</p>
          </div>
          <div class="col-sm-6">
            <p class="pull-right">Modified by Elvis</p>
          </div>
        </div>
      </div>
    </div>
  </footer>

  	<div class="style-chooser">
      <div class="style-chooser-inner">
        <a href="#" class="toggler"><i class="fa fa-cog fa-spin"></i></a>
        <h4>Presets Color</h4>
        <ul class="clearfix">
          <li class="preset1 active" data-preset="1"><a href="#" data-color="preset1"></a></li>
          <li class="preset2" data-preset="2"><a href="#" data-color="preset2"></a></li>
          <li class="preset3" data-preset="3"><a href="#" data-color="preset3"></a></li>        
          <li class="preset4" data-preset="4"><a href="#" data-color="preset4"></a></li>
          <li class="preset5" data-preset="5"><a href="#" data-color="preset5"></a></li>
          <li class="preset6" data-preset="6"><a href="#" data-color="preset6"></a></li>
        </ul>
      </div>
    </div>

  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
  <script type="text/javascript" src="js/jquery.inview.min.js"></script>
  <script type="text/javascript" src="js/wow.min.js"></script>
  <script type="text/javascript" src="js/mousescroll.js"></script>
  <script type="text/javascript" src="js/smoothscroll.js"></script>
  <script type="text/javascript" src="js/jquery.countTo.js"></script>
  <script type="text/javascript" src="js/lightbox.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>

</body>
</html>