


//isLetterKey ->says if a char is letter a-z
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.util.Duration;
import javafx.scene.text.Text;
import java.io.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.*;
import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class hangman extends Application {
    //boolean inGame =true;
    boolean a=false;

    @Override
    public void start(Stage stage) throws  IOException {
        boolean play=true;
        boolean inGame=true;
        a = false;
        
        Randomaccess theFile = new Randomaccess();
        
        Button no=new Button();
        no.setVisible(false);
        Button yes=new Button();
        yes.setVisible(false);
        Text pa=new Text();
        pa.setVisible(false);
        
        Line base = new Line();
        base.setStartX(50.0f);
        base.setStartY(250.0f);
        base.setEndX(150.0f);
        base.setEndY(250.0f);
        base.setStrokeWidth(5);
        //base.setVisible(false);
        
        Line pole = new Line();
        pole.setStartX(100.0f);
        pole.setStartY(250.0f);
        pole.setEndX(100.0f);
        pole.setEndY(50.0f);
        pole.setStrokeWidth(5);
        //pole.setVisible(false);
        
        
        Line over = new Line();
        over.setStartX(100.0f);
        over.setStartY(50.0f);
        over.setEndX(200.0f);
        over.setEndY(50.0f);
        over.setStrokeWidth(5);
        //over.setVisible(false);
        
        Line down = new Line();
        down.setStartX(200.0f);
        down.setStartY(75.0f);
        down.setEndX(200.0f);
        down.setEndY(50.0f);
        down.setStrokeWidth(5);
        //down.setVisible(false);
        
        Circle head = new Circle();
        head.setCenterX(200.0f);
        head.setCenterY(100.0f);
        head.setRadius(25.0f);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        head.setVisible(false);
        
        Line back = new Line();
        back.setStartX(200.0f);
        back.setStartY(127.0f);
        back.setEndX(200.0f);
        back.setEndY(175.0f);
        back.setStrokeWidth(5);
        back.setVisible(false);
        
        Line arm1 = new Line();
        arm1.setStartX(150.0f);
        arm1.setStartY(150.0f);
        arm1.setEndX(200.0f);
        arm1.setEndY(150.0f);
        arm1.setStrokeWidth(5);
        arm1.setVisible(false);
        
        Line arm2 = new Line();
        arm2.setStartX(200.0f);
        arm2.setStartY(150.0f);
        arm2.setEndX(250.0f);
        arm2.setEndY(150.0f);
        arm2.setStrokeWidth(5);
        arm2.setVisible(false);
        
        Line leg1 = new Line();
        leg1.setStartX(200.0f);
        leg1.setStartY(175.0f);
        leg1.setEndX(150.0f);
        leg1.setEndY(225.0f);
        leg1.setStrokeWidth(5);
        leg1.setVisible(false);
        
        Line leg2 = new Line();
        leg2.setStartX(200.0f);
        leg2.setStartY(175.0f);
        leg2.setEndX(250.0f);
        leg2.setEndY(225.0f);
        leg2.setStrokeWidth(5);
        leg2.setVisible(false);
        
        Circle eye1 = new Circle();
        eye1.setCenterX(190.0f);
        eye1.setCenterY(90.0f);
        eye1.setRadius(3.0f);
        eye1.setFill(Color.WHITE);
        eye1.setStroke(Color.BLACK);
        eye1.setVisible(false);
        
        Circle eye2 = new Circle();
        eye2.setCenterX(210.0f);
        eye2.setCenterY(90.0f);
        eye2.setRadius(3.0f);
        eye2.setFill(Color.WHITE);
        eye2.setStroke(Color.BLACK);
        eye2.setVisible(false);
        
        Arc mouth = new Arc();
        mouth.setCenterX(200.0f); 
        mouth.setCenterY(110.0f); 
        mouth.setRadiusX(15.0f); 
        mouth.setRadiusY(15.0f); 
        mouth.setStartAngle(0.0f); 
        mouth.setLength(180.0f); 
        mouth.setType(ArcType.OPEN);
        mouth.setVisible(false);
        
        TextField g=new TextField();
        HBox t = new HBox(g);
        g.setPrefWidth(100);
        t.setTranslateX(400);
        t.setTranslateY(100);
        
        Button submit=new Button();
        submit.setText("Enter");
        submit.setTranslateX(500);
        submit.setTranslateY(100);
 
        //int i;
        //int  n = (int) (Math.random()*58113 + 1);
        //File file = new file("wordList.txt");
        //File tex = new File("wordList.txt");
        //Scanner sc = new Scanner(tex);
        String word = theFile.str;
        System.out.println(word);
        //int q=1;
        //while(sc.hasNextLine()&&q<n)
        //{
            //word = sc.nextLine();
            //System.out.println(word);
            //q++;
        //}

        //String word = "long john silvers";
        char[] wordlet = word.toCharArray();
        ArrayList<Line>space = new ArrayList <Line>();
        ArrayList<Text>let = new ArrayList<Text>();
        //System.out.println(wordlet.length);
        //space[0]=new Line(25+0,295,45+0,295);
        //int b=0;
        for(int i=0; i<wordlet.length;i++)
        {
            space.add(new Line(25+(25*i),295,45+(25*i),295));
            let.add(new Text());
            let.get(i).setX((i*25)+25);
            let.get(i).setY(275);
            let.get(i).setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
            let.get(i).setFill(Color.BLACK);
            let.get(i).setStroke(Color.BLACK);
            let.get(i).setStrokeWidth(1);
            let.get(i).setText(Character.toString(wordlet[i]));
            let.get(i).setVisible(false);
            
            //System.out.println(space.get(7));
            //b++;
        }
        //System.out.println(b);
        
        
        for(int i=0;i<space.size();i++)
        {
            System.out.println(space.get(i));
        }
        Set<Character> guessed = new HashSet <Character>();
        guessed.add(' ');
       
      
        Group root = new Group(base,pole,over,down,head,back,arm1,arm2,leg1,leg2,eye1,eye2,mouth,t);
        for(int i=0;i<space.size();i++)
        {
            if (wordlet[i]!=' ')
            root.getChildren().add(space.get(i));
            root.getChildren().add(let.get(i));
        }
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Drawing stuff");

        
        
        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
        
             
        
         /*scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.ENTER) {
                System.out.println("You pressed enter");
                char c=g.getText().charAt(0);
                if (key..isLetterKey())
                {
                guessed.add(c);
                System.out.println(c);
                }//movement
                
                Text text=new Text();
                text.setX(375);
                text.setY(70);
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                text.setFill(Color.BLACK);
                text.setStroke(Color.BLACK);
                text.setStrokeWidth(1);
                text.setText("Guess a letter");
                
                root.getChildren().add(text);
            }
        });*/
                Text text=new Text();
                text.setX(375);
                text.setY(70);
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                text.setFill(Color.BLACK);
                text.setStroke(Color.BLACK);
                text.setStrokeWidth(1);
                text.setText("Guess a letter");
                
                root.getChildren().add(text);
                //int c=0;
        g.setOnKeyPressed((KeyEvent e) -> {
            
            if (e.getCode().isLetterKey()&&play==true) {
                int spc=0;
                for (int j=0;j<wordlet.length;j++)
                {
                    if (wordlet[j]==' ')
                    {
                        spc+=1;
                    }
                }
                int c = 0;
                
        
                Text go=new Text();
                go.setX(375);
                go.setY(70);
                go.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                go.setFill(Color.BLACK);
                go.setStroke(Color.BLACK);
                go.setStrokeWidth(1);
                go.setText("Game Over!");
                go.setVisible(false);
                root.getChildren().add(go);
                
                Text v=new Text();
                v.setX(375);
                v.setY(70);
                v.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                v.setFill(Color.BLACK);
                v.setStroke(Color.BLACK);
                v.setStrokeWidth(1);
                v.setText("You Win!");
                v.setVisible(false);
                root.getChildren().add(v);
                
                char ch=g.getText().charAt(0);
                guessed.add(ch);
                System.out.println(guessed);
                //System.out.println(c);
                g.setText("");
                boolean game=true;
                
                
                for (int j=0;j<wordlet.length;j++)
            {   //int c = 0;
                
                //int bodyCount;
                //bodyCount = guessed.size()-c-1;
                //System.out.println(bodyCount);
                /*int bodyCount;
                bodyCount = guessed.size()-c;
                System.out.println(bodyCount+" BC");*/
                if (guessed.contains(wordlet[j]) && wordlet[j]!=' ')
                {   
                    let.get(j).setVisible(true);
                    c++;
                    //System.out.println(c+" C");
                    if (c+spc>=wordlet.length)
                    {
                        game=false;
                        //v.setVisible();
                    }
                    //bodyCount = guessed.size()-c-1;
                    //System.out.println(bodyCount);
                    /*
                    if (bodyCount>=1)
                    {
                    head.setVisible(true);
                    }
                    if(bodyCount>=2)
                    {
                    back.setVisible(true);
                    }
                    if(bodyCount>=3)
                    {
                    arm1.setVisible(true);
                    }
                    if(bodyCount>=4)
                    {
                    arm2.setVisible(true);
                    }
                    if(bodyCount>=5)
                    {
                    leg1.setVisible(true);
                    }
                    if(bodyCount>=6)
                    {
                    leg2.setVisible(true);
                    }
                    if(bodyCount>=7)
                    {
                    eye2.setVisible(true);
                    eye1.setVisible(true);
                    }
                    if(bodyCount>=8)
                    {
                    mouth.setVisible(true);
                    game = false;
                    go.setVisible(true);
                    text.setVisible(false);
                    }*/
                }
                    /*int bodyCount;
                    bodyCount = guessed.size()-c;
                    System.out.println(bodyCount+" BC");*/
                    
                    
                
                  
                if (c==wordlet.length)
                {
                    game=false;
                    
                }
        }
        int bodyCount;
        bodyCount = guessed.size()-c-1;
        //System.out.println(bodyCount+" BC");
        if (bodyCount>=1)
                    {
                    head.setVisible(true);
                    }
                    
                    if(bodyCount>=2)
                    {
                    back.setVisible(true);
                    }
                    if(bodyCount>=3)
                    {
                    arm1.setVisible(true);
                    }
                    if(bodyCount>=4)
                    {
                    arm2.setVisible(true);
                    }
                    if(bodyCount>=5)
                    {
                    leg1.setVisible(true);
                    }
                    if(bodyCount>=6)
                    {
                    leg2.setVisible(true);
                    }
                    if(bodyCount>=7)
                    {
                    eye2.setVisible(true);
                    eye1.setVisible(true);
                    }
                    if(bodyCount>=8)
                    {
                    mouth.setVisible(true);
                    game = false;
                    go.setVisible(true);
                    text.setVisible(false);
                    }
        if (game == false)
        {
            text.setVisible(false);
            t.setVisible(false);
            if (bodyCount<8)
            {
                v.setVisible(true);
            }
            
            yes.setText("yes");
            yes.setTranslateX(400);
            yes.setTranslateY(200);
            yes.setVisible(true);
            
            no.setText("no");
            no.setTranslateX(450);
            no.setTranslateY(200);
            no.setVisible(true);
            
            
            pa.setX(300);
            pa.setY(150);
            pa.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
            pa.setFill(Color.BLACK);
            pa.setStroke(Color.BLACK);
            pa.setStrokeWidth(1);
            pa.setText("Do you want to play again?");
            pa.setVisible(true);
            root.getChildren().add(pa);
            
            root.getChildren().add(no);
            root.getChildren().add(yes);
            
            
            
        }
        else
        {
        }
            }
            else{
            g.setText("");
            }
            
        });
            //Button no=new Button();
            no.setVisible(false);
            //Button yes=new Button();
            yes.setVisible(false);
            yes.setText("yes");
            yes.setTranslateX(400);
            yes.setTranslateY(200);
            yes.setVisible(true);
            
            no.setText("no");
            no.setTranslateX(450);
            no.setTranslateY(200);
            no.setVisible(true);
            yes.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                
                //hang(scene);
                //start(stage);
                System.out.println("Check");
                }
            });
        
            no.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                //inGame=false;
                System.exit(0);
                System.out.println("Check");
                }
            });//System.out.print("check");   
        
        //guessed.add(guess);
        
        /*for (int j=0;j<wordlet.length;j++)
            {   int c = 0;
                
                if (guessed.contains(wordlet[j]) && wordlet[j]!=' ')
                {   
                    
                    c++;
                    System.out.println(c);
                    bodyCount = guessed.size()-c;
                    System.out.println(bodyCount);
                    if (bodyCount>=1)
                    {
                    head.setVisible(true);
                    } 
                }
                
                
                
                  
                if (c==wordlet.length)
                {
                    game=false;
                }
        }*/
        //}
        //});
        
      
        
      
     
    }
    public static void main(String args[]){
        launch(args);
        Button no=new Button();
        no.setVisible(false);
        Button yes=new Button();
        yes.setVisible(false);
        
        
        
        
        
         yes.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                //inGame=true;
                launch(args);
                //start(stage);
                System.out.println("Check");
                }
            });
            no.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                //inGame=false;
                System.exit(0);
                System.out.println("Check");
                }
            });

    }
    
   }
