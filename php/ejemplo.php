<!DOCTYPE html>
<html>
<head>
<title>page Title</title>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/codigo.js"></script>
</head>
<body>
<?php
echo "My first PHP script!";
?>

<?php
$t = date("H");

if ($t < "24") {
echo "Have a good day!";
} else {
echo "Have a good afternoon!";
}
?>

<h1> This is a Haead</h1>
<p>This is a paragraph</p>

</body>
</html>
