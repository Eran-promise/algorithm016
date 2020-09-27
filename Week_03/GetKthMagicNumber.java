package week03;

public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        if(k < 1) return 0;
        int po3 = 0, po5 = 0, po7 = 0;
        int[] box = new int[k];
        box[0] = 1;
        for(int i = 1; i < k; i++){
            box[i] = Math.min(box[po3] * 3, Math.min(box[po5] * 5, box[po7] * 7));
            if(box[i] == box[po3] * 3) po3++;
            if(box[i] == box[po5] * 5) po5++;
            if(box[i] == box[po7] * 7) po7++;
        }
        return box[k - 1];
    }
}
