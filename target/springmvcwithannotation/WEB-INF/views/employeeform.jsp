<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE FORM</title>
</head>
<body>
	  <div>
	  	<h2>EMPLOYEE FORM DETAILS</h2>
	  	<hr/>
	  	<form:form action="storeEmployee" modelAttribute="emp" method="POST">
      <table>
          <tr>
              <td>EID:</td>
              <td><form:input path="id" /></td>
          </tr>
           <tr>
              <td>ENAME:</td>
              <td><form:input path="name" /></td>
          </tr>
          <tr>
              <td>ESALARY:</td>
              <td><form:input path="salary" /></td>
          </tr>
           <tr>
              <td colspan="2">
                  <input type="submit" value="STORE" />
              </td>
          </tr>
          
      </table>
  </form:form>
	  </div>
</body>
</html>