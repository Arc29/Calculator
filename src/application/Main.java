package application;
	
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.*;

public class Main extends Application {
	TextField screen;
	String expression;
	InPost ss;
	boolean isRad;
	int baseSet;
	TextField base;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calculator-@Chat");
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			expression="";
			ss=new InPost();
			primaryStage.setScene(scene);
			Button bt1=new Button("1");
			Button bt2=new Button("2");
			Button bt3=new Button("3");
			Button bt4=new Button("4");
			Button bt5=new Button("5");
			Button bt6=new Button("6");
			Button bt7=new Button("7");
			Button bt8=new Button("8");
			Button bt9=new Button("9");
			Button bt0=new Button("0");
			Button btplus=new Button("+");
			Button btsub=new Button("-");
			Button btmul=new Button("*");
			Button btdiv=new Button("/");
			Button btc=new Button("C");
			Button btac=new Button("AC");
			Button bteq=new Button("=");
            Button btdec=new Button(".");
            Button btopb=new Button("(");
            Button btclb=new Button(")");
            Button btsin=new Button("sin");
            Button btcos=new Button("cos");
            Button bttan=new Button("tan");
            Button btlog=new Button("log");
            Button btlgn=new Button("lgn");
            Button btexp=new Button("exp");
            Button btA=new Button("A");
            Button btB=new Button("B");
            Button btC=new Button("C");
            Button btD=new Button("D");
            Button btE=new Button("E");
            Button btF=new Button("F");
            RadioButton btdeg=new RadioButton("Degree");
            RadioButton btrad=new RadioButton("Radians");
            ToggleGroup tg=new ToggleGroup();
            TextField base=new TextField("10");
            base.setPromptText("Enter base");
            btdeg.setToggleGroup(tg);
            btrad.setToggleGroup(tg);
			screen=new TextField();
			screen.setPrefColumnCount(400);
			FlowPane console=new FlowPane(10,10);
		    bt1.setPrefWidth(90.0);
		    bt2.setPrefWidth(90.0);
		    bt3.setPrefWidth(90.0);
		    bt4.setPrefWidth(90.0);
		    bt5.setPrefWidth(90.0);
		    bt6.setPrefWidth(90.0);
		    bt7.setPrefWidth(90.0);
		    bt8.setPrefWidth(90.0);
		    bt9.setPrefWidth(90.0);
		    bt0.setPrefWidth(90.0);
		    btplus.setPrefWidth(90.0);
		    btsub.setPrefWidth(90.0);
		    btmul.setPrefWidth(90.0);
		    btdiv.setPrefWidth(90.0);
		    btc.setPrefWidth(90.0);
		    btac.setPrefWidth(90.0);
		    bteq.setPrefWidth(90.0);
		    btdec.setPrefWidth(90.0);
		    btopb.setPrefWidth(90.0);
		    btclb.setPrefWidth(90.0);
		    btsin.setPrefWidth(90.0);
		    btcos.setPrefWidth(90.0);
		    bttan.setPrefWidth(90.0);
		    btlog.setPrefWidth(90.0);
		    btlgn.setPrefWidth(90.0);
		    btexp.setPrefWidth(90.0);
		    btA.setPrefWidth(56.0);
		    btB.setPrefWidth(56.0);
		    btC.setPrefWidth(56.0);
		    btD.setPrefWidth(56.0);
		    btE.setPrefWidth(56.0);
		    btF.setPrefWidth(56.0);
		    console.setAlignment(Pos.CENTER);
		    Separator sep=new Separator();
		    Separator sep1=new Separator();
		    sep.setPrefWidth(400.0);
		    sep1.setPrefWidth(400.0);
		    console.getChildren().addAll(btdeg,btrad,base,sep,btac,btc,btdiv,btmul,bt7,bt8,bt9,btsub,bt4,bt5,bt6,btplus,bt1,bt2,bt3,bteq,bt0,btdec,btopb,btclb,btA,btB,btC,btD,btE,btF,sep1,btsin,btcos,bttan,btlog,btlgn,btexp);
		    root.setTop(screen);
		    root.setCenter(console);
		    EventHandler<ActionEvent> numhandle=new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		expression+=((Button)ae.getTarget()).getText();
		    		screen.setText(expression);
		    	}
		    };
		    EventHandler<ActionEvent> funchandle=new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		expression+=((Button)ae.getTarget()).getText();
		    		screen.setText(expression);
		    		
		    	}
		    };
		    bt1.setOnAction(numhandle);
		    bt2.setOnAction(numhandle);
		    bt3.setOnAction(numhandle);
		    bt4.setOnAction(numhandle);
		    bt5.setOnAction(numhandle);
		    bt6.setOnAction(numhandle);
		    bt7.setOnAction(numhandle);
		    bt8.setOnAction(numhandle);
		    bt9.setOnAction(numhandle);
		    bt0.setOnAction(numhandle);
		    btplus.setOnAction(numhandle);
		    btsub.setOnAction(numhandle);
		    btmul.setOnAction(numhandle);
		    btdiv.setOnAction(numhandle);
		    btdec.setOnAction(numhandle);
		    btopb.setOnAction(numhandle);
		    btclb.setOnAction(numhandle);
		    btsin.setOnAction(funchandle);
		    btcos.setOnAction(funchandle);
		    bttan.setOnAction(funchandle);
		    btlog.setOnAction(funchandle);
		    btlgn.setOnAction(funchandle);
		    btexp.setOnAction(funchandle);
		    btA.setOnAction(numhandle);
		    btB.setOnAction(numhandle);
		    btC.setOnAction(numhandle);
		    btD.setOnAction(numhandle);
		    btE.setOnAction(numhandle);
		    btF.setOnAction(numhandle);
		    btc.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		if(expression.length()>0)
		    		expression=expression.substring(0, expression.length()-1);
		    		screen.setText(expression);
		    	}
		    });
		    btac.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		expression="";
		    		screen.setText("");
		    	}
		    	
		    	});
		    baseSet=10;
		    if(baseSet<=10) {
		    	btA.setDisable(true);
		    	btB.setDisable(true);
		    	btC.setDisable(true);
		    	btD.setDisable(true);
		    	btE.setDisable(true);
		    	btF.setDisable(true);
		    }
		    base.setOnAction(new EventHandler<ActionEvent>(){
		    	public void handle(ActionEvent ae) {
		    		if(Integer.parseInt(base.getText())<2) {
		    			baseSet=10;
		    			base.setText("10");
		    		}
		    		else
		    			baseSet=Integer.parseInt(base.getText());
		    		if(baseSet<=10) {
				    	btA.setDisable(true);
				    	btB.setDisable(true);
				    	btC.setDisable(true);
				    	btD.setDisable(true);
				    	btE.setDisable(true);
				    	btF.setDisable(true);
				    }
		    		else {
		    			btA.setDisable(false);
				    	btB.setDisable(false);
				    	btC.setDisable(false);
				    	btD.setDisable(false);
				    	btE.setDisable(false);
				    	btF.setDisable(false);
		    		}
		    	}
		    });
		    tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		    	public void changed(ObservableValue<? extends Toggle> changed,Toggle oldval,Toggle newval) {
		    		RadioButton rb=(RadioButton) newval;
		    		if(rb.getText().equals("Degree"))
		    			isRad=false;
		    			else
		    				isRad=true;
		    	}
		    });
		    btdeg.fire();
		    bteq.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		expression=screen.getText();
		    		ss.infix=expression;
		    		expression=(ss.stackSolv(ss.convert(),baseSet,isRad));
		    	    screen.setText(expression);
		    	}
		    });
		    screen.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent ae) {
		    		expression=screen.getText();
		    		ss.infix=expression;
		    		expression=(ss.stackSolv(ss.convert(),baseSet,isRad));
		    	    screen.setText(expression);
		    	}
		    });
		    
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
