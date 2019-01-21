package com.rio.roombasic

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Movies {
    @PrimaryKey
    @NonNull
    lateinit var movieId: String
    var movieName: String? = null
}