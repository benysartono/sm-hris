<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<embed id="pdfFile" width="1000" height="1000" type="application/pdf" src="<s:property value='fileURL' />" />
<!-- <object type="application/pdf" data="<s:property value='outputStream' />" />  -->
</body>
</html>