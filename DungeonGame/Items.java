public class Items
{
    private String name;
    private boolean possess;

    public Items(String name, boolean possess)
    {
        this.name = name;
        this.possess = possess;
    }

    public String toString()
    {
        return name;
    }

    public void setName(String name){this.name = name;}
    public void setPossess(boolean possess){this.possess = possess;}

    public String getName(){return name;}
    public boolean getPossess(){return possess;}
}
