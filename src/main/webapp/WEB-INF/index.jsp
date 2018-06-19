<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	 <div class="wrapper">
        <div class="goldcount">
            <h4>Your Gold:</h4>
            <input type="text" value = "<c:out value="${gold}"/>">
            <form action="/clear" method="post">
                <button>Reset Gold</button>
            </form>
        </div>
        <div>
            <div class ="box" >
                <h3>Farm</h3>
                <p>(earns 10-20 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="farm" />
                    <input type="submit" value="Find Gold!"/>
                </form>
            </div>
            <div class ="box" >
                <h3>Cave</h3>
                <p>(earns 5-10 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="cave" />
                    <input type="submit" value="Find Gold!"/>
                </form>
            </div>
            <div class ="box" >
                <h3>House</h3>
                <p>(earns 2-5 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="house" />
                    <input type="submit" value="Find Gold!"/>
                </form>
            </div>
            <div class ="box" >
                <h3>Casino</h3>
                <p>(earns/takes 0-50 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="casino" />
                    <input type="submit" value="Find Gold!"/>
                </form>
            </div>
        </div>
        <p class="activityheader">Activities:</p>
        
         <div class = "activitiesbox">
            <ul>
            	<c:forEach items="${activity}" var ="activities">
                    <li>${activities}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>