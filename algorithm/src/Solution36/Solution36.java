package Solution36;

public class Solution36 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        //左上角坐标{x1,y2(0,3)}
        //右下角坐标{x2,y1(2,1)}
        return !(rec1[1] >= rec2[3] ||
                 rec1[3] <= rec2[1] ||
                 rec1[2] <= rec2[0] ||
                 rec1[0] >= rec2[2]);


    }


}
