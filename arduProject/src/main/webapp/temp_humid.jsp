<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온습도 데이터</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<style>
		body {font-size:30px}
		#container {text-align: center;margin-top: 50px;}
	</style>
</head>
<body>
	<div id="container">
		<h1>온습도 웹</h1>
		<div>Temperature: <span id="temp"></span>°C</div>
		<div>Humidity: <span id="humid"></span>%</div>
	</div>
</body>
</html>