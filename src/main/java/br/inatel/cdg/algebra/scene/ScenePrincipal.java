package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalculaCoeficienteAngular, btnCalculaCoeficienteLinear;
    private Label lblP1X,lblP1Y,lblP2X,lblP2Y;
    private TextField txtP1X,txtP1Y,txtP2X,txtP2Y, txtCoeficienteAngular, txtCoeficienteLinear;

    public void criaScenePrincipal(Stage stage){
        lblP1X = new Label("Ponto P1.X");
        txtP1X = new TextField();

        lblP1Y = new Label("Ponto P1.Y");
        txtP1Y = new TextField();

        lblP2X = new Label("Ponto P2.X");
        txtP2X = new TextField();

        lblP2Y = new Label("Ponto P2.Y");
        txtP2Y = new TextField();

        HBox hboxP1X = new HBox(lblP1X, txtP1X);
        HBox hboxP1Y = new HBox(lblP1Y, txtP1Y);
        HBox hboxP2X = new HBox(lblP2X, txtP2X);
        HBox hboxP2Y = new HBox(lblP2Y, txtP2Y);

        VBox vboxEntradaCoord = new VBox(hboxP1X,hboxP1Y,hboxP2X,hboxP2Y);

        txtCoeficienteAngular = new TextField();
        txtCoeficienteAngular.setEditable(false);
        txtCoeficienteAngular.setText("Coeficiente Angular: ");

        txtCoeficienteLinear = new TextField();
        txtCoeficienteLinear.setEditable(false);
        txtCoeficienteLinear.setText("Coeficiente Linear: ");

        HBox hboxRespostas = new HBox(txtCoeficienteAngular, txtCoeficienteLinear);

        btnCalculaCoeficienteAngular = new Button("Calcular Coeficiente Angular");
        btnCalculaCoeficienteAngular.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoeficienteAngular.setText("Coeficiente Angular: " + reta.calculaCoeficienteAngular());
        });

        btnCalculaCoeficienteLinear = new Button("Calcular Coeficiente Linear");
        btnCalculaCoeficienteLinear.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoeficienteLinear.setText("Coeficiente Linear: " + reta.calculaCoeficienteLinear());
        });

        HBox hBoxBotoes = new HBox(btnCalculaCoeficienteAngular, btnCalculaCoeficienteLinear);


        VBox layoutFinal = new VBox(vboxEntradaCoord,hboxRespostas, hBoxBotoes);

        Scene scene = new Scene(layoutFinal, 400 , 300);

        stage.setTitle("Calcula coeficiente linear e angular da reta");
        stage.setScene(scene);
        stage.show();
    }

    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(txtP1X.getText()),
                Double.parseDouble(txtP1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtP2X.getText()),
                Double.parseDouble(txtP2Y.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }

}