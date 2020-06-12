
//Anthony Tu - God of this program
//ICS4U
//September 30, 2014 - January 18
// An awesome game where you cut up some flying fruit
package waibabffgame;

/*

 */
/**
 * @author Anthony Tu
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;


import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * 
 */
public class Game extends JPanel implements Runnable {

    boolean Mute = false;
    int testw = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    int testh = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    public static Double awidth = 0.0;
    public static Double aheight = 0.0;
    //These variables dictate which screen is shown and functions are used.
    public static boolean ingame;
    public static boolean play;
    public static boolean mmenu;
    public static boolean levelselect;
    //Main image that displays EVERYTHING!!!!
    BufferedImage Imager = new BufferedImage(1024, 725, BufferedImage.TYPE_INT_ARGB);
    //Fruit image arraylist
    public static ArrayList<BufferedImage> FruitImage = new ArrayList();
    //"Objects" - Most are pretty self-explanitory -----
    public static Ninja ninja;
    public static ArrayList<Fruit> fruit = new ArrayList();
    public static ArrayList<Buttons> buttons = new ArrayList();
    public static GameBackground background;
    public static GameBackground background2;
    public static LifeHolder lifeholder;
    //The Thread that allows code to be run similtaniously
    private Thread animator;
    //Fruit related variables ----
    //The number of fruit currently on the screen
    public static int NumberofFruit = 0;
    //Time to spawn the fruit
    private int SpawnFruitTime = 0;
    int SpawnFruitTimer = 0;
    //Sets the fruit as dead
    ArrayList<Boolean> FruitDeadSetter = new ArrayList();
    //Fruit Rotation variables
    ArrayList<Double> rotationRequired = new ArrayList();
    ArrayList<Double> locationX = new ArrayList();
    ArrayList<Double> locationY = new ArrayList();
    ArrayList<AffineTransform> tx = new ArrayList();
    ArrayList<AffineTransformOp> op = new ArrayList();
    ArrayList<Integer> FruitRotation = new ArrayList();
    ArrayList<Integer> DieTimer = new ArrayList();
    int SpawnedFruitNumber = 0;
    //Fruit Images -------------------------------
    //Normal Fruit --------
    //Apple Images
    public static BufferedImage HPp2;
    public static BufferedImage HPS1;
    public static BufferedImage HPS2;
    public static BufferedImage HPS3;
    private BufferedImage AI;
    private BufferedImage[] rAI = new BufferedImage[361];
    public static BufferedImage AS1;
    public static BufferedImage AS2;
    public static BufferedImage AS3;
    //Mango Images
    private BufferedImage MI;
    private BufferedImage[] rMI = new BufferedImage[361];
    public static BufferedImage MS1;
    public static BufferedImage MS2;
    public static BufferedImage MS3;
    //Banana Images
    private BufferedImage BI;
    private BufferedImage[] rBI = new BufferedImage[361];
    public static BufferedImage BS1;
    public static BufferedImage BS2;
    public static BufferedImage BS3;
    //Grape Images
    private BufferedImage GI;
    private BufferedImage[] rGI = new BufferedImage[361];
    public static BufferedImage GS1;
    public static BufferedImage GS2;
    public static BufferedImage GS3;
    //Orange Images
    private BufferedImage OI;
    private BufferedImage[] rOI = new BufferedImage[361];
    public static BufferedImage OS1;
    public static BufferedImage OS2;
    public static BufferedImage OS3;
    //Strawberry Images
    private BufferedImage SI;
    private BufferedImage[] rSI = new BufferedImage[361];
    public static BufferedImage SS1;
    public static BufferedImage SS2;
    public static BufferedImage SS3;
    //Watermelon images
    private BufferedImage WI;
    private BufferedImage[] rWI = new BufferedImage[361];
    public static BufferedImage WS1;
    public static BufferedImage WS2;
    public static BufferedImage WS3;
    //Watermelonseeds Images
    private BufferedImage sWI;
    private BufferedImage[] srWI = new BufferedImage[361];
    public static BufferedImage sWS1;
    public static BufferedImage sWS2;
    public static BufferedImage sWS3;
    //Big Fruit -------
    //Big Apple Image
    private BufferedImage bAI;
    public static BufferedImage bAS1;
    public static BufferedImage bAS2;
    public static BufferedImage bAS3;
    private BufferedImage[] brAI = new BufferedImage[361];
    //Big Mango Images
    private BufferedImage bMI;
    public static BufferedImage bMS1;
    public static BufferedImage bMS2;
    public static BufferedImage bMS3;
    private BufferedImage[] brMI = new BufferedImage[361];
    //Big Banana Images
    private BufferedImage bBI;
    public static BufferedImage bBS1;
    public static BufferedImage bBS2;
    public static BufferedImage bBS3;
    private BufferedImage[] brBI = new BufferedImage[361];
    //Big Grape Images
    private BufferedImage bGI;
    public static BufferedImage bGS1;
    public static BufferedImage bGS2;
    public static BufferedImage bGS3;
    private BufferedImage[] brGI = new BufferedImage[361];
    //Big orange images
    private BufferedImage bOI;
    public static BufferedImage bOS1;
    public static BufferedImage bOS2;
    public static BufferedImage bOS3;
    private BufferedImage[] brOI = new BufferedImage[361];
    //Big StrawBerry Images
    private BufferedImage bSI;
    public static BufferedImage bSS1;
    public static BufferedImage bSS2;
    public static BufferedImage bSS3;
    private BufferedImage[] brSI = new BufferedImage[361];
    //Big Watermelon images
    private BufferedImage bWI;
    public static BufferedImage bWS1;
    public static BufferedImage bWS2;
    public static BufferedImage bWS3;
    private BufferedImage[] brWI = new BufferedImage[361];
    //King Fruit --------
    //King Apple
    private BufferedImage KAI;
    public static BufferedImage AKAI;
    public static BufferedImage KAS1;
    public static BufferedImage KAS2;
    public static BufferedImage KAS3;
    public static BufferedImage AKAS1;
    public static BufferedImage AKAS2;
    //King Mango
    private BufferedImage KMI;
    public static BufferedImage AKMI;
    public static BufferedImage KMS1;
    public static BufferedImage KMS2;
    public static BufferedImage KMS3;
    public static BufferedImage AKMS1;
    public static BufferedImage AKMS2;
    //King Banana
    private BufferedImage KBI;
    public static BufferedImage AKBI;
    public static BufferedImage KBS1;
    public static BufferedImage KBS2;
    public static BufferedImage KBS3;
    public static BufferedImage AKBS1;
    public static BufferedImage AKBS2;
    //King Grape
    private BufferedImage KGI;
    public static BufferedImage AKGI;
    public static BufferedImage KGS1;
    public static BufferedImage KGS2;
    public static BufferedImage KGS3;
    public static BufferedImage AKGS1;
    public static BufferedImage AKGS2;
    //King Orange
    private BufferedImage KOI;
    public static BufferedImage AKOI;
    public static BufferedImage KOS1;
    public static BufferedImage KOS2;
    public static BufferedImage KOS3;
    public static BufferedImage AKOS1;
    public static BufferedImage AKOS2;
    //King Strawberry
    private BufferedImage KSI;
    public static BufferedImage AKSI;
    public static BufferedImage KSS3;
    private BufferedImage SPI;
    public static BufferedImage SPS1;
    public static BufferedImage SPS2;
    public static BufferedImage SPS3;
    //King Watermelon Images
    private BufferedImage KWI;
    public static BufferedImage AKWI;
    public static BufferedImage KWS1;
    public static BufferedImage KWS2;
    public static BufferedImage KWS3;
    public static BufferedImage AKWS1;
    public static BufferedImage AKWS2;
    //Health bar variables
    public static Image[] bar = new Image[201];
    public static ImageIcon[] barI = new ImageIcon[201];
    ImageIcon imgr;
    //Pressboard variables
    public static BufferedImage UpArrowImage;
    public static BufferedImage DownArrowImage;
    public static BufferedImage LeftArrowImage;
    public static BufferedImage RightArrowImage;
    public static ImageIcon UpArrowImageHL;
    public static ImageIcon DownArrowImageHL;
    public static ImageIcon LeftArrowImageHL;
    public static ImageIcon RightArrowImageHL;
    public static ImageIcon LeftArrowImagem;
    public static ImageIcon RightArrowImagem;
    //Pressboard >3 HP Images
    public static ImageIcon HPp;
    public static ImageIcon N0;
    public static ImageIcon N1;
    public static ImageIcon N2;
    public static ImageIcon N3;
    public static ImageIcon N4;
    public static ImageIcon N5;
    public static ImageIcon N6;
    public static ImageIcon N7;
    public static ImageIcon N8;
    public static ImageIcon N9;
    //Menu Images
    public static ImageIcon WAIBABFF;
    public static ImageIcon Start;
    public static ImageIcon Start2;
    public static ImageIcon CSaveData;
    public static ImageIcon LoadScreen;
    public static ImageIcon MainMenuB;
    //Background Images
    public static ImageIcon Stage1B;
    public static ImageIcon Stage1B2;
    public static ImageIcon Stage2B;
    public static ImageIcon Stage2B2;
    public static ImageIcon Stage3B;
    public static ImageIcon Stage3B2;
    public static ImageIcon Stage4B;
    public static ImageIcon Stage4B2;
    public static ImageIcon Stage5B;
    public static ImageIcon Stage5B2;
    public static ImageIcon Stage6B;
    public static ImageIcon Stage6B2;
    public static ImageIcon Stage7B;
    public static ImageIcon Stage7B2;
    public static ImageIcon BlackScreen;
    int mini1x = 100;
    int mini1y = 50;
    int mini2x;
    int mini2y;
    int tempminix;
    int tempminiy;
    public static ImageIcon bmini1;
    public static ImageIcon bmini2;
    public static ImageIcon b1mini;
    public static ImageIcon b2mini;
    public static ImageIcon b3mini;
    public static ImageIcon b4mini;
    public static ImageIcon b5mini;
    public static ImageIcon b6mini;
    public static ImageIcon b7mini;
    public static ImageIcon tutmini;
    public static ImageIcon tempmini;
    public static ImageIcon VictoryP;
    //Cutscene images
    public static ImageIcon SceneImage1;
    public static ImageIcon SceneImage2;
    public static ImageIcon SceneImage3;
    public static ImageIcon SceneImage4;
    public static ImageIcon SceneImage5;
    public static ImageIcon SceneImage6;
    //Loading Screen Determiner
    boolean InitFinished = false;
    //TextHolders
    private ImageIcon TextHolder;
    //Event variables
    public static int WatermelonEvent = 0;
    public static boolean GlobalEvent = false;
    //Variables used for testing purposes
    int test = 0;
    int KillCounter = 0;
    public static ImageIcon Spacer;
    public static boolean ActivateGame = false;
    public static boolean ActivateLS = false;
    boolean AllowToDie = false;
    public static boolean WinRound = false;
    public static int CurrentLevel = 0;
    int LevelSelectAct = 0;
    public static boolean RightLevel = false;
    public static boolean LeftLevel = false;
    public static int TutorialEvent = 0;
    public static boolean StopFruits = false;
    Font FontNormal = new Font("Arial", Font.BOLD, 20);
    Font FontBold = new Font("Arial", Font.BOLD, 30);
    int RequiredFruit = 0;
    //Ultimate picture
    public static ImageIcon[] UltimatePicture = new ImageIcon[30];
    public static boolean ReturnToMenu = false;
    //Fruit Events for boss
    public static int StrawberryEvent = 0;
    public static int OrangeEvent = 0;
    public static int GrapeEvent = 0;
    public static int BananaEvent = 0;
    public static int MangoEvent = 0;
    public static int AppleEvent = 0;
    //Music
    InputStream BattleTheme;
    InputStream MainTheme;
    InputStream BattleTheme2;
    InputStream SadTheme;
    //Conditions
    public static boolean ATest = false;
    public static boolean Defeat = false;
    public static boolean GameOver = false;
    public static boolean Cutscene = false;
    public static int CutSceneAct = 0;
    boolean EnableGame = false;
    //Slice Boss
    ImageIcon Slice1;
    ImageIcon Slice2;
    Double test1 = 0.0;
    Double test2 = 0.0;
    //Summon minions
    public static boolean SummonASeed = false;
    public static boolean SummonAPirate = false;
    public static boolean SummonSpinningApple = false;
    public static boolean SummonSpinningOrange = false;
    public static boolean SummonSwirlingGrape = false;
    public static boolean SummonSwagBanana = false;
    public static boolean SummonSwagApple = false;
    public static int SummonSwirlingAct = 0;
    public static boolean GiantMangoAttack = false;
    public static boolean DontSummonHP = false;
    public static boolean SummonABomb = false;
    public static BufferedImage[] Explosion = new BufferedImage[6];
    public static boolean SummonFire = false;
    public static ImageIcon[] Symbol = new ImageIcon[6];
    //Textholder texts
    ImageIcon TA;
    ImageIcon TA2;
    ImageIcon TA3;
    ImageIcon TM;
    ImageIcon TB;
    ImageIcon TG;
    ImageIcon TO;
    ImageIcon TS;
    ImageIcon TW;
    //Lock picture
    ImageIcon Lock1;
    ImageIcon Lock2;
    public static boolean[] Locked = new boolean[8];
    public static boolean PlayCutscene = true;
    public static boolean MenuToLS = false;
    public static boolean LSToMenu = false;
    //Save data
    public static boolean CSaveDataPrompt = false;
    public static boolean CSaveDataCleared = false;
    boolean BossBattle = false;

    public Game() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);
        long heapsize = Runtime.getRuntime().totalMemory();
        System.out.println("heapsize is::" + heapsize);
        //Sets initial to main menu
        play = true;
        // Cutscene = true;

        //Initializes ninja
        ninja = new Ninja();
        //Initializes Backgrounds
        background = new GameBackground();
        background2 = new GameBackground();
        //Initializes lifeholder
        lifeholder = new LifeHolder();

        //Start thread to repaint stuff on screen
        initThread();

    }

    //Starts the thread
    private void initThread() {
        if (animator == null || play) {
            animator = new Thread(this);
            animator.start();
        }

    }

    //Initialize Game Variables
    private void InitGame() {
        //This is where variables are initialized. It is usually initalized here to avoid in-game loading times from slowing the pace
        //of the game.
        //Loading Screen (Note: Must be put first )
        LoadScreen = new ImageIcon(this.getClass().getResource("Pictures/Other/loading.png"));
        background.setImage(LoadScreen.getImage());
        //Sets divider
        awidth = 974.0 / this.getWidth();
        aheight = 725.0 / this.getHeight();
        //Set inital images menu images
        MainMenuB = new ImageIcon(this.getClass().getResource("Pictures/MainMenuB.png"));
        // Spacer = new ImageIcon(this.getClass().getResource("Pictures/spacer.png"));
        WAIBABFF = new ImageIcon(this.getClass().getResource("Pictures/WAIBABFF.png"));
        Start = new ImageIcon(this.getClass().getResource("Pictures/Start.png"));
        Start2 = new ImageIcon(this.getClass().getResource("Pictures/Start2.png"));
        CSaveData = new ImageIcon(this.getClass().getResource("Pictures/CS.png"));
        //Initialize background
        Stage1B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Background.png"));
        Stage2B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage2.png"));
        Stage3B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage3.png"));
        Stage4B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage4.png"));
        Stage5B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage5.png"));
        Stage6B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage6.png"));
        Stage7B = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage7.png"));
        BlackScreen = new ImageIcon(this.getClass().getResource("Pictures/Stages/black.png"));

        tutmini = new ImageIcon(this.getClass().getResource("Pictures/Stages/tutmini.png"));
        b1mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Background1mini.png"));
        b2mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage2mini.png"));
        b3mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage3mini.png"));
        b4mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage4mini.png"));
        b5mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage5mini.png"));
        b6mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage6mini.png"));
        b7mini = new ImageIcon(this.getClass().getResource("Pictures/Stages/Stage7mini.png"));


        //Load alternate background
        Stage1B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/Background2.png"));
        Stage2B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage2.png"));
        Stage3B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage3.png"));
        Stage4B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage4.png"));
        Stage5B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage5.png"));
        Stage6B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage6.png"));
        Stage7B2 = new ImageIcon(this.getClass().getResource("Pictures/Stages/2Stage7.png"));



        Lock1 = new ImageIcon(this.getClass().getResource("Pictures/Lock.png"));
        Lock2 = new ImageIcon(this.getClass().getResource("Pictures/Lock.png"));
        for (int i = 2; i <= 7; i++) {
            Locked[i] = true;
        }


        //Add buttons to the screen
        buttons.add(new Buttons());

        buttons.get(buttons.size() - 1).setButton("Level Select");
        buttons.get(buttons.size() - 1).setImage(Start2.getImage());
        buttons.get(buttons.size() - 1).setmX(650);
        buttons.get(buttons.size() - 1).setmY(300);
        this.addMouseListener(buttons.get(0));


        buttons.add(new Buttons());
        buttons.get(1).setButton("Clear Data");
        buttons.get(buttons.size() - 1).setmX(850);
        buttons.get(buttons.size() - 1).setmY(600);
        buttons.get(buttons.size() - 1).setImage(CSaveData.getImage());
        this.addMouseListener(buttons.get(buttons.size() - 1));

        //Text bubble
        TextHolder = new ImageIcon(this.getClass().getResource("Pictures/Textholder/Textholder.png"));

        //Initalizes spawn time
        SpawnFruitTime = (int) Math.floor(Math.random() * (50 - 5 + 1) + 5);
        //  NewFruit();

        //Arial

        Slice1 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/Slice1.png"));
        Slice2 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/Slice2.png"));

        //Creates all bufferedImages
        try {
            //Apple Images
            AI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Apples.png"));
            bAI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Applesbig.png"));
            KAI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleBoss.png"));
            AKAI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            //Mango Images
            MI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/mangoes.png"));
            bMI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/mangoesbig.png"));
            KMI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoBoss.png"));
            AKMI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            //Banana Images
            BI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/bananas.png"));
            bBI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/bananasbig.png"));
            KBI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaBoss.png"));
            AKBI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            //Grape Images
            GI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/grapess.png"));
            bGI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/grapessbig.png"));
            KGI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeCute.png"));
            AKGI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            //Orange Images
            OI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/oranges.png"));
            bOI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/orangesbig.png"));
            KOI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeBoss.png"));
            AKOI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            //Strawbberry Images
            SI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/strawberries.png"));
            bSI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/strawberriesbig.png"));
            KSI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingStrawberry.png"));
            AKSI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));
            SPI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Pirate.png"));
            //Watermelon Images
            WI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/watermelons.png"));
            sWI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
            bWI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/watermelonsbig.png"));
            KWI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
            AKWI = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttack.png"));

            HPp2 = ImageIO.read(this.getClass().getResource("Pictures/Numbers/HP.png"));
            //Creates an image for every degree (to reduce in-game lag)
            for (int i = 0; i < 360; i++) {
                //Apple Rotation Images
                double ArotationRequired = Math.toRadians(-i);
                double AlocationX = AI.getWidth() / 2;
                double AlocationY = AI.getHeight() / 2;
                AffineTransform Atx = AffineTransform.getRotateInstance(ArotationRequired, AlocationX, AlocationY);
                AffineTransformOp Aop = new AffineTransformOp(Atx, AffineTransformOp.TYPE_BILINEAR);
                rAI[i] = Aop.filter(AI, null);
                //Big Apple Rotation Images
                double bArotationRequired = Math.toRadians(-i);
                double bAlocationX = bAI.getWidth() / 2;
                double bAlocationY = bAI.getHeight() / 2;
                AffineTransform bAtx = AffineTransform.getRotateInstance(bArotationRequired, bAlocationX, bAlocationY);
                AffineTransformOp bAop = new AffineTransformOp(bAtx, AffineTransformOp.TYPE_BILINEAR);
                brAI[i] = bAop.filter(bAI, null);

                //Mango Rotation Images
                double MrotationRequired = Math.toRadians(-i);
                double MlocationX = MI.getWidth() / 2;
                double MlocationY = MI.getHeight() / 2;
                AffineTransform Mtx = AffineTransform.getRotateInstance(MrotationRequired, MlocationX, MlocationY);
                AffineTransformOp Mop = new AffineTransformOp(Mtx, AffineTransformOp.TYPE_BILINEAR);
                rMI[i] = Mop.filter(MI, null);

                //Big Mango Rotation Images
                double bMrotationRequired = Math.toRadians(-i);
                double bMlocationX = bMI.getWidth() / 2;
                double bMlocationY = bMI.getHeight() / 2;
                AffineTransform bMtx = AffineTransform.getRotateInstance(bMrotationRequired, bMlocationX, bMlocationY);
                AffineTransformOp bMop = new AffineTransformOp(bMtx, AffineTransformOp.TYPE_BILINEAR);
                brMI[i] = bMop.filter(bMI, null);

                //Banana Rotation Images
                double BrotationRequired = Math.toRadians(-i);
                double BlocationX = BI.getWidth() / 2;
                double BlocationY = BI.getHeight() / 2;
                AffineTransform Btx = AffineTransform.getRotateInstance(BrotationRequired, BlocationX, BlocationY);
                AffineTransformOp Bop = new AffineTransformOp(Btx, AffineTransformOp.TYPE_BILINEAR);
                rBI[i] = Bop.filter(BI, null);

                //Big Banana Rotation Images
                double bBrotationRequired = Math.toRadians(-i);
                double bBlocationX = bBI.getWidth() / 2;
                double bBlocationY = bBI.getHeight() / 2;
                AffineTransform bBtx = AffineTransform.getRotateInstance(bBrotationRequired, bBlocationX, bBlocationY);
                AffineTransformOp bBop = new AffineTransformOp(bBtx, AffineTransformOp.TYPE_BILINEAR);
                brBI[i] = bBop.filter(bBI, null);

                //Grape Rotation Images
                double GrotationRequired = Math.toRadians(-i);
                double GlocationX = GI.getWidth() / 2;
                double GlocationY = GI.getHeight() / 2;
                AffineTransform Gtx = AffineTransform.getRotateInstance(GrotationRequired, GlocationX, GlocationY);
                AffineTransformOp Gop = new AffineTransformOp(Gtx, AffineTransformOp.TYPE_BILINEAR);
                rGI[i] = Gop.filter(GI, null);

                //Big Grape Rotation Images
                double bGrotationRequired = Math.toRadians(-i);
                double bGlocationX = bGI.getWidth() / 2;
                double bGlocationY = bGI.getHeight() / 2;
                AffineTransform bGtx = AffineTransform.getRotateInstance(bGrotationRequired, bGlocationX, bGlocationY);
                AffineTransformOp bGop = new AffineTransformOp(bGtx, AffineTransformOp.TYPE_BILINEAR);
                brGI[i] = bGop.filter(bGI, null);

                //Orange Rotation Images
                double OrotationRequired = Math.toRadians(-i);
                double OlocationX = OI.getWidth() / 2;
                double OlocationY = OI.getHeight() / 2;
                AffineTransform Otx = AffineTransform.getRotateInstance(OrotationRequired, OlocationX, OlocationY);
                AffineTransformOp Oop = new AffineTransformOp(Otx, AffineTransformOp.TYPE_BILINEAR);
                rOI[i] = Oop.filter(OI, null);
                //Big Orange Rotation Images
                double bOrotationRequired = Math.toRadians(-i);
                double bOlocationX = bOI.getWidth() / 2;
                double bOlocationY = bOI.getHeight() / 2;
                AffineTransform bOtx = AffineTransform.getRotateInstance(bOrotationRequired, bOlocationX, bOlocationY);
                AffineTransformOp bOop = new AffineTransformOp(bOtx, AffineTransformOp.TYPE_BILINEAR);
                brOI[i] = bOop.filter(bOI, null);
                //Strawberry Rotation Images
                double SrotationRequired = Math.toRadians(-i);
                double SlocationX = SI.getWidth() / 2;
                double SlocationY = SI.getHeight() / 2;
                AffineTransform Stx = AffineTransform.getRotateInstance(SrotationRequired, SlocationX, SlocationY);
                AffineTransformOp Sop = new AffineTransformOp(Stx, AffineTransformOp.TYPE_BILINEAR);
                rSI[i] = Sop.filter(SI, null);
                //Big Strawberry Rotation Images
                double bSrotationRequired = Math.toRadians(-i);
                double bSlocationX = bSI.getWidth() / 2;
                double bSlocationY = bSI.getHeight() / 2;
                AffineTransform bStx = AffineTransform.getRotateInstance(bSrotationRequired, bSlocationX, bSlocationY);
                AffineTransformOp bSop = new AffineTransformOp(bStx, AffineTransformOp.TYPE_BILINEAR);
                brSI[i] = bSop.filter(bSI, null);
                //Watermelon Rotation Images
                double WrotationRequired = Math.toRadians(-i);
                double WlocationX = WI.getWidth() / 2;
                double WlocationY = WI.getHeight() / 2;
                AffineTransform Wtx = AffineTransform.getRotateInstance(WrotationRequired, WlocationX, WlocationY);
                AffineTransformOp Wop = new AffineTransformOp(Wtx, AffineTransformOp.TYPE_BILINEAR);
                rWI[i] = Wop.filter(WI, null);

                //Watermelon seed Rotation Images
                double sWrotationRequired = Math.toRadians(-i);
                double sWlocationX = sWI.getWidth() / 2;
                double sWlocationY = sWI.getHeight() / 2;
                AffineTransform sWtx = AffineTransform.getRotateInstance(sWrotationRequired, sWlocationX, sWlocationY);
                AffineTransformOp sWop = new AffineTransformOp(sWtx, AffineTransformOp.TYPE_BILINEAR);
                srWI[i] = sWop.filter(sWI, null);

                //Big Watermelon Rotation Images
                double bWrotationRequired = Math.toRadians(-i);
                double bWlocationX = bWI.getWidth() / 2;
                double bWlocationY = bWI.getHeight() / 2;
                AffineTransform bWtx = AffineTransform.getRotateInstance(bWrotationRequired, bWlocationX, bWlocationY);
                AffineTransformOp bWop = new AffineTransformOp(bWtx, AffineTransformOp.TYPE_BILINEAR);
                brWI[i] = bWop.filter(bWI, null);

            }

            //Initalize Slicing images (to reduce in-game lag)
            //Apple Slice
            AS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice1.png"));
            AS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice2.png"));
            AS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice3.png"));
            bAS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice1big.png"));
            bAS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice2big.png"));
            bAS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleSlice3big.png"));
            KAS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KAS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KAS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingAppleSlice3.png"));
            AKAS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKAS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));

            //Mango Slice
            MS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice1.png"));
            MS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice2.png"));
            MS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice3.png"));
            bMS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice1big.png"));
            bMS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice2big.png"));
            bMS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoSlice3big.png"));
            KMS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KMS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KMS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingMangoSlice3.png"));
            AKMS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKMS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));

            //Banana Slice
            BS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice1.png"));
            BS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice2.png"));
            BS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice3.png"));
            bBS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice1big.png"));
            bBS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice2big.png"));
            bBS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaSlice3big.png"));
            KBS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KBS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KBS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingBananaSlice3.png"));
            AKBS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKBS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));


            //Grape Slice
            GS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice1.png"));
            GS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice2.png"));
            GS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice3.png"));
            bGS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice1big.png"));
            bGS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice2big.png"));
            bGS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeSlice3big.png"));
            KGS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KGS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KGS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingGrapeSlice3.png"));
            AKGS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKGS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));

            //Orange Slice
            OS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice1.png"));
            OS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice2.png"));
            OS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice3.png"));
            bOS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice1big.png"));
            bOS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice2big.png"));
            bOS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeSlice3big.png"));
            KOS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KOS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KOS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingOrangeSlice3.png"));
            AKOS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKOS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));

            //Strawberry Slice
            SS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice1.png"));
            SS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice2.png"));
            SS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice3.png"));
            bSS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice1big.png"));
            bSS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice2big.png"));
            bSS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberrySlice3big.png"));

            KSS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/StrawberryBossSlice3.png"));


            SPS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/PirateSlice1.png"));
            SPS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/PirateSlice2.png"));
            SPS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/PirateSlice3.png"));

            //Watermelon SLice
            WS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice1.png"));
            WS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice2.png"));
            WS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice3.png"));
            sWS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
            sWS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
            sWS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
            bWS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice1big.png"));
            bWS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice2big.png"));
            bWS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WatermelonSlice3big.png"));
            KWS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice1.png"));
            KWS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice2.png"));
            KWS3 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonSlice3.png"));
            AKWS1 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice1.png"));
            AKWS2 = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelonAttackSlice2.png"));

            HPS1 = ImageIO.read(this.getClass().getResource("Pictures/Numbers/HP.png"));
            HPS2 = ImageIO.read(this.getClass().getResource("Pictures/Numbers/HP.png"));
            HPS3 = ImageIO.read(this.getClass().getResource("Pictures/Numbers/HP.png"));

            //Pressboard Images
            UpArrowImage = ImageIO.read(this.getClass().getResource("Pictures/Pressboard/UpArrow.png"));
            DownArrowImage = ImageIO.read(this.getClass().getResource("Pictures/Pressboard/DownArrow.png"));
            LeftArrowImage = ImageIO.read(this.getClass().getResource("Pictures/Pressboard/LeftArrow.png"));
            RightArrowImage = ImageIO.read(this.getClass().getResource("Pictures/Pressboard/RightArrow.png"));

            Explosion[0] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp1.png"));
            Explosion[1] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp2.png"));
            Explosion[2] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp3.png"));
            Explosion[3] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp4.png"));
            Explosion[4] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp5.png"));
            Explosion[5] = ImageIO.read(this.getClass().getResource("Pictures/Other/Exp6.png"));


        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpArrowImageHL = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/UpArrowHL.png"));
        DownArrowImageHL = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/DownArrowHL.png"));
        LeftArrowImageHL = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrowHL.png"));
        RightArrowImageHL = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrowHL.png"));

        LeftArrowImagem = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrow.png"));
        RightArrowImagem = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrow.png"));


        HPp = new ImageIcon(this.getClass().getResource("Pictures/Numbers/HP.png"));
        N0 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/0.png"));
        N1 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/1.png"));
        N2 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/2.png"));
        N3 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/3.png"));
        N4 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/4.png"));
        N5 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/5.png"));
        N6 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/6.png"));
        N7 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/7.png"));
        N8 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/8.png"));
        N9 = new ImageIcon(this.getClass().getResource("Pictures/Numbers/9.png"));

        Symbol[0] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol1.png"));
        Symbol[1] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol2.png"));
        Symbol[2] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol3.png"));
        Symbol[3] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol4.png"));
        Symbol[4] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol5.png"));
        Symbol[5] = new ImageIcon(this.getClass().getResource("Pictures/Other/Symbol6.png"));




        for (int i = 0; i < NumberofFruit; i++) {
            // DieTimer.add(0);

            //Initalize Starting Fruit Food
            //Sets fruit accordingly
            // 1 = A = Apple
            // 2 = M = Mango
            // 3 = B = Banana
            // 4 = G = Grapes
            // 5 = O = Orange
            // 6 = S = Strawberry
            // 7 = W = Watermelon
            // +b at start = Big fruit
            switch (fruit.get(i).getFood()) {
                case 1:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, AI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bAI);
                        }
                    }
                    break;
                case 2:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, MI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bMI);
                        }
                    }
                    break;
                case 3:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, BI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bBI);
                        }
                    }
                    break;
                case 4:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, GI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bGI);
                        }
                    }
                    break;
                case 5:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, OI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bOI);
                        }
                    }
                    break;
                case 6:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, SI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bSI);
                        }
                    }
                    break;
                case 16:

                    FruitImage.set(i, SPI);
                    break;

                case 7:
                    if (fruit.get(i).getAbnormal() == false) {
                        FruitImage.set(i, WI);
                    } else {
                        if (fruit.get(i).getBig() == true) {
                            FruitImage.set(i, bWI);
                        }
                    }

                    break;
                case 17:

                    FruitImage.set(i, sWI);
                    break;
                case 30:

                    FruitImage.set(i, HPp2);
                    break;
            }

        }

        //Health bar initializations
        for (int i = 0; i < 201; i++) {
            try {
                bar[i] = ImageIO.read(this.getClass().getResource("Pictures/Ninja/green.jpg"));
                bar[i] = bar[i].getScaledInstance((int) (i * 1.95), 35, Image.SCALE_SMOOTH);
                barI[i] = new ImageIcon(bar[i]);

            } catch (Exception e) {
            }

        }
        //Ultimate picture Initializations
        UltimatePicture[1] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U1.png"));
        UltimatePicture[2] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U2.png"));
        UltimatePicture[3] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U3.png"));
        UltimatePicture[4] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U4.png"));
        UltimatePicture[5] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U5.png"));
        UltimatePicture[6] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U6.png"));
        UltimatePicture[7] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U7.png"));
        UltimatePicture[8] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U8.png"));
        UltimatePicture[9] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U9.png"));
        UltimatePicture[10] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U10.png"));
        UltimatePicture[11] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U11.png"));
        UltimatePicture[12] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U12.png"));
        UltimatePicture[13] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U13.png"));
        UltimatePicture[14] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U14.png"));
        UltimatePicture[15] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U15.png"));
        UltimatePicture[16] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U16.png"));
        UltimatePicture[17] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U17.png"));
        UltimatePicture[18] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U18.png"));
        UltimatePicture[19] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U19.png"));
        UltimatePicture[20] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U20.png"));
        UltimatePicture[21] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U21.png"));
        UltimatePicture[22] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U22.png"));
        UltimatePicture[23] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U23.png"));
        UltimatePicture[24] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U24.png"));
        UltimatePicture[25] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U25.png"));
        UltimatePicture[26] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U26.png"));
        UltimatePicture[27] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U27.png"));
        UltimatePicture[28] = new ImageIcon(this.getClass().getResource("Pictures/Ultimate/U28.png"));

        VictoryP = new ImageIcon(this.getClass().getResource("Pictures/Victory.png"));

        SceneImage1 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS1.png"));
        SceneImage2 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS2.png"));
        SceneImage3 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS3.png"));
        SceneImage4 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS4.png"));
        SceneImage5 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS5.png"));
        SceneImage6 = new ImageIcon(this.getClass().getResource("Pictures/Cutscene/CS6.png"));


        //Make sure the screen ration is correct
        awidth = 974.0 / this.getWidth();
        aheight = 725.0 / this.getHeight();

        TA = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TA1.png"));
        TA2 = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TA2.png"));
        TA3 = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TA3.png"));
        TM = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TM.png"));
        TB = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TB.png"));
        TG = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TG.png"));
        TO = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TO.png"));
        TS = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TS.png"));
        TW = new ImageIcon(this.getClass().getResource("Pictures/Textholder/TW.png"));



        background2.setImage(Stage1B2.getImage());
        background2.setX(1024);
        background2.setY(background.getY());
        LoadFile();

        //Remove loading screen
        InitFinished = true;

        //Sets Main Menu Background
        //    background.setImage(MainMenuB.getImage());
        background.setImage(MainMenuB.getImage());
        //Starts the game loop WOOO!!
        GameLoop();

    }

    public void animationCycle() {
        // This is where all (most) of the movement happens.
        if (GameOver == true || Cutscene == true) {
            try {
                if (SadTheme.available() == 0) {
                    SadTheme();
                }
            } catch (Exception e) {
            }
        }
        if (levelselect == true || mmenu == true || Cutscene == true) {
            try {
                if (MainTheme.available() == 0) {
                    MainTheme();
                }
            } catch (Exception e) {
            }
        }

        if (Cutscene == true) {

            if (CutSceneAct == 1) {
                CutSceneAct++;
                background.setImage(SceneImage1.getImage());

            }
            if (CutSceneAct == 3) {
                background.setImage(SceneImage2.getImage());
                CutSceneAct++;
            }
            if (CutSceneAct == 5) {
                background.setImage(SceneImage3.getImage());
                CutSceneAct++;
            }
            if (CutSceneAct == 7) {
                background.setImage(SceneImage4.getImage());
                CutSceneAct++;
            }
            if (CutSceneAct == 9) {
                background.setImage(SceneImage5.getImage());
                CutSceneAct++;
            }
            if (CutSceneAct == 11) {
                background.setImage(SceneImage6.getImage());
                CutSceneAct++;
            }
            if (CutSceneAct == 13) {

                // CutSceneAct ++;
                background.setImage(MainMenuB.getImage());
                Cutscene = false;
                mmenu = true;
                if (Mute == false) {
                    try {
                        SadTheme.close();

                    } catch (Exception e) {
                    }
                    MainTheme();
                }
            }


        }

        if (ReturnToMenu == true) {
            // CurrentLevel = 0;
            try {
                BattleTheme.close();

            } catch (Exception e) {
            }
            try {
                BattleTheme2.close();

            } catch (Exception e) {
            }
            try {
                SadTheme.close();

            } catch (Exception e) {
            }
            if (Mute == false) {
                MainTheme();
            }

            while (fruit.size() > 0) {
                //Remove the dead fruit - Everything! :(

                FruitRotation.remove(0);
                rotationRequired.remove(0);
                locationX.remove(0);
                locationY.remove(0);
                tx.remove(0);
                op.remove(0);
                FruitImage.remove(0);
                fruit.remove(0);

                DieTimer.set(0, 0);
                DieTimer.remove(0);

            }

            ninja.setSymbolTimer(0);
            BossBattle = false;
            ninja.setSlash(false);
            ninja.setSlashF(0);
            ninja.setImage(ninja.getNinjaPic().getImage());
            ninja.setX(80);
            ninja.setY(380);
            if (CurrentLevel != 7 && Locked[CurrentLevel + 1] == false) {
                RightLevel = true;
            }
            SaveFile();


            SummonAPirate = false;
            SummonSpinningOrange = false;
            SummonSwirlingGrape = false;
            SummonSwagBanana = false;
            SummonSwagApple = false;


            TutorialEvent = -2;
            WatermelonEvent = -2;
            StrawberryEvent = -2;
            OrangeEvent = -2;
            GrapeEvent = -2;
            BananaEvent = -2;
            MangoEvent = -2;
            AppleEvent = -2;

            Game.lifeholder.setHealth(200);

            SpawnedFruitNumber = 0;
            GlobalEvent = false;
            ingame = false;
            NumberofFruit = 0;

            StopFruits = false;
            SummonASeed = false;
            RequiredFruit = 0;
            KillCounter = 0;
            ActivateLS = true;
            WinRound = false;
            ReturnToMenu = false;
            LevelSelectAct = 0;


        }

        if (ActivateGame == true) {

            try {
                MainTheme.close();
            } catch (Exception e) {
            }
            if (Mute == false) {
                BattleTheme2();
            }

            if (CurrentLevel == 0 || CurrentLevel == 1) {
                background.setImage(Game.Stage1B.getImage());
            } else if (CurrentLevel == 2) {
                background.setImage(Game.Stage2B.getImage());
            } else if (CurrentLevel == 3) {
                background.setImage(Game.Stage3B.getImage());
            } else if (CurrentLevel == 4) {
                background.setImage(Game.Stage4B.getImage());
            } else if (CurrentLevel == 5) {
                background.setImage(Game.Stage5B.getImage());
            } else if (CurrentLevel == 6) {
                background.setImage(Game.Stage6B.getImage());
            } else if (CurrentLevel == 7) {
                background.setImage(Game.Stage7B.getImage());
            }


            if (CurrentLevel == 1) {
                RequiredFruit = 15;
                TutorialEvent = -2;
            } else if (CurrentLevel == 2) {
                RequiredFruit = 20;
                TutorialEvent = -2;
            } else if (CurrentLevel == 3) {
                RequiredFruit = 25;
                TutorialEvent = -2;
            } else if (CurrentLevel == 4) {
                RequiredFruit = 30;
                TutorialEvent = -2;
            } else if (CurrentLevel == 5) {
                RequiredFruit = 35;
                TutorialEvent = -2;
            } else if (CurrentLevel == 6) {
                RequiredFruit = 40;
                TutorialEvent = -2;
            } else if (CurrentLevel == 7) {
                RequiredFruit = 45;
                TutorialEvent = -2;
            }
            //      RequiredFruit = 1;


            mmenu = false;
            ingame = true;
            levelselect = false;
            ActivateGame = false;

            Game.buttons.remove(0);
            Game.buttons.remove(0);
            Game.buttons.remove(0);
            this.addMouseListener(buttons.get(0));
            this.addMouseListener(buttons.get(0));
            this.addMouseListener(buttons.get(0));
        }
        //Activater
        if (MenuToLS == true) {
            for (int i = 0; i < buttons.size(); i++) {

                Game.buttons.remove(i);
                this.removeMouseListener(buttons.get(i));

            }
            MenuToLS = false;
            ActivateLS = true;

        }
        if (LSToMenu) {
            levelselect = false;
            background.setImage(MainMenuB.getImage());

            //Add buttons to the screen
            for (int i = 0; i < buttons.size(); i++) {

                Game.buttons.remove(i);
                this.removeMouseListener(buttons.get(i));

            }

            buttons.add(new Buttons());
            //   buttons.get(buttons.size() - 1).setButton("Start Game");
            buttons.get(buttons.size() - 1).setButton("Level Select");
            buttons.get(buttons.size() - 1).setImage(Start2.getImage());
            buttons.get(buttons.size() - 1).setmX(650);
            buttons.get(buttons.size() - 1).setmY(300);

            this.addMouseListener(buttons.get(0));

            buttons.add(new Buttons());
            buttons.get(1).setButton("Clear Data");
            buttons.get(buttons.size() - 1).setmX(850);
            buttons.get(buttons.size() - 1).setmY(600);
            buttons.get(buttons.size() - 1).setImage(CSaveData.getImage());
            this.addMouseListener(buttons.get(buttons.size() - 1));

            LSToMenu = false;

            mmenu = true;
        }
        if (ActivateLS == true) {




            background.setImage(BlackScreen.getImage());
            mmenu = false;
            levelselect = true;


            mini1x = 100;
            mini1y = 50;
            mini2x = 1030;
            mini2y = 50;
            if (CurrentLevel == 0) {
                bmini1 = tutmini;
                bmini2 = b1mini;
            }
            if (CurrentLevel == 1) {
                bmini1 = b1mini;
                bmini2 = b2mini;
            }
            if (CurrentLevel == 2) {
                bmini1 = b2mini;
                bmini2 = b3mini;
            }
            if (CurrentLevel == 3) {
                bmini1 = b3mini;
                bmini2 = b4mini;
            }
            if (CurrentLevel == 4) {
                bmini1 = b4mini;
                bmini2 = b5mini;
            }
            if (CurrentLevel == 5) {
                bmini1 = b5mini;
                bmini2 = b6mini;
            }
            if (CurrentLevel == 6) {
                bmini1 = b6mini;
                bmini2 = b7mini;
            }
            if (CurrentLevel == 7) {
                bmini1 = b7mini;
                bmini2 = tutmini;

            }
            if (CurrentLevel == 8) {
                CurrentLevel = 0;
            }

            //Add buttons to the screen
            buttons.add(new Buttons());
            //   buttons.get(buttons.size() - 1).setButton("Start Game");

            buttons.get(buttons.size() - 1).setImage(Start.getImage());
            buttons.get(buttons.size() - 1).setmX(400);
            buttons.get(buttons.size() - 1).setmY(550);
            buttons.get(buttons.size() - 1).setButton("Start Game");
            this.addMouseListener(buttons.get(buttons.size() - 1));
            buttons.add(new Buttons());
            //   buttons.get(buttons.size() - 1).setButton("Start Game");

            buttons.get(buttons.size() - 1).setImage(RightArrowImagem.getImage());
            buttons.get(buttons.size() - 1).setmX(900);
            buttons.get(buttons.size() - 1).setmY(620);
            buttons.get(buttons.size() - 1).setButton("Right Level");
            this.addMouseListener(buttons.get(buttons.size() - 1));

            buttons.add(new Buttons());
            buttons.get(buttons.size() - 1).setImage(LeftArrowImagem.getImage());
            buttons.get(buttons.size() - 1).setmX(40);
            buttons.get(buttons.size() - 1).setmY(620);
            buttons.get(buttons.size() - 1).setButton("Left Level");
            this.addMouseListener(buttons.get(buttons.size() - 1));

            ActivateLS = false;

        }
        //Level select screen
        if (levelselect) {
            if (RightLevel) {
                CurrentLevel++;

                LevelSelectAct = 1;
                mini1x = 100;
                mini1y = 50;
                mini2x = 1030;
                mini2y = 50;

                RightLevel = false;
                //Display levels
                if (CurrentLevel == 1) {
                    bmini1 = tutmini;
                    bmini2 = b1mini;
                } else if (CurrentLevel == 2) {
                    bmini1 = b1mini;
                    bmini2 = b2mini;
                } else if (CurrentLevel == 3) {
                    bmini1 = b2mini;
                    bmini2 = b3mini;
                } else if (CurrentLevel == 4) {
                    bmini1 = b3mini;
                    bmini2 = b4mini;
                } else if (CurrentLevel == 5) {
                    bmini1 = b4mini;
                    bmini2 = b5mini;
                } else if (CurrentLevel == 6) {
                    bmini1 = b5mini;
                    bmini2 = b6mini;
                } else if (CurrentLevel == 7) {
                    bmini1 = b6mini;
                    bmini2 = b7mini;
                } else if (CurrentLevel == 8) {
                    bmini1 = b7mini;
                    bmini2 = tutmini;
                    CurrentLevel = 0;
                }

            }
            //Switch the two pictures
            if (LevelSelectAct == 1) {
                if (mini2x > 100) {
                    mini1x -= 50;
                    if (mini2x - 50 < 100) {
                        mini2x = 100;
                        tempmini = bmini1;
                        bmini1 = bmini2;
                        bmini2 = tempmini;

                        tempminix = mini1x;
                        mini1x = mini2x;
                        mini2x = tempminix;

                        tempminiy = mini1y;
                        mini1y = mini2y;
                        mini2y = tempminiy;
                        LevelSelectAct = 0;

                    } else {
                        mini2x -= 50;
                    }

                }


            }


            //Move screen left
            if (LeftLevel) {
                CurrentLevel--;
                LevelSelectAct = -1;
                mini1x = 100;
                mini1y = 50;
                mini2x = -1030;
                mini2y = 50;

                LeftLevel = false;

                if (CurrentLevel == -1) {
                    bmini1 = tutmini;
                    bmini2 = b7mini;
                    CurrentLevel = 7;
                } else if (CurrentLevel == 0) {
                    bmini1 = b1mini;
                    bmini2 = tutmini;
                } else if (CurrentLevel == 1) {
                    bmini1 = b2mini;
                    bmini2 = b1mini;
                } else if (CurrentLevel == 2) {
                    bmini1 = b3mini;
                    bmini2 = b2mini;
                } else if (CurrentLevel == 3) {
                    bmini1 = b4mini;
                    bmini2 = b3mini;
                } else if (CurrentLevel == 4) {
                    bmini1 = b5mini;
                    bmini2 = b4mini;
                } else if (CurrentLevel == 5) {
                    bmini1 = b6mini;
                    bmini2 = b5mini;
                } else if (CurrentLevel == 6) {
                    bmini1 = b7mini;
                    bmini2 = b6mini;
                } else if (CurrentLevel == 7) {
                    bmini1 = b7mini;
                    bmini2 = tutmini;

                }


            }
            //Switch the two pictures
            if (LevelSelectAct == -1) {
                if (mini2x < 100) {
                    mini1x += 50;
                    if (mini2x + 50 > 100) {
                        mini2x = 100;
                        tempmini = bmini1;
                        bmini1 = bmini2;
                        bmini2 = tempmini;

                        tempminix = mini1x;
                        mini1x = mini2x;
                        mini2x = tempminix;

                        tempminiy = mini1y;
                        mini1y = mini2y;
                        mini2y = tempminiy;
                        LevelSelectAct = 0;

                    } else {
                        mini2x += 50;
                    }
                }
            }
        }

        //Defeat screen
        if (Defeat == true) {
            Defeat = false;
            ninja.setY(-200);
            ninja.setX(380);
            GameOver = true;
            ingame = false;
            //Play sad music
            try {
                BattleTheme.close();
            } catch (Exception e) {
            }
            try {
                BattleTheme2.close();
            } catch (Exception e) {
            }
            SadTheme();

        }
        if (GameOver) {
            ninja.act();
        }
        //Ingame music repeat
        if (ingame) {
            try {
                if (WatermelonEvent != -1 && StrawberryEvent != -1 && OrangeEvent != -1 && GrapeEvent != -1 && BananaEvent != -1 && MangoEvent != -1 && AppleEvent != -1) {

                    if (BattleTheme2.available() == 0) {
                        if (Mute == false) {
                            BattleTheme2.close();
                            BattleTheme2();
                        }
                    }
                } else {
                    if (BattleTheme.available() == 0) {
                        if (Mute == false) {
                            BattleTheme.close();
                            BattleTheme();
                        }
                    }
                }
            } catch (Exception e) {
            }


            //Ninja movement
            ninja.act();

            //Life bar movement
            lifeholder.act();
            //Fruit Movement
            for (int i = 0; i < NumberofFruit; i++) {

                fruit.get(i).act();
            }

            //TutorialEvents - guides the tutorial
            //Inital fruit
            if (TutorialEvent == 1) {
                NewFruit();
                fruit.get(0).setfdX(20);
                fruit.get(0).setY(300);
                fruit.get(0).setFirstSequence(1);
                TutorialEvent++;
                GlobalEvent = true;
            }
            //Initial combat
            if (TutorialEvent == 4) {
                if (fruit.isEmpty()) {
                    TutorialEvent++;
                }
            }

            if (TutorialEvent == 5) {
                NewFruit();

                fruit.get(0).setfdX(20);
                fruit.get(0).setY(300);
                fruit.get(0).setFirstSequence(1);
                TutorialEvent++;

            }

            if (TutorialEvent == 6) {
                if (fruit.get(0).getX() < 700) {
                    StopFruits = true;
                    TutorialEvent++;
                }
            }
            if (TutorialEvent == 7) {
            }

            if (TutorialEvent == 8) {
                NewFruit();
                fruit.get(0).setfdX(20);
                fruit.get(0).setY(300);
                TutorialEvent++;
            }
            if (TutorialEvent == 9) {
                if (fruit.get(0).getX() < 700) {
                    StopFruits = true;
                    TutorialEvent++;
                }
            }
            //Guidelines
            if (TutorialEvent == 11) {
                NewFruit();
                NewFruit();
                NewFruit();
                fruit.get(0).setfdX(20);
                fruit.get(0).setY(300);
                fruit.get(0).setFirstSequence(1);
                fruit.get(1).setfdX(20);
                fruit.get(1).setX(fruit.get(0).getX() + 200);
                fruit.get(1).setY(200);
                fruit.get(1).setFirstSequence(1);
                fruit.get(2).setX(fruit.get(0).getX() + 100);
                fruit.get(2).setY(400);
                fruit.get(2).setfdX(20);
                fruit.get(2).setFirstSequence(2);

                TutorialEvent++;
            }

            if (TutorialEvent == 12) {
                if (fruit.get(0).getX() < 650) {
                    StopFruits = true;
                    TutorialEvent++;
                }
            }
            //Ultimate Tutorial
            if (TutorialEvent == 14) {
                if (NumberofFruit < 20) {
                    NewFruit();
                } else {
                    TutorialEvent++;
                }

            }
            if (TutorialEvent == 15) {
                for (int i = 0; i < NumberofFruit; i++) {
                    if (fruit.get(i).getX() < 675) {

                        StopFruits = true;
                        TutorialEvent++;
                        break;
                    }
                }

            }

            //Watermelon King Event!
            //Act 1: Move screen to the right and show King Watermelon
            if (WatermelonEvent == 1) {

                background2.setImage(Stage1B2.getImage());
                TextHolder.setImage(TW.getImage());
                //Summons the almighty Watermelon King
                if (NumberofFruit == 0) {

                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(7);

                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();

                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    WatermelonEvent = 2;
                }

            }
            //Act 2: Move back left to battle the Watermelon King!
            if (WatermelonEvent == 3) {
                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Watermelon King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }

                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event

                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);

                    GlobalEvent = false;
                    WatermelonEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                }
            }

            //STrawberry
            if (StrawberryEvent == 1) {
                background2.setImage(Stage2B2.getImage());
                TextHolder.setImage(TS.getImage());
                //Summons the almighty Strawberry King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(6);

                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();
                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    StrawberryEvent = 2;
                }

            }
            //Act 2: Move back left to battle the Strawberry King!
            if (StrawberryEvent == 3) {
                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Strawberry King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);


                    GlobalEvent = false;
                    StrawberryEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                }
            }
            //Orange
            if (OrangeEvent == 1) {
                background2.setImage(Stage3B2.getImage());
                TextHolder.setImage(TO.getImage());
                //Summons the almighty Orange King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(5);

                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();
                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    OrangeEvent = 2;
                }

            }
            //Act 2: Move back left to battle the Orange King!
            if (OrangeEvent == 3) {

                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Orange King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);

                    OrangeEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                    GlobalEvent = false;
                }
            }
            //Grape
            if (GrapeEvent == 1) {
                background2.setImage(Stage4B2.getImage());
                TextHolder.setImage(TG.getImage());
                //Summons the almighty Grape King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(4);
                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();

                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    GrapeEvent = 2;
                }

            }
            //Act 2: Move back left to battle the grape King!
            if (GrapeEvent == 3) {

                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Grape King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);

                    GlobalEvent = false;
                    GrapeEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                }
            }
            //Banana
            if (BananaEvent == 1) {
                background2.setImage(Stage5B2.getImage());
                TextHolder.setImage(TB.getImage());
                //Summons the almighty banana King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(3);
                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();

                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {
                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    BananaEvent = 2;
                }

            }
            //Act 2: Move back left to battle the Banana King!
            if (BananaEvent == 3) {
                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Banana King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);


                    GlobalEvent = false;
                    BananaEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                }
            }
            //Mango
            if (MangoEvent == 1) {
                background2.setImage(Stage6B2.getImage());
                TextHolder.setImage(TM.getImage());
                //Summons the almighty Mango King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1800);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(2);

                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();

                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    MangoEvent = 2;
                }

            }
            //Act 2: Move back left to battle the Mango King!
            if (MangoEvent == 3) {
                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Mango King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);

                    GlobalEvent = false;
                    MangoEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);

                }
            }
            //Apple <3
            if (AppleEvent == 1) {
                background2.setImage(Stage7B2.getImage());
                TextHolder.setImage(TA.getImage());
                //Summons the almighty Apple King
                if (NumberofFruit == 0) {
                    SpawnFruitTimer = 0;
                    NewFruit();
                    fruit.get(0).setfdX(0);
                    fruit.get(0).setY(250);
                    fruit.get(0).setX(1600);

                    fruit.get(0).setAbnormal(true);
                    fruit.get(0).setHeroic(true);
                    fruit.get(0).setFood(1);

                    try {
                        BattleTheme2.close();
                    } catch (Exception e) {
                    }
                    BattleTheme();

                }
                fruit.get(0).setfdX(0);
                //Moves background
                if (background2.getX() > 0 - 50 && background2.getX() != 0) {

                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() - 50);
                    }
                    //background2.setX(0);
                    ninja.setX(ninja.getX() - 50);
                    ninja.setSymbolX(ninja.getSymbolX() - 50);
                    lifeholder.setX(lifeholder.getX() - 50);
                    lifeholder.setbX(lifeholder.getbX() - 50);
                    background.setX(background.getX() - 50);
                    background2.setX(background2.getX() - 50);

                    if (background2.getX() < 0) {
                        background2.setX(0);
                        background.setX(-1030);
                    }


                } else {

                    background2.setX(0);
                    background.setX(-1030);
                    ninja.setX(background.getX() + 80);
                    lifeholder.setX(background.getX() + 10);
                    lifeholder.setbX(background.getX() + 31);
                    AppleEvent = 2;
                }

            }
            if (AppleEvent == 3) {
                TextHolder.setImage(TA2.getImage());
            }
            if (AppleEvent == 4) {
                TextHolder.setImage(TA3.getImage());
            }
            //Act 2: Move back left to battle the Apple King!
            if (AppleEvent == 5) {
                if (background.getX() < 0 + 50 && background.getX() != 0) {
                    //Summons the almighty Apple King!
                    for (int i = 0; i < NumberofFruit; i++) {
                        fruit.get(i).setX(fruit.get(i).getX() + 50);
                    }
                    if (ninja.getX() + 50 < 80) {
                        ninja.setX(ninja.getX() + 50);
                    }
                    if (lifeholder.getX() + 50 < 10) {
                        lifeholder.setX(lifeholder.getX() + 50);
                        lifeholder.setbX(lifeholder.getbX() + 50);
                    }
                    if (ninja.getSymbolX() + 50 < 450) {
                        ninja.setSymbolX(ninja.getSymbolX() + 50);
                    }
                    background.setX(background.getX() + 50);
                    background2.setX(background2.getX() + 50);
                    if (background.getX() > 0) {
                        background.setX(0);
                        background2.setX(1030);
                    }
                } else {
                    //End Global Event
                    ninja.setX(80);
                    lifeholder.setX(10);
                    lifeholder.setbX(31);
                    ninja.setSymbolX(450);

                    GlobalEvent = false;
                    AppleEvent = -1;
                    fruit.get(0).setX(1024);
                    fruit.get(0).setfdX(10);
                }
            }


            //Spawn Fruit ----------
            //Spawned Fruit Number is used to determine when the level is to end and when the boss arrives
            if (TutorialEvent <= 0) {
                if (SpawnedFruitNumber < RequiredFruit && WinRound == false && StopFruits == false || WatermelonEvent == -1 && WinRound == false && StopFruits == false || StrawberryEvent == -1 && WinRound == false && StopFruits == false || OrangeEvent == -1 && WinRound == false && StopFruits == false || GrapeEvent == -1 && WinRound == false && StopFruits == false || BananaEvent == -1 && WinRound == false && StopFruits == false || MangoEvent == -1 && WinRound == false && StopFruits == false || AppleEvent == -1 && WinRound == false && StopFruits == false) {
                    //   if (SpawnedFruitNumber < 1 ) {be
                    //Increase Timer if not end
                    SpawnFruitTimer++;

                } else {
                    if (CurrentLevel == 1) {
                        if (WatermelonEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            WatermelonEvent = 1;
                            GlobalEvent = true;
                        }

                    }
                    if (CurrentLevel == 2) {
                        if (StrawberryEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            StrawberryEvent = 1;
                            GlobalEvent = true;
                        }
                    }
                    if (CurrentLevel == 3) {
                        if (OrangeEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            OrangeEvent = 1;
                            GlobalEvent = true;
                        }
                    }
                    if (CurrentLevel == 4) {
                        if (GrapeEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            GrapeEvent = 1;
                            GlobalEvent = true;
                        }
                    }
                    if (CurrentLevel == 5) {
                        if (BananaEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            BananaEvent = 1;
                            GlobalEvent = true;
                        }
                    }
                    if (CurrentLevel == 6) {
                        if (MangoEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            MangoEvent = 1;
                            GlobalEvent = true;
                        }
                    }
                    if (CurrentLevel == 7) {
                        if (AppleEvent == 0 && SpawnedFruitNumber >= RequiredFruit && NumberofFruit == 0) {
                            AppleEvent = 1;
                            GlobalEvent = true;
                        }
                    }

                }
            }


            //Spawns the FRUIT!
            if (SpawnFruitTimer > SpawnFruitTime) {
                SpawnFruitTimer = 0;
                NewFruit();

                //Get Another Random Time
                // SpawnFruitTime = (int) Math.floor(Math.random() * (50 - 5 + 1) + 5);

                SpawnFruitTime = (int) Math.floor(Math.random() * (50 - 10 + 1) + 10);
                if (WatermelonEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (70 - 25 + 1) + 25);
                }
                if (StrawberryEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (65 - 25 + 1) + 25);
                }
                if (OrangeEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (60 - 25 + 1) + 25);
                }
                if (GrapeEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (60 - 20 + 1) + 20);
                }
                if (BananaEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (55 - 20 + 1) + 20);
                }
                if (MangoEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (60 - 20 + 1) + 20);
                }
                if (AppleEvent == -1) {
                    SpawnFruitTime = (int) Math.floor(Math.random() * (60 - 15 + 1) + 15);
                }
                //Add one to the count for awakening the King fruit
                SpawnedFruitNumber += 1;


            }

            //Summon SPecial fruit

            for (int i = 0; i < NumberofFruit; i++) {
                if (fruit.get(i).getFood() == 1) {
                    if (fruit.get(i).getAddNewFruit() == true && AppleEvent == -1 && fruit.get(i).getAppleAttack() == 1) {
                        //Apple barage
                        DontSummonHP = true;
                        NewFruit();

                        fruit.get(i).setAddNewFruit(false);
                        DontSummonHP = false;

                    } else if (fruit.get(i).getAddNewFruit() == true && AppleEvent == -1 && fruit.get(i).getAppleAttack() == 2) {
                        //Spinning apples of doom
                        SummonSpinningApple = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setX(690);
                        fruit.get(fruit.size() - 1).setY(320);

                        fruit.get(fruit.size() - 1).setSpinning(true);


                        fruit.get(i).setAddNewFruit(false);
                    } else if (fruit.get(i).getAddNewFruit() == true && AppleEvent == -1 && fruit.get(i).getAppleAttack() == 3) {
                        //Swag apples
                        SummonSwagApple = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setY(380);
                        fruit.get(fruit.size() - 1).setX(900);

                        fruit.get(i).setAddNewFruit(false);
                    } else if (fruit.get(i).getAddNewFruit() == true && AppleEvent == -1 && fruit.get(i).getAppleAttack() == 4 && fruit.get(i).getBossAct() == 3) {
                        //Fire apples
                        SummonFire = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setY(280);
                        fruit.get(fruit.size() - 1).setX(600);

                        fruit.get(i).setAddNewFruit(false);
                        fruit.get(i).setBossCounter(fruit.get(i).getBossCounter() + 1);
                    }
                }
                //Mango specials
                if (fruit.get(i).getFood() == 2) {

                    if (fruit.get(i).getAddNewFruit() == true && MangoEvent == -1 && fruit.get(i).getBossAct() == 2) {
                        //Summon Mango bomb
                        SummonABomb = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setY(400);

                        fruit.get(i).setAddNewFruit(false);
                        fruit.get(i).setBossAct(3);

                    }
                    if (fruit.get(i).getAddNewFruit() == true && MangoEvent == -1 && fruit.get(i).getBossAct() == 4) {
                        //Mango Barrage
                        DontSummonHP = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setfdX(12);
                        fruit.get(i).setAddNewFruit(false);
                        DontSummonHP = false;

                    }
                }
                //Banana specials
                if (fruit.get(i).getFood() == 3) {
                    if (fruit.get(i).getAddNewFruit() == true && BananaEvent == -1) {
                        //Swag banana
                        SummonSwagBanana = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setY(300);
                        fruit.get(i).setAddNewFruit(false);
                    }
                }
                //Grape specials
                if (fruit.get(i).getFood() == 4) {
                    if (fruit.get(i).getAddNewFruit() == true && GrapeEvent == -1) {
                        //Swirling grape
                        SummonSwirlingGrape = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setInitialY((int) Math.floor(Math.random() * (450 - 250 + 1) + 250));
                        fruit.get(fruit.size() - 1).setSwirling(true);
                        fruit.get(fruit.size() - 1).setSwirlNumber(1);
                        SummonSwirlingGrape = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setInitialY(fruit.get(fruit.size() - 2).getInitialY());
                        fruit.get(fruit.size() - 1).setSwirlNumber(2);
                        fruit.get(fruit.size() - 1).setSwirling(true);

                        fruit.get(i).setAddNewFruit(false);


                    }
                }

                //Orange specials
                if (fruit.get(i).getFood() == 5) {
                    if (fruit.get(i).getAddNewFruit() == true && OrangeEvent == -1) {
                        //Spinning orange
                        SummonSpinningOrange = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setX(690);
                        fruit.get(fruit.size() - 1).setY(320);
                        fruit.get(fruit.size() - 1).setSpinning(true);
                        fruit.get(i).setAddNewFruit(false);
                    }
                }
                //Strawberry specials
                if (fruit.get(i).getFood() == 6) {
                    if (fruit.get(i).getAddNewFruit() == true && StrawberryEvent == -1) {
                        //Pirate
                        SummonAPirate = true;
                        NewFruit();
                        fruit.get(fruit.size() - 1).setY(200);
                        fruit.get(i).setAddNewFruit(false);


                    }
                }
                //Watermelon specials
                if (fruit.get(i).getFood() == 7) {
                    //Watermelon seeds
                    if (fruit.get(i).getAddNewFruit() == true && WatermelonEvent == -1) {

                        SummonASeed = true;
                        NewFruit();
                        fruit.get(i).setAddNewFruit(false);
                    }
                }

            }
        }
    }
    //OffScreen Paint!!
//Painter

    public void MyPaintOffScreen(Graphics g) {
        //This paints all of the pictures on the screen. Not directly however. It instead paints it onto a BufferedImage
        //, which is then displayed on the screen. Very complicated. Much research.
        //Manages 2D graphics
        Graphics2D g2d = (Graphics2D) g;
        //Menu Objects drawn to screen
//Menu images
        if (mmenu) {
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    this);

            if (buttons.size() > 0) {
                g2d.drawImage(buttons.get(0).getImage(), buttons.get(0).getmX(), buttons.get(0).getmY(), this);
                if (buttons.size() > 1) {
                    g2d.drawImage(buttons.get(1).getImage(), buttons.get(1).getmX(), buttons.get(1).getmY(), this);
                }
                //Clear save data prompt
                if (CSaveDataPrompt == true) {

                    if (g2d.getFont() != FontNormal) {
                        g2d.setFont(FontNormal);
                    }
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Are you sure? (Y/N)", 600, 650);
                }
                if (CSaveDataCleared == true && CSaveDataPrompt == false) {
                    if (g2d.getFont() != FontNormal) {
                        g2d.setFont(FontNormal);
                    }
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Save data cleared! \nRestart for full effect.", 600, 650);
                }

            }

        }

        //InGame
        if (play == true && EnableGame == false) {
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    this);
            //Cutscene
            if (InitFinished == true) {
                if (PlayCutscene == true) {
                    CutSceneAct = 1;
                    Cutscene = true;
                    if (Mute == false) {
                        SadTheme();
                    }
                } else {
                    background.setImage(MainMenuB.getImage());
                    Cutscene = false;
                    mmenu = true;
                    if (Mute == false) {
                        MainTheme();
                    }
                }



                EnableGame = true;
            }
        }


        //Cuscene start
        if (Cutscene == true) {
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    this);
            if (g2d.getFont() != FontBold) {
                g2d.setFont(FontBold);
            }
            g2d.setColor(Color.BLACK);
            drawString(g2d, "Press any key to continue", 620, 670);

        }

//Levelselect draw
        if (levelselect) {
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    this);
            g2d.drawImage(bmini1.getImage(), mini1x, mini1y,
                    this);
            g2d.drawImage(bmini2.getImage(), mini2x, mini2y,
                    this);
            //Levelselct locks
            if (LevelSelectAct == 0) {

                if (Locked[CurrentLevel] == true) {
                    g2d.drawImage(Lock1.getImage(), mini1x, mini1y,
                            this);

                }

            }
            if (LevelSelectAct == 1) {
                if (CurrentLevel - 1 != -1) {
                    if (Locked[CurrentLevel - 1] == true) {
                        g2d.drawImage(Lock1.getImage(), mini1x, mini1y,
                                this);

                    }
                    if (Locked[CurrentLevel] == true) {

                        g2d.drawImage(Lock2.getImage(), mini2x, mini2y, this);
                    }
                } else {
                    if (Locked[7] == true) {
                        g2d.drawImage(Lock1.getImage(), mini1x, mini1y,
                                this);
                    }
                }
            }
            if (LevelSelectAct == -1) {
                if (CurrentLevel + 1 != 8) {
                    if (Locked[CurrentLevel + 1] == true) {
                        g2d.drawImage(Lock1.getImage(), mini1x, mini1y,
                                this);
                    }
                    if (Locked[CurrentLevel] == true) {
                        g2d.drawImage(Lock2.getImage(), mini2x, mini2y, this);
                    }
                } else {
                    if (Locked[7] == true) {
                        g2d.drawImage(Lock2.getImage(), mini2x, mini2y,
                                this);
                    }

                }

            }

            //Buttons
            if (buttons.size() > 0) {
                if (ActivateLS == false && ingame == false) {
                    g2d.drawImage(buttons.get(0).getImage(), buttons.get(0).getmX(), buttons.get(0).getmY(), this);
                    if (buttons.size() >= 2) {
                        g2d.drawImage(buttons.get(1).getImage(), buttons.get(1).getmX(), buttons.get(1).getmY(), this);
                    }

                    if (buttons.size() >= 3) {
                        g2d.drawImage(buttons.get(2).getImage(), buttons.get(2).getmX(), buttons.get(2).getmY(), this);
                    }

                }


            }

            if (g2d.getFont() != FontBold) {
                g2d.setFont(FontBold);
            }
            g2d.setColor(Color.WHITE);
            //Level names
            if (CurrentLevel == 0) {
                drawString(g2d, "Stage 0: Tutorial", 400, 0);
            } else if (CurrentLevel == 1) {
                drawString(g2d, "Stage 1: Melon Fields", 390, 0);
            } else if (CurrentLevel == 2) {
                drawString(g2d, "Stage 2: Strawberry Road", 370, 0);
            } else if (CurrentLevel == 3) {
                drawString(g2d, "Stage 3: Orange Sunset", 380, 0);
            } else if (CurrentLevel == 4) {
                drawString(g2d, "Stage 4: Grape Beach", 380, 0);
            } else if (CurrentLevel == 5) {
                drawString(g2d, "Stage 5: Banana Brick Road", 360, 0);
            } else if (CurrentLevel == 6) {
                drawString(g2d, "Stage 6: Mango Foyer", 380, 0);
            } else if (CurrentLevel == 7) {
                drawString(g2d, "Stage 7: Apple Castle", 380, 0);
            }




        }

        //Gameover screen draw
        if (GameOver) {

            //Black screen
            g2d.drawImage(BlackScreen.getImage(), 0, 0,
                    this);

            g2d.drawImage(ninja.getImage(), ninja.getX(), ninja.getY(), this);

            if (g2d.getFont() != FontBold) {
                g2d.setFont(FontBold);
            }
            g2d.setColor(Color.WHITE);

            drawString(g2d, "Game Over", 410, 0);



            if (g2d.getFont() != FontBold) {
                g2d.setFont(FontBold);
            }
            g2d.setColor(Color.WHITE);
            drawString(g2d, "Press any key to continue", 620, 670);


        }


        //In game objects--------
        if (ingame) {
            //Draws the background
            g2d.drawImage(background.getImage(), background.getX(), background.getY(),
                    this);
            if (TutorialEvent != 16) {
                g2d.drawImage(Symbol[ninja.getSymbol()].getImage(), ninja.getSymbolX(), ninja.getSymbolY(),
                        this);

            } else {
                if (ninja.UltiAct == 0) {
                    g2d.drawImage(Symbol[5].getImage(), ninja.getSymbolX(), ninja.getSymbolY(), this);
                } else {
                    g2d.drawImage(Symbol[0].getImage(), ninja.getSymbolX(), ninja.getSymbolY(), this);
                }
            }

            //Tutorial text
            if (TutorialEvent == 3) {
                g2d.setFont(FontNormal);
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Oh no! You've been attacked by a flying fruit! \nBeing hit decreases your health at the top left! \nDon't let it reach zero, or else you'll die a humiliating death! \nAnd trust me, you don't want that to happen!", 300, 200);

                if (g2d.getFont() != FontBold) {
                    g2d.setFont(FontBold);
                }
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Press any key to continue", 620, 670);


            }
            if (TutorialEvent == 7) {
                g2d.setFont(FontNormal);
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Press the sequence (up, down left, or right) to \n eliminate the fruit before it gets to you!", 300, 200);

                if (g2d.getFont() != FontBold) {
                    g2d.setFont(FontBold);
                }
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Eliminate the fruit to continue", 600, 670);
            }
            if (TutorialEvent == 10) {
                g2d.setFont(FontNormal);
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Some fruits can take more attacks than others \nbefore going down. Press all of their sequences to \nto eliminate them!", 300, 200);
                drawString(g2d, "Their total health (HP) is shown if it is \n greater than 3.", 300, 300);

                if (g2d.getFont() != FontBold) {
                    g2d.setFont(FontBold);
                }
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Eliminate the fruit to continue", 600, 670);
            }

            if (TutorialEvent == 13) {
                g2d.setFont(FontNormal);
                g2d.setColor(Color.BLACK);
                drawString(g2d, "You can only attack the HORIZONTALLY  CLOSEST \nFRUIT OF EACH DIRECTION. Confused? The arrows highlighted in \nred indicate the closest sequence of each direction (up down, left, right)\nThey are the fruits that you can attack!"
                        + "\n\nKeep in mind that you still attack a closer fruit of a\ndifferent sequence, as long as it's highlighted red!\n\nThis knowledge can be used to great effect! \nStratagize which fruit to slice up first! ", 125, 125);
                //  drawString(g2d, "Keep in mind that you still attack a closer fruit of a\ndifferent sequence, as long as it's highlighted red!\n\nThis knowledge can be used to great effect! \nStratagize which fruit to slice up first! ", 125, 250);


                if (g2d.getFont() != FontBold) {
                    g2d.setFont(FontBold);
                }
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Eliminate the fruit to continue", 600, 670);
            }
            if (TutorialEvent == 16) {
                g2d.setFont(FontNormal);
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Too much fruit to handle? \nWhen the top left symbol is glowing yellow,\nPress Space Bar to use your ultimate move \nYour ultimate will refill again over time.", 100, 200);



            }


            //Special boss drawings
            if (CurrentLevel == 1) {
                if (WatermelonEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }

                //Watermelon King Event draw stuff
                if (WatermelonEvent == 1) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);

                }
                //Background of the cutscene
                if (WatermelonEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }



                //More Watermelon King stuff
                if (WatermelonEvent == 1 || WatermelonEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }
            }
            //Special boss drawings
            if (CurrentLevel == 2) {
                if (StrawberryEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Strawberry
                if (StrawberryEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Watermelon King stuff
                if (StrawberryEvent == 1 || StrawberryEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }
            }

            //Special boss drawings
            if (CurrentLevel == 3) {
                if (OrangeEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Orange
                if (OrangeEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);


                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Orange King stuff
                if (OrangeEvent == 1 || OrangeEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }

            }
            //Special boss drawings
            if (CurrentLevel == 4) {
                if (GrapeEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Grape
                if (GrapeEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Grape King stuff
                if (GrapeEvent == 1 || GrapeEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }

            }
            //Special boss drawings
            if (CurrentLevel == 5) {
                if (BananaEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Banana
                if (BananaEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Banana King stuff
                if (BananaEvent == 1 || BananaEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }

            }
            //Special boss drawings
            if (CurrentLevel == 6) {
                if (MangoEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Mango
                if (MangoEvent == 2) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Mango King stuff
                if (MangoEvent == 1 || MangoEvent == 3) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }

            }
            //Special boss drawings
            if (CurrentLevel == 7) {
                if (AppleEvent == 0) {
                    g2d.setFont(FontNormal);
                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Fruit Thrown: " + SpawnedFruitNumber + "\nFruits Before Boss: " + RequiredFruit, 10, 100);
                }
                //Background of the Apple
                if (AppleEvent == 2 || AppleEvent == 3 || AppleEvent == 4) {

                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                    g2d.drawImage(TextHolder.getImage(), 340, 160,
                            this);

                    //Draws the text of the King

                    if (g2d.getFont() != FontBold) {
                        g2d.setFont(FontBold);
                    }

                    g2d.setColor(Color.BLACK);
                    drawString(g2d, "Press any key to continue", 620, 670);

                }

                //More Apple King stuff
                if (AppleEvent == 1 || AppleEvent == 5) {
                    g2d.drawImage(background2.getImage(), background2.getX(), background2.getY(),
                            this);
                }

            }




            //Draws the ninja
            if (ninja.isVisible() && ninja.getUltiAct() != 3) {

                g2d.drawImage(ninja.getImage(), ninja.getX(), ninja.getY(), this);
            }


            //Draws the Health bar
            g2d.drawImage(lifeholder.getImage(), lifeholder.getX(), lifeholder.getY(), this);
            if (Game.lifeholder.getHealth() > 0) {
                g2d.drawImage(lifeholder.getBarImage(), lifeholder.getbX(), lifeholder.getbY(), this);
            }


            //PressBoard Image - The black thing where you press the arrow keys
            for (int i = 0; i < NumberofFruit; i++) {
                //A bunch of if statements to satisfy all possible errors
                if (fruit.get(i).getpbVisible() == true && TutorialEvent != 2 && TutorialEvent != 3 && TutorialEvent != 4) {

                    if (fruit.get(i).getNextSequence() == false) {


                        if (fruit.get(i).getAbnormal() == false) {
                            int fruitLocation = fruit.get(i).getY() + 50;

                            //Normal Fruit Pressboard
                            if (fruit.get(i).getNumberofSequences() > 0) {
                                g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 50, fruitLocation,
                                        this);

                            }
                            //Normal Fruit Arrows
                            if (fruit.get(i).getNumberofSequences() > 0) {
                                g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 50 - fruit.get(i).getArrowOffset(), fruitLocation,
                                        this);
                            }
                            if (fruit.get(i).getNumberofSequences() > 1) {
                                g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 50 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                        this);
                            }
                            if (fruit.get(i).getNumberofSequences() > 2) {
                                g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 50 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                        this);
                            }



                        } else {

                            if (fruit.get(i).getBig() == true) {
                                //Big fruit Pressboard
                                int fruitLocation = 0;

                                fruitLocation = fruit.get(i).getY() + 150;
                                if (fruit.get(i).getBomb() == true) {
                                    fruitLocation = fruit.get(i).getY() + 180;
                                }
                                if (fruit.get(i).getFire() == true) {
                                    fruitLocation = fruit.get(i).getY() + 280;
                                }

                                if (fruit.get(i).getBomb() == false || fruit.get(i).getBomb() == true && fruit.get(i).getExplode() == false) {

                                    if (fruit.get(i).getNumberofSequences() > 0) {
                                        g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 25, fruitLocation,
                                                this);
                                    }
                                    if (fruit.get(i).getNumberofSequences() > 0) {
                                        g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 25 - fruit.get(i).getArrowOffset(), fruitLocation,
                                                this);
                                    }
                                    if (fruit.get(i).getNumberofSequences() > 1) {
                                        g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 25 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                                this);
                                    }
                                    if (fruit.get(i).getNumberofSequences() > 2) {
                                        g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 25 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                                this);
                                    }

                                }
                            }
                            if (fruit.get(i).getHeroic() == true && GlobalEvent == false) {
                                //King Fruit Pressboard
                                int fruitLocation = 0;
                                if (fruit.get(i).getFood() == 1 || fruit.get(i).getFood() == 2) {
                                    fruitLocation = fruit.get(i).getY() + 210;
                                } else {
                                    fruitLocation = fruit.get(i).getY() + 180;
                                }

                                if (fruit.get(i).getNumberofSequences() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 5, fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getNumberofSequences() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 5 - fruit.get(i).getArrowOffset(), fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getNumberofSequences() > 1) {
                                    g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 5 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                            this);
                                }
                                if (fruit.get(i).getNumberofSequences() > 2) {
                                    g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 5 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                            this);
                                }

                            }

                            //Extra Health - This is the numbers (XHP) on the screen if the fruit has > 3 Health
                            if (fruit.get(i).getNumberofSequences() > 3 && GlobalEvent == false || fruit.get(i).getNumberofSequences() > 3 && TutorialEvent >= 8) {
                                //Determine whether to draw big pressboard or king pressboard
                                int fruitLocation = 0;
                                int XAlignment = 0;
                                if (fruit.get(i).getBig() == true) {
                                    fruitLocation = fruit.get(i).getY() + 150;
                                    if (fruit.get(i).getBomb() == true) {
                                        fruitLocation = fruit.get(i).getY() + 180;
                                    }
                                    if (fruit.get(i).getFire() == true) {
                                        fruitLocation = fruit.get(i).getY() + 280;
                                    }
                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    if (fruit.get(i).getFood() == 1 || fruit.get(i).getFood() == 2) {
                                        fruitLocation = fruit.get(i).getY() + 210;
                                    } else {
                                        fruitLocation = fruit.get(i).getY() + 180;
                                    }
                                    XAlignment = 25;

                                }

                                //Display one digit Numbers of health
                                if (fruit.get(i).getNumberofSequences() < 10) {



                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);


                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }
                                    //Display two digit Numbers of health
                                } else if (fruit.get(i).getNumberofSequences() >= 10 && fruit.get(i).getNumberofSequences() < 100) {
                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);

                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }

                                    if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    }


                                } else if (fruit.get(i).getNumberofSequences() >= 100) {

                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 330 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);

                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }
                                    if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);

                                    }

                                    if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);

                                    }

                                }


                            }


                        }


                    } else {
                        //Must have different pressboard when hit
                        if (fruit.get(i).getAbnormal() == false) {
                            //Normal Fruit Pressboard hit
                            int fruitLocation = fruit.get(i).getY() + 50;

                            if (fruit.get(i).getTemp() > 0) {
                                g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 50, fruitLocation,
                                        this);
                            }
                            if (fruit.get(i).getTemp() > 0) {
                                g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 50 - fruit.get(i).getArrowOffset(), fruitLocation,
                                        this);
                            }
                            if (fruit.get(i).getTemp() > 1) {
                                g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 50 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                        this);
                            }
                            if (fruit.get(i).getTemp() > 2) {
                                g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 50 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                        this);

                            }

                        } else {
                            //Big Fruit Pressboard hit
                            if (fruit.get(i).getBig() == true) {
                                int fruitLocation = 0;
                                fruitLocation = fruit.get(i).getY() + 150;
                                if (fruit.get(i).getBomb() == true) {
                                    fruitLocation = fruit.get(i).getY() + 180;
                                }
                                if (fruit.get(i).getFire() == true) {
                                    fruitLocation = fruit.get(i).getY() + 280;
                                }

                                if (fruit.get(i).getTemp() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 25, fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 25 - fruit.get(i).getArrowOffset(), fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 1) {
                                    g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 25 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 2) {
                                    g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 25 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                            this);
                                }

                            }
                            if (fruit.get(i).getHeroic() == true) {
                                //King Fruit Pressboard hit
                                int fruitLocation = 0;
                                if (fruit.get(i).getFood() == 1 || fruit.get(i).getFood() == 2) {
                                    fruitLocation = fruit.get(i).getY() + 210;
                                } else {
                                    fruitLocation = fruit.get(i).getY() + 180;
                                }


                                if (fruit.get(i).getTemp() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbImage(), fruit.get(i).getX() - 5, fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 0) {
                                    g2d.drawImage(fruit.get(i).getpbaImage(), fruit.get(i).getX() - 5 - fruit.get(i).getArrowOffset(), fruitLocation,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 1) {
                                    g2d.drawImage(fruit.get(i).getpbaImage2(), fruit.get(i).getX() - 5 + 100 - fruit.get(i).getArrowOffset2(), fruitLocation + 30,
                                            this);
                                }
                                if (fruit.get(i).getTemp() > 2) {
                                    g2d.drawImage(fruit.get(i).getpbaImage3(), fruit.get(i).getX() - 5 + 150 - fruit.get(i).getArrowOffset3(), fruitLocation + 30,
                                            this);
                                }

                            }

                            //Extra Health - This is the numbers (XHP) on the screen if the fruit has > 3 Health
                            if (fruit.get(i).getNumberofSequences() > 3 && GlobalEvent == false) {
                                //King or Big
                                int fruitLocation = 0;
                                int XAlignment = 0;
                                if (fruit.get(i).getBig() == true) {
                                    fruitLocation = fruit.get(i).getY() + 150;
                                    if (fruit.get(i).getBomb() == true) {
                                        fruitLocation = fruit.get(i).getY() + 180;
                                    }
                                    if (fruit.get(i).getFire() == true) {
                                        fruitLocation = fruit.get(i).getY() + 280;
                                    }
                                }
                                if (fruit.get(i).getHeroic() == true) {

                                    if (fruit.get(i).getFood() == 1 || fruit.get(i).getFood() == 2) {
                                        fruitLocation = fruit.get(i).getY() + 210;
                                    } else {
                                        fruitLocation = fruit.get(i).getY() + 180;
                                    }
                                    XAlignment = 25;
                                }

                                //One digit numbers
                                if (fruit.get(i).getNumberofSequences() < 10) {
                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }
                                    //Two digit Numbers
                                } else if (fruit.get(i).getNumberofSequences() >= 10 && fruit.get(i).getNumberofSequences() < 100) {
                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);

                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }
                                    if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);

                                    }

                                } else if (fruit.get(i).getNumberofSequences() >= 100) {

                                    g2d.drawImage(HPp.getImage(), fruit.get(i).getX() + 330 + XAlignment, fruitLocation + 15,
                                            this);
                                    if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);

                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(0)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 150 + XAlignment, fruitLocation,
                                                this);
                                    }
                                    if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(1)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 210 + XAlignment, fruitLocation,
                                                this);

                                    }

                                    if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("0")) {
                                        g2d.drawImage(N0.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("1")) {
                                        g2d.drawImage(N1.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("2")) {
                                        g2d.drawImage(N2.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("3")) {
                                        g2d.drawImage(N3.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("4")) {
                                        g2d.drawImage(N4.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("5")) {
                                        g2d.drawImage(N5.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("6")) {
                                        g2d.drawImage(N6.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("7")) {
                                        g2d.drawImage(N7.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("8")) {
                                        g2d.drawImage(N8.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);
                                    } else if (String.valueOf(fruit.get(i).getSS().charAt(2)).equals("9")) {
                                        g2d.drawImage(N9.getImage(), fruit.get(i).getX() + 270 + XAlignment, fruitLocation,
                                                this);

                                    }

                                }
                            }

                        }


                    }





                }


            }



            //DRAWS THE ACTUAL FRUIT -  HURRAY!~ --------------------------------------------
            for (int i = 0; i < NumberofFruit; i++) {

                if (fruit.get(i).getHeroic() == true && fruit.get(i).getFood() == 1 && fruit.get(i).getAppleAttack() == 4 && fruit.get(i).getBossAct() == 2) {
                    if (fruit.get(i).getActTimer() > 10) {

                        g2d.drawImage(Explosion[0], fruit.get(i).getX(), fruit.get(i).getY(),
                                this);
                    } else if (fruit.get(i).getActTimer() > 8) {
                        g2d.drawImage(Explosion[1], fruit.get(i).getX(), fruit.get(i).getY(), this);
                    } else if (fruit.get(i).getActTimer() > 6) {
                        g2d.drawImage(Explosion[2], fruit.get(i).getX(), fruit.get(i).getY(),
                                this);
                    } else if (fruit.get(i).getActTimer() > 4) {
                        g2d.drawImage(Explosion[3], fruit.get(i).getX(), fruit.get(i).getY(), this);
                    } else if (fruit.get(i).getActTimer() >= 2) {
                        g2d.drawImage(Explosion[4], fruit.get(i).getX(), fruit.get(i).getY(),
                                this);
                    } else if (fruit.get(i).getActTimer() < 2) {
                        g2d.drawImage(Explosion[5], fruit.get(i).getX(), fruit.get(i).getY(),
                                this);
                    }





                }



                if (fruit.get(i).isDying() == false && fruit.get(i).getIsHit() == false && fruit.get(i).getBomb() == false) {

                    //Rotation Stuff
                    if (StopFruits == false && fruit.get(i).getSpinning() == false && fruit.get(i).getSwirling() == false && fruit.get(i).getFood() != 30) {
                        FruitRotation.set(i, FruitRotation.get(i) + 2);



                        rotationRequired.set(i, (Math.toRadians(FruitRotation.get(i))));

                        locationX.set(i, ((double) (fruit.get(i).getWidth() / 2)));
                        locationY.set(i, ((double) (fruit.get(i).getHeight() / 2)));

                        tx.set(i, AffineTransform.getRotateInstance(rotationRequired.get(i), locationX.get(i), locationY.get(i)));
                        op.set(i, new AffineTransformOp(tx.get(i), AffineTransformOp.TYPE_BILINEAR));
                    }
                    //Determine the kind of fruit (to not waste memory)

                    // 1  = A = Apple
                    // 2 = M = Mango
                    // 3 = B = Banana
                    // 4 = G = Grapes
                    // 5 = O = Orange
                    // 6 = S = Strawberry
                    // 7 = W = Watermelon
                    // +b = Big Fruit

                    switch (fruit.get(i).getFood()) {
                        case 1:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rAI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    if (fruit.get(i).getFire() == false) {
                                        g2d.drawImage(brAI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else {
                                        g2d.drawImage(Explosion[2], fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }

                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    //     if (fruit.get(i).getBossAct() >= 1) {
                                    //       g2d.drawImage(AKAI, fruit.get(i).getX(), fruit.get(i).getY(),
                                    //               this);
                                    //    } else {
                                    g2d.drawImage(KAI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                    //   }

                                }
                            }
                            break;
                        case 2:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rMI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brMI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    //       if (fruit.get(i).getBossAct() >= 1) {
                                    //          g2d.drawImage(AKMI, fruit.get(i).getX(), fruit.get(i).getY(),
                                    //                 this);
                                    //       } else {
                                    g2d.drawImage(KMI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                    //    }

                                }
                            }
                            break;
                        case 3:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rBI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brBI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    //       if (fruit.get(i).getBossAct() >= 1) {
                                    //           g2d.drawImage(AKBI, fruit.get(i).getX(), fruit.get(i).getY(),
                                    //                  this);
                                    //      } else {
                                    g2d.drawImage(KBI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                    //      }

                                }
                            }
                            break;
                        case 4:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rGI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brGI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    //            if (fruit.get(i).getBossAct() >= 1) {
                                    //              g2d.drawImage(AKGI, fruit.get(i).getX(), fruit.get(i).getY(),
                                    //                    this);
                                    //     } else {
                                    g2d.drawImage(KGI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                    //   }

                                }
                            }
                            break;
                        case 5:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rOI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brOI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {

                                    g2d.drawImage(KOI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                    //   }

                                }
                            }
                            break;
                        case 6:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rSI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brSI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {

                                    g2d.drawImage(KSI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                 

                                }
                            }
                            break;
                        case 16:
                            g2d.drawImage(SPI, fruit.get(i).getX(), fruit.get(i).getY(),
                                    this);
                            break;
                        case 7:
                            if (fruit.get(i).getAbnormal() == false) {
                                g2d.drawImage(rWI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            } else {
                                if (fruit.get(i).getBig() == true) {
                                    g2d.drawImage(brWI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                }
                                if (fruit.get(i).getHeroic() == true) {
                                    if (fruit.get(i).getBossAct() >= 1) {
                                        g2d.drawImage(AKWI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else {
                                        g2d.drawImage(KWI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }

                                }
                            }
                            break;
                        case 17:
                            g2d.drawImage(srWI[FruitRotation.get(i)], fruit.get(i).getX(), fruit.get(i).getY(),
                                    this);
                            break;
                        case 30:
                            g2d.drawImage(HPp2, fruit.get(i).getX(), fruit.get(i).getY(),
                                    this);
                            break;

                    }


                    //Restart Rotation
                    if (FruitRotation.get(i) == 358) {
                        FruitRotation.set(i, 0);
                    }
                    //This else is if the fruit is hit - must have different pictures
                } else {
                    //Restart Rotation
                    if (FruitRotation.get(i) > 0) {
                        FruitRotation.set(i, -FruitRotation.get(i));
                    }
                    //Draws the Kings
                    if (fruit.get(i).isVisible()) {

                        if (fruit.get(i).getHeroic() == true) {
                            if (fruit.get(i).getFood() == 1) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KAI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KAS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KAI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KAI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }

                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            } else if (fruit.get(i).getFood() == 2) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KMI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KMS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KMI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KMI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }

                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            } else if (fruit.get(i).getFood() == 3) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KBI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KBS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KBI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KBI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }

                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            } else if (fruit.get(i).getFood() == 4) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KGI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KGS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KGI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KGI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }

                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            } else if (fruit.get(i).getFood() == 5) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KOI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KOS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KOI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KOI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }

                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            } else if (fruit.get(i).getFood() == 6) {
                                if (fruit.get(i).isDying() == false) {
                                    g2d.drawImage(KSI, fruit.get(i).getX(), fruit.get(i).getY(),
                                            this);
                                } else {
                                    if (fruit.get(i).getDyingTimer() > 5) {
                                        g2d.drawImage(KSS3, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                    if (fruit.get(i).getDyingTimer() <= 5 && fruit.get(i).getDyingTimer() > 3) {
                                        g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KSI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    } else if (fruit.get(i).getDyingTimer() <= 3) {
                                        g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                                this);
                                        g2d.drawImage(KSI, fruit.get(i).getX(), fruit.get(i).getY(),
                                                this);
                                    }
                                }
                                if (fruit.get(i).isHitTimer <= 5 && fruit.get(i).isHitTimer > 3) {
                                    g2d.drawImage(Slice2.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);

                                } else if (fruit.get(i).isHitTimer <= 3) {
                                    g2d.drawImage(Slice1.getImage(), fruit.get(i).getX() - 20, fruit.get(i).getY() + 120,
                                            this);
                                }
                            }
                            if (fruit.get(i).getFood() == 7) {
                                g2d.drawImage(fruit.get(i).getImageIcon(), fruit.get(i).getX(), fruit.get(i).getY(),
                                        this);
                            }




                            //  }
                            //If big or normal
                        } else {
                            try {

                                //Rotation Stuff
                                if (StopFruits == false) {
                                    if (fruit.get(i).getSpinning() == false && fruit.get(i).getSwirling() == false && fruit.get(i).getFood() != 30 && fruit.get(i).getBomb() == false && fruit.get(i).getFire() == false) {

                                        FruitRotation.set(i, FruitRotation.get(i) - 2);

                                    }
                                    if (fruit.get(i).getBomb() == true && fruit.get(i).getdX() != 0) {
                                        FruitRotation.set(i, FruitRotation.get(i) - 20);
                                    }
                                    if (fruit.get(i).getExplode() == true) {
                                        FruitRotation.set(i, 0);
                                    }
                                    if (fruit.get(i).getFire() == true) {
                                        FruitRotation.set(i, 0);
                                    }

                                    rotationRequired.set(i, (Math.toRadians(FruitRotation.get(i))));
                                    if (fruit.get(i).getFood() == 16) {
                                        rotationRequired.set(i, 0.0);
                                    }

                                    locationX.set(i, ((double) (fruit.get(i).getWidth() / 2)));
                                    locationY.set(i, ((double) (fruit.get(i).getHeight() / 2)));

                                    tx.set(i, AffineTransform.getRotateInstance(rotationRequired.get(i), locationX.get(i), locationY.get(i)));
                                    op.set(i, new AffineTransformOp(tx.get(i), AffineTransformOp.TYPE_BILINEAR));
                                }
                                //Get the Image from the fruit class
                                try {
                                    FruitImage.set(i, (BufferedImage) fruit.get(i).getImageIcon());
                                } catch (Exception e) {
                                }

                                // Drawing the rotated image at the required drawing locations
                                g2d.drawImage(op.get(i).filter(FruitImage.get(i), null), fruit.get(i).getX(), fruit.get(i).getY(), null);

                                ImageIcon Transformed = new ImageIcon(FruitImage.get(i));
                                fruit.get(i).setImage(Transformed.getImage());
                                //Restart Rotation
                                if (FruitRotation.get(i) == -360) {
                                    FruitRotation.set(i, 0);
                                }
                            } catch (Exception e) {
                            }
                        }



                    }



                }







            }

            if (WinRound == true) {
                g2d.drawImage(VictoryP.getImage(), 200, 120,
                        this);

                if (g2d.getFont() != FontBold) {
                    g2d.setFont(FontBold);
                }
                g2d.setColor(Color.BLACK);
                drawString(g2d, "Press any key to continue", 620, 670);


            }


            if (ninja.getUltiAct() == 3) {
                g2d.drawImage(ninja.getUltiPic().getImage(), 0, 0, this);
            }

            AllowToDie = true;

            fruitdying();

            AllowToDie = false;

            //Dispose to not waste memory
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
            g2d.dispose();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        //Where the ACTUAL ACTUAL image is drawn.

        Graphics gra;

        gra = Imager.createGraphics();

        Imager.flush();
        MyPaintOffScreen(gra);

        Graphics2D g2d = (Graphics2D) g;
        if (play) {
            //Draw everything according to the width and height!
            g.drawImage(Imager, 0, 0, this.getWidth(), this.getHeight(), null);


            //Dispose stuff to not waste memory
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
            g2d.dispose();
        }

    }

    //Runs the initGame
    public void run() {
        InitGame();

    }

    public void GameLoop() {
        //MAIN GAME LOOP
        //Everything in here is repeated infinity times
        //This is the code that the program ACTUALLY runs over and over again

        while (play) {
            try {
                //Resizing stuff
                awidth = this.getWidth() / 1024.0;
                aheight = 725.0 / this.getHeight();
                //REPAINTS EVERYTHING
                repaint();
                animationCycle();


            } catch (Exception e) {
            }

            try {
                Thread.sleep((long) 41.6);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
//Pretty self explanitory - Function in the case of which a fruit dies

    public void fruitdying() {


        //Search all fruits for a dead one
        if (Game.ninja.getUltiAct() != 3) {


            for (int i = 0; i < NumberofFruit; i++) {
                if (fruit.get(i).isDying() == true || fruit.get(i).getY() > this.getHeight() && fruit.get(i).getSpinning() == false || fruit.get(i).getY() > this.getHeight() + 200 && fruit.get(i).getSpinning() == true || fruit.get(i).getSwirling() == true && fruit.get(i).getX() < 0) {
                    //After a delay,
                    if (fruit.get(i).getHeroic() == true) {
                        SpawnFruitTimer = 0;
                    }
                    //   DieTimer.set(i, DieTimer.get(i) + 1);
                    if (fruit.get(i).getDyingTimer() > 7 && AllowToDie == true || fruit.get(i).getY() > this.getHeight()) {

                        if (fruit.get(i).getHeroic() == true) {
                            fruit.get(i).setBossAct(0);

                            SummonASeed = false;
                            SummonAPirate = false;
                            fruit.get(i).setBossAct(0);
                            fruit.get(i).setAddNewFruit(false);

                            WinRound = true;
                            if (CurrentLevel != 7) {
                                Locked[CurrentLevel + 1] = false;
                            }


                            while (fruit.size() > 0) {
                                //Remove the dead fruit - Everything! :(
                                FruitRotation.remove(0);
                                rotationRequired.remove(0);
                                locationX.remove(0);
                                locationY.remove(0);
                                tx.remove(0);
                                op.remove(0);
                                FruitImage.remove(0);
                                fruit.remove(0);

                                DieTimer.set(0, 0);
                                DieTimer.remove(0);

                                NumberofFruit--;
                                KillCounter++;
                            }
                        } else {


                            if (fruit.get(i).getBomb() == false || fruit.get(i).getBomb() == true && fruit.get(i).getExplode() == false || fruit.get(i).getBomb() == true && fruit.get(i).getExplode() == true && fruit.get(i).getBombTimer() > 30) {



                                //Remove the dead fruit - Everything! :(
                                FruitRotation.remove(i);
                                rotationRequired.remove(i);
                                locationX.remove(i);
                                locationY.remove(i);
                                tx.remove(i);
                                op.remove(i);
                                FruitImage.remove(i);
                                fruit.remove(i);

                                DieTimer.set(i, 0);
                                DieTimer.remove(i);

                                NumberofFruit--;
                                KillCounter++;
                                if (TutorialEvent == 7) {
                                    TutorialEvent++;
                                    StopFruits = false;
                                }
                                if (TutorialEvent == 10) {
                                    TutorialEvent++;
                                    StopFruits = false;
                                }

                                if (TutorialEvent == 13 && NumberofFruit == 0) {
                                    TutorialEvent++;
                                    StopFruits = false;
                                }
                                if (TutorialEvent == 15 && NumberofFruit == 0) {
                                    TutorialEvent++;
                                    StopFruits = false;
                                    ninja.setSymbolTimer(ninja.getSymbolTime());
                                    //End tutorial
                                }
                                if (TutorialEvent == 16 && NumberofFruit == 0) {
                                    TutorialEvent++;
                                    WinRound = true;

                                    //End tutorial
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    //New fruit function - the variables required to make a new fruit

    public void NewFruit() {
        fruit.add(new Fruit());
        FruitRotation.add(0);
        DieTimer.add(0);

        rotationRequired.add(null);
        locationX.add(null);
        locationY.add(null);
        tx.add(null);
        op.add(null);
        FruitImage.add(null);
        FruitDeadSetter.add(false);
        //   pb.add(new PressBoard());
        NumberofFruit++;
    }
    //Resize function

    public BufferedImage resizeImage(BufferedImage image, int width, int height) {
        int type = 0;
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, width, height, null);

        graphics2D.dispose();
        return image;
    }
    //Draw string function to enable next lines

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n")) {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }
    //Allows for Keyboard input
//Adapter for key press
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            ninja.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            ninja.keyPressed(e);
        }
    }
//Music
    private void BattleTheme() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/battletheme.wav";
            BattleTheme = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(BattleTheme);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }

    private void BattleTheme2() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/battletheme2.wav";
            BattleTheme2 = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(BattleTheme2);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }

    private void SadTheme() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/sad.wav";
            SadTheme = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(SadTheme);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }

    private void MainTheme() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/maintheme.wav";
            MainTheme = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(MainTheme);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }

    public static void ClearSave() {
        try {
            //Save high score
            BufferedWriter SaveWriter = new BufferedWriter(new FileWriter("SaveFile.txt", false));
            SaveWriter.write("ShowCutscene 1");
            SaveWriter.newLine();

            SaveWriter.write("Locked 2");

            SaveWriter.close();
        } catch (Exception e) {
        }
    }
//File saves
    private void SaveFile() {
        try {
            //Save high score
            BufferedWriter SaveWriter = new BufferedWriter(new FileWriter("SaveFile.txt", false));
            SaveWriter.write("ShowCutscene 0");
            SaveWriter.newLine();
            int LockedValue = 0;

            for (int i = 2; i < 8; i++) {
                if (Locked[i] == true) {
                    SaveWriter.write("Locked " + i);
                    break;
                } else if (i == 7 && Locked[i] == false) {
                    SaveWriter.write("Locked 8");
                }
            }


            SaveWriter.close();
        } catch (Exception e) {
        }
    }
//File Loads
    public static void LoadFile() {

        try {
            //Display Successfully loaded!

            BufferedReader LoadReader = new BufferedReader(new FileReader("SaveFile.txt"));

            //Load High score
            String EntireLine = LoadReader.readLine();
            int ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ", 0) + 1))));

            if (ValueOnly == 1) {
                PlayCutscene = true;
            } else {
                PlayCutscene = false;
            }

            //Load Cash
            EntireLine = LoadReader.readLine();
            ValueOnly = Integer.parseInt(String.valueOf(EntireLine.substring((EntireLine.indexOf(" ", 0) + 1))));
            int LockedValue = ValueOnly;
            for (int i = 0; i < 8; i++) {
                Locked[i] = false;
            }
            if (LockedValue != 8) {
                for (int i = LockedValue; i < 8; i++) {
                    Locked[i] = true;
                }
            }




        } catch (Exception e) {
        }
    }
}
