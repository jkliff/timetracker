package de.jkliff.timetracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseUtils {
    private static SimpleDateFormat getDateParser() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD HH:MM");
        return sdf;
    }

    public static Date parseDate(String s) throws ParseException {
        return getDateParser().parse(s);
    }
}
