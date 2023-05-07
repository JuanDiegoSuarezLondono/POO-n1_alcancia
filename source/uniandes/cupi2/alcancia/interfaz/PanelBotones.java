/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_alcancia 
 * Autor: Mario S�nchez - 4/08/2005 
 * Autor: Pablo Barvo - 14-Oct-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.alcancia.interfaz;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel en el que se encuentran los botones para romper la Alcancía y crear una nueva
 */
public class PanelBotones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    private static final String ROMPER = "romper";

    private static final String NUEVA = "nueva";

    private static final String OPCION_1 = "opcion1";

    private static final String OPCION_2 = "opcion2";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazAlcancia ventanaPrincipal;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es el bot�n usado para romper la Alcancía
     */
    private JButton botonRomper;

    /**
     * Es el bot�n usado para crear una nueva Alcancía
     */
    private JButton botonNueva;

    /**
     * Es el bot�n para la extensi�n 1
     */
    private JButton botonOpcion1;

    /**
     * Es el bot�n para la extensi�n 2
     */
    private JButton botonOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye un nuevo panel <br>
     * <b>post: </b>Se construy� el panel y se inicializaron sus componentes
     * @param ia Es una referencia a la clase principal de la interfaz. ia != null
     */
    public PanelBotones( InterfazAlcancia ia )
    {
        ventanaPrincipal = ia;

        setLayout( new BorderLayout( ) );

        //Inicializa los componentes del panel
        JPanel panelInternoRomper = new JPanel( );
        botonRomper = new JButton( new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/martillo.jpg") ) );
        botonRomper.setActionCommand( ROMPER );
        botonRomper.setMargin( new Insets( 1, 1, 1, 1 ) );
        botonRomper.addActionListener( this );
        panelInternoRomper.add( botonRomper );
        panelInternoRomper.setBorder( new TitledBorder( "Romper Alcancía" ) );
        add( panelInternoRomper, BorderLayout.CENTER );

        JPanel panelInternoBotones = new JPanel( );

        botonNueva = new JButton( "Nueva Alcancía" );
        botonNueva.setActionCommand( NUEVA );
        botonNueva.addActionListener( this );
        panelInternoBotones.add( botonNueva );

        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        panelInternoBotones.add( botonOpcion1 );

        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        panelInternoBotones.add( botonOpcion2 );

        add( panelInternoBotones, BorderLayout.SOUTH );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Ejecuta la acci�n seg�n el bot�n sobre el que se haya hecho click
     * @param evento Es el evento de click sobre un bot�n. evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( NUEVA.equals( comando ) )
        {
            ventanaPrincipal.nuevaAlcancia( );
        }
        else if( ROMPER.equals( comando ) )
        {
            ventanaPrincipal.romperAlcancia( );
        }
        else if( OPCION_1.equals( comando ) )
        {
            ventanaPrincipal.reqFunc1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            ventanaPrincipal.reqFunc2( );
        }
    }

}