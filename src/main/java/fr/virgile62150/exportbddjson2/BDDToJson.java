package fr.virgile62150.exportbddjson2;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BDDToJson {



void BDDToJsonClass(List<Commentaire> commentaires){


try {
    JSONArray commentairesJson = new JSONArray();
    for (Commentaire commentaire : commentaires) {
        JSONObject obj = new JSONObject();
        obj.put("texteCommentaire", commentaire.texteCommentaire);
        obj.put("pointGeo", commentaire.pointGeo);
        obj.put("dossard", commentaire.dossard);
        obj.put("dateHeureCommentaire", commentaire.dateHeureCommentaire);
        obj.put("auteur", commentaire.auteur);
        obj.put("course", commentaire.course);
        JSONArray hashtagsJson = new JSONArray();
        for (Hashtag hashtag : commentaire.hashtags) {
            JSONObject hashtagJson = new JSONObject();
            hashtagJson.put("hashtag", hashtag.textehHashtag);
            hashtagsJson.put(hashtagJson);
        }
        obj.put("mesHashtags", hashtagsJson);
        commentairesJson.put(obj);
    }
    FileWriter writer = new FileWriter("commentaires.json");
    //System.out.println(commentairesJson.toString());
    writer.write(commentairesJson.toString());
    writer.flush();
    writer.close();
} catch (JSONException e) {
    throw new RuntimeException(e);
} catch (IOException e) {
    throw new RuntimeException(e);
}

}

String BDDToJsonClassString(List<Commentaire> commentaires){


        try {
            JSONArray commentairesJson = new JSONArray();
            for (Commentaire commentaire : commentaires) {
                JSONObject obj = new JSONObject();
                obj.put("texteCommentaire", commentaire.texteCommentaire);
                obj.put("pointGeo", commentaire.pointGeo);
                obj.put("dossard", commentaire.dossard);
                obj.put("dateHeureCommentaire", commentaire.dateHeureCommentaire);
                obj.put("auteur", commentaire.auteur);
                obj.put("course", commentaire.course);
                JSONArray hashtagsJson = new JSONArray();
                for (Hashtag hashtag : commentaire.hashtags) {
                    JSONObject hashtagJson = new JSONObject();
                    hashtagJson.put("hashtag", hashtag.textehHashtag);
                    hashtagsJson.put(hashtagJson);
                }
                obj.put("mesHashtags", hashtagsJson);
                commentairesJson.put(obj);
            }
            return commentairesJson.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

}
