package com.dev.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin分支合并
 * 使用方法：
 * 1.forkJoinPool 通过它执行
 * 2.计算任务 forkjoinPool.execute(ForkJoinTask task)
 * 3.计算类要继承 ForkJoinTask
 * 求和任务 计算1-10亿的和
 *
 * @author 路飞
 * @create 2021/1/20
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }



    @Override
    protected Long compute() {
        if ((end-start)<temp){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else { //forkjoin递归
            long middle =  (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start , middle);
            task1.fork(); // 拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1 , end);
            task2.fork(); // 拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}
