package Hard;

public class VolumeOfHistogramBest {

    public static void main(String[] args){
        int[] hist = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        VolumeOfHistogramBest vMB = new VolumeOfHistogramBest();
        System.out.println(vMB.histogramVolume(hist));
    }

    public int histogramVolume(int[] hist){
        int[] leftMaxes = new int[hist.length];
        int leftMax = hist[0];
        for(int i = 0; i < hist.length; i++){
            leftMax = Math.max(leftMax, hist[i]);
            leftMaxes[i] = leftMax;
        }
        int rightMax = hist[hist.length - 1];
        int sum = 0;
        for(int i = hist.length - 1; i >= 0; i--){
            rightMax = Math.max(rightMax, hist[i]);
            int secondTallest = Math.min(rightMax, leftMaxes[i]);
            if(secondTallest > hist[i]){
                sum += secondTallest - hist[i];
            }
        }
        return sum;
    }

}