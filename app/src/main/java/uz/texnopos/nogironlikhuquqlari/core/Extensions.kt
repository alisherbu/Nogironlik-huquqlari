package uz.texnopos.nogironlikhuquqlari.core

import android.content.Context
import android.content.res.Resources
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import uz.texnopos.nogironlikhuquqlari.App
import uz.texnopos.nogironlikhuquqlari.App.Companion.sharedPrefUtils
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.ui.settings.Settings

inline fun <T : View> T.onClick(crossinline func: T.() -> Unit) = setOnClickListener { func() }
fun getSharedPreferences(): SharedPrefUtils {
    return if (sharedPrefUtils == null) {
        sharedPrefUtils = SharedPrefUtils()
        sharedPrefUtils!!
    } else sharedPrefUtils!!
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun createDynamicViews(
    htmlText: String, context: Context, linearLayout: LinearLayout,
    textList: MutableList<TextView> = mutableListOf()
) {
    //////////////Qay jerde text qay jerde suwret ekenin tawip aliw//////////////////
    val face = ResourcesCompat.getFont(context, R.font.times)
    val textPair: MutableList<Pair<Int, Int>> = mutableListOf()
    val imagePair: MutableList<Pair<Int, Int>> = mutableListOf()
    var string = htmlText
    var i1 = string.indexOf('{')
    var i2 = -1
    while (i1 != -1) {
        textPair.add(Pair(i2 + 1, i1 - 1))
        i2 = string.indexOf('}')
        val chars = string.toCharArray()
        chars[i1] = '*'
        chars[i2] = '*'
        string = String(chars)
        imagePair.add(Pair(i1 + 1, i2))
        i1 = string.indexOf('{')
    }
    textPair.add(Pair(i2 + 1, string.length - 1))
    /////////////////////////////////////////////////////////////////////////////////
    for (i in 0 until textPair.size-1) {
        if (textPair[i].first < textPair[i].second) {
            val textView = TextView(context)
            textList.add(textView)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
            textView.layoutParams = params
            textView.textSize = Settings.textSize
            textView.typeface = face
            textView.movementMethod = LinkMovementMethod.getInstance()
            textView.text = HtmlCompat.fromHtml(
                string.substring(textPair[i].first, textPair[i].second),
                HtmlCompat.FROM_HTML_MODE_COMPACT
            )
             linearLayout.addView(textView)
        }
        if (imagePair[i].first < imagePair[i].second) {
            val imageView = ImageView(context)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300.dp)
            params.setMargins(16.dp, 0.dp, 16.dp, 0.dp)
            imageView.layoutParams = params
            val id = context.resources.getIdentifier(
                string.substring(
                    imagePair[i].first,
                    imagePair[i].second
                ), "drawable", context.packageName
            )
//            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView.setImageResource(id)
            linearLayout.addView(imageView)
        }
    }
    val i = textPair.size - 1
    if (textPair[i].first < textPair[i].second) {
        val textView = TextView(context)
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        params.setMargins(16.dp, 8.dp, 16.dp, 8.dp)
        textView.layoutParams = params
        textView.textSize = Settings.textSize
        textView.typeface = face
        textView.movementMethod = LinkMovementMethod.getInstance()
        textList.add(textView)
        textView.text = HtmlCompat.fromHtml(
            string.substring(textPair[i].first, textPair[i].second),
            HtmlCompat.FROM_HTML_MODE_COMPACT
        )
       if(textView.text.isNotEmpty()) linearLayout.addView(textView)
    }
}

private fun getWidth(): Int {
    val display = Resources.getSystem().displayMetrics
    return display.widthPixels
}
