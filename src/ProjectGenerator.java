import java.util.Random;

public class ProjectGenerator {
    String[] branches = {"Front-end", "Back-end", "Wordpress", "Baza danych", "PretaShop", "Mobile"};
    String[] temp = {"Front-end", "Back-end", "Wordpress", "Baza danych", "PretaShop", "Mobile"};
    DataBase dataBase = new DataBase();
    public String[] choosedBranch = new String[branches.length];
    String projectName;
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
        generateProjectTitle();
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
    public void generateProjectTitle() {
        for(int i=0; i< branches.length;i++) {
            for(int j=0; j< choosedBranch.length;j++) {
                if(choosedBranch[j]!=null&&choosedBranch[j].equals(branches[i])) {
                    if(i==1||i==2||i==3) {
                        System.out.println(dataBase.backendName[0]);
                    }
                }
            }
        }
    }
    public String[] getChoosedBranch() {
        return choosedBranch;
    }
    public String getChoosedBranch(int a) {
        return choosedBranch[a];
    }

}
