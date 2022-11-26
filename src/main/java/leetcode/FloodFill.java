package leetcode;

@LeetcodeNumber(number = 733, level = Level.EASY)
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int newColor = color;
        int startColor = image[sr][sc];
        if (newColor == startColor) return image;
        return image;
    }

//    void setColor(int[][] image, int r, int c int startColor, int newColor) {
//        if (image)
//    }
}
