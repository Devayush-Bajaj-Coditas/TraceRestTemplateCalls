package com.devayush.PracticeDemo.repository;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.devayush.PracticeDemo.config.DynamoDBConfigurations;
import com.devayush.PracticeDemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProductRepository {

    @Autowired
    private DynamoDBConfigurations dynamoDBConfigurations;

    public Product save(Product product){

        AmazonDynamoDB client = dynamoDBConfigurations.buildAmazonDynamoDB();
        DynamoDB dynamoDB = new DynamoDB(client);

        String uuid = UUID.randomUUID().toString();

        Item item = new Item()
                .withPrimaryKey("id", uuid)  // Specify the primary key attribute
                .withString("name", product.getName())
                .withDouble("price", product.getPrice());

        PutItemSpec putItemSpec = new PutItemSpec().withItem(item);

        Table table = dynamoDB.getTable("Products");
        table.putItem(putItemSpec);
        return product;
    }
}
