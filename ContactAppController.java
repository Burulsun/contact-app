package ContactApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ContactAppController {
        @FXML private ImageView coverImageView;
        @FXML private ListView<Person> booksListView;


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;





    private final ObservableList<Person> info = FXCollections.observableArrayList();



    public void initialize(){
        info.add(new Person("James", "Davis", "nn@gmail.com", "12345"));
        info.add(new Person("Luke", "Lewis", "ll@gmail.com", "123456"));
        info.add(new Person("Dvid", "Bold", "mm@gmail.com", "123457"));
        info.add(new Person("David", "Bold2", "nk@gmail.com", "1234578"));
        info.add(new Person("James young", "Brown", "na@gmail.com", "123459"));
        info.add(new Person("Kate", "Red", "pp@gmail.com", "1234556"));

        booksListView.setItems(info);

        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

            @Override
            public void changed(ObservableValue<? extends Person> observableValue, Person person, Person t1) {
                nameTextField.setText(t1.getFirstName());
                lastNameTextField.setText(t1.getLastname());
                emailTextField.setText(t1.getEmail());
                phoneNumberTextField.setText(t1.getPhoneNumber());
            }
        });
        }
    @FXML
    void deleteContact(ActionEvent event) {
        Person person =new Person(nameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(),
                phoneNumberTextField.getText());
        info.removeIf(i->i.getFirstName().equals(person.getFirstName()) && i.getLastname().equals(person.getLastname()) && i.getEmail().equals(person.getEmail()) && i.getPhoneNumber().equals(person.getPhoneNumber()));
        booksListView.setItems(info);

    }

    @FXML
    void updateInfo(ActionEvent event) {
        Person p =new Person(nameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(),
                phoneNumberTextField.getText());
        info.removeIf(i->i.getFirstName().equals(p.getFirstName()) || i.getLastname().equals(p.getLastname()) && i.getEmail().equals(p.getEmail()) && i.getPhoneNumber().equals(p.getPhoneNumber()));
        info.add(p);

        booksListView.setItems(info);



    }
    @FXML
    void addContact(ActionEvent event) {
        //Person person =new Person(nameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(),
         //       phoneNumberTextField.getText());
//        String a =nameTextField.getText();
//        String b =lastNameTextField.getText();
//        String c =emailTextField.getText();
//        String d =phoneNumberTextField.getText();
//        info.add(new Person(a,b,c,d));
//        booksListView.setItems(info);
        info.add(new Person(nameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(),
                phoneNumberTextField.getText()));
        booksListView.setItems(info);

    }
    }

