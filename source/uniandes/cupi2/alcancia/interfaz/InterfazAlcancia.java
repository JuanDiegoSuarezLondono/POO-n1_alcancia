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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.alcancia.mundo.Alcancia;

/**
 * Clase principal de la interfaz
 */
public class InterfazAlcancia extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es la Alcancía que se est� usando en el momento
     */
    private Alcancia alcancia;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es el panel donde se muestra el estado actual de la Alcancía
     */
    private PanelAlcancia panelAlcancia;

    /**
     * Es el panel con los botones que controlan la aplicaci�n
     */
    private PanelBotones panelBotones;

    /**
     * Es el panel donde se seleccionan y agregan las monedas
     */
    private PanelMonedas panelMonedas;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye la interfaz de la aplicaci�n y la inicializa con una Alcancía Vacía <br>
     * <b>post: </b> alcancia != null
     */
    public InterfazAlcancia( )
    {
        //Crea la Alcancía inicial
        alcancia = new Alcancia( );
        alcancia.inicializar( );

        //Crea y organiza los componentes de la interfaz
        panelAlcancia = new PanelAlcancia( );
        getContentPane( ).add( panelAlcancia, BorderLayout.CENTER );

        panelBotones = new PanelBotones( this );
        getContentPane( ).add( panelBotones, BorderLayout.EAST );

        panelMonedas = new PanelMonedas( this );
        getContentPane( ).add( panelMonedas, BorderLayout.NORTH );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Alcancía" );
        setSize( 700, 500 );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Agrega una moneda a la Alcancía siempre y cuando no est� rota <br>
     * <b>post: </b>Se agreg� la cantidad indicada a la Alcancía o se present� un mensaje de error si estaba rota
     * @param cantidad cantidad que se va a agregar a la Alcancía
     */
    public void agregarMoneda( int cantidad )
    {
        if( alcancia.estaRota( ) == 0 )
        {
            if( cantidad == 20 )
            {
                alcancia.agregarMoneda20( );
                panelMonedas.cambiarCantidad( 20, alcancia.darNumeroMonedas20( ) );
            }
            else if( cantidad == 50 )
            {
                alcancia.agregarMoneda50( );
                panelMonedas.cambiarCantidad( 50, alcancia.darNumeroMonedas50( ) );
            }
            else if( cantidad == 100 )
            {
                alcancia.agregarMoneda100( );
                panelMonedas.cambiarCantidad( 100, alcancia.darNumeroMonedas100( ) );
            }
            else if( cantidad == 200 )
            {
                alcancia.agregarMoneda200( );
                panelMonedas.cambiarCantidad( 200, alcancia.darNumeroMonedas200( ) );
            }
            else if( cantidad == 500 )
            {
                alcancia.agregarMoneda500( );
                panelMonedas.cambiarCantidad( 500, alcancia.darNumeroMonedas500( ) );
            }

            panelAlcancia.cambiarMensaje( "Se agregaron " + cantidad + " pesos a la Alcancía.\nEn la Alcancía hay " + alcancia.darTotalDinero( ) + " pesos" );
        }
        else
            JOptionPane.showMessageDialog( this, "No se puede agregar monedas a una Alcancía rota", "Error", JOptionPane.ERROR_MESSAGE );
    }

    /**
     * Crea una nueva Alcancía <br>
     * <b>post: </b>La Alcancía es nueva y est� Vacía
     */
    public void nuevaAlcancia( )
    {
        alcancia = new Alcancia( );
        alcancia.inicializar( );

        panelAlcancia.cambiarEstadoAlcancia( false );
        panelAlcancia.cambiarMensaje( "Alcancía Vacía" );

        panelMonedas.cambiarCantidad( 20, alcancia.darNumeroMonedas20( ) );
        panelMonedas.cambiarCantidad( 50, alcancia.darNumeroMonedas50( ) );
        panelMonedas.cambiarCantidad( 100, alcancia.darNumeroMonedas100( ) );
        panelMonedas.cambiarCantidad( 200, alcancia.darNumeroMonedas200( ) );
        panelMonedas.cambiarCantidad( 500, alcancia.darNumeroMonedas500( ) );
    }

    /**
     * Rompe la Alcancía y actualiza la informaci�n mostrada <br>
     * <b>post: </b>La Alcancía est� rota y se mostr� su contenido
     */
    public void romperAlcancia( )
    {
        String mensaje = alcancia.darEstadoAlcancia( );
        alcancia.romperAlcancia( );

        panelAlcancia.cambiarEstadoAlcancia( true );
        panelAlcancia.cambiarMensaje( mensaje );
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1
     */
    public void reqFunc1( )
    {
        String resultado = alcancia.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensi�n 2
     */
    public void reqFunc2( )
    {
        String resultado = alcancia.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Ejecuci�n
    //-----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n
     * @param args par�metros de la ejecuci�n
     */
    public static void main( String[] args )
    {
        InterfazAlcancia ia = new InterfazAlcancia( );
        ia.setVisible( true );
    }
}