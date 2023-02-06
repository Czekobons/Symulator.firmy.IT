import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ProjectGenerator[] project = new ProjectGenerator[100];
    ArrayList<ProjectGenerator> projectInProgress = new ArrayList<ProjectGenerator>();
    ProjectGenerator[] projectsInProgress = new ProjectGenerator[100];
    int newClient =0;
    public void showMenuList() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Podpisz umowe na realizacje projektu.");
        System.out.println("2. Szukaj nowych klientow.");
        System.out.println("3. Programuj.");
        System.out.println("4. Testuj kod.");
        System.out.println("5. Oddaj gotowy projekt klientowi.");
        System.out.println("6. Zatrudnij nowego pracownika.");
        System.out.println("7. Zwolnij pracownika.");
        System.out.println("8. Rozlicz się z urzędami.");
        System.out.println("9. Zarzadzaj firma.");
        System.out.println("10. Porzuc swoja firme i zatrudnij sie na etat.");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");

        Short chosedAction = scan.nextShort();
        choseAction1(chosedAction);
    }
    public void choseAction1(Short action)  {
        switch (action) {
            case 1:
                singInProjectMenu();
                break;
            case 2:
                newClient++;
                if(newClient >=5) {
                    for(int i=0;i<project.length;i++) {
                        if(project[i] == null) {
                            project[i] = new ProjectGenerator();
                            newClient = 0;
                            break;
                        }
                    }
                    System.out.println("Gratualcje udało Ci się pozyskać nowego klienta.");
                }
                else {
                    if(newClient<4) {
                        System.out.println("Potrzebujesz jeszcze "+(5-newClient)+"dni aby pozyskać nowego klienta.");
                    }
                    else {
                        System.out.println("Jeszcze tylko jeden dzień poszukiwań i uda Ci się pozyskać nowego klienta.");
                    }

                }
                break;
            case 3:
                System.out.println();
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            case 8:
                System.out.println("Sunday");
                break;
            case 9:
                System.out.println("\u001B[2J");
                showMenuCompanyManagement();
                break;
            case 10:
                System.exit(0);
                break;
            case 12:
                showFullProjectInfo(project[0]);
                break;
        }
    }
    public void singInProjectMenu() {
        Scanner scan = new Scanner(System.in);
        boolean avaibleProjects =false;
        int[] projectTemp = new int[100];
        int temp = 1;
        for(int i=0;i< project.length;i++) {
            if(project[i]!=null) {
                System.out.print(temp+". ");
                showFullProjectInfo(project[i]);
                System.out.println();
                projectTemp[temp] = i;
                temp++;
                avaibleProjects = true;
            }
        }
        if(avaibleProjects) {
            System.out.print("Wybierz jeden z dostepnych projektów: ");
            Short chosedAction = scan.nextShort();
            ProjectGenerator tempProj = new ProjectGenerator();
            for(int j=0;j<projectsInProgress.length;j++) {
                if(projectsInProgress[j]==null) {
                    tempProj = project[projectTemp[chosedAction]];
                    projectsInProgress[j]= tempProj;
                    tempProj = null;
                    break;
                }
            }
            project[projectTemp[chosedAction]] = null;
            System.out.println("Gratulacje, ten projekt bedzie teraz wykonaywany przez twoją firme.");
        }
        else {
            System.out.println("Nie masz żadnych dosępnych projektów. Poświęć dzień na szukanie aby się tu pojawiły.");
            pressEnterToCont();
        }
    }
    public void showMenuCompanyManagement() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Sprawdz stan realizacji projektow.");
        System.out.println("2. Przejrzyj dostepne projekty.");
        System.out.println("3. Sprawdz dostepnych pracownikow.");
        System.out.println("4. Sprawdz stan konta firmy.");
        System.out.println("5. Wroc do glownego menu.");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");
        Short chosedAction = scan.nextShort();
        choseAction2(chosedAction);
    }
    public void choseAction2(Short action)  {
        switch (action) {
            case 1:
                checkStateYourProjects();
                break;
            case 2:
                checkAvalibleProject();
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                showMenuList();
                break;
        }
    }

    public void checkStateYourProjects() {
        boolean projectsAvaiable =false;
        for(int i=0;i<projectsInProgress.length;i++) {
            if(projectsInProgress[i]!= null) {
                showFullProjectInfo(projectsInProgress[i]);
                System.out.println("Project "+i);
                projectsAvaiable= true;
            }
        }
        if(!projectsAvaiable){
            System.out.println("Nie masz obecnie żadnych projektów w trakcie realizacji.");
        }
        pressEnterToCont();
    }

    public void checkAvalibleProject() {
        for(int i=0;i< project.length;i++) {
            if(project[i]!=null) {
                showFullProjectInfo(project[i]);
                System.out.println();
            }
        }
        pressEnterToCont();
    }
    public void showFullProjectInfo(ProjectGenerator project) {
        System.out.println(project.getProjectTitle());
        project.showOursNeeded();
        System.out.println("Czas ukończnia: "+project.getDayToDeadLine()+" dni.");
        System.out.println("Kara za przekroczenie terminu: "+project.getPenalty()+"$.");
        System.out.println("Wartosc projektu: "+project.getProjectValue()+"$.");
        if(project.getProjectLevel()==1) {
            System.out.println("Poziom projektu: latwy.");
        }
        else if(project.getProjectLevel()==2) {
            System.out.println("Poziom projektu: sredni.");
        }
        else {
            System.out.println("Poziom projektu: zlozony.");
        }

    }
    public void showProjectInfo(ProjectGenerator project) {
        System.out.println(project.getProjectTitle());
        System.out.println("Wartosc projektu: " + project.getProjectValue() + "$.");
        if (project.getProjectLevel() == 1) {
            System.out.println("Poziom projektu: latwy.");
        } else if (project.getProjectLevel() == 2) {
            System.out.println("Poziom projektu: sredni.");
        } else {
            System.out.println("Poziom projektu: zlozony.");
        }
    }

    public void pressEnterToCont() {
        System.out.print("Nacisnij enter aby wyjsc...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        showMenuCompanyManagement();
    }

}
