package com.udea.drools.controller;

import com.udea.drools.model.Request;
import com.udea.drools.model.Response;
import com.udea.drools.service.AirlineEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight")
public class AirlineEvaluationController {

    @Autowired
    private AirlineEvaluationService evaluationService;

    // Endpoint REST
    @PostMapping("/api/evaluate")
    @ResponseBody
    public Response evaluteRequestAPI(@Valid @RequestBody Request request, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");
            return new Response(false, 0.0, 0.0, "Error de validación: " + errorMessage);
        }
        return evaluationService.evaluateRequest(request);
    }

    // Mostrar formulario web
    @GetMapping("/form")
    public String showForm(Model model) {
        Request request = new Request();
        // creditRequest.setCustomer(new Customer());
        model.addAttribute("creditRequest", request);
        return "airline_form";
    }

    // Procesar solicitud desde el formulario web
    @PostMapping("/evaluate")
    public String evaluateCreditWeb(@Valid Request request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, volver al formulario con los errores
            return "airline_form";
        }
        Response response = evaluationService.evaluateRequest(request);
        model.addAttribute("creditResponse", response);
        return "airline_result";
    }
}