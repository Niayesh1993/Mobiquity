package xyz.zohre.presentation_shared

sealed class TextData {
    class TextStringRes(val resId: Int) : TextData()
    class TextString(val text: String) : TextData()
}
