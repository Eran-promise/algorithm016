package week04;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> box = new HashSet<>();
        for(int[] arr: obstacles){
            box.add(arr[0] + "," + arr[1]);
        }
        int x = 0, y = 0, direc = 0, res = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -1) direc = (direc + 1) % 4;
            else if(commands[i] == -2) direc = (direc + 3) % 4;
            else{
                int temp = 0;
                while(temp++ < commands[i] && !box.contains((x + direction[direc][0]) + "," + (y + direction[direc][1]))){
                    x = x + direction[direc][0];
                    y = y + direction[direc][1];
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }
}
