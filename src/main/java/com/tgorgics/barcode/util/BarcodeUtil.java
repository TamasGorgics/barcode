package com.tgorgics.barcode.util;

import com.tgorgics.barcode.web.dto.BarcodeDTO;

public class BarcodeUtil {

    public static String assembleImagePath(final String servletPath, final BarcodeDTO barcode) {

        final StringBuilder sb = new StringBuilder(servletPath).append("?data=").append(barcode.getData());
        sb.append(barcode.getLabel() == null || barcode.getLabel() == "" ? "" : "&label=" + barcode.getLabel());
        sb.append(barcode.isDrawText() == false ? "" : "&drawText=true");
        sb.append(barcode.getWidth() == 0 ? "" : "&width=" + barcode.getWidth());
        sb.append(barcode.getHeight() == 0 ? "" : "&height=" + barcode.getHeight());
        sb.append("&headless=false&resolution=-1");

        return sb.toString();
    }
}
