package xyz.hcen.quizweb.entity;

public class QuestionEntity {
    private String question;
    private String answer;
    private String rightans;
    private String category;
    private int difficulty;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRightans() {
        return rightans;
    }

    public void setRightans(String rightans) {
        this.rightans = rightans;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
