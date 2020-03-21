package kJavaFX.iToDoListApplication.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance(){
        return instance;
    }

    private TodoData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

    /*public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }*/

    public void loadTodoItems() throws IOException, URISyntaxException {

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(getClass().getResource("/kJavaFX/iToDoListApplication/" + filename).toURI());
        System.out.println(path);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = "";
                String dateString = "";
                if (itemPieces.length > 1) {
                    details = itemPieces[1];
                }
                if (itemPieces.length > 2) {
                    dateString = itemPieces[2];
                }

                // The Due Date in final format
                if (dateString.equals("")) {
                    continue;
                }
                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }
        }
    }

    public void storeTodoItems () throws IOException, URISyntaxException {

        Path path = Paths.get(getClass().getResource("/kJavaFX/iToDoListApplication/" + filename).toURI());

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            Iterator<TodoItem> iter = todoItems.iterator();
            while (iter.hasNext()) {
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s", item.getShortDescription(), item.getDetails(), item.getDeadline().format(formatter)));
                bw.newLine();
            }
        }
    }

    public void deleteTodoItem(TodoItem item){
        todoItems.remove(item);
    }
}
