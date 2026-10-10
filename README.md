# Employee API — Spring Boot + GitHub Actions

Java 17, Spring Boot 3.3, Maven. No database or Azure account required.

## Run locally
Open the folder as a Maven project in IntelliJ, select JDK 17, and run `EmployeeApiApplication`.
Alternatively: `mvn spring-boot:run`.

## Try endpoints
- `GET http://localhost:8080/api/employees`
- `POST http://localhost:8080/api/employees` with JSON `{"name":"Asha","department":"Engineering"}`
- `GET http://localhost:8080/api/employees/1`
- `DELETE http://localhost:8080/api/employees/1`

Employees are stored **in memory** and reset on restart.

## Learn GitHub Actions
1. Create a new empty GitHub repository (don't add a README).
2. In this folder: `git init`, `git add .`, `git commit -m "Initial Spring Boot API"`.
3. Add your GitHub remote: `git remote add origin https://github.com/YOUR_USERNAME/employee-api.git`.
4. Run `git branch -M main` and `git push -u origin main`.
5. In GitHub open **Actions** → **Java CI** → select the run. Inspect Checkout, Set up Java, Build and test, and Upload JAR artifact.

The workflow builds/tests on push and pull request. It **does not deploy** to Azure, so no cloud charges or credentials are needed.

## Next lesson
Add unit tests, then introduce Azure App Service deployment using a dedicated test environment and carefully scoped credentials.
