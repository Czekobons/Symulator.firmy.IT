import java.util.Random;

public class ProjectGenerator {
    String projectName;
    String[] branches = {"Front-end", "Back-end", "Wordpress", "Baza danych", "PretaShop", "Mobile"};
    public String[] choosedBranch = new String[branches.length];
    Integer hoursFrontEnd;
    Integer hoursBackEnd;
    Integer hoursDataBase;
    Integer hoursMobile;
    Integer hoursWordpress;
    Integer hoursPretaShop;
    String client;
    Integer dayDeadline, monthDeadline, yearDeadline;
    Integer penalty;
    Integer projectPrice;
    Integer dayPayday, monthPayday, yearPayday;

    Integer projectLevel;

    public ProjectGenerator() {
        projectLevel = getRandomNumber(1, 4);
        neededTechnologies();
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Integer getProjectLevel() {
        return projectLevel;
    }
    private  void chooseBranch(int min, int max) {
        int random =getRandomNumber(min ,max);
        for(int i=0;i<random;i++) {
            String temp[] = branches;
            int x =getRandomNumber(0, branches.length);
            if(temp[x]!=null) {
                choosedBranch[i] = temp[x];
                temp[x] = null;
            }
            else {
                i--;
            }
        }
    }
    private void neededTechnologies() {
        choosedBranch[0] = branches[getRandomNumber(0, branches.length)];
        switch (projectLevel) {
            case 2:
                chooseBranch(2,4);
                break;
            case 3:
                chooseBranch(3,7);
                break;
        }
    }
    public String[] getChoosedBranch() {
        return choosedBranch;
    }

}
