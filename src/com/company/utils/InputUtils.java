package com.company.utils;

import com.company.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputUtils {
    static Scanner in = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);

    public int readInt(){
        return in.nextInt();
    }

    public Date readDate() throws ParseException {
        return dateFormat.parse(readString());
    }

    public String readString(){
        return in.next();
    }
}
