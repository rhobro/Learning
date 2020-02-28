package com.RoBroTech.Dev.ContactsManager;

public class Main {
    public static void main(String[] args) {
        ContactManager myContactManager = new ContactManager();
        Contact ronnieParker = new Contact();
        ronnieParker.name = "Ronnie Parker";
        ronnieParker.email = "ronnie.parker0808@icloud.com";
        ronnieParker.phoneNumber = "07881652805";
        myContactManager.addContact(ronnieParker);
        Contact zackSiddle = new Contact();
        zackSiddle.name = "Zack Siddle";
        zackSiddle.email = "itszackx@gmail.com";
        zackSiddle.phoneNumber = "07729784096";
        myContactManager.addContact(zackSiddle);
        Contact amma = new Contact();
        amma.name = "Nisha Anne Alex (Amma)";
        amma.email = "nishalex98@gmail.com";
        amma.phoneNumber = "07882341743";
        myContactManager.addContact(amma);
        Contact dada = new Contact();
        dada.name = "Bipin Mathew (Dada)";
        dada.email = "drbipinmathew@hotmail.com";
        dada.phoneNumber = "07883609560";
        myContactManager.addContact(dada);
        Contact maxiStirc = new Contact();
        maxiStirc.name = "Maxi Stirc";
        maxiStirc.email = "mstirc@gmail.com";
        maxiStirc.phoneNumber = "07415754826";
        myContactManager.addContact(maxiStirc);
        Contact aliKamel = new Contact();
        aliKamel.name = "Ali Kamel";
        aliKamel.email = "alik87932@gmail.com";
        aliKamel.phoneNumber = "";
        myContactManager.addContact(aliKamel);
        System.out.println(myContactManager.searchContact("Maxi Stirc").phoneNumber);
    }
}
