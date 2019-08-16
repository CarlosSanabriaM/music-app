/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        //Color Panel arriba
        Color color_panel_arriba = new Color(40,40,40);//(54, 57, 59);
        Color color_panel_izda = new Color(18,18,18);//(38, 41, 44);
        pReproduccionArriba.setBackground(color_panel_arriba);
        pReproduccionIzda.setBackground(color_panel_izda);
        listaPlayLists.setBackground(color_panel_izda);
        pNuevaPlayList.setBackground(color_panel_izda);
        pEcualizadorVP.setBackground(color_panel_arriba);
        pInferior.setBackground(color_panel_arriba);
        
        
        //Variables
        aleatorioON=false;
        repetirON=false;
        playOK=false;
        rojo=new Color(255,102,102);
        grisMuyClaro= new Color(160,160,160);
        verde=new Color(204,255,204);
        
        //Metemos los paneles en el Contenedor
        panelContenedor.add(pRecomendados,"pRecomendados");
        panelContenedor.add(pGeneros,"pGeneros");
        panelContenedor.add(pTusCanciones,"pTusCanciones");
        panelContenedor.add(pPLFavoritos,"pPLFavoritos");
        panelContenedor.add(pPLCoche,"pPLCoche");
        
        //Ponemos los iconos de los generos
        PonerIconoAjustado(lGeneroPop,"genero pop.png","iconosGeneros");
        PonerIconoAjustado(lGeneroRock,"genero rock.png","iconosGeneros");
        PonerIconoAjustado(lGeneroHipHop,"genero hip hop.png","iconosGeneros");
        PonerIconoAjustado(lGeneroMetal,"genero metal.png","iconosGeneros");
        PonerIconoAjustado(lGeneroDance,"genero dance.png","iconosGeneros");
        PonerIconoAjustado(lGeneroIndie_Alternativa,"genero indie_alternativa.png","iconosGeneros");
        PonerIconoAjustado(lGeneroClasica,"genero clasica.png","iconosGeneros");
        PonerIconoAjustado(lGeneroLatina,"genero latina.png","iconosGeneros");
        
        
        //Cambiamos el modelo de las listas para que se puedan añadir y borrar elementos
        listaPlayLists.setModel(new javax.swing.DefaultListModel());
        
        //Metemos playlists por defecto
        javax.swing.DefaultListModel DLM = (javax.swing.DefaultListModel) listaPlayLists.getModel();
        DLM.addElement("Favoritos");
        DLM.addElement("Coche");
        
        //Metemos canciones por defecto en tus canciones
        tablaTusCanciones.setModel(new DefaultTableModel());//Modificamos el modelo de la tabla para poder añadir y borrar elementos
        DefaultTableModel DTM_TusCanciones = (DefaultTableModel) tablaTusCanciones.getModel();
        tablaTusCanciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Solo podemos seleccionar una cancion a la vez
        //Metemos las columnas
        añadirColumnas(DTM_TusCanciones);
        //Añadimos canciones
        String[] s1= {"Shape of You","Ed Sheeran","Divide","Pop","3:54"};
        String[] s2= {"Castle on the Hill","Ed Sheeran","Divide","Pop","4:21"};
        String[] s3= {"Photograph","Ed Sheeran","X","Pop","3:54"};
        String[] s4= {"Sing","Ed Sheeran","X","Pop","3:55"};
        String[] s5= {"Don't","Ed Sheeran","X","Pop","3:40"};
        String[] s6= {"Numb","Linkin Park","Meteora","Rock","3:06"};
        String[] s7= {"Faint","Linkin Park","Meteora","Rock","2:44"};
        String[] s8= {"In The End","Linkin Park","Hybrid Theory","Rock","3:39"};
        String[] s9= {"Crawling","Linkin Park","Hybrid Theory","Rock","3:31"};
        String[] s10= {"Despacito","Luis Fonsi","Despacito(Single)","Latina","3:48"};
        String[] s11= {"Chantaje","Shakira","Chantaje(Single)","Latina","3:16"};
        String[] s12= {"La Bicicleta","Shakira","La Bicicleta(Single)","Latina","3:47"};
        String[] s13= {"Requiem: Lacrimosa","Mozart","Mozart: Requiem Realisations","Clásica","4:07"};
        String[] s14= {"Requiem: Kyrie","Mozart","Mozart: Requiem Realisations","Clásica","2:39"};
        String[] s15= {"Requiem: Dies irae","Mozart","Mozart: Requiem Realisations","Clásica","1:55"};
        String[] s16= {"Requiem: Tuba mirum","Mozart","Mozart: Requiem Realisations","Clásica","2:59"};
        String[] s17= {"Requiem: Rex tremendae","Mozart","Mozart: Requiem Realisations","Clásica","1:26"};
        String[] s18= {"Requiem: Sanctus","Mozart","Mozart: Requiem Realisations","Clásica","4:57"};
        String[] s19= {"Requiem: Benedictus","Mozart","Mozart: Requiem Realisations","Clásica","4:27"};
        String[] s20= {"Requiem: Amen","Mozart","Mozart: Requiem Realisations","Clásica","2:32"};
        String[] s21= {"Fake Love","Drake","Fake Love(Single)","Hip Hop","3:28"};
        String[] s22= {"One Dance","Drake","Views","Hip Hop","2:54"};
        String[] s23= {"Too Good","Drake","Views","Hip Hop","4:23"};
        String[] s24= {"Controlla","Drake","Views","Hip Hop","1:56"};
        String[] s25= {"Hotline Bling","Drake","Views","Hip Hop","3:13"};
        String[] s26= {"24K Magic","Bruno Mars","24K Magic","Pop","3:46"};
        String[] s27= {"Perm","Bruno Mars","24K Magic","Pop","3:30"};
        
        
        añadirFilas(DTM_TusCanciones, s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27);
        
        
        //Metemos canciones por defecto en la PL Favoritos(son canciones que han de estar en la tabla de Tus Canciones)
        tablaPLFavoritos.setModel(new DefaultTableModel());//Modificamos el modelo de la tabla para poder añadir y borrar elementos
        DefaultTableModel DTM_PLFavoritos = (DefaultTableModel) tablaPLFavoritos.getModel();
        tablaPLFavoritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Solo podemos seleccionar una cancion a la vez
        //Metemos las columnas
        añadirColumnas(DTM_PLFavoritos);
        //Añadimos canciones
        añadirFilas(DTM_PLFavoritos, s1,s4,s6,s8,s10,s12,s13,s22,s27);
        
        
        //Metemos canciones por defecto en la PL Coche(son canciones que han de estar en la tabla de Tus Canciones)
        tablaPLCoche.setModel(new DefaultTableModel());//Modificamos el modelo de la tabla para poder añadir y borrar elementos
        DefaultTableModel DTM_PLCoche = (DefaultTableModel) tablaPLCoche.getModel();
        tablaPLCoche.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Solo podemos seleccionar una cancion a la vez
        //Metemos las columnas
        añadirColumnas(DTM_PLCoche);
        //Añadimos canciones
        añadirFilas(DTM_PLCoche, s7,s4,s6,s19,s20);
        
        String[] s28= {"Locked Out of Heaven","Bruno Mars","Unorthodox Jukebox","Pop","3:43"};
        String[] s29= {"Treasure","Bruno Mars","Unorthodox Jukebox","Pop","3:43"};
        String[] s30= {"Money Make Her Smile","Bruno Mars","Unorthodox Jukebox","Pop","3:24"};
        String[] s31= {"Basket Case","Green Day","Dookie","Rock","3:02"};
        String[] s32= {"Burnout","Green Day","Dookie","Rock","2:08"};
        String[] s33= {"Chump","Green Day","Dookie","Rock","2:54"};
        String[] s34= {"Coming Clean","Green Day","Dookie","Rock","1:35"};
        String[] s35= {"American Idiot","Green Day","American Idiot","Rock","2:56"};
        String[] s36= {"Wake Me Up When September Ends","Green Day","American Idiot","Rock","4:46"};
        String[] s37= {"Whatsername","Green Day","American Idiot","Rock","4:17"};
        String[] s38= {"Can't Hold Us","Macklemore","The Heist","Rap","4:18"};
        String[] s39= {"Ten Thousand Hours","Macklemore","The Heist","Rap","4:10"};
        String[] s40= {"Thrift Shop","Macklemore","The Heist","Rap","3:56"};
        String[] s41= {"Make The Money","Macklemore","The Heist","Rap","3:44"};
        String[] s42= {"White Walls","Macklemore","The Heist","Rap","3:39"};
        String[] s43= {"Downtown","Macklemore","This Unruly Mess I've Made","Rap","4:53"};
        String[] s44= {"Light Tunels","Macklemore","This Unruly Mess I've Made","Rap","6:38"};
        String[] s45= {"St. Ides","Macklemore","This Unruly Mess I've Made","Rap","3:39"};
        String[] s46= {"Kevin","Macklemore","This Unruly Mess I've Made","Rap","4:40"};
        String[] s47= {"Need To Know","Macklemore","This Unruly Mess I've Made","Rap","3:52"};
        String [] s48= {"Sincericidio","Leiva","Monstruos","Rock","4:11"};

        
        //Metemos canciones por defecto en Recomendados
        tablaRecomendados.setModel(new DefaultTableModel());//Modificamos el modelo de la tabla para poder añadir y borrar elementos
        DefaultTableModel DTM_Recomendados = (DefaultTableModel) tablaRecomendados.getModel();
        tablaRecomendados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Solo podemos seleccionar una cancion a la vez
        //Metemos las columnas
        añadirColumnas(DTM_Recomendados);
        //Añadimos canciones
        añadirFilas(DTM_Recomendados, s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,s43,s44,s45,s46,s47,s48);
        
        
        //Ventanas
        NPLD = new NuevaPlaylistDialog();
        ECU = new Ecualizador(this);
        VOL = new Volumen(this);
        AAPL = new AniadirAPlaylist(this);
        INI = new VentanaInicial(this);
        INI.setVisible(true);
        LC = new LetraCancion(this);
        TM = new TareaMusic(this);
    }
    


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoDeAudioConfiguracion = new javax.swing.ButtonGroup();
        bgmiTipoDeAudio = new javax.swing.ButtonGroup();
        tpPrincipal = new javax.swing.JTabbedPane();
        pReproductor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pReproduccionIzda = new javax.swing.JPanel();
        lRecomendados = new javax.swing.JLabel();
        lGeneros = new javax.swing.JLabel();
        lTusCanciones = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        listaPlayLists = new javax.swing.JList<>();
        pNuevaPlayList = new javax.swing.JPanel();
        lNueva = new javax.swing.JLabel();
        lPlayList = new javax.swing.JLabel();
        lMasNuevaPlaylist = new javax.swing.JLabel();
        pEcualizadorVP = new javax.swing.JPanel();
        lActivadoDesactivadoEcualizador = new javax.swing.JLabel();
        lModoEcuVP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pInferior = new javax.swing.JPanel();
        lAñadirAPlaylist = new javax.swing.JLabel();
        lGuardarEnTusCanciones = new javax.swing.JLabel();
        lReproducir = new javax.swing.JLabel();
        lEliminarDeLaPlaylist = new javax.swing.JLabel();
        lEliminarDeTusCanciones = new javax.swing.JLabel();
        lTerminarCancion = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        pRecomendados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRecomendados = new javax.swing.JTable();
        pTusCanciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTusCanciones = new javax.swing.JTable();
        pPLFavoritos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPLFavoritos = new javax.swing.JTable();
        pPLCoche = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaPLCoche = new javax.swing.JTable();
        pGeneros = new javax.swing.JPanel();
        lGeneroPop = new javax.swing.JLabel();
        lGeneroRock = new javax.swing.JLabel();
        lGeneroHipHop = new javax.swing.JLabel();
        lGeneroMetal = new javax.swing.JLabel();
        lGeneroDance = new javax.swing.JLabel();
        lGeneroIndie_Alternativa = new javax.swing.JLabel();
        lGeneroLatina = new javax.swing.JLabel();
        lGeneroClasica = new javax.swing.JLabel();
        pTienda = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tfNumeroTarjetaCreditoTienda = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbMesTienda = new javax.swing.JComboBox<>();
        cbAñoTienda = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        pfNumeroSeguridadTienda = new javax.swing.JPasswordField();
        bProcederPagoTienda = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfNombreTienda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfApellidosTienda = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfDireccionTienda = new javax.swing.JTextField();
        tfCodigoPostalTienda = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfDNITienda = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfTelefonoTienda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pConfiguracion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbIdioma = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbSalidaAudio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        rbEstereo = new javax.swing.JRadioButton();
        rbMono = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        slVolDefecto = new javax.swing.JSlider();
        spVolDefecto = new javax.swing.JSpinner();
        slVolMaximo = new javax.swing.JSlider();
        spVolMaximo = new javax.swing.JSpinner();
        bEcualizador = new javax.swing.JButton();
        pReproduccionArriba = new javax.swing.JPanel();
        lPlayPause = new javax.swing.JLabel();
        lAvanzar = new javax.swing.JLabel();
        lRetroceder = new javax.swing.JLabel();
        lTiempoActualCancion = new javax.swing.JLabel();
        lTiempoFinalCancion = new javax.swing.JLabel();
        pbCancion = new javax.swing.JProgressBar();
        lRepetir = new javax.swing.JLabel();
        lAleatorio = new javax.swing.JLabel();
        lBocinaVolumen = new javax.swing.JLabel();
        slVolumen = new javax.swing.JSlider();
        lNombreCancion = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        miNuevaPlaylist = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        miSalirAplicacion = new javax.swing.JMenuItem();
        mCancion = new javax.swing.JMenu();
        miGuardarEnTusCanciones = new javax.swing.JMenuItem();
        miAñadirAPlaylist = new javax.swing.JMenuItem();
        miEliminarDeTusCanciones = new javax.swing.JMenuItem();
        mReproduccion = new javax.swing.JMenu();
        miReanudarPausar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSiguiente = new javax.swing.JMenuItem();
        miAnterior = new javax.swing.JMenuItem();
        miAvanzar = new javax.swing.JMenuItem();
        miRetroceder = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miAleatorio = new javax.swing.JCheckBoxMenuItem();
        miRepetir = new javax.swing.JCheckBoxMenuItem();
        cbmiLetraCancion = new javax.swing.JCheckBoxMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miSubirVolumen = new javax.swing.JMenuItem();
        miBajarVolumen = new javax.swing.JMenuItem();
        cbmiMostrarVolumen = new javax.swing.JCheckBoxMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        rbmiEstereo = new javax.swing.JRadioButtonMenuItem();
        rbmiMono = new javax.swing.JRadioButtonMenuItem();
        miIniciarSesion = new javax.swing.JMenu();
        miCerrarSesion = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MusicApp");
        setResizable(false);

        tpPrincipal.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lRecomendados.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lRecomendados.setForeground(new java.awt.Color(160, 160, 160));
        lRecomendados.setText("Recomendados");
        lRecomendados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lRecomendadosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lRecomendadosMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lRecomendadosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lRecomendadosMouseEntered(evt);
            }
        });

        lGeneros.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lGeneros.setForeground(new java.awt.Color(160, 160, 160));
        lGeneros.setText("Géneros");
        lGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lGenerosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lGenerosMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lGenerosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lGenerosMouseEntered(evt);
            }
        });

        lTusCanciones.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lTusCanciones.setForeground(new java.awt.Color(160, 160, 160));
        lTusCanciones.setText("Tus Canciones");
        lTusCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lTusCancionesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lTusCancionesMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lTusCancionesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lTusCancionesMouseEntered(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(160, 160, 160));
        jLabel4.setText("PLAYLISTS");

        listaPlayLists.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        listaPlayLists.setForeground(new java.awt.Color(160, 160, 160));
        listaPlayLists.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Favoritos", "Coche" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPlayLists.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPlayLists.setOpaque(false);
        listaPlayLists.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPlayListsValueChanged(evt);
            }
        });

        javax.swing.GroupLayout pReproduccionIzdaLayout = new javax.swing.GroupLayout(pReproduccionIzda);
        pReproduccionIzda.setLayout(pReproduccionIzdaLayout);
        pReproduccionIzdaLayout.setHorizontalGroup(
            pReproduccionIzdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproduccionIzdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pReproduccionIzdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pReproduccionIzdaLayout.createSequentialGroup()
                        .addGroup(pReproduccionIzdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lRecomendados)
                            .addComponent(lGeneros)
                            .addComponent(jLabel4)
                            .addComponent(lTusCanciones))
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(pReproduccionIzdaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(listaPlayLists, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pReproduccionIzdaLayout.setVerticalGroup(
            pReproduccionIzdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproduccionIzdaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lRecomendados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lGeneros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lTusCanciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPlayLists, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pReproduccionIzda);

        pNuevaPlayList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pNuevaPlayListMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pNuevaPlayListMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pNuevaPlayListMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pNuevaPlayListMouseEntered(evt);
            }
        });

        lNueva.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        lNueva.setForeground(new java.awt.Color(160, 160, 160));
        lNueva.setText("Nueva");

        lPlayList.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        lPlayList.setForeground(new java.awt.Color(160, 160, 160));
        lPlayList.setText("PlayList");

        lMasNuevaPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/mas borde gris.png"))); // NOI18N

        javax.swing.GroupLayout pNuevaPlayListLayout = new javax.swing.GroupLayout(pNuevaPlayList);
        pNuevaPlayList.setLayout(pNuevaPlayListLayout);
        pNuevaPlayListLayout.setHorizontalGroup(
            pNuevaPlayListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNuevaPlayListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lMasNuevaPlaylist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(pNuevaPlayListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPlayList)
                    .addComponent(lNueva))
                .addGap(21, 21, 21))
        );
        pNuevaPlayListLayout.setVerticalGroup(
            pNuevaPlayListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNuevaPlayListLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(lNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPlayList)
                .addGap(12, 12, 12))
            .addGroup(pNuevaPlayListLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lMasNuevaPlaylist)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pEcualizadorVP.setBackground(new java.awt.Color(255, 255, 255));
        pEcualizadorVP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ecualizador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18), new java.awt.Color(160, 160, 160))); // NOI18N
        pEcualizadorVP.setForeground(new java.awt.Color(204, 204, 204));

        lActivadoDesactivadoEcualizador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cruz gris.png"))); // NOI18N

        lModoEcuVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/uniforme azul.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(160, 160, 160));
        jLabel9.setText("Activado:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(160, 160, 160));
        jLabel11.setText("Modo:");

        javax.swing.GroupLayout pEcualizadorVPLayout = new javax.swing.GroupLayout(pEcualizadorVP);
        pEcualizadorVP.setLayout(pEcualizadorVPLayout);
        pEcualizadorVPLayout.setHorizontalGroup(
            pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEcualizadorVPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lModoEcuVP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lActivadoDesactivadoEcualizador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEcualizadorVPLayout.setVerticalGroup(
            pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEcualizadorVPLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lActivadoDesactivadoEcualizador)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEcualizadorVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEcualizadorVPLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pEcualizadorVPLayout.createSequentialGroup()
                        .addComponent(lModoEcuVP, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pInferior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lAñadirAPlaylist.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lAñadirAPlaylist.setForeground(new java.awt.Color(210, 210, 210));
        lAñadirAPlaylist.setText("Añadir a playlist");
        lAñadirAPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lAñadirAPlaylist.setEnabled(false);
        lAñadirAPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAñadirAPlaylistMouseClicked(evt);
            }
        });

        lGuardarEnTusCanciones.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lGuardarEnTusCanciones.setForeground(new java.awt.Color(210, 210, 210));
        lGuardarEnTusCanciones.setText("Guardar en tus canciones");
        lGuardarEnTusCanciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGuardarEnTusCanciones.setEnabled(false);
        lGuardarEnTusCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGuardarEnTusCancionesMouseClicked(evt);
            }
        });

        lReproducir.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lReproducir.setForeground(new java.awt.Color(210, 210, 210));
        lReproducir.setText("Reproducir");
        lReproducir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lReproducir.setEnabled(false);
        lReproducir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lReproducirMouseClicked(evt);
            }
        });

        lEliminarDeLaPlaylist.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lEliminarDeLaPlaylist.setForeground(new java.awt.Color(210, 210, 210));
        lEliminarDeLaPlaylist.setText("Eliminar de la playlist");
        lEliminarDeLaPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lEliminarDeLaPlaylist.setEnabled(false);
        lEliminarDeLaPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEliminarDeLaPlaylistMouseClicked(evt);
            }
        });

        lEliminarDeTusCanciones.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lEliminarDeTusCanciones.setForeground(new java.awt.Color(210, 210, 210));
        lEliminarDeTusCanciones.setText("Eliminar de tus canciones");
        lEliminarDeTusCanciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lEliminarDeTusCanciones.setEnabled(false);
        lEliminarDeTusCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEliminarDeTusCancionesMouseClicked(evt);
            }
        });

        lTerminarCancion.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lTerminarCancion.setForeground(new java.awt.Color(210, 210, 210));
        lTerminarCancion.setText("Terminar canción");
        lTerminarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lTerminarCancion.setEnabled(false);
        lTerminarCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lTerminarCancionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pInferiorLayout = new javax.swing.GroupLayout(pInferior);
        pInferior.setLayout(pInferiorLayout);
        pInferiorLayout.setHorizontalGroup(
            pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAñadirAPlaylist)
                    .addComponent(lGuardarEnTusCanciones)
                    .addComponent(lReproducir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lEliminarDeTusCanciones)
                    .addComponent(lEliminarDeLaPlaylist)
                    .addComponent(lTerminarCancion))
                .addGap(24, 24, 24))
        );
        pInferiorLayout.setVerticalGroup(
            pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAñadirAPlaylist)
                    .addComponent(lEliminarDeLaPlaylist))
                .addGap(27, 27, 27)
                .addGroup(pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGuardarEnTusCanciones)
                    .addComponent(lEliminarDeTusCanciones))
                .addGap(27, 27, 27)
                .addGroup(pInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lReproducir)
                    .addComponent(lTerminarCancion))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panelContenedor.setLayout(new java.awt.CardLayout());

        pRecomendados.setBackground(new java.awt.Color(255, 255, 255));

        tablaRecomendados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Canción", "Artista", "Álbum", "Género", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaRecomendados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRecomendadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaRecomendadosMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tablaRecomendados);

        javax.swing.GroupLayout pRecomendadosLayout = new javax.swing.GroupLayout(pRecomendados);
        pRecomendados.setLayout(pRecomendadosLayout);
        pRecomendadosLayout.setHorizontalGroup(
            pRecomendadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        pRecomendadosLayout.setVerticalGroup(
            pRecomendadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        panelContenedor.add(pRecomendados, "card2");

        pTusCanciones.setBackground(new java.awt.Color(255, 255, 255));
        pTusCanciones.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pTusCancionesComponentShown(evt);
            }
        });

        tablaTusCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Canción", "Artista", "Álbum", "Género", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaTusCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTusCancionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaTusCancionesMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTusCanciones);

        javax.swing.GroupLayout pTusCancionesLayout = new javax.swing.GroupLayout(pTusCanciones);
        pTusCanciones.setLayout(pTusCancionesLayout);
        pTusCancionesLayout.setHorizontalGroup(
            pTusCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        pTusCancionesLayout.setVerticalGroup(
            pTusCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        panelContenedor.add(pTusCanciones, "card2");

        pPLFavoritos.setBackground(new java.awt.Color(255, 255, 255));

        tablaPLFavoritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Canción", "Artista", "Álbum", "Género", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPLFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPLFavoritosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaPLFavoritosMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tablaPLFavoritos);

        javax.swing.GroupLayout pPLFavoritosLayout = new javax.swing.GroupLayout(pPLFavoritos);
        pPLFavoritos.setLayout(pPLFavoritosLayout);
        pPLFavoritosLayout.setHorizontalGroup(
            pPLFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        pPLFavoritosLayout.setVerticalGroup(
            pPLFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        panelContenedor.add(pPLFavoritos, "card2");

        pPLCoche.setBackground(new java.awt.Color(255, 255, 255));

        tablaPLCoche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Canción", "Artista", "Álbum", "Género", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPLCoche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPLCocheMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaPLCocheMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tablaPLCoche);

        javax.swing.GroupLayout pPLCocheLayout = new javax.swing.GroupLayout(pPLCoche);
        pPLCoche.setLayout(pPLCocheLayout);
        pPLCocheLayout.setHorizontalGroup(
            pPLCocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        pPLCocheLayout.setVerticalGroup(
            pPLCocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        panelContenedor.add(pPLCoche, "card2");

        pGeneros.setBackground(new java.awt.Color(255, 255, 255));
        pGeneros.setLayout(new java.awt.GridLayout(2, 4, 40, 20));

        lGeneroPop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroPop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroPopMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroPop);

        lGeneroRock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroRock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroRockMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroRock);

        lGeneroHipHop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroHipHop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroHipHopMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroHipHop);

        lGeneroMetal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroMetal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroMetalMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroMetal);

        lGeneroDance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroDance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroDanceMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroDance);

        lGeneroIndie_Alternativa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroIndie_Alternativa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroIndie_AlternativaMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroIndie_Alternativa);

        lGeneroLatina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroLatina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroLatinaMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroLatina);

        lGeneroClasica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lGeneroClasica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGeneroClasicaMouseClicked(evt);
            }
        });
        pGeneros.add(lGeneroClasica);

        panelContenedor.add(pGeneros, "card2");

        javax.swing.GroupLayout pReproductorLayout = new javax.swing.GroupLayout(pReproductor);
        pReproductor.setLayout(pReproductorLayout);
        pReproductorLayout.setHorizontalGroup(
            pReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproductorLayout.createSequentialGroup()
                .addGroup(pReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pNuevaPlayList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pReproductorLayout.createSequentialGroup()
                        .addComponent(pInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pEcualizadorVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        pReproductorLayout.setVerticalGroup(
            pReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproductorLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pNuevaPlayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pReproductorLayout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pReproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pEcualizadorVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tpPrincipal.addTab("                Reproductor                ", pReproductor);

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel12.setText("Número de la tarjeta de crédito:");

        tfNumeroTarjetaCreditoTienda.setForeground(java.awt.Color.lightGray);
        tfNumeroTarjetaCreditoTienda.setText("Insertar tarjeta de credito");
        tfNumeroTarjetaCreditoTienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNumeroTarjetaCreditoTiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNumeroTarjetaCreditoTiendaFocusLost(evt);
            }
        });
        tfNumeroTarjetaCreditoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroTarjetaCreditoTiendaActionPerformed(evt);
            }
        });
        tfNumeroTarjetaCreditoTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroTarjetaCreditoTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNumeroTarjetaCreditoTiendaKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel13.setText("Fecha de caducidad:");

        cbMesTienda.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cbMesTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMesTienda.setToolTipText("");
        cbMesTienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesTiendaItemStateChanged(evt);
            }
        });

        cbAñoTienda.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cbAñoTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        cbAñoTienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAñoTiendaItemStateChanged(evt);
            }
        });
        cbAñoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAñoTiendaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel14.setText("Número de seguridad:");

        pfNumeroSeguridadTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfNumeroSeguridadTiendaActionPerformed(evt);
            }
        });
        pfNumeroSeguridadTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfNumeroSeguridadTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pfNumeroSeguridadTiendaKeyReleased(evt);
            }
        });

        bProcederPagoTienda.setBackground(new java.awt.Color(43, 110, 232));
        bProcederPagoTienda.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        bProcederPagoTienda.setForeground(new java.awt.Color(255, 255, 255));
        bProcederPagoTienda.setText("Proceder al pago");
        bProcederPagoTienda.setEnabled(false);
        bProcederPagoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProcederPagoTiendaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel7.setText("Nombre:");

        tfNombreTienda.setForeground(java.awt.Color.lightGray);
        tfNombreTienda.setText("Insertar nombre");
        tfNombreTienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNombreTiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNombreTiendaFocusLost(evt);
            }
        });
        tfNombreTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreTiendaActionPerformed(evt);
            }
        });
        tfNombreTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreTiendaKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel15.setText("Apellidos:");

        tfApellidosTienda.setForeground(java.awt.Color.lightGray);
        tfApellidosTienda.setText("Insertar apellidos");
        tfApellidosTienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfApellidosTiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfApellidosTiendaFocusLost(evt);
            }
        });
        tfApellidosTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidosTiendaActionPerformed(evt);
            }
        });
        tfApellidosTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfApellidosTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfApellidosTiendaKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel16.setText("Dirección:");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel17.setText("Código postal:");

        tfDireccionTienda.setText("C\\ ");
        tfDireccionTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionTiendaActionPerformed(evt);
            }
        });
        tfDireccionTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDireccionTiendaKeyReleased(evt);
            }
        });

        tfCodigoPostalTienda.setForeground(java.awt.Color.lightGray);
        tfCodigoPostalTienda.setText("Insertar CP");
        tfCodigoPostalTienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCodigoPostalTiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoPostalTiendaFocusLost(evt);
            }
        });
        tfCodigoPostalTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoPostalTiendaActionPerformed(evt);
            }
        });
        tfCodigoPostalTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodigoPostalTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoPostalTiendaKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel18.setText("DNI:");

        tfDNITienda.setForeground(java.awt.Color.lightGray);
        tfDNITienda.setText("Insertar DNI");
        tfDNITienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDNITiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDNITiendaFocusLost(evt);
            }
        });
        tfDNITienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDNITiendaActionPerformed(evt);
            }
        });
        tfDNITienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDNITiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDNITiendaKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel19.setText("Teléfono:");

        tfTelefonoTienda.setForeground(java.awt.Color.lightGray);
        tfTelefonoTienda.setText("Insertar telefono");
        tfTelefonoTienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTelefonoTiendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTelefonoTiendaFocusLost(evt);
            }
        });
        tfTelefonoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonoTiendaActionPerformed(evt);
            }
        });
        tfTelefonoTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoTiendaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTelefonoTiendaKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosRelleno/altavoces1.png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosRelleno/altavoces2.png"))); // NOI18N

        javax.swing.GroupLayout pTiendaLayout = new javax.swing.GroupLayout(pTienda);
        pTienda.setLayout(pTiendaLayout);
        pTiendaLayout.setHorizontalGroup(
            pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTiendaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfDireccionTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addGap(69, 69, 69)
                .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bProcederPagoTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addComponent(tfCodigoPostalTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGroup(pTiendaLayout.createSequentialGroup()
                            .addComponent(cbMesTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbAñoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(tfNumeroTarjetaCreditoTienda)
                        .addComponent(jLabel14)
                        .addComponent(pfNumeroSeguridadTienda))
                    .addComponent(jLabel15)
                    .addComponent(tfApellidosTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDNITienda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefonoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel20)))
                .addGap(25, 25, 25))
        );
        pTiendaLayout.setVerticalGroup(
            pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfApellidosTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCodigoPostalTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDNITienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTelefonoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDireccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pTiendaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(9, 9, 9)
                        .addComponent(tfNumeroTarjetaCreditoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMesTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAñoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfNumeroSeguridadTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bProcederPagoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        tpPrincipal.addTab("                    Tienda                     ", pTienda);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Idioma");

        cbIdioma.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cbIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "English" }));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Salida audio");

        cbSalidaAudio.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cbSalidaAudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auriculares", "Altavoces" }));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Tipo de audio");

        bgTipoDeAudioConfiguracion.add(rbEstereo);
        rbEstereo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        rbEstereo.setSelected(true);
        rbEstereo.setText("Estéreo");
        rbEstereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstereoActionPerformed(evt);
            }
        });

        bgTipoDeAudioConfiguracion.add(rbMono);
        rbMono.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        rbMono.setText("Mono");
        rbMono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMonoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("Volumen por defecto");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setText("Volumen máximo");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel10.setText("Ecualizador");

        slVolDefecto.setMaximum(10);
        slVolDefecto.setPaintTicks(true);
        slVolDefecto.setValue(5);
        slVolDefecto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slVolDefectoStateChanged(evt);
            }
        });

        spVolDefecto.setModel(new javax.swing.SpinnerNumberModel(5, 0, 10, 1));
        spVolDefecto.setValue(5);
        spVolDefecto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spVolDefectoStateChanged(evt);
            }
        });

        slVolMaximo.setMaximum(10);
        slVolMaximo.setPaintTicks(true);
        slVolMaximo.setToolTipText("");
        slVolMaximo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slVolMaximoStateChanged(evt);
            }
        });

        spVolMaximo.setModel(new javax.swing.SpinnerNumberModel(10, 0, 10, 1));
        spVolMaximo.setValue(10);
        spVolMaximo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spVolMaximoStateChanged(evt);
            }
        });

        bEcualizador.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        bEcualizador.setText("Configurar");
        bEcualizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEcualizadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pConfiguracionLayout = new javax.swing.GroupLayout(pConfiguracion);
        pConfiguracion.setLayout(pConfiguracionLayout);
        pConfiguracionLayout.setHorizontalGroup(
            pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConfiguracionLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSalidaAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEstereo)
                    .addComponent(rbMono))
                .addGap(164, 164, 164)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pConfiguracionLayout.createSequentialGroup()
                            .addComponent(slVolMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spVolMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pConfiguracionLayout.createSequentialGroup()
                            .addComponent(slVolDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spVolDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6))
                    .addComponent(bEcualizador, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        pConfiguracionLayout.setVerticalGroup(
            pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConfiguracionLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slVolDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spVolDefecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pConfiguracionLayout.createSequentialGroup()
                        .addComponent(cbSalidaAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3))
                    .addGroup(pConfiguracionLayout.createSequentialGroup()
                        .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slVolMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spVolMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(pConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEcualizador, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEstereo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMono)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        tpPrincipal.addTab("               Configuración               ", pConfiguracion);

        getContentPane().add(tpPrincipal, java.awt.BorderLayout.CENTER);

        lPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play azul.png"))); // NOI18N
        lPlayPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPlayPauseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPlayPauseMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPlayPauseMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lPlayPauseMouseEntered(evt);
            }
        });

        lAvanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/avanzar azul.png"))); // NOI18N
        lAvanzar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAvanzarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lAvanzarMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAvanzarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lAvanzarMouseEntered(evt);
            }
        });

        lRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/retroceder azul.png"))); // NOI18N
        lRetroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lRetrocederMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lRetrocederMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lRetrocederMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lRetrocederMouseEntered(evt);
            }
        });

        lTiempoActualCancion.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lTiempoActualCancion.setForeground(new java.awt.Color(0, 109, 240));
        lTiempoActualCancion.setText("0:00");

        lTiempoFinalCancion.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lTiempoFinalCancion.setForeground(new java.awt.Color(0, 109, 240));
        lTiempoFinalCancion.setText("0:00");

        lRepetir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/repetir gris.png"))); // NOI18N
        lRepetir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lRepetirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lRepetirMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lRepetirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lRepetirMouseEntered(evt);
            }
        });

        lAleatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aleatorio gris.png"))); // NOI18N
        lAleatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lAleatorioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lAleatorioMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lAleatorioMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lAleatorioMouseEntered(evt);
            }
        });

        lBocinaVolumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bocina medio borde azul.png"))); // NOI18N

        slVolumen.setMaximum(10);
        slVolumen.setValue(5);
        slVolumen.setFocusable(false);
        slVolumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slVolumenStateChanged(evt);
            }
        });

        lNombreCancion.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lNombreCancion.setForeground(new java.awt.Color(0, 109, 240));
        lNombreCancion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pReproduccionArribaLayout = new javax.swing.GroupLayout(pReproduccionArriba);
        pReproduccionArriba.setLayout(pReproduccionArribaLayout);
        pReproduccionArribaLayout.setHorizontalGroup(
            pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproduccionArribaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lRetroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPlayPause)
                .addGap(18, 18, 18)
                .addComponent(lAvanzar)
                .addGap(18, 18, 18)
                .addComponent(lTiempoActualCancion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNombreCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pbCancion, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lTiempoFinalCancion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBocinaVolumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lAleatorio)
                .addGap(18, 18, 18)
                .addComponent(lRepetir)
                .addGap(25, 25, 25))
        );
        pReproduccionArribaLayout.setVerticalGroup(
            pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReproduccionArribaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lNombreCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pReproduccionArribaLayout.createSequentialGroup()
                        .addComponent(lBocinaVolumen)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pReproduccionArribaLayout.createSequentialGroup()
                        .addGroup(pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lPlayPause)
                                .addComponent(lRetroceder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pReproduccionArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lTiempoActualCancion)
                                    .addComponent(pbCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lTiempoFinalCancion)))
                            .addComponent(lAleatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(lRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(pReproduccionArribaLayout.createSequentialGroup()
                        .addComponent(slVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(pReproduccionArriba, java.awt.BorderLayout.PAGE_START);

        mArchivo.setText("Archivo");
        mArchivo.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        miNuevaPlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        miNuevaPlaylist.setText("Nueva PlayList...");
        miNuevaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevaPlaylistActionPerformed(evt);
            }
        });
        mArchivo.add(miNuevaPlaylist);
        mArchivo.add(jSeparator7);

        miSalirAplicacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        miSalirAplicacion.setText("Salir de la aplicacion");
        miSalirAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirAplicacionActionPerformed(evt);
            }
        });
        mArchivo.add(miSalirAplicacion);

        jMenuBar1.add(mArchivo);

        mCancion.setText("Canción");
        mCancion.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        miGuardarEnTusCanciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        miGuardarEnTusCanciones.setText("Guardar en Tus Canciones");
        miGuardarEnTusCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarEnTusCancionesActionPerformed(evt);
            }
        });
        mCancion.add(miGuardarEnTusCanciones);

        miAñadirAPlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.META_MASK));
        miAñadirAPlaylist.setText("Añadir a Playlist...");
        miAñadirAPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAñadirAPlaylistActionPerformed(evt);
            }
        });
        mCancion.add(miAñadirAPlaylist);

        miEliminarDeTusCanciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.META_MASK));
        miEliminarDeTusCanciones.setText("Eliminar de Tus Canciones");
        miEliminarDeTusCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarDeTusCancionesActionPerformed(evt);
            }
        });
        mCancion.add(miEliminarDeTusCanciones);

        jMenuBar1.add(mCancion);

        mReproduccion.setText("Reproducción");
        mReproduccion.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        miReanudarPausar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        miReanudarPausar.setText("Reanudar/Pausar");
        miReanudarPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReanudarPausarActionPerformed(evt);
            }
        });
        mReproduccion.add(miReanudarPausar);
        mReproduccion.add(jSeparator1);

        miSiguiente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.META_MASK));
        miSiguiente.setText("Siguiente");
        miSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSiguienteActionPerformed(evt);
            }
        });
        mReproduccion.add(miSiguiente);

        miAnterior.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.META_MASK));
        miAnterior.setText("Anterior");
        miAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAnteriorActionPerformed(evt);
            }
        });
        mReproduccion.add(miAnterior);

        miAvanzar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        miAvanzar.setText("Avanzar");
        mReproduccion.add(miAvanzar);

        miRetroceder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        miRetroceder.setText("Retroceder");
        mReproduccion.add(miRetroceder);
        mReproduccion.add(jSeparator2);

        miAleatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.META_MASK));
        miAleatorio.setText("Aleatorio");
        miAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAleatorioActionPerformed(evt);
            }
        });
        mReproduccion.add(miAleatorio);

        miRepetir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.META_MASK));
        miRepetir.setText("Repetir");
        miRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRepetirActionPerformed(evt);
            }
        });
        mReproduccion.add(miRepetir);

        cbmiLetraCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.META_MASK));
        cbmiLetraCancion.setText("Letra de la Cancion");
        cbmiLetraCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmiLetraCancionActionPerformed(evt);
            }
        });
        mReproduccion.add(cbmiLetraCancion);
        mReproduccion.add(jSeparator3);

        miSubirVolumen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.META_MASK));
        miSubirVolumen.setText("Subir Volumen");
        miSubirVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSubirVolumenActionPerformed(evt);
            }
        });
        mReproduccion.add(miSubirVolumen);

        miBajarVolumen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.META_MASK));
        miBajarVolumen.setText("Bajar Volumen");
        miBajarVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBajarVolumenActionPerformed(evt);
            }
        });
        mReproduccion.add(miBajarVolumen);

        cbmiMostrarVolumen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.META_MASK));
        cbmiMostrarVolumen.setText("Mostrar Volumen");
        cbmiMostrarVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmiMostrarVolumenActionPerformed(evt);
            }
        });
        mReproduccion.add(cbmiMostrarVolumen);
        mReproduccion.add(jSeparator8);

        rbmiEstereo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.META_MASK));
        bgmiTipoDeAudio.add(rbmiEstereo);
        rbmiEstereo.setSelected(true);
        rbmiEstereo.setText("Estéreo");
        rbmiEstereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmiEstereoActionPerformed(evt);
            }
        });
        mReproduccion.add(rbmiEstereo);

        rbmiMono.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.META_MASK));
        bgmiTipoDeAudio.add(rbmiMono);
        rbmiMono.setText("Mono");
        rbmiMono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmiMonoActionPerformed(evt);
            }
        });
        mReproduccion.add(rbmiMono);

        jMenuBar1.add(mReproduccion);

        miIniciarSesion.setText("Cuenta");
        miIniciarSesion.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        miCerrarSesion.setText("Iniciar Sesión...");
        miIniciarSesion.add(miCerrarSesion);

        jMenuItem13.setText("Cerrar Sesión");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        miIniciarSesion.add(jMenuItem13);

        jMenuBar1.add(miIniciarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSubirVolumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSubirVolumenActionPerformed
        //Subimos el volumen en una unidad
        slVolumen.setValue(slVolumen.getValue()+1);
    }//GEN-LAST:event_miSubirVolumenActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void lRecomendadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRecomendadosMouseEntered
        IluminaTexto(lRecomendados);        
    }//GEN-LAST:event_lRecomendadosMouseEntered

    private void lRecomendadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRecomendadosMouseExited
        DesiluminaTexto(lRecomendados);
    }//GEN-LAST:event_lRecomendadosMouseExited

    private void lGenerosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGenerosMouseEntered
        IluminaTexto(lGeneros);
    }//GEN-LAST:event_lGenerosMouseEntered

    private void lGenerosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGenerosMouseExited
        DesiluminaTexto(lGeneros);
    }//GEN-LAST:event_lGenerosMouseExited

    private void lTusCancionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTusCancionesMouseEntered
        IluminaTexto(lTusCanciones);
    }//GEN-LAST:event_lTusCancionesMouseEntered

    private void lTusCancionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTusCancionesMouseExited
        DesiluminaTexto(lTusCanciones);
    }//GEN-LAST:event_lTusCancionesMouseExited

    private void lPlayPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPlayPauseMouseEntered
        if(playOK)//Nos muestra el icono de pausa
            CambiaIcono(lPlayPause,"pausa blanco.png","iconos");
        else//Si no es que nos mostraba el icono de play
            CambiaIcono(lPlayPause,"play blanco.png","iconos");       
    }//GEN-LAST:event_lPlayPauseMouseEntered

    private void lPlayPauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPlayPauseMouseExited
        if(playOK)//Tenemos que mostrar el icono de pausa
            CambiaIcono(lPlayPause,"pausa azul.png","iconos");
        else//Si no mostramos el icono de play
            CambiaIcono(lPlayPause,"play azul.png","iconos");
    }//GEN-LAST:event_lPlayPauseMouseExited

    private void lPlayPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPlayPauseMousePressed
        if(playOK)//mostramos pausa
            CambiaIcono(lPlayPause,"pausa gris.png","iconos");
        else
            CambiaIcono(lPlayPause,"play gris.png","iconos");
    }//GEN-LAST:event_lPlayPauseMousePressed

    private void lPlayPauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPlayPauseMouseReleased
        //Cuando soltamos la pulsacion es cuando se cambia realmente entre pausa/play
        AccionPulsarPausaOPlay("lPlayPause");
    }//GEN-LAST:event_lPlayPauseMouseReleased

    private void slVolumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slVolumenStateChanged
        int valor = slVolumen.getValue();
        //No podemos pasarnos del volumen maximo
        valor=Math.min(valor, slVolMaximo.getValue());
        slVolumen.setValue(valor);
        
        if(valor==0)
            CambiaIcono(lBocinaVolumen,"bocina mute borde azul.png","iconos");
        else if(valor<=2)
            CambiaIcono(lBocinaVolumen,"bocina muy bajo borde azul.png","iconos");
        else if(valor<=4)
             CambiaIcono(lBocinaVolumen,"bocina bajo borde azul.png","iconos");
        else if(valor<=7)
            CambiaIcono(lBocinaVolumen,"bocina medio borde azul.png","iconos");
        else
            CambiaIcono(lBocinaVolumen,"bocina alto borde azul.png","iconos");
        
        //Modificamos el pb de la ventana volumen
        VOL.pbVolumen.setValue(valor);
        
    }//GEN-LAST:event_slVolumenStateChanged

    private void pNuevaPlayListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNuevaPlayListMouseEntered
        IluminaNuevaPlayList();
    }//GEN-LAST:event_pNuevaPlayListMouseEntered

    private void pNuevaPlayListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNuevaPlayListMouseExited
        DesiluminaNuevaPlayList();
    }//GEN-LAST:event_pNuevaPlayListMouseExited

    private void pNuevaPlayListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNuevaPlayListMousePressed
        DesiluminaNuevaPlayList();
    }//GEN-LAST:event_pNuevaPlayListMousePressed

    private void pNuevaPlayListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pNuevaPlayListMouseReleased
        IluminaNuevaPlayList();
        
        //Cuando soltamos el click tiene que saltarnos un dialogo para crear una nueva playlist
        llamadaAlDialogoNuevaPlaylist();
    }//GEN-LAST:event_pNuevaPlayListMouseReleased

    private void lAleatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAleatorioMouseEntered
        CambiaIcono(lAleatorio, "aleatorio blanco.png","iconos");
    }//GEN-LAST:event_lAleatorioMouseEntered

    private void lAleatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAleatorioMouseExited
        if(aleatorioON)
            CambiaIcono(lAleatorio, "aleatorio azul.png","iconos");
        else
            CambiaIcono(lAleatorio, "aleatorio gris.png","iconos");           
    }//GEN-LAST:event_lAleatorioMouseExited

    private void lAleatorioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAleatorioMousePressed
        CambiaIcono(lAleatorio, "aleatorio gris.png","iconos");
    }//GEN-LAST:event_lAleatorioMousePressed

    private void lAleatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAleatorioMouseReleased
        AccionAleatorio("lAleatorio");
    }//GEN-LAST:event_lAleatorioMouseReleased

    private void lRepetirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRepetirMouseEntered
        CambiaIcono(lRepetir, "repetir blanco.png","iconos");      
    }//GEN-LAST:event_lRepetirMouseEntered

    private void lRepetirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRepetirMouseExited
        if(repetirON)
        CambiaIcono(lRepetir, "repetir azul.png","iconos");
        else
        CambiaIcono(lRepetir, "repetir gris.png","iconos");
    }//GEN-LAST:event_lRepetirMouseExited

    private void lRepetirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRepetirMousePressed
        CambiaIcono(lRepetir, "repetir gris.png","iconos");
    }//GEN-LAST:event_lRepetirMousePressed

    private void lRepetirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRepetirMouseReleased
        AccionRepetir("lRepetir");
    }//GEN-LAST:event_lRepetirMouseReleased

    private void rbEstereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstereoActionPerformed
        //modificamos tambien el rbmiEstereo
        rbmiEstereo.setSelected(true);
    }//GEN-LAST:event_rbEstereoActionPerformed

    private void bEcualizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEcualizadorActionPerformed
        //Mostrar la ventana Ecualizador
        ECU.setVisible(true);
    }//GEN-LAST:event_bEcualizadorActionPerformed

    private void miSalirAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirAplicacionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirAplicacionActionPerformed

    private void lAvanzarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvanzarMouseEntered
        CambiaIcono(lAvanzar,"avanzar blanco.png","iconos");
    }//GEN-LAST:event_lAvanzarMouseEntered

    private void lAvanzarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvanzarMouseExited
        CambiaIcono(lAvanzar, "avanzar azul.png","iconos");
    }//GEN-LAST:event_lAvanzarMouseExited

    private void lAvanzarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvanzarMousePressed
        CambiaIcono(lAvanzar, "avanzar gris.png","iconos");
    }//GEN-LAST:event_lAvanzarMousePressed

    private void lAvanzarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAvanzarMouseReleased
        CambiaIcono(lAvanzar, "avanzar blanco.png","iconos");
    }//GEN-LAST:event_lAvanzarMouseReleased

    private void lRetrocederMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRetrocederMouseEntered
        CambiaIcono(lRetroceder, "retroceder blanco.png","iconos");
    }//GEN-LAST:event_lRetrocederMouseEntered

    private void lRetrocederMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRetrocederMouseExited
        CambiaIcono(lRetroceder, "retroceder azul.png","iconos");
    }//GEN-LAST:event_lRetrocederMouseExited

    private void lRetrocederMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRetrocederMousePressed
        CambiaIcono(lRetroceder, "retroceder gris.png","iconos");
    }//GEN-LAST:event_lRetrocederMousePressed

    private void lRetrocederMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRetrocederMouseReleased
        CambiaIcono(lRetroceder, "retroceder blanco.png","iconos");
    }//GEN-LAST:event_lRetrocederMouseReleased

    private void miAñadirAPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAñadirAPlaylistActionPerformed
        AccionAñadirAPlaylist();
    }//GEN-LAST:event_miAñadirAPlaylistActionPerformed

    private void miEliminarDeTusCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarDeTusCancionesActionPerformed
        AccionEliminarDeTusCanciones();
    }//GEN-LAST:event_miEliminarDeTusCancionesActionPerformed

    private void miNuevaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevaPlaylistActionPerformed
        //Activamos el dialogo
        llamadaAlDialogoNuevaPlaylist();
    }//GEN-LAST:event_miNuevaPlaylistActionPerformed

    private void lRecomendadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRecomendadosMousePressed
        DesiluminaTexto(lRecomendados);
    }//GEN-LAST:event_lRecomendadosMousePressed

    private void lRecomendadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRecomendadosMouseReleased
        IluminaTexto(lRecomendados);
        
        //Tenemos que poner visible el panel de Recomendados
        CardLayout paletas = (CardLayout) (panelContenedor.getLayout()); 
        paletas.show(panelContenedor, "pRecomendados"); 
        
        //Desmarcamos la playlist seleccionada(si la hay)
        DesmarcarPL();
        //Desmarcamos el elemento seleccionado con anterioridad
        tablaRecomendados.clearSelection();
    }//GEN-LAST:event_lRecomendadosMouseReleased

    private void lGenerosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGenerosMouseReleased
        IluminaTexto(lGeneros);
        
        //Tenemos que poner visible el panel de Generos
        CardLayout paletas = (CardLayout) (panelContenedor.getLayout()); 
        paletas.show(panelContenedor, "pGeneros"); 
        
        //Desmarcamos la playlist seleccionada(si la hay)
        DesmarcarPL();
    }//GEN-LAST:event_lGenerosMouseReleased

    private void lGenerosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGenerosMousePressed
        DesiluminaTexto(lGeneros);
    }//GEN-LAST:event_lGenerosMousePressed

    private void lTusCancionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTusCancionesMousePressed
        DesiluminaTexto(lTusCanciones);
    }//GEN-LAST:event_lTusCancionesMousePressed

    private void lTusCancionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTusCancionesMouseReleased
        IluminaTexto(lTusCanciones);
        
        //Tenemos que poner visible el panel de Recomendados
        CardLayout paletas = (CardLayout) (panelContenedor.getLayout()); 
        paletas.show(panelContenedor, "pTusCanciones"); 
        
        //Desmarcamos la playlist seleccionada(si la hay)
        DesmarcarPL();
        //Desmarcamos el elemento seleccionado con anterioridad
        tablaTusCanciones.clearSelection();
    }//GEN-LAST:event_lTusCancionesMouseReleased

    private void rbmiMonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmiMonoActionPerformed
        //modificamos tambien el rbmiMono
        rbMono.setSelected(true);
    }//GEN-LAST:event_rbmiMonoActionPerformed

    private void rbMonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMonoActionPerformed
        //modificamos tambien el rbmiMono
        rbmiMono.setSelected(true);
    }//GEN-LAST:event_rbMonoActionPerformed

    private void rbmiEstereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmiEstereoActionPerformed
        //modificamos tambien el rbEstereo
        rbEstereo.setSelected(true);
    }//GEN-LAST:event_rbmiEstereoActionPerformed

    private void miReanudarPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReanudarPausarActionPerformed
        AccionPulsarPausaOPlay("miSiguiente");
    }//GEN-LAST:event_miReanudarPausarActionPerformed

    private void miSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miSiguienteActionPerformed

    private void miAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAleatorioActionPerformed
        AccionAleatorio("miAleatorio");
    }//GEN-LAST:event_miAleatorioActionPerformed

    private void miAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miAnteriorActionPerformed

    private void miRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRepetirActionPerformed
        AccionRepetir("miRepetir");
    }//GEN-LAST:event_miRepetirActionPerformed

    private void miBajarVolumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBajarVolumenActionPerformed
        // Bajamos el volumen en una unidad
        slVolumen.setValue(slVolumen.getValue()-1);
    }//GEN-LAST:event_miBajarVolumenActionPerformed

    private void tfNumeroTarjetaCreditoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroTarjetaCreditoTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroTarjetaCreditoTiendaActionPerformed

    private void bProcederPagoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcederPagoTiendaActionPerformed
        MensajeErrorNoExiste();
    }//GEN-LAST:event_bProcederPagoTiendaActionPerformed

    private void tfNombreTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreTiendaActionPerformed

    private void tfApellidosTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidosTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellidosTiendaActionPerformed

    private void tfCodigoPostalTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoPostalTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoPostalTiendaActionPerformed

    private void tfDNITiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDNITiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDNITiendaActionPerformed

    private void tfTelefonoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonoTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefonoTiendaActionPerformed

    private void cbAñoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAñoTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAñoTiendaActionPerformed

    private void tfDNITiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDNITiendaKeyReleased
        //Si metimos 9 caracteres en DNI
        if(tfDNITienda.getText().length()==9){
            //Si el DNI es correcto ponemos el fondo en verde
            if(DNICorrecto())
                FondoTextFieldVerde(tfDNITienda);
                
            //Si no lo ponemos en rojo
            else
                FondoTextFieldRojo(tfDNITienda);       
        }
        
        else//Si no hay 9 caracteres lo ponemos en blanco
            FondoTextFieldBlanco(tfDNITienda);
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfDNITiendaKeyReleased

    private void tfDNITiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDNITiendaKeyTyped
        // Si ya tenemos 9 caracteres no dejamos que el usuario meta mas
        if(tfDNITienda.getText().length()==9)
            evt.consume();
    }//GEN-LAST:event_tfDNITiendaKeyTyped

    private void tfCodigoPostalTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoPostalTiendaKeyReleased
        //Si ha introducido 5 caracteres
        if(tfCodigoPostalTienda.getText().length()==5){
            if(CPCorrecto())//Si el codigo postal es correcto
                FondoTextFieldVerde(tfCodigoPostalTienda);//ponemos el fondo verde
            
            else//Si es incorrecto
                FondoTextFieldRojo(tfCodigoPostalTienda);//ponemos el fondo rojo
        }
        
        else//Si hay menos de 5 caracteres
            FondoTextFieldBlanco(tfCodigoPostalTienda);//Pobemos el fondo blanco
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfCodigoPostalTiendaKeyReleased

    private void tfCodigoPostalTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoPostalTiendaKeyTyped
        // Si ya tenemos 5 caracteres no dejamos que el usuario meta mas
        if(tfCodigoPostalTienda.getText().length()==5)
            evt.consume();
    }//GEN-LAST:event_tfCodigoPostalTiendaKeyTyped

    private void tfNombreTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreTiendaKeyReleased
        //Si hay algo escrito en el tf
        if(tfNombreTienda.getText().length()>0){
            if(Character.isDigit(evt.getKeyChar()))//Si metemos algun numero en el nombre esta mal (Si el tf estaba en rojo no dejamos que siga escribiendo)
                FondoTextFieldRojo(tfNombreTienda);
            else
                FondoTextFieldVerde(tfNombreTienda);
        }
        
        else
            FondoTextFieldBlanco(tfNombreTienda);
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfNombreTiendaKeyReleased

    private void tfNombreTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreTiendaKeyTyped
        //Si el tf ya está en rojo no nos deja meter mas caracteres
        if(tfNombreTienda.getBackground().equals(rojo))
            evt.consume();
    }//GEN-LAST:event_tfNombreTiendaKeyTyped

    private void tfTelefonoTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoTiendaKeyReleased
        //Si hay 9 caracteres
        if(tfTelefonoTienda.getText().length()==9){
            //Si el telefono es correcto
            if(TelefonoCorrecto())
                FondoTextFieldVerde(tfTelefonoTienda);//Ponemos el tf en verde
            else
                FondoTextFieldRojo(tfTelefonoTienda);//Si no lo ponemos en rojo
        }
        
        else
            FondoTextFieldBlanco(tfTelefonoTienda);//Si no hay 9 caracteres lo ponemos en blanco
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfTelefonoTiendaKeyReleased

    private void tfTelefonoTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoTiendaKeyTyped
        // Si ya tenemos 9 caracteres no dejamos que el usuario meta mas
        if(tfTelefonoTienda.getText().length()==9)
            evt.consume();
    }//GEN-LAST:event_tfTelefonoTiendaKeyTyped

    private void listaPlayListsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPlayListsValueChanged
        //Tenemos que mostrar el panel de la PL seleccionada
        String PL = listaPlayLists.getSelectedValue();
        CardLayout paletas = (CardLayout) (panelContenedor.getLayout()); 
        paletas.show(panelContenedor, "pPL"+PL);
        
        //Desmarcamos el elemento seleccionado con anterioridad
        if(PL=="Coche")
            tablaPLCoche.clearSelection();
        else if(PL=="Favoritos")
            tablaPLFavoritos.clearSelection();
    }//GEN-LAST:event_listaPlayListsValueChanged

    private void slVolMaximoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slVolMaximoStateChanged
        // Si el valor de este slider es menor que el del volumen actual, ponemos el volumen actual a este valor
        int max = slVolMaximo.getValue();
        if(max<slVolumen.getValue())
            slVolumen.setValue(max);
        
        //Modificamos el valor del spiner
        javax.swing.SpinnerNumberModel Model=(javax.swing.SpinnerNumberModel)spVolMaximo.getModel();
        Model.setValue(max);
    }//GEN-LAST:event_slVolMaximoStateChanged

    private void cbmiMostrarVolumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiMostrarVolumenActionPerformed
        // Si está seleccionado mostramos la ventana Volumen
        if(cbmiMostrarVolumen.isSelected())
            VOL.setVisible(true);
        else//Si no la escondemos
            VOL.setVisible(false);
    }//GEN-LAST:event_cbmiMostrarVolumenActionPerformed

    private void slVolDefectoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slVolDefectoStateChanged
        //Modificamos el valor del spiner
        javax.swing.SpinnerNumberModel Model=(javax.swing.SpinnerNumberModel)spVolDefecto.getModel();
        Model.setValue(slVolDefecto.getValue());
    }//GEN-LAST:event_slVolDefectoStateChanged

    private void spVolDefectoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spVolDefectoStateChanged
        // Modificamos el valor del slider
        javax.swing.SpinnerNumberModel Model=(javax.swing.SpinnerNumberModel)spVolDefecto.getModel();
        int valor=Model.getNumber().intValue();
        slVolDefecto.setValue(valor);
    }//GEN-LAST:event_spVolDefectoStateChanged

    private void spVolMaximoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spVolMaximoStateChanged
        // Modificamos el valor del slider
        javax.swing.SpinnerNumberModel Model=(javax.swing.SpinnerNumberModel)spVolMaximo.getModel();
        int valor=Model.getNumber().intValue();
        slVolMaximo.setValue(valor);
    }//GEN-LAST:event_spVolMaximoStateChanged
    
    public boolean HayUnaFilaSeleccionadaEnLaTabla(javax.swing.JTable tabla){
        if(tabla.isFocusOwner())
            if(tabla.getSelectedRowCount()==1)//Si hay una fila seleccionada
                return true;
        
         return false;
    }
    
    private void tfNumeroTarjetaCreditoTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroTarjetaCreditoTiendaKeyTyped
        //Si ya hemos metido 16 caracteres no dejamos meter mas
        if(tfNumeroTarjetaCreditoTienda.getText().length()==16)
            evt.consume();
    }//GEN-LAST:event_tfNumeroTarjetaCreditoTiendaKeyTyped

    private void tfNumeroTarjetaCreditoTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroTarjetaCreditoTiendaKeyReleased
        //Si hay 16 caracteres
        if(tfNumeroTarjetaCreditoTienda.getText().length()==16){
             //Si el numero de la tarjeta es correcto
            if(NumeroTarjetaCreditoCorrecto())
                FondoTextFieldVerde(tfNumeroTarjetaCreditoTienda);//Ponemos el tf en verde
            else
                FondoTextFieldRojo(tfNumeroTarjetaCreditoTienda);//Si no lo ponemos en rojo
        }
        
        else
            FondoTextFieldBlanco(tfNumeroTarjetaCreditoTienda);//Si no hay 9 caracteres lo ponemos en blanco
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfNumeroTarjetaCreditoTiendaKeyReleased

    private void cbmiLetraCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiLetraCancionActionPerformed
        LC.setVisible(cbmiLetraCancion.isSelected());
    }//GEN-LAST:event_cbmiLetraCancionActionPerformed

    private void lGeneroPopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroPopMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroPopMouseClicked

    private void lGeneroRockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroRockMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroRockMouseClicked

    private void lGeneroHipHopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroHipHopMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroHipHopMouseClicked

    private void lGeneroMetalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroMetalMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroMetalMouseClicked

    private void lGeneroDanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroDanceMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroDanceMouseClicked

    private void lGeneroIndie_AlternativaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroIndie_AlternativaMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroIndie_AlternativaMouseClicked

    private void lGeneroLatinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroLatinaMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroLatinaMouseClicked

    private void lGeneroClasicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGeneroClasicaMouseClicked
        MensajeErrorNoExiste();
    }//GEN-LAST:event_lGeneroClasicaMouseClicked

    private void pfNumeroSeguridadTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfNumeroSeguridadTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfNumeroSeguridadTiendaActionPerformed

    private void tfNombreTiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNombreTiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfNombreTienda.getText().equalsIgnoreCase("Insertar nombre") && tfNombreTienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfNombreTienda, Color.black);
        }
    }//GEN-LAST:event_tfNombreTiendaFocusGained

    private void tfApellidosTiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfApellidosTiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfApellidosTienda.getText().equalsIgnoreCase("Insertar apellidos") && tfApellidosTienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfApellidosTienda, Color.black);
        }
    }//GEN-LAST:event_tfApellidosTiendaFocusGained

    private void tfCodigoPostalTiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoPostalTiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfCodigoPostalTienda.getText().equalsIgnoreCase("Insertar CP") && tfCodigoPostalTienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfCodigoPostalTienda, Color.black);
        }
    }//GEN-LAST:event_tfCodigoPostalTiendaFocusGained

    private void tfTelefonoTiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTelefonoTiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfTelefonoTienda.getText().equalsIgnoreCase("Insertar telefono") && tfTelefonoTienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfTelefonoTienda, Color.black);
        }
    }//GEN-LAST:event_tfTelefonoTiendaFocusGained

    private void tfDNITiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDNITiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfDNITienda.getText().equalsIgnoreCase("Insertar DNI") && tfDNITienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfDNITienda, Color.black);
        }
    }//GEN-LAST:event_tfDNITiendaFocusGained

    private void tfNumeroTarjetaCreditoTiendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumeroTarjetaCreditoTiendaFocusGained
        //Si el texto pone "Nombre de la playlist" en gris y ponemos el focus sobre el tf nos deja escribir el nombre de la pl
        if(tfNumeroTarjetaCreditoTienda.getText().equalsIgnoreCase("Insertar tarjeta de credito") && tfNumeroTarjetaCreditoTienda.getForeground().equals(Color.LIGHT_GRAY)){
            PonerTexto("", tfNumeroTarjetaCreditoTienda, Color.black);
        }
    }//GEN-LAST:event_tfNumeroTarjetaCreditoTiendaFocusGained

    private void tfNombreTiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNombreTiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfNombreTienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar nombre", tfNombreTienda);
        }
    }//GEN-LAST:event_tfNombreTiendaFocusLost

    private void tfApellidosTiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfApellidosTiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfApellidosTienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar apellidos", tfApellidosTienda);
        }
    }//GEN-LAST:event_tfApellidosTiendaFocusLost

    private void tfCodigoPostalTiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoPostalTiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfCodigoPostalTienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar CP", tfCodigoPostalTienda);
        }
    }//GEN-LAST:event_tfCodigoPostalTiendaFocusLost

    private void tfTelefonoTiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTelefonoTiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfTelefonoTienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar telefono", tfTelefonoTienda);
        }
    }//GEN-LAST:event_tfTelefonoTiendaFocusLost

    private void tfDNITiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDNITiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfDNITienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar DNI", tfDNITienda);
        }
    }//GEN-LAST:event_tfDNITiendaFocusLost

    private void tfNumeroTarjetaCreditoTiendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumeroTarjetaCreditoTiendaFocusLost
        //Si el texto es vacio y quitamos el focus del tf ponemos el texto de fondo de ayuda (de color gris)
        if(tfNumeroTarjetaCreditoTienda.getText().equalsIgnoreCase("")){
            PonerTextoFondo("Insertar tarjeta de credito", tfNumeroTarjetaCreditoTienda);
        }
    }//GEN-LAST:event_tfNumeroTarjetaCreditoTiendaFocusLost

    private void pfNumeroSeguridadTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfNumeroSeguridadTiendaKeyReleased
        //Si hay 16 caracteres
        if(pfNumeroSeguridadTienda.getPassword().length==4){
             //Si el numero de la tarjeta es correcto
            if(NumeroSeguridadCorrecto())
                FondoTextFieldVerde(pfNumeroSeguridadTienda);//Ponemos el tf en verde
            else
                FondoTextFieldRojo(pfNumeroSeguridadTienda);//Si no lo ponemos en rojo
        }
        
        else
            FondoTextFieldBlanco(pfNumeroSeguridadTienda);//Si no hay 9 caracteres lo ponemos en blanco
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_pfNumeroSeguridadTiendaKeyReleased

    private void tfApellidosTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidosTiendaKeyReleased
        //Si hay algo escrito en el tf
        if(tfApellidosTienda.getText().length()>0){
            if(Character.isDigit(evt.getKeyChar()))//Si metemos algun numero en el nombre esta mal (Si el tf estaba en rojo no dejamos que siga escribiendo)
                FondoTextFieldRojo(tfApellidosTienda);
            else
                FondoTextFieldVerde(tfApellidosTienda);
        }
        
        else
            FondoTextFieldBlanco(tfApellidosTienda);
        
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfApellidosTiendaKeyReleased

    private void tfApellidosTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidosTiendaKeyTyped
        //Si el tf ya está en rojo no nos deja meter mas caracteres
        if(tfApellidosTienda.getBackground().equals(rojo))
            evt.consume();
    }//GEN-LAST:event_tfApellidosTiendaKeyTyped

    private void cbMesTiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesTiendaItemStateChanged
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
        
        //Traza
        System.out.println("State changed cb Mes");
    }//GEN-LAST:event_cbMesTiendaItemStateChanged

    private void cbAñoTiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAñoTiendaItemStateChanged
        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
        
        //Traza
        System.out.println("State changed cb Año");
    }//GEN-LAST:event_cbAñoTiendaItemStateChanged

    private void pfNumeroSeguridadTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfNumeroSeguridadTiendaKeyTyped
        //Si ya metimos 4 caracteres no nos deja meter mas
        if(pfNumeroSeguridadTienda.getPassword().length==4)
            evt.consume();
    }//GEN-LAST:event_pfNumeroSeguridadTiendaKeyTyped
    
    public void AccionGuardarEnTusCanciones(){
        //Si esta seleccionada una cancion de las tabla Recomendados o de una PL
        //Metemos esa cancion en la tabla TusCanciones
        DefaultTableModel DTM;
        int fila;
        
        if(HayUnaFilaSeleccionadaEnLaTabla(tablaRecomendados)){
            DTM = (DefaultTableModel) tablaRecomendados.getModel();
            fila = tablaRecomendados.getSelectedRow();
        }
        else if(HayUnaFilaSeleccionadaEnLaTabla(tablaPLCoche)){
            DTM = (DefaultTableModel) tablaPLCoche.getModel();
            fila = tablaPLCoche.getSelectedRow();
        }
        else if(HayUnaFilaSeleccionadaEnLaTabla(tablaPLFavoritos)){
            DTM = (DefaultTableModel) tablaPLFavoritos.getModel();
            fila = tablaPLFavoritos.getSelectedRow();
        }            
        else return;
        
        
            String cancion = (String) DTM.getValueAt(fila, 0);
            String artista = (String) DTM.getValueAt(fila, 1);
            String album = (String) DTM.getValueAt(fila, 2);
            String genero = (String) DTM.getValueAt(fila, 3);
            String duracion = (String) DTM.getValueAt(fila, 4);
            System.out.print("Click "+cancion);
            String[] s = {cancion, artista,album,genero,duracion};

            //Añadimos a la tabla TusCanciones
            DefaultTableModel DTM_TC = (DefaultTableModel) tablaTusCanciones.getModel();
            DTM_TC.addRow(s);
    }
    
    private void pTusCancionesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pTusCancionesComponentShown
        // TODO add your handling code here:
        System.out.println("Se ha mostrado el panel Tus Canciones");
    }//GEN-LAST:event_pTusCancionesComponentShown

    private void lTerminarCancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTerminarCancionMouseClicked
        TM.setStop();

        playOK=false;
        CambiaIcono(lPlayPause,"play azul.png","iconos");

        //Desactivamos Terminar
        lTerminarCancion.setEnabled(false);
        //Activamos Reproducir
        lReproducir.setEnabled(true);
    }//GEN-LAST:event_lTerminarCancionMouseClicked

    private void lEliminarDeTusCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEliminarDeTusCancionesMouseClicked
        AccionEliminarDeTusCanciones();
    }//GEN-LAST:event_lEliminarDeTusCancionesMouseClicked
    
    public void AccionEliminarDeTusCanciones(){
        //Si estamos visualizando el panel Tus Canciones y la tabla tusCanciones tiene el focus
        //Y tenemos una Cancion seleccionada en la tabla
        //Eliminamos esa cancion de la tabla
        if(HayUnaFilaSeleccionadaEnLaTabla(tablaTusCanciones)){//Si hay una fila seleccionada
            //Eliminamos esa cancion(fila) de la tabla
            DefaultTableModel modelo = (DefaultTableModel)tablaTusCanciones.getModel();
            modelo.removeRow(tablaTusCanciones.getSelectedRow());
        }
    }
    
    private void lEliminarDeLaPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEliminarDeLaPlaylistMouseClicked

        if(HayUnaFilaSeleccionadaEnLaTabla(tablaPLCoche)){//Si hay una fila seleccionada
            //Eliminamos esa cancion(fila) de la tabla
            DefaultTableModel modelo = (DefaultTableModel)tablaPLCoche.getModel();
            modelo.removeRow(tablaPLCoche.getSelectedRow());
        }
        else if(HayUnaFilaSeleccionadaEnLaTabla(tablaPLFavoritos)){//Si hay una fila seleccionada
            //Eliminamos esa cancion(fila) de la tabla
            DefaultTableModel modelo = (DefaultTableModel)tablaPLFavoritos.getModel();
            modelo.removeRow(tablaPLFavoritos.getSelectedRow());
        }
    }//GEN-LAST:event_lEliminarDeLaPlaylistMouseClicked

    private void lReproducirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lReproducirMouseClicked
        //Tenemos que empezar la tarea, con el tiempo que dice la cancion seleccionada
        String s="";
        if(tablaRecomendados.isFocusOwner())
            s="Recomendados";
        else if(tablaTusCanciones.isFocusOwner())
            s="TusCanciones";
        else if(tablaPLFavoritos.isFocusOwner())
            s="PLFavoritos";
        else if(tablaPLCoche.isFocusOwner())
            s="tablaPLCoche";

        String duracion="";
        String cancion="";
        int fila;

        switch(s){
            case "Recomendados":
            fila = tablaRecomendados.getSelectedRow();
            DefaultTableModel DTM = (DefaultTableModel) tablaRecomendados.getModel();
            duracion = (String) DTM.getValueAt(fila, 4);
            cancion = (String) DTM.getValueAt(fila, 0);
            break;
            case "TusCanciones":
            fila = tablaTusCanciones.getSelectedRow();
            DefaultTableModel DTM2 = (DefaultTableModel) tablaTusCanciones.getModel();
            duracion = (String) DTM2.getValueAt(fila, 4);
            cancion = (String) DTM2.getValueAt(fila, 0);
            break;
            case "PLFavoritos":
            fila = tablaPLFavoritos.getSelectedRow();
            DefaultTableModel DTM3 = (DefaultTableModel) tablaPLFavoritos.getModel();
            duracion = (String) DTM3.getValueAt(fila, 4);
            cancion = (String) DTM3.getValueAt(fila, 0);
            break;
            case "PLCoche":
            fila = tablaPLCoche.getSelectedRow();
            DefaultTableModel DTM4 = (DefaultTableModel) tablaPLCoche.getModel();
            duracion = (String) DTM4.getValueAt(fila, 4);
            cancion = (String) DTM4.getValueAt(fila, 0);
            break;
            
            //Si no se entra por ninguno de los casos anteriores, salimos del metodo
            default: return;
        }

        int min = Integer.parseInt(""+duracion.charAt(0));
        int seg_totales = min*60;
        int segs = Integer.parseInt(duracion.substring(2));
        seg_totales=seg_totales+segs;

        //Traza
        System.out.println("Tabla: "+s);
        System.out.println("Cancion: "+cancion);
        System.out.println("Duracion: "+duracion);
        System.out.println("Segundos totales: "+seg_totales);

        //Parametros iniciales de la tarea
        TM.setSegundosCancion(seg_totales);
        TM.setSegsIte(1);
        TM.setCancion(cancion);

        // Crear un hilo que lance la tarea
        HiloBack=new Thread(){public void run(){VentanaPrincipal.TM.Run();}};
        HiloBack.start(); // Lanzar el hilo (ejecutará Run)

        //Cambiamos el icono de playPausa
        playOK=true;
        CambiaIcono(lPlayPause,"pausa azul.png","iconos");

    }//GEN-LAST:event_lReproducirMouseClicked

    private void lGuardarEnTusCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGuardarEnTusCancionesMouseClicked
        AccionGuardarEnTusCanciones();
    }//GEN-LAST:event_lGuardarEnTusCancionesMouseClicked

    private void lAñadirAPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAñadirAPlaylistMouseClicked
        AccionAñadirAPlaylist();
    }//GEN-LAST:event_lAñadirAPlaylistMouseClicked

    public void AccionAñadirAPlaylist(){
        System.out.println("AccionAñadirAPLaylist()");
        
        DefaultTableModel DTM;
        int fila;

        //Si hay una fila seleccionada en tus canciones
        if(HayUnaFilaSeleccionadaEnLaTabla(tablaTusCanciones)){
            DTM = (DefaultTableModel) tablaTusCanciones.getModel();
            //Fila seleccionada
            fila = tablaTusCanciones.getSelectedRow();
        }
        else if(HayUnaFilaSeleccionadaEnLaTabla(tablaRecomendados)){//Si hay una fila seleccionada en recomendados
            DTM = (DefaultTableModel) tablaRecomendados.getModel();
            //Fila seleccionada
            fila = tablaRecomendados.getSelectedRow();
        }

        else return;//Si no se cumple nada de lo anterior, salimos de la funcion

        //Mostramos la Ventana para Añadir a una PL
        AAPL.getListaAAPL().setModel(listaPlayLists.getModel());

        String cancion = (String) DTM.getValueAt(fila, 0);
        String artista = (String) DTM.getValueAt(fila, 1);
        String album = (String) DTM.getValueAt(fila, 2);
        String genero = (String) DTM.getValueAt(fila, 3);
        String duracion = (String) DTM.getValueAt(fila, 4);
        String[] s = {cancion, artista,album,genero,duracion};
        AAPL.setCancionSeleccionada(s);
        
        System.out.println("Cancion Seleccionada: "+s);
        
        //Lo ultimo que hacemos es hacer la ventana modal visible para que no nos bloquee pasarle los datos antes
        AAPL.setVisible(true);
    }
    
    private void miGuardarEnTusCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarEnTusCancionesActionPerformed
        AccionGuardarEnTusCanciones();
    }//GEN-LAST:event_miGuardarEnTusCancionesActionPerformed

    private void tablaTusCancionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTusCancionesMouseEntered
         // Si hay una cancion seleccionada
        int indice = tablaTusCanciones.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsTusCanciones();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaTusCancionesMouseEntered

    private void tablaRecomendadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecomendadosMouseEntered
         // Si hay una cancion seleccionada
        int indice = tablaRecomendados.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsRecomendados();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaRecomendadosMouseEntered

    private void tablaPLFavoritosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPLFavoritosMouseEntered
        // Si hay una cancion seleccionada
        int indice = tablaPLFavoritos.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsPL();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaPLFavoritosMouseEntered

    private void tablaPLCocheMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPLCocheMouseEntered
        // Si hay una cancion seleccionada
        int indice = tablaPLCoche.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsPL();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaPLCocheMouseEntered

    private void tablaRecomendadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecomendadosMouseClicked
        // Si hay una cancion seleccionada
        int indice = tablaRecomendados.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsRecomendados();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaRecomendadosMouseClicked

    private void tablaTusCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTusCancionesMouseClicked
        // Si hay una cancion seleccionada
        int indice = tablaTusCanciones.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsTusCanciones();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaTusCancionesMouseClicked

    private void tablaPLCocheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPLCocheMouseClicked
        // Si hay una cancion seleccionada
        int indice = tablaPLCoche.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsPL();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaPLCocheMouseClicked

    private void tablaPLFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPLFavoritosMouseClicked
        // Si hay una cancion seleccionada
        int indice = tablaPLFavoritos.getSelectedRow();
        if(indice!=-1)//Si hay una fila seleccionada
            ActivarLabelsPL();//Activamos las labels que tocan
    }//GEN-LAST:event_tablaPLFavoritosMouseClicked

    private void tfDireccionTiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionTiendaKeyReleased
        if(tfDireccionTienda.getText().isEmpty())
        FondoTextFieldRojo(tfDireccionTienda);//Si no lo ponemos en rojo

        else
        FondoTextFieldVerde(tfDireccionTienda);//Si no hay caracteres lo ponemos en blanco

        //Comprobamos si esta todo correcto
        TodoCorrectoTienda();
    }//GEN-LAST:event_tfDireccionTiendaKeyReleased

    private void tfDireccionTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionTiendaActionPerformed
    
    public void ActivarLabelsRecomendados(){
        lAñadirAPlaylist.setEnabled(true);
        lGuardarEnTusCanciones.setEnabled(true);
        lReproducir.setEnabled(true);
        lEliminarDeLaPlaylist.setEnabled(false);
        lEliminarDeTusCanciones.setEnabled(false);
    }
    
    public void ActivarLabelsPL(){
        lAñadirAPlaylist.setEnabled(false);
        lGuardarEnTusCanciones.setEnabled(true);
        lReproducir.setEnabled(true);
        lEliminarDeLaPlaylist.setEnabled(true);
        lEliminarDeTusCanciones.setEnabled(false);
    }
    
    public void ActivarLabelsTusCanciones(){
        lAñadirAPlaylist.setEnabled(true);
        lGuardarEnTusCanciones.setEnabled(false);
        lReproducir.setEnabled(true);
        lEliminarDeLaPlaylist.setEnabled(false);
        lEliminarDeTusCanciones.setEnabled(true);
    }
    
    public boolean DNICorrecto(){
        String texto = tfDNITienda.getText();
        
        for(int i=0; i<=7; i++){//Recorremos los 8 primeros caracteres
            if(! Character.isDigit(texto.charAt(i)))//Si alguno de ellos no es un digito
                return false;//el DNI es incorrecto
        }
        
        if(! Character.isLetter(texto.charAt(8)))//Si el noveno caracter no es una letra
            return false;//el DNI es incorrecto
        
        //Si no se cumple nada de lo anterior el DNI es correcto
        return true;
    }
    
    public boolean CPCorrecto(){
        String texto = tfCodigoPostalTienda.getText();
        
        for(int i=0; i<=4; i++){//Recorremos los 5 caracteres
            if(! Character.isDigit(texto.charAt(i)))//Si alguno de ellos no es un digito
                return false;//el CP es incorrecto
        }
        
        return true;//Si no es correcto
    }
    
    public boolean TelefonoCorrecto(){
        String texto = tfTelefonoTienda.getText();
        
        for(int i=0; i<=8; i++){//Recorremos los 9 caracteres
            if(! Character.isDigit(texto.charAt(i)))//Si alguno de ellos no es un digito
                return false;//el telefono es incorrecto
        }
        
        return true;//Si no es correcto
    }
    
    public boolean NumeroTarjetaCreditoCorrecto(){
        String texto = tfNumeroTarjetaCreditoTienda.getText();
        
        for(int i=0; i<=15; i++){//Recorremos los 16 caracteres
            if(! Character.isDigit(texto.charAt(i)))//Si alguno de ellos no es un digito
                return false;//el numero de la tarjeta es incorrecto
        }
        
        return true;//Si no es correcto
    }
    
    public boolean NumeroSeguridadCorrecto(){
        char[] texto = pfNumeroSeguridadTienda.getPassword();
        
        for(int i=0; i<=3; i++){//Recorremos los 4 caracteres
            if(! Character.isDigit(texto[i]))//Si alguno de ellos no es un digito
                return false;//el numero de seguridad es incorrecto
        }
        
        return true;//Si no es correcto
    }
    
    public void FondoTextFieldRojo(javax.swing.JTextField tf){
        FondoTextField(tf,rojo);
    }
    
    public void FondoTextFieldVerde(javax.swing.JTextField tf){
        FondoTextField(tf,verde);
    }
    
    public void FondoTextFieldBlanco(javax.swing.JTextField tf){
        FondoTextField(tf,Color.white);
    }
    
    public void FondoTextField(javax.swing.JTextField tf, Color c){
        tf.setBackground(c);
    }
    
    public void AccionRepetir(String s){
        if(repetirON)
            repetirON=false;
        else 
            repetirON=true;
        
        if(repetirON)
            CambiaIcono(lRepetir, "repetir azul.png","iconos");
        else{
            if(s.equalsIgnoreCase("miRepetir"))
                CambiaIcono(lRepetir, "repetir gris.png","iconos");
            else
                CambiaIcono(lRepetir, "repetir blanco.png","iconos");
        }
    }
    
    public void AccionAleatorio(String s){ 
        if(aleatorioON)
            aleatorioON=false;
        else aleatorioON=true;
        
        if(aleatorioON)
            CambiaIcono(lAleatorio, "aleatorio azul.png","iconos");
        else{
            if(s.equalsIgnoreCase("miAleatorio"))
                CambiaIcono(lAleatorio, "aleatorio gris.png","iconos");
            else
                CambiaIcono(lAleatorio, "aleatorio blanco.png","iconos"); 
        }
    }
    
    public void IluminaNuevaPlayList(){
        CambiaIcono(lMasNuevaPlaylist,"mas borde blanco.png","iconos");
        IluminaTexto(lNueva);
        IluminaTexto(lPlayList);
    }
    
    public void DesiluminaNuevaPlayList(){
        CambiaIcono(lMasNuevaPlaylist,"mas borde gris.png","iconos");
        DesiluminaTexto(lNueva);
        DesiluminaTexto(lPlayList);
    }
    
    public void AccionPulsarPausaOPlay(String s){
        if(playOK)
            playOK=false;
        else playOK=true;
     
        
        if(playOK){
            //Si pulsamos desde el mi tenemos que poner el icono azul(el blanco indica que el cursor esta encima del boton)
            if(s.equalsIgnoreCase("miSiguiente"))
                CambiaIcono(lPlayPause,"pausa azul.png","iconos");
            else
                //Si no es que pulsamos el boton directamente y tenemos que poner el icono blanco porque el raton esta encima de el
                CambiaIcono(lPlayPause,"pausa blanco.png","iconos");
            
            //Reanudamos la tarea
            TM.setContinue();
        }
        else{
            //Si pulsamos desde el mi tenemos que poner el icono azul(el blanco indica que el cursor esta encima del boton)
            if(s.equalsIgnoreCase("miSiguiente"))            
                CambiaIcono(lPlayPause,"play azul.png","iconos");
            else
                CambiaIcono(lPlayPause,"play blanco.png","iconos");
            
            //Pausamos la tarea
            TM.setPause();
        }
    }
    
    public void CambiaIcono(javax.swing.JLabel l, String nombre, String pack){
        ImageIcon icon = new ImageIcon(getClass().getResource("/"+pack+"/"+nombre));
        l.setIcon(icon);
    }
    
    public void PonerIconoAjustado(javax.swing.JLabel label, String nombre, String pack){
        ImageIcon imagen = new ImageIcon(getClass().getResource("/"+pack+"/"+nombre));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
    
    public void IluminaTexto(javax.swing.JLabel l){
        l.setForeground(Color.white);
    }
    
    public void DesiluminaTexto(javax.swing.JLabel l){
        //Color c = new Color(160,160,160);
        l.setForeground(grisMuyClaro);
    }
    
    public void llamadaAlDialogoNuevaPlaylist(){
        if(NPLD.showDialog()){//el show dialog ya pone setVisible true de la ventana dialogos
            //Si se pulso el boton de OK:
            javax.swing.DefaultListModel DLM = (javax.swing.DefaultListModel) listaPlayLists.getModel();
            DLM.addElement(NPLD.getNombrePL());
            //Hacemos que se seleccione el nuevo objeto añadido
            listaPlayLists.setSelectedValue(NPLD.getNombrePL(), true);
        }
    }
    
    /**
     * Establece el numero de columnas de la tabla, así como el valor de las cabeceras
     * @param DTM 
     */
    public void añadirColumnas(javax.swing.table.DefaultTableModel DTM){
        DTM.addColumn("Canción");
        DTM.addColumn("Artista");
        DTM.addColumn("Álbum");
        DTM.addColumn("Género");
        DTM.addColumn("Duración");
    }
    
    /**
      * Recibe como parametros el DTM de la tabla a la que quieres añadir las columnas, y como demás parámetros, 
      * un número indefinido de vectores de String que van a ser las tuplas de la tabla. 
      * Los vectores han de ser del mismo tamaño que el número de columnas de la tabla
      * @param DTM modelo de la tabla
      * @param s tuplas
      */
    public void añadirFilas(javax.swing.table.DefaultTableModel DTM, String[]... s){
        for (int i = 0; i < s.length; i++)//Añadimos a la tabla las filas de una en 1
            DTM.addRow(s[i]);
    }
    
    public void DesmarcarPL(){
        listaPlayLists.clearSelection();
    }
    
    public void MensajeErrorNoExiste(){
        JOptionPane.showMessageDialog(null, "Lo sentimos, pero esta sección \naún está en fase de pruebas", " Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public void PonerTexto(String texto, javax.swing.text.JTextComponent comp, Color color){
        comp.setText(texto);
        comp.setForeground(color);
    }
    
    public void PonerTextoFondo(String texto, javax.swing.text.JTextComponent comp){
        PonerTexto(texto, comp, Color.LIGHT_GRAY);
    }
    
    public boolean esFondoVerde(javax.swing.JTextField tf){
        return tf.getBackground().equals(verde);
    }
    
    public void TodoCorrectoTienda(){
        if(esFondoVerde(tfNombreTienda) && esFondoVerde(tfApellidosTienda) && esFondoVerde(tfCodigoPostalTienda) && 
                esFondoVerde(tfDireccionTienda) && esFondoVerde(tfDNITienda) && esFondoVerde(tfTelefonoTienda) && esFondoVerde(tfNumeroTarjetaCreditoTienda)
                && FechaCorrecta() && esFondoVerde(pfNumeroSeguridadTienda))
            bProcederPagoTienda.setEnabled(true);
        
        else bProcederPagoTienda.setEnabled(false);
    }
    
    public boolean FechaCorrecta(){
        String mes = (String) cbMesTienda.getSelectedItem();
        String año = (String) cbAñoTienda.getSelectedItem();
        if(mes!="Mes" && año!="Año")
            return true;
        else return false;
    }
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(false);
            }
        });
    }
    
    //Variables
    public boolean aleatorioON;
    public boolean repetirON;
    public boolean playOK;
    public Color rojo;
    public Color verde;
    public Color grisMuyClaro;
    
    //Ventanas
    NuevaPlaylistDialog NPLD;
    Ecualizador ECU;
    Volumen VOL;
    AniadirAPlaylist AAPL;
    VentanaInicial INI;
    LetraCancion LC;
    
    // Tarea 
    private Thread HiloBack;// Hilo de la tarea
    static private TareaMusic TM; 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton bEcualizador;
    javax.swing.JButton bProcederPagoTienda;
    javax.swing.ButtonGroup bgTipoDeAudioConfiguracion;
    javax.swing.ButtonGroup bgmiTipoDeAudio;
    javax.swing.JComboBox<String> cbAñoTienda;
    javax.swing.JComboBox<String> cbIdioma;
    javax.swing.JComboBox<String> cbMesTienda;
    javax.swing.JComboBox<String> cbSalidaAudio;
    javax.swing.JCheckBoxMenuItem cbmiLetraCancion;
    javax.swing.JCheckBoxMenuItem cbmiMostrarVolumen;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel19;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JMenuItem jMenuItem13;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JScrollPane jScrollPane5;
    javax.swing.JPopupMenu.Separator jSeparator1;
    javax.swing.JPopupMenu.Separator jSeparator2;
    javax.swing.JPopupMenu.Separator jSeparator3;
    javax.swing.JSeparator jSeparator4;
    javax.swing.JSeparator jSeparator5;
    javax.swing.JSeparator jSeparator6;
    javax.swing.JPopupMenu.Separator jSeparator7;
    javax.swing.JPopupMenu.Separator jSeparator8;
    javax.swing.JLabel lActivadoDesactivadoEcualizador;
    javax.swing.JLabel lAleatorio;
    javax.swing.JLabel lAvanzar;
    javax.swing.JLabel lAñadirAPlaylist;
    javax.swing.JLabel lBocinaVolumen;
    javax.swing.JLabel lEliminarDeLaPlaylist;
    javax.swing.JLabel lEliminarDeTusCanciones;
    javax.swing.JLabel lGeneroClasica;
    javax.swing.JLabel lGeneroDance;
    javax.swing.JLabel lGeneroHipHop;
    javax.swing.JLabel lGeneroIndie_Alternativa;
    javax.swing.JLabel lGeneroLatina;
    javax.swing.JLabel lGeneroMetal;
    javax.swing.JLabel lGeneroPop;
    javax.swing.JLabel lGeneroRock;
    javax.swing.JLabel lGeneros;
    javax.swing.JLabel lGuardarEnTusCanciones;
    javax.swing.JLabel lMasNuevaPlaylist;
    javax.swing.JLabel lModoEcuVP;
    javax.swing.JLabel lNombreCancion;
    javax.swing.JLabel lNueva;
    javax.swing.JLabel lPlayList;
    javax.swing.JLabel lPlayPause;
    javax.swing.JLabel lRecomendados;
    javax.swing.JLabel lRepetir;
    javax.swing.JLabel lReproducir;
    javax.swing.JLabel lRetroceder;
    javax.swing.JLabel lTerminarCancion;
    javax.swing.JLabel lTiempoActualCancion;
    javax.swing.JLabel lTiempoFinalCancion;
    javax.swing.JLabel lTusCanciones;
    javax.swing.JList<String> listaPlayLists;
    javax.swing.JMenu mArchivo;
    javax.swing.JMenu mCancion;
    javax.swing.JMenu mReproduccion;
    javax.swing.JCheckBoxMenuItem miAleatorio;
    javax.swing.JMenuItem miAnterior;
    javax.swing.JMenuItem miAvanzar;
    javax.swing.JMenuItem miAñadirAPlaylist;
    javax.swing.JMenuItem miBajarVolumen;
    javax.swing.JMenuItem miCerrarSesion;
    javax.swing.JMenuItem miEliminarDeTusCanciones;
    javax.swing.JMenuItem miGuardarEnTusCanciones;
    javax.swing.JMenu miIniciarSesion;
    javax.swing.JMenuItem miNuevaPlaylist;
    javax.swing.JMenuItem miReanudarPausar;
    javax.swing.JCheckBoxMenuItem miRepetir;
    javax.swing.JMenuItem miRetroceder;
    javax.swing.JMenuItem miSalirAplicacion;
    javax.swing.JMenuItem miSiguiente;
    javax.swing.JMenuItem miSubirVolumen;
    javax.swing.JPanel pConfiguracion;
    javax.swing.JPanel pEcualizadorVP;
    javax.swing.JPanel pGeneros;
    javax.swing.JPanel pInferior;
    javax.swing.JPanel pNuevaPlayList;
    javax.swing.JPanel pPLCoche;
    javax.swing.JPanel pPLFavoritos;
    javax.swing.JPanel pRecomendados;
    javax.swing.JPanel pReproduccionArriba;
    javax.swing.JPanel pReproduccionIzda;
    javax.swing.JPanel pReproductor;
    javax.swing.JPanel pTienda;
    javax.swing.JPanel pTusCanciones;
    javax.swing.JPanel panelContenedor;
    javax.swing.JProgressBar pbCancion;
    javax.swing.JPasswordField pfNumeroSeguridadTienda;
    javax.swing.JRadioButton rbEstereo;
    javax.swing.JRadioButton rbMono;
    javax.swing.JRadioButtonMenuItem rbmiEstereo;
    javax.swing.JRadioButtonMenuItem rbmiMono;
    javax.swing.JSlider slVolDefecto;
    javax.swing.JSlider slVolMaximo;
    javax.swing.JSlider slVolumen;
    javax.swing.JSpinner spVolDefecto;
    javax.swing.JSpinner spVolMaximo;
    javax.swing.JTable tablaPLCoche;
    javax.swing.JTable tablaPLFavoritos;
    javax.swing.JTable tablaRecomendados;
    javax.swing.JTable tablaTusCanciones;
    javax.swing.JTextField tfApellidosTienda;
    javax.swing.JTextField tfCodigoPostalTienda;
    javax.swing.JTextField tfDNITienda;
    javax.swing.JTextField tfDireccionTienda;
    javax.swing.JTextField tfNombreTienda;
    javax.swing.JTextField tfNumeroTarjetaCreditoTienda;
    javax.swing.JTextField tfTelefonoTienda;
    javax.swing.JTabbedPane tpPrincipal;
    // End of variables declaration//GEN-END:variables
}
