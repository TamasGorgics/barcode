package com.tgorgics.barcode.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tgorgics.barcode.web.dto.BarcodeDTO;

import net.sourceforge.barbecue.BarcodeFactory;

public class BarcodeUtil {

    public static List<String> BARCODE_TYPES;

    public static String assembleImagePath(final String servletPath, final BarcodeDTO barcode) {

        final StringBuilder sb = new StringBuilder(servletPath).append("?data=").append(barcode.getData());
        sb.append(barcode.getLabel() == null || barcode.getLabel() == "" ? "" : "&label=" + barcode.getLabel());
        sb.append(barcode.isDrawText() == false ? "" : "&drawText=true");
        sb.append(barcode.getWidth() == 0 ? "" : "&width=" + barcode.getWidth());
        sb.append(barcode.getHeight() == 0 ? "" : "&height=" + barcode.getHeight());
        sb.append(barcode.getType() == null || barcode.getType() == "" ? "" : "&type=" + barcode.getType());
        sb.append("&headless=false&resolution=-1");

        return sb.toString();
    }

    public static List<String> getBarcodeTypesList() {
        if (null == BARCODE_TYPES) {
            BARCODE_TYPES = readBarcodeTypes();
            Collections.sort(BARCODE_TYPES);
        }
        return BARCODE_TYPES;
    }

    private static List<String> readBarcodeTypes() {
        final List<String> resultList = new ArrayList<String>(29);
        final Method[] methods = BarcodeFactory.class.getMethods();

        String methodName = null;
        String barcodeType = null;
        for (final Method method : methods) {
            methodName = method.getName();
            if (method.getParameterTypes().length == 1 && methodName.startsWith("create")) {
                barcodeType = methodName.substring("create".length());
                resultList.add(barcodeType);
            }
        }

        return resultList;
    }
}
