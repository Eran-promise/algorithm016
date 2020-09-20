package week02;
/**
 * author: Eran-promise
 * question: 猜数字游戏
 * url: https://leetcode-cn.com/problems/bulls-and-cows/
 * action:
 * time complexity：O(n) n:字符串长度
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null) return "0A0B";
        int aNum = 0, bNum = 0;
        int[] box = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) aNum++;
            else{
                if(box[secret.charAt(i) - '0']++ < 0) bNum++;
                if(box[guess.charAt(i) - '0']-- > 0) bNum++;
            }
        }
        return aNum + "A" + bNum + "B";
    }
}
