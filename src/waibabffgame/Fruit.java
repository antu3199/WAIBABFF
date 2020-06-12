/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *  -Xms32m -Xmx1280m -XX:ReservedCodeCacheSize=100m
 */
package waibabffgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author atu3199
 */
//Fruit Class - The DNA of those little cute things are in here!
public class Fruit extends Sprite {

    //x and y
    private int fx;
    private int fy;
    //Movement of x and y
    private int fdx = 5;
    private int fdy = 0;
    //Determines what fruit they are
    private int Food = 0;
    //Some variables to calculate when the fruit falls
    int TimeFall = 0;
    private int FallTime = 180;
    //Ninja
    private Ninja ninja;
    private boolean visible;
    //Image
    private Image image;
    //Dying fruit :(
    private boolean dying;
    //Real Fruit Image
    BufferedImage FImage = null;
    //Number of Sequences - Health
    private int NumberofSequences;
    private ArrayList<Integer> pbSequence = new ArrayList();
    //Fruit Images
    private BufferedImage A;
    private BufferedImage M;
    private BufferedImage B;
    private BufferedImage G;
    private BufferedImage O;
    private BufferedImage S;
    private BufferedImage W;
    private BufferedImage sW;
    private BufferedImage SP;
    private BufferedImage HP;
    //Dying Timer :(
    int DyingTimer = 0;
    //Init Image
    boolean init = true;
    boolean isHit = false;
    int isHitTimer = 0;
    //Pressboard
    private String pressboardImage = "Pictures/Pressboard/pressboard.png";
    private String pressboardImage2 = "Pictures/Pressboard/pressboard2.png";
    private String pressboardImage3 = "Pictures/Pressboard/pressboard3.png";
    //Arrow Offset
    private int ArrowOffset = 0;
    private int ArrowOffset2 = 0;
    private int ArrowOffset3 = 0;
    //Pressboard variables
    private boolean pbvisible;
    private Image pbimage;
    private Image pbaimage;
    private Image pbaimage2;
    private Image pbaimage3;
    private Boolean pbnextSequence = false;
    private int pbTemp;
    //Temp image
    BufferedImage pbdest;
    //Fruit Classification variables
    private boolean abnormal;
    private boolean big;
    private boolean heroic;
    //Attacked variables
    private boolean Attacked = false;
    //HP thing 
    private String SS = "";
    //Boss variables
    private int BossAct = 0;
    private int BossActTimer = 0;
    private boolean AddNewFruit = false;
    private boolean minor = false;
    private int RandomBossTimer = 0;
    private boolean upHL = false;
    private boolean downHL = false;
    private boolean leftHL = false;
    private boolean rightHL = false;
    int SpeedIncreaseCounter = 0;
    private int BossCounter = 0;
    private boolean Spinning = false;
    private int SpinAct = 0;
    int SpinInitX = 0;
    int SpinInitY = 0;
    Double SpinSpeed = 0.0;
    Double SpinIncrease = 0.0;
    int InitialY = 0;
    private boolean Swirling = false;
    Double SwirlLength = 0.0;
    int SwirlNumber = 0;
    boolean Swag = false;
    int AppleAttack = 0;
    boolean Bomb = false;
    int BombTimer = 0;
    boolean Explode = false;
    boolean Fire = false;
    int FireHit = 0;
    int AppleChargeHit = 0;

    public Fruit() {
        //Determines which fruit:
        // 1 = A = Apple
        // 2 = M = Mango
        // 3 = B = Banana
        // 4 = G = Grapes
        // 5 = O = Orange
        // 6 = S = Strawberry
        // 7 = W = Watermelon
        // +b at start = Big fruit


        Food = (int) Math.floor(Math.random() * (7 - 1 + 1) + 1);
        //  Food = 30;
        //In the boss levels, spawn only that fruit
        if (Game.WatermelonEvent == -1) {
            Food = 7;
        }
        if (Game.StrawberryEvent == -1) {
            Food = 6;
        }
        if (Game.OrangeEvent == -1) {
            Food = 5;
        }
        if (Game.GrapeEvent == -1) {
            Food = 4;
        }
        if (Game.BananaEvent == -1) {
            Food = 3;
        }
        if (Game.MangoEvent == -1) {
            Food = 2;
        }
        if (Game.AppleEvent == -1) {
            Food = 1;
        }
        int HPChance = 0;
        if (Game.WatermelonEvent == -1 || Game.StrawberryEvent == -1 || Game.StrawberryEvent == -1 || Game.OrangeEvent == -1 || Game.GrapeEvent == -1 || Game.BananaEvent == -1 || Game.MangoEvent == -1 && Game.GiantMangoAttack == false || Game.AppleEvent == -1) {

            HPChance = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        } else {
            HPChance = (int) Math.floor(Math.random() * (8 - 1 + 1) + 1);
        }
        if (HPChance == 1 && Game.TutorialEvent < 1 && Game.DontSummonHP == false) {
            Food = 30;
        }
        //  Food = 17;
        //Determines the fruit stats
        FruitStats();
        //Width, height thing
        if (abnormal == false) {
            setWidth(100);
            setHeight(100);
        } else {

            if (big == true) {
                setWidth(200);
                setHeight(220);
            }
        }
        //Sets the image (but not for long)
        setImage(image);

        visible = true;
        setVisible(true);
        //Sets inital location if unmodified
        if (Food == 17) {
            fx = 700;
            fy = 350;
        } else {
            fx = 1024;

        }




        if (Game.ingame && Game.NumberofFruit > 0) {
      
            boolean Match = false;
            fy = (int) Math.floor(Math.random() * (500 - 100 + 1) + 100);
            if (big == true) {
                fy = (int) Math.floor(Math.random() * (450 - 50 + 1) + 50);
            }
            do {

                for (int i = 0; i < Game.NumberofFruit; i++) {
                    if (fy >= Game.fruit.get(i).getY() + 150 + 130 && fy <= Game.fruit.get(i).getY() + 150) {
                        Match = true;
                        for (int j = fy; j < 500; j++) {
                            if (fy + j >= Game.fruit.get(i).getY() + 150 + 130 && fy + j <= Game.fruit.get(i).getY() + 150) {
                                Match = true;
                            } else {
                                fy = fy + j;
                                Match = false;
                            }
                        }
                        if (Match == false) {
                            for (int j = fy; j > 0; j--) {
                                if (fy - j >= Game.fruit.get(i).getY() + 150 + 130 && fy - j <= Game.fruit.get(i).getY() + 150) {
                                    Match = true;
                                } else {
                                    fy = fy - j;
                                    Match = false;
                                }
                            }


                        }

                    }
                }


            } while (Match == true);


        } else {

            fy = (int) Math.floor(Math.random() * (500 - 100 + 1) + 100);
            if (big == true) {
                fy = (int) Math.floor(Math.random() * (450 - 50 + 1) + 50);
            }
        }

        if (Food == 17) {
            fx = 700;
            fy = 350;
        }


        setX(fx);
        setY(fy);
        dying = false;

        //Sets fruit images
        SetFruitImage();


        setpbVisible(true);
        //Determine Sequence directions
        setSequenceDirection();

        pbdest = null;

        visible = true;

        //Makes the PB smaller if HP = 2 or 1
        if (NumberofSequences == 2) {
            ImageIcon pbImage = new ImageIcon(this.getClass().getResource(pressboardImage2));
            pbimage = pbImage.getImage();
        } else if (NumberofSequences == 1) {
            ImageIcon pbImage = new ImageIcon(this.getClass().getResource(pressboardImage3));
            pbimage = pbImage.getImage();
        } else {
            ImageIcon pbImage = new ImageIcon(this.getClass().getResource(pressboardImage));
            pbimage = pbImage.getImage();
        }


        if (heroic == true) {
            RandomBossTimer = (int) Math.floor(Math.random() * (70 - 20 + 1) + 20);
        }

    }

    private void SetFruitImage() {
        try {
            // 1 = A = Apple
            // 2 = M = Mango
            // 3 = B = Banana
            // 4 = G = Grapes
            // 5 = O = Orange
            // 6 = S = Strawberry
            // 7 = W = Watermelon
            // +b at start = Big fruit

            //Initalizes starting fruit pictures
            switch (Food) {
                case 1:
                    if (abnormal == false) {
                        A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Apples.png"));
                    } else {
                        if (big == true) {
                            A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Applesbig.png"));
                            if (Fire == true) {
                                A = Game.Explosion[2];
                            }
                        }
                    }
                    if (Game.AppleEvent == 1) {
                        A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;
                case 2:
                    if (abnormal == false) {
                        M = ImageIO.read(this.getClass().getResource("Pictures/Fruit/mangoes.png"));
                    } else {
                        if (big == true) {
                            M = FImage = ImageIO.read(this.getClass().getResource("Pictures/Fruit/mangoesbig.png"));
                            if (Bomb == true) {
                                M = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoBomb.png"));
                            }
                        }
                    }
                    if (Game.MangoEvent == 1) {
                        // M = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;

                case 3:
                    if (abnormal == false) {
                        B = ImageIO.read(this.getClass().getResource("Pictures/Fruit/bananas.png"));
                    } else {
                        if (big == true) {
                            B = ImageIO.read(this.getClass().getResource("Pictures/Fruit/bananasbig.png"));
                        }
                    }
                    if (Game.BananaEvent == 1) {
                        B = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;
                case 4:
                    if (abnormal == false) {
                        G = ImageIO.read(this.getClass().getResource("Pictures/Fruit/grapess.png"));
                    } else {
                        if (big == true) {
                            G = ImageIO.read(this.getClass().getResource("Pictures/Fruit/grapessbig.png"));
                        }
                    }
                    if (Game.GrapeEvent == 1) {
                        G = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;
                case 5:
                    if (abnormal == false) {
                        O = ImageIO.read(this.getClass().getResource("Pictures/Fruit/oranges.png"));
                    } else {
                        if (big == true) {
                            O = ImageIO.read(this.getClass().getResource("Pictures/Fruit/orangesbig.png"));
                        }
                    }
                    if (Game.OrangeEvent == 1) {
                        O = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;
                case 6:
                    if (abnormal == false) {
                        S = ImageIO.read(this.getClass().getResource("Pictures/Fruit/strawberries.png"));
                    } else {
                        if (big == true) {
                            S = ImageIO.read(this.getClass().getResource("Pictures/Fruit/strawberriesbig.png"));
                        }
                    }
                    if (Game.StrawberryEvent == 1) {
                        S = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    break;
                case 16:
                    SP = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Pirate.png"));
                    break;
                case 7:
                    if (abnormal == false) {
                        W = ImageIO.read(this.getClass().getResource("Pictures/Fruit/watermelons.png"));
                    } else {
                        if (big == true) {
                            W = ImageIO.read(this.getClass().getResource("Pictures/Fruit/watermelonsbig.png"));
                        }
                    }
                    if (Game.WatermelonEvent == 1) {
                        W = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
                    }
                    ////////////////////////////////////////////////////////////////////
                    break;
                case 17:
                    sW = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
                    break;
                case 30:
                    HP = ImageIO.read(this.getClass().getResource("Pictures/Numbers/HP.png"));
                    break;
            }


        } catch (Exception e) {
        }
    }

    private void setSequenceDirection() {
//Determines the direction for the arrow
        //1 = Up
        //2 = Down
        //3 = Left
        //4 = Right

        for (int i = 0; i < NumberofSequences; i++) {
            if (i == 0) {
                if (pbSequence.get(i) == 1) {
                    ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/UpArrow.png"));
                    pbaimage = aImageIcon.getImage();
                } else if (pbSequence.get(i) == 2) {
                    ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/DownArrow.png"));
                    pbaimage = aImageIcon.getImage();
                } else if (pbSequence.get(i) == 3) {
                    ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrow.png"));
                    pbaimage = aImageIcon.getImage();
                } else if (pbSequence.get(i) == 4) {
                    ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrow.png"));
                    pbaimage = aImageIcon.getImage();
                }
            }

            if (i == 1) {
                if (pbSequence.get(i) == 1) {
                    ImageIcon aImageIcon2 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/UpArrowFaded.png"));
                    pbaimage2 = aImageIcon2.getImage();
                }
                if (pbSequence.get(i) == 2) {
                    ImageIcon aImageIcon2 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/DownArrowFaded.png"));
                    pbaimage2 = aImageIcon2.getImage();
                } else if (pbSequence.get(i) == 3) {
                    ImageIcon aImageIcon2 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrowFaded.png"));
                    pbaimage2 = aImageIcon2.getImage();
                } else if (pbSequence.get(i) == 4) {
                    ImageIcon aImageIcon2 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrowFaded.png"));
                    pbaimage2 = aImageIcon2.getImage();
                }
            }
            if (i == 2) {
                if (pbSequence.get(i) == 1) {
                    ImageIcon aImageIcon3 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/UpArrowFaded.png"));
                    pbaimage3 = aImageIcon3.getImage();
                }
                if (pbSequence.get(i) == 2) {
                    ImageIcon aImageIcon3 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/DownArrowFaded.png"));
                    pbaimage3 = aImageIcon3.getImage();
                } else if (pbSequence.get(i) == 3) {
                    ImageIcon aImageIcon3 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrowFaded.png"));
                    pbaimage3 = aImageIcon3.getImage();
                } else if (pbSequence.get(i) == 4) {
                    ImageIcon aImageIcon3 = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrowFaded.png"));
                    pbaimage3 = aImageIcon3.getImage();
                }
            }

        }
    }

    public void act() {

        if (init == true) {
            // 1 = A = Apple
            // 2 = M = Mango
            // 3 = B = Banana
            // 4 = G = Grapes
            // 5 = O = Orange
            // 6 = S = Strawberry
            // 7 = W = Watermelon
            // +b at start = Big fruit

            //Fruit Slice 1 Pictures



            try {
                switch (Food) {
                    case 1:

                        if (abnormal == false) {
                            FImage = Game.AS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS1;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KAS1;
                                } else {
                                    FImage = Game.AKAS1;
                                }

                            }
                        }

                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS1;
                                if (Bomb == true) {
                                    FImage = M;
                                }

                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KMS1;
                                } else {
                                    FImage = Game.AKMS1;
                                }

                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KBS1;
                                } else {
                                    FImage = Game.AKBS1;
                                }

                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KGS1;
                                } else {
                                    FImage = Game.AKGS1;
                                }

                            }
                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KOS1;
                                } else {
                                    FImage = Game.AKOS1;
                                }

                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS1;
                            }
                            if (heroic == true) {
                            }
                        }
                        break;
                    case 16:
                        FImage = Game.SPS1;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KWS1;
                                } else {
                                    FImage = Game.AKWS1;
                                }

                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS1;
                        break;
                    case 30:
                        FImage = Game.HPS1;
                        break;

                }


            } catch (Exception e) {
            }

            init = false;
        }

        if (Food == 16) {
            SpeedIncreaseCounter++;
            if (fdx < 20 && SpeedIncreaseCounter > 4) {
                fdx++;
                SpeedIncreaseCounter = 0;
            }

        }

        if (heroic == true) {

            if (Food == 1 && Game.AppleEvent == -1 && Game.StopFruits == false) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;

                }
                if (BossActTimer > RandomBossTimer && BossAct == 0 && Game.StopFruits == false) {
                    BossAct = 1;
                    AppleAttack = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
                    //  AppleAttack = 4;
                    BossActTimer = 0;

                }
                if (AppleAttack == 1) {


                    if (BossAct == 1 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (BossCounter < 25 && BossActTimer > 5) {
                            AddNewFruit = true;

                            BossCounter++;
                            BossActTimer = 0;
                        }
                        if (BossCounter >= 25) {
                            BossAct = 2;
                        }
                    }
                    if (BossAct == 2 && Game.StopFruits == false) {
                        BossAct = 0;
                        BossCounter = 0;
                        BossActTimer = 0;
                        AppleAttack = 0;
                        RandomBossTimer = 100;
                    }
                }
                if (AppleAttack == 2) {
                    if (BossAct == 1 && Game.StopFruits == false) {
                        BossActTimer++;
                        //  if( BossActTimer > 10){
                        if (BossActTimer > 40) {
                            BossAct = 2;
                            BossCounter = 0;
                            BossActTimer = 0;
                        }
                    }

                    if (BossAct == 2 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (Game.SummonSpinningApple == false && BossCounter < 8 && BossActTimer > 20) {
                            AddNewFruit = true;

                            BossCounter++;
                            BossActTimer = 0;
                        }
                        if (BossCounter >= 8) {
                            BossAct = 3;
                        }
                    }
                    if (BossAct == 3 && Game.StopFruits == false) {
                        BossAct = 0;
                        BossCounter = 0;
                        BossActTimer = 0;
                        RandomBossTimer = 100;
                        AppleAttack = 0;
                    }
                }
                if (AppleAttack == 3) {
                    if (BossAct == 1 && Game.StopFruits == false) {

                        setX(getX() + 10);
                        if (getX() > 820) {
                            BossAct = 2;

                        }

                    }

                    if (BossAct == 2 && Game.StopFruits == false) {
                        BossActTimer++;

                        if (BossActTimer > 40) {
                            BossAct = 3;
                            BossCounter = 0;
                            BossActTimer = 0;
                        }
                    }
                    if (BossAct == 3 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (Game.SummonSwagApple == false && BossCounter < 25 && BossActTimer > 4) {
                            AddNewFruit = true;

                            BossCounter++;
                            BossActTimer = 0;
                        }
                        if (BossCounter >= 25) {
                            BossAct = 4;
                            BossActTimer = 0;
                            BossCounter = 0;
                        }

                    }
                  

                    if (BossAct == 4 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (BossActTimer > 50) {
                            BossAct = 5;
                            BossActTimer = 0;

                        }
                    }

                    if (BossAct == 5 && Game.StopFruits == false) {
                        setX(getX() - 10);
                        if (getX() <= 570) {
                            BossAct = 6;
                        }


                    }
                    if (BossAct == 6) {
                        BossAct = 0;
                        BossCounter = 0;
                        BossActTimer = 0;
                        RandomBossTimer = 100;
                        AppleAttack = 0;
                    }
                }
                if (AppleAttack == 4) {
                    if (BossAct == 1 && Game.StopFruits == false) {
                        BossActTimer++;
                        //  if( BossActTimer > 10){
                        if (BossActTimer > 40) {
                            BossAct = 2;
                            BossCounter = 0;
                            BossActTimer = 0;
                        }
                    }

                    if (BossAct == 2 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (BossActTimer >= 12) {
                            BossCounter += 1;
                            BossActTimer = 0;
                        }
                        if (BossCounter > 15) {//15
                            BossActTimer = 0;
                            BossCounter = 0;
                            BossAct = 3;
                            AppleChargeHit = 0;
                        }
                        if (AppleChargeHit >= 13) {
                            BossActTimer = 0;
                            BossCounter = 0;
                            AppleChargeHit = 0;
                            BossAct = 4;
                        }

                    }
                    if (BossAct == 3 && Game.StopFruits == false) {
                        BossActTimer++;
                        if (BossCounter < 3 && BossActTimer > 10) {
                            AddNewFruit = true;

                            //   BossCounter++;
                            BossActTimer = 0;
                        }
                        if (BossCounter >= 3) {
                            BossAct = 4;
                            BossActTimer = 0;
                            BossCounter = 0;
                            AppleChargeHit = 0;
                        }
                    }
                    if (BossAct == 4 && Game.StopFruits == false) {
                        BossAct = 0;
                        BossCounter = 0;
                        BossActTimer = 0;
                        AppleChargeHit = 0;
                        RandomBossTimer = 100;
                        AppleAttack = 0;

                    }
                }


            }


            if (Food == 2 && Game.MangoEvent == -1) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;


                }
                if (BossActTimer > RandomBossTimer && BossAct == 0) {
                    BossAct = 1;

                    BossActTimer = 0;

                }
                if (BossAct == 1 && Game.StopFruits == false) {
                    BossActTimer++;
                    setX(getX() + 10);
                    if (getX() > 1000) {
                        BossAct = 2;

                    }
                }
                if (BossAct == 2 && Game.StopFruits == false) {
                    BossActTimer++;

                    if (BossActTimer > 30) {

                        AddNewFruit = true;

                        BossCounter++;
                        BossActTimer = 0;
                        //    BossAct = 3;
                    }

                }
                if (BossAct == 3 && Game.StopFruits == false) {
                   BossActTimer++;
                    if (BossActTimer > 20) {
                        BossAct = 4;
                        BossActTimer = 0;
                        BossCounter = 0;

                    }


                }
                if (BossAct == 4 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (AddNewFruit == false && BossCounter < 8 && BossActTimer > 20) {
                        AddNewFruit = true;
                        BossCounter++;
                        BossActTimer = 0;
                    }
                    if (BossCounter >= 8) {

                        AddNewFruit = false;
                        BossAct = 5;
                    }
                }

                if (BossAct == 5 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (BossActTimer > 30) {
                        BossAct++;

                    }


                }

                if (BossAct == 6 && Game.StopFruits == false) {
                    setX(getX() - 10);
                    if (getX() <= 630) {
                        BossAct = 7;
                    }
                }
                if (BossAct == 7 && Game.StopFruits == false) {

                    Game.GiantMangoAttack = false;
                    BossAct = 0;
                    BossCounter = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (300 - 200 + 1) + 200);


                }


            }



            if (Food == 3 && Game.BananaEvent == -1) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;

                }
                if (BossActTimer > RandomBossTimer && BossAct == 0) {
                    BossAct = 1;

                    BossActTimer = 0;

                }
                if (BossAct == 1 && Game.StopFruits == false) {

                    setX(getX() + 5);
                    if (getX() > 900) {
                        BossAct = 2;

                    }

                }

                if (BossAct == 2 && Game.StopFruits == false) {
                    BossActTimer++;
                    //  if( BossActTimer > 10){
                    if (BossActTimer > 40) {
                        BossAct = 3;
                        BossCounter = 0;
                        BossActTimer = 0;
                    }
                }
                if (BossAct == 3 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (Game.SummonSwagBanana == false && BossCounter < 25 && BossActTimer > 7) {
                        AddNewFruit = true;

                        BossCounter++;
                        BossActTimer = 0;
                    }
                    if (BossCounter >= 25) {
                        BossAct = 4;
                        BossActTimer = 0;
                        BossCounter = 0;
                    }

                }

                if (BossAct == 4 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (BossActTimer > 50) {
                        BossAct = 5;
                        BossActTimer = 0;

                    }
                }

                if (BossAct == 5 && Game.StopFruits == false) {
                    setX(getX() - 5);
                    if (getX() <= 630) {
                        BossAct = 6;
                    }


                }
                if (BossAct == 6) {
                    BossAct = 0;
                    BossCounter = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (400 - 300 + 1) + 300);
                }


            }
            if (Food == 4 && Game.GrapeEvent == -1 && Game.StopFruits == false) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;

                }
                if (BossActTimer > RandomBossTimer && BossAct == 0 && Game.StopFruits == false) {
                    BossAct = 1;

                    BossActTimer = 0;

                }
                if (BossAct == 1 && Game.StopFruits == false) {
                    BossActTimer++;
                    //  if( BossActTimer > 10){
                    if (BossActTimer > 40) {
                        BossAct = 2;
                        BossCounter = 0;
                        BossActTimer = 0;
                    }
                }
                if (BossAct == 2 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (Game.SummonSwirlingGrape == false && BossCounter < 4 && BossActTimer > 70) {
                        AddNewFruit = true;

                        BossCounter++;
                        BossActTimer = 0;
                    }
                    if (BossCounter >= 4) {
                        BossAct = 3;
                    }
                }
                if (BossAct == 3 && Game.StopFruits == false) {
                    BossAct = 0;
                    BossCounter = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (300 - 150 + 1) + 150);

                }


            }
            if (Food == 5 && Game.OrangeEvent == -1) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;


                }
                if (BossActTimer > RandomBossTimer && BossAct == 0) {
                    BossAct = 1;

                    BossActTimer = 0;

                }
                if (BossAct == 1 && Game.StopFruits == false) {
                    BossActTimer++;
                    //  if( BossActTimer > 10){
                    if (BossActTimer > 40) {
                        BossAct = 2;
                        BossCounter = 0;
                        BossActTimer = 0;
                    }
                }
                if (BossAct == 2 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (Game.SummonSpinningOrange == false && BossCounter < 3 && BossActTimer > 20) {
                        AddNewFruit = true;

                        BossCounter++;
                        BossActTimer = 0;
                    }
                    if (BossCounter >= 3) {
                        BossAct = 3;
                    }
                }
                if (BossAct == 3 && Game.StopFruits == false) {
                    BossAct = 0;
                    BossCounter = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (200 - 150 + 1) + 150);

                }


            }
            if (Food == 6 && Game.StrawberryEvent == -1) {
                if (fdx == 0 && Game.StopFruits == false && BossAct == 0) {
                    BossActTimer++;


                }
                if (BossActTimer > RandomBossTimer && BossAct == 0 && Game.StopFruits == false) {
                    BossAct = 1;

                    BossActTimer = 0;

                }
                if (BossAct == 1 && Game.StopFruits == false) {
                    BossActTimer++;
                    //  if( BossActTimer > 10){
                    if (BossActTimer > 40) {
                        BossAct = 2;
                        BossCounter = 0;
                        BossActTimer = 0;
                    }
                }
                if (BossAct == 2 && Game.StopFruits == false) {
                    BossActTimer++;
                    if (Game.SummonAPirate == false && BossCounter < 5 && BossActTimer > 20) {
                        AddNewFruit = true;
                        Game.SummonAPirate = true;
                        BossCounter++;
                        BossActTimer = 0;
                    }
                    if (BossCounter >= 5) {
                        BossAct = 3;
                    }
                }
                if (BossAct == 3 && Game.StopFruits == false) {
                    BossAct = 0;
                    BossCounter = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (300 - 200 + 1) + 200);



                }


            }

            if (Food == 7 && Game.WatermelonEvent == -1) {
                if (fdx == 0 && Game.StopFruits == false) {
                    BossActTimer++;

                }

                if (BossActTimer > RandomBossTimer && BossAct == 0 && Game.StopFruits == false) {
                    BossAct = 1;

                    BossActTimer = 0;
                }


                if (BossActTimer > 30 && BossAct == 1 && Game.StopFruits == false) {
                    BossAct++;
                    AddNewFruit = true;
                    BossActTimer = 0;

                }
                if (BossActTimer > 10 && BossAct == 2 && Game.StopFruits == false) {
                    BossAct++;
                    AddNewFruit = true;
                    BossActTimer = 0;

                }
                if (BossActTimer > 10 && BossAct == 3 && Game.StopFruits == false) {
                    BossAct++;
                    AddNewFruit = true;
                    BossActTimer = 0;

                }
                if (BossActTimer > 10 && BossAct == 4 && Game.StopFruits == false) {
                    BossAct = 0;
                    BossActTimer = 0;
                    RandomBossTimer = (int) Math.floor(Math.random() * (70 - 20 + 1) + 20);

                }



            } else if (Food == 6 && Game.StrawberryEvent == -1) {
            }


        }



        if (Game.ninja.getUltiAct() == 3) {


            if (NumberofSequences - 3 <= 0) {
                setDying(true);
            } else {
                this.setIsHit(true);
            }

            switch (Food) {
                case 1:
                    if (abnormal == false) {
                        FImage = Game.AS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bAS1;
                            if (Fire == true) {
                                FImage = Game.Explosion[2];
                            }
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KAS1;
                            } else {
                                FImage = Game.AKAS1;
                            }
                        }
                    }

                    break;
                case 2:
                    if (abnormal == false) {
                        FImage = Game.MS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bMS1;
                            if (Bomb == true) {
                                FImage = M;
                            }
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KMS1;
                            } else {
                                FImage = Game.AKMS1;
                            }
                        }
                    }
                    break;
                case 3:
                    if (abnormal == false) {
                        FImage = Game.BS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bBS1;
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KBS1;
                            } else {
                                FImage = Game.AKBS1;
                            }
                        }
                    }
                    break;
                case 4:
                    if (abnormal == false) {
                        FImage = Game.GS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bGS1;
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KGS1;
                            } else {
                                FImage = Game.AKGS1;
                            }
                        }

                    }
                    break;
                case 5:
                    if (abnormal == false) {
                        FImage = Game.OS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bOS1;
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KOS1;
                            } else {
                                FImage = Game.AKOS1;
                            }
                        }
                    }
                    break;
                case 6:
                    if (abnormal == false) {
                        FImage = Game.SS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bSS1;
                        }
                        if (heroic == true) {
                        }
                    }
                    break;
                case 16:
                    FImage = Game.SPS1;
                    break;
                case 7:
                    if (abnormal == false) {
                        FImage = Game.WS1;
                    } else {

                        if (big == true) {
                            FImage = Game.bWS1;
                        }
                        if (heroic == true) {
                            if (BossAct < 1) {
                                FImage = Game.KWS1;
                            } else {
                                FImage = Game.AKWS1;
                            }
                        }
                    }
                    break;
                case 17:
                    FImage = Game.sWS1;
                    break;
                case 30:
                    FImage = Game.HPS1;
                    break;
            }



        }

        //Moves the fruit Left
        if (Game.StopFruits == false && Spinning == false) {
            this.setX(this.getX() - fdx);
        }
        //Exception movers
        //Fire from the apple
        if (Fire == true) {
            FireHit++;
        }
        if (Fire == true && getX() + 400 < 0) {
            setDying(true);
            DyingTimer = 8;
        }
        //Spinning fruit
        if (Spinning == true) {
            if (SpinAct == 0) {
                SpinAct = 1;
                SpinInitX = 690;
                SpinInitY = 320;

            }
            if (SpinAct == 1 && Game.StopFruits == false) {

                SpinSpeed += 0.10;

                SpinIncrease += 2.40;

                setX(SpinInitX + (int) (SpinIncrease * Math.sin(SpinSpeed)));
                setY(SpinInitY + (int) (SpinIncrease * Math.cos(SpinSpeed)));

            }

        }
        //Swirling fruit
        if (Swirling == true && Game.StopFruits == false) {
            SwirlLength += 0.20;
            if (SwirlNumber == 1) {
                setY((int) (InitialY + 100 * Math.sin(SwirlLength)));
            }
            if (SwirlNumber == 2) {
                setY((int) (InitialY + 100 * Math.sin(-SwirlLength)));
            }
            if (getX() < Game.ninja.getX() + 50) {
                fdx = 20;
            }
        }
        //Bomb Mango
        if (Bomb == true && getX() <= 420) {
            fdx = 0;
        }
        if (Bomb == true && fdx == 0 && Explode == false && Game.StopFruits == false) {
            BombTimer++;
            if (BombTimer > 75) {
                Explode = true;
                BombTimer = 0;
                setDying(true);
                NumberofSequences = 0;
            }
        }
        //Exploding bomb mango
        if (Explode == true) {
            if (getX() != 200 && getY() != 350) {
                setX(200);
                setY(350);
                M = Game.Explosion[0];
                FImage = Game.Explosion[0];
            }
            //Bomb Frames
            BombTimer++;
            if (BombTimer < 5) {
                M = Game.Explosion[0];
                FImage = Game.Explosion[0];
            }
            if (BombTimer >= 5) {
                M = Game.Explosion[1];
                FImage = Game.Explosion[1];
            }
            if (BombTimer > 10) {
                M = Game.Explosion[2];
                FImage = Game.Explosion[2];
            }
            if (BombTimer > 15) {
                M = Game.Explosion[3];
                FImage = Game.Explosion[3];
            }
            if (BombTimer > 20) {
                M = Game.Explosion[4];
                FImage = Game.Explosion[4];
            }
            if (BombTimer > 25) {
                M = Game.Explosion[5];
                FImage = Game.Explosion[5];
            }
        }
        //Calculates time required to fall
        if (fdx != 0 && Game.StopFruits == false) {
            TimeFall = (this.getX() - 190) / fdx;
        }
        //Falling fruit onto ninja man
        if (TimeFall < 12 && fdx != 0 && Game.StopFruits == false && Fire == false) {

            if (this.getY() < 800) {
                fdy += 2;
                this.setY(this.getY() + fdy);

            } else {
            }

        }

        //Heroic stance
        if (heroic == true) {
            if (Food == 1) {
                if (this.getX() < 570) {
                    fdx = 0;
                }
            } else {
                if (this.getX() < 630) {
                    fdx = 0;
                }
            }


        }


        //IF fruit is dying :(
        if (this.isDying() == true && Game.ninja.getUltiAct() != 3) {
            isHit = false;

            DyingTimer++;
            if (heroic == true) {
                BossAct = 0;
                BossActTimer = 0;
                if (Food == 7) {
                    Game.SummonASeed = false;
                    AddNewFruit = false;
                }

            }


            if (DyingTimer >= 1 && Game.ninja.getUltiAct() != 3) {


                //Fruit Slice 1 Pictures
                switch (Food) {
                    case 1:
                        if (abnormal == false) {
                            FImage = Game.AS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS1;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KAS1;
                                } else {
                                    FImage = Game.AKAS1;
                                }
                            }
                        }

                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS1;
                                if (Bomb == true) {
                                    FImage = M;
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KMS1;
                                } else {
                                    FImage = Game.AKMS1;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KBS1;
                                } else {
                                    FImage = Game.AKBS1;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KGS1;
                                } else {
                                    FImage = Game.AKGS1;
                                }
                            }

                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KOS1;
                                } else {
                                    FImage = Game.AKOS1;
                                }
                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS1;
                            }
                            if (heroic == true) {
                            }
                        }
                        break;
                    case 16:
                        FImage = Game.SPS1;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KWS1;
                                } else {
                                    FImage = Game.AKWS1;
                                }
                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS1;
                        break;
                    case 30:
                        FImage = Game.HPS1;
                        break;
                }


            }
            //Fruit Slice pictures 2
            if (DyingTimer >= 3 && Game.ninja.getUltiAct() != 3) {


                switch (Food) {
                    case 1:
                        if (abnormal == false) {
                            FImage = Game.AS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS2;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KAS2;
                                } else {
                                    FImage = Game.AKAS2;
                                }
                            }
                        }

                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS2;
                                if (Bomb == true) {
                                    FImage = M;
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KMS2;
                                } else {
                                    FImage = Game.AKMS2;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS2;

                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KBS2;
                                } else {
                                    FImage = Game.AKBS2;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KGS2;
                                } else {
                                    FImage = Game.AKGS2;
                                }
                            }
                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KOS2;
                                } else {
                                    FImage = Game.AKOS2;
                                }
                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS2;
                            }
                            if (heroic == true) {
                            }


                        }
                        break;
                    case 16:
                        FImage = Game.SPS2;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KWS2;
                                } else {
                                    FImage = Game.AKWS2;
                                }
                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS2;
                        break;
                    case 30:
                        FImage = Game.HPS2;
                        break;
                }

            }
            //Fruit cut in half :( RIP
            if (DyingTimer >= 5 && Game.ninja.getUltiAct() != 3) {



                switch (Food) {
                    case 1:
                        if (abnormal == false) {
                            FImage = Game.AS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS3;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                FImage = Game.KAS3;
                            }
                        }
                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS3;
                                if (Bomb == true) {
                                    FImage = M;
                                }
                            }
                            if (heroic == true) {
                                FImage = Game.KMS3;
                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS3;
                            }
                            if (heroic == true) {
                                FImage = Game.KBS3;
                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS3;
                            }
                            if (heroic == true) {
                                FImage = Game.KGS3;
                            }
                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS3;
                            }
                            if (heroic == true) {
                                FImage = Game.KOS3;
                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS3;
                            }
                            if (heroic == true) {
                                FImage = Game.KSS3;
                            }
                        }
                        break;
                    case 16:
                        FImage = Game.SPS3;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS3;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS3;
                            }
                            if (heroic == true) {
                                FImage = Game.KWS3;
                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS3;
                        break;
                    case 30:
                        FImage = Game.HPS3;
                        break;
                }
            }
        }

        //When Fruit is hit
        if (isHit == true && Game.ninja.UltiAct != 3) {

            isHitTimer++;
            //Fruit Slice 1
            if (isHitTimer >= 1) {

                switch (Food) {
                    case 1:
                        if (abnormal == false) {
                            FImage = Game.AS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS1;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KAS1;
                                } else {
                                    FImage = Game.AKAS1;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS1;
                                if (Bomb == true) {
                                    FImage = M;
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                
                                } else {
                             
                                }
                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KBS1;
                                } else {
                                    FImage = Game.AKBS1;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KGS1;
                                } else {
                                    FImage = Game.AKGS1;
                                }
                            }
                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KOS1;
                                } else {
                                    FImage = Game.AKOS1;
                                }
                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS1;
                            }
                            if (heroic == true) {
                            }
                        }
                        break;
                    case 16:
                        FImage = Game.SPS1;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS1;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS1;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KWS1;
                                } else {
                                    FImage = Game.AKWS1;
                                }
                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS1;
                        break;
                    case 30:
                        FImage = Game.HPS1;
                        break;
                }
            }
            //Fruit Slice 2
            if (isHitTimer >= 3 && Game.ninja.UltiAct != 3) {
                switch (Food) {
                    case 1:
                        if (abnormal == false) {
                            FImage = Game.AS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bAS2;
                                if (Fire == true) {
                                    FImage = Game.Explosion[2];
                                }
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KAS2;
                                } else {
                                    FImage = Game.AKAS2;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (abnormal == false) {
                            FImage = Game.MS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bMS2;
                                if (Bomb == true) {
                                    FImage = M;
                                }

                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                 
                                } else {
                                  
                                }
                            }
                        }
                        break;
                    case 3:
                        if (abnormal == false) {
                            FImage = Game.BS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bBS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KBS2;
                                } else {
                                    FImage = Game.AKBS2;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (abnormal == false) {
                            FImage = Game.GS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bGS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KGS2;
                                } else {
                                    FImage = Game.AKGS2;
                                }
                            }
                        }
                        break;
                    case 5:
                        if (abnormal == false) {
                            FImage = Game.OS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bOS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KOS2;
                                } else {
                                    FImage = Game.AKOS2;
                                }
                            }
                        }
                        break;
                    case 6:
                        if (abnormal == false) {
                            FImage = Game.SS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bSS2;
                            }
                            if (heroic == true) {
                            }
                        }
                        break;
                    case 16:
                        FImage = Game.SPS2;
                        break;
                    case 7:
                        if (abnormal == false) {
                            FImage = Game.WS2;
                        } else {

                            if (big == true) {
                                FImage = Game.bWS2;
                            }
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = Game.KWS2;
                                } else {
                                    FImage = Game.AKWS2;
                                }
                            }
                        }
                        break;
                    case 17:
                        FImage = Game.sWS2;
                        break;
                    case 30:
                        FImage = Game.HPS2;
                        break;
                }
            }
            //After the slicing, return to normal state
            if (isHitTimer >= 5 && Game.ninja.UltiAct != 3) {
                try {

                    switch (Food) {
                        case 1:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = A;
                                } else {
                                    FImage = Game.AKAI;
                                }
                            } else {
                                FImage = A;
                            }

                            break;
                        case 2:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = M;
                                } else {
                                    FImage = Game.AKMI;
                                }
                            } else {
                                FImage = M;
                                if (Bomb == true) {
                                    FImage = M;
                                }
                            }

                            break;
                        case 3:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = B;
                                } else {
                                    FImage = Game.AKBI;
                                }
                            } else {
                                FImage = B;
                            }

                            break;
                        case 4:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = G;
                                } else {
                                    FImage = Game.AKGI;
                                }
                            } else {
                                FImage = G;
                            }

                            break;
                        case 5:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = O;
                                } else {
                                    FImage = Game.AKOI;
                                }
                            } else {
                                FImage = O;
                            }

                            break;
                        case 6:
                            if (heroic == true) {
                                FImage = S;
                            }
                            FImage = S;

                            break;
                        case 16:
                            FImage = SP;
                            break;
                        case 7:
                            if (heroic == true) {
                                if (BossAct < 1) {
                                    FImage = W;
                                } else {
                                    FImage = Game.AKWI;
                                }
                            } else {
                                FImage = W;
                            }



                            break;
                        case 17:
                            FImage = sW;
                            break;
                        case 30:
                            FImage = Game.HPp2;
                            break;
                    }
                } catch (Exception e) {
                }
            }
        }

        //pb Act -------------------------------------------------------------

        //Pressboard act

        //If next Sequence
        if (pbnextSequence == true) {

            //Arrow animation when pressed key
            ArrowOffset += 1;
            ArrowOffset2 += 10;
            ArrowOffset3 += 5;

            //Stuff
            if (NumberofSequences > -1) {
                if (getSequence(0) == 1) {
                    pbdest = Game.UpArrowImage.getSubimage(ArrowOffset * 10, 0, 90 - ArrowOffset * 10, 90);
                } else if (getSequence(0) == 2) {
                    pbdest = Game.DownArrowImage.getSubimage(ArrowOffset * 10, 0, 90 - ArrowOffset * 10, 90);
                } else if (getSequence(0) == 3) {
                    pbdest = Game.LeftArrowImage.getSubimage(ArrowOffset * 10, 0, 90 - ArrowOffset * 10, 90);
                } else if (getSequence(0) == 4) {
                    pbdest = Game.RightArrowImage.getSubimage(ArrowOffset * 10, 0, 90 - ArrowOffset * 10, 90);


                }

                //More stuff
                ImageIcon Cropped = new ImageIcon(pbdest);
                setpbaImage(Cropped.getImage());

                if (ArrowOffset >= 8) {
                    //Stops the animation
                    pbnextSequence = false;
                    ArrowOffset = 0;
                    ArrowOffset2 = 0;
                    ArrowOffset3 = 0;
                    setSequenceDirection();
                    if (NumberofSequences == 2) {
                        ImageIcon pbImage = new ImageIcon(this.getClass().getResource(pressboardImage2));
                        pbimage = pbImage.getImage();
                    } else if (NumberofSequences == 1) {
                        ImageIcon pbImage = new ImageIcon(this.getClass().getResource(pressboardImage3));
                        pbimage = pbImage.getImage();
                    }
                }
            }
        }


    }

    //Fruit Functions, most are pretty self-explanitory
    public void setFirstSequence(int Seq) {
        pbSequence.set(0, Seq);
        setSequenceDirection();
    }

    public BufferedImage getImageIcon() {
        return FImage;
    }

    public void setImageIcon(BufferedImage image) {
        FImage = image;
    }

    public void setFood(int food) {
        this.Food = food;
    }

    public void setIsHit(boolean hit) {
        isHit = hit;
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setIsHitTimer(int hit) {
        isHitTimer = hit;
    }

    public boolean getAttacked() {
        return Attacked;
    }

    public void setAttacked(boolean attack) {
        Attacked = attack;
    }

    public Integer getIsHitTimer() {
        return isHitTimer;
    }

    public Integer getFood() {
        return Food;
    }

    //pb functions
    public void RemoveSequence(int sequence) {
        pbSequence.remove(sequence);
    }

    public void setSequence(int index, int sequence) {
        pbSequence.set(index, sequence);

    }

    public Boolean getNextSequence() {
        return pbnextSequence;

    }

    public void setNextSequence(Boolean seq) {
        pbnextSequence = seq;

    }

    public Integer getTemp() {
        return pbTemp;

    }

    public void setTemp(int temp) {
        pbTemp = temp;

    }

    public Integer getSequence(int index) {
        return pbSequence.get(index);
    }

    public Integer getNumberofSequences() {
        return NumberofSequences;
    }

    public void setNumberofSequences(int number) {
        NumberofSequences = number;
    }

    public void setpbImage(Image image) {
        this.pbimage = image;
    }

    public Image getpbImage() {
        return pbimage;
    }

    public void setpbaImage(Image image) {
        this.pbaimage = image;
    }

    public Image getpbaImage() {
        return pbaimage;
    }

    public void setpbVisible(boolean vis) {
        this.pbvisible = vis;
    }

    public Boolean getpbVisible() {
        return pbvisible;
    }

    public void setpbaImage2(Image image) {
        this.pbaimage2 = image;
    }

    public Image getpbaImage2() {
        return pbaimage2;
    }

    public void setpbaImage3(Image image) {
        this.pbaimage3 = image;
    }

    public Image getpbaImage3() {
        return pbaimage3;
    }

    public Integer getArrowOffset() {
        return ArrowOffset;

    }

    public Integer getArrowOffset2() {
        return ArrowOffset2;

    }

    public Integer getArrowOffset3() {
        return ArrowOffset3;

    }

    public void reSS() {
        SS = String.valueOf(NumberofSequences);
    }

    public String getSS() {
        return SS;
    }

    private Image ScaledImage(Image img, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage((Image) img, 0, 0, w, h, null);

        return resizedImage;
    }

    private BufferedImage cropImage(BufferedImage src, Rectangle rect) {
        BufferedImage dest = src.getSubimage(0, 0, rect.width, rect.height);
        return dest;
    }

    public void setX(int x) {
        this.fx = x;
    }

    public void setY(int y) {
        this.fy = y;
    }

    public int getY() {
        return fy;
    }

    public int getX() {
        return fx;
    }

    public void setfdX(int x) {
        this.fdx = x;
    }

    public int getdX() {
        return fdx;
    }

    public void setAbnormal(boolean Abnormal) {
        this.abnormal = Abnormal;
    }

    public Boolean getAbnormal() {
        return abnormal;
    }

    public void setBig(boolean Big) {
        this.big = Big;
    }

    public Boolean getBig() {
        return big;
    }

    public void setHeroic(boolean Heroic) {
        this.heroic = Heroic;

    }

    public Boolean getHeroic() {
        return heroic;
    }

    public void setBossAct(int act) {
        this.BossAct = act;

    }

    public int getBossAct() {
        return BossAct;
    }

    public void setAddNewFruit(boolean Heroic) {
        this.AddNewFruit = Heroic;

    }

    public Boolean getAddNewFruit() {
        return AddNewFruit;
    }

    public void addupHL() {
        upHL = true;
        ImageIcon aImageIcon = Game.UpArrowImageHL;
        pbaimage = aImageIcon.getImage();

    }

    public void adddownHL() {
        downHL = true;
        ImageIcon aImageIcon = Game.DownArrowImageHL;
        pbaimage = aImageIcon.getImage();

    }

    public void addleftHL() {
        leftHL = true;
        ImageIcon aImageIcon = Game.LeftArrowImageHL;
        pbaimage = aImageIcon.getImage();


    }

    public void addrightHL() {
        rightHL = true;
        ImageIcon aImageIcon = Game.RightArrowImageHL;
        pbaimage = aImageIcon.getImage();
    }

    public void removeupHL() {
        upHL = false;
        ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/UpArrow.png"));
        pbaimage = aImageIcon.getImage();

    }

    public void removedownHL() {
        downHL = false;
        ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/DownArrow.png"));
        pbaimage = aImageIcon.getImage();

    }

    public void removeleftHL() {

        leftHL = false;
        ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/LeftArrow.png"));
        pbaimage = aImageIcon.getImage();

    }

    public void removerightHL() {

        rightHL = false;
        ImageIcon aImageIcon = new ImageIcon(this.getClass().getResource("Pictures/Pressboard/RightArrow.png"));
        pbaimage = aImageIcon.getImage();

    }

    public void setupHL(boolean hl) {
        this.upHL = hl;

    }

    public boolean getupHL() {
        return upHL;
    }

    public void setdownHL(boolean hl) {
        this.downHL = hl;
    }

    public boolean getdownHL() {
        return downHL;
    }

    public void setleftHL(boolean hl) {
        this.leftHL = hl;
    }

    public boolean getleftHL() {
        return leftHL;
    }

    public void setrightHL(boolean hl) {
        this.rightHL = hl;
    }

    public boolean getrightHL() {
        return rightHL;
    }

    public void setSpinning(boolean spinning) {
        this.Spinning = spinning;
    }

    public boolean getSpinning() {
        return Spinning;
    }

    public void setSwirling(boolean swirling) {
        this.Swirling = swirling;
    }

    public boolean getSwirling() {
        return Swirling;
    }

    public void setSwirlNumber(int swirlingnumber) {
        this.SwirlNumber = swirlingnumber;
    }

    public int getSwirlNumber() {
        return SwirlNumber;
    }

    public void setInitialY(int yy) {
        this.InitialY = yy;
    }

    public int getInitialY() {
        return InitialY;
    }

    public void setSwag(boolean swag) {
        this.Swag = swag;
    }

    public boolean getSwag() {
        return Swag;
    }

    public void setBomb(boolean bomb) {
        this.Bomb = bomb;
    }

    public boolean getBomb() {
        return Bomb;
    }

    public void setExplode(boolean explode) {
        this.Explode = explode;
    }

    public boolean getFire() {
        return Fire;
    }

    public void setFire(boolean fire) {
        this.Fire = fire;
    }

    public boolean getExplode() {
        return Explode;
    }

    public void setAppleAttack(int attack) {
        this.AppleAttack = attack;
    }

    public int getAppleAttack() {
        return AppleAttack;
    }

    public void setBombTimer(int timer) {
        this.BombTimer = timer;
    }

    public int getBombTimer() {
        return BombTimer;
    }

    public void setActTimer(int timer) {
        this.BossActTimer = timer;
    }

    public int getActTimer() {
        return BossActTimer;
    }

    public void setBossCounter(int BossActCounter) {
        this.BossCounter = BossActCounter;
    }

    public int getBossCounter() {
        return BossCounter;
    }

    public void setFireHit(int hit) {
        this.FireHit = hit;
    }

    public int getFireHit() {
        return FireHit;
    }

    public void setAppleChargeHit(int hit) {
        this.AppleChargeHit = hit;
    }

    public int getAppleChargeHit() {
        return AppleChargeHit;
    }

    //Determines the fruit states
    private void FruitStats() {


        //King stats
        // if (Game.TutorialEvent < 1) {
        //WatermelonBoss stats
        if (Game.WatermelonEvent == 1) {

            heroic = true;
            abnormal = true;
            Food = 7;
            try {
                W = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingWatermelon.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }

            NumberofSequences = 30;
         //       NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }

            //Watermelon seed
        } else if (Game.SummonASeed == true) {

            Food = 17;
            try {
                sW = ImageIO.read(this.getClass().getResource("Pictures/Fruit/WSeed.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Game.SummonASeed = false;
            fdx = 10;



//Strawberry Stats
        } else if (Game.StrawberryEvent == 1) {
            Food = 6;
            heroic = true;
            abnormal = true;
            try {
                S = ImageIO.read(this.getClass().getResource("Pictures/Fruit/KingStrawberry.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 40;
           //  NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            //Pirate
        } else if (Game.SummonAPirate == true) {
            Food = 16;
            setY(200);
            try {
                SP = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Pirate.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 2;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Game.SummonAPirate = false;
            fdx = 0;
            //Orange Boss
        } else if (Game.OrangeEvent == 1) {
            Food = 5;
            heroic = true;
            abnormal = true;
            try {
                O = ImageIO.read(this.getClass().getResource("Pictures/Fruit/OrangeBoss.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 60;
          //   NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            //Spinning ORange
        } else if (Game.SummonSpinningOrange == true) {
            Food = 5;

            try {
                O = ImageIO.read(this.getClass().getResource("Pictures/Fruit/oranges.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 3;
            // NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }

            Game.SummonSpinningOrange = false;

            //Grape boss
        } else if (Game.GrapeEvent == 1) {
            Food = 4;
            heroic = true;
            abnormal = true;
            try {
                G = ImageIO.read(this.getClass().getResource("Pictures/Fruit/GrapeCute.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 75;
             //NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            //Swirling grape
        } else if (Game.SummonSwirlingGrape == true) {
            Food = 4;
            Game.SummonSwirlingAct++;
            try {
                G = ImageIO.read(this.getClass().getResource("Pictures/Fruit/grapess.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 2;
            // NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            fdx = 8;
            Game.SummonSwirlingGrape = false;

            //BananaBoss
        } else if (Game.BananaEvent == 1) {
            Food = 3;
            heroic = true;
            abnormal = true;
            try {
                B = ImageIO.read(this.getClass().getResource("Pictures/Fruit/BananaBoss.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 80;
           //  NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            //Swag banana
        } else if (Game.SummonSwagBanana) {

            Food = 3;
            try {
                B = ImageIO.read(this.getClass().getResource("Pictures/Fruit/bananas.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 1;

            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Game.SummonSwagBanana = false;
            setY(300);
            Swag = true;
            fdx = 10;

            //Mango Boss
        } else if (Game.MangoEvent == 1) {
            Food = 2;
            heroic = true;
            abnormal = true;
            try {
                M = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoBoss.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 100;
          //   NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            //Bomb
        } else if (Game.SummonABomb == true) {

            Food = 2;
            abnormal = true;
            big = true;
            try {
                M = ImageIO.read(this.getClass().getResource("Pictures/Fruit/MangoBomb.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 10;

            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Game.SummonABomb = false;
            Bomb = true;
            setY(400);
            Bomb = true;
            fdx = 10;
            //Apple King
        } else if (Game.AppleEvent == 1) {
            Food = 1;
            heroic = true;
            abnormal = true;
            try {
                A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/AppleBoss.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 150;
           //  NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }

            //Spinning Apple
        } else if (Game.SummonSpinningApple == true) {
            Food = 1;

            try {
                A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Apples.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 2;
            // NumberofSequences = 1;
            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }

            Game.SummonSpinningApple = false;

            //Swag apple
        } else if (Game.SummonSwagApple == true) {
            Food = 1;
            try {
                A = ImageIO.read(this.getClass().getResource("Pictures/Fruit/Apples.png"));
            } catch (IOException ex) {
                Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberofSequences = 1;

            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Game.SummonSwagApple = false;
            setY(380);
            setX(900);
            //Swag = true;
            fdx = 12;

            //Fire
        } else if (Game.SummonFire == true) {
            Food = 1;
            big = true;
            abnormal = true;
            A = Game.Explosion[2];

            NumberofSequences = 3;

            SS = String.valueOf(NumberofSequences);
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
            }
            Fire = true;
            Game.SummonFire = false;
            setY(280);
            setX(600);

            fdx = 25;

        } else {
            //Normal fruit and big states

            //Determines whether or not big
            int DetermineBig = 0;

            if (Game.WatermelonEvent != -1 && Game.TutorialEvent < 1 && Game.StrawberryEvent != -1 && Game.StrawberryEvent != -1 && Game.OrangeEvent != -1 && Game.GrapeEvent != -1 && Game.BananaEvent != -1 && Game.MangoEvent != -1 && Game.AppleEvent != -1 || Game.TutorialEvent == 8) {
                if (Food != 30) {
                    DetermineBig = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                    if (Game.TutorialEvent == 8) {
                        DetermineBig = 1;
                    }
                    if (DetermineBig == 1) {
                        abnormal = true;
                        big = true;
                    }
                }

            }

            int Health = 0;
            int Speed = 0;
            //Applies stats
            if (abnormal == false) {
                Health = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

                if (Health == 1) {
                    Speed = (int) Math.floor(Math.random() * (15 - 10 + 1) + 10);
                } else if (Health == 2) {
                    Speed = (int) Math.floor(Math.random() * (13 - 7 + 1) + 7);
                } else {
                    Speed = (int) Math.floor(Math.random() * (10 - 5 + 1) + 5);
                }
            } else {

                if (big == true) {
                    Health = (int) Math.floor(Math.random() * (6 - 4 + 1) + 4);

                    if (Health == 4) {
                        Speed = (int) Math.floor(Math.random() * (6 - 3 + 1) + 3);
                    } else if (Health == 5) {
                        Speed = (int) Math.floor(Math.random() * (5 - 3 + 1) + 3);
                    } else {
                        Speed = (int) Math.floor(Math.random() * (3 - 2 + 1) + 2);
                    }
                }
            }

            // Speed = 2;
            // Health = 5;
            if (Game.GiantMangoAttack == true) {
                big = true;
                abnormal = true;
                Speed = 6;
                Health = 5;
            }
            //Exceptions
            if (Game.WatermelonEvent == -1 || Game.StrawberryEvent == -1 || Game.StrawberryEvent == -1 || Game.OrangeEvent == -1 || Game.GrapeEvent == -1 || Game.BananaEvent == -1 || Game.MangoEvent == -1 && Game.GiantMangoAttack == false || Game.AppleEvent == -1) {
                if (Health >= 2) {
                    Health = 1;
                }
                if (Speed >= 9) {
                    Speed = 8;
                }
            }
            if (Food == 30) {
                Health = 3;
                Speed += 5;

                if (Game.WatermelonEvent == -1 || Game.StrawberryEvent == -1 || Game.StrawberryEvent == -1 || Game.OrangeEvent == -1 || Game.GrapeEvent == -1 || Game.BananaEvent == -1 || Game.MangoEvent == -1 && Game.GiantMangoAttack == false || Game.AppleEvent == -1) {
                    Health = 1;
                }
            }
            //Get the number of health in a string for HP thing
            if (Health > 3) {

                SS = String.valueOf(Health);
            }

            if (Game.TutorialEvent == 5) {
                Health = 1;
            }

            fdx = Speed;
            //Health = 3;
            NumberofSequences = Health;

            //Add a sequence for each Health
            for (int i = 0; i < NumberofSequences; i++) {
                pbSequence.add((int) Math.floor(Math.random() * (4 - 1 + 1) + 1));
                //pbSequence.add((int) Math.floor(Math.random() * (2 - 1 + 1) + 1));
                // pbSequence.set(i, 2);

            }

        }

    }

    public int getDyingTimer() {
        return DyingTimer;
    }
}
