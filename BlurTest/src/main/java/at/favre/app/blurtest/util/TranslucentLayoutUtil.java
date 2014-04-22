package at.favre.app.blurtest.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import at.favre.app.blurtest.R;

/**
 * Created by PatrickF on 22.04.2014.
 */
public class TranslucentLayoutUtil {
	public static void setTranslucentThemeInsets(Activity context, View view) {

		SystemBarTintManager tintManager = new SystemBarTintManager(context);
		SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			view.setPadding(0, config.getPixelInsetTop(true) + config.getStatusBarHeight(), config.getPixelInsetRight(), config.getPixelInsetBottom());
		} else {
			view.setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height), 0, 0);
		}
	}

	public static void setTranslucentThemeInsetsWithoutActionbarHeight(Activity context, View view) {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;

		SystemBarTintManager tintManager = new SystemBarTintManager(context);
		SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
		view.setPadding(0, config.getPixelInsetTop(false)+ config.getStatusBarHeight(), config.getPixelInsetRight(), config.getPixelInsetBottom());
	}
}
