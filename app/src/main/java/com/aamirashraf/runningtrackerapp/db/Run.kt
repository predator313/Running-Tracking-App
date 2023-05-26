package com.aamirashraf.runningtrackerapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img:Bitmap?=null,
    var timeStamp:Long=0L,
    var avgSpeedInKMH:Float=0f,
    var distanceOfRunInMeters:Int=0,
    var timeInMillis:Long=0L,
    var caloriesBurned:Int=0

){
    //lets room handle the primary key
    //so we don't prove the primary key in the constructor of the data class
    //but in the body of the dataclass and room here handle the instance of the primary key
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
