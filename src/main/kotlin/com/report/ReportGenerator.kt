package com.report

import net.masterthought.cucumber.Configuration
import net.masterthought.cucumber.ReportBuilder
import java.io.File

object ReportGenerator {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 3) {
            val exceptionMessage = """
                
                
                Please supply the following mandatory arguments:
                0. Full path to cucumber JSON file.
                1. Full path to Cucumber HTML out directory.
                2. Project name.
                
                The following arguments are optional:
                3. Platform.
                4. Browser.
                
                Examples:
                java -jar ./build/libs/CucumberReportGenerator.jar ./cucumber.json ./ "My project"
                java -jar ./build/libs/CucumberReportGenerator.jar ./cucumber.json ./ "My project" Android Chrome
             
            """.trimIndent()

            throw Exception(exceptionMessage)
        }

        val jsonReportPath = args[0]
        val reportOutputDirectory = File(args[1])
        val projectName = args[2]

        val config = Configuration(reportOutputDirectory, projectName)
        if (args.size > 3) {
            config.addClassifications("Platform", args[3])
        }
        if (args.size > 4) {
            config.addClassifications("Browser", args[4])
        }

        val jsonFiles = ArrayList<String>()
        jsonFiles.add(jsonReportPath)

        val reportBuilder = ReportBuilder(jsonFiles, config)
        reportBuilder.generateReports()
    }
}
