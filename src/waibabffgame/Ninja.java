/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waibabffgame;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Anthony Tu
 */
public class Ninja extends Sprite {

    InputStream Ultimate;
    InputStream PageTurn;
    InputStream SlashEffect;
    InputStream SlashEffect2;
    InputStream Confused;
    private String ninja = "Pictures/Ninja/ninja.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Game game;
    int aWidth = 92;
    int aHeight = 90;
    int tester = 0;
    // BufferedImage BackgroundImage = null;
    private boolean visible;
    private Image image;
    int SlashFrame = 0;
    private ImageIcon Ninja1;
    private ImageIcon Ninja2;
    private ImageIcon Ninja3;
    private ImageIcon Ninja4;
    //Ninja is hit
    private ImageIcon NinjaHit;
    //NInja ded
    private ImageIcon NinjaDed;
    private int ttest = 0;
    //Slash variables
    boolean Slash = false;
    boolean AllowForSlash = true;
    //If the user inputs a direction that's not there
    int MissTimer = 0;
    int isHitTimer = 0;
    int DeadNinjaTimer = 0;
    int DeadvelocityY = 5;
    ArrayList<Integer> upX = new ArrayList();
    ArrayList<Integer> downX = new ArrayList();
    ArrayList<Integer> leftX = new ArrayList();
    ArrayList<Integer> rightX = new ArrayList();
    int UltiAct = 0;
    int UltiTimer = 0;
    ImageIcon UltPic;
    ImageIcon NinjaU;
    ImageIcon UNinja1;
    ImageIcon UNinja2;
    ImageIcon UNinja3;
    ImageIcon UNinja4;
    ImageIcon UNinja5;
    ImageIcon UNinja6;
    private boolean Healing = false;
    private int HealingTimer = 0;
    int SymbolTimer = 0;
    int SymbolIndex = 0;
    int SymbolX = 0;
    int SymbolY = 0;
    final int SymbolTime = 1500;
    int SymbolTime2 = 0;
    int LifeSteal = 0;
    int RandSlash = 0;

    public Ninja() {
        ImageIcon NinjaStand = new ImageIcon(this.getClass().getResource(ninja));
        image = NinjaStand.getImage();
        setWidth(image.getWidth(null));
        setHeight(image.getHeight(null));
        setImage(image);
        //Initialize images

        Ninja1 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/ninja.png"));
        Ninja2 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/Ninja2.png"));
        Ninja3 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/Ninja3.png"));
        Ninja4 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/Ninja4.png"));
        NinjaHit = new ImageIcon(this.getClass().getResource("Pictures/Ninja/NinjaisHit.png"));
        NinjaDed = new ImageIcon(this.getClass().getResource("Pictures/Ninja/NinjaDead.png"));

        UNinja1 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja1.png"));
        UNinja2 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja2.png"));
        UNinja3 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja3.png"));
        UNinja4 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja4.png"));
        UNinja5 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja5.png"));
        UNinja6 = new ImageIcon(this.getClass().getResource("Pictures/Ninja/UNinja6.png"));

        NinjaU = UNinja1;
        visible = true;
        //location
        x = 80;
        y = 380;

        setX(x);
        setY(y);
        SymbolX = 450;
        SymbolY = 25;
        SymbolTime2 = (int) (SymbolTime / 6);

    }

    public void act() {
        /*
        if (UltiAct == 1)
        {
        visible = false;

        }
         *
         */

        //If fruit hits ninja
        if (Game.ingame == true) {


            for (int i = 0; i < Game.NumberofFruit; i++) {
                if (Game.fruit.get(i).getX() < this.getX() + this.getWidth() && Game.fruit.get(i).getX() + 100 > this.getX() && Game.fruit.get(i).getY() > this.getY() && DeadNinjaTimer == 0 && UltiAct == 0 || DeadNinjaTimer == 0 && Game.fruit.get(i).getFire() == true && Game.fruit.get(i).getX() < getX() + getWidth() && Game.fruit.get(i).getFireHit() % 2 == 0 && UltiAct == 0 || Game.fruit.get(i).getExplode() == true && Game.StopFruits == false && DeadNinjaTimer == 0 && UltiAct == 0) {
                    isHitTimer = 1;
                    if (image != NinjaHit.getImage()) {
                        image = NinjaHit.getImage();
                        setImage(image);
                    }

                    if (Game.fruit.get(i).isDying() == false && Game.fruit.get(i).getY() < getY() + getHeight() && Game.StopFruits == false || Game.fruit.get(i).getExplode() == true && Game.StopFruits == false && DeadNinjaTimer == 0) {
                        Game.lifeholder.lowerHealth(1);
                        //  Bonus damages
                        if (Game.fruit.get(i).getSpinning() == true) {
                            Game.lifeholder.lowerHealth(2);
                        }
                        if (Game.fruit.get(i).getBombTimer() % 2 == 0) {
                            Game.lifeholder.lowerHealth(1);
                        }
                        if (Game.lifeholder.getHealth() < 0) {
                            Game.lifeholder.setHealth(0);
                        }

                    }
                    if (Game.TutorialEvent == 2 && Game.lifeholder.getHealth() <= 195) {
                        Game.TutorialEvent++;
                        Game.StopFruits = true;
                    }



                }
            }

            //Hit animation
            if (isHitTimer >= 1 && DeadNinjaTimer == 0) {
                isHitTimer++;


                if (isHitTimer > 4 || Slash == true) {
                    if (Slash == false) {
                        if (image != Ninja1.getImage()) {
                            image = Ninja1.getImage();
                            setImage(image);
                        }

                    }

                    isHitTimer = 0;
                }
            }

            //Mis delay and animation
            if (MissTimer >= 1 && DeadNinjaTimer == 0) {
                MissTimer++;

                if (MissTimer > 30 || Game.WinRound == true) {
                    image = Ninja1.getImage();
                    setImage(image);
                    MissTimer = 0;

                }

            }
            //Slash animation
            if (Slash == true && MissTimer == 0 && DeadNinjaTimer == 0) {

                //Timer to direct which image to display
                SlashFrame++;

                if (SlashFrame >= 12) {
                    image = Ninja1.getImage();
                    setImage(image);
                    Slash = false;
                    setY(this.getY() + 60);
                } else if (SlashFrame >= 7) {
                    image = Ninja4.getImage();
                    setImage(image);

                    if (SlashFrame == 7) {
                        setY(this.getY() - 20);
                    }

                } else if (SlashFrame >= 5) {
                    image = Ninja3.getImage();
                    setImage(image);
                    if (SlashFrame == 5) {
                        setY(this.getY() - 20);
                    }

                } else if (SlashFrame >= 3) {
                    image = Ninja2.getImage();
                    setImage(image);
                    if (SlashFrame == 3) {
                        setY(this.getY() - 20);
                    }

                }

            }
            //Dead Ninja
            if (Game.lifeholder.getHealth() <= 0 && Game.Defeat == false) {
                if (DeadNinjaTimer == 0) {
                    Game.lifeholder.setHealth(0);
                    image = NinjaDed.getImage();
                    setImage(image);
                    isHitTimer = 0;
                    MissTimer = 0;
                    DeadvelocityY = 5;
                    Slash = false;
                    SlashFrame = 0;
                }
                DeadNinjaTimer += 1;
                setY(getY() - DeadvelocityY);
                DeadvelocityY -= 1;

                if (getY() > 690) {
                    Game.Defeat = true;
                    DeadNinjaTimer = 0;
                    DeadvelocityY = 5;


                }

            }
            //Ultimate change picture
            if (Game.ingame && Game.GlobalEvent == false && Game.StopFruits == false || Game.TutorialEvent == 16) {

                if (SymbolTimer < SymbolTime2 * 5) {
                    SymbolTimer++;
                }
                if (SymbolTimer < SymbolTime2) {
                    SymbolIndex = 0;
                }
                if (SymbolTimer >= SymbolTime2) {
                    SymbolIndex = 1;
                }
                if (SymbolTimer >= SymbolTime2 * 2) {
                    SymbolIndex = 2;
                }
                if (SymbolTimer >= SymbolTime2 * 3) {
                    SymbolIndex = 3;
                }
                if (SymbolTimer >= SymbolTime2 * 4) {
                    SymbolIndex = 4;
                }
                if (SymbolTimer >= SymbolTime2 * 5) {
                    SymbolIndex = 5;
                }


            }

            if (Game.ingame == true && LifeSteal >= 5) {
                LifeSteal = 0;
                if (Game.lifeholder.getHealth() + 1 < 200) {
                    Game.lifeholder.lowerHealth(-1);
                }
            }

            if (Game.GlobalEvent == false || Game.TutorialEvent >= 1) {
                scan();
            }

            if (UltiAct == 1) {
                Game.StopFruits = true;
                UltiAct++;
                UltPic = Game.UltimatePicture[1];
                setY(this.getY() - 70);
                setX(this.getX() - 80);
                //visible = false;
            }

            if (UltiAct == 2) {
                UltiTimer++;
                if (UltiTimer > 5) {
                    NinjaU = UNinja1;
                }
                if (UltiTimer == 5) {
                    UltimateSound();
                }
                if (UltiTimer > 25) {
                    NinjaU = UNinja2;

                }
                if (UltiTimer > 30) {
                    NinjaU = UNinja3;
                }
                if (UltiTimer > 35) {
                    NinjaU = UNinja4;
                }
                if (UltiTimer > 40) {
                    NinjaU = UNinja5;
                }
                if (UltiTimer > 45) {
                    NinjaU = UNinja6;


                }

                image = NinjaU.getImage();
                setImage(image);
                if (UltiTimer > 50) {
                    UltiAct++;
                    UltiTimer = 0;
                    SlashSound();
                }
            }
            //Ultimate timer picture change
            if (UltiAct == 3) {
                UltiTimer++;
                if (UltiTimer == 2) {
                    SlashSound();
                }
                if (UltiTimer > 5) {
                    UltPic = Game.UltimatePicture[2];
                }
                if (UltiTimer == 6) {
                    SlashSound();
                }
                if (UltiTimer > 9) {
                    UltPic = Game.UltimatePicture[3];
                }
                if (UltiTimer == 10) {
                    SlashSound();
                }
                if (UltiTimer > 12) {
                    UltPic = Game.UltimatePicture[4];
                }
                if (UltiTimer == 13) {
                    SlashSound();
                }
                if (UltiTimer > 14) {
                    UltPic = Game.UltimatePicture[5];
                }
                if (UltiTimer == 15) {
                    SlashSound();
                }
                if (UltiTimer > 16) {
                    UltPic = Game.UltimatePicture[6];
                }
                if (UltiTimer == 17) {
                    SlashSound();
                }
                if (UltiTimer > 18) {
                    UltPic = Game.UltimatePicture[7];
                }
                if (UltiTimer == 19) {
                    SlashSound();
                }
                if (UltiTimer > 20) {
                    UltPic = Game.UltimatePicture[8];
                }
                if (UltiTimer == 21) {
                    SlashSound();
                }
                if (UltiTimer > 22) {
                    UltPic = Game.UltimatePicture[9];
                }
                if (UltiTimer == 23) {
                    SlashSound();
                }
                if (UltiTimer > 24) {
                    UltPic = Game.UltimatePicture[10];
                }
                if (UltiTimer == 25) {
                    SlashSound();
                }
                if (UltiTimer > 26) {
                    UltPic = Game.UltimatePicture[11];
                }
                if (UltiTimer == 27) {
                    SlashSound();
                }
                if (UltiTimer > 28) {
                    UltPic = Game.UltimatePicture[12];
                }
                if (UltiTimer == 29) {
                    SlashSound();
                }
                if (UltiTimer > 30) {
                    UltPic = Game.UltimatePicture[13];
                }
                if (UltiTimer == 31) {
                    SlashSound();
                }
                if (UltiTimer > 32) {
                    UltPic = Game.UltimatePicture[14];
                }
                if (UltiTimer == 33) {
                    SlashSound();
                }
                if (UltiTimer > 34) {
                    UltPic = Game.UltimatePicture[15];
                }
                if (UltiTimer == 35) {
                    SlashSound();
                }
                if (UltiTimer > 36) {
                    UltPic = Game.UltimatePicture[16];
                }
                if (UltiTimer == 37) {
                    SlashSound();
                }
                if (UltiTimer > 38) {
                    UltPic = Game.UltimatePicture[17];
                }
                if (UltiTimer == 39) {
                    SlashSound();
                }
                if (UltiTimer > 40) {
                    UltPic = Game.UltimatePicture[18];
                }
                if (UltiTimer == 41) {
                    SlashSound();
                }
                if (UltiTimer > 42) {
                    UltPic = Game.UltimatePicture[19];
                }
                if (UltiTimer == 43) {
                    SlashSound();
                }
                if (UltiTimer > 44) {
                    UltPic = Game.UltimatePicture[20];
                }
                if (UltiTimer == 45) {
                    SlashSound();
                }
                if (UltiTimer > 46) {
                    UltPic = Game.UltimatePicture[21];
                }
                if (UltiTimer == 47) {
                    SlashSound();
                }
                if (UltiTimer > 48) {
                    UltPic = Game.UltimatePicture[22];
                }
                if (UltiTimer == 49) {
                    SlashSound();
                }
                if (UltiTimer > 50) {
                    UltPic = Game.UltimatePicture[23];
                }
                if (UltiTimer == 51) {
                    SlashSound2();
                }
                if (UltiTimer > 52) {
                    UltPic = Game.UltimatePicture[24];
                }
                if (UltiTimer == 53) {
                }
                if (UltiTimer > 54) {
                    UltPic = Game.UltimatePicture[25];
                }
                if (UltiTimer == 55) {
                }
                if (UltiTimer > 56) {
                    UltPic = Game.UltimatePicture[26];
                }
                if (UltiTimer == 57) {
                }
                if (UltiTimer > 58) {
                    UltPic = Game.UltimatePicture[27];
                }
                if (UltiTimer == 59) {
                }
                if (UltiTimer > 60) {
                    UltPic = Game.UltimatePicture[28];
                }
                if (UltiTimer == 61) {
                }
                if (UltiTimer > 65) {
                    UltiTimer = 0;
                    UltiAct = 4;

                }


            }
            //Damages all of the fruit on the screen
            if (UltiAct == 4) {
                Game.StopFruits = false;
                UltiAct = 0;
                setY(this.getY() + 70);
                setX(this.getX() + 80);
                setImage(Ninja1.getImage());

                for (int i = 0; i < Game.NumberofFruit; i++) {
                    Game.fruit.get(i).setTemp(Game.fruit.get(i).getNumberofSequences());

                    Game.fruit.get(i).setNextSequence(true);


                    if (Game.fruit.get(i).getNumberofSequences() - 1 > 0) {
                        Game.fruit.get(i).RemoveSequence(0);
                        Game.fruit.get(i).setNumberofSequences(Game.fruit.get(i).getNumberofSequences() - 1);
                    }
                    if (Game.fruit.get(i).getNumberofSequences() - 2 > 0) {
                        Game.fruit.get(i).RemoveSequence(1);
                        Game.fruit.get(i).setNumberofSequences(Game.fruit.get(i).getNumberofSequences() - 1);
                    }
                    if (Game.fruit.get(i).getNumberofSequences() - 3 > 0) {
                        Game.fruit.get(i).RemoveSequence(2);
                        Game.fruit.get(i).setNumberofSequences(Game.fruit.get(i).getNumberofSequences() - 1);
                    }

                    Game.fruit.get(i).reSS();


                    if (Game.fruit.get(i).getNumberofSequences() <= 0) {
                        Game.fruit.get(i).setDying(true);

                    } else {
                        Game.fruit.get(i).setIsHit(true);
                        Game.fruit.get(i).setIsHitTimer(0);
                    }


                }

            }
        }

        //Lose
        if (Game.GameOver == true) {
            // DeadNinjaTimer += 1;
            if (getY() < 400) {
                setY(getY() - DeadvelocityY);
                DeadvelocityY -= 1;
            }

        }


        //Healing
        if (Healing == true && DeadNinjaTimer == 0) {
            HealingTimer++;
            if (Game.lifeholder.getHealth() + 1 < 200) {
                Game.lifeholder.lowerHealth(-1);
            }

            if (HealingTimer > 20) {
                HealingTimer = 0;
                Healing = false;
            }

        }



    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, this.getWidth(), this.getHeight());
    }

    //Key pressed - this is the user input
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // The "Press any key to continue" stuff

//Game.GlobalEvent = false;

        if (Game.Cutscene == true) {
            if (Game.CutSceneAct == 2 || Game.CutSceneAct == 4 || Game.CutSceneAct == 6 || Game.CutSceneAct == 8 || Game.CutSceneAct == 10 || Game.CutSceneAct == 12) {
                Game.CutSceneAct++;
            }

        }
        //Clear Save files
        if (Game.mmenu == true && Game.CSaveDataPrompt == true) {
            if (key == KeyEvent.VK_Y) {
                Game.CSaveDataCleared = true;
                Game.CSaveDataPrompt = false;
                Game.CurrentLevel = 0;
                Game.ClearSave();
                Game.LoadFile();

            }
            if (key == KeyEvent.VK_N) {
                Game.CSaveDataPrompt = false;
            }
        }

        //WinRound
        if (Game.WinRound == true) {
            Game.ReturnToMenu = true;
        }
        //Gameover
        if (Game.GameOver == true) {
            Game.GameOver = false;
            Game.ReturnToMenu = true;
            setX(80);
            setY(380);
            setImage(Ninja1.getImage());
            return;
        }

        //Level Select Buttons
        if (Game.levelselect == true) {

            if (key == KeyEvent.VK_HOME) {
                for (int i = 0; i < 8; i++) {
                    Game.Locked[i] = false;
                }

            }
            if (key == KeyEvent.VK_SPACE && Game.levelselect == true && Game.Locked[Game.CurrentLevel] == false) {
                //Change background

                if (Game.CurrentLevel == 0) {
                    Game.TutorialEvent = 1;
                } else if (Game.CurrentLevel == 1) {
                    Game.WatermelonEvent = 0;

                } else if (Game.CurrentLevel == 2) {
                    Game.StrawberryEvent = 0;
                } else if (Game.CurrentLevel == 3) {
                    Game.OrangeEvent = 0;
                } else if (Game.CurrentLevel == 4) {
                    Game.GrapeEvent = 0;
                } else if (Game.CurrentLevel == 5) {
                    Game.BananaEvent = 0;
                } else if (Game.CurrentLevel == 6) {
                    Game.MangoEvent = 0;
                } else if (Game.CurrentLevel == 7) {
                    Game.AppleEvent = 0;
                }

                Game.ActivateGame = true;
            }
            if (key == KeyEvent.VK_LEFT) {
                Game.LeftLevel = true;
            }
            if (key == KeyEvent.VK_RIGHT) {
                Game.RightLevel = true;
            }
            if (key == KeyEvent.VK_ESCAPE) {
                Game.LSToMenu = true;
            }

        }

        //In game controls
        if (Game.ingame == true) {


            if (Game.TutorialEvent == 3) {
                Game.TutorialEvent++;
                Game.StopFruits = false;
            }

            //Advance to next screen in boss
            if (Game.GlobalEvent == true && Game.background2.getX() == 0) {
                if (Game.WatermelonEvent == 2) {
                    Game.WatermelonEvent = 3;
                }

                if (Game.StrawberryEvent == 2) {
                    Game.StrawberryEvent = 3;
                }
                if (Game.OrangeEvent == 2) {
                    Game.OrangeEvent = 3;
                }
                if (Game.GrapeEvent == 2) {
                    Game.GrapeEvent = 3;
                }
                if (Game.BananaEvent == 2) {
                    Game.BananaEvent = 3;
                }
                if (Game.MangoEvent == 2) {
                    Game.MangoEvent = 3;
                }
                if (Game.AppleEvent == 4) {
                    Game.AppleEvent = 5;
                }
                if (Game.AppleEvent == 3) {
                    Game.AppleEvent = 4;
                }
                if (Game.AppleEvent == 2) {
                    Game.AppleEvent = 3;
                }
            }
            //Exit out of combat
            if (key == KeyEvent.VK_ESCAPE) {
                if (Game.GlobalEvent == false || Game.TutorialEvent >= 1) {
                    Game.TutorialEvent = -2;
                    Game.ingame = false;
                    Game.ReturnToMenu = true;
                    setX(80);
                    setY(380);
                    setImage(Ninja1.getImage());
                }
            }
            //ULTIMATE ATTACK
            if (key == KeyEvent.VK_SPACE && SymbolTimer >= SymbolTime2 * 5 && UltiAct == 0 && Game.TutorialEvent == -2 && Game.GlobalEvent == false && Game.WinRound == false && DeadNinjaTimer == 0 || key == KeyEvent.VK_SPACE && UltiAct == 0 && Game.TutorialEvent == 16 && DeadNinjaTimer == 0) {
                UltiAct = 1;
                UltiTimer = 0;
                NinjaU = UNinja1;
                SymbolTimer = 0;
                SymbolIndex = 0;

            }
            //Normal directional attacks
            if (AllowForSlash == true && MissTimer == 0 && DeadNinjaTimer == 0 && Game.GlobalEvent == false && Game.WinRound == false && UltiAct == 0 || Game.TutorialEvent >= 7 && Game.TutorialEvent != 16 && Game.TutorialEvent != 12) {

                int current = 1030;
                int index = 0;
                boolean hit = false;
                //Up Slash
                if (key == KeyEvent.VK_UP) {
                    if (isHitTimer != 0) {
                        isHitTimer = 0;

                    }

                    Slash = true;
                    SlashFrame = 0;

                    image = Ninja1.getImage();
                    setImage(image);

                    x = 80;
                    y = 380;
                    setX(x);
                    setY(y);
                    //Obtains the index of the horizontally closest fruit
                    if (Game.fruit.size() > 0) {
                        for (int i = 0; i < Game.NumberofFruit; i++) {
                            if (Game.fruit.get(i).getX() < current && Game.fruit.get(i).getSequence(0) == 1 && Game.fruit.get(i).isDying() == false) {
                                current = Game.fruit.get(i).getX();
                                index = i;
                                hit = true;
                            }
                        }
                        //Attack the fruit
                        if (Game.NumberofFruit > 0 && Game.fruit.get(index).getSequence(0) == 1 && Game.fruit.get(index).isDying() == false) {
                            //Damages the fruit, potentialling killing it
                            AllowForSlash = false;
                            SymbolTimer += 5;
                            LifeSteal++;
                            Game.fruit.get(index).setTemp(Game.fruit.get(index).getNumberofSequences());

                            Game.fruit.get(index).setNextSequence(true);


                            if (Game.fruit.get(index).getNumberofSequences() - 1 > 0) {
                                Game.fruit.get(index).RemoveSequence(0);
                            }

                            Game.fruit.get(index).setNumberofSequences(Game.fruit.get(index).getNumberofSequences() - 1);
                            Game.fruit.get(index).reSS();


                            if (Game.fruit.get(index).getNumberofSequences() <= 0) {
                                Game.fruit.get(index).setDying(true);
                                if (Game.fruit.get(index).getFood() == 30) {
                                    Healing = true;
                                }
                                SlashSound2();

                            } else {
                                Game.fruit.get(index).setIsHit(true);
                                Game.fruit.get(index).setIsHitTimer(0);
                                SlashSound();
                            }
                            if (Game.fruit.get(index).getHeroic() == true && Game.fruit.get(index).getFood() == 1 && Game.fruit.get(index).getAppleAttack() == 4 && Game.fruit.get(index).getBossAct() == 2) {
                                Game.fruit.get(index).setAppleChargeHit(Game.fruit.get(index).getAppleChargeHit() + 1);
                            }
                            return;
                        }
                        //If no fruit was found, miss
                        if (hit == false) {
                            MissTimer = 1;
                            image = NinjaHit.getImage();
                            setImage(image);
                            Slash = false;
                            SlashFrame = 0;
                            AllowForSlash = false;
                            try {
                                Confused.close();
                            } catch (Exception w) {
                            }
                            ConfusedSound();
                            return;
                        }



                    }

                }
                if (key == KeyEvent.VK_DOWN) {
                    if (isHitTimer != 0) {
                        isHitTimer = 0;

                    }

                    Slash = true;
                    SlashFrame = 0;

                    image = Ninja1.getImage();
                    setImage(image);

                    x = 80;
                    y = 380;
                    setX(x);
                    setY(y);
                    //Obtains the index of the horizontally closest fruit
                    if (Game.fruit.size() > 0) {
                        for (int i = 0; i < Game.NumberofFruit; i++) {
                            if (Game.fruit.get(i).getX() < current && Game.fruit.get(i).getSequence(0) == 2 && Game.fruit.get(i).isDying() == false) {
                                current = Game.fruit.get(i).getX();
                                index = i;
                                hit = true;
                            }
                        }

                        if (Game.NumberofFruit > 0 && Game.fruit.get(index).getSequence(0) == 2 && Game.fruit.get(index).isDying() == false) {
                            //Damages the fruit, potentialling killing it
                            AllowForSlash = false;
                            SymbolTimer += 5;
                            LifeSteal++;
                            Game.fruit.get(index).setTemp(Game.fruit.get(index).getNumberofSequences());

                            Game.fruit.get(index).setNextSequence(true);


                            if (Game.fruit.get(index).getNumberofSequences() - 1 > 0) {
                                Game.fruit.get(index).RemoveSequence(0);
                            }


                            Game.fruit.get(index).setNumberofSequences(Game.fruit.get(index).getNumberofSequences() - 1);
                            Game.fruit.get(index).reSS();


                            if (Game.fruit.get(index).getNumberofSequences() <= 0) {
                                Game.fruit.get(index).setDying(true);
                                if (Game.fruit.get(index).getFood() == 30) {
                                    Healing = true;
                                }
                                SlashSound2();

                            } else {
                                Game.fruit.get(index).setIsHit(true);
                                Game.fruit.get(index).setIsHitTimer(0);
                                SlashSound();
                            }
                            if (Game.fruit.get(index).getHeroic() == true && Game.fruit.get(index).getFood() == 1 && Game.fruit.get(index).getAppleAttack() == 4 && Game.fruit.get(index).getBossAct() == 2) {
                                Game.fruit.get(index).setAppleChargeHit(Game.fruit.get(index).getAppleChargeHit() + 1);
                            }

                            return;
                        }
                        //Misses fruit
                        if (hit == false) {
                            MissTimer = 1;
                            image = NinjaHit.getImage();
                            setImage(image);
                            Slash = false;
                            SlashFrame = 0;
                            AllowForSlash = false;
                            try {
                                Confused.close();
                            } catch (Exception w) {
                            }
                            ConfusedSound();
                            return;
                        }
                    }
                }
                if (key == KeyEvent.VK_LEFT) {
                    if (isHitTimer != 0) {
                        isHitTimer = 0;

                    }

                    Slash = true;
                    SlashFrame = 0;

                    image = Ninja1.getImage();
                    setImage(image);

                    x = 80;
                    y = 380;
                    setX(x);
                    setY(y);
                    //Obtains the index of the horizontally closest fruit
                    if (Game.fruit.size() > 0) {
                        for (int i = 0; i < Game.NumberofFruit; i++) {
                            if (Game.fruit.get(i).getX() < current && Game.fruit.get(i).getSequence(0) == 3 && Game.fruit.get(i).isDying() == false) {
                                current = Game.fruit.get(i).getX();
                                index = i;
                                hit = true;
                            }
                        }

                        if (Game.NumberofFruit > 0 && Game.fruit.get(index).getSequence(0) == 3 && Game.fruit.get(index).isDying() == false) {

                            //Damages the fruit, potentialling killing it
                            AllowForSlash = false;
                            SymbolTimer += 5;
                            LifeSteal++;
                            Game.fruit.get(index).setTemp(Game.fruit.get(index).getNumberofSequences());

                            Game.fruit.get(index).setNextSequence(true);
                            if (Game.fruit.get(index).getNumberofSequences() - 1 > 0) {
                                Game.fruit.get(index).RemoveSequence(0);
                            }


                            Game.fruit.get(index).setNumberofSequences(Game.fruit.get(index).getNumberofSequences() - 1);
                            Game.fruit.get(index).reSS();
                            if (Game.fruit.get(index).getNumberofSequences() <= 0) {
                                Game.fruit.get(index).setDying(true);
                                if (Game.fruit.get(index).getFood() == 30) {
                                    Healing = true;
                                }
                                SlashSound2();

                            } else {
                                Game.fruit.get(index).setIsHit(true);
                                Game.fruit.get(index).setIsHitTimer(0);
                                SlashSound();

                            }
                            if (Game.fruit.get(index).getHeroic() == true && Game.fruit.get(index).getFood() == 1 && Game.fruit.get(index).getAppleAttack() == 4 && Game.fruit.get(index).getBossAct() == 2) {
                                Game.fruit.get(index).setAppleChargeHit(Game.fruit.get(index).getAppleChargeHit() + 1);
                            }
                            return;
                        }
                        //Miss fruit
                        if (hit == false) {
                            MissTimer = 1;
                            image = NinjaHit.getImage();
                            setImage(image);
                            Slash = false;
                            SlashFrame = 0;
                            AllowForSlash = false;
                            try {
                                Confused.close();
                            } catch (Exception w) {
                            }
                            ConfusedSound();
                            return;
                        }
                    }
                }
                if (key == KeyEvent.VK_RIGHT) {
                    if (isHitTimer != 0) {
                        isHitTimer = 0;

                    }

                    Slash = true;
                    SlashFrame = 0;

                    image = Ninja1.getImage();
                    setImage(image);

                    x = 80;
                    y = 380;
                    setX(x);
                    setY(y);
                    //Obtains the index of the horizontally closest fruit
                    if (Game.fruit.size() > 0) {
                        for (int i = 0; i < Game.NumberofFruit; i++) {
                            if (Game.fruit.get(i).getX() < current && Game.fruit.get(i).getSequence(0) == 4 && Game.fruit.get(i).isDying() == false) {
                                current = Game.fruit.get(i).getX();
                                index = i;
                                hit = true;
                            }
                        }

                        if (Game.NumberofFruit > 0 && Game.fruit.get(index).getSequence(0) == 4 && Game.fruit.get(index).isDying() == false) {

                            //Damages the fruit, potentialling killing it
                            AllowForSlash = false;
                            SymbolTimer += 5;
                            LifeSteal++;
                            Game.fruit.get(index).setTemp(Game.fruit.get(index).getNumberofSequences());

                            Game.fruit.get(index).setNextSequence(true);


                            if (Game.fruit.get(index).getNumberofSequences() - 1 > 0) {
                                Game.fruit.get(index).RemoveSequence(0);
                            }


                            Game.fruit.get(index).setNumberofSequences(Game.fruit.get(index).getNumberofSequences() - 1);
                            Game.fruit.get(index).reSS();


                            if (Game.fruit.get(index).getNumberofSequences() <= 0) {
                                Game.fruit.get(index).setDying(true);
                                if (Game.fruit.get(index).getFood() == 30) {
                                    Healing = true;
                                }
                                SlashSound2();
                            } else {
                                Game.fruit.get(index).setIsHit(true);
                                Game.fruit.get(index).setIsHitTimer(0);
                                SlashSound();

                            }
                            if (Game.fruit.get(index).getHeroic() == true && Game.fruit.get(index).getFood() == 1 && Game.fruit.get(index).getAppleAttack() == 4 && Game.fruit.get(index).getBossAct() == 2) {
                                Game.fruit.get(index).setAppleChargeHit(Game.fruit.get(index).getAppleChargeHit() + 1);
                            }
                            return;
                        }
                        //Miss fruit
                        if (hit == false) {
                            MissTimer = 1;
                            image = NinjaHit.getImage();
                            setImage(image);
                            Slash = false;
                            SlashFrame = 0;
                            AllowForSlash = false;
                            try {
                                Confused.close();
                            } catch (Exception w) {
                            }
                            ConfusedSound();
                            return;
                        }
                    }
                }





            }
        }

    }
//Scans for the horizontally closest fruit and applies a red marker on it

    private void scan() {
//Scan up
        int currentup = 1030;
        int indexup = 0;
        for (int i = 0; i < Game.NumberofFruit; i++) {
            if (Game.fruit.get(i).getX() < currentup && Game.fruit.get(i).getSequence(0) == 1) {
                currentup = Game.fruit.get(i).getX();
                indexup = i;

            }
        }
        if (Game.NumberofFruit > 0 && Game.fruit.get(indexup).getSequence(0) == 1) {
            Game.fruit.get(indexup).addupHL();
        }

        for (int k = 0; k < Game.NumberofFruit; k++) {
            if (Game.fruit.get(k).getupHL() == true && Game.fruit.get(k).getX() > Game.fruit.get(indexup).getX() && Game.fruit.get(k).getSequence(0) == 1) {
                Game.fruit.get(k).removeupHL();

                break;
            }

        }
//Scan down
        int currentdown = 1030;
        int indexdown = 0;
        for (int i = 0; i < Game.NumberofFruit; i++) {
            if (Game.fruit.get(i).getX() < currentdown && Game.fruit.get(i).getSequence(0) == 2) {
                currentdown = Game.fruit.get(i).getX();
                indexdown = i;

            }
        }
        if (Game.NumberofFruit > 0 && Game.fruit.get(indexdown).getSequence(0) == 2) {
            Game.fruit.get(indexdown).adddownHL();
        }

        for (int k = 0; k < Game.NumberofFruit; k++) {
            if (Game.fruit.get(k).getdownHL() == true && Game.fruit.get(k).getX() > Game.fruit.get(indexdown).getX() && Game.fruit.get(k).getSequence(0) == 2) {
                Game.fruit.get(k).removedownHL();

                break;
            }

        }
        //Scan left
        int currentleft = 1030;
        int indexleft = 0;
        for (int i = 0; i < Game.NumberofFruit; i++) {
            if (Game.fruit.get(i).getX() < currentleft && Game.fruit.get(i).getSequence(0) == 3) {
                currentleft = Game.fruit.get(i).getX();
                indexleft = i;

            }
        }
        if (Game.NumberofFruit > 0 && Game.fruit.get(indexleft).getSequence(0) == 3) {
            Game.fruit.get(indexleft).addleftHL();
        }

        for (int k = 0; k < Game.NumberofFruit; k++) {
            if (Game.fruit.get(k).getleftHL() == true && Game.fruit.get(k).getX() > Game.fruit.get(indexleft).getX() && Game.fruit.get(k).getSequence(0) == 3) {
                Game.fruit.get(k).removeleftHL();

                break;
            }

        }
        //Scan right
        int currentright = 1030;
        int indexright = 0;
        for (int i = 0; i < Game.NumberofFruit; i++) {
            if (Game.fruit.get(i).getX() < currentright && Game.fruit.get(i).getSequence(0) == 4) {
                currentright = Game.fruit.get(i).getX();
                indexright = i;

            }
        }
        if (Game.NumberofFruit > 0 && Game.fruit.get(indexright).getSequence(0) == 4) {
            Game.fruit.get(indexright).addrightHL();
        }

        for (int k = 0; k < Game.NumberofFruit; k++) {
            if (Game.fruit.get(k).getrightHL() == true && Game.fruit.get(k).getX() > Game.fruit.get(indexright).getX() && Game.fruit.get(k).getSequence(0) == 4) {
                Game.fruit.get(k).removerightHL();

                break;
            }
        }
    }

    //Key released - THis is to avoid holding
    void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        //When the respective key is released, all for it to be pressed again.
        if (key == KeyEvent.VK_LEFT) {
            AllowForSlash = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            AllowForSlash = true;
        }

        if (key == KeyEvent.VK_UP) {
            AllowForSlash = true;
        }

        if (key == KeyEvent.VK_DOWN) {
            AllowForSlash = true;
        }
    }

    //Ninja functions - most are pretty self explanitory.
    public void setUltiAct(int act) {
        this.UltiAct = act;
    }

    public int getUltiAct() {
        return UltiAct;
    }

    public void setSymbol(int symbol) {
        this.SymbolIndex = symbol;
    }

    public int getSymbol() {
        return SymbolIndex;
    }

    public void setSymbolX(int symbol) {
        this.SymbolX = symbol;
    }

    public int getSymbolX() {
        return SymbolX;
    }

    public void setSymbolY(int symbol) {
        this.SymbolY = symbol;
    }

    public int getSymbolY() {
        return SymbolY;
    }

    public void setHealing(boolean healing) {
        this.Healing = healing;
    }

    public boolean getHealing() {
        return Healing;
    }

    public void setSlash(boolean slash) {
        this.Slash = slash;
    }

    public boolean getSlash() {
        return Slash;
    }

    public void setSlashF(int slash) {
        this.SlashFrame = slash;
    }

    public int getSlashF() {
        return SlashFrame;
    }

    public void setSymbolTimer(int time) {
        this.SymbolTimer = time;
    }

    public int getSymbolTimer() {
        return SymbolTimer;
    }

    public int getSymbolTime() {
        return SymbolTime;
    }

    public ImageIcon getUltiPic() {
        return UltPic;
    }

    public ImageIcon getNinjaPic() {
        return Ninja1;
    }
//Slash sound effect
    private void SlashSound() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/slash.wav";
            SlashEffect = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(SlashEffect);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }
//Slash sound effect
    private void SlashSound2() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/slash2.wav";
            SlashEffect2 = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(SlashEffect2);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }
//Confused effect
    private void ConfusedSound() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/confused.wav";
            Confused = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(Confused);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }
//Ultimate sound effect
    private void UltimateSound() {

        try {
            // open the sound file as a Java input stream
            String gongFile = "src/ultimate.wav";
            Ultimate = new FileInputStream(gongFile);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(Ultimate);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
        }
    }
}
