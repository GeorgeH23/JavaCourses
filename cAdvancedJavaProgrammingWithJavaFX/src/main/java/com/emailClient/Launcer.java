package com.emailClient;

import com.emailClient.controller.persistence.PersistenceAccess;
import com.emailClient.controller.persistence.ValidAccount;
import com.emailClient.controller.services.LoginService;
import com.emailClient.model.EmailAccount;
import com.emailClient.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Launcer extends Application {

    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();
    private ViewFactory viewFactory = new ViewFactory(emailManager);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        checkPersistence();
        viewFactory.updateStyles();
    }

    private void checkPersistence() {
        List<ValidAccount> validAccounts = persistenceAccess.loadFromPersistence();
        if (validAccounts.size() > 0) {
            viewFactory.showMainWindow();
            for (ValidAccount validAccount : validAccounts) {
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccounts = new ArrayList<>();
        for (EmailAccount emailAccount : emailManager.getEmailAccounts()) {
            validAccounts.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(validAccounts);
    }
}
