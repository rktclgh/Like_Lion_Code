package com.sec17.obj;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CalcClientFx extends Application {

	@Override
	public void start(Stage stage) {
		// 입력 필드
		TextField numTf01 = new TextField();
		TextField numTf02 = new TextField();
		ComboBox<String> opBox = new ComboBox<>();
		opBox.getItems().addAll("+", "-", "*", "/");
		opBox.setValue("+");

		Button calcBtn = new Button("🧮 계산하기");
		Label resultLabel = new Label("결과: -");
		resultLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

		calcBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 13;");

		calcBtn.setOnAction(e -> {
			try {
				double a = Double.parseDouble(numTf01.getText());
				double b = Double.parseDouble(numTf02.getText());
				String op = opBox.getValue();

				SendData res = sendDataServer(new SendData(a, b, op));
				resultLabel.setText("결과: " + res.getResult());
			} catch (Exception ex) {
				resultLabel.setText("❌ 계산 실패: 입력을 확인하세요.");
			}
		});

		// 레이아웃 구성
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setVgap(15);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);

		grid.add(new Label("숫자 1:"), 0, 0);
		grid.add(numTf01, 1, 0);

		grid.add(new Label("연산자:"), 0, 1);
		grid.add(opBox, 1, 1);

		grid.add(new Label("숫자 2:"), 0, 2);
		grid.add(numTf02, 1, 2);

		grid.add(calcBtn, 0, 3, 2, 1);
		grid.add(resultLabel, 0, 4, 2, 1);

		GridPane.setHalignment(calcBtn, HPos.CENTER);
		GridPane.setHalignment(resultLabel, HPos.CENTER);

		Scene scene = new Scene(grid, 350, 280);
		stage.setScene(scene);
		stage.setTitle("💻 계산기 클라이언트");
		stage.show();
	}

	private SendData sendDataServer(SendData data) throws IOException, ClassNotFoundException {
		try (Socket socket = new Socket("localhost", 7777);
			 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

			oos.writeObject(data);
			oos.flush();
			return (SendData) ois.readObject();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
