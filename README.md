# Installationsbeschreibung:

* Install Java: 
https://www.oracle.com/de/java/technologies/javase-downloads.html 
* Install  IntelliJ:
 https://www.jetbrains.com/de-de/idea/download/#section=windows 
* Install Selenium: 
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java 
* Configure Selenium Jars:
https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
https://mvnrepository.com/artifact/org.testng/testng
https://mvnrepository.com/artifact/org.apache.poi/poi
* Maven installieren: 
https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/ 
* Maven Projekt (quickstart-archetype) erstellen
* Dependencies in Pom.xml hinzufügen.

# RUN:
* Über IntelliJ Studio --> TestNG.xml  mit der rechten Maustaste klicken  RUN /testNG.xml
ODER
* Über cmd --> cd Projekt --> mvn clean --> mvn compile --> mvn test.
1. Dafür soll Maven installiert werden.
2. Man sollte noch der Pfad zum Maven bin-Verzeichnis in die PATH-Umgebungsvariable aufnehmen.
3. Zusätzlich soll Maven Plugin in Pom hinzugefügt werden, sodass der Pom auf testNG.xml zugreifen kann:

```<plugin>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>2.18.1</version>
  <configuration>
    <suiteXmlFiles>
      <suiteXmlFile>testng.xml</suiteXmlFile>
    </suiteXmlFiles>
  </configuration>
</plugin>
```
