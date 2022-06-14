package com.ukg.api

import com.google.gson.Gson
import com.ukg.Model.Demographic
import com.ukg.Model.Location
import com.ukg.Repositories.LoadingDb
import com.ukg.services.FillingCharts
import com.ukg.services.LoadingFiles
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/hello")
class HelloWorldController {

    val files = LoadingFiles()
    val db = FillingCharts()
    val convJson = Gson()

    @GetMapping("/text")
    fun getText():String{
        val demoJson = convJson.toJson(files.loadDemographic())
        return demoJson;
    }
    @GetMapping("/json")
    fun getJson():List<Demographic>{
        return files.loadDemographic();
    }

    @GetMapping("/db-json")
    fun getDbJson():List<Location>{//:List<Location>
        return db.threeChartPro();
    }
}