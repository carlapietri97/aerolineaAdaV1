package com.ada.aerolinea.aerolineaAdaV1.controller;

import com.ada.aerolinea.aerolineaAdaV1.service.ICalculator;
import com.ada.aerolinea.aerolineaAdaV1.service.impl.CalculatorImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/aerolinea/ada/v1/calculator")
public class CalculatorController {


    private ICalculator calculator = new CalculatorImpl();

    @GetMapping(path = "/suma/{a}/{b}")
    public @ResponseBody
    Integer sumar(@PathVariable("a") int a, @PathVariable("b") int b  ) {
        return calculator.suma(a, b);
    }

}
