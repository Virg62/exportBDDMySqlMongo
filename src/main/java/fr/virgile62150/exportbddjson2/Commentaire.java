package fr.virgile62150.exportbddjson2;

import java.util.ArrayList;
import java.util.List;

public class Commentaire {


    String texteCommentaire;
    int pointGeo;
    int dossard ;
    String dateHeureCommentaire ;
    String auteur;
    int course ;
    List<Hashtag> hashtags = new ArrayList<>();


    public Commentaire(String texteCommentaire, int pointGeo, int dossard, String dateHeureCommentaire, String auteur, int course, List<Hashtag> hashtags) {
        this.texteCommentaire = texteCommentaire;
        this.pointGeo = pointGeo;
        this.dossard = dossard;
        this.dateHeureCommentaire = dateHeureCommentaire;
        this.auteur = auteur;
        this.course = course;
        this.hashtags = hashtags;
    }

    public Commentaire() {

    }
}
