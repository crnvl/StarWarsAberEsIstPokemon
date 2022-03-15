import java.util.Scanner;

public class CharacterCreation { //Our work is never over. ~Daft Punk
    public void setPlayers(int p1, int p2) {
        //Character Creation START
        Character player1 = new Character();
        Character player2 = new Character();
        
        Character LukeSkywalker = new Character();
        Character DarthVader = new Character();
        Character Palpatine = new Character();
        Character RahmKota = new Character();
        Character LeiaOrgana = new Character();
        Character HanSolo = new Character();
        Character Chewbacca = new Character();
        Character BobaFett = new Character();
        Character Stormtrooper = new Character();
        Character RebelSoldier = new Character();
        Character MilitiaSoldier = new Character();
        //Character Creation STOP
        
        
        
        //Character Setters START
        LukeSkywalker.setStats("Luke Skywalker", "TIER3", true); //Name, TIER, forcesensitive
        DarthVader.setStats("Darth Vader", "TIER3", true);
        Palpatine.setStats("Emperor Palpatine", "TIER3", true);
        RahmKota.setStats("General Rahm Kota", "TIER3", true);
        LeiaOrgana.setStats("Leia Organa", "TIER2", false);
        HanSolo.setStats("Han Solo", "TIER2", false);
        Chewbacca.setStats("Chewbacca", "TIER2", false);
        BobaFett.setStats("Boba Fett", "TIER2", false);
        Stormtrooper.setStats("Stormtrooper", "TIER1", false);
        RebelSoldier.setStats("Rebel Soldier", "TIER1", false);
        MilitiaSoldier.setStats("Kota Militia Soldier", "TIER1", false);
        
        LukeSkywalker.setAttacks("Lichtschwert Angriff", "Machtschub", "Abwehr", "Machtheilung");
        DarthVader.setAttacks("Lichtschwert Angriff", "Machtschub", "Machtwürgung", "Lichtschwert Wurf");
        Palpatine.setAttacks("Lichtschwert Angriff", "Machtblitz", "Machtwurf", "Dunkle Aura");
        RahmKota.setAttacks("Lichtschwert Angriff", "Militia Unterstützung", "Machtschub", "Machtschild");
        LeiaOrgana.setAttacks("Blaster Angriff", "Blaster Schnellfeuer", "Hoffnung", "Stimpacks");
        HanSolo.setAttacks("Blaster Angriff", "Genauigkeit", "Sprengsatz", "Scharfschützenschuss");
        Chewbacca.setAttacks("Armbrust Schuss", "Armbrust Multi-Schuss", "Wookie Wut", "Granate");
        BobaFett.setAttacks("Blaster Angriff", "Flammenwerfer", "Handgelenkrakete", "Detpack");
        Stormtrooper.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");
        RebelSoldier.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");        
        MilitiaSoldier.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");
        //Character Setters STOP
        
        
        
        //Switch START
        switch(p1) {
            case 1:
                player1 = LukeSkywalker;
                break;
            case 2:
                player1 = DarthVader;
                break;
            case 3:
                player1 = Palpatine;
                break;
            case 4:
                player1 = RahmKota;
                break;
            case 5:
                player1 = LeiaOrgana;
                break;
            case 6:
                player1 = HanSolo;
                break;
            case 7:
                player1 = Chewbacca;
                break;
            case 8:
                player1 = BobaFett;
                break;
            case 9:
                player1 = Stormtrooper;
                break;
            case 10:
                player1 = RebelSoldier;
                break;
            case 11:
                player1 = MilitiaSoldier;
                break;
            default:
                System.out.println("Wichtiger Fehler! Was ist passiert?");
                break;
        }
        player1.printStats();
        switch(p2) {
            case 1:
                player2 = LukeSkywalker;
                break;
            case 2:
                player2 = DarthVader;
                break;
            case 3:
                player2 = Palpatine;
                break;
            case 4:
                player2 = RahmKota;
                break;
            case 5:
                player2 = LeiaOrgana;
                break;
            case 6:
                player2 = HanSolo;
                break;
            case 7:
                player2 = Chewbacca;
                break;
            case 8:
                player2 = BobaFett;
                break;
            case 9:
                player2 = Stormtrooper;
                break;
            case 10:
                player2 = RebelSoldier;
                break;
            case 11:
                player2 = MilitiaSoldier;
                break;
            default:
                System.out.println("Wichtiger Fehler! Was ist passiert?");
                break;
        }
        player2.printStats();
        //Switch STOP
        
        
        int p1attack = 1; //MUSS AUSSERHALB DER WHILE SCHLEIFE SEIN!!! 
        int p2attack = 1;
        
        //Kampf an sich START
        while(true) {
            Scanner attackinput = new Scanner(System.in);
            if(player1.getAttackSpeed()>player2.getAttackSpeed()) { //Spieler 1 fängt an
                    checkBurn(player2, player1, p2attack, p1attack);
                    System.out.println("\nSpieler 1, wähle deine Attacke:");
                    for(int i = 0; i<player1.getAttacks().length; i++) { //Je nach Anzahl der Attacken, meist 4
                        System.out.println((i+1) + ") " + player1.getAttacks()[i]); //Printet z.b. 1) Melee
                    }
                    p1attack = attackinput.nextInt();
                    player1.setCurrentAttack(p1attack); //Geht wieder rüber zu class "Character", setzt vorherige input Variable "p1attack" ein.
                    player1.Attacks(); //setzt die damage values
                    
                    
                    if(player2.getAttacks()[p2attack-1].contains("schild") || player2.getAttacks()[p2attack-1].equals("Abwehr")) { //MUSS VOR SETLIFE SEIN!!! Sonst klappt es nicht. WAG ES JA NICHT WIEDER DEN CODE HIER ZU ZWEIFELN; SONST KRIEGT DER SPIELER SCHADEN
                        player1.setFinalAttackDamage(0);   
                    }
                    
                    
                    player2.setLife(player2.getLife()-player1.getFinalAttackDamage()); //Fügt den Schaden hinzu
                    AttackOutput(player1, player2); //Printet ob man sich heilt oder ob man Schaden gemacht hat und wie viel
                    
                    if(player2.getLife()<0) { //Wenn Spieler 2 0 HP hat
                        System.out.println("\nGlückwunsch, Spieler 1, du hast gewonnen!");
                        break;
                    }
                    
                    
                    checkBurn(player1, player2, p1attack, p2attack);
                    System.out.println("\nSpieler 2, wähle deine Attacke:");
                    for(int i = 0; i<player2.getAttacks().length; i++) { //Je nach Anzahl der Attacken, meist 4
                        System.out.println((i+1) + ") " + player2.getAttacks()[i]); //Printet z.b. 1) Melee
                    }
                    p2attack = attackinput.nextInt();
                    player2.setCurrentAttack(p2attack); //Geht wieder rüber zu class "Character", setzt vorherige input Variable "p2attack" ein.
                    player2.Attacks(); //setzt die damage values
                    
                    
                    if(player1.getAttacks()[p1attack-1].contains("schild") || player1.getAttacks()[p1attack-1].equals("Abwehr")) {
                        player2.setFinalAttackDamage(0);   
                    }
                    
                    
                    player1.setLife(player1.getLife()-player2.getFinalAttackDamage()); //Fügt den Schaden hinzu
                    AttackOutput(player2, player1);
                    
                    if(player1.getLife()<0) { //Wenn Spieler 1 0 HP hat
                        System.out.println("\nGlückwunsch, Spieler 2, du hast gewonnen!");
                        break;
                    }
                }
                
                
                else {
                    checkBurn(player1, player2, p1attack, p2attack);
                    System.out.println("\nSpieler 2, wähle deine Attacke:");
                    for(int i = 0; i<player2.getAttacks().length; i++) {
                        System.out.println((i+1) + ") " + player2.getAttacks()[i]);
                    }
                    p2attack = attackinput.nextInt();
                    player2.setCurrentAttack(p2attack);
                    player2.Attacks();
                    
                    if(player1.getAttacks()[p1attack-1].contains("schild") || player1.getAttacks()[p1attack-1].equals("Abwehr")) {
                        player2.setFinalAttackDamage(0);   
                    }
                    
                    
                    player1.setLife(player1.getLife()-player2.getFinalAttackDamage());
                    AttackOutput(player2, player1);
                    
                    if(player1.getLife()<0) {
                        System.out.println("\nGlückwunsch, Spieler 2, du hast gewonnen!");
                        break;
                    }
                    
                    
                    checkBurn(player2, player1, p2attack, p1attack);
                    System.out.println("\nSpieler 1, wähle deine Attacke:");
                    for(int i = 0; i<player1.getAttacks().length; i++) {
                        System.out.println((i+1) + ") " + player1.getAttacks()[i]);
                    }
                    p1attack = attackinput.nextInt();
                    player1.setCurrentAttack(p1attack);
                    player1.Attacks();
                    
                    if(player2.getAttacks()[p2attack-1].contains("schild") || player2.getAttacks()[p2attack-1].equals("Abwehr")) {
                        player1.setFinalAttackDamage(0);   
                    }
                    
                    
                    player2.setLife(player2.getLife()-player1.getFinalAttackDamage());
                    AttackOutput(player1, player2);
                    
                    if(player2.getLife()<0) {
                        System.out.println("\nGlückwunsch, Spieler 1, du hast gewonnen!");
                        break;
                    }
                }
        }
        //Kampf an sich STOP
    }
    
    public void AttackOutput(Character input1, Character input2) {
        if(input1.getType().equals("Heal")) { //Falls die Attacke eine Heilung war.
                        System.out.println("\n" + input1.getName() + " hat 250 Leben geheilt und hat somit jetzt " + input1.getLife() + " Leben.");
                    }
                else if (input1.getType().equals("Shield")) { //Falls die Attacke blockt/abwehrt
                        System.out.println("\n" + input1.getName() + " ist für die nächste Runde geschützt.");
                }
                else {
                        if(input1.getFinalAttackDamage()>input1.getDamage()) { //Falls es mehr Schaden macht, als dein Character kann (dank der Attacke)
                        System.out.println("\n" + input1.getName() + " greift " + input2.getName() + " an und fügt " + input1.getFinalAttackDamage() + " Schaden hinzu, " + (input1.getFinalAttackDamage()-input1.getDamage()) + " Schaden mehr als es sollte. " + input2.getName() + " hat noch " + input2.getLife() + " Leben übrig.");
                        }
                        else { //Falls es weniger Schaden macht, als dein Character kann ("dank" der Attacke)
                        System.out.println("\n" + input1.getName() + " greift " + input2.getName() + " an und fügt " + input1.getFinalAttackDamage() + " Schaden hinzu, " + (input1.getDamage()-input1.getFinalAttackDamage()) + " Schaden weniger als es sollte. " + input2.getName() + " hat noch " + input2.getLife() + " Leben übrig.");
                        }
                    }
    }
    
    public void checkBurn(Character input1, Character input2, int p1attackinput, int p2attackinput) { //input1 = Brandverursacher, input2 = Opfer, p1attackinput = p1attack, p2attackinput = p2attack
        if(input1.getBurnCounter()>0) { //Wenn der Brandschaden noch aktiv ist
            input1.setBurnCounter(input1.getBurnCounter()-1); //Eins pro Runde runterstellen
            if(input2.getAttacks()[p2attackinput-1].contains("schild") || input2.getAttacks()[p2attackinput-1].equals("Abwehr")) { //Falls Shield type aktiv ist
                        System.out.println("\n" + input2.getName() + " hat den Brandschaden blockiert. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
                }
            else {
                input2.setLife(input2.getLife()-50);
                System.out.println("\n" + input2.getName() + " hat 50 Leben an Brandschaden verloren. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
            }
        }
        else {
            //Deine Mutter LMAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        }
    }
}
