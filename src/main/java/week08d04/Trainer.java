package week08d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {

        this.canMark = canMark;
    }

    int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer happyTrainer = new Trainer(new GoodMood());
        Trainer sadTrainer = new Trainer(new BadMood());

        happyTrainer.giveMark();
        sadTrainer.giveMark();

    }


}
