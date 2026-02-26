http://localhost:8080/h2-console

#GET
http://localhost:8080/api/countryctrl/findAll
http://localhost:8080/api/countryctrl/findByName/Germany
http://localhost:8080/api/countryctrl/findById/1
http://localhost:8080/api/countryctrl/findLikeByName/Fr%25
http://localhost:8080/api/countryctrl/findLikeByNameJPQL/Fr%25
http://localhost:8080/api/countryctrl/delete/Germany

#POST
http://localhost:8080/api/countryctrl/insert
{
  "countryName":"Spain",
  "population":"40000"
}

http://localhost:8080/api/countryctrl/insertCr
{
  "country": {
  	"countryName":"Italy",
  	"population":"40000"
  },
  "region": {
  	"regionName":"Emilia Romagna",
  	"population":"40000"
}

http://localhost:8080/api/countryctrl/update
{
  "countryName":"Spain",
  "population":"60000"
}