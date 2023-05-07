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
package uniandes.cupi2.alcancia.mundo;

/**
 * Es una alcanc�a a la cual se le introducen monedas y despu�s se rompe para saber su contenido
 */
public class Alcancia
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es el n�mero de monedas de 20 que se han introducido en la alcanc�a
     */
    private int numeroMonedas20;

    /**
     * Es el n�mero de monedas de 50 que se han introducido en la alcanc�a
     */
    private int numeroMonedas50;

    /**
     * Es el n�mero de monedas de 100 que se han introducido en la alcanc�a
     */
    private int numeroMonedas100;

    /**
     * Es el n�mero de monedas de 200 que se han introducido en la alcanc�a
     */
    private int numeroMonedas200;

    /**
     * Es el n�mero de monedas de 500 que se han introducido en la alcanc�a
     */
    private int numeroMonedas500;

    /**
     * Indica si la alcanc�a ya est� rota <br>
     * 0 indica que no est� rota <br>
     * 1 indica que si lo est�
     */
    private int rota;

    public void inicializar( )
    {
        numeroMonedas20 = 0;
        numeroMonedas50 = 0;
        numeroMonedas100 = 0;
        numeroMonedas200 = 0;
        numeroMonedas500 = 0;
        rota = 0;
    }

    
    public void agregarMoneda20( )
    {
        numeroMonedas20 = numeroMonedas20 + 1;
    }

    
    public void agregarMoneda50( )
    {
        numeroMonedas50 = numeroMonedas50 + 1;
    }

    
    public void agregarMoneda100( )
    {
        numeroMonedas100 = numeroMonedas100 + 1;
    }

    
    public void agregarMoneda200( )
    {
        numeroMonedas200 = numeroMonedas200 + 1;
    }

    
    public void agregarMoneda500( )
    {
        numeroMonedas500 = numeroMonedas500 + 1;
    }

    
    public void romperAlcancia( )
    {
        rota = 1;
    }

    
    public String darEstadoAlcancia( )
    {
        int totalDinero = darTotalDinero( );

        return "La alcanc�a ten�a " + numeroMonedas20 + " monedas de 20, " + numeroMonedas50 + " monedas de 50, " + numeroMonedas100 + " monedas de 100, " + numeroMonedas200 + " monedas de 200 y " + numeroMonedas500 + " monedas de 500 "
                + " que sumaban " + totalDinero + " pesos";
    }

    
    public int darTotalDinero( )
    {
        return numeroMonedas20 * 20 + numeroMonedas50 * 50 + numeroMonedas100 * 100 + numeroMonedas200 * 200 + numeroMonedas500 * 500;
    }

    
    public int darNumeroMonedas20( )
    {
        return numeroMonedas20;
    }

    
    public int darNumeroMonedas50( )
    {
        return numeroMonedas50;
    }

    
    public int darNumeroMonedas100( )
    {
        return numeroMonedas100;
    }

    
    public int darNumeroMonedas200( )
    {
        return numeroMonedas200;
    }

    
    public int darNumeroMonedas500( )
    {
        return numeroMonedas500;
    }

    
    public int estaRota( )
    {
        return rota;
    }

    
    /**
     * M�todo para la extensi�n 1
     * @return respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2
     * @return respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}