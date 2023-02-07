public class Client {
    String name;
    String[] nameTab = {"Biedronka", "Intel"};

    public Integer paymentDelayWeekChance;
    public Integer paymentDelayMonthChance;
    public Integer noPenaltyChance;
    public Integer returningUnworkingProjectChance;
    public Integer noPaymentChance;
    public Boolean paymentDelayWeek = false;
    public Boolean paymentDelayMonth = false;
    public Boolean noPenalty = false;
    public Boolean returningUnworkingProject = false;
    public Boolean noPayment = false;

    //1= wyluzowany, 2=wymagajacy, 3=skurwiel
    public Client(int type, int nameGen) {
        if (type == 1) {
            paymentDelayWeekChance = 30;
            paymentDelayMonthChance = 0;
            noPenaltyChance = 20;
            returningUnworkingProjectChance = 0;
            noPaymentChance = 0;
        } else if (type == 2) {
            paymentDelayWeekChance = 0;
            paymentDelayMonthChance = 0;
            noPenaltyChance = 0;
            returningUnworkingProjectChance = 50;
            noPaymentChance = 0;
        } else if (type == 3) {
            paymentDelayWeekChance = 30;
            paymentDelayMonthChance = 5;
            noPenaltyChance = 0;
            returningUnworkingProjectChance = 100;
            noPaymentChance = 1;
        } else {
            try {
                throw new Exception("Wrong type");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.name = nameTab[nameGen];
    }

    public void chance() {
        int chance = getRandomNumber(1, 100);
        if (chance <= paymentDelayWeekChance) {
            paymentDelayWeek = true;
        }
        int chance2 = getRandomNumber(1, 100);
        if (chance2 <= paymentDelayMonthChance) {
            paymentDelayMonth = true;
        }
        int chance3 = getRandomNumber(1, 100);
        if (chance3 <= noPenaltyChance) {
            noPenalty = true;
        }
        int chance4 = getRandomNumber(1, 100);
        if (chance4 >= returningUnworkingProjectChance) {
            returningUnworkingProject = true;
        }
        int chance5 = getRandomNumber(1, 100);
        if (chance5 <= noPaymentChance) {
            noPayment = true;
        }
    }

    int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
