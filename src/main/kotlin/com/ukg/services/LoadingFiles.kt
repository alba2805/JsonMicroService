package com.ukg.services

import com.ukg.Model.Demographic
import java.io.File

class  LoadingFiles {
     fun loadDemographic(): MutableList<Demographic>{
        var demogs: MutableList<Demographic> = ArrayList<Demographic>()
        try {
            val fileName = "Pro_Demographic_Csv_Fact.csv"
            var lines : List<String> = File(fileName).readLines()
            for (i in lines.indices){
                if ( i > 0){
                    var newLine = lines.get(i).split(",")
                    var demo = Demographic(newLine[0].trim(), newLine[1], newLine[2].toInt(), newLine[3].toInt(), newLine[4].toInt(),
                        newLine[5],newLine[6],newLine[7].toInt())
                    demogs.add(demo)
                }
            }
        }catch (e : java.lang.Exception){
            e.printStackTrace()
        }
        return demogs
    }
}