package week04;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int num : bills){
            if(num == 5) five++;
            else if(num == 10){
                if(five > 0) {
                    five--;
                    ten++;
                }
                else return false;
            }
            else {
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }
                else if(five > 2) five-=3;
                else return false;
            }
        }
        return true;
    }
}
