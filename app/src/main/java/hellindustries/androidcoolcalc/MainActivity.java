package hellindustries.androidcoolcalc;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    public enum Operation {ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL}

    String leftOperand = "";
    String rightOperand = "";
    String currentNumber = "";
    int result = 0;
    TextView resultView;
    Operation currentOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getActionBar().setElevation(0);

        Button button0 = (Button)findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);

        Button clearButton = (Button)findViewById(R.id.clearButton);
        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);
        ImageButton subButton = (ImageButton)findViewById(R.id.subButton);
        ImageButton divideButton = (ImageButton)findViewById(R.id.divideButton);
        ImageButton multiplyButton = (ImageButton)findViewById(R.id.multiplyButton);
        ImageButton equalButton = (ImageButton)findViewById(R.id.equalButton);

        resultView = (TextView)findViewById(R.id.result);

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed("9");
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperator(Operation.ADD);
            }
        });

        subButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperator(Operation.SUBTRACT);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperator(Operation.DIVIDE);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperator(Operation.MULTIPLY);
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperator(Operation.EQUAL);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                rightOperand = "";
                leftOperand = "";
                currentNumber = "";
                currentOperation = null;
                resultView.setText("0");
                result = 0;
            }
        });

    }

    private void processOperator(Operation operation){
        if(currentOperation != null){
            if(currentNumber != ""){

                rightOperand = currentNumber;
                currentNumber = "";
                switch(currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftOperand) + Integer.parseInt(rightOperand);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftOperand) - Integer.parseInt(rightOperand);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftOperand) / Integer.parseInt(rightOperand);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftOperand) * Integer.parseInt(rightOperand);
                        break;
                    case EQUAL:
                        break;
                }

                leftOperand = String.valueOf(result);
                resultView.setText(leftOperand);
            }
        } else {
            leftOperand = currentNumber;
            currentNumber = "";
        }

        currentOperation = operation;
    }

    private void numberPressed(String number){
        currentNumber += number;
        resultView.setText(currentNumber);
    }
}
