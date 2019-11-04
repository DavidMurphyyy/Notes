package org.wit.note.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoteModel(var id: Long = 0,
                          var title: String = "",
                          var description: String = "") : Parcelable

