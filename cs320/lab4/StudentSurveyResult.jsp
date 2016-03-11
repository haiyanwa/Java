<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Student Survey Result</title>
</head>
<body>
<table border="1">
<tr><th>First Name</th><th>Last Name</th><th>CIN</th><th>Quarter</th><th>Course</th><th>Date</th></tr>
<c:forEach items="${survies}" var="survey">
<tr><td>${survey.fname}</td>
<td>${survey.lname}</td>
<td>${survey.cin}</td>
<td>${survey.quarter}</td>
<td>${survey.courseName}</td>
<td>${survey.date}</td>
</tr>
</c:forEach>
</table>
</body>
</html>