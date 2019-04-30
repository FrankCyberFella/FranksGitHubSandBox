package com.techelevator.ssg.model.planets;

public class PlanetDistance {
	
	double earthToMercury = 56974146.00;
	double earthToVenus = 25724767.00;
	double earthToMars = 48678219.00;
	double earthToJupiter = 390674710.00;
	double earthToSaturn = 792248270.00;
	double earthToUranus = 1692662530.00;
	double earthToNeptune = 2703959960.00;
	double calculation = 0.0;
	
	public double planetDistanceCalculation (String selectPlanet, String selectVehicle) {
		
		if(selectPlanet.equals("mercury")) {
			if(selectVehicle.equals("walking")) {
			calculation = (earthToMercury/3.0)/8760.0;
			}
			if(selectVehicle.equals("car")) {
			calculation = (earthToMercury/100.0)/8760.0;
			}
			if(selectVehicle.equals("bulletTrain")) {
			calculation = (earthToMercury/200.0)/8760.0;
			}
			if(selectVehicle.equals("boeing747")) {
			calculation = (earthToMercury/570.0)/8760.0;
			}
			if(selectVehicle.equals("concorde")) {
			calculation = (earthToMercury/1350.0)/8760.0;
			}
		}
		if(selectPlanet.equals("venus")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToVenus/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToVenus/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToVenus/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToVenus/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToVenus/1350.0)/8760.0;
				}
		}
		
		if(selectPlanet.equals("mars")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToMars/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToMars/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToMars/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToMars/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToMars/1350.0)/8760.0;
				}
		}
		if(selectPlanet.equals("jupiter")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToJupiter/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToJupiter/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToJupiter/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToJupiter/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToJupiter/1350.0)/8760.0;
				}
		}
		if(selectPlanet.equals("saturn")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToSaturn/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToSaturn/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToSaturn/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToSaturn/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToSaturn/1350.0)/8760.0;
				}
		}
		if(selectPlanet.equals("uranus")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToUranus/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToUranus/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToUranus/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToUranus/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToUranus/1350.0)/8760.0;
				}
		}
		if(selectPlanet.equals("neptune")) {
			if(selectVehicle.equals("walking")) {
				calculation = (earthToNeptune/3.0)/8760.0;
				}
				if(selectVehicle.equals("car")) {
				calculation = (earthToNeptune/100.0)/8760.0;
				}
				if(selectVehicle.equals("bulletTrain")) {
				calculation = (earthToNeptune/200.0)/8760.0;
				}
				if(selectVehicle.equals("boeing747")) {
				calculation = (earthToNeptune/570.0)/8760.0;
				}
				if(selectVehicle.equals("concorde")) {
				calculation = (earthToNeptune/1350.0)/8760.0;
				}
		}
	
		return calculation;
	} 
	
	public double getEarthToMercury() {
		return earthToMercury;
	}
	public double getEarthToVenus() {
		return earthToVenus;
	}
	public double getEarthToMars() {
		return earthToMars;
	}
	public double getEarthToJupiter() {
		return earthToJupiter;
	}
	public double getEarthToSaturn() {
		return earthToSaturn;
	}
	public double getEarthToUranus() {
		return earthToUranus;
	}
	public double getEarthToNeptune() {
		return earthToNeptune;
	}
	
}
