This is add product page

<form action="/products" method="post">
	<label for="name">Name: </label> <input type="text" name="name" required/><br>
	<label for="type">Type: </label> <input type="text" name="type" required/><br>
	<label for="description">Description: </description> <br>
	<textarea name="description"></textarea><br>
	<label for="price">Price: </label> <input type="number" name="price" /><br>
	<br><br>
	<input type="submit" value="Add new product" />
</form>