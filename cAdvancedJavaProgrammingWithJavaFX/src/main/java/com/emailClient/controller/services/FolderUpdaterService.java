package com.emailClient.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javax.mail.Folder;
import java.util.List;

public class FolderUpdaterService extends Service<Void> {

    private final List<Folder> folderList;

    public FolderUpdaterService(List<Folder> folderList) {
        this.folderList = folderList;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                for (;;) {
                    try {
                        Thread.sleep(5000);
                        for (Folder folder : folderList) {
                            synchronized (folderList) {
                                if ((folder.getType() != Folder.HOLDS_FOLDERS) && (folder.isOpen())) {
                                    folder.getMessageCount();
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
