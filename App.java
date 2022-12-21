package Tictactoe;

/**
 * author : Rahulram
 * 
 */

public class App extends javax.swing.JFrame {
    
    int turn = 0;
    int[] used = {0,0,0,0,0,0,0,0,0,0};
    
    //1 -> x, 2-> O, 0 -> Empty
    int arr[][] = new int[3][3];
    
    int winner(int arr[][]) // -1 -> X , 1 -> O, 0 -> Tie
    {
        for(int i=0;i<3;i++)
        {
            if(arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1) return -1;
            if(arr[i][0] == 2 && arr[i][1] == 2 && arr[i][2] == 2) return 1;
            if(arr[0][i] == 1 && arr[1][i] == 1 && arr[2][i] == 1) return -1;
            if(arr[0][i] == 2 && arr[1][i] == 2 && arr[2][i] == 2) return 1;
        }
        
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return -1;
        if(arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) return 1;
        
        if(arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) return -1;
        if(arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2) return 1;
        
        int flag = 1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j] == 0) flag = 0;
            }
        }
        
        if(flag == 1) return 0;
        
        return 100; // game needs to continue
    }
    
    void win(int arr[][])
    {
        int ans = winner(arr);
        
        System.out.println(ans);
        
        if(ans != 100) {
            for(int i=1;i<10;i++) used[i] = 1;
            
            if(ans == 0) text.setText("Draw !");
            else if(ans == -1) text.setText("X Won");
            else text.setText("O Won");
        }
    }
    
    int minmax(int arr[][],int depth,Boolean isMax)
    {   
        int result = winner(arr);
        
        if(result != 100) {
            return result;
        }
        
        if(isMax){
            int bestScore = -1000;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++)
                {
                    if(arr[i][j] == 0){
                        arr[i][j] = 2;
                        int score = minmax(arr,depth+1,false);
                        arr[i][j] = 0;
                        if(score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
        else {
            int bestScore = 1000;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++)
                {
                    if(arr[i][j] == 0){
                        arr[i][j] = 1;
                        int score = minmax(arr,depth+1,true);
                        arr[i][j] = 0;
                        if(score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
    
    void Ai_Move() {
        
        int bestScore  = -100;
        int bestMove[] = {-1,-1};
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 2;
                    int score = minmax(arr,0,false);
                    arr[i][j] = 0;
                    if(score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        
        if(bestMove[0] == -1) return;
        
        arr[bestMove[0]][bestMove[1]] = 2;
        
        int no = (bestMove[0]*3 + bestMove[1] + 1);
        
        if(used[no] == 1) return;
        
        used[no] = 1;
        
        if(no == 1) b1.setText("O");
        else if(no == 2) b2.setText("O");
        else if(no == 3) b3.setText("O");
        else if(no == 4) b4.setText("O");
        else if(no == 5) b5.setText("O");
        else if(no == 6) b6.setText("O");
        else if(no == 7) b7.setText("O");
        else if(no == 8) b8.setText("O");
        else if(no == 9) b9.setText("O");
        
        turn++;
    }
     
    public App() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        b9 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        text = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(700, 550));

        b9.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        text.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N

        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jButton1.setText("Again ? ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel1.setText("              Tic - Tac - Toe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[9] == 1) return;
        
        if(turn%2 == 0) {
            b9.setText("X");
            arr[2][2] = 1;
        }
        else {
            b9.setText("O");
        }
        
        used[9] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[3] == 1) return;
        
        if(turn%2 == 0) {
            b3.setText("X");
            arr[0][2] = 1;
        }
        else {
            b3.setText("O");
        }
        
        used[3] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[4] == 1) return;
        
        if(turn%2 == 0) {
            b4.setText("X");
            arr[1][0] = 1;
        }
        else {
            b4.setText("O");
        }
        
        used[4] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[5] == 1) return;
        
        if(turn%2 == 0) {
            b5.setText("X");
            arr[1][1] = 1;
        }
        else {
            b5.setText("O");
        }
        
        used[5] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[6] == 1) return;
        
        if(turn%2 == 0) {
            b6.setText("X");
            arr[1][2] = 1;
        }
        else {
            b6.setText("O");
        }
        
        used[6] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        
        System.out.println(winner(arr));
    }                                  

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[7] == 1) return;
        
        if(turn%2 == 0) {
            b7.setText("X");
            arr[2][0] = 1;
        }
        else {
            b7.setText("O");
        }
        
        used[7] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[1] == 1) return;
        
        if(turn%2 == 0) {
            b1.setText("X");
            arr[0][0] = 1;
        }
        else {
            b1.setText("O");
        }
        
        used[1] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[2] == 1) return;
        
        if(turn%2 == 0) {
            b2.setText("X");
            arr[0][1] = 1;
        }
        else {
            b2.setText("O");
        }
        
        used[2] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        if(used[8] == 1) return;
        
        if(turn%2 == 0) {
            b8.setText("X");
            arr[2][1] = 1;
        }
        else {
            b8.setText("O");
        }
        
        used[8] = 1;
        turn++;
        win(arr);
        
        Ai_Move();
        win(arr);
        System.out.println(winner(arr));
    }                                  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        turn = 0;
        for(int i=1;i<10;i++) used[i] = 0;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j] = 0;
            }
        }
        
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        
        text.setText("");
    }                                        

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel text;
    // End of variables declaration                   
}
