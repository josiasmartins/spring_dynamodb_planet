# Planet api with spring dynamodb

## configuracao do dynamodb
#### dependencias
```xml
<!-- dependencias para o dynamodb -->
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk-dynamodb</artifactId>
    <version>1.11.64</version>
</dependency>

<dependency>
    <groupId>com.github.derjust</groupId>
    <artifactId>spring-data-dynamodb</artifactId>
    <version>5.1.0</version>
</dependency>
<!-- dependencias para o dynamodb -->
```

```properties
amazon.dynamodb.endpoint=http://dynamodb.us-east-2.amazonaws.com
amazon.aws.accesskey=
amazon.aws.secretkey=
```

```java
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());


        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }

        amazonDynamoDB.setRegion(Region.getRegion(Regions.US_EAST_2));

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
```
