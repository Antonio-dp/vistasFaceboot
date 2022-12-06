/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;
import entidades.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Clase que permite realizar la conexion con facebook para logearte
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FbConexion {
    /**
     * Realiza la conexion con facebook y devuelve un
     * objeto de tipo usuario con los datos obtenidos de facebook
     * @return Usuario usuario con informacion de facebook
     */
    public Usuario authUser() {

        String domain = "https://localhost/";
        String appId = "696397435033146";

        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_activities,user_birthday,user_education_history,"
                + "user_events,user_photos,user_games_activity,user_groups,user_hometown,user_interests,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_notifications,manage_pages,publish_actions,read_insights,read_mailbox,read_page_mailboxes,read_stream,rsvp_event";

        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while (true) {

            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
                String[] arreglo = accessToken.split("&");
                driver.quit();

                FacebookClient fbClient = new DefaultFacebookClient(arreglo[0]);
                User user = fbClient.fetchObject("me", User.class, Parameter.with("fields", "id,name,email"));

                Usuario usuario = new Usuario(user.getId(), user.getName(), user.getEmail());
                return usuario;
            }
        }
    }
}
