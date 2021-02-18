package diana.soleil.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView, questionTextView, scoreTextView,resultTextView;
    Button button1,button2,button3,button4,button5;
    int random1,random2,random4Numbers,theRightbutton,randomButton1,randomButton2,randomButton3;
    int counter,counterRightAnswer;
    public int random(){
        int i =  (int)(Math.random()*100) + 1 ;
        return i;
    }
    public int random4()
    {
        int j = (int)(Math.random()*4) +1;
        return  j;
    }
    public void questionTextView(){


        questionTextView.setText( String.valueOf(random1)+ " + " + String.valueOf(random2));

            if (Integer.parseInt(button1.getTag().toString())==random4Numbers) {
               button1.setText(String.valueOf(theRightbutton));
                button2.setText(String.valueOf(randomButton1));
                button3.setText(String.valueOf(randomButton2));
                button4.setText(String.valueOf(randomButton3));
            }else if (Integer.parseInt(button2.getTag().toString())==random4Numbers){
                button2.setText(String.valueOf(theRightbutton));
                button1.setText(String.valueOf(randomButton1));
                button3.setText(String.valueOf(randomButton2));
                button4.setText(String.valueOf(randomButton3));
        } else if (Integer.parseInt(button3.getTag().toString())==random4Numbers){
                button3.setText(String.valueOf(theRightbutton));
                button1.setText(String.valueOf(randomButton1));
                button2.setText(String.valueOf(randomButton2));
                button4.setText(String.valueOf(randomButton3));
            }else if (Integer.parseInt(button4.getTag().toString())==random4Numbers){
                button4.setText(String.valueOf(theRightbutton));
                button1.setText(String.valueOf(randomButton1));
                button3.setText(String.valueOf(randomButton2));
                button2.setText(String.valueOf(randomButton3));
            }
    }
    public void clicked (View view) {
        Button b = (Button) view;
       counter = counter + 1;
        scoreTextView.setText(String.valueOf(counterRightAnswer)+"/"+String.valueOf(counter));
        if (Integer.parseInt(b.getText().toString()) == theRightbutton) {
            counterRightAnswer = counterRightAnswer + 1;
            scoreTextView.setText(String.valueOf(counterRightAnswer)+"/"+String.valueOf(counter));
            resultTextView.setText("Great Job! Your Answer is Correct");
        } else {
            resultTextView.setText("It is okay! Your Answer is Wrong");
        }
        random1 = random();
        random2 = random();
        random4Numbers = random4();
        randomButton1 = random();
        randomButton2 = random();
        randomButton3 = random();
        theRightbutton = random1+random2;

        questionTextView();

    }





    public void timer () {
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                button5.setVisibility(View.VISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.INVISIBLE);
                timerTextView.setVisibility(View.INVISIBLE);
                questionTextView.setVisibility(View.INVISIBLE);
                resultTextView.setVisibility(View.INVISIBLE);


            }
        }.start();
    }
    public void restartTheGame(View view){
        button5.setVisibility(View.INVISIBLE);
        timer();
        scoreTextView.setText("0/0");
        counter = 0;
        counterRightAnswer=0;
        resultTextView.setText("");
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        questionTextView.setVisibility(View.VISIBLE);
        resultTextView.setVisibility(View.VISIBLE);
        counter = 0;
        counterRightAnswer=0;
        scoreTextView.setText(String.valueOf(counterRightAnswer)+"/"+String.valueOf(counter));
        resultTextView.setText("");
        button5.setText("Play Again!");
        random1 = random();
        random2 = random();
        random4Numbers = random4();
        randomButton1 = random();
        randomButton2 = random();
        randomButton3 = random();
        theRightbutton = random1+random2;
        //button5.setVisibility(View.INVISIBLE);
        timer();
        questionTextView();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        questionTextView = (TextView) findViewById(R.id.questionTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button5.setVisibility(View.VISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        questionTextView.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);

    }
}