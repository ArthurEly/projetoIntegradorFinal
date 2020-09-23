package br.com.senac.pif_mobile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import br.com.senac.pif_mobile.R;


/**
 * NÃO UTILIZADO POR CONTER BUGS FATAIS
 */
public class DottedEditText extends LinearLayout {
    private AttributeSet attr;
    private int fields = 2;
    private String separator = ".";
    private ArrayList<EditText> editors;
    private ArrayList<TextView> editor_texts;

    public void init() {
        editors = new ArrayList<EditText>();
        editor_texts = new ArrayList<TextView>();

        setOrientation(HORIZONTAL);

        if (attr != null) {
            TypedArray a = getContext().obtainStyledAttributes(attr, R.styleable.DottedEditText, 0, 0);
            fields = a.getInt(R.styleable.DottedEditText_fields,2);
            separator = a.getString(R.styleable.DottedEditText_separator);
        }

        for (int x = 0; x < (fields - 1);x++) {
            editors.add(x,new EditText(getContext()));
            editors.get(x).setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1.0f));
        }

        for (int x = 0; x < (fields - 2); x++) {
            editor_texts.add(x, new TextView(getContext()));
            editor_texts.get(x).setText(separator);
        }

        for (int x = 0; x < (fields - 1); x++) {
            addView(editors.get(x));
            if (editor_texts.get(x) != null) {
                addView(editor_texts.get(x));
            }
        }
    }

    public DottedEditText(Context context) {
        super(context);
        init();
    }

    public DottedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr = attrs;
        init();
    }

    public DottedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr = attrs;
        init();
    }

    public int getFields() {
        return fields;
    }

    public void setFields(int fields) {
        this.fields = fields;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
