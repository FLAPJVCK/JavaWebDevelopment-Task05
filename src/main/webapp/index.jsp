<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Medicine</title>
</head>
<body>
</h1>
<br/>
<section>
    <h2>Choose Parser:</h2>
    <section>
        <form enctype="multipart/form-data" action="parsing" method="post">
            <input type="file" name="fileXML" accept=".xml"/>
            <br><br>
            <input class="type" type="submit" name="parserType" value="SAX">
            <input class="type" type="submit" name="parserType" value="StAX">
            <input class="type" type="submit" name="parserType" value="DOM">
        </form>
    </section>
</section>
</body>
</html>