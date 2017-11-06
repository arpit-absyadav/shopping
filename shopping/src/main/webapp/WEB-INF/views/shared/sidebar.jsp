
<h1 class="my-4">Shop Name</h1>
<div class="list-group" style="font-size: 2em;">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
	</c:forEach>

</div>