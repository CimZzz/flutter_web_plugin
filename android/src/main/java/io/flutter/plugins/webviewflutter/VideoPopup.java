package io.flutter.plugins.webviewflutter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;

/**
 * Anchor : Create by CimZzz
 * Time : 2020/8/10 21:34:35
 * Project : webview-flutter
 * Since Version : Alpha
 * VideoPopup
 */
public class VideoPopup extends Dialog {
    private final View proxyView;
    public VideoPopup(@NonNull Context context, View proxyView) {
        super(context);
        this.proxyView = proxyView;
        Window window = getWindow();
        requestWindowFeature(Window. FEATURE_NO_TITLE);  //去掉dialog的title
        window.addFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN);  //全屏的flag
        window.setBackgroundDrawableResource(android.R.color.transparent); //设置window背景透明
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 1.0f;
        lp.dimAmount = 0.0f; //dimAmount在0.0f和1.0f之间，0.0f完全不暗，1.0f全暗
        window.setAttributes(lp);
    }

    @Override
    public void show() {
        super.show();
        FrameLayout viewGroup = new FrameLayout(getContext());
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(viewGroup);
        viewGroup.addView(proxyView);
    }
}
