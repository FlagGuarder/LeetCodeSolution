package greedy.Solution1465;

import java.util.Arrays;

public class Solution {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] horizontalSize = new int[horizontalCuts.length+1];
        int[] verticalSize = new int[verticalCuts.length+1];
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        initSubSize(h, horizontalCuts, horizontalSize);

        initSubSize(w, verticalCuts, verticalSize);
        int maxVertical = Arrays.stream(verticalSize).max().getAsInt();
        long maxArea = 0;
        int maxHorizontal = Arrays.stream(horizontalSize).max().getAsInt();
        for (int i = 0; i < horizontalSize.length; i++){
            maxArea = maxArea < maxVertical * horizontalSize[i] ? maxVertical*horizontalSize[i] : maxArea;
        }
        for (int i = 0; i < verticalSize.length; i++){
            maxArea = maxArea < maxHorizontal * verticalSize[i] ? maxHorizontal*verticalSize[i] : maxArea;
        }
        return (int)maxArea % 1000000007;

    }

    private static void initSubSize(int w, int[] verticalCuts, int[] verticalSize) {
        for (int j =0; j <= verticalCuts.length; j++){
            if (j == 0)
                verticalSize[j] = verticalCuts[j] - 0;
            else if (j < verticalCuts.length)
                verticalSize[j] = verticalCuts[j] - verticalCuts[j-1];
            else
                verticalSize[j] = w - verticalCuts[j-1];
        }
    }

    public static void main(String[] args) {
        int h = 5;
        int w =4;
        int[] horizontalCuts = {3,1};
        int[] verticalCuts = {1};
        int area = maxArea(h, w, horizontalCuts, verticalCuts);
        int i = 0;
    }
}
