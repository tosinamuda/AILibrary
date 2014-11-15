/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Search.Search;
import Model.Graph.Edge;
import Model.Graph.Graph;
import Model.Graph.Node;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author tosinamuda
 */
public class DLSVisualize extends javax.swing.JPanel {

    /**
     * Creates new form DrawNode
     */
    public DLSVisualize() {
        initComponents();
        graph = new Graph();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDrawPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonNodeEdgeAction = new javax.swing.JButton();
        jComboBoxSelectNodeEdgeAction = new javax.swing.JComboBox();
        jTextFieldNodeA = new javax.swing.JTextField();
        jLabelNodeA = new javax.swing.JLabel();
        jLabelNodeB = new javax.swing.JLabel();
        jTextFieldNodeB = new javax.swing.JTextField();
        jTextFieldLimit = new javax.swing.JTextField();
        jTextFieldLimit.setVisible(false);
        jLabelLimit = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanelDrawPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jPanelDrawPanel.setToolTipText("Click to draw a Node");
        jPanelDrawPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelDrawPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDrawPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDrawPanelLayout = new javax.swing.GroupLayout(jPanelDrawPanel);
        jPanelDrawPanel.setLayout(jPanelDrawPanelLayout);
        jPanelDrawPanelLayout.setHorizontalGroup(
            jPanelDrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelDrawPanelLayout.setVerticalGroup(
            jPanelDrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jButtonNodeEdgeAction.setText("Enter");
        jButtonNodeEdgeAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNodeEdgeActionActionPerformed(evt);
            }
        });

        jComboBoxSelectNodeEdgeAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add Edge", "Delete Edge", "Delete Node", "Select Start and Goal Node" }));
        jComboBoxSelectNodeEdgeAction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSelectNodeEdgeActionItemStateChanged(evt);
            }
        });
        jComboBoxSelectNodeEdgeAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectNodeEdgeActionActionPerformed(evt);
            }
        });

        jLabelNodeA.setText("Node 1");

        jLabelNodeB.setText("Node 2");

        jLabelLimit.setText("Limit");
        jLabelLimit.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxSelectNodeEdgeAction, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNodeA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNodeA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNodeB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNodeB))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNodeEdgeAction, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLimit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldLimit))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNodeA)
                    .addComponent(jLabelNodeB)
                    .addComponent(jLabelLimit))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNodeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNodeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSelectNodeEdgeAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonNodeEdgeAction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDrawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDrawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formMousePressed

    private void jComboBoxSelectNodeEdgeActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectNodeEdgeActionActionPerformed
        // TODO add your handling code here:
        javax.swing.JComboBox cb = (javax.swing.JComboBox) evt.getSource();
        int index = cb.getSelectedIndex();
        jLabelLimit.setVisible(false);
        jTextFieldLimit.setVisible(false);

        if (index == 2) {
            jLabelNodeB.setVisible(false);
            jTextFieldNodeB.setVisible(false);
        } else if (index == 3) {
            jLabelNodeA.setText("Start Node");

            jLabelNodeB.setVisible(false);
            jTextFieldNodeB.setVisible(false);

            jLabelLimit.setVisible(true);
            jTextFieldLimit.setVisible(true);
        } else if (index == 0 || index == 1) {
            jLabelNodeA.setText("Node 1");
            jLabelNodeB.setText("Node 2");
            jLabelNodeB.setVisible(true);
            jTextFieldNodeB.setVisible(true);
        }


    }//GEN-LAST:event_jComboBoxSelectNodeEdgeActionActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_formMouseClicked

    private void jButtonNodeEdgeActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNodeEdgeActionActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jComboBoxSelectNodeEdgeAction.getSelectedIndex();
        String node1Value = jTextFieldNodeA.getText();

        Node node1 = findNode(node1Value);

        if (selectedIndex == 0 || selectedIndex == 1) {
            String node2Value = jTextFieldNodeB.getText();
            Node node2 = findNode(node2Value);
            if (node1 == null || node2 == null) {
                JOptionPane.showMessageDialog(this, "One of the Nodes does not exist...Please Enter The Right Node");

            } else if (selectedIndex == 0) {

                graph.ListofEdges.add(new Edge(node1, node2));
                graph.AddEdge(node1, node2);
                repaint();
            } else if (selectedIndex == 1) {
             //TO-DO     do edge and node delete function

                graph.ListofEdges.add(new Edge(node1, node2));
                graph.AddEdge(node1, node2);
                repaint();
            }

        } //Option for deleteNode
        else if (selectedIndex == 2) {
            if (node1 == null) {
                JOptionPane.showMessageDialog(this, "The Node entered  does not exist...Please Enter The Right Node");

            }

        } else if (selectedIndex == 3) {

            if (jTextFieldLimit.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Wrong Entry...Please Try Again");

            } else {
                int limit = Integer.parseInt(jTextFieldLimit.getText());
                Search search = new Model.Search.UninformedSearch.DepthLimitedSearch(this.graph, limit);

                task = new Task(node1, search);
                task.execute();
            }

        }
    }//GEN-LAST:event_jButtonNodeEdgeActionActionPerformed

    private Node findNode(String nodeValue) {
        Node foundNode = null;
        for (Node n : graph.ListofNodes) {
            if (n.Label().equals(nodeValue)) {
                foundNode = n;
            }
        }
        return foundNode;

    }

    private void jComboBoxSelectNodeEdgeActionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSelectNodeEdgeActionItemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxSelectNodeEdgeActionItemStateChanged

    private void jPanelDrawPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDrawPanelMouseClicked
        // TODO add your handling code here:
        Node newNode = new Node(String.valueOf(Graph.countNode), 20, evt.getPoint());
        graph.ListofNodes.add(newNode);
        graph.AddNode(newNode);
        repaint();
    }//GEN-LAST:event_jPanelDrawPanelMouseClicked

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Check if the graph has empty nodes
        if (!graph.ListofNodes.isEmpty()) {

            //Draw all nodes in a graph    
            for (Node n : graph.ListofNodes) {
                n.drawCircle(g2);

            }
        }

        //Check if the graph has empty edges
        if (!graph.ListofEdges.isEmpty()) {

            //Draw all edges in a graph   
            for (Edge e : graph.ListofEdges) {
                e.drawEdge(g2);
            }
        }
    }

    public static void main(String[] args) {
        DLSVisualize drawNode = new DLSVisualize();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawNode);
        frame.setSize(200, 400);
        frame.pack();
        frame.setVisible(true);
    }

    class Task extends SwingWorker<Void, Node> {

        public Node startNode;
        public Search search;

        Task(Node startNode, Search search) {

            this.startNode = startNode;
            this.search = search;

        }

        @Override
        protected Void doInBackground() throws InterruptedException {

            List<Node> lst = search.Search(startNode);
            Iterator iterator = lst.iterator();
            for (int i = 0; i < lst.size(); i++) {
                lst.get(i).setVisited(true);
                Thread.sleep(1000);
                publish(lst.get(i));

            }
            return null;
        }

        @Override
        protected void process(List<Node> nodes) {
            repaint();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNodeEdgeAction;
    private javax.swing.JComboBox jComboBoxSelectNodeEdgeAction;
    private javax.swing.JLabel jLabelLimit;
    private javax.swing.JLabel jLabelNodeA;
    private javax.swing.JLabel jLabelNodeB;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDrawPanel;
    private javax.swing.JTextField jTextFieldLimit;
    private javax.swing.JTextField jTextFieldNodeA;
    private javax.swing.JTextField jTextFieldNodeB;
    // End of variables declaration//GEN-END:variables

    private Node node;
    private Node nodeA;
    private Node nodeB;

    private Graph graph;
    private Task task;
}
