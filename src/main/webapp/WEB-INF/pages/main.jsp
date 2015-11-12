<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head lang="en">
    <c:url value="/resources/js/main.js" var="js"/>
    <c:url value="/resources/js/libraries/jquery-2.1.3.js" var="jquery"/>
    <script src="${js}" type="text/javascript"></script>
    <script src="${jquery}" type="text/javascript"></script>
</head>

<body>
<input id="combinationCode">
<div id="getCombination" style="
    width: 130px;
    height: 20px;
    float: left;
    background: gray;
    cursor: pointer;
">Get Combination</div>
<label id="combinationName"></label>
</body>
</html>