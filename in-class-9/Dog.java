public class Dog extends Pet
{
    private String breed;
    private boolean boosterShot;
    
    public Dog () // default constructor
    {
        super();
        breed = "None";
        boosterShot = false;
    }
    
    public Dog (String initialName, int initialAge, double initialWeight,
                String initialBreed, boolean initialBoosterShot)
    {
        super(initialName, initialAge, initialWeight);
        breed = initialBreed;
        boosterShot = initialBoosterShot;
    }
    
    public void setBreed (String newBreed)
    {
        breed = newBreed;
    }
    
    public void setBoosterShot (boolean newBoosterShot)
    {
        boosterShot = newBoosterShot;
    }
    
    public String getBreed ()
    {
        return breed;
    }
    
    public boolean getBoosterShot ()
    {
        return boosterShot;
    }
    
    @Override
    public void writeOutput ()
    {
        super.writeOutput();
        System.out.println ("Breed: " + breed);
        System.out.println ("Booster Shot: " + boosterShot);
    }
}