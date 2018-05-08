package com.stark.app.tools.controller;

import com.stark.app.tools.logic.Barcode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/tools/barcode")
public class BarcodeController {

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/createBarcode")
    public void createBarcode(String url, HttpServletResponse response){
        Barcode barcode = new Barcode();
        try {
            barcode.getTwoDimension(url, response, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
