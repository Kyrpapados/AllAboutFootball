package kyrpapados.footballapp.utils.helper

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.support.annotation.ColorInt

class UIHelper {
    companion object {
        fun drawCircle(@ColorInt color: Int): ShapeDrawable {
            val oval = ShapeDrawable(OvalShape())
            oval.paint.color = color
            return oval
        }
    }

}