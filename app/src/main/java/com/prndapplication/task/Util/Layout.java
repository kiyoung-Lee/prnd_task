package com.prndapplication.task.Util;

import android.content.Context;
import android.util.TypedValue;

import java.text.DecimalFormat;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class Layout {

    public static int dpToPixel(Context context, int dp) {
        if (context != null) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        } else
            return 0;
    }

    public static String getFormattedPrice(int price) {
        DecimalFormat df = new DecimalFormat("#,###");
        String formatted_price = df.format(price) + "만원";
        return formatted_price;
    }

    public static String getFormattedDistance(int distance){
        DecimalFormat df = new DecimalFormat("#,####");
        String formatted_price = df.format(distance);

        int dotIdx = formatted_price.indexOf(",");
        String substringFormat = formatted_price.substring(0, dotIdx + 2);

        String[] resultSplit = substringFormat.split("");
        String result = null;
        if(resultSplit[dotIdx + 2].equals("0")){
            result = formatted_price.substring(0, dotIdx);
        }else{
            result = substringFormat;
        }
        return result + "만km";
    }
}
