package week12d02;

public class FenceStat {

    private int perfect = 0;
    private int needUpGrade = 0;
    private int noFence = 0;

    public int getPerfect() {
        return perfect;
    }

    public int getNeedUpGrade() {
        return needUpGrade;
    }

    public int getNoFence() {
        return noFence;
    }

    public void setPerfect() {
        this.perfect += 1;
    }

    public void setNeedUpGrade() {
        this.needUpGrade += 1;
    }

    public void setNoFence() {
        this.noFence += 1;
    }
}
