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
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            kieSession.insert(request);
            kieSession.insert(response);

            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }

        return response;
    }
}