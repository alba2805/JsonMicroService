package com.ukg.Model

class Demographic {
    var Ethnicity: String
    var Gender: String
    var IsDisabled: Int
    var Age: Int
    var AgeCategory: Int
    var EmployeeStatus: String
    var Date: String
    var Count: Int

    constructor(ethnicity: String, gender: String, isDisabled: Int, age: Int, ageCategory: Int, employeeStatus: String,
                date: String, count: Int){
        this.Ethnicity = ethnicity
        this.Gender = gender
        this.IsDisabled = isDisabled
        this.Age = age
        this.AgeCategory = ageCategory
        this.EmployeeStatus = employeeStatus
        this.Date = date
        this.Count = count
    }

}