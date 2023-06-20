package com.github.vihaan.codewars.kyu4.codewarsStyleRankingSystem;

public class User {
    int rank;
    int progress;

    public User() {
        this.rank = LOWEST_RANK;
        this.progress = 0;
    }

    public void incProgress(int taskRank) {
        if (isMaxRank()) {
            return;
        } else if (!isValidTaskRank(taskRank)) {
            throw new IllegalArgumentException();
        }
        var obtainedProgress = 0;
        if (rank == taskRank) {
            obtainedProgress = 3;
        } else if (rank > taskRank) {
            var diff = Math.abs(rank - taskRank);
            if (Integer.signum(rank) != Integer.signum(taskRank)) {
                diff -= 1;
            }
            obtainedProgress = diff <= 1 ? 1 : 0;
        } else {
            var diff = Math.abs(taskRank - rank);
            if (Integer.signum(rank) != Integer.signum(taskRank)) {
                diff -= 1;
            }
            obtainedProgress = Math.toIntExact(Math.round(10 * Math.pow(diff, 2)));
        }
        progress += obtainedProgress;
        while (progress >= EXP_TO_PROMOTION && rank < HIGHEST_RANK) {
            progress -= EXP_TO_PROMOTION;
            rank += 1;
            if (rank == 0) {
                rank = 1;
            } else if (rank == HIGHEST_RANK) {
                progress = 0;
                return;
            }
        }

        if (rank >= HIGHEST_RANK) {
            rank = HIGHEST_RANK;
            progress = 0;
        } else if (rank < LOWEST_RANK) {
            rank = LOWEST_RANK;
        } else if (rank == 0) {
            rank = 1;
        }
    }

    private boolean isValidTaskRank(int taskRank) {
        return taskRank <= HIGHEST_RANK && taskRank >= LOWEST_RANK && taskRank != 0;
    }

    private boolean isMaxRank() {
        return this.rank >= HIGHEST_RANK;
    }

    private static final int HIGHEST_RANK = 8;
    private static final int LOWEST_RANK = -8;
    private static final int EXP_TO_PROMOTION = 100;
}


