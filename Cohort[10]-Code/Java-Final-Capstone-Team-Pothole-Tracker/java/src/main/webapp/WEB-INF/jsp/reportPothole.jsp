<%@ include file = "common/header.jspf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:url var="action" value="/reportPothole" />
<form:form action="${action}" method="POST" modelAttribute="Pothole">
<p id="pothole-button">Please Click On Pothole Location You Wish To Report:</p>

<div id="googleMap" style="width:100%;height:500px;"></div>

<script type="text/javascript">
function myMap() {
	
 var mapProp= {
		
  center:new google.maps.LatLng(41.5050104,-81.6400623),
  zoom:10, 
}; 
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

google.maps.event.addListener(map, 'click', function(e) {
    placeMarker(e.latLng, map);
  });
  
google.maps.event.addListener(map, "click", function (event) {
    var latitude = event.latLng.lat();
    var longitude = event.latLng.lng();
    console.log( latitude + ', ' + longitude );
    document.getElementById('longitude').setAttribute('value', longitude);
    document.getElementById('latitude').setAttribute('value', latitude);
    event.removeEventListener('click', event, false);
});

  function placeMarker(position, map) {
    var marker = new google.maps.Marker({
      position: position,
      map: map
    });  
    map.panTo(position);
   
  }

  
  
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoyViqMP1rs6z4IL4fwidAJ2CLeFnMviQ&callback=myMap"></script>

<input type="hidden" value="" id="latitude" name="latitude"/>
<input type="hidden" value="" id="longitude" name="longitude"/>
<br>
<br>
<p id="pothole-button">Location Description:</p>
<input type="text" name="location"/>

<p id="pothole-button">Select Pothole Size:</p> <form:select path="size" name="size" id="size_select">
			<form:option value="" selected="selected"></form:option>
			<form:option value="Small"></form:option>
			<form:option value="Medium"></form:option>
			<form:option value="Large"></form:option>

</form:select>

<br>
<br>


<br>
<input id="submission" class="potholeSubmitButton" type="submit" value="SUBMIT POTHOLE"/>
</form:form>


<%@ include file = "common/footer.jspf" %>