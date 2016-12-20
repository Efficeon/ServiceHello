<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<br/>
<h2>Service Hello</h2>
<br/>
<h3>Пример запросов</h3>
<br/>
<h4>/hello/contacts?nameFilter=^A.*$ - возвращает контакты, которые НЕ начинаются с A</h4>
<br/>
<h4>/hello/contacts?nameFilter=^.*[aei].*$ - возвращает контакты, которые НЕ содержат букв a, e, </h4>
</body>
</html>