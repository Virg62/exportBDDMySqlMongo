package fr.virgile62150.exportbddjson2;
// Import the necessary packages
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class InjectMongoDb {

    public void InjectMongo(String path) throws FileNotFoundException {
        // Connect to the MongoDB database
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Get the collection
        MongoCollection<Document> collection = database.getCollection("test");

        JSONObject jsonData = new JSONObject(new FileReader(path));

        // Convert JSON data to MongoDB Document
        Document document = Document.parse(jsonData.toString());

        // Insert the document into the collection
        collection.insertOne(document);
        mongoClient.close();
    }

    public void InjectMongoString(String text) throws FileNotFoundException, JSONException {
        // Connect to the MongoDB database
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Get the collection
        MongoCollection<Document> collection = database.getCollection("test");

        JSONArray jsonData = new JSONArray(text);

        for (int i = 0; i<jsonData.length(); i++) {
            JSONObject obj = jsonData.getJSONObject(i);
            Document document = Document.parse(obj.toString());
            collection.insertOne(document);
        }

        // Convert JSON data to MongoDB Document


        // Insert the document into the collection

        mongoClient.close();
    }

}


