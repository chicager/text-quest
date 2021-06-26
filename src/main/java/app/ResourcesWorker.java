package app;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourcesWorker {
    private ResourceBundle resBundle;

    public ResourceBundle getResBundle() {
        return resBundle;
    }

    public void setResBundle(Locale locale) {
        this.resBundle = ResourceBundle.getBundle("Bundle", locale);
    }
    public String getString(String str) {
        return this.getResBundle().getString(str);
    }
}
