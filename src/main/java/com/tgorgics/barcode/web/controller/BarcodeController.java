package com.tgorgics.barcode.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgorgics.barcode.util.BarcodeUtil;
import com.tgorgics.barcode.web.dto.BarcodeDTO;

@Controller
public class BarcodeController {

    @Value("${barcode.servlet.mapping}")
    private String barcodeServletMapping;

    @RequestMapping("/")
    public String index(final Model model) {
        final List<String> barcodeTypes = BarcodeUtil.getBarcodeTypesList();
        model.addAttribute("barcodeTypes", barcodeTypes);
        return "index";
    }

    @RequestMapping(value = "/barcode", method = RequestMethod.POST)
    public String barcode(@ModelAttribute("barcode") final BarcodeDTO barcode, final Model model) {
        final String barcodeImage = BarcodeUtil.assembleImagePath(this.barcodeServletMapping, barcode);
        model.addAttribute("imageSrc", barcodeImage);

        return "barcode :: barcodeImage";
    }

    @ModelAttribute("barcode")
    public BarcodeDTO newBarcodeObject() {
        return new BarcodeDTO();
    }

}
