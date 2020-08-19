package model;

import controller.Main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sounds {
// Star Wars Sounds
    public static Clip clip, clipMusic;
    public static boolean soundsMuted, songMuted;
    public static int song = 0;
    public static String twoOfThem;
    public static String helloThere;
    public static String explosion1;
    public static String explosion2;
    public static String happyLanding;
    public static String noMoon;
    public static String DSExplosion;
    public static String funBegins;
    public static String highGround;
    public static String itsOver;
    public static String dontTryIt;
    public static String honored;
    public static String doIt;
    public static String treatedUnfairly;
    public static String badFeeling;
    public static String haveYouNow;
    public static String wellWhaddyaKnow;
    public static String creditsWillDoFine;
    public static String order66;
    public static String itsATrap;
    public static String goodJob;
    public static String unlimitedPower;
    public static String soUncivilized;
    public static String reallyBigGun;
    public static String underestimateMyPower;
    public static String anakinYell;
    public static String anakinYell2;
    public static String anAngel;
    public static String dontLikeSand;
    public static String notJustTheMen;
    public static String noDangerAtAll;
    public static String shortNegotiations;
    public static String sidiousScream;
    public static String simpleMan;
    public static String theSenate;
    public static String tooDangerous;
    public static String tooWeak;
    public static String treason;
    public static String halfAShip;
    public static String rogerRoger;
    public static String legal;
    public static String makeItLegal;
    public static String thisIsImpossible;
    public static String shootHerOrSomething;
    public static String youCanDoBetter;
    public static String yup;
    public static String fineAddition;
    public static String podracing;
    public static String weGotEem;
    public static String abandonShip;
    public static String darthPlag;
    public static String gangstas;
    public static String takeASeat;
    public static String hate;
    public static String liar;
    public static String myNewEmpire;
    public static String againstMe;
    public static String takingHimNow;
    public static String doneThatYourself;
    public static String no;
    public static String youHaveLost;
    public static String peaceFreedom;
    public static String cantinaBand;
    public static String anakinVsObiwan;
    public static String duelOfFates;
    public static String tOR;
// Halo sounds
    public static String arFiring;
    public static String bansheeFlying;
    public static String bansheeBomb;
    public static String eliteAlert;
    public static String eliteDeath;
    public static String eliteFall;
    public static String flameThrower;
    public static String ghostFiring;
    public static String gruntDeath;
    public static String gruntLaugh;
    public static String hurryChief;
    public static String noTime;
    public static String rocketLaunch;
    public static String sLaser;
    public static String whatAboutHalo;
    public static String wraithBoost;
    public static String wraithMortar;
    public static String haloAccordion;
// Computer Science Teachers Sounds
    // Park
    public static String areYouWithMePark;
    public static String clearThroatPark;
    public static String helloPark;
    public static String httpsPark;
    public static String test2Park;
    public static String continuePark;
    public static String soFarSoGoodPark;
    // McDaniel
    public static String coughMcD;
    public static String theoreticalForkAndJoinMcD;
    public static String executeMcD;
    public static String gainsControlMcD;
    // Qian
    public static String comprehensiveFinalQian;
    public static String backToTheBeginningQian;
    public static String straightToPointQian;
    public static String thatsFineQian;
    public static String youCanDoThisQian;
    // Sung
    public static String createNewHSung;
    public static String doubleClickSung;
    public static String greenTriangleSung;
    public static String helloWorldSung;
    public static String justSkipSung;
    public static String nothingThereSung;
    // Turner
    public static String two4681012Turner;
    public static String andHereWeAreTurner;
    public static String beExecutedTurner;
    public static String doublePowerTurner;
    public static String funTurner;
    public static String goodEveningTurner;
    public static String heresAnExampleTurner;
    public static String multipleTurner;
    public static String objectObjectTurner;
    public static String potentialProblem20000ErrorsTurner;
    public static String powTurner;
    public static String severalPartsTurner;
    public static String thenIReturnTurner;
    public static String tonightUhTurner;
    // Accordion Songs
    public static String battleHymnAccordion;
    public static String snowAccordion;
    public static String sSThemeAccordion;
    public static String takeOnMeAccordion;
    public static String theEntertainer;
    public static String vivaAccordion;

    public Sounds() {
        soundsMuted = false;
        songMuted = false;
        // Star Wars Sounds
        twoOfThem = "../TermProject/src/Sounds/SW/TwoOfThem.wav";
        helloThere = "../TermProject/src/Sounds/SW/ObiWanHelloThere.wav";
        explosion1 = "../TermProject/src/Sounds/SW/Explosion1.wav";
        explosion2 = "../TermProject/src/Sounds/SW/Explosion2.wav";
        happyLanding = "../TermProject/src/Sounds/SW/HappyLanding.wav";
        noMoon = "../TermProject/src/Sounds/SW/NoMoon.wav";
        DSExplosion = "../TermProject/src/Sounds/SW/DSExplosion.wav";
        funBegins = "../TermProject/src/Sounds/SW/FunBegins.wav";
        highGround = "../TermProject/src/Sounds/SW/HighGround.wav";
        itsOver = "../TermProject/src/Sounds/SW/ItsOver.wav";
        dontTryIt = "../TermProject/src/Sounds/SW/DontTryIt.wav";
        honored = "../TermProject/src/Sounds/SW/Honored.wav";
        doIt = "../TermProject/src/Sounds/SW/DoIt.wav";
        treatedUnfairly = "../TermProject/src/Sounds/SW/TreatedUnfairly.wav";
        badFeeling = "../TermProject/src/Sounds/SW/BadFeeling.wav";
        haveYouNow = "../TermProject/src/Sounds/SW/HaveYouNow.wav";
        wellWhaddyaKnow = "../TermProject/src/Sounds/SW/WellWhaddyaKnow.wav";
        creditsWillDoFine = "../TermProject/src/Sounds/SW/CreditsWillDoFine.wav";
        order66 = "../TermProject/src/Sounds/SW/Order66.wav";
        itsATrap = "../TermProject/src/Sounds/SW/ItsATrap.wav";
        goodJob = "../TermProject/src/Sounds/SW/GoodJob.wav";
        unlimitedPower = "../TermProject/src/Sounds/SW/UnlimitedPower.wav";
        soUncivilized = "../TermProject/src/Sounds/SW/SoUncivilized.wav";
        reallyBigGun = "../TermProject/src/Sounds/SW/ReallyBigGun.wav";
        underestimateMyPower = "../TermProject/src/Sounds/SW/UnderestimateMyPower.wav";
        anakinYell = "../TermProject/src/Sounds/SW/AnakinYell.wav";
        anakinYell2 = "../TermProject/src/Sounds/SW/AnakinYell2.wav";
        anAngel = "../TermProject/src/Sounds/SW/AnAngel.wav";
        dontLikeSand = "../TermProject/src/Sounds/SW/DontLikeSand.wav";
        notJustTheMen = "../TermProject/src/Sounds/SW/NotJustTheMen.wav";
        noDangerAtAll = "../TermProject/src/Sounds/SW/NoDangerAtAll.wav";
        shortNegotiations = "../TermProject/src/Sounds/SW/ShortNegotiations.wav";
        sidiousScream = "../TermProject/src/Sounds/SW/SidiousScream.wav";
        simpleMan = "../TermProject/src/Sounds/SW/SimpleMan.wav";
        theSenate = "../TermProject/src/Sounds/SW/TheSenate.wav";
        tooDangerous = "../TermProject/src/Sounds/SW/TooDangerous.wav";
        tooWeak = "../TermProject/src/Sounds/SW/TooWeak.wav";
        treason = "../TermProject/src/Sounds/SW/Treason.wav";
        halfAShip = "../TermProject/src/Sounds/SW/HalfAShip.wav";
        rogerRoger = "../TermProject/src/Sounds/SW/RogerRoger.wav";
        legal = "../TermProject/src/Sounds/SW/Legal.wav";
        makeItLegal = "../TermProject/src/Sounds/SW/MakeItLegal.wav";
        thisIsImpossible = "../TermProject/src/Sounds/SW/ThisIsImpossible.wav";
        shootHerOrSomething = "../TermProject/src/Sounds/SW/ShootHerOrSomething.wav";
        youCanDoBetter = "../TermProject/src/Sounds/SW/YouCanDoBetter.wav";
        yup = "../TermProject/src/Sounds/SW/Yup.wav";
        fineAddition = "../TermProject/src/Sounds/SW/FineAddition.wav";
        podracing = "../TermProject/src/Sounds/SW/Podracing.wav";
        weGotEem = "../TermProject/src/Sounds/SW/WeGotEem.wav";
        abandonShip = "../TermProject/src/Sounds/SW/AbandonShip.wav";
        darthPlag = "../TermProject/src/Sounds/SW/DarthPlag.wav";
        gangstas = "../TermProject/src/Sounds/SW/Gangstas.wav";
        takeASeat = "../TermProject/src/Sounds/SW/TakeASeat.wav";
        againstMe = "../TermProject/src/Sounds/SW/AgainstMe.wav";
        takingHimNow = "../TermProject/src/Sounds/SW/TakingHimNow.wav";
        doneThatYourself = "../TermProject/src/Sounds/SW/DoneThatYourself.wav";
        myNewEmpire = "../TermProject/src/Sounds/SW/MyNewEmpire.wav";
        liar = "../TermProject/src/Sounds/SW/Liar.wav";
        hate = "../TermProject/src/Sounds/SW/Hate.wav";
        no = "../TermProject/src/Sounds/SW/No.wav";
        youHaveLost = "../TermProject/src/Sounds/SW/YouHaveLost.wav";
        peaceFreedom = "../TermProject/src/Sounds/SW/PeaceFreedom.wav";
        cantinaBand = "../TermProject/src/Sounds/SW/CantinaBand.wav";
        anakinVsObiwan = "../TermProject/src/Sounds/SW/AnakinVsObiwan.wav";
        duelOfFates = "../TermProject/src/Sounds/SW/DuelOfFates.wav";
        tOR = "../TermProject/src/Sounds/SW/TOR.wav";
    // Halo Sounds
        arFiring = "../TermProject/src/Sounds/Halo/ARFiring.wav";
        bansheeFlying = "../TermProject/src/Sounds/Halo/BansheeFlying.wav";
        bansheeBomb = "../TermProject/src/Sounds/Halo/BansheeBomb.wav";
        eliteAlert = "../TermProject/src/Sounds/Halo/EliteAlert.wav";
        eliteDeath  = "../TermProject/src/Sounds/Halo/EliteDeath.wav";
        eliteFall  = "../TermProject/src/Sounds/Halo/EliteFall.wav";
        flameThrower  = "../TermProject/src/Sounds/Halo/FlameThrower.wav";
        ghostFiring = "../TermProject/src/Sounds/Halo/GhostFiring.wav";
        gruntDeath = "../TermProject/src/Sounds/Halo/GruntDeath.wav";
        gruntLaugh = "../TermProject/src/Sounds/Halo/GruntLaugh.wav";
        hurryChief = "../TermProject/src/Sounds/Halo/HurryChief.wav";
        noTime = "../TermProject/src/Sounds/Halo/NoTime.wav";
        rocketLaunch = "../TermProject/src/Sounds/Halo/RocketLaunch.wav";
        sLaser = "../TermProject/src/Sounds/Halo/SLaser.wav";
        whatAboutHalo = "../TermProject/src/Sounds/Halo/WhatAboutHalo.wav";
        wraithBoost = "../TermProject/src/Sounds/Halo/WraithBoost.wav";
        wraithMortar = "../TermProject/src/Sounds/Halo/WraithMortar.wav";
        haloAccordion = "../TermProject/src/Sounds/Halo/HaloAccordion.wav";
    // Computer Science Teacher Sounds
        areYouWithMePark = "../TermProject/src/Sounds/CS/AreYouWithMePark.wav";
        clearThroatPark = "../TermProject/src/Sounds/CS/ClearThroatPark.wav";
        helloPark = "../TermProject/src/Sounds/CS/HelloPark.wav";
        httpsPark = "../TermProject/src/Sounds/CS/HTTPSPark.wav";
        test2Park = "../TermProject/src/Sounds/CS/Test2Park.wav";
        continuePark  = "../TermProject/src/Sounds/CS/ContinuePark.wav";
        soFarSoGoodPark  = "../TermProject/src/Sounds/CS/SoFarSoGoodPark.wav";
        coughMcD = "../TermProject/src/Sounds/CS/CoughMcD.wav";
        theoreticalForkAndJoinMcD  = "../TermProject/src/Sounds/CS/TheoreticalForkAndJoinMcD.wav";
        executeMcD =  "../TermProject/src/Sounds/CS/ExecuteMcD.wav";
        gainsControlMcD =  "../TermProject/src/Sounds/CS/GainsControlMcD.wav";
        comprehensiveFinalQian = "../TermProject/src/Sounds/CS/ComprehensiveFinalQian.wav";
        backToTheBeginningQian = "../TermProject/src/Sounds/CS/BackToTheBeginningQian.wav";
        straightToPointQian = "../TermProject/src/Sounds/CS/StraightToPointQian.wav";
        thatsFineQian = "../TermProject/src/Sounds/CS/ThatsFineQian.wav";
        youCanDoThisQian = "../TermProject/src/Sounds/CS/YouCanDoThisQian.wav";
        doubleClickSung = "../TermProject/src/Sounds/CS/DoubleClickSung.wav";
        createNewHSung = "../TermProject/src/Sounds/CS/LetsCreateNewHSung.wav";
        greenTriangleSung = "../TermProject/src/Sounds/CS/GreenTriangleSung.wav";
        helloWorldSung = "../TermProject/src/Sounds/CS/HelloWorldSung.wav";
        justSkipSung = "../TermProject/src/Sounds/CS/JustSkipSung.wav";
        nothingThereSung = "../TermProject/src/Sounds/CS/NothingThereSung.wav";
        two4681012Turner = "../TermProject/src/Sounds/CS/24681012Turner.wav";
        andHereWeAreTurner = "../TermProject/src/Sounds/CS/AndHereWeAreTurner.wav";
        beExecutedTurner = "../TermProject/src/Sounds/CS/BeExecutedTurner.wav";
        doublePowerTurner = "../TermProject/src/Sounds/CS/DoublePowerTurner.wav";
        funTurner = "../TermProject/src/Sounds/CS/FunTurner.wav";
        goodEveningTurner = "../TermProject/src/Sounds/CS/GoodEveningTurner.wav";
        heresAnExampleTurner = "../TermProject/src/Sounds/CS/HeresAnExampleTurner.wav";
        multipleTurner = "../TermProject/src/Sounds/CS/MultipleTurner.wav";
        objectObjectTurner = "../TermProject/src/Sounds/CS/ObjectObjectTurner.wav";
        potentialProblem20000ErrorsTurner = "../TermProject/src/Sounds/CS/PotentialProblem20000ErrorsTurner.wav";
        powTurner = "../TermProject/src/Sounds/CS/PowTurner.wav";
        severalPartsTurner = "../TermProject/src/Sounds/CS/SeveralPartsTurner.wav";
        thenIReturnTurner = "../TermProject/src/Sounds/CS/ThenIReturnTurner.wav";
        tonightUhTurner = "../TermProject/src/Sounds/CS/TonightUhTurner.wav";
        battleHymnAccordion = "../TermProject/src/Sounds/CS/BattleHymnAccordion.wav";
        snowAccordion = "../TermProject/src/Sounds/CS/SnowAccordion.wav";
        sSThemeAccordion = "../TermProject/src/Sounds/CS/SSThemeAccordion.wav";
        takeOnMeAccordion = "../TermProject/src/Sounds/CS/TakeOnMeAccordion.wav";
        theEntertainer = "../TermProject/src/Sounds/CS/TheEntertainer.wav";
        vivaAccordion = "../TermProject/src/Sounds/CS/VivaAccordion.wav";
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(rogerRoger)));
            clipMusic = AudioSystem.getClip();
            clipMusic.open(AudioSystem.getAudioInputStream(new File(tOR)));
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
    }

    public static void loadSound(String bip) { //Loads and plays sounds with file path passed to it
        if (!soundsMuted) {
            try {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(bip)));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }

    public static void loadSong(String bip){
        if(!songMuted) {
            try {
                clipMusic = AudioSystem.getClip();
                clipMusic.open(AudioSystem.getAudioInputStream(new File(bip)));
                clipMusic.start();
                clipMusic.loop(clipMusic.getFrameLength());
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }

    public static void nextSong(){
        if (Main.selectedMap == 1) {
            if(song == 3) song = 0;
            else song++;
        } else if (Main.selectedMap == 2) {
            if(song == 4) song = 4;
            else song++;
        } else {
            if(song == 10) song = 5;
            else song++;
        }
        playSong();
    }

    public static void playSong(){
        if(song == 0){
            clipMusic.stop();
            loadSong(anakinVsObiwan);
        }else if(song == 1){
            clipMusic.stop();
            loadSong(duelOfFates);
        }else if(song == 2){
            clipMusic.stop();
            loadSong(cantinaBand);
        }else if(song == 3){
            clipMusic.stop();
            loadSong(tOR);
        }else if(song == 4){
            clipMusic.stop();
            loadSong(haloAccordion);
        }else if(song == 5){
            clipMusic.stop();
            loadSong(theEntertainer);
        }else if(song == 6){
            clipMusic.stop();
            loadSong(snowAccordion);
        }else if(song == 7){
            clipMusic.stop();
            loadSong(battleHymnAccordion);
        }else if(song == 8){
            clipMusic.stop();
            loadSong(takeOnMeAccordion);
        }else if(song == 9){
            clipMusic.stop();
            loadSong(vivaAccordion);
        }else if(song == 10){
            clipMusic.stop();
            loadSong(sSThemeAccordion);
        }
    }
}
