package com.tgorgics.barcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgorgics.barcode.dto.BarcodeDTO;

@Controller
public class BarcodeController {

    @RequestMapping("/")
    public String index(final Model model) {
        return "index";
    }

    @ModelAttribute("barcode")
    public BarcodeDTO newBarcodeObject() {
        return new BarcodeDTO();
    }

}
