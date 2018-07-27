package com.londonappbrewery.destini;

public class Stories {

    private int story;
    private int topAnswer;
    private int bottomAnswer;

    public Stories(int story, int topAnswer, int bottomAnswer) {
        this.story = story;
        this.topAnswer = topAnswer;
        this.bottomAnswer = bottomAnswer;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getTopAnswer() {
        return topAnswer;
    }

    public void setTopAnswer(int topAnswer) {
        this.topAnswer = topAnswer;
    }

    public int getBottomAnswer() {
        return bottomAnswer;
    }

    public void setBottomAnswer(int bottomAnswer) {
        this.bottomAnswer = bottomAnswer;
    }
}
