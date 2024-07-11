package pandemic;
public class Disease{
    private int id;
    private int numberOfCubes;
    private boolean remedy;

    /**
     * Create disease object
     * @param id disease ID
     * @param numberOfCubes number of cubes for the disease
     */
    public Disease(int id, int numberOfCubes){
        this.id = id;
        this.numberOfCubes = numberOfCubes;
        this.remedy = false;
    }
    /**
     * get the number of cubes the disease has
     * @return the number of cubes the disease
     */
    public int getNumberOfCubes(){
        return this.numberOfCubes;
    }

    /**
     * increase the number of cubes
     */
    public void increaseNumberOfCubes(){
        this.numberOfCubes += 1;
    }

    /**
     * decrease the number of cubes
     */
    public void decreaseNumberOfCubes(){
        if ( this.numberOfCubes > 0){
        this.numberOfCubes -= 1;}
    }

    /**
     * returns the disease's ID
     * @return disease's ID
     */
    public int getId(){
        return this.id;
    }

    /**
     * check if two objects are equal
     * @param object The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object o){
        if (!(o instanceof Disease)){
            return false;
        }

        else{
            Disease d = (Disease) o;
            return (d.id == this.id && d.numberOfCubes == this.numberOfCubes);
        }
    }

    public boolean hasRemedy(){
        return this.remedy;
    }


    public void setRemedy(){ this.remedy = true;}
    @Override
    public String toString() {
        return " disease " + this.id;
    }


    

    
}