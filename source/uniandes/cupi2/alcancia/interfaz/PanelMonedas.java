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
 * Im�genes tomadas de "http://www.casamoneda.gov.co"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.alcancia.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel donde se selecciona la denominaci�n de una moneda para agregarla a la alcanc�a
 */
public class PanelMonedas extends JPanel implements ActionListener, ItemListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    private static final String AGREGAR = "agregar";

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
     * Es la opci�n para seleccionar monedas de 20
     */
    private JRadioButton radio20;

    /**
     * Es la opci�n para seleccionar monedas de 50
     */
    private JRadioButton radio50;

    /**
     * Es la opci�n para seleccionar monedas de 100
     */
    private JRadioButton radio100;

    /**
     * Es la opci�n para seleccionar monedas de 200
     */
    private JRadioButton radio200;

    /**
     * Es la opci�n para seleccionar monedas de 500
     */
    private JRadioButton radio500;

    /**
     * Es el grupo de botones que asegura que solamente se selecciona una moneda a la vez
     */
    private ButtonGroup grupoBotones;

    /**
     * Es el bot�n para agregar una moneda a la alcanc�a
     */
    private JButton botonAgregar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye un nuevo panel <br>
     * <b>post: </b>Se construy� el panel y se inicializaron sus componentes
     * @param ia Es una referencia a la clase principal de la interfaz. ia != null
     */
    public PanelMonedas( InterfazAlcancia ia )
    {
        ventanaPrincipal = ia;

        //Inicializa los componentes del panel
        grupoBotones = new ButtonGroup( );

        radio20 = new JRadioButton( "0", new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/20.jpg") ) );
        grupoBotones.add( radio20 );
        radio20.setVerticalTextPosition( SwingConstants.BOTTOM );
        radio20.setHorizontalTextPosition( SwingConstants.CENTER );
        radio20.addItemListener( this );
        radio20.setBorder( null );
        add( radio20 );

        radio50 = new JRadioButton( "0", new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/50.jpg") ) );
        grupoBotones.add( radio50 );
        radio50.setVerticalTextPosition( SwingConstants.BOTTOM );
        radio50.setHorizontalTextPosition( SwingConstants.CENTER );
        radio50.addItemListener( this );
        radio50.setBorder( null );
        add( radio50 );

        radio100 = new JRadioButton( "0", new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/100.jpg") ) );
        grupoBotones.add( radio100 );
        radio100.setVerticalTextPosition( SwingConstants.BOTTOM );
        radio100.setHorizontalTextPosition( SwingConstants.CENTER );
        radio100.addItemListener( this );
        radio100.setBorder( null );
        add( radio100 );

        radio200 = new JRadioButton( "0", new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/200.jpg") ) );
        grupoBotones.add( radio200 );
        radio200.setVerticalTextPosition( SwingConstants.BOTTOM );
        radio200.setHorizontalTextPosition( SwingConstants.CENTER );
        radio200.addItemListener( this );
        radio200.setBorder( null );
        add( radio200 );

        radio500 = new JRadioButton( "0", new ImageIcon( getClass().getResource("/uniandes/cupi2/alcancia/interfaz/data/500.jpg") ) );
        grupoBotones.add( radio500 );
        radio500.setVerticalTextPosition( SwingConstants.BOTTOM );
        radio500.setHorizontalTextPosition( SwingConstants.CENTER );
        radio500.addItemListener( this );
        radio500.setBorder( null );
        add( radio500 );

        radio20.setSelected( true );

        botonAgregar = new JButton( "Agregar Moneda" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        add( botonAgregar );

        setBorder( new TitledBorder( "Monedas" ) );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Cambia la cantidad de monedas que hay de una cierta cantidad
     * @param denominacion La denominaci�n de la moneda
     * @param cantidad La cantidad de esas monedas que hay
     */
    public void cambiarCantidad( int denominacion, int cantidad )
    {
        if( denominacion == 20 )
        {
            radio20.setText( "" + cantidad );
        }
        else if( denominacion == 50 )
        {
            radio50.setText( "" + cantidad );
        }
        else if( denominacion == 100 )
        {
            radio100.setText( "" + cantidad );
        }
        else if( denominacion == 200 )
        {
            radio200.setText( "" + cantidad );
        }
        else if( denominacion == 500 )
        {
            radio500.setText( "" + cantidad );
        }
    }

    /**
     * Se ejecuta cuando se hace click sobre un bot�n
     * @param evento Es el evento del click sobre el bot�n
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR.equals( comando ) )
        {
            int cantidad = 0;
            if( radio20.isSelected( ) )
            {
                cantidad = 20;
            }
            else if( radio50.isSelected( ) )
            {
                cantidad = 50;
            }
            else if( radio100.isSelected( ) )
            {
                cantidad = 100;
            }
            else if( radio200.isSelected( ) )
            {
                cantidad = 200;
            }
            else if( radio500.isSelected( ) )
            {
                cantidad = 500;
            }

            ventanaPrincipal.agregarMoneda( cantidad );
        }
    }

    /**
     * Este m�todo se llama cuando se selecciona alguno de los botones que indican las denominaciones. <br>
     * El m�todo se encarga de dibujar un borde alrededor de la denominaci�n seleccionada.
     * @param evento Es el evento de la selecci�n de una denominaci�n
     */
    public void itemStateChanged( ItemEvent evento )
    {
        JRadioButton boton = ( JRadioButton )evento.getItem( );

        if( evento.getStateChange( ) == ItemEvent.SELECTED )
        {
            boton.setBorder( new BevelBorder( BevelBorder.LOWERED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY ) );
            boton.setBorderPainted( true );
        }
        else
        {
            boton.setBorder( null );
        }
        validate( );
    }

}