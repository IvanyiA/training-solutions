package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String personName;
    private List<Skill> skills;

    public Cv(String personName, List<Skill> skills) {
        this.personName = personName;
        this.skills = skills;
    }

    public Cv(String personName) {
        this.personName = personName;
        skills = new ArrayList<>();
    }

    public void addSkills(String... skillsNameAndLevels) {

        for (int i = 0; i < skillsNameAndLevels.length; i++) {
            skills.add(new Skill(skillsNameAndLevels[i]));
        }

//        for (String skillsNameAndLevel : skillsNameAndLevels) {
//            skills.add(new Skill(skillsNameAndLevel));
//        }


    }

    public String getPersonName() {
        return personName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int findSkillLevelByName(String skillName) {

        for (Skill skill : skills) {
            if (skill.getSkillName().equals(skillName)) {
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException();
    }


}
