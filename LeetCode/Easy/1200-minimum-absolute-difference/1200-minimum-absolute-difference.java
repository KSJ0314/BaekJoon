class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++){
            int diff = Math.abs(arr[i]-arr[i+1]);
            if (minDiff > diff) {
                minDiff = diff;
                res = new ArrayList<>();
            }
            if (minDiff >= diff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                res.add(list);
            }
        }
        return res;
    }
}