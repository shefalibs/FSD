<!doctype html>  
<html lang="en">  
<head>  
  <meta charset="utf-8">  
  <title>jQuery UI Autocomplete - Default functionality</title>  
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
  <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>  
  <link rel="stylesheet" href="/resources/demos/style.css">  
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  
  <script>  
  $(function() {  
    $( "#productName" ).autocomplete({  
      source:'${pageContext.request.contextPath }/product/search'  
    });  
  });  
  </script>  
</head>  
<body>  
<div class="container">
<form th:action="@{/product/product1/search}" class="form-inline">
<div class="ui-widget">  
  
  <input id="productName" name="name">  
  <button class="btn btn-success mb-3" type="submit">Search</button>
  </form>
  <br/><br/><br/><br/>
  <table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="tempEmployee : ${products}">
			
				<td th:text="${tempEmployee.name}" />	
				<td th:text="${tempEmployee.price}" />	
				<td th:text="${tempEmployee.quantity}" />
				<td th:text="${tempEmployee.description}" />	
				</tr>
				</tbody>
		</table>
		</div>
</div>  
</body>  
</html>  