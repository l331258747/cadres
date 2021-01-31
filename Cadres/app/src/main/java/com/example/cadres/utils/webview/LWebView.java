package com.example.cadres.utils.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name: LWebView.java
 * <p>
 * Function:
 * <p>
 * version 1.0
 * since  2017/02/13 13:57
 */

public class LWebView extends WebView {
    private View mErrorView;
    private Context context;

    public LWebView(Context context) {
        this(context, null);
    }

    public LWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public LWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     *
     */
    private void init() {
        /*
             支持Js
             setting.setJavaScriptEnabled(true);

             设置自适应屏幕，两者合用
             //将图片调整到适合webview的大小 settings.setUseWideViewPort(true);
             // 缩放至屏幕的大小   settings.setLoadWithOverviewMode(true);

             缩放操作
             // 是否支持画面缩放，默认不支持 settings.setBuiltInZoomControls(true); setting.setSupportZoom(true);
             // 是否显示缩放图标，默认显示  settings.setDisplayZoomControls(false);
             // 设置网页内容自适应屏幕大小  settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

             设置允许JS弹窗
             settings.setJavaScriptCanOpenWindowsAutomatically(true);
             settings.setDomStorageEnabled(true);

             关闭webview中缓存
             settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

             设置可以访问文件
             settings.setAllowFileAccess(true);
             settings.setAllowFileAccessFromFileURLs(true);
             settings.setAllowUniversalAccessFromFileURLs(true);
         */


        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);//支持js
        settings.setDisplayZoomControls(false); // 关闭自动缩放
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR); //  自适应屏幕处理，不设置，低分辨率显示异常
        settings.setDefaultTextEncodingName("utf-8");

        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setDomStorageEnabled(true); // h5 本地缓存 //设置DOM Storage缓存
        settings.setDatabaseEnabled(true); //启用数据库

        this.setVerticalScrollBarEnabled(false);
        this.setVerticalScrollbarOverlay(false);
        this.setHorizontalScrollBarEnabled(false);
        this.setHorizontalScrollbarOverlay(false);


        setWebViewClient(new MyWebViewClient(this));

//        setWebViewClient(new WebViewClient() {
//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                view.loadUrl("file:///android_asset/error.html");
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                // 不重写会调用系统浏览器
//                view.loadUrl(url);
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//
//            }
//        });
    }


    /**
     * 获取html中的所有图片
     * @param compatText
     * @return
     */
    public static List<String> filterImages(String compatText){
        List<String> uList = new ArrayList<>();
        if(!TextUtils.isEmpty(compatText)&&compatText.contains("<img")){
            //get img src
            Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
            Matcher m = p.matcher(compatText);
            String searchAttrib = "src";
            String regxpForTagAttrib = searchAttrib + "\\s*=\\s*[\"|']http://([^\"|']+)[\"|']";//"=[\"|']([^[\"|']]+)[\"|']";
            Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);
            while(m.find()){
                Matcher matcherForAttrib = patternForAttrib.matcher(m.group());
                if (matcherForAttrib.find()) {
                    System.out.println("poe " +"http://" +matcherForAttrib.group(1));
                    uList.add("http://" +matcherForAttrib.group(1));
                }
            }
        }
        return  uList;
    }

    /** 获取图片字符串中所有链接 */
    public Set<String> getImgStr(String htmlStr) {
        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)")
                    .matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

}
