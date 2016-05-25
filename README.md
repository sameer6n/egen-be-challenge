<snippet>
  <content>
# egen-be-challenge
UserManagement System is a webservice which allows users to create a user in json format and post to the webservice 
using any of the available REST clients like POSTMAN. Below are the 4 functionalities of the webservice
1) CreateUser
2) GetAll users
3) Delete a user
4) Update a user Information.


## Installation Steps for Spark Java Frame work
1. Spark Java framework: By adding the Maven dependencies the required jars can be directly included in the project

## MongoDB installation :
1. The installer is Downloaded from `https://www.mongodb.com/download-center#community`
2. Set mongodb working environment `md \data\db`
3. run in command prompt `mongod` 
4. Connect to the server using `mongo`

## Usage
1. Build the project with dependencies and make sure you have the pom.xml setup with required libraries.
2. run UserResource.java 
3. In your RestClient submit requests 
4. Set HTTP method to `get` in postman `http://localhost:4567/users` to get all users.
5. Set HTTP method to `post` in postman `http://localhost:4567/users` and add body as
6. Example body json `{
    "id": "1630215c-2608-44b9-aad4-9d56d8aafd4klwxyz",
    "firstName": "Sameer",
    "lastName": "Nadgouda1",
    "email": "xxxxxxxxx8@gmail.com",
    "address": {
      "street": "valley",
      "city": "north",
      "zip": "000000",
      "state": "ZZ",
      "country": "ZZ"
    },
    "dateCreated": "2016-03-15T07:02:40.896Z",
    "company": {
      "name": "Denesik Group",
      "website": "http://jodie.org"
    },
    "profilePic": "http://lorempixel.com/640/480/people"
  }`
7. For put create a json with required fields for update and submit to required url `http://localhost:4567/users/<userid>` 
8. To remove user set HTTP method to delete and add required url `http://localhost:4567/users/<id to delete>
9. To get a particular user, add required userid in the URL and set HTTP method to get and submit the query.
## Contributing
TODO:
## History
TODO: Write history
## Credits
TODO: Write credits
## License
TODO: Write license
]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>
