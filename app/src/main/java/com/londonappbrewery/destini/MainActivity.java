package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        // Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini","Top Button Pressed");

                switch(mStoryIndex){
                    case 1:
                        // Story 1 and 2 Top Button both move to Story 3.
                        // Fall through.
                    case 2:
                        mStoryTextView.setText(R.string.T3_Story);
                        mButtonTop.setText(R.string.T3_Ans1);
                        mButtonBottom.setText(R.string.T3_Ans2);
                        mStoryIndex = 3;
                        break;

                    case 3:
                        // Top button results in Ending 6
                        mStoryTextView.setText(R.string.T6_End);

                        mStoryIndex = 99;

                        // Display End Text
                        mButtonTop.setText(R.string.Replay_Game);
                        mButtonBottom.setText(R.string.Quit);
                        break;

                    case 99:
                        // Reset the game
                        mStoryTextView.setText(R.string.T1_Story);
                        mButtonTop.setText(R.string.T1_Ans1);
                        mButtonBottom.setText(R.string.T1_Ans2);
                        mStoryIndex = 1;
                        break;

                    default:
                        // Should never reach here
                        Log.d("Destini","Reached unreachable Top Button default case!");
                        break;
                }
            }
        });

        // Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini","Bottom Button Pressed");

                switch(mStoryIndex){
                    case 1:
                        mStoryTextView.setText(R.string.T2_Story);
                        mButtonTop.setText(R.string.T2_Ans1);
                        mButtonBottom.setText(R.string.T2_Ans2);
                        mStoryIndex = 2;
                        break;

                    case 2:
                        // Bottom button results in Ending 4
                        mStoryTextView.setText(R.string.T4_End);

                        mStoryIndex = 99;

                        // Display End Text
                        mButtonTop.setText(R.string.Replay_Game);
                        mButtonBottom.setText(R.string.Quit);
                        break;

                    case 3:
                        // Bottom button results in ending 5
                        mStoryTextView.setText(R.string.T5_End);

                        mStoryIndex = 99;

                        // Display End Text
                        mButtonTop.setText(R.string.Replay_Game);
                        mButtonBottom.setText(R.string.Quit);
                        break;

                    case 99:
                        // User quit
                        finish();

                    default:
                        // Should never reach here
                        Log.d("Destini","Reached unreachable Top Button default case!");
                        break;
                }

            }
        });

    }
}
