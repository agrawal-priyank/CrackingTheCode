package Hard;

public class VolumeOfHistogramOptimal {

    public static void main(String[] args){
        int[] hist = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        VolumeOfHistogramOptimal vMO = new VolumeOfHistogramOptimal();
        System.out.println(vMO.histogramVolume(hist));
    }

    public int histogramVolume(int[] hist){
        int start = 0;
        int end = hist.length - 1;
        Histogram[] histo = getHistogramData(hist);
        int max = histo[0].getRightMaxIndex();
        int leftVolume = subgraphVolume(histo, start, max, true);
        int rightVolume = subgraphVolume(histo, max, end, false);
        return leftVolume + rightVolume;
    }

    private int subgraphVolume(Histogram[] histo, int start, int end, boolean isLeft){
        if(start >= end){
            return 0;
        }
        int sum = 0;
        if(isLeft){
            int max = histo[end - 1].getLeftMaxIndex();
            sum += borderedVolume(histo, max, end);
            sum += subgraphVolume(histo, start, max, isLeft);
        } else{
            int max = histo[start + 1].getRightMaxIndex();
            sum += borderedVolume(histo, start, max);
            sum += subgraphVolume(histo, max, end, isLeft);
        }
        return sum;
    }

    private int borderedVolume(Histogram[] histo, int start, int end){
        if(start >= end){
            return 0;
        }
        int min = Math.min(histo[start].getHeight(), histo[end].getHeight());
        int sum = 0;
        for(int i = start + 1; i < end; i++){
            sum += min - histo[i].getHeight();
        }
        return sum;
    }

    private Histogram[] getHistogramData(int[] hist){
        Histogram[] histo = new Histogram[hist.length];
        for(int i = 0; i < hist.length; i++){
            histo[i] = new Histogram(hist[i]);
        }

        int leftMaxIndex = 0;
        for(int i = 0; i < hist.length; i++){
            if(hist[leftMaxIndex] < hist[i]){
                leftMaxIndex = i;
            }
            histo[i].setLeftMaxIndex(leftMaxIndex);
        }

        int rightMaxIndex = hist.length - 1;
        for(int i = hist.length - 1; i >= 0; i--){
            if(hist[rightMaxIndex] < hist[i]){
                rightMaxIndex = i;
            }
            histo[i].setRightMaxIndex(rightMaxIndex);
        }
        return histo;
    }

}