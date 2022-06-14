package com.ukg.services

import com.ukg.Model.Gender
import com.ukg.Model.Jobs
import com.ukg.Model.Location
import com.ukg.Repositories.LoadingDb

class FillingCharts {

    var loadb = LoadingDb()

    fun threeChartPro(): MutableList<Location>{
        var locJobsGender: MutableList<Location> = ArrayList<Location>()

        var resultDb = loadb.LoadingData()
        var i = 0
        resultDb.next()
        var firstTotal = resultDb.getInt(1)
        var firstLocation = resultDb.getString(2)
        var firstJobTitle = resultDb.getString(3)
        var firstGender = resultDb.getString(4)


        var location:Location = Location(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
            if (firstGender == "X") firstTotal else 0, firstLocation)
        location.ListGender.add(Gender(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
                if (firstGender == "X") firstTotal else 0))
        var job: Jobs = Jobs(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
            if (firstGender == "X") firstTotal else 0, firstJobTitle)


        while (resultDb.next()){
            if (firstLocation == resultDb.getString(2)){
                location.Others = location.Others + if (resultDb.getString(4) == "X") resultDb.getInt(1) else 0
                location.Female = location.Female + if (resultDb.getString(4) == "F") resultDb.getInt(1) else 0
                location.Male = location.Male + if (resultDb.getString(4) == "M") resultDb.getInt(1) else 0

                var gender: Gender = Gender(if (resultDb.getString(4) == "F") resultDb.getInt(1) else 0,
                    if (resultDb.getString(4) == "M") resultDb.getInt(1) else 0,
                    if (resultDb.getString(4) == "X") resultDb.getInt(1) else 0)
                location.ListGender.add(gender)

                if (firstJobTitle == resultDb.getString(3)){// keep working on the same job
                    job.Others = job.Others + if (resultDb.getString(4) == "X") resultDb.getInt(1) else 0
                    job.Female = job.Female + if (resultDb.getString(4) == "F") resultDb.getInt(1) else 0
                    job.Male = job.Male + if (resultDb.getString(4) == "M") resultDb.getInt(1) else 0
                }else{
                    location.ListJobs.add(job)// closing the works in the current previous job
                    job = Jobs(if (resultDb.getString(4) == "F") resultDb.getInt(1) else 0,
                        if (resultDb.getString(4) == "M") resultDb.getInt(1) else 0,
                        if (resultDb.getString(4) == "X") resultDb.getInt(1) else 0,
                    resultDb.getString(3))// creating new Job with current resultDb
                    firstJobTitle = resultDb.getString(3)
                }
            }else{
                if(location.ListJobs.find { it.Job == firstJobTitle } == null){
                    location.ListJobs.add(job)
                }
                locJobsGender.add(location)
                firstTotal = resultDb.getInt(1)
                firstLocation = resultDb.getString(2)
                firstJobTitle = resultDb.getString(3)
                firstGender = resultDb.getString(4)


                location = Location(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
                    if (firstGender == "X") firstTotal else 0, firstLocation)
                location.ListGender.add(Gender(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
                    if (firstGender == "X") firstTotal else 0))
                 job = Jobs(if (firstGender == "F") firstTotal else 0, if (firstGender == "M") firstTotal else 0,
                    if (firstGender == "X") firstTotal else 0, firstJobTitle)
            }
        }
        if (location.ListJobs.find { it.Job == firstJobTitle } == null){
            location.ListJobs.add(job)
        }
        if(locJobsGender.find { it.Location == firstLocation}  == null){
            locJobsGender.add(location)
        }
        return locJobsGender
    }
}