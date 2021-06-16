package algorithms.curated170.medium;

public class FindTheCelebrity {

    public int findCelebrity(int n) {
        int celeb = 0;
        for (int p = 0; p < n; ++p)
            if (knows(celeb, p))
                celeb = p;
        for (int p = 0; p < celeb; ++p)
            if (knows(celeb, p))
                return -1;
        for (int p = 0; p < n; ++p)
            if (!knows(p, celeb))
                return -1;
        return celeb;
    }

    int[][] relations;

    public FindTheCelebrity(int[][] relations) {
        this.relations = relations;
    }

    boolean knows(int a, int b) {
        return relations[a][b] == 1;
    }

    public static void main(String[] args) {

        int[][] relations = { { 1, 0, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 } };
        var solution = new FindTheCelebrity(relations);
        System.out.println(solution.findCelebrity(relations.length)); // prints 3

        relations = new int[][] { { 1, 0 }, { 0, 1 } };
        solution = new FindTheCelebrity(relations);
        System.out.println(solution.findCelebrity(relations.length)); // prints -1

        relations = new int[][] { { 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1 }, { 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0 }, { 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1 } };
        solution = new FindTheCelebrity(relations);
        System.out.println(solution.findCelebrity(relations.length)); // prints 9

        relations = new int[][] { { 1, 0, 1, 1, 0 }, { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0 },
                { 0, 1, 1, 1, 1 } };
        solution = new FindTheCelebrity(relations);
        System.out.println(solution.findCelebrity(relations.length)); // prints 3

    }
}