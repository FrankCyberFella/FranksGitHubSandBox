<%@ include file="common/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Employee View</h1>
<div id="pothole_main">
	<c:forEach var="depression" items="${aPothole}">
		<div id="pothole_div">
			<div id="pothole_text">
				<h5>
					<b>Location:</b> ${depression.location}
				</h5>
				<br>
				<h5>
					<b>Size:</b> ${depression.size}
				</h5>
				<br>
				<h5>
					<b>Date Reported:</b> ${depression.dateReported}
				</h5>
				<br>
				<h5>
					<b>Repair Status:</b> ${depression.repairStatus}
				</h5>
				<h5>
					<b>Severity:</b> ${depression.severity}
				</h5>
				
				<h2>Update Status</h2>

				<button class="accordion">Inspected</button>
				<div class="panel">
				  <c:url var="action" value="/empPotholes" />
				  <form:form action="${action}" method="POST" modelAttribute="Pothole">
				  Severity:
				  <form:select path="severity" name="severity" id="size_select">
						<form:option value="1"></form:option>
						<form:option value="2"></form:option>
						<form:option value="3"></form:option>
						<form:option value="4"></form:option>
						<form:option value="5"></form:option>
					</form:select>
					<input class="potholeSubmitButton" type="submit"
						value="Update Pothole" />
					<input type="hidden" value="${depression.potholeId}"
						name="potholeId" />
					<input type="hidden" value="Inspected"
						name="repairStatus" />
					<input type="hidden" value="update"
						name="formValue" />
				  </form:form>
				</div>
				
				<button class="accordion">Repaired</button>
				<div class="panel">
				  <c:url var="action" value="/empPotholes" />
				  <form:form action="${action}" method="POST" modelAttribute="Pothole">
				  <input class="potholeSubmitButton" type="submit"
						value="Pothole Repaired" />
					<input type="hidden" value="${depression.potholeId}"
						name="potholeId" />
					<input type="hidden" value="Repaired"
						name="repairStatus" />
					<input type="hidden" value="repaired"
						name="formValue" />
					<input type="hidden" value="0"
						name="severity" />
				  </form:form>
				</div>
				<button class="accordion">Delete Duplicate</button>
				<div class="panel">
				  <c:url var="action" value="/empPotholes" />
				  <form:form action="${action}" method="POST" modelAttribute="Pothole">
					<input type="hidden" value="${depression.potholeId}"
						name="potholeId" />
					<input type="hidden" value="delete"
						name="formValue" />
					 <input class="potholeSubmitButton" type="submit"
						value="Delete Pothole" />
				  </form:form>
				</div>

				
				</div>

			</div>
</c:forEach>
</div>
		
	

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>

<%@ include file="common/footer.jspf"%>