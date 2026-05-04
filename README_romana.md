DemoBlaze Automation Framework

Framework de automatizare end to end pentru testarea aplicației DemoBlaze, construit în Java + Selenium WebDriver + TestNG, cu rapoarte Allure și pipeline CI/CD în GitHub Actions.
Tehnologii folosite
•	Java 
•	Selenium WebDriver 
•	TestNG 
•	WebDriverManager 
•	Allure TestNG + Allure Maven Plugin
•	Maven
•	GitHub Actions (CI/CD)

Structura proiectului
src
 ├── main
 │    └── java
 │         └── org.example
 │              ├── BasePage.java
 │              ├── CartPage.java
 │              ├── HomePage.java
 │              ├── LoginPage.java
 │              ├── Main.java
 │              ├── ProductDetailsPage.java
 │              └── ProductsPage.java
 │
 │
 │
 └── test
      └── java
           └── org.example
                ├── BaseTest.java
                └── LoginTest.java
                
src/main/java/org.example
Conține codul framework ului:
•	BasePage – metode comune pentru toate paginile (click, wait, alerts etc.)
•	HomePage – acțiuni și elemente din pagina principală
•	LoginPage – login/logout + validări
•	ProductsPage – listă produse, navigare, selectare produs
•	ProductDetailsPage – detalii produs, add to cart
•	CartPage – verificare coș, confirmare



src/test/java/org.example
Conține testele:
•	BaseTest – setup WebDriver, teardown, configurări TestNG
•	LoginTest – scenarii de login/logout

1.Rulez testul din IntelijjIDEA-Terminal:
mvn clean test 
2. Generez raportul Allure:
allure serve allure-results

Rapoarte Allure în GitHub Actions:
Pipeline-ul generează automat:
•	allure-results
•	allure-report (HTML complet)
Le găsești în secțiunea Actions → Artifacts.

CI/CD Workflow (GitHub Actions)
Pipeline-ul rulează:
•	checkout cod
•	setup JDK
•	instalare Chrome
•	rulare teste
•	generare raport Allure
•	upload artifacte
Workflow-ul este complet automatizat la fiecare push pe master.

Ce am învățat în acest proiect
•	Cum să construiesc un framework POM modular
•	Cum să gestionez WebDriver și ChromeDriver în mod stabil
•	Cum să rezolv erori reale (stale elements, JS click, alert handling)
•	Cum să integrez Allure în Maven și GitHub Actions
•	Cum să configurez un pipeline CI/CD profesionist

Funcționalități implementate
•	Login / Logout
•	Navigare prin categorii
•	Deschidere produs
•	Adăugare în coș
•	Validare mesaje și alerte
•	Teste end to end stabile
