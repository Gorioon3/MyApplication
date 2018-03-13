package aes.gorio.com.myapplication.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import aes.gorio.com.myapplication.view.interdface.onExtClickListener;



/**
 * Class Name MyView
 * Created by Gorio on 2018/3/12.
 *
 * @author Gorio
 * @date 2018 /3/12
 */
public class MyView extends LinearLayout {

    private  TextView tv;
    private  ImageButton ib;
    private onExtClickListener clickListener;

    /**
     * Instantiates a new My view.
     *
     * @param context the context
     * @param text    the text
     * @param imgres  the imgres
     */
    public MyView(Context context,String text,int imgres){
        super(context);
        this.setOrientation(VERTICAL);
        this.tv = new TextView(context);
        tv.setText(text);
        addView(tv,new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        this.ib = new ImageButton(context);
        ib.setImageResource(imgres);
        ib.setOnClickListener(o->{
            if (clickListener != null){
                clickListener.onclickListenr(getText());
            }
        });
        addView(ib,new LinearLayoutCompat.LayoutParams(LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public   void  setText(String text) {
        tv.setText(text);
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public  String getText() {
        return  tv.getText().toString();
    }

    /**
     * Sets image.
     *
     * @param res the res
     */
    public   void  setImage( int  res) {
        ib.setImageResource(res);
    }

    /**
     * Gets drawable.
     *
     * @return the drawable
     */
    public  Drawable getDrawable() {
        return  ib.getDrawable();
    }

    /**
     * Sets drawable.
     *
     * @param dd the dd
     */
    public   void  setDrawable(Drawable dd) {
        ib.setImageDrawable(dd);
    }

    /**
     * Sets on ext click listener.
     *
     * @param click the click
     */
    public   void  setOnExtClickListener(onExtClickListener click) {
        this .clickListener  =  click;
    }

    /**
     * Instantiates a new My view.
     *
     * @param context the context
     */
    public MyView(Context context) {
        super(context);
    }

    /**
     * Instantiates a new My view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Instantiates a new My view.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Instantiates a new My view.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     * @param defStyleRes  the def style res
     */
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
