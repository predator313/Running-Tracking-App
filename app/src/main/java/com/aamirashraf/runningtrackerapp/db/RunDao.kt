package com.aamirashraf.runningtrackerapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDao {
    //here we do all the sql related work
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run:Run)
    @Delete
    suspend fun deleteRun(run: Run)

    //belows are the sql queries which return the live data
    @Query("Select*from running_table order by timeStamp desc")
    fun allRunSortedByDate():LiveData<List<Run>>
    @Query("Select*from running_table order by timeInMillis desc")
    fun allRunSortedByTimeInMillis():LiveData<List<Run>>
    @Query("Select*from running_table order by caloriesBurned desc")
    fun allRunSortedByCaloriesBurned():LiveData<List<Run>>
    @Query("Select*from running_table order by avgSpeedInKMH desc")
    fun allRunSortedByAvgSpeed():LiveData<List<Run>>
    @Query("Select*from running_table order by distanceOfRunInMeters desc")
    fun allRunSortedByDistance():LiveData<List<Run>>

    //for statistical fragment
    @Query("Select sum(timeInMillis) from running_table")
    fun getTotalTimesInMillis():LiveData<Long>
    @Query("Select sum(caloriesBurned) from running_table")
    fun getTotalCaloriesBurned():LiveData<Int>
    @Query("select sum(distanceOfRunInMeters) from running_table")
    fun getTotalDistance():LiveData<Int>
    @Query("Select sum(avgSpeedInKMH) from running_table")
    fun getTotalAvgSpeed():LiveData<Float>

}