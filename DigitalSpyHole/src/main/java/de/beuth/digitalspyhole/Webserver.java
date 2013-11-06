package de.beuth.digitalspyhole;

/**
 * Created by Niklas Knauer on 30.10.13.
 */

/**
 * This class is for the transaction with the web server authorized.
 */
public class Webserver {

    private String s_servername;
    private String s_ip;
    private String s_url;



    public Webserver(String s_servername, String s_ip, String s_url) {
        this.s_servername = s_servername;
        this.s_ip = s_ip;
        this.s_url = s_url;
        connnect(s_servername,s_ip,s_url);
    }

    public String getS_servername() {
        return s_servername;
    }

    public void setS_servername(String s_servername) {
        this.s_servername = s_servername;
    }
    public String getUrl() {
        return s_url;
    }

    public void setUrl(String url) {
        this.s_url = url;
    }

    /**
     * The method is able to connect to the web server with the following three parameters.
     * @param s_servername
     * @param s_ip
     * @param s_url
     */
    private void connnect(String s_servername, String s_ip, String s_url) {
    }


}
