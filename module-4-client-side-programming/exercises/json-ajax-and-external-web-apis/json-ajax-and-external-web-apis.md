# JSON, AJAX, and External Web APIs

## Listed APIs
* Random User Generator
* REST Country
* MARS Rover Photos
* The Internet Chuck Norris Database 
* Weather Underground
* xkcd

### Random User Generator

The web service generates a random user each time it is called.

**Home Page**

General information, and calling instructions
> 
```
https://randomuser.me`
```

**Request**
>
```
$.ajax({
  url: 'https://randomuser.me/api/',
  dataType: 'json',
  success: function(data){
    console.log(data); // Or whatever
  }
});
```

**Response**

Returns JSON 
>
```
{
  results: [{
    user: {
      gender: "female",
      name: {
        title: "ms",
        first: "manuela",
        last: "velasco"
      },
      location: {
        street: "1969 calle de alberto aguilera",
        city: "la coruña",
        state: "asturias",
        zip: "56298"
      },
      email: "manuela.velasco50@example.com",
      username: "heavybutterfly920",
      password: "enterprise",
      salt: ">egEn6YsO",
      md5: "2dd1894ea9d19bf5479992da95713a3a",
      sha1: "ba230bc400723f470b68e9609ab7d0e6cf123b59",
      sha256: "f4f52bf8c5ad7fc759d1d4156b25a4c7b3d1e2eec6c92d80e508aa0b7946d4ba",
      registered: "1303647245",
      dob: "415458547",
      phone: "994-131-106",
      cell: "626-695-164",
      DNI: "52434048-I",
      picture: {
        large: "http://api.randomuser.me/portraits/women/39.jpg",
        medium: "http://api.randomuser.me/portraits/med/women/39.jpg",
        thumbnail: "http://api.randomuser.me/portraits/thumb/women/39.jpg",
      },
      version: "0.6"
      nationality: "ES"
    },
    seed: "graywolf"
  }]
}
```


### REST Countries

Get information about countries via a RESTful API

**Home Page**

General information, and a listing of the calls available.
>
```
https://restcountries.eu/
```

**Request** 

There are a number of ways to retrieve country information, but only two are shown below, since they all follow the same format.

Retrieve country information using a partial spelling of the country name
>
```
https://restcountries.eu/rest/v1/name/Rus
```
>
Returns JSON objects for Belarus, Cyprus, and Russia

Retrieve country information using a specific country code
>
```
https://restcountries.eu/rest/v1/alpha/cy
```
>
Returns a single JSON object for Cyprus

**Response**

Returns JSON

Note, a number of the the calls can potentially return multiple countries, the resulting JSON objects may be wrapped in a JSON array as shown below.  In the case where the call returns a single country JSON object, it will not be in wrapped inside an array.

``` 
[
    {
        "name": "United States",
        "capital": "Washington D.C.",
        "altSpellings": [
            "US",
            "USA",
            "United States of America"
        ],
        "relevance": "3.5",
        "region": "Americas",
        "subregion": "Northern America",
        "translations": {
            "de": "Vereinigte Staaten von Amerika",
            "es": "Estados Unidos",
            "fr": "États-Unis",
            "ja": "アメリカ合衆国",
            "it": "Stati Uniti D'America"
        },
        "population": 321645000,
        "latlng": [
            38,
            -97
        ],
        "demonym": "American",
        "area": 9629091,
        "gini": 48,
        "timezones": [
            "UTC−12:00",
            "UTC−11:00",
            "UTC−10:00",
            "UTC−09:00",
            "UTC−08:00",
            "UTC−07:00",
            "UTC−06:00",
            "UTC−05:00",
            "UTC−04:00",
            "UTC+10:00",
            "UTC+12:00"
        ],
        "borders": [
            "CAN",
            "MEX"
        ],
        "nativeName": "United States",
        "callingCodes": [
            "1"
        ],
        "topLevelDomain": [
            ".us"
        ],
        "alpha2Code": "US",
        "alpha3Code": "USA",
        "currencies": [
            "USD",
            "USN",
            "USS"
        ],
        "languages": [
            "en"
        ]
    }
]
```

### Mars Rover Photos

Retrieve black-and-white photos taken by the Mars Rover.

**Home Page**

NASA offers a surprising number of APIs. Check them out.
> 
```
https://api.nasa.gov/index.html
```

**Request**

To request Mars Rover photos for a specific day, use the following URL. Set the earth_date (yyyy-m-d) request paramater to the desired day.
>
```
https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2016-3-30&api_key=DEMO_KEY
```

Note, the request makes use of the DEMO_KEY. The DEMO_KEY is limited to 30 calls per hour, and 50 calls per day. Individual keys are available for free.
>
```
https://api.nasa.gov/index.html#apply-for-an-api-key
```

**Response**

Returns JSON

Sorry for the size and formatting of the JSON returned, but it isn't all that difficult to parse, plus, *THEY'RE PICTURES FROM MARS!*.

Note, the number of photos returned can vary from day to day.
>
{"photos":
[
{"id":550612,"sol":1297,"camera":{"id":20,"name":"FHAZ","rover_id":5,"full_name":"Front Hazard Avoidance Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/fcam/FLB_512635476EDR_F0532644FHAZ00323M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550613,"sol":1297,"camera":{"id":20,"name":"FHAZ","rover_id":5,"full_name":"Front Hazard Avoidance Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/fcam/FRB_512635476EDR_F0532644FHAZ00323M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550664,"sol":1297,"camera":{"id":21,"name":"RHAZ","rover_id":5,"full_name":"Rear Hazard Avoidance Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/rcam/RLB_512635509EDR_F0532644RHAZ00323M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550665,"sol":1297,"camera":{"id":21,"name":"RHAZ","rover_id":5,"full_name":"Rear Hazard Avoidance Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/rcam/RRB_512635509EDR_F0532644RHAZ00323M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550668,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637743EDR_S0532644NCAM00546M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550669,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637670EDR_S0532644NCAM00546M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550670,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637597EDR_S0532644NCAM00546M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550671,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637524EDR_S0532644NCAM00546M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550672,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512638071EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550673,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512638033EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550674,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637995EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550675,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637957EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550676,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637919EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550677,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637881EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550678,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637843EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550679,"sol":1297,"camera":{"id":26,"name":"NAVCAM","rover_id":5,"full_name":"Navigation Camera"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ncam/NLB_512637805EDR_M0532644NCAM00567M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550694,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512637075EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550695,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636848EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550696,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636794EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550697,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636567EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550698,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636513EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550699,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636286EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550700,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636232EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550701,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512636006EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}},{"id":550702,"sol":1297,"camera":{"id":23,"name":"CHEMCAM","rover_id":5,"full_name":"Chemistry and Camera Complex"},"img_src":"http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01297/opgs/edr/ccam/CR0_512635952EDR_F0532644CCAM04296M_.JPG","earth_date":"2016-03-30","rover":{"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1298,"max_date":"2016-03-31","total_photos":246872,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}}
]
}

### The Internet Chuck Norris Database 

Who doesn't love Chuck Norris jokes? Especially, if you can insert your name, or the name of a friend or loved one into it.

**Home Page**

General information.
>
```
http://www.icndb.com 
```
See API for more information
>
```
http://www.icndb.com/api/
```

**Request**

There are several ways to access and modify the jokes outlined on the API page. Only obtaining a random is shown below. 
>
```
http://api.icndb.com/jokes/random/
```

Channel your inner Chuck, and in the grand tradition of the master, roundhouse kick the rest of the calls into submission.

**Response**

Returns JSON

Note, the calls may return multiple jokes, in which case, they are wrapped in a JSON array as shown below.  In the case where the call returns a single joke JSON object, it will not be in wrapped inside an array.
>
```
{ 
	"type": "success", 
	"value": 
		[ 
			{ "id": 162, "joke": "Once you go Norris, you are physically unable to go back.", "categories": [] },
			{ "id": 240, "joke": "In a fight between Batman and Darth Vader, the winner would be Chuck Norris.", "categories": [] } 
		]  
}
```

### Weather Underground

Weather information from around the world.

**Home Page**

General information.
>
```
https://www.wunderground.com/
```

API documentation.
>
```
https://www.wunderground.com/weather/api/d/docs
```

**Request**

There are a number of calls available. The simpliest is getting the current weather for a given city in the US.  For instance, the following askes for Cleveland, OH.
>
```
http://api.wunderground.com/api/api-key/conditions/q/OH/Cleveland.json
```

Tech Elevator's limited api-key: ff29edd8a8808b08

**Response**

Returns JSON

```
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "conditions": 1
  }
	}
  ,	"current_observation": {
		"image": {
		"url":"http://icons.wxug.com/graphics/wu2/logo_130x80.png",
		"title":"Weather Underground",
		"link":"http://www.wunderground.com"
		},
		"display_location": {
		"full":"Cleveland, OH",
		"city":"Cleveland",
		"state":"OH",
		"state_name":"Ohio",
		"country":"US",
		"country_iso3166":"US",
		"zip":"44101",
		"magic":"1",
		"wmo":"99999",
		"latitude":"41.49306870",
		"longitude":"-81.66831970",
		"elevation":"210.00000000"
		},
		"observation_location": {
		"full":"LeanDog, Cleveland, Ohio",
		"city":"LeanDog, Cleveland",
		"state":"Ohio",
		"country":"US",
		"country_iso3166":"US",
		"latitude":"41.510742",
		"longitude":"-81.691978",
		"elevation":"574 ft"
		},
		"estimated": {
		},
		"station_id":"KOHCLEVE65",
		"observation_time":"Last Updated on April 1, 11:48 AM EDT",
		"observation_time_rfc822":"Fri, 01 Apr 2016 11:48:00 -0400",
		"observation_epoch":"1459525680",
		"local_time_rfc822":"Fri, 01 Apr 2016 11:48:09 -0400",
		"local_epoch":"1459525689",
		"local_tz_short":"EDT",
		"local_tz_long":"America/New_York",
		"local_tz_offset":"-0400",
		"weather":"Overcast",
		"temperature_string":"44.5 F (6.9 C)",
		"temp_f":44.5,
		"temp_c":6.9,
		"relative_humidity":"85%",
		"wind_string":"From the ESE at 13.0 MPH",
		"wind_dir":"ESE",
		"wind_degrees":108,
		"wind_mph":13.0,
		"wind_gust_mph":0,
		"wind_kph":20.9,
		"wind_gust_kph":0,
		"pressure_mb":"1004",
		"pressure_in":"29.64",
		"pressure_trend":"+",
		"dewpoint_string":"40 F (5 C)",
		"dewpoint_f":40,
		"dewpoint_c":5,
		"heat_index_string":"NA",
		"heat_index_f":"NA",
		"heat_index_c":"NA",
		"windchill_string":"38 F (3 C)",
		"windchill_f":"38",
		"windchill_c":"3",
		"feelslike_string":"38 F (3 C)",
		"feelslike_f":"38",
		"feelslike_c":"3",
		"visibility_mi":"10.0",
		"visibility_km":"16.1",
		"solarradiation":"--",
		"UV":"2","precip_1hr_string":"0.00 in ( 0 mm)",
		"precip_1hr_in":"0.00",
		"precip_1hr_metric":" 0",
		"precip_today_string":"0.00 in (0 mm)",
		"precip_today_in":"0.00",
		"precip_today_metric":"0",
		"icon":"cloudy",
		"icon_url":"http://icons.wxug.com/i/c/k/cloudy.gif",
		"forecast_url":"http://www.wunderground.com/US/OH/Cleveland.html",
		"history_url":"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=KOHCLEVE65",
		"ob_url":"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=41.510742,-81.691978",
		"nowcast":""
	}
}
```

### xkcd 

Get any xkcd cartoon.

**Home Page**

API documentation (in the the form of a cartoon, of course)
>
```
https://xkcd.com/1481/
```

**Request**

There are really only two requests possible, today's
>
```
http://xkcd.com/info.0.json
```

or a previous, for instance, number 614.
>
```
http://dynamic.xkcd.com/api-0/jsonp/comic/614
```

**Response**

Returns JSON
>
```
{
	"month": "3", 
	"num": 1662, 
	"link": "", 
	"year": "2016", 
	"news": "", "safe_title": 
	"Jack and Jill", "transcript": "", 
	"alt": "Jill and Jack \/ began to frack. \/ The oil boosts their town. \/ But fractures make \/ the bedrock shake \/ and Jack came tumbling down.",
	"img": "http:\/\/imgs.xkcd.com\/comics\/jack_and_jill.png", 
	"title": "Jack and Jill", 
	"day": "30"
}
```