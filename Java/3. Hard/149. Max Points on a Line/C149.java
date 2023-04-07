import java.util.HashMap;
import java.util.Map;

class C149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        var maxPointsOnLine = 0;
        for (var i = points.length - 1; i >= 0; --i) {
            var maxCollinearPointsBySlope = calculateMaxCollinearPointsBySlope(i, points);
            if (maxPointsOnLine < maxCollinearPointsBySlope) {
                maxPointsOnLine = maxCollinearPointsBySlope;
            }
        }

        return maxPointsOnLine + 1;
    }

    int calculateMaxCollinearPointsBySlope(int startPoint, int[][] points) {
        Map<Double, Integer> pointsSlopes = new HashMap<>(points.length, 1.1F);
        var fixedPoint = points[startPoint];
        var maxCountSlope = 0;
        for (int i = startPoint - 1; i >= 0; --i) {
            var point = points[i];
            var slope = calcSlope(fixedPoint, point);
            var countSlope = pointsSlopes.merge(slope, 1, Integer::sum);
            maxCountSlope = Integer.max(maxCountSlope, countSlope);
        }

        return maxCountSlope;
    }

    private Double calcSlope(int[] point1, int[] point2) {
        // (x - x1) / (x2 - x1) = (y - y1) / (y2 - y1)
        var px1 = point1[0];
        var py1 = point1[1];
        var px2 = point2[0];
        var py2 = point2[1];
        // infite slope
        if (px1 == px2)
            return 20003.0;
        // slope is zero
        if (py1 == py2)
            return 0.0;
        return (double) (py2 - py1) / (px2 - px1);
    }

}