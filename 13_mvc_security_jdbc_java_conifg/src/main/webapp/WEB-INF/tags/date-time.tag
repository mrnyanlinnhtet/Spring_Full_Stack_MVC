<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="value" required="true" type="java.time.LocalDateTime" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="T(java.time.format.DateTimeFormatter).ofPattern('yyyy-MM-dd  HH:mm:ss').format(value)"></spring:eval>
