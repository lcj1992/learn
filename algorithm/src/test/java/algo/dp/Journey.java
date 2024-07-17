package algo.dp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 上午11:30
 */
public class Journey {


    public static void main(String[] args) {

        // 两天时间，游玩一些地方，使得总评分最高，求出最高评分下的景点名称,以及最高的评分是多少？
        List<PointOfInterest> poiList = Lists.newArrayList();
        poiList.add(new PointOfInterest(1, 7, "威斯敏斯特教堂"));
        poiList.add(new PointOfInterest(1, 6, "环球剧场"));
        poiList.add(new PointOfInterest(2, 9, "英国国家美术馆"));
        poiList.add(new PointOfInterest(4, 9, "大英博物馆"));
        poiList.add(new PointOfInterest(1, 8, "圣保罗大教堂"));
        int totalCost = 4;

        List<PointOfInterest> result = journey(poiList, totalCost);
        System.out.println(result.stream().mapToInt(PointOfInterest::getScore).sum());
        System.out.println(result.stream().map(PointOfInterest::getName).collect(Collectors.toList()));
    }

    @AllArgsConstructor
    @Getter
    private static class PointOfInterest {
        private int costDays;

        private int score;

        private String name;
    }

    private static List<PointOfInterest> journey(List<PointOfInterest> poiList, int totalCost) {


        @Data
        @AllArgsConstructor
        @EqualsAndHashCode
        class TableIndex {
            private int x;
            private int y;

        }

        Map<TableIndex, List<PointOfInterest>> memo = Maps.newHashMap();

        for (int poiIdx = 0; poiIdx < poiList.size(); poiIdx++) {
            for (int currentCost = 1; currentCost < totalCost + 1; currentCost++) {
                if (poiIdx == 0) {
                    if (poiList.get(poiIdx).getCostDays() <= currentCost) {
                        TableIndex tableIndex = new TableIndex(poiIdx, currentCost);
                        if (Objects.nonNull(memo.get(tableIndex)) && !memo.get(tableIndex).isEmpty()) {
                            memo.get(tableIndex).add(poiList.get(poiIdx));
                        } else {
                            memo.put(tableIndex, Lists.newArrayList(poiList.get(poiIdx)));
                        }
                    }
                    continue;
                }

                if (poiList.get(poiIdx).getCostDays() > currentCost) {
                    // 时间不够
                    TableIndex tableIndex = new TableIndex(poiIdx, currentCost);
                    memo.put(tableIndex, memo.get(new TableIndex(poiIdx - 1, currentCost)));
                } else {
                    // 时间充足
                    List<PointOfInterest> elements = memo.get(new TableIndex(poiIdx - 1, currentCost - poiList.get(poiIdx).getCostDays()));
                    List<PointOfInterest> played = Objects.nonNull(elements) ? Lists.newArrayList(elements) : Lists.newArrayList();
                    played.add(poiList.get(poiIdx));

                    List<PointOfInterest> notPlayed = memo.get(new TableIndex(poiIdx - 1, currentCost));

                    int playedScore = played.stream().mapToInt(PointOfInterest::getScore).sum();
                    int notPlayedScore = notPlayed.stream().mapToInt(PointOfInterest::getScore).sum();
                    TableIndex tableIndex = new TableIndex(poiIdx, currentCost);
                    // 玩该景点
                    if (playedScore <= notPlayedScore) {
                        memo.put(tableIndex, notPlayed);
                    }
                    // 不玩该景点
                    else {
                        memo.put(tableIndex, played);
                    }
                }
            }
        }
        return memo.get(new TableIndex(poiList.size() - 1, totalCost));
    }
}
