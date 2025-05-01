package com.udea.drools.controller;

import com.udea.drools.model.Request;
import com.udea.drools.model.Response;
import com.udea.drools.model.Flight;
import com.udea.drools.model.Seat;
import com.udea.drools.model.Passenger;
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
    public Response evaluteRequestApi(@Valid @RequestBody Request request, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");
            return new Response(request.getPassenger(), errorMessage);
        }
        return evaluationService.evaluateRequest(request);
    }

    // Mostrar formulario web
    @GetMapping("/form")
    public String showForm(Model model) {
        Request request = new Request();
        request.setPassenger(new Passenger());
        model.addAttribute("Request", request);
        return "airline_form";
    }

    @PostMapping("/evaluate")
    public String evaluateWeb(@Valid Request request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Request", request);
            return "airline_form";
        }

        Response response = evaluationService.evaluateRequest(request);
        if (response == null) {
            response = new Response();
            response.setMessage("No se pudo procesar la solicitud.");
        }

        if (response.getPassenger() == null) {
            response.setPassenger(request.getPassenger());
        }

        if (response.getPassenger().getFlight() == null) {
            response.getPassenger().setFlight(new Flight());
        }

        if (response.getPassenger().getAssignedSeat() == null) {
            response.getPassenger().setAssignedSeat(new Seat(request.getPassenger().getSeatPreference()));
        }

        model.addAttribute("Response", response);
        return "airline_result";
        }
}