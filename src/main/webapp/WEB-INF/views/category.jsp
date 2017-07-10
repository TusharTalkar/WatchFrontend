<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD OPERATIONS</title>
</head>
<body>
<div>
${msg}
</div>
<c:if test="${isEditing}" >
<c:url var="formaction"  value="/update"/>
</c:if>
<c:if test="${not isEditing}" >
<c:url var="formaction"  value="/save"/>
</c:if>
<form:form method = "POST" modelAttribute="category" action = "${formaction}">
         <table>
<tr>
               <td><form:label path = "cat_id">Category Id:</form:label></td>
               <td><form:input path = "cat_id" /></td>
            </tr>
<tr>
               <td><form:label path = "cat_name">Name:</form:label></td>
               <td><form:input path = "cat_name" /></td>
            </tr>
<tr>
               <td><form:label path = "cat_desc">Description</form:label></td>
               <td><form:input path = "cat_desc" /></td>
            </tr>
<tr>
<td colspan = "2">
               <c:if test="${isEditing}" >
                  <input type = "submit" value = "Update"/>
                  </c:if>
                     <c:if test="${not isEditing}" >
                  <input type = "submit" value = "Save"/>
                  </c:if>
               </td>
            </tr>
</table>
</form:form>
      <table>
<tr>
      <th>ID</th>
      <th> NAME</th>
      <th> DESCRIPTION</th>
      </tr>
<c:forEach var="cat" items="${categoryList}" >
<tr>
      <td>${cat.cat_id}</td>
      <td>${cat.cat_name}</td>
      <td>${cat.cat_desc}</td>
      <td><a href="update/${cat.cat_id}">Update</a></td>
      <td><a href="delete/${cat.cat_id}">Delete</a></td>
      </tr>
</c:forEach>
      </table>
</body>
</html>