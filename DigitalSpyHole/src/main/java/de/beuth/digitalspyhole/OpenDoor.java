package de.beuth.digitalspyhole;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Niklas Knauer on 30.10.13.
 */
public class OpenDoor {


    public OpenDoor() {
        try{
            URL u = new URL("http://spyhole.no-ip.biz?open=open");
            u.openStream();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
