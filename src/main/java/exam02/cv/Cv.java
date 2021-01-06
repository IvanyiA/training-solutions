package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private final String name;
    private final List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    public Skill addSkills(){String...skills}

    public int findSkillLevelByName(String skillName) {
        if (skills.isEmpty()) {
            throw SkillNotFoundException();
        }
        for (Skill skill : skills) {
            if (skillName.equals(skill.getName())) {
                return skill.getLevel();
            }
        }
        return -1;
    }


}
