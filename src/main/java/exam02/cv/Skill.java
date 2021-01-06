package exam02.cv;

public class Skill {

    private final String skillName;
    private int level;

    public Skill(String name, int level) {
        this.skillName = name;
        this.level = level;
    }

    public Skill(String skillsNameAndLevel) {
        skillName = skillsNameAndLevel.substring
                (0, skillsNameAndLevel.indexOf("(")).trim();
        level = Integer.parseInt(skillsNameAndLevel.substring
                (skillsNameAndLevel.indexOf("(") + 1, skillsNameAndLevel.indexOf(")")));
    }

    public String getSkillName() {
        return skillName;
    }

    public int getLevel() {
        return level;
    }

}
