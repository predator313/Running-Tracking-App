package com.aamirashraf.runningtrackerapp.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {
    @TypeConverter
    fun fromBitmap(bmp:Bitmap):ByteArray{
        val outputStream=ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return outputStream.toByteArray()
    }
    @TypeConverter
    fun toBitmap(value:ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(value,0,value.size)
    }
}