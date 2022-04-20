package xyz.zohre.presentation

import android.view.View
import com.google.android.material.snackbar.Snackbar
import xyz.zohre.presentation_shared.R

fun parseErrorStringRes(): TextData {

    return TextData.TextStringRes(R.string.show_error)

}

fun TextData.shortToast(view: View) {
    when (this) {
        is TextData.TextString -> Snackbar.make(view, this.text, Snackbar.LENGTH_LONG).show()
        is TextData.TextStringRes -> Snackbar.make(view, this.resId, Snackbar.LENGTH_LONG).show()
    }


}