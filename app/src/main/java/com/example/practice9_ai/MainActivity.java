package com.example.practice9_ai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practice9_ai.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonPaper.setOnClickListener(view -> game("보"));
        binding.buttonRock.setOnClickListener(view -> game("바위"));
        binding.buttonScissors.setOnClickListener(view -> game("가위"));
    }

    private void game(String yourChoice) {
        int ai = random.nextInt(3);
        String aiChoice;
        switch (ai) {
            case 0:
                aiChoice = "가위";
                break;
            case 1:
                aiChoice = "바위";
                break;
            default:
                aiChoice = "보";
        }

        binding.textAi.setText("AI가" + aiChoice + "를 냈습니다.");
        binding.textYou.setText("당신은" + yourChoice + "를 냈습니다.");

        String result;

        if (aiChoice.equals(yourChoice)) {
            result = "비겼습니다!";
        } else if ((aiChoice.equals("가위") && yourChoice.equals("바위")) ||
                (aiChoice.equals("바위") && yourChoice.equals("보")) ||
                (aiChoice.equals("보") && yourChoice.equals("가위"))) {
            result = "축하합니다! 당신이 이겼습니다!";
        } else {
            result = "미안합니다! 당신이 졌습니다ㅜㅜ";
        }
        binding.textResults.setText(result);
    }
}