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

    final Stories[] mStory = new Stories[]{
            new Stories(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Stories(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Stories(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Stories(R.string.T4_End, R.string.Replay_Game, R.string.Quit),
            new Stories(R.string.T5_End, R.string.Replay_Game, R.string.Quit),
            new Stories(R.string.T6_End, R.string.Replay_Game, R.string.Quit)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Restore bundle if present
        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            Log.d("Destini","Restoring Bundle. Setting mStoryIndex to " + mStoryIndex);
        }
        else {
            mStoryIndex = 1;
        }

        // Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        // Initialise text
        setDisplay(mStoryIndex);

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
                        setDisplay(3);
                        break;

                    case 3:
                        // Top button results in Ending 6
                        setDisplay(6);
                        break;

                    case 4:
                    case 5:
                    case 6:
                        // Reset the game
                        setDisplay(1);
                        break;

                    default:
                        // Should never reach here
                        Log.d("Destini","Reached unreachable Top Button default case! mStoryIndex == " + mStoryIndex);
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
                        setDisplay(2);
                        break;

                    case 2:
                        setDisplay(4);
                        break;

                    case 3:
                        // Bottom button results in ending 5
                        setDisplay(5);
                        break;

                    case 4:
                    case 5:
                    case 6:
                        // User quit
                        finish();

                    default:
                        // Should never reach here
                        Log.d("Destini","Reached unreachable Top Button default case! mStoryIndex == " + mStoryIndex);
                        break;
                }

            }
        });
    }

    private void setDisplay(int newStoryIndex) {

        Log.d("Destini", "Setting Story to Index - " + newStoryIndex );

        mStoryIndex = newStoryIndex ;

        mStoryTextView.setText(mStory[ mStoryIndex - 1].getStory());
        mButtonTop.setText(mStory[ mStoryIndex - 1 ].getTopAnswer());
        mButtonBottom.setText(mStory[ mStoryIndex -1 ].getBottomAnswer());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
    }
}
