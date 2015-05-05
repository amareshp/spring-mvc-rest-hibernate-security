<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Get page title</h2>
  <form role="form" action="/spring-mvc-rest-hibernate/page/details" method="post">
    <div class="form-group">
      <label for="url">URL:</label>
      <input type="text" class="form-control" id="url" name="url" placeholder="Enter url">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

<div class="container">
  <h2>Get page details using REST</h2>
  <form role="form" action="/spring-mvc-rest-hibernate/getpage" method="post">
    <div class="form-group">
      <label for="url">URL:</label>
      <input type="text" class="form-control" id="url" name="url" placeholder="Enter url">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

<div class="container">
  <h2>List Employees</h2>
  <form role="form" action="/spring-mvc-rest-hibernate/employees/list" method="get">
    <div class="form-group">
      <label for="url">SSN:</label>
      <input type="text" class="form-control" id="ssn" name="ssn" placeholder="Employee SSN">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
