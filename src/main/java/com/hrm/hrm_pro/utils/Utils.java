package com.hrm.hrm_pro.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getCurDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
