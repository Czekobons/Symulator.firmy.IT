import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    ProjectGenerator[] project = new ProjectGenerator[100];
    ArrayList<ProjectGenerator> projectInProgress = new ArrayList<ProjectGenerator>();
    ProjectGenerator[] projectsInProgress = new ProjectGenerator[100];
    ProjectGenerator[] projectsFinished = new ProjectGenerator[100];
    int newClient = 0;
    public Double companyCash = 2000.0;
    public List<Double> delayedPaymentValue = new ArrayList<>();
    public List<Integer> delayedPaymentTime = new ArrayList<>();
    public int dealWithBurdens = 0;

    public void showMenuList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------");
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
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");
        Short chosedAction = scan.nextShort();
        choseAction1(chosedAction);

    }

    public void choseAction1(Short action) {
        switch (action) {
            case 1:
                singInProjectMenu();
                break;
            case 2:
                newClient++;
                if (newClient >= 5) {
                    for (int i = 0; i < project.length; i++) {
                        if (project[i] == null) {
                            project[i] = new ProjectGenerator();
                            newClient = 0;
                            break;
                        }
                    }
                    System.out.println("Gratualcje udało Ci się pozyskać nowego klienta.");
                } else {
                    if (newClient < 4) {
                        System.out.println("Potrzebujesz jeszcze " + (5 - newClient) + "dni aby pozyskać nowego klienta.");
                    } else {
                        System.out.println("Jeszcze tylko jeden dzień poszukiwań i uda Ci się pozyskać nowego klienta.");
                    }

                }
                break;
            case 3:
                workOnProject();
                break;
            case 4:
                testCode();
                break;
            case 5:
                returnFinishedProject();
                break;
            case 6:
                System.out.println("Zatrudnij pracownika, Work in Progress");
                break;
            case 7:
                System.out.println("Zwolnij pracownika, Work in Progress");
                break;
            case 8:
                dealWithBurdens++;
                if(dealWithBurdens==1) {
                    System.out.println("Wszytskie dziejsze formalnosci zotaly dopelnione, bedziesz musial odbyc jeszcze jedna wizyte w urzadzie.");
                }else if(dealWithBurdens==2) {
                    System.out.println("Wszytskie formalnosci zotaly dopelnione, w tym miesiącu jestes bezpieczny");
                }
                else {
                    System.out.println("Wszystkie formalnosci zostaly juz dopelnione w tym miesiace, mozesz skupic sie na pracy");
                    pressEnterToCont();
                }
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
                System.out.println("-----------------------------------------------------------------------------");
                break;
        }
    }

    public void returnFinishedProject() {
        if(projectsFinished[0] == null) {
            System.out.println("Nie masz projektow gotowych do oddania.");
            pressEnterToCont();
            return;
        }
        Scanner scan = new Scanner(System.in);
        boolean avaibleProjects = false;
        int[] projectTemp = new int[100];
        int temp = 1;
        for (int i = 0; i < projectsFinished.length; i++) {
            if (projectsFinished[i] != null) {
                System.out.print(temp + ". ");
                showFullProjectInfo(projectsFinished[i]);
                System.out.println();
                projectTemp[temp] = i;
                temp++;
            }
        }
        System.out.print("Wybierz jeden z dostepnych projektów ktory chcesz oddac: ");
        Short chosedAction = scan.nextShort();
        projectsFinished[projectTemp[chosedAction]].client.chance();
        if(projectsFinished[projectTemp[chosedAction]].client.noPayment) {
            System.out.println("Niestety ale twoj klient uciekl z projektem bez zaplaty.");
            projectsFinished[projectTemp[chosedAction]] = null;
            return;
        }
        if(projectsFinished[projectTemp[chosedAction]].client.returningUnworkingProject && !projectsFinished[projectTemp[chosedAction]].wasTested) {
            System.out.println("Niestety oddalas klientowi nie sprawny kod i nie zaplaci Tobie za ten projekt.");
            projectsFinished[projectTemp[chosedAction]] = null;
            return;
        }
        if(projectsFinished[projectTemp[chosedAction]].dayToDeadLine < -7) {
            System.out.println("Niestety ale twoj projekt jest zbyt opozniony, nie otrzymasz zadnej zaplaty, ciesz sie, ze nie otrzymujesz jeszcze kary.");
            projectsFinished[projectTemp[chosedAction]] = null;
            return;
        }
        if(projectsFinished[projectTemp[chosedAction]].dayToDeadLine < 0 && projectsFinished[projectTemp[chosedAction]].dayToDeadLine >= -7) {
            if(projectsFinished[projectTemp[chosedAction]].client.noPenalty) {
                System.out.println("Co prawda oddales projekt po czasie ale twoj klient byl wyrozumialy i nie obiciazy cie kara.");
            }
            else {
                System.out.println("Niestety oddalas projekt po czasie wiec muszisz zaplacic kare.");
                companyCash -= projectsFinished[projectTemp[chosedAction]].getPenalty();
                System.out.println("Oplacono kare w wyoskosci:" +projectsFinished[projectTemp[chosedAction]].getPenalty());
            }
        }
        else if(projectsFinished[projectTemp[chosedAction]].dayToDeadLine >= 0) {}
        else {
            System.out.println("Niestety oddalas projekt po czasie wiec muszisz zaplacic kare.");
            companyCash -= projectsFinished[projectTemp[chosedAction]].getPenalty();
            System.out.println("Oplacono kare w wyoskosci:" +projectsFinished[projectTemp[chosedAction]].getPenalty());
        }
        if(projectsFinished[projectTemp[chosedAction]].client.paymentDelayWeek || projectsFinished[projectTemp[chosedAction]].client.paymentDelayMonth) {
            if(projectsFinished[projectTemp[chosedAction]].client.paymentDelayMonth) {
                System.out.println("Twoj klient spoznia sie z platnoscia ale obiecuje, ze otrzymasz pieniadze.");
                delayedPaymentTime.add(30);
                delayedPaymentValue.add(projectsFinished[projectTemp[chosedAction]].projectValue);
            }
            else {
                System.out.println("Twoj klient spoznia sie z platnoscia ale obiecuje, ze otrzymasz pieniadze.");
                delayedPaymentTime.add(7);
                delayedPaymentValue.add(projectsFinished[projectTemp[chosedAction]].projectValue);
            }
        }
        else {
            companyCash += projectsFinished[projectTemp[chosedAction]].projectValue;
            System.out.println("Twoj klient uregulowal platnosc za projekt. Nasza firma zyskala: "+projectsFinished[projectTemp[chosedAction]].projectValue);
        }
        projectsFinished[projectTemp[chosedAction]] = null;
    }
    public void testCode() {
        if(projectsFinished[0] == null) {
            System.out.println("Nie masz ukonczonych projektow ktorych kod moglbys testowac.");
            pressEnterToCont();
            return;
        }
        Scanner scan = new Scanner(System.in);
        int[] projectTemp = new int[100];
        int temp = 1;
        for (int i = 0; i < projectsFinished.length; i++) {
            if (projectsFinished[i] != null) {
                System.out.print(temp + ". ");
                showFullProjectInfo(projectsFinished[i]);
                System.out.println();
                projectTemp[temp] = i;
                temp++;
            }
        }
        System.out.print("Wybierz jeden z dostepnych projektów ktorych kod chcesz testowac.");
        Short chosedAction = scan.nextShort();
        projectsFinished[projectTemp[chosedAction]].wasTested = true;
        System.out.println("Masz teraz pewnosc, ze kod zostanie oddany bez bledow.");

    }
    public void workOnProject() {
        if(projectsInProgress[0] == null) {
            System.out.println("Nie masz projektow w trakcie realizacji.");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int[] projectTemp = new int[100];
        int temp = 1;
        for (int i = 0; i < projectsInProgress.length; i++) {
            if (projectsInProgress[i] != null) {
                System.out.print(temp + ". ");
                showFullProjectInfo(projectsInProgress[i]);
                System.out.println();
                projectTemp[temp] = i;
                temp++;
            }
        }
        System.out.print("Wybierz jeden z dostepnych projektów nad ktorym chcesz pracowac: ");
        Short chosedAction = scan.nextShort();
        int workHours = 8;
        for (int i = 0; i < projectsInProgress[projectTemp[chosedAction]].choosedBranch.length; i++) {
            if (projectsInProgress[projectTemp[chosedAction]] != null && workHours > 0) {
                if (true) {
                    if (workHours > projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] && projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] != 0) {
                        workHours -= projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i];
                        projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] = 0;
                    } else if (workHours <= projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] && projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] != 0) {
                        projectsInProgress[projectTemp[chosedAction]].hoursLeftTab[i] -= workHours;
                        workHours = 0;
                    } else {
                    }
                }
            }
        }

    }

    public void chceckIfFinished() {
        for (int i = 0; i < projectsInProgress.length; i++) {
            if (projectsInProgress[i] != null) {
                int count = projectsInProgress[i].hoursLeftTab.length;
                for (int j = 0; j < projectsInProgress[i].hoursLeftTab.length; j++) {
                    if (projectsInProgress[i].hoursLeftTab[j] <= 0) {
                        count -= 1;
                    }
                }
                if (count == 0) {
                    for (int k = 0; k < projectsFinished.length; k++) {
                        if (projectsFinished[k] == null) {
                            projectsFinished[k] = projectsInProgress[i];
                            projectsInProgress[i] = null;
                        }
                    }
                }
            }
        }

    }


    public void singInProjectMenu() {
        Scanner scan = new Scanner(System.in);
        boolean avaibleProjects = false;
        int[] projectTemp = new int[100];
        int temp = 1;
        for (int i = 0; i < project.length; i++) {
            if (project[i] != null) {
                System.out.print(temp + ". ");
                showFullProjectInfo(project[i]);
                System.out.println();
                projectTemp[temp] = i;
                temp++;
                avaibleProjects = true;
            }
        }
        if (avaibleProjects) {
            System.out.print("Wybierz jeden z dostepnych projektów: ");
            Short chosedAction = scan.nextShort();
            ProjectGenerator tempProj = new ProjectGenerator();
            for (int j = 0; j < projectsInProgress.length; j++) {
                if (projectsInProgress[j] == null) {
                    tempProj = project[projectTemp[chosedAction]];
                    projectsInProgress[j] = tempProj;
                    tempProj = null;
                    break;
                }
            }
            project[projectTemp[chosedAction]] = null;
            System.out.println("Gratulacje, ten projekt bedzie teraz wykonaywany przez twoją firme.");
            pressEnterToCont();
        } else {
            System.out.println("Nie masz żadnych dosępnych projektów. Poświęć dzień na szukanie aby się tu pojawiły.");
            pressEnterToCont();
        }
    }

    public void showMenuCompanyManagement() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1. Sprawdz stan realizacji projektow.");
        System.out.println("2. Przejrzyj dostepne projekty.");
        System.out.println("3. Sprawdz dostepnych pracownikow.");
        System.out.println("4. Sprawdz stan konta firmy.");
        System.out.println("5. Wroc do glownego menu.");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");
        Short chosedAction = scan.nextShort();
        choseAction2(chosedAction);
    }

    public void choseAction2(Short action) {
        switch (action) {
            case 1:
                checkStateYourProjects();
                pressEnterToCont();
                break;
            case 2:
                checkAvalibleProject();
                break;
            case 3:
                System.out.println("Work in Progress");
                break;
            case 4:
                System.out.println("Stan twojego konta to obecnie: "+companyCash);
                pressEnterToCont();
                break;
            case 5:
                showMenuList();
                break;
        }
    }

    public void checkStateYourProjects() {
        boolean projectsAvaiable = false;
        for (int i = 0; i < projectsInProgress.length; i++) {
            if (projectsInProgress[i] != null) {
                showFullProjectInfo(projectsInProgress[i]);
                System.out.println("Project " + i);
                projectsAvaiable = true;
            }
        }
        if (!projectsAvaiable) {
            System.out.println("Nie masz obecnie żadnych projektów w trakcie realizacji.");
            showMenuList();
        }
    }

    public void checkAvalibleProject() {
        for (int i = 0; i < project.length; i++) {
            if (project[i] != null) {
                showFullProjectInfo(project[i]);
                System.out.println();
            }
        }
    }

    public void showFullProjectInfo(ProjectGenerator project) {
        System.out.println(project.getProjectTitle());
        project.showOursLeft();
        System.out.println("Czas ukończnia: " + project.getDayToDeadLine() + " dni.");
        System.out.println("Kara za przekroczenie terminu: " + project.getPenalty() + "$.");
        System.out.println("Wartosc projektu: " + project.getProjectValue() + "$.");
        System.out.println("Klient: "+project.client.name);
        if (project.getProjectLevel() == 1) {
            System.out.println("Poziom projektu: latwy.");
        } else if (project.getProjectLevel() == 2) {
            System.out.println("Poziom projektu: sredni.");
        } else {
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

    public void timeForProjects() {
        for (int i = 0; i < projectsInProgress.length; i++) {
            if (projectsInProgress[i] != null) {
                projectsInProgress[i].dayToDeadLine--;
                if (projectsInProgress[i].dayToDeadLine == 1) {
                    //System.out.println("Zbliza sie termin oddania projektu, jesli go jutro nie oddasz moze sie to wiazac z kara.");
                    //pressEnterToCont();
                }
            }
        }
    }
    public void delayedPayments() {
        if(!delayedPaymentTime.isEmpty()) {
            for(int i=0;i<delayedPaymentTime.size()-1;i++) {
                int temp = delayedPaymentTime.get(i);
                temp--;
                delayedPaymentTime.remove(i);
                delayedPaymentTime.add(i,temp);
                if(temp <= 0) {
                    companyCash += delayedPaymentValue.get(i);
                    System.out.println("Otrzymales zalegla platnosc za projekt o wyoskosci:"+delayedPaymentValue.get(i));
                    delayedPaymentTime.remove(i);
                    delayedPaymentValue.remove(i);
                }
            }
        }
    }
    public void pressEnterToCont() {
        System.out.print("Nacisnij enter aby wyjsc...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        showMenuList();
    }

}
