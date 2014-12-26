<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Select check-in date | The Last Asylum</title>
<link media="all" rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/all.css'/>" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="<c:url value='/resources/js/main.js'/>"></script>
<script  type="text/javascript">

function doAjax() {
	
	$.ajax({
		
		
		
		url : '/LisanetsProject/freeRooms.do',
				type: 'GET',
				dataType: 'json',
				contentType: 'application/json',
				mimeType: 'application/json',
				
				data : {
					dayIn : $('#day-select').val(),
					monthIn : $('#month-select').val(),
					yearIn : $('#year-select').val(),
					dayOut : $('#day-select-out').val(),
					monthOut : $('#month-select-out').val(),
					yearOut : $('#year-select-out').val()
					
				},
				
				success : function(responseText) {
					
					if( responseText instanceof Array ) {
							
					
					$.each(responseText, function(index, item) { 
						$( "#lable" + index ).empty();
					      $('<label>').text(item).appendTo($( "#lable" + index )); 
						
			         });
					}  else{
						
						$("#sel").empty();
						$("#bookId").empty();
						 $('<label>').text("Incorrect date").appendTo($( "#sel" )); 
					}
				
				
				}
	});
}
</script>

</head>
<body>
	<div id="wrapper">
		<!--some information-->
		<div id="header">
			<h1>The Last Asylum Hotel</h1>
			<p class="header">&quot;Abandon all hope, ye who enter here&quot;</p>
		</div>
		<!--main-->
		<div id="main">
			<div id="content">
				<div>
					<p>Lorem ipsum</p>
				</div>
				<form action="#"   class="date-selection-form">
					<fieldset>

						<div class="login-form-heading">
							<p>Select check-in date</p>
						</div>
						<!--check-in date selects-->
						<div class="row-select">
							<ul>
								<li><select name="dayIn" id="day-select" onchange="" size="1">
										<option selected="selected">Day</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
								</select></li>
								<li><select name="monthIn" id="month-select" onchange=""
									size="1">
										<option selected="selected">Month</option>
										<option value="01">January</option>
										<option value="02">February</option>
										<option value="03">March</option>
										<option value="04">April</option>
										<option value="05">May</option>
										<option value="06">June</option>
										<option value="07">July</option>
										<option value="08">August</option>
										<option value="09">September</option>
										<option value="10">October</option>
										<option value="11">November</option>
										<option value="12">December</option>
								</select></li>
								<li><select name="yearIn" id="year-select" onchange=""
									size="1">
										<option selected="selected">Year</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
								</select></li>
							</ul>
						</div>
					
										
						<div class="login-form-heading">
							<p>Select check-out date</p>
						</div>
						<!--check-in date selects-->
						<div class="row-select">
							<ul>
								<li><select name="dayOut" id="day-select-out" onchange="" size="1">
										<option selected="selected">Day</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
								</select></li>
								<li><select name="monthOut" id="month-select-out" onchange=""
									size="1">
										<option selected="selected">Month</option>
										<option value="01">January</option>
										<option value="02">February</option>
										<option value="03">March</option>
										<option value="04">April</option>
										<option value="05">May</option>
										<option value="06">June</option>
										<option value="07">July</option>
										<option value="08">August</option>
										<option value="09">September</option>
										<option value="10">October</option>
										<option value="11">November</option>
										<option value="12">December</option>
								</select></li>
								<li><select name="yearOut" id="year-select-out" onchange=""
									size="1">
										<option selected="selected">Year</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
								</select></li>
							</ul>
						</div>
							
						
						<div class="row-button">
							<input id="sign-up-button" type="button"
								onclick=" document.getElementById('light3').style.display='block';document.getElementById('fade3').style.display='block'; doAjax() "
								value="Find rooms" />
						</div>
					</fieldset>
				</form>
			</div>
		</div>
		<!--password remember lightbox-->
		<div id="light3" class="white_content">
			<!--registration form for new user-->
			<form action="http://localhost:8080/LisanetsProject/confirmation.do" class="registration-form" method="post">
				<fieldset>
				<div id="sel">
					<div class="registration-form-heading">
						<p>Select number of rooms</p>
					</div>
					<div class="row-stand-room" id="lable0"></div>
						<div>
						 <select 
							name="rooms0" id="standard-select" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<div class="row-stand-room" id="lable1"></div>
					<div>
					 <select
							name="rooms1" id="standard-select2" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>


                  <div class="row-stand-room" id="lable2"></div>
                  <div>
                   <select
							name="rooms2" id="lux-select" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<div class="row-stand-room" id="lable3"></div>
					<div>
					<select
							name="rooms3" id="lux-select2" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>

                     <div class="row-stand-room" id="lable4"></div>
                     <div>
                      <select
							name="rooms4" id="vip-select" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<div class="row-stand-room" id="lable5"></div>
					<div>
					 <select
							name="rooms5" id="vip-select2" onchange="" size="1">
							<option selected="selected">-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>

                    </div>





					<!--register submit button-->
					<div class="row-button">
						<ul>
							<li><button type="reset" class="close-button"
									onclick="document.getElementById('light3').style.display='none';document.getElementById('fade3').style.display='none'">Close</button></li>
						<div id = "bookId">	<li><input id="remind-button" type="submit" value="Book" /></li> </div>
						</ul>
					</div>
				</fieldset>
			</form>
		</div>
		<div id="fade3" class="black_overlay"></div>




		<!--footer-->
		<div id="footer">
			<p>Copyright &copy; 2014 Hotel Ltd. All rights reserved</p>
		</div>
	</div>
</body>
</html>