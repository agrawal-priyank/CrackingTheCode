package Hard;

public class VolumeOfHistogram {

    public static void main(String[] args){
        int[] hist = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        VolumeOfHistogram vM = new VolumeOfHistogram();
        System.out.println(vM.histogramVolume(hist));
    }

    public int histogramVolume(int[] hist){
        int start = 0, end = hist.length - 1;
        int max = indexOfMax(hist, start, end);
        int leftVolume = subgraphVolume(hist, start, max, true);
        int rightVolume = subgraphVolume(hist, max, end, false);
        return leftVolume + rightVolume;
    }

    private int subgraphVolume(int[] hist, int start, int end, boolean isLeft){
        if(start >= end){
            return 0;
        }
        int volume = 0;
        if(isLeft){
            int max = indexOfMax(hist, start, end - 1);
            volume += borderedVolume(hist, max, end);
            volume += subgraphVolume(hist, start, max, isLeft);
        } else{
            int max = indexOfMax(hist, start + 1, end);
            volume += borderedVolume(hist, start, max);
            volume += subgraphVolume(hist, max, end, isLeft);
        }
        return volume;
    }

    private int borderedVolume(int[] hist, int start, int end){
        if(start >= end){
            return 0;
        }
        int min = Math.min(hist[start], hist[end]);
        int sum = 0;
        for(int i = start + 1; i < end; i++){
            sum += min - hist[i];
        }
        return sum;
    }

    private int indexOfMax(int[] hist, int start, int end){
        int maxIndex = start;
        for(int i = start + 1; i <= end; i++){
            if(hist[maxIndex] < hist[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}