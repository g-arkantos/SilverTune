/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThePlayerPK;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFileChooser;

/**
 *
 * @author Grace Edwin
 */
public class PlayerFrame extends javax.swing.JFrame {

    /**
     * Creates new form PlayerFrame
     */
    
    MP3Player player;       //this defines class from the mp3 library
    File songFile;          //Defines the song file
    String currentDirectory="home.user"; //will ask the user the dir    
    String currentPath;
    String imagePath;
    String appName = "SilverTune";
    
    boolean repeat=false;
    boolean windowCollapsed=false;
    boolean isPlaying=false;
    
    int Mouse_on_X, Mouse_on_Y;//(to get the position on the screen)
    int currentPosition=0;
    
    int i=15;
    
    
    
    
    
    String[] songListPath = {":\\Users\\Grace Edwin\\Documents\\Music_lib\\1Dir.mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Doraemon_sad_song_with_lyrics(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Dress.mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Ed_Sheeran_-_I_Don't_Care_(Live_At_Abbey_Road)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Enchanted_Taylor_Swift__Lyrics(128kbps).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\End_of_the_Day_-_One_Direction_(Lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\From_The_Dining_Table.mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Louis_Tomlinson_-_Just_Like_You_(Official_Lyric_Video)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Louis_Tomlinson_-_Miss_You__Lyrics___Lyric_Video_(256kbps).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Louis_Tomlinson_-_Two_of_Us_(Official_Lyric_Video)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Maroon_5_-_Memories_(Lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Marvin_Gaye_-_Charlie_Puth_ft._Meghan_Trainor_(Lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Miss_Americana_&_The_Heartbreak_Prince.mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Moana_How_Far_I'll_Go_Lyrics_Auli'i_Cravalho(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Niall_Horan_-_Nice_To_Meet_Ya_(Official)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Niall_Horan_-_Put_A_Little_Love_On_Me_(Lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Niall_Horan_-_Too_Much_To_Ask_(Lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Nial_Horan-this_town(vidéo_lyrics)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\One_Direction_-_Don't_Forget_Where_You_Belong_(Lyrics_pictures)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Back_To_December(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Bad_Blood_ft._Kendrick_Lamar(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Blank_Space(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Death_By_A_Thousand_Cuts_(Official_Audio)(256kbps).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Delicate(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Everything_Has_Changed_ft._Ed_Sheeran(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Gorgeous_(Lyric_Video)(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_I_Knew_You_Were_Trouble(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_London_Boy_(Official_Audio)(256kbps).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Love_Story(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Mean(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Mine(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Ours(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Red(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Safe_and_Sound_Lyrics(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Style(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_The_Archer_(Music_Video)(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_The_Man_(Official_Audio)(256kbps).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_White_Horse(128k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_Wildest_Dreams(256k).mp3",
"C:\\Users\\Grace Edwin\\Documents\\Music_lib\\Taylor_Swift_-_You_Belong_With_Me(256k).mp3"};
    
        
    public PlayerFrame() {
        initComponents();
        AppTitleLabel.setText(appName);
        
        String songPath= songListPath[i];
        songFile = new File(songPath);
        String fileName = songFile.getName();// this will take the song name
        SongTitleLabel.setText(fileName);//this will display the song title
        player = mp3Player();//method to player variable
        player.addToPlayList(songFile);
        
        
        currentPath =Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\Images";
        
        
       
        
        
        

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        HeaderMainPanel = new javax.swing.JPanel();
        appTitlePanel = new javax.swing.JPanel();
        AppTitleLabel = new javax.swing.JLabel();
        quitLabel = new javax.swing.JLabel();
        PhotoHolder1 = new javax.swing.JPanel();
        PhotoHolder2 = new javax.swing.JPanel();
        Picture = new javax.swing.JLabel();
        ContolPanel = new javax.swing.JPanel();
        RepeatBttn = new javax.swing.JButton();
        PrevBttn = new javax.swing.JButton();
        Play_PauseBttn = new javax.swing.JButton();
        NextBttn = new javax.swing.JButton();
        StopBttn = new javax.swing.JButton();
        SongTitleLabel = new javax.swing.JLabel();
        OpenBttn = new javax.swing.JButton();
        VolDownBttn = new javax.swing.JButton();
        VolFullBttn = new javax.swing.JButton();
        muteBttn = new javax.swing.JButton();
        VolUPBttn = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();

        jPasswordField1.setText("jPasswordField1");

        setTitle("SilverTune");
        setBackground(new java.awt.Color(0, 51, 51));
        setUndecorated(true);

        HeaderMainPanel.setBackground(new java.awt.Color(0, 0, 0));
        HeaderMainPanel.setName(""); // NOI18N

        appTitlePanel.setBackground(new java.awt.Color(0, 0, 0));
        appTitlePanel.setForeground(new java.awt.Color(0, 255, 255));
        appTitlePanel.setFont(new java.awt.Font("Cambria Math", 3, 24)); // NOI18N

        AppTitleLabel.setBackground(new java.awt.Color(0, 0, 0));
        AppTitleLabel.setFont(new java.awt.Font("Lucida Blackletter", 3, 24)); // NOI18N
        AppTitleLabel.setForeground(java.awt.Color.green);
        AppTitleLabel.setText("    App Title");
        AppTitleLabel.setOpaque(true);
        AppTitleLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                AppTitleLabelMouseDragged(evt);
            }
        });
        AppTitleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppTitleLabelMouseClicked(evt);
            }
        });

        quitLabel.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        quitLabel.setForeground(java.awt.SystemColor.activeCaption);
        quitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThePlayerPK/images/QUIT.png"))); // NOI18N
        quitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout appTitlePanelLayout = new javax.swing.GroupLayout(appTitlePanel);
        appTitlePanel.setLayout(appTitlePanelLayout);
        appTitlePanelLayout.setHorizontalGroup(
            appTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(quitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        appTitlePanelLayout.setVerticalGroup(
            appTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(appTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appTitlePanelLayout.createSequentialGroup()
                        .addComponent(quitLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(AppTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PhotoHolder1.setBackground(new java.awt.Color(0, 0, 0));

        Picture.setBackground(new java.awt.Color(0, 204, 204));
        Picture.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        Picture.setForeground(new java.awt.Color(0, 204, 204));
        Picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThePlayerPK/images/music_img.jpg"))); // NOI18N

        javax.swing.GroupLayout PhotoHolder2Layout = new javax.swing.GroupLayout(PhotoHolder2);
        PhotoHolder2.setLayout(PhotoHolder2Layout);
        PhotoHolder2Layout.setHorizontalGroup(
            PhotoHolder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        PhotoHolder2Layout.setVerticalGroup(
            PhotoHolder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PhotoHolder1Layout = new javax.swing.GroupLayout(PhotoHolder1);
        PhotoHolder1.setLayout(PhotoHolder1Layout);
        PhotoHolder1Layout.setHorizontalGroup(
            PhotoHolder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhotoHolder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PhotoHolder1Layout.setVerticalGroup(
            PhotoHolder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PhotoHolder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContolPanel.setBackground(new java.awt.Color(0, 0, 0));

        RepeatBttn.setBackground(new java.awt.Color(0, 0, 0));
        RepeatBttn.setForeground(new java.awt.Color(0, 255, 51));
        RepeatBttn.setText("Loop");
        RepeatBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepeatBttnMouseClicked(evt);
            }
        });

        PrevBttn.setBackground(new java.awt.Color(0, 0, 0));
        PrevBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThePlayerPK/images/PREV.png"))); // NOI18N
        PrevBttn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PrevBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrevBttnMouseClicked(evt);
            }
        });
        PrevBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevBttnActionPerformed(evt);
            }
        });

        Play_PauseBttn.setBackground(new java.awt.Color(0, 0, 0));
        Play_PauseBttn.setForeground(new java.awt.Color(0, 0, 0));
        Play_PauseBttn.setToolTipText("Play Or Pause");
        Play_PauseBttn.setAutoscrolls(true);
        Play_PauseBttn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Play_PauseBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Play_PauseBttnMouseClicked(evt);
            }
        });
        Play_PauseBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play_PauseBttnActionPerformed(evt);
            }
        });

        NextBttn.setBackground(new java.awt.Color(0, 0, 0));
        NextBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThePlayerPK/images/NEXT.png"))); // NOI18N
        NextBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextBttnMouseClicked(evt);
            }
        });

        StopBttn.setText("stop");
        StopBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StopBttnMouseClicked(evt);
            }
        });

        SongTitleLabel.setBackground(new java.awt.Color(0, 0, 0));
        SongTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        SongTitleLabel.setText("Song Title");

        OpenBttn.setText("open");
        OpenBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenBttnMouseClicked(evt);
            }
        });

        VolDownBttn.setText("-");
        VolDownBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolDownBttnMouseClicked(evt);
            }
        });

        VolFullBttn.setText("full");
        VolFullBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolFullBttnMouseClicked(evt);
            }
        });

        muteBttn.setText("mute");
        muteBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muteBttnMouseClicked(evt);
            }
        });

        VolUPBttn.setText("+");
        VolUPBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolUPBttnMouseClicked(evt);
            }
        });

        ProgressBar.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout ContolPanelLayout = new javax.swing.GroupLayout(ContolPanel);
        ContolPanel.setLayout(ContolPanelLayout);
        ContolPanelLayout.setHorizontalGroup(
            ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContolPanelLayout.createSequentialGroup()
                        .addComponent(SongTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ContolPanelLayout.createSequentialGroup()
                        .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ContolPanelLayout.createSequentialGroup()
                                .addComponent(RepeatBttn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PrevBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ContolPanelLayout.createSequentialGroup()
                                .addComponent(VolUPBttn)
                                .addGap(18, 18, 18)
                                .addComponent(VolDownBttn)
                                .addGap(18, 18, 18)
                                .addComponent(VolFullBttn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(muteBttn)
                            .addGroup(ContolPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Play_PauseBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContolPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(NextBttn)
                                .addGap(40, 40, 40)
                                .addComponent(StopBttn)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContolPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OpenBttn))))
                    .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        ContolPanelLayout.setVerticalGroup(
            ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContolPanelLayout.createSequentialGroup()
                .addComponent(SongTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContolPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NextBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StopBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ContolPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Play_PauseBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContolPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrevBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RepeatBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(ContolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VolFullBttn)
                    .addComponent(VolDownBttn)
                    .addComponent(VolUPBttn)
                    .addComponent(muteBttn))
                .addContainerGap())
        );

        javax.swing.GroupLayout HeaderMainPanelLayout = new javax.swing.GroupLayout(HeaderMainPanel);
        HeaderMainPanel.setLayout(HeaderMainPanelLayout);
        HeaderMainPanelLayout.setHorizontalGroup(
            HeaderMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderMainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhotoHolder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        HeaderMainPanelLayout.setVerticalGroup(
            HeaderMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderMainPanelLayout.createSequentialGroup()
                .addComponent(appTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PhotoHolder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderMainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Play_PauseBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play_PauseBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Play_PauseBttnActionPerformed

    private void Play_PauseBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Play_PauseBttnMouseClicked
        // TODO add your handling code here:
        
        if(isPlaying==false)
        {
            player.play();
            isPlaying=true;
                        
        }
        else
        {
            player.pause();
            isPlaying=false;
        }
        
    }//GEN-LAST:event_Play_PauseBttnMouseClicked

    private void StopBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopBttnMouseClicked
        // TODO add your handling code here:
        player.stop();
        isPlaying=false;
    }//GEN-LAST:event_StopBttnMouseClicked

    private void RepeatBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepeatBttnMouseClicked
        // TODO add your handling code here:
        
        if(repeat==false)
        {
            repeat=true;
            player.setRepeat(repeat);
           
            
        }
        else if(repeat==true)
        {
            repeat=false;
            player.setRepeat(repeat);
        }
        
        
    }//GEN-LAST:event_RepeatBttnMouseClicked

    private void OpenBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenBttnMouseClicked
        // TODO add your handling code here:
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3","Open MP3 Files Only!"));
        int result =  openFileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            songFile=openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            SongTitleLabel.setText("Playing Now... |"+ songFile.getName());
            
            
            
        }
    }//GEN-LAST:event_OpenBttnMouseClicked

    private void VolUPBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolUPBttnMouseClicked
        // TODO add your handling code here:
        VolumeUp(0.1);
    }//GEN-LAST:event_VolUPBttnMouseClicked

    private void VolDownBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolDownBttnMouseClicked
        // TODO add your handling code here:
        VolumeDown(0.1);
    }//GEN-LAST:event_VolDownBttnMouseClicked

    private void VolFullBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolFullBttnMouseClicked
        // TODO add your handling code here:
        VolumeFull(1.0);
    }//GEN-LAST:event_VolFullBttnMouseClicked

    private void muteBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muteBttnMouseClicked
        // TODO add your handling code here:
        VolumeFull(0.0);
    }//GEN-LAST:event_muteBttnMouseClicked

    private void AppTitleLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppTitleLabelMouseDragged
        // TODO add your handling code here:
        int x= evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x, y);
    }//GEN-LAST:event_AppTitleLabelMouseDragged

    private void quitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitLabelMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quitLabelMouseClicked

    private void AppTitleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppTitleLabelMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount()==2)
        {
            if (windowCollapsed==false)
            {
                windowCollapsed=true;
                this.setSize(new Dimension(this.getSize().width,50));
                AppTitleLabel.setFont(new Font("Lucida Blackletter", 0, 12));
                AppTitleLabel.setText("SilverTune : " + songFile.getName());
            }
            else if(windowCollapsed == true)
            {
                windowCollapsed = false;
                this.setSize(new Dimension(this.getSize().width,400));
                AppTitleLabel.setFont(new Font("Lucida Blackletter", 0, 24));
                AppTitleLabel.setText(appName);
                
                
            }
        }
    }//GEN-LAST:event_AppTitleLabelMouseClicked

    private void NextBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextBttnMouseClicked
        // TODO add your handling code here:
        i=i+2;
         String songPath= songListPath[i];
        songFile = new File(songPath);
        
            player.addToPlayList(songFile);
            player.skipForward();
            player.play();
            isPlaying=true;
            currentDirectory = songFile.getAbsolutePath();
            SongTitleLabel.setText("Playing Now... |"+ songFile.getName());
        
        
        
    }//GEN-LAST:event_NextBttnMouseClicked

    private void PrevBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrevBttnMouseClicked
        // TODO add your handling code here:
        i=i-2;
         String songPath= songListPath[i];
        songFile = new File(songPath);
        
            player.addToPlayList(songFile);
            player.skipForward();
            player.play();
            isPlaying=true;
            currentDirectory = songFile.getAbsolutePath();
            SongTitleLabel.setText("Playing Now... |"+ songFile.getName());
            
    }//GEN-LAST:event_PrevBttnMouseClicked

    private void PrevBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevBttnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrevBttnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PlayerFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AppTitleLabel;
    public javax.swing.JPanel ContolPanel;
    public javax.swing.JPanel HeaderMainPanel;
    public javax.swing.JButton NextBttn;
    public javax.swing.JButton OpenBttn;
    public javax.swing.JPanel PhotoHolder1;
    public javax.swing.JPanel PhotoHolder2;
    public javax.swing.JLabel Picture;
    public javax.swing.JButton Play_PauseBttn;
    public javax.swing.JButton PrevBttn;
    public javax.swing.JProgressBar ProgressBar;
    public javax.swing.JButton RepeatBttn;
    public javax.swing.JLabel SongTitleLabel;
    public javax.swing.JButton StopBttn;
    public javax.swing.JButton VolDownBttn;
    public javax.swing.JButton VolFullBttn;
    public javax.swing.JButton VolUPBttn;
    public javax.swing.JPanel appTitlePanel;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JButton muteBttn;
    public javax.swing.JLabel quitLabel;
    // End of variables declaration//GEN-END:variables

    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
    
    private void VolumeDown(Double value)
    {
        Mixer.Info[] mixers =AudioSystem.getMixerInfo();
        for (Mixer.Info mixerinfo: mixers)
        {
            Mixer mixer=AudioSystem.getMixer(mixerinfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo: lineInfos)
            {
                Line line=null;
                boolean opened = true;
                
                try
                {
                    line= mixer.getLine(lineInfo);
                    opened=line.isOpen() || line instanceof Clip;
                    if(!opened)
                    {
                        line.open();
                    }
                    FloatControl volcontrol= (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volcontrol.getValue();
                    Double volumeToCut= value;
                    float changedCalc=(float) ((float)currentVolume- (double)volumeToCut);
                    volcontrol.setValue(changedCalc);
                    
                }
                catch(LineUnavailableException | IllegalArgumentException lineEx){
                }finally
                {
                    if(line!=null && !opened)
                    {
                        line.close();
                    }
                }
            }
        }
    }
    
    
    
    private void VolumeUp(Double value)
    {
        Mixer.Info[] mixers =AudioSystem.getMixerInfo();
        for (Mixer.Info mixerinfo: mixers)
        {
            Mixer mixer=AudioSystem.getMixer(mixerinfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo: lineInfos)
            {
                Line line=null;
                boolean opened = true;
                
                try
                {
                    line= mixer.getLine(lineInfo);
                    opened=line.isOpen() || line instanceof Clip;
                    if(!opened)
                    {
                        line.open();
                    }
                    FloatControl volcontrol= (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volcontrol.getValue();
                    Double volumeToCut= value;
                    float changedCalc=(float) ((float)currentVolume+ (double)volumeToCut);
                    volcontrol.setValue(changedCalc);
                    
                }
                catch(LineUnavailableException | IllegalArgumentException lineEx){
                }finally
                {
                    if(line!=null && !opened)
                    {
                        line.close();
                    }
                }
            }
        }
    }
    
    
    
    private void VolumeFull(Double value)
    {
        Mixer.Info[] mixers =AudioSystem.getMixerInfo();
        for (Mixer.Info mixerinfo: mixers)
        {
            Mixer mixer=AudioSystem.getMixer(mixerinfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo: lineInfos)
            {
                Line line=null;
                boolean opened = true;
                
                try
                {
                    line= mixer.getLine(lineInfo);
                    opened=line.isOpen() || line instanceof Clip;
                    if(!opened)
                    {
                        line.open();
                    }
                    FloatControl volcontrol= (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volcontrol.getValue();
                    Double volumeToCut= value;
                    float changedCalc=(float)((double)volumeToCut);
                    volcontrol.setValue(changedCalc);
                    
                }
                catch(LineUnavailableException | IllegalArgumentException lineEx){
                }finally
                {
                    if(line!=null && !opened)
                    {
                        line.close();
                    }
                }
            }
        }
    }

}
