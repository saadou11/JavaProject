package spring.controllers;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.services.AwsConnectService;

@RestController
public class InitController {

    @Autowired
    private AwsConnectService awsConnectService;

    @RequestMapping("init")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "fsociety") String name) {
        AWSSecretsManager secretManager = awsConnectService.getSecretManager();
        return "Hello " + name +" with secret : "+ awsConnectService.secretManagerValue(secretManager, "blah");
    }
}
