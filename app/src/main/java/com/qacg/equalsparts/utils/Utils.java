package com.qacg.equalsparts.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jhovany on 9/03/17.
 */

public class Utils {

    public static void goToActivity(Activity context, Class clazz, Bundle params, boolean finish) {
        Intent i = new Intent(context, clazz);

        if (params != null)
            i.putExtras(params);

        context.startActivity(i);

        if (finish)
            context.finish();

    }

    public static void launchActivityForResult(Activity context, Class clazz, Bundle params, int code) {
        Intent i = new Intent(context, clazz);

        if (params != null)
            i.putExtras(params);

        context.startActivityForResult(i, code);
    }


}
