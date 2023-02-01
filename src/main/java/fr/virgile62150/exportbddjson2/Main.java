package fr.virgile62150.exportbddjson2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        //TEST BDDtoJSON

        /*List<Hashtag> hashtags = new ArrayList<>();
        List<Commentaire> commentaires = new ArrayList<>();
        hashtags.add(new Hashtag("YOLO"));
        hashtags.add(new Hashtag("NARUTO"));

        final Commentaire test3 = new Commentaire("texteCommentaire", 15661, 16515, "dateHeureCommentaire", " auteur",  15615, hashtags);
        commentaires.add(test3);
        */
        /*
        Analyse des perfs
         */
        long before_mysql = System.currentTimeMillis();

        BDD bdd = new BDD();
        Calendar c = Calendar.getInstance();





        ArrayList<Commentaire> commentaires = bdd.getCommentaires();
        long after_mysql = System.currentTimeMillis();
        System.out.println("Durée d'exécution du select : " + Long.toString(after_mysql - before_mysql) + " ms");
        
        BDDToJson testJson = new BDDToJson();

        String str = testJson.BDDToJsonClassString(commentaires);
        long before_mongo = System.currentTimeMillis();
        // import
        try {
            //new InjectMongoDb().InjectMongo("C:\\Users\\Virgi\\IdeaProjects\\exportBDDJson2\\commentaires.json");
            new InjectMongoDb().InjectMongoString(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long after_mongo = System.currentTimeMillis();

        System.out.println("Durée d'exécution de l'insert : " + Long.toString(after_mongo - before_mongo) + " ms");


    }
}
