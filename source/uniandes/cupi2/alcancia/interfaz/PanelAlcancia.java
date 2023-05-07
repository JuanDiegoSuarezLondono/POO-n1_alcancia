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
 * Imagen "alcancia.jpg" modificada a partir de 
 * "http://www.elmostrador.cl/c_economia/imagenes/chancho_rosa.jpg"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.alcancia.interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se muestra la Alcancía y se muestran los mensajes sobre su estado
 */
public class PanelAlcancia extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es la etiqueta donde se dibuja la Alcancía
     */
    private JLabel etiquetaAlcancia;

    /**
     * Es el �rea donde se muestran los mensajes sobre la Alcancía
     */
    private JTextArea txtMensaje;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye un nuevo panel <br>
     * <b>post: </b>Se construy� el panel y se inicializaron sus componentes
     */
    public PanelAlcancia( )
    {
        setLayout( new BorderLayout( ) );

        etiquetaAlcancia = new JLabel( new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/alcancia.jpg") ) );
        add( etiquetaAlcancia, BorderLayout.CENTER );

        txtMensaje = new JTextArea( 3, 40 );
        Font fuente = new Font( "Tahoma", Font.PLAIN, 12 );
        txtMensaje.setFont( fuente );
        txtMensaje.setText( "Alcancía Vacía" );
        txtMensaje.setWrapStyleWord( true );
        txtMensaje.setLineWrap( true );
        txtMensaje.setBackground( getBackground( ) );
        txtMensaje.setEditable( false );
        add( txtMensaje, BorderLayout.SOUTH );

        setBorder( new TitledBorder( "Alcancía" ) );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Cambia el mensaje mostrado <br>
     * <b>post: </b>Se cambi� el mensaje
     * @param mensaje El mensaje que se quiere mostrar. mensaje!=null
     */
    public void cambiarMensaje( String mensaje )
    {
        txtMensaje.setText( mensaje );
        validate( );
    }

    /**
     * Cambia el dibujo de la Alcancía seg�n el estado actual <br>
     * <b>post: </b>El dibujo refleja el estado actual de la Alcancía
     * @param rota Indica si actualmente la Alcancía est� rota o no
     */
    public void cambiarEstadoAlcancia( boolean rota )
    {
        if( rota )
        {
            etiquetaAlcancia.setIcon( new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/alcanciaRota.jpg") ) );
        }
        else
        {
            etiquetaAlcancia.setIcon( new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/alcancia.jpg") ) );
        }
        validate( );
    }

}