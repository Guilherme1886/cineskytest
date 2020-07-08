package com.gui.antonio.cinesky.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Movies {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
    var title: String? = null
    var overview: String? = null
    var duration: String? = null
    @SerializedName(value = "release_year")
    var releaseYear: String? = null
    @SerializedName(value = "cover_url")
    var coverUrl: String? = ""
    @Ignore
    var backdropsUrl: List<String>? = null

}