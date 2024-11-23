import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TravelAssistant extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("TravelAssistant");
        primaryStage.setScene(createHomeScene());
        primaryStage.show();
    }

    // home page for user residence
    private Scene createHomeScene() {
        // welcoming users
        Label welcomeLabel = new Label("Welcome to TravelAssistant!");
        welcomeLabel.setFont(new Font("Comic Sans MS", 24));
        welcomeLabel.setTextFill(Color.rgb(50, 50, 50));
        welcomeLabel.setEffect(new DropShadow(10, Color.GRAY));

        // user input
        // asking user
        Label residenceLabel = new Label("Where do you currently reside?");
        residenceLabel.setFont(new Font("Comic Sans MS", 16));
        residenceLabel.setTextFill(Color.rgb(100, 100, 100));

        // text field for user input
        TextField residenceField = new TextField();
        residenceField.setMaxWidth(300);
        residenceField.setPromptText("Enter your country");
        residenceField.setStyle("-fx-background-radius: 15; -fx-padding: 10; -fx-border-color: #ccc; -fx-border-radius: 15;");

        // submit button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;");
        submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: #003f7f; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        submitButton.setEffect(new DropShadow(5, Color.GRAY));

        // action for button
        submitButton.setOnAction(e -> {
            String residence = residenceField.getText();
            String normalizedResidence = CountryNameNormalizer.normalizeCountryName(residence);
            System.out.println("Residence: " + normalizedResidence);
            primaryStage.setScene(createDestinationScene(normalizedResidence));
        });

        // arrangement of components
        VBox homeLayout = new VBox(15);
        homeLayout.getChildren().addAll(welcomeLabel, residenceLabel, residenceField, submitButton);
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.setStyle("-fx-background-color: #f4f4f9; -fx-padding: 20;");
        return new Scene(new StackPane(homeLayout), 900, 600);
    }

    // second page for destination user input
    private Scene createDestinationScene(String normalizedResidence) {
        // label asking for user input
        Label destinationLabel = new Label("Where do you want to travel?");
        destinationLabel.setFont(new Font("Comic Sans MS", 16));
        destinationLabel.setTextFill(Color.rgb(100, 100, 100));

        TextField destinationField = new TextField();
        destinationField.setMaxWidth(300);
        destinationField.setPromptText("Enter your destination");
        destinationField.setStyle("-fx-background-radius: 15; -fx-padding: 10; -fx-border-color: #ccc; -fx-border-radius: 15;");

        // back button to homepage
        Button backButton = new Button("<-Back");
        backButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #003f7f; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        backButton.setOnAction(e -> primaryStage.setScene(createHomeScene()));
        backButton.setEffect(new DropShadow(5, Color.GRAY));


        Button destinationSubmitButton = new Button("Submit");
        destinationSubmitButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;");
        destinationSubmitButton.setOnMouseEntered(e -> destinationSubmitButton.setStyle("-fx-background-color: #003f7f; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        destinationSubmitButton.setOnMouseExited(e -> destinationSubmitButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        destinationSubmitButton.setEffect(new DropShadow(5, Color.GRAY));
        destinationSubmitButton.setOnAction(e -> {
            String destination = destinationField.getText();
            String normalizedDestination = CountryNameNormalizer.normalizeCountryName(destination);
            System.out.println("Destination: " + normalizedDestination);
            primaryStage.setScene(createInformationScene(normalizedResidence, normalizedDestination));
        });

        // scene
        VBox destinationLayout = new VBox(15);
        destinationLayout.getChildren().addAll(destinationLabel, destinationField, destinationSubmitButton, backButton);
        destinationLayout.setAlignment(Pos.CENTER);
        destinationLayout.setStyle("-fx-background-color: #f4f4f9; -fx-padding: 20;");
        return new Scene(new StackPane(destinationLayout), 900, 600);
    }

    // third page to display information about destination
    private Scene createInformationScene(String normalizedResidence, String normalizedDestination) {
        // instances of classes and methods to get information
        TravelAdvisory Advisory = new TravelAdvisory();
        String advisoryMessage = Advisory.getTravelAdvisory(normalizedDestination);
        String sourceCurrency = CountryCurrencyMapper.getCurrencyCode(normalizedResidence);
        String targetCurrency = CountryCurrencyMapper.getCurrencyCode(normalizedDestination);
        CurrencyConverter Converter = new CurrencyConverter();
        double exchangeRate = Converter.getExchangeRate(sourceCurrency, targetCurrency);

        // labels for advisory message
        Label advisoryLabel = new Label("Travel Advisory for " + normalizedDestination + ":");
        advisoryLabel.setFont(new Font("Comic Sans MS", 18));
        Label messageLabel = new Label(advisoryMessage);
        messageLabel.setFont(new Font("Comic Sans MS", 14));

        // user input for amount of money
        Label moneyLabel = new Label("How much money do you plan to bring on this trip?");
        moneyLabel.setFont(new Font("Comic Sans MS", 16));
        TextField moneyField = new TextField();
        moneyField.setPromptText("Enter amount");
        moneyField.setMaxWidth(200);

        Label convertedAmountLabel = new Label();
        convertedAmountLabel.setFont(new Font("Comic Sans MS", 14));
        convertedAmountLabel.setTextFill(Color.rgb(50, 50, 50));

        moneyField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty() || !newValue.matches("\\d+(\\.\\d{1,2})?")) {
                convertedAmountLabel.setText("Please enter a valid amount.");
            } else {
                double money = Double.parseDouble(newValue);
                double convertedAmount = Converter.convertCurrency(money, exchangeRate);
                convertedAmountLabel.setText(String.format("%.2f %s = %.2f %s", money, sourceCurrency, convertedAmount, targetCurrency));
            }
        });

        // back button to destination page
        Button backButton = new Button("<-Back");
        backButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #003f7f; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 16; -fx-background-radius: 12;"));
        backButton.setOnAction(e -> primaryStage.setScene(createDestinationScene(normalizedResidence)));
        backButton.setEffect(new DropShadow(5, Color.GRAY));

        // scene
        VBox informationLayout = new VBox(15);
        informationLayout.getChildren().addAll(advisoryLabel, messageLabel, moneyLabel, moneyField, convertedAmountLabel, backButton);
        informationLayout.setStyle("-fx-background-color: #f4f4f9; -fx-padding: 20;");
        informationLayout.setAlignment(Pos.CENTER);
        return new Scene(informationLayout, 900, 600);
    }
}
