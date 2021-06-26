package app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Lang {
    private String lang;
    private String country;
    private Locale locale;
    private ResourcesWorker rw;

    public Lang() {
        this.lang = "en";
        this.country = "US";
        this.locale = new Locale(this.lang, this.country);
        this.rw = new ResourcesWorker();
    }

    //region getters/setters
    public String getLang() {
        return lang;
    }
    public String getCountry() {
        return country;
    }
    public Locale getLocale() {
        return this.locale;
    }
    public ResourcesWorker getRw() {
        return rw;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setLocale() {
        locale = new Locale(this.getLang(), this.getCountry());
    }
    //endregion

    //set language and resources
    public void setLang() {
        chooseLang();
        this.setResources();
    }

    //set resources
    public void setResources() {
        rw.setResBundle(this.getLocale());
    }

    //shortening for getting resources string
    public String getString(String str) {
        return this.rw.getResBundle().getString(str);
    }

    public void chooseLang() {
        while(true) {
            System.out.println("================================");
            System.out.println("CHOOSE LANGUAGE / ВЫБЕРИТЕ ЯЗЫК:");
            System.out.println("================================");
            System.out.println("1: ENG");
            System.out.println("2: RU");
            System.out.println();
            System.out.print("Your choice / Ваш выбор: ");

            Scanner sc = new Scanner(System.in);
            try {
                int choice = sc.nextInt();

                if (choice == 1) {
                    this.setLang("en");
                    this.setCountry("US");
                } else if (choice == 2) {
                    this.setLang("ru");
                    this.setCountry("RU");
                } else {
                    throw new InputMismatchException();
                }
                this.setLocale();
                break;
            } catch (Exception e) {
                System.out.println("Error! Choose correct number / Ошибка! Выберите правильный номер");
                System.out.println();
            }
        }
    }
}
