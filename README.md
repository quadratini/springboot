# Springboot dev

## Getting started

### MySQL

1. Install MySQL https://dev.mysql.com/downloads/mysql/ and select version 8.0.34
2. In the installer, be sure to download MySQL workbench and MySQL server
3. Don't need to install the MySQL command line one
4. Also be sure to add a user during the installation, the user "springstudent" and password "springstudent"
5. If "springstudent" wasn't added during installation, can be added through MySQL workbench directly
6. Create a student_tracker schema/database in workbench
7. Run the main application, (CruddemoApplication.java) and the tables will be created
8. Open localhost:8080 on browser

### Maven

1. The Maven plugin should be installed when cloning the project, if using IntelliJ,
   click reload all maven projects to update all required dependencies
2. Select the main application and run
3. Note: look up how to reload maven if you don't know how to.

## Springboot devtools

1. Go to Intellij Advanced settings and enable "Allow auto-make to start..."
2. Also enable "build project automatically"
3. Tip: can do a search for these settings using settings search