package com.humanbooster.mediabuzzsql.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.mediabuzzsql.manager.CommentManager;
import com.humanbooster.mediabuzzsql.manager.ContentManager;
import com.humanbooster.mediabuzzsql.manager.TagManager;
import com.humanbooster.mediabuzzsql.manager.UserManager;
import com.humanbooster.mediabuzzsql.pojos.Comment;
import com.humanbooster.mediabuzzsql.pojos.Media;
import com.humanbooster.mediabuzzsql.pojos.User;
import com.humanbooster.mediabuzzsql.utils.DataConnect;

public class Client {

    public static void main(String[] args) {

        try (Connection connection = DataConnect.getConnection()) {
            
            UserManager usermanager = new UserManager(connection);
            ContentManager contentmanager = new ContentManager(connection);
            TagManager tagmanager = new TagManager(connection);
            CommentManager commentmanager = new CommentManager(connection);
            Timestamp timeNow = new Timestamp(System.currentTimeMillis());
            Date date = new Date(System.currentTimeMillis());
            
            System.out.println("---------- TEST CONNEXION MEDIABUZZSQL----------");
            System.out.println("Connexion : " + connection);
            
//            User user = new User("user69","pass","user69@gmail.com",timeNow);
//            usermanager.createUser(user);
//            System.out.println("---------- TEST AJOUT UTILISATEUR \nMEDIABUZZSQL----------");
            
//            System.out.println("---------- TEST SELECTIONNER UTILISATEUR PAR LOGIN \nMEDIABUZZSQL----------");
//            System.out.println(usermanager.getUserByLogin("user69"));
            
//            System.out.println("---------- TEST AFFICHER TOUS LES UTILISATEURS \\nMEDIABUZZSQL----------");
//            for(User user : usermanager.getAllUser()) {
//                System.out.println(user);
//            }
            
//          AJOUTER UN MEDIA
//          Media media = new Media("video","Rocket","Flying to the moon!","mp4",30,"/var/video/rocket.mp4",timeNow,usermanager.getUserByLogin("johndoe").getLogin());
//          contentmanager.createContent(media);
//          System.out.println("---------- TEST AJOUT MEDIA MEDIABUZZSQL----------");
            

//            VOIR TOUTES LES IMAGES ANTECHRONOLOGIQUEMENT
//            for(Media media : contentmanager.getAllImagesDesc()) {
//              System.out.println(media);
//            }
            
//          VOIR TOUTES LES IMAGES D'UN USER ANTECHRONOLOGIQUEMENT
//          for(Media media : contentmanager.getAllImagesByUser("johndoe")) {
//            System.out.println(media);
//          }
            
//          VOIR TOUS LES AUDIO ANTECHRONOLOGIQUEMENT
//            for(Media media : contentmanager.getAllAudiosDesc()) {
//                System.out.println(media);
//            }
          
//          VOIR TOUS LES AUDIO D'UN USER ANTECHRONOLOGIQUEMENT
//          for(Media media : contentmanager.getAllAudiosByUser("johndoe")) {
//              System.out.println(media);
//          }
            
//          VOIR TOUTES LES VIDEOS ANTECHRONOLOGIQUEMENT
//            for(Media media : contentmanager.getAllVideosDesc()) {
//                System.out.println(media);
//            }
            
//          VOIR TOUTES LES VIDEOS D'UN USER ANTECHRONOLOGIQUEMENT
//          for(Media media : contentmanager.getAllVideosByUser("johndoe")) {
//              System.out.println(media);
//          }
            
//          VOIR TOUS LES MEDIAS ORDRE ANTECHRONOLOGIQUE
//          for(Media media : contentmanager.getAllMediasDesc()) {
//              System.out.println(media);
//          }
            
            
//            VOIR LE NOMBRE DE MEDIA PAR UTILISATEUR
//            System.out.println(contentmanager.getNumberOfContentByUser("johndoe"));
//            System.out.println("----------");
//            System.out.println("--- Dont images :");
//            System.out.println(contentmanager.getNumberOfContentByUser("johndoe","image"));
           
//            AJOUTER VUE
//            contentmanager.addView(1);
            
            
//            NOTER UN TAG AJOUTER TOP et AJOUTER FLOP
//            tagmanager.addTop(1);
//            tagmanager.addFlop(1);
            
//            VOIR LE NOMBRE DE TOP et FLOP  D'UN TAG
//            System.out.println(tagmanager.getTopTag(1));
//            System.out.println(tagmanager.getFlopTag(1));
//            System.out.println(tagmanager.getAvgTag(1));
//            System.out.println("Pour " + tagmanager.getNbVote(1) + " votes.");
            
//            CREER UN COMMENTAIRE
//            Comment comment = new Comment("Superbe! Quelle virtuosité!",timeNow,1,3);
//            commentmanager.createComment(comment);
            
//            VOIR LES COMMENTAIRES PAR ORDRE ANTE-CHRONOLOGIQUE
//            for(Comment comment : commentmanager.getAllCommentsDesc()) {
//                System.out.println(comment);
//            }
                       
//            VOIR LES COMMENTAIRES PAR UTILISATEUR PAR ORDRE ANTE-CHRONOLOGIQUE
//            for(Comment comment : commentmanager.getCommentsByUser(1)) {
//                System.out.println(comment);
//            }
            
//          VOIR LES COMMENTAIRES PAR MEDIA PAR ORDRE ANTE-CHRONOLOGIQUE
//          for(Comment comment : commentmanager.getCommentsByMedia(1)) {
//              System.out.println(comment);
//          }
            
//            VOIR LE NOMBRE DE COMMENTAIRES PAR UTILISATEUR
//            System.out.println(commentmanager.numberOfCommentsByUser(1));
            
//          VOIR LE NOMBRE DE COMMENTAIRES PAR MEDIA
//          System.out.println(commentmanager.numberOfCommentsByMedia(1));
            
//            String wordA = "bain";
////            String wordB = "fleur";
////            String wordC = "ce";
//           List<String> words = new ArrayList<>();
//           words.add(wordA);
////           words.add(wordB);
//////            words.add(wordC);
////            
//            System.out.println("---------- TEST RECHERCHE -----------");
//            for(Media media : contentmanager.searchMedia(words)) {
//                System.out.println(media);
//            }

            
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
