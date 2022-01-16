package my.project.scorekeeper;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    int americanoQuantity = 0;
    int latteQuantity = 0;
    int kapuchinoQuantity = 0;
    int costKapuchino = 45;
    int costAmericano = 40;
    int costLatte = 50;
    int sum = 0;
    boolean chekBoxAmericano = false;
    boolean chekBoxLatte = false;
    boolean chekBoxKapuchino = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void chekBoxChek() {
        String tempText = "";
        CheckBox cbAmericano = findViewById(R.id.checkBoxAmericano);
        CheckBox cbLatte = findViewById(R.id.checkBoxLate);
        CheckBox cbKapuchino = findViewById(R.id.checkBoxKapuchino);
        chekBoxAmericano = cbAmericano.isChecked();
        chekBoxKapuchino = cbKapuchino.isChecked();
        chekBoxLatte = cbLatte.isChecked();
        if (chekBoxLatte) tempText = tempText + "\n Латте со сливками ";
        if (chekBoxKapuchino) tempText = tempText + "\n Капучино со сливками ";
        if(chekBoxAmericano)  tempText = tempText + "\n Американо со сливками ";
        TextView tvSlivki = findViewById(R.id.textViewSlivki);
        tvSlivki.setText(tempText);

    }

    public void buttonSumOnClic(View view) {
        if (sum > 0) {
            TextView tv = findViewById(R.id.textViewTotalSumm);
            tv.setText("Итого: " + sum);
            EditText etEditText = findViewById(R.id.editText);
            TextView tvComment = findViewById(R.id.textViewComment);
            tvComment.setText("Комментарий:" + etEditText.getText());
            chekBoxChek();
            thanksMethod();
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Заказ Принят!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Выберите кофе!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void americanoPlus(View view) {
        displayAmericano(americanoQuantity = increment(americanoQuantity));
        sumPreChek();
        clearAllTextView();
    }

    public void americanoMinus(View view) {
        displayAmericano(americanoQuantity = decrement(americanoQuantity));
        sumPreChek();
        clearAllTextView();
    }

    public void lattePlus(View view) {
        displayLatte(latteQuantity = increment(latteQuantity));
        sumPreChek();
        clearAllTextView();
    }

    public void latteMinus(View view) {
        displayLatte(latteQuantity = decrement(latteQuantity));
        sumPreChek();
        clearAllTextView();
    }

    public void kapuchinoPlus(View view) {
        displayKapuchino(kapuchinoQuantity = increment(kapuchinoQuantity));
        sumPreChek();
        clearAllTextView();
    }

    public void kapuchinoMinus(View view) {
        displayKapuchino(kapuchinoQuantity = decrement(kapuchinoQuantity));
        sumPreChek();
        clearAllTextView();
    }


    public void displayAmericano(int n) {
        TextView Tv = findViewById(R.id.textViewAmericanoCount);
        Tv.setText("" + n);
        sumPreChek();
    }

    public void displayLatte(int n) {
        TextView Tv = findViewById(R.id.textViewLatteCount);
        Tv.setText("" + n);
    }

    public void displayKapuchino(int n) {
        TextView Tv = findViewById(R.id.textViewKapuchinoCount);
        Tv.setText("" + n);
    }

    public int increment(int n) {
        n++;
        return n;
    }

    public int decrement(int n) {
        if (n > 0) {
            n--;
            return n;
        } else
            return 0;
    }

    public void sumPreChek() {
        TextView tw = findViewById(R.id.textViewSumma);

        sum = kapuchinoQuantity * costKapuchino + americanoQuantity * costAmericano + latteQuantity * costLatte;
        tw.setText("" + sum);
    }
    public void thanksMethod()
    {
        TextView tw = findViewById(R.id.textViewThanks);
        tw.setText("Cпасибо за заказ)!");
    }
    public void  clearAllTextView()
    {
        TextView tw = findViewById(R.id.textViewThanks);
        tw.setText("");
        TextView tvSlivki = findViewById(R.id.textViewSlivki);
        tvSlivki.setText("Сливки:");
        TextView tvComment = findViewById(R.id.textViewComment);
        tvComment.setText("Комментарий:");
        TextView tv = findViewById(R.id.textViewTotalSumm);
        tv.setText("Итого:" );

    }

}