/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author fabre
 */
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class RevetementFenetre extends Application {
    
    
    private Stage appStage;
    private int nombreRectangles;
 public List<Mur> liste_murs;
    
    
    
    // Ajout du constructeur pour initialiser le nombre de rectangles
    public RevetementFenetre(int nombreRectangles) {
        this.nombreRectangles = nombreRectangles;
    }
private int getSelectedValue(ComboBox<Integer> comboBox) {
    return comboBox.getValue();
}


    private void saveButtonAction(Button saveButton, ComboBox<Integer> comboBox, String label) {
           
            System.out.println(label + " sélectionné : " +  comboBox.getValue());
          
        
    }
    
   /* private void ComboboxValue(ComboBox<Integer> comboBox) {
       prix_revetementValue=comboBox.getValue();
           
            return  prix_revetementValue;
          
        
    }*/
      public double Prix_mur(int nbrePortes, int nbreFenetres, double longueur, double hauteur, double prix_revetement) {
     double prix;      
     prix=(longueur * hauteur - 0.6 * nbrePortes - 0.6 * nbreFenetres) * prix_revetement + 200 * nbrePortes + 200 * nbreFenetres;
     System.out.println (prix);
        return prix;
     }
      
      public Mur RetrouverMur( int rectangleId, int numero_mur){
        for (Mur mur: liste_murs) {
            if (rectangleId == mur.getRectangleId() && numero_mur == mur.getNumero_mur()){
                return mur;}
        }
    return null;
      }
      
      private void MajMur (int rectangleId, int numero_mur, int nbrePortes, int nbreFenetres, List<Revetement> listeRevetement, double hauteur){
          Mur mur = RetrouverMur( rectangleId, numero_mur);
         // if ( mur=! null){    à remettre si on ajoute le null
              mur.setListeRevetement(listeRevetement);
              mur.setNbrePortes(nbrePortes);
              mur.setNbreFenetres(nbreFenetres);
              mur.setHauteur(hauteur);
              System.out.println(mur.toString());
              
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
              
          
     
    private void saveTextField(Button saveButton, TextField textField, String label) {
    
        
        System.out.println(label + " : " + textField.getText());
        
    }
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        appStage = primaryStage;
        
        int rectangleId;

        // Création du menu déroulant
        ComboBox<Integer> rectangleComboBox = createRectangleComboBox();
        ComboBox<Integer> AComboBox = createComboBox();
        ComboBox<Integer> BComboBox = createComboBox();
        ComboBox<Integer> CComboBox = createComboBox();
        ComboBox<Integer> DComboBox = createComboBox();
        ComboBox<Integer> EComboBox = createComboBox();
        
        TextField A1Text = createTextField();
        TextField A2Text = createTextField();
        TextField B1Text = createTextField();
        TextField B2Text = createTextField();
        TextField C1Text = createTextField();
        TextField C2Text = createTextField();
        TextField D1Text = createTextField();
        TextField D2Text = createTextField();
        TextField FText = createTextField();
        
        
       // Création des boutons "Enregistrer"
        Button saveButtonRectangle = new Button("Enregistrer");
        saveButtonRectangle.setOnAction(event -> {
            saveTextField(saveButtonRectangle, A1Text, "Nombre de portes");
          
        });
        rectangleId= rectangleComboBox.getValue();
       
        Button saveButton1 = new Button("Enregistrer");
        saveButton1.setOnAction(event -> {
            saveTextField(saveButton1, A1Text, "Nombre de portes");
        });

        Button saveButton2 = new Button("Enregistrer");
        saveButton2.setOnAction(event -> {
           saveTextField(saveButton2, B1Text, "Nombre de portes");
        });

        Button saveButton3 = new Button("Enregistrer");
        saveButton3.setOnAction(event -> {
            saveTextField(saveButton3, C1Text, "Nombre de portes");
        });

        Button saveButton4 = new Button("Enregistrer");
        saveButton4.setOnAction(event -> {
            saveTextField(saveButton4, D1Text, "Nombre de portes");
        });

        Button saveButton5 = new Button("Enregistrer");
        saveButton5.setOnAction(event -> {
            
        });
        
   
        Button saveButton6 = new Button("Enregistrer");
saveButton6.setOnAction(event -> {
    saveTextField(saveButton6, A2Text, "Nombre de fenetres");
   //  MajMur (rectangleId, 2, Integer.parseInt(A1Text.getText()),Integer.parseInt(A2Text.getText()) , Integer.parseInt(AComboBox.getValue()), Integer.parseInt(FText.getText()));
    
    

    
    

  /*  int nbrePortesValue = Integer.parseInt(A1Text.getText());
    int nbreFenetresValue = Integer.parseInt(A2Text.getText());
    double longueurValue = rectangles[1][1];
    double hauteurValue = Double.parseDouble(FText.getText());
    double prix_revetementValue = AComboBox.getValue().doubleValue();*/

  
   
   // Prix_mur(Integer.parseInt(A1Text.getText()), 
   //      Integer.parseInt(A2Text.getText()), 
   //      rectangles[1][1], 
   //      Double.parseDouble(FText.getText()), 
   //      AComboBox.getValue().doubleValue());
    
     
});


        Button saveButton7 = new Button("Enregistrer");
        saveButton7.setOnAction(event -> {
             saveTextField(saveButton7, B2Text, "Nombre de fenetres");
        });

        Button saveButton8 = new Button("Enregistrer");
        saveButton8.setOnAction(event -> {
             saveTextField(saveButton8, C2Text, "Nombre de fenetres");
        });

        Button saveButton9 = new Button("Enregistrer");
        saveButton9.setOnAction(event -> {
            saveTextField(saveButton9, D2Text, "Nombre de fenetres");
        });

        Button saveButton10 = new Button("Enregistrer");
        saveButton10.setOnAction(event -> {
            // Ajouter ici la logique pour le revêtement sol
        });
        
         Button saveButtonA= new Button("Enregistrer");
         saveButtonA.setOnAction(event -> {
           saveButtonAction(saveButtonA, AComboBox , "Revêtements mur intérieur droit:");
         
           
       });

        Button saveButtonB = new Button("Enregistrer");
        saveButtonB.setOnAction(event -> {
        saveButtonAction(saveButtonB, BComboBox , "Revêtements mur intérieur gauche:");
});
        
        Button saveButtonC = new Button("Enregistrer");
        saveButtonC.setOnAction(event -> {
        saveButtonAction(saveButtonC, CComboBox , "Revêtements mur intérieur haut:");
});
        
        Button saveButtonD = new Button("Enregistrer");
        saveButtonD.setOnAction(event -> {
        saveButtonAction(saveButtonD, DComboBox , "Revêtements mur intérieur bas:");
});
        
        Button saveButtonE = new Button("Enregistrer");
        saveButtonE.setOnAction(event -> {
        saveButtonAction(saveButtonE, EComboBox , "Revêtements sol:");
        });
        
        Button saveButtonF = new Button("Enregistrer");
        saveButtonF.setOnAction(event -> {
            saveTextField(saveButtonF, FText, "Hauteur plafond");
        });
        
        Button FinButton = new Button("Fin");
        FinButton.setOnAction(event -> {
            primaryStage.close();    
        });

        // Création des libellés 
        Text label1 = new Text("Revêtements mur intérieur droit:");
        Text label2 = new Text("Revêtements mur intérieur gauche:");
        Text label3 = new Text("Revêtements mur intérieur haut:");
        Text label4 = new Text("Revêtements mur intérieur bas:");
        Text label5 = new Text("Revêtements sol:");
        Text label6 = new Text("Hauteur plafond:");
        
        // Création de la grille pour organiser les éléments
        GridPane root = new GridPane();
        root.addRow(0, new Label("Rectangle:"), rectangleComboBox, saveButtonRectangle);
        root.addRow(1, label1, AComboBox,saveButtonA, new Label("Nombre de portes:"), A1Text ,saveButton1, new Label("Nombre de fenêtres:"), A2Text , saveButton6);
        root.addRow(2, label2, BComboBox,saveButtonB, new Label("Nombre de portes:"), B1Text ,saveButton2, new Label("Nombre de fenêtres:"), B2Text , saveButton7);
        root.addRow(3, label3, CComboBox,saveButtonC, new Label("Nombre de portes:"), C1Text ,saveButton3, new Label("Nombre de fenêtres:"), C2Text , saveButton8);
        root.addRow(4, label4, DComboBox,saveButtonD, new Label("Nombre de portes:"), D1Text ,saveButton4, new Label("Nombre de fenêtres:"), D2Text , saveButton9);
        root.addRow(5, label5, EComboBox,saveButtonE);
        root.addRow(8,new Label(" "), new Label(" "),new Label(" "), label6, FText ,saveButtonF);
        root.addRow(11,new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "), new Label(" "),new Label(" "),FinButton);

        // Espacement et alignement des éléments
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        
        // Création de la scène et affichage de la fenêtre
        Scene scene = new Scene(root, 1100, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Choisir revêtements");
        primaryStage.show();
    }

    
    private TextField createTextField() {
    TextField textField = new TextField();
    textField.setText("0");
    return textField;
}
    
    
    private ComboBox<Integer> createComboBox() {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= 14; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(1); // Définition de la valeur par défaut
        return comboBox;
    }
    
    private ComboBox<Integer> createRectangleComboBox() {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= nombreRectangles; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(nombreRectangles); // Définition de la valeur par défaut
        return comboBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// Surface mur haut bas = hauteur plafond x largeur - nb porte - nb fenetre
// Surface mur droite gauche = hauteur plafond x longueur - nb porte - nb fenetre
// Surface Sol = longueur x largeur - tremis


// prix mur haut bas = (prix m2)x(Surface) + prix porte + prix fenetre
// prix mur droite gauche = (prix m2)x(Surface) + prix porte + prix fenetre
// prix sol = (prix m2)xsurface + prix trémis
