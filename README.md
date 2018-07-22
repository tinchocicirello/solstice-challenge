# Solstice Back End Coding Challenge - Contacts REST API
## Installation and setup
For run the application you'll need to have:

- [MySQL](https://dev.mysql.com/downloads/mysql)
- [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

For database connection replace your config in application.properties file

```
spring.datasource.url = jdbc:mysql://{Host_or_IP}:{port}/{schema_name}
spring.datasource.username = {db_username}
spring.datasource.password = {db_password}
```

## Build and Run application

In shell navigate to project, then execute:

```
./gradlew bootRun
```

Note: This will run tests, build and then run the application.

For access de API Docs: http://localhost:8080/swagger.ui.html

## Using the API
### Create a Contact

Make a POST to http://localhost:8080/v1/contacts/create
Requires a message body with the contact data:

```
{
  "name": "Test Contact",
  "birthdate": "1994-06-16",
  "city": "Palermo",
  "state": "Ciudad Autonoma de Buenos Aires",
  "address": "Fake Street 123",
  "company": "Solstice",
  "email": "email@test.com",
  "phones": [
    {
      "number": "+54(011)1537940286",
      "type": "Personal"
    },
    {
      "number": "+54(011)1537940286",
      "type": "Work"
    }
  ],
  "profileImageUrl": "http://images.com/image.jpg"
}
```

If everything works fine, you'll get a response like this:

```
{
  "messageType": "OK"
  "message": "Contact id:{contactId} was succesfully created"
  "contactId": {contactId}
}
```

### Update a Contact

Make a PUT to http://localhost:8080/v1/contacts/update/{contactId}
Requires a message body with the contact data:

```
{
  "name": "Test Contact",
  "birthdate": "1994-06-16",
  "city": "Palermo",
  "state": "Ciudad Autonoma de Buenos Aires",
  "address": "Fake Street 123",
  "company": "Solstice",
  "email": "email@test.com",
  "phones": [
    {
      "number": "+54(011)1537940286",
      "type": "Personal"
    },
    {
      "number": "+54(011)1537940286",
      "type": "Work"
    }
  ],
  "profileImageUrl": "http://images.com/image.jpg"
}
```
If everything works fine, you'll get a response like this:

```
{
  "messageType": "OK"
  "message": "Contact id:{contactId} was succesfully updated"
  "contactId": {contactId}
}
```

### Delete a Contact

Make a DELETE to http://localhost:8080/v1/contacts/delete/{contactId} replacing the {contactId} with the ID of the contact you want to delete

If everything works fine, you'll get a response like this:

```
{
  "messageType": "OK"
  "message": "Contact id:{contactId} was succesfully deleted"
  "contactId": {contactId}
}
```
### Retrieve a Contact by ID

Make a GET to http://localhost:8080/v1/contacts/id/{contactId} replacing the {contactId} with the ID of the contact

### Retrieve a Contact by Email

Make a GET to http://localhost:8080/v1/contacts/email/{email} replacing the {email} with the EMAIL of the contact

### Retrieve a Contact by Phone

Make a GET to http://localhost:8080/v1/contacts/phone/{phone} replacing the {phone} with the PHONE of the contact

### Search all contacts from the same City

Make a GET to http://localhost:8080/v1/contacts/city/{city} replacing the {city} with the CITY you want to search

### Search all contacts from the same State

Make a GET to http://localhost:8080/v1/contacts/state/{state} replacing the {state} with the STATE you want to search

