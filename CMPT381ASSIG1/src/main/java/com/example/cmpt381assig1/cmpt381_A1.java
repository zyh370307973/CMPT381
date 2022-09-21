package com.example.cmpt381assig1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class cmpt381_A1 extends Application {

    public ArrayList<House> getInfo() {
        ArrayList<House> houses = new ArrayList<House>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("houses.txt"));
            if (br.ready()) {
                String content = br.readLine();
                String[] lines = content.substring(1, content.length() - 2).split(", ");
                for (String line : lines) {
                    String[] parts = line.substring(1, line.length() - 1).split(",");
                    houses.add(new House(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (House house : houses) {
            System.out.println(house);
        }

        return houses;
    }
    public ArrayList<SearchSpec> saved_info (){
        ArrayList<SearchSpec> yourchoice = new ArrayList<>();
        return yourchoice;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        AnchorPane left = new AnchorPane();
        AnchorPane right = new AnchorPane();
        AnchorPane.setLeftAnchor(right, 420.0);
        right.setPrefHeight(500);
        primaryStage.setTitle("381A1");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        Button set = new Button();
        set.setText("Set");
        set.setLayoutX(100);
        set.setLayoutY(100);

        Button save = new Button();
        save.setText("Save");
        save.setLayoutX(100);
        save.setLayoutY(100);

        Button load_search = new Button();
        load_search.setText("Load Search");
        load_search.setLayoutX(100);
        load_search.setLayoutY(100);
        load_search.setPrefWidth(180);

        Button clear_filters = new Button();
        clear_filters.setText("Clear Filters");
        clear_filters.setLayoutX(100);
        clear_filters.setLayoutY(100);
        clear_filters.setPrefWidth(180);

        Button quit = new Button();
        quit.setText("Quit");
        quit.setLayoutX(100);
        quit.setLayoutY(100);
        quit.setPrefWidth(180);

        HBox rightbutton_box = new HBox();
        rightbutton_box.setPrefWidth(200);
        rightbutton_box.setPrefHeight(100);
        rightbutton_box.getChildren().addAll(load_search, clear_filters, quit);
        ObservableList <House> house_info = FXCollections.observableArrayList(getInfo());
        ListView<House> house_sale = new ListView<House>(house_info);
        ObservableList<SearchSpec> saved_search = FXCollections.observableArrayList();
        ListView<SearchSpec> Saved_Sale = new ListView<SearchSpec>(saved_search);


        Saved_Sale.setPrefWidth(600);
        Saved_Sale.setPrefHeight(428);
        house_sale.setPrefWidth(600);
        house_sale.setPrefHeight(400);
        AnchorPane.setLeftAnchor(house_sale, 10.0);
        AnchorPane.setTopAnchor(house_sale, 30.0);





        Label Save_Searches = new Label("Saved Searches");

        VBox rightvbox = new VBox();
        rightvbox.setPrefWidth(400);
        rightvbox.setPrefHeight(800);
        rightvbox.getChildren().addAll(Save_Searches, Saved_Sale, rightbutton_box);

        Slider price_upper = new Slider(150000, 800000, 150000);
        price_upper.setPrefWidth(240);
        Slider price_lower = new Slider(150000, 800000, 150000);
        price_lower.setPrefWidth(240);
        VBox Slider_box = new VBox();
        Slider_box.getChildren().addAll(price_upper, price_lower);

        Label House_for_sale = new Label("House For Sale");
        House_for_sale.setFont(new Font("Arial", 30));

        HBox pricetool = new HBox();
        Label price = new Label("Price");
        Label range = new Label("150000 - 800000");
        pricetool.setPrefWidth(410);
        pricetool.setPrefHeight(25);
        AnchorPane.setTopAnchor(pricetool, 500.0);
        AnchorPane.setLeftAnchor(pricetool, 0.0);
        pricetool.setStyle("-fx-background-color:#C0C0C0");
        pricetool.getChildren().addAll(price, Slider_box, range, set);

        Label SaveSearch = new Label("Save Search:");
        Save_Searches.setFont(new Font("Arial", 30));
        TextField name = new TextField();
        name.setPrefWidth(285);
        HBox searchtool = new HBox();
        searchtool.setPrefWidth(410);
        searchtool.setPrefHeight(30);
        AnchorPane.setLeftAnchor(searchtool, 0.0);
        AnchorPane.setTopAnchor(searchtool, 0.0);
        searchtool.getChildren().addAll(SaveSearch, name, save);


        VBox leftvbox = new VBox();
        leftvbox.setPrefWidth(400);
        leftvbox.setPrefHeight(1200);
        AnchorPane.setLeftAnchor(leftvbox, 10.0);
        leftvbox.getChildren().addAll(House_for_sale, house_sale, pricetool, searchtool);


        left.getChildren().addAll(leftvbox);
        right.getChildren().addAll(rightvbox);
        root.getChildren().addAll(left, right);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


    }
    public class House {
        String address;

        int price, area, numberOfBR, numberOfBath;

        public House (){}

        public House (String address, String price, String area, String numberOfBR, String numberOfBath) {
            this.address = address;
            this.price = Integer.parseInt(price);
            this.area = Integer.parseInt(area);
            this.numberOfBR = Integer.parseInt(numberOfBR);
            this.numberOfBath = Integer.parseInt(numberOfBath);
        }

        public String getAddress(){return address;}

        public int getPrice(){return price;}

        public int getArea(){return area;}

        public int getNumberOfBR(){return numberOfBR;}

        public int getNumberOfBath(){return numberOfBath;}

        public void setAddress(String address){this.address = address;}

        public void setArea(String area){this.area = Integer.parseInt(area);}

        public void setNumberOfBR(String numberOfBR){this.numberOfBR = Integer.parseInt(numberOfBR);}

        public void setNumberOfBath(String numberOfBath){this.numberOfBath = Integer.parseInt(numberOfBath);}


        @Override
        public String toString() {

            return
                      address + '\'' +
                    ", price is'" + price + '\'' +
                    ", area is'" + area + '\'' +
                    ", numberOfBR :'" + numberOfBR + '\'' +
                    ", numberOfBath :'" + numberOfBath + '\'' + """
                              """
                    ;
        }
    }
     public class SearchSpec{
        String address;

        int price, area, numberOfBR, numberOfBath;

    }




}

