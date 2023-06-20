package com.github.vihaan.codewars.kyu4.codewarsStyleRankingSystem;

public class User {
    int rank;
    int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public void incProgress(int taskRank) {
        var obtainedProgress = 0;
        if (isMaxRank())
            return;
        if (taskRank == this.rank) {
            obtainedProgress = 3;
        } else if (taskRank < this.rank) {
            var diff = Math.abs(this.rank - taskRank);
            if (Integer.signum(taskRank) != Integer.signum(this.rank)) {
                diff -= 1;
            }
            obtainedProgress += (diff > 1 || diff < -1) ? 0 : 1;
        } else {
            var diff = taskRank - this.rank;
            if (Integer.signum(taskRank) != Integer.signum(this.rank)) {
                diff -= 1;
            }
            obtainedProgress = 10 * diff * diff;
        }
        progress += obtainedProgress;
        while (progress >= EXP_TO_PROMOTION && rank <= 8) {
            progress -= EXP_TO_PROMOTION;
            rank += 1;
            if (rank == 0) {
                rank += 1;
            }
        }
    }

    private boolean isMaxRank() {
        return this.rank == HIGHEST_RANK;
    }

    private static final int HIGHEST_RANK = 8;
    private static final int EXP_TO_PROMOTION = 100;
}


