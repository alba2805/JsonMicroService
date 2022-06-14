package com.ukg.Model

class Jobs : Gender {
    var Job: String

    constructor(f: Int, m: Int, o: Int, job: String) : super(f, m, o){
        Job = job
    }
}