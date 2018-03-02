package org.javabrain.swing.container;

/**
 *
 * @author Fernando García
 */
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javax.swing.JPanel;

public class WebView extends JPanel{

    SwingBrowser browser = new SwingBrowser();

    public WebView() {
        setBackground(Color.WHITE);
    }

    public void setUrl(String url){
        browser.loadURL(url);
        browser.setBounds(1, 1,getWidth() - 1,getHeight() - 1);
        add(browser);
    }
    
}


class SwingBrowser extends JFXPanel {
//Variable encargada de renderizar el website

    private WebEngine engine;

    //Constructor de la clase
    public SwingBrowser() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                javafx.scene.web.WebView view = new javafx.scene.web.WebView();
                engine = view.getEngine();
                setScene(new Scene(view));
            }
        });
        setVisible(true);
    }
//Método para cargar la URL de la página web

    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String tmp = toURL(url);
                if (tmp == null) {
                    tmp = toURL(url);
                }
                engine.load(tmp);

            }
        });
    }

    private String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }
}
