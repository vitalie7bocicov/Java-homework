import java.util.concurrent.TimeUnit;

class Generator
{
    public static void main(String[] args) {
    }

    public String[] generate(int n, int p, char[] alphabet)
    {
        String[] words = new String[n];
        for(int i=0;i<n;i++)
        {
            StringBuilder sb= new StringBuilder();
            for(int j=0;j<p;j++)
            {
                int pos=-1;
                while(pos<0)
                    pos=(int)(Math.random()*(alphabet.length+1))-1;
                sb.append(alphabet[pos]);
            }
            words[i]=sb.toString();
        }
        return words;
    }

    public boolean checkNeighbors(String n1, String n2)
    {
        for(int i=0;i<n1.length();i++)
            if(n2.indexOf(n1.charAt(i))!=-1)
                return true;
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if(args.length<3)
        {
            System.out.println("Not enough argumets!");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int alphabetSize= args.length-2;
        char [] alphabet = new char[alphabetSize];
        for(int i=0;i< alphabetSize;i++)
            alphabet[i]=args[i+2].charAt(0);
        Generator g = new Generator();
        String [] words = g.generate(n,p,alphabet);


        boolean [][] adjWords = new boolean[n][n];
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                adjWords[i][j]=adjWords[j][i]=g.checkNeighbors(words[i],words[j]);

        String [][]neighbors = new String[n][];

        for(int i=0;i<n;i++) {
            int nrOfNeighbors=0;
            for (int j = 0; j < n; j++) {
                if(adjWords[i][j]==true)
                    nrOfNeighbors++;
            }
            neighbors[i]=new String[nrOfNeighbors];
        }
        for(int i=0;i<n;i++) {
            int k=0;
            for (int j = 0; j < n; j++)
                if (adjWords[i][j] == true)
                    neighbors[i][k++]=words[j];
        }

//        System.out.println("Data structure that stores the neighbors of each word:");
//        for(int i=0;i<n;i++) {
//            for (String element : neighbors[i])
//                System.out.print(element + " ");
//            System.out.println();
//        }

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }
}
//input : 29000 7 A C G T
//output: Execution time in nanoseconds: 22057237300