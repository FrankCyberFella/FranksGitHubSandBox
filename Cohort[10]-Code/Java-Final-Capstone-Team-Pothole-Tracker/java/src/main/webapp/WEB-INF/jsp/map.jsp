<%@ include file = "common/header.jspf" %>

<h1>Google Map</h1>
<div id="googleMap" style="width:100%;height:500px;"></div>

<script type="text/javascript">

function myMap(){
	
var locations = [
	<c:forEach var="depression" items="${aPothole}">
    ['${depression.location}', ${depression.latitude}, ${depression.longitude}, '${depression.repairStatus}'],
    </c:forEach>
  ];
	
  var map = new google.maps.Map(document.getElementById('googleMap'), {
    zoom: 10,
    center: new google.maps.LatLng(41.5, -81.59),
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });

  var infowindow = new google.maps.InfoWindow();

  var marker, i;
  
  for (i = 0; i < locations.length; i++) {  
    marker = new google.maps.Marker({
      position: new google.maps.LatLng(locations[i][1], locations[i][2]),
      map: map
    });

    google.maps.event.addListener(marker, 'click', (function(marker, i) {
      return function() {
        infowindow.setContent(locations[i][0] +': '+locations[i][3]);
        infowindow.open(map, marker);
      }
    })(marker, i));
  }
}
</script>


<!-- <ul id = "lat"> -->
<%-- <c:forEach var="depression" items="${aPothole}"> --%>
<%-- <li>${depression.latitude}</li> --%>
<%-- </c:forEach> --%>
<!-- </ul> -->

<!-- <ul id = "long"> -->
<%-- <c:forEach var="depression" items="${aPothole}"> --%>
<%-- <li>${depression.longitude}</li> --%>
<%-- </c:forEach> --%>
<!-- </ul> -->

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoyViqMP1rs6z4IL4fwidAJ2CLeFnMviQ&callback=myMap"></script>
<%@ include file = "common/footer.jspf" %>