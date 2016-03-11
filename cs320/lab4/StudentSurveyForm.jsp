<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Student Survey Form</title>
</head>
<body>
<p><font color="red">${errmsg}</font></p>
<p><font color="red">${message}</font></p>
<form action="StudentSurvey" method="post">
First Name: <input type="text" name="fname" placeholder="First Name" value="${fname}" /><br/>
Last Name: <input type="text" name="lname" placeholder="Last Name" value="${lname}" /><br/>
CIN: <input type="text" name="cin" placeholder="CIN" value="${cin}" /><br/>

Quarter: <select name="quarter">
<c:choose>
	<c:when test="${quarter} eq 'Winter 2016'"><option value="Winter 2016" selected/>Winter 2016</c:when>
	<c:otherwise><option value="Winter 2016"/>Winter 2016</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${quarter} eq 'Spring 2016'"><option value="Spring 2016" selected/>Spring 2016</c:when>
	<c:otherwise><option value="Spring 2016"/>Spring 2016</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${quarter} eq 'Summer 2016'"><option value="Summer 2016" selected/>Summer 2016</c:when>
	<c:otherwise><option value="Summer 2016"/>Summer 2016</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${quarter} eq 'Fall 2016'"><option value="Fall 2016" selected/>Fall 2016</c:when>
	<c:otherwise><option value="Fall 2016"/>Fall 2016</c:otherwise>
</c:choose>
</select><br/>

Course:
<c:choose>
<c:when test="${courseName} eq 'cs512'"><input type="radio" name="course" value="cs512" checked/>cs512<br/></c:when>
<c:otherwise><input type="radio" name="course" value="cs512" />cs512<br/></c:otherwise>
</c:choose>
<c:choose>
<c:when test="${courseName} eq 'cs520'"><input type="radio" name="course" value="cs520" checked/>cs520<br/></c:when>
<c:otherwise><input type="radio" name="course" value="cs520" />cs520<br/></c:otherwise>
</c:choose>
<input type="submit" name="submit" value="Submit" /><br/>
<a href="StudentSurveyResult">Check the Survey result</a>
</form>	
</body>
</html>