class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 7, new int[]{1, 0,2,0,1,0,2}, new int[]{0,2,0,1,0,2,0});
    }
    private int cap; // 택배 상자 최대 개수
    private int n; // 집 개수
    private int[] deliveries; // 각 집 배달 상자 개수
    private int[] pickups; // 각 집 수거 상자 개수
    private int maxDeliveryPoint = -1; // 배달해야할 집의 최대 위치
    private int maxPickupPoint = -1; // 수거해야할 집의 최대 위치
    private int deliveringBoxCount; // 배달중인 상자 개수
    private int pickingUpBoxCount;  // 수거중인 상자 개수
    private int remainDeliverBoxCount;
    /**
     * 상태를 두개로 나눔
     * : 배달중
     * : 수거중
     * <p>
     * 택배 상자의 개수도 분리
     * : 배달중 상자
     * : 수거중 상자
     * <p>
     * 맨 마지막 집부터 배달과 수거를 할 택배가 없으면 도착지점에서 제외해줌
     * <p>
     * 배달중인 상자가 0개이고 수거중인 상자가 가득찰때까지 위치를 -- 하면서 박스를 수거
     */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.cap = cap;
        this.n = n;
        this.deliveries = deliveries;
        this.pickups = pickups;
        this.deliveringBoxCount = cap;

        for (int i = n - 1; i >= 0; i--) {
            if (maxDeliveryPoint == -1 && deliveries[i] > 0) {
                this.maxDeliveryPoint = i;
            }

            if (maxPickupPoint == -1 && pickups[i] > 0) {
                this.maxPickupPoint = i;
            }

            remainDeliverBoxCount += deliveries[i];
        }

        long answer = 0;
        while (maxPickupPoint >= 0 || maxDeliveryPoint >= 0) {
            // 최대 지점 까지 가야 하니 왕복 이동 거리 추가
            deliveringBoxCount = Math.min(cap, remainDeliverBoxCount);
            answer += (Math.max(maxDeliveryPoint, maxPickupPoint) + 1) * 2;

            startDelivery();
            startPickup();
        }

        return answer;
    }

    private void startDelivery() {

        if (deliveringBoxCount == 0) {
            maxDeliveryPoint = -1;
            return;
        }

        while (deliveringBoxCount > 0 && maxDeliveryPoint >= 0) {
            int requiredBoxCount = deliveries[maxDeliveryPoint];

            // 모든 택배를 배달 시켜 줄 수 있을 경우
            if (deliveringBoxCount >= requiredBoxCount) {
                maxDeliveryPoint--;
                deliveringBoxCount -= requiredBoxCount;
                remainDeliverBoxCount -= requiredBoxCount;
                continue;
            }

            // 모든 택배를 배달 할 수 없는 경우
            deliveries[maxDeliveryPoint] -= deliveringBoxCount;
            remainDeliverBoxCount -= deliveringBoxCount;
            deliveringBoxCount = 0;
        }
        
        for (int i = maxDeliveryPoint; i >= 0; i--) {
            if (deliveries[i] == 0) {
                maxDeliveryPoint--;
            } else {
                break;
            }
        }


    }

    private void startPickup() {
        while (pickingUpBoxCount < cap && maxPickupPoint >= 0) {
            int pickupBoxCount = pickups[maxPickupPoint];

            // 해당 집에 박스를 모두 수거할 수 있을 경우
            if (pickupBoxCount + pickingUpBoxCount <= cap) {
                maxPickupPoint--;
                pickingUpBoxCount += pickupBoxCount;
                continue;
            }

            // 박스를 모두 수거할 수 없을 경우 최대로 담아줌
            int canPickupBoxCount = cap - pickingUpBoxCount;
            pickups[maxPickupPoint] -= canPickupBoxCount;
            pickingUpBoxCount += canPickupBoxCount;
        }

        for (int i = maxPickupPoint; i >= 0; i--) {
            if (pickups[i] == 0) {
                maxPickupPoint--;
            } else {
                break;
            }
        }

        pickingUpBoxCount = 0;
    }
}