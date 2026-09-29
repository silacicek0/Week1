 
package week1;
import java.util.Scanner;
 
public class Week1 {
 
    public static void main(String[] args) {
        System.out.println("-----TEAMS-----");
        System.out.println("Team A");
        System.out.println("Team B");
        System.out.println("Team C");
        System.out.println("Team D");
        
        System.out.println("-----MATCHES-----");
        System.out.println("MATCH 1: Team A & Team B");
        System.out.println("MATCH 2: Team A & Team C");
        System.out.println("MATCH 3: Team A & Team D");
        System.out.println("MATCH 4: Team B & Team C");
        System.out.println("MATCH 5: Team B & Team D");
        System.out.println("MATCH 6: Team C & Team D");
        
        
        int[] goalsFor = new int[4];
        int[] goalsAgainst  = new int[4];
        String[] teams = {"Team A", "Team B", "Team C", "Team D"};
        int[] first  = {0, 0, 0, 1, 1, 2};   
        int[] second = {1, 2, 3, 2, 3, 3};    
        
        int[] points = new int[4];
        int[] played = new int[4];
        int[] wins = new int[4];
        int[] draws = new int[4];
        int[] losses = new int[4];
        int[] score1 = new int[6];    
        int[] score2 = new int[6];
        
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            
            int t1 = first[i];
            int t2 = second[i];
            System.out.print("Match "+(i+1)+": "+teams[t1]+" vs "+teams[t2]+" -- "+teams[t1]+" goals: ");
            int firstTeamGoal = scanner.nextInt();
            System.out.print(teams[t2]+" goals: ");
            int secondTeamGoal = scanner.nextInt();
            score1[i] = firstTeamGoal;
            score2[i] = secondTeamGoal;

            
            switch(i){
                case 0:
                    goalsAgainst[1] = goalsAgainst[1] + firstTeamGoal;
                    goalsFor[0] = goalsFor[0] + firstTeamGoal;
                    goalsAgainst[0] = goalsAgainst[0] + secondTeamGoal;
                    goalsFor[1] = goalsFor[1] + secondTeamGoal;
                    break;
                case 1:
                    goalsAgainst[2] = goalsAgainst[2] + firstTeamGoal;
                    goalsFor[0] = goalsFor[0] + firstTeamGoal;
                    goalsAgainst[0] = goalsAgainst[0] + secondTeamGoal;
                    goalsFor[2] = goalsFor[2] + secondTeamGoal;
                    break;
                case 2:
                    goalsAgainst[3] = goalsAgainst[3] + firstTeamGoal;
                    goalsFor[0] = goalsFor[0] + firstTeamGoal;
                    goalsAgainst[0] = goalsAgainst[0] + secondTeamGoal;
                    goalsFor[3] = goalsFor[3] + secondTeamGoal;
                    break;
                case 3:
                    goalsAgainst[2] = goalsAgainst[2] + firstTeamGoal;
                    goalsFor[1] = goalsFor[1] + firstTeamGoal;
                    goalsAgainst[1] = goalsAgainst[1] + secondTeamGoal;
                    goalsFor[2] = goalsFor[2] + secondTeamGoal;
                    break;
                case 4:
                    goalsAgainst[3] = goalsAgainst[3] + firstTeamGoal;
                    goalsFor[1] = goalsFor[1] + firstTeamGoal;
                    goalsAgainst[1] = goalsAgainst[1] + secondTeamGoal;
                    goalsFor[3] = goalsFor[3] + secondTeamGoal;
                    break;
                case 5:
                    goalsAgainst[3] = goalsAgainst[3] + firstTeamGoal;
                    goalsFor[2] = goalsFor[2] + firstTeamGoal;
                    goalsAgainst[2] = goalsAgainst[2] + secondTeamGoal;
                    goalsFor[3] = goalsFor[3] + secondTeamGoal;
                    break;
            }
            
            played[t1]++;
            played[t2]++;
            if(firstTeamGoal == secondTeamGoal){
                points[t1]++;
                points[t2]++;
                draws[t1]++;
                draws[t2]++;
            } else if(firstTeamGoal > secondTeamGoal){
                points[t1] += 3;
                wins[t1]++;
                losses[t2]++;
            } else {
                points[t2] += 3;
                wins[t2]++;
                losses[t1]++;
            }
        }
        
        System.out.println("-----MATCH SCORES-----");
        for(int i = 0; i < 6; i++){
            System.out.println("Match "+(i+1)+": "+teams[first[i]]+" "+score1[i]+" - "+score2[i]+" "+teams[second[i]]);
        }
        
        int[] goalDiff = new int[4];
        for(int i = 0; i < 4; i++){
            goalDiff[i] = goalsFor[i] - goalsAgainst[i];
        }
        
        System.out.println("-----STANDINGS-----");
        System.out.printf("%-10s %-8s %-6s %-6s %-6s %-8s %-8s%n", "TEAM", "PLAYED", "WIN", "DRAW", "LOSS", "POINTS", "GD");
        for(int i = 0; i < 4; i++){
            System.out.printf("%-10s %-8d %-6d %-6d %-6d %-8d %-8d%n", teams[i], played[i], wins[i], draws[i], losses[i], points[i], goalDiff[i]);
        }
        
        int champion = 0;
        for(int i = 1; i < 4; i++){
            if(points[i] > points[champion] || (points[i] == points[champion] && goalDiff[i] > goalDiff[champion])){
                champion = i;
            }
        }
        System.out.println("Tournament Champion: "+teams[champion]);
       

    }
    
}
