# This project
This project uses https://github.com/damianszczepanik/cucumber-reporting to generate a fat .jar file (i.e. including all dependencies) which can then be used to generate an HTML report from a Cucumber JSON file (as mentioned at https://cucumber.io/docs/cucumber/reporting/?lang=java).

# Generate fat .jar file
Run the following from the root of the project:
```
./gradlew clean generateFatJar
```

This will output the jar on path `./build/libs/CucumberReportGenerator.jar`

# Use generated fat .jar file
First ensure you have a cucumber JSON file.

Execute `CucumberReportGenerator.jar` with the following arguments:

0. Full path to Cucumber JSON file.
1. Full path to Cucumber report output directory.
2. Project name.

The following arguments are optional:
3. Platform.
4. Browser.

Examples:
```
java -jar ./build/libs/CucumberReportGenerator.jar ./example-cucumber/cucumber.json ./example-cucumber "My project"
java -jar ./build/libs/CucumberReportGenerator.jar ./example-cucumber/cucumber.json ./example-cucumber "My project" Android Chrome
```

Open the report at `<report output directory>/cucumber-html-reports/overview-features.html`
