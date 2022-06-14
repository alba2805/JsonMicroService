package com.ukg.Model

class Location : Gender {
    var ListGender: MutableList<Gender>
    var ListJobs: MutableList<Jobs>
    var Location: String

    constructor(f: Int, m: Int, o: Int, location: String) : super(f, m, o){
        ListGender = ArrayList<Gender>()
        ListJobs =  ArrayList<Jobs>()
        Location = location
    }
}