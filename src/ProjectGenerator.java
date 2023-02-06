public class ProjectGenerator {
    String[] branches = {"Front-end", "Back-end", "Wordpress", "Baza danych", "PretaShop", "Mobile"};
    String[] temp = {"Front-end", "Back-end", "Wordpress", "Baza danych", "PretaShop", "Mobile"};
    DataBase dataBase = new DataBase();
    TimeManagment time =  new TimeManagment();
    public String[] choosedBranch = new String[branches.length];
    int branchesTtile[] = new int[branches.length];
    final Integer level1Hours = 10;
    final Integer level2Hours = 100;
    final Integer level3Hours = 1000;
    String projectName;
    Integer allHoursNeed;
    int[] hoursNeededTab = new int[branches.length];
    int[] hoursDoneTab = new int[branches.length];
    String client;
    Integer dayToDeadLine;
    Integer deadLineDay, deadLineMonth, deadLineYear;
    Double penalty;
    Double projectValue;
    Integer dayPayday, monthPayday, yearPayday;

    Integer projectLevel;

    public ProjectGenerator() {
        projectLevel = getRandomNumber(1, 4);
        generateTechnologies();
        generateProjectTitle();
        generateHoursNeeded();
        generateDeadLine();
        generateProjectValue();
        generatePenalty();
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
    private void generateTechnologies() {
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
    private void generateProjectTitle() {
        for(int i=0; i< branches.length;i++) {
            for(int j=0; j< choosedBranch.length;j++) {
                if(choosedBranch[j]!=null&&choosedBranch[j].equals(branches[i])) {
                    switch(i) {
                        case 0:
                            branchesTtile[0] = 1;
                            break;
                        case 1:
                            branchesTtile[1] = 1;
                            break;
                        case 2:
                            branchesTtile[2] = 1;
                            break;
                        case 3:
                            branchesTtile[3] = 1;
                            break;
                        case 4:
                            branchesTtile[4] = 1;
                            break;
                        case 5:
                            branchesTtile[5] = 1;
                            break;
                    }
                }
            }
        }
        System.out.println();
        if(branchesTtile[0]==1||branchesTtile[1]==1||branchesTtile[2]==1||branchesTtile[3]==1) {
            projectName = dataBase.titleFrontBackDataBase[0];
            if(branchesTtile[5]==1) {
                projectName.concat(" i "+dataBase.titleMobile[0]);
            }
        }
        else if(branchesTtile[5]==1 && projectLevel==1) {
            projectName = dataBase.titleMobile[0];
        }
        else if(branchesTtile[2]==1 && projectLevel==1) {
            projectName = dataBase.titleWordpress[0];
        }
        else if(branchesTtile[4]==1) {
            projectName = dataBase.titlePretaShop[0];
            if(branchesTtile[5]==1) {
                projectName.concat(" i "+dataBase.titleMobile[0]);
            }
        }
    }
    private void generateHoursNeeded() {
        int temp = 0;
        if(projectLevel==1) {
            temp = level1Hours;
        }
        else if(projectLevel==2) {
            temp = level2Hours;
        }
        else if(projectLevel==3) {
            temp = level3Hours;
        }
        for(int i=0;i<branchesTtile.length;i++){
            if(branchesTtile[i]==1) {
                switch (i) {
                    case 0:
                        hoursNeededTab[0] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                    case 1:
                        hoursNeededTab[1] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                    case 2:
                        hoursNeededTab[2] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                    case 3:
                        hoursNeededTab[3] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                    case 4:
                        hoursNeededTab[4] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                    case 5:
                        hoursNeededTab[5] = getRandomNumber(5*getChoosedBranch().length, temp/getChoosedBranch().length);
                        break;
                }
            }
        }
        System.out.println();
        allHoursNeed = 0;
        for(int i=0;i<hoursNeededTab.length;i++) {
            if(hoursNeededTab[i]!=0) {
                allHoursNeed += hoursNeededTab[i];
                //System.out.println(branches[i]+": "+hoursNeededTab[i]);
            }
        }
    }
    private void generateDeadLine() {
        if(projectLevel==1) {
            if(allHoursNeed<6) {
                dayToDeadLine =1;
            }
            else {
                dayToDeadLine = allHoursNeed/getRandomNumber(4, 6);
            }
        }
        else if(projectLevel==2) {
            dayToDeadLine = allHoursNeed/getRandomNumber(7, 12);
        }
        else {
            dayToDeadLine = allHoursNeed/getRandomNumber(13, 20);
        }
    }
    private void generateProjectValue() {
        projectValue = Double.valueOf((projectLevel*allHoursNeed*getChoosedBranch().length)/dayToDeadLine*100);
    }
    private void generatePenalty() {
        penalty = projectValue/10;
    }
    public void getDeadLineDate() {

    }
    int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public Double getPenalty() {
        return penalty;
    }
    public Double getProjectValue() {
        return projectValue;
    }
    public Integer getDayToDeadLine() {
        return dayToDeadLine;
    }
    public String getProjectTitle() {
        return projectName;
    }
    public Integer getProjectLevel() {
        return projectLevel;
    }
    public String[] getChoosedBranch() {
        return choosedBranch;
    }
    public String getChoosedBranch(int a) {
        return choosedBranch[a];
    }
    public void showOursNeeded() {
        for(int i=0;i<branches.length;i++) {
            if(hoursNeededTab[i]!=0) {
                System.out.println(branches[i] + ": " + hoursNeededTab[i]);
            }
        }
    }


}
