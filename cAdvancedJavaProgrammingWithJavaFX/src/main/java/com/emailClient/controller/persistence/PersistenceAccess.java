package com.emailClient.controller.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceAccess {

    private static final String VALID_ACCOUNTS_LOCATION = System.getProperty("user.home") +
            File.separator + "validAccounts.ser";
    private Encoder encoder = new Encoder();

    public List<ValidAccount> loadFromPersistence() {
        List<ValidAccount> resultList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(VALID_ACCOUNTS_LOCATION);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<ValidAccount> persistedList = (List<ValidAccount>) objectInputStream.readObject();
            decodePasswords(persistedList);
            resultList.addAll(persistedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void saveToPersistence(List<ValidAccount> validAccounts) {
        System.out.println(VALID_ACCOUNTS_LOCATION);
        File file = new File(VALID_ACCOUNTS_LOCATION);
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            encodePasswords(validAccounts);
            objectOutputStream.writeObject(validAccounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void decodePasswords(List<ValidAccount> persistedList) {
        for (ValidAccount validAccount : persistedList) {
            String originalPassword = validAccount.getPassword();
            validAccount.setPassword(encoder.decode(originalPassword));
        }
    }

    private void encodePasswords(List<ValidAccount> persistedList) {
        for (ValidAccount validAccount : persistedList) {
            String originalPassword = validAccount.getPassword();
            validAccount.setPassword(encoder.encode(originalPassword));
        }
    }

}
