package FixtureGenerator.app;

import java.util.*;

public class Fixture {
    private  ArrayList<Team> teams = new ArrayList<>();
    private  List<String> firstHalf = new ArrayList<>();
    private  List<String> secondHalf = new ArrayList<>();


    public  void run()
    {
        addTeams();

    }

    private void addTeams()
    {
        var GS = new Team("Galatasaray");
        var FB = new Team("Fenerbahce");
        var BJK = new Team("Besiktas");
        var TS = new Team("Trabzonspor");
        var BS = new Team("Bursaspor");
        var İBFK = new Team("IBFK");


        teams.add(GS);
        teams.add(FB);
        teams.add(BS);
        teams.add(İBFK);
        teams.add(BJK);
        teams.add(TS);

        if(teams.size() % 2 != 0){
            var Bay = new Team("Bay");
            teams.add(Bay);
        }

        createFixture();

    }

    private void createFixture()
    {

        Random r = new Random();

        for(int i = 0; i < teams.size() - 1; ++i) {
            //İlk devre fikstürü bu loop'ta. Ligde bir devrede takım sayısnın bir eksiği kadar hafta olur.

            var selectedTeams = new HashSet<Team>(); //o hafta seçilen takımlar buraya atılacak, bir kere atılan takım tekrar atılamayacak.Her hafta bu collection sıfırlanacak,

            while (selectedTeams.size() != teams.size()) {

                var home = teams.get(r.nextInt(teams.size()));
                var away = teams.get(r.nextInt(teams.size()));

                if (home != away && !selectedTeams.contains(home) && !selectedTeams.contains(away)) {

                    var match = home.toString() + " vs " + away.toString();
                    var match2 = away.toString() + " vs " + home.toString();

                    if (!firstHalf.contains(match) && !firstHalf.contains(match2)) {
                        firstHalf.add(match);
                        secondHalf.add(match2);
                        selectedTeams.add(home);
                        selectedTeams.add(away);
                    }
                }
            }

        }

        printFixture();


    }

    private void printFixture()
    {
        var weak = 1;
        for(int i = 0; i < teams.size()-1 ; ++i){
            System.out.println(String.format("----------Weak "+weak+"-----------"));
            for(int j = (i * (teams.size() / 2)) ; j < (i * (teams.size() / 2)) + teams.size() / 2 ; ++j)
            {
                System.out.println(firstHalf.get(j));
            }
            ++weak;
        }

        var weak2 = teams.size() ;

        for(int i = 0; i < teams.size()-1 ; ++i){
            System.out.println(String.format("----------Weak "+weak2+"-----------"));
            for(int j = (i * (teams.size() / 2)) ; j < (i * (teams.size() / 2)) + teams.size() / 2 ; ++j)
            {
                System.out.println(secondHalf.get(j));
            }
            ++weak2;
        }

    }
}

