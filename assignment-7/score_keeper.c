// scores.c
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

static double round2(double x) {
    // round to 2 decimals, e.g. 1.234 -> 1.23, 1.235 -> 1.24
    return round(x * 100.0) / 100.0;
}

int main(void) {
    int n;
    printf("How many scores? ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        fprintf(stderr, "Invalid count.\n");
        return 1;
    }

    double *s = (double *)malloc((size_t)n * sizeof(double));
    if (!s) {
        fprintf(stderr, "Out of memory.\n");
        return 1;
    }

    // Input, total, and max in one pass
    double total = 0.0;
    double hi = -INFINITY;
    for (int i = 0; i < n; ++i) {
        printf("Enter a score: ");
        if (scanf("%lf", &s[i]) != 1) {
            fprintf(stderr, "Invalid score.\n");
            free(s);
            return 1;
        }
        total += s[i];
        if (s[i] > hi) hi = s[i];
    }

    double avg = total / n;

    // Print summary like Python version
    printf("The average score is %g\n", avg);
    printf("The highest score is %g\n", hi);

    // Branch-light reporting
    const char *labels[3] = {"below", "equivalent to", "above"};

    for (int i = 0; i < n; ++i) {
        double num = round2(s[i]);                 // match Python: round item first
        double by  = round2(fabs(num - avg));      // difference rounded to 2 decimals
        int gt = num > avg;
        int lt = num < avg;
        const char *where = labels[gt - lt + 1];   // -1,0,1 -> index 0,1,2

        printf("%.2f is %s the average", num, where);
        if (gt || lt) printf(" by %.2f", by);      // omit "by ..." when equal
        printf("\n");
    }

    free(s);
    return 0;
}
