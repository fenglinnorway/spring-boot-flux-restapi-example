package no.ensurance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


    @GetMapping("/sendmail")
    public SampleResponse hello() {
        SampleResponse response = new SampleResponse();
        response.setMessage("mail sent!");
        return response;
    }

    public static class SampleResponse {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

