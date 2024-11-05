package com.kotlin.newsapplication.db

import androidx.room.TypeConverter
import com.kotlin.newsapplication.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source? {
        val source = Source(name, name)
        return source
    }
}