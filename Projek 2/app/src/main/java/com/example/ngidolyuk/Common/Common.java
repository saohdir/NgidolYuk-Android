package com.example.ngidolyuk.Common;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.example.ngidolyuk.Model.BestDealListModel;
import com.example.ngidolyuk.Model.BestDealModel;
import com.example.ngidolyuk.Model.User;
import com.example.ngidolyuk.Model.CategoryListModel;
import com.example.ngidolyuk.Model.CategoryModel;

public class Common {
    public static final String BEST_DEALS_REF ="BestDeals" ;
    public static final int DEFAULT_COLUMN_COUNT = 0;
    public static final int FULL_WIDTH_COLUMN = 1;
    public static final String CATEGORY_REF = "Category";
    public static final String SCHDULE_REF = "users";
    public static final String MEMBER_REF = "Member";
    public static User currentUser;
    public static final String POPULAR_CATEGORY_REF = "MostPopular";
    public static BestDealModel bestdealSelected;
    public static BestDealListModel selectedBestdeal;
    public static CategoryModel categorySelected;
    public static CategoryListModel selectedCategory;

    public static void setSpanString(String welcome, String name, TextView textView) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(welcome);
        SpannableString spannableString = new SpannableString(name);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, 0,name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(spannableString);
        textView.setText(builder,TextView.BufferType.SPANNABLE);
    }
}
