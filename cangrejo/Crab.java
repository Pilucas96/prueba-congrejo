import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Esta clase define un cangrejo. Los cangrejos viven en la playa o en el mar.
 */
public class Crab extends Animal
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    //private int GusanoComido;
    
    /**
     * Inicializamos el marcador de los puntos del cangrejo
     * Crea al cangrejo en dos imagenes que realiza la animación.
     */
    public Crab()
    {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
        GusanoComidoj = 0;
    }
    
    public void act()
{
     checkKeypress();
     move();
     lookForWorm();
     switchImage();
     Fin_del_juego(GusanoComidoj);
}

/**
     * Alterna la imagen del cangrejo entre imagen 1 e imagen 2. 
     */
    public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }
        else
        {
            setImage(image1);
        }
    }

/**
 *
 * Comprueba si se pulsa una tecla de control en el teclado. 
 * Si se pulsa, reacciona como corresponda.
 */
public void checkKeypress()
{
  if (Greenfoot.isKeyDown("left"))
   {
       turn(0);
    }
  if (Greenfoot.isKeyDown("right"))
   {
       turn(0);
    } 
  if (Greenfoot.isKeyDown("down"))
   {
       turn(270);
    }
  if (Greenfoot.isKeyDown("up"))
   {
       turn(90);
    }
}

/**
 * Comprueba si descubrimos un gusano. 
 * SI lo vemos, nos lo comemos. Si no, no hacemos nada. Si nos hemos comido ocho gusanos, ganamos.
 * 
 */
public void lookForWorm()
{
   if (canSee(Worm.class))
   { 
       eat(Worm.class);
       Greenfoot.playSound("bite.wav");
       
       GusanoComidoj= GusanoComidoj + 1;
       
       if (GusanoComidoj == 8)
      {
          Greenfoot.playSound("fanfare.wav");
          Greenfoot.stop();
    }
} 
}

}
