package com.torrez.flowpayapp.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun obtenerFechaActual(): String {
    return SimpleDateFormat(
        "dd-MM-yyyy",
        Locale.getDefault()
    ).format(Date())
}