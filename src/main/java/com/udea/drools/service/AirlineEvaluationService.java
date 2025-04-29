package com.udea.drools.service;

import com.udea.drools.model.Request;
import com.udea.drools.model.Response;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineEvaluationService {

    @Autowired
    private KieContainer kieContainer;

    public Response evaluateRequest(Request request) {
        // Crear una respuesta inicial
        Response response = new Response();

        // Crear una sesión de Drools
        KieSession kieSession = kieContainer.newKieSession();

        try {
            // Insertar los hechos (request y response) en la sesión
            kieSession.insert(request);
            kieSession.insert(response);

            // Ejecutar todas las reglas
            kieSession.fireAllRules();
        } finally {
            // Liberar la sesión
            kieSession.dispose();
        }

        return response;
    }
}