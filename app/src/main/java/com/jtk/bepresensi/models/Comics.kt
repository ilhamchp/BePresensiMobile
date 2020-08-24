package com.jtk.bepresensi.models

import com.google.gson.annotations.SerializedName

class Comics {
    var year = ""

    @SerializedName("safe_title")
    var title = ""

    @SerializedName("img")
    var gambar = ""
}