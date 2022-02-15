package spring.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.AWSSecretsManagerException;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AwsConnectService {

    public AWSSecretsManager getSecretManager() {
        return AWSSecretsManagerClientBuilder.standard().withRegion(Regions.EU_WEST_3).build();
    }

    public Optional<String> secretManagerValue(AWSSecretsManager secretsClient, String secretName) {
        Optional<String> secret;
        try {
            GetSecretValueRequest valueRequest = new GetSecretValueRequest().withSecretId(secretName);
            GetSecretValueResult valueResponse = secretsClient.getSecretValue(valueRequest);
            secret = Optional.of(valueResponse.getSecretString());

        } catch (AWSSecretsManagerException exception) {
            exception.printStackTrace();
            secret = Optional.of("Secret " + secretName + " not found");
        }
        return secret;
    }

    /**
     *
     * @return
     */
    private DynamoDB getDynamoDB(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_3)
                .build();
        return new DynamoDB(client);
    }

    /**
     *
     * @param userID
     * @return
     */
    public Item getUserDetails(Integer userID){
        Table table = getDynamoDB().getTable("amdata_fsociety_dynamo_users");
        return table.getItem(new PrimaryKey().addComponent("user_id", userID));
    }

    public Item getDetails(Integer userID){
        Table table = getDynamoDB().getTable("amdata_fsociety_dynamo_users");
        Item item = table.getItem(new PrimaryKey().addComponent("user_id", userID));

        //table.getItem(GetItemSpec)

        return item;
    }
}
