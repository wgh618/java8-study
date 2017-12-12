package com.will.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName:StreamDemo2
 * Description:Task类有一个分数的概念（或者说是伪复杂度），其次是还有一个值可以为OPEN或CLOSED的状态
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class StreamDemo2 {
    private enum Status {
        OPEN, CLOSED
    }

    ;

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String[] args) {
        /* stream操作被分成了中间操作与最终操作这两种。
        中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，运行一个像filter这样的中间操作实际上没有进行任何过滤，
        相反它在遍历元素时会产生了一个新的stream对象，这个新的stream对象包含原始stream中符合给定谓词的所有元素。
        像forEach、sum这样的最终操作可能直接遍历stream，产生一个结果或副作用。当最终操作执行结束之后，
        stream管道被认为已经被消耗了，没有可能再被使用了。在大多数情况下，最终操作都是采用及早求值方式，及早完成底层数据源的遍历。*/


        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        /*所有状态为OPEN的任务一共有多少分数--Calculate total points of all active tasks using sum()*/
        /* 注意事项。第一，task集合被转换化为其相应的stream表示。然后，filter操作过滤掉状态为CLOSED的task。
        下一步，mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。
        最后，用sum函数把所有的分数加起来，得到最终的结果。*/
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("Total points: " + totalPointsOfOpenTasks);

        /*stream另一个有价值的地方是能够原生支持并行处理。让我们来看看这个算task分数和的例子*/
        final double totalPoints = tasks
                .stream()
                .parallel()
                // or map(Task::getPoints)
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        /*按照某种准则来对集合中的元素进行分组*/
        // Group tasks by their status
        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        /*计算整个集合中每个task分数（或权重）的平均值*/
        // Calculate the weight of each tasks (as percent of total points)
        final Collection<String> result = tasks
                .stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble(points -> points / totalPoints)

                // stream< Double >
                .boxed()
                .mapToLong(weigth -> (long) (weigth * 100))

                // stream< String>
                .mapToObj(percentage -> percentage + "%")

                // List< String >
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
