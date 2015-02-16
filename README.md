# DatabaseConnection
A simple way to perform database operations with Java and MySQL

## Usage
You can either extract the connector jar file into your workspace or add it to your project (in case you're using an IDE), then add the package `dbConnection` to your workspace/project, edit the ConnectionParameters.java file to fit your needs:
* Set the `dbURL` parameter to the address of the db host
* Set the `database`, `username` and `password` parameters according to your access credentials

After that just add `import dbConnection.DBOperation;` in the class that needs access to the database and use the DBOperation class methods.