<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/style.css" rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Error</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template alert alert-danger">
					<h2>Oops!</h2>
					<div class="error-details">
						Sorry, an <strong>error</strong> has occured!
					</div>
					<div class="error-details">
						<h2>Message:</h2>
						${ errorMessage }
					</div>
					<br><a href="index.jsp">Go back to main page.</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>